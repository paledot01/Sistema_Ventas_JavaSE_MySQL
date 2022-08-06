package Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entidad.Boleta_Cabecera;
import entidad.Boleta_Cabecera_Reporte;
import entidad.Boleta_Detalle;
import entidad.Boleta_Detalle_Reporte;
import entidad.Cliente;
import entidad.Empleado;
import entidad.EmpleadoReporte;
import interfaces.VentaInterfaceDao;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import utils.ConnectionMySQL_8;

public class VentaGestionDao implements VentaInterfaceDao{

	
	private Connection cn;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	
	private ArrayList<Boleta_Detalle> lista;
	
	ClienteGestionDao gCliente = new ClienteGestionDao(); // --
	
	// Sentencias
	final String LASTCODE = "{call pa_buscar_ultimo_codigo_boleta()}";
	final String INSERTCLIENTE = "{call pa_insertar_cliente(?,?,?,?,?,?,?,?)}"; 
	final String INSERTCABECERA = "{call pa_insertar_boleta(?,?,?)}"; // parametros (codigo_boleta . XfechaX , XhoraX, cod_cliente , cod_empleado ) --> no necesita la fecha ni hora
	final String INSERTDETALLE = "{call pa_insertar_detalle_boleta(?,?,?,?)}";
	final String UPDATESTOCK = "{call pa_reducir_stock_calzado(?,?)}"; // parametros (codigo_calzado , cantidad)
	
	// Sentencias para generar la boleta
	final String SEARCH_CABECERA_BOLETA = "{call pa_buscar_cabeza_boleta(?)}";
	final String SEARCH_DETALLE_BOLETA = "{call pa_buscar_detalle_boleta(?)}";
	
	

	@Override
	public String generarCodigo() {
		
		String codEmpleado = "BL10001";

		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(LASTCODE);
			rs = cs.executeQuery();
			
			if(rs.next()){
				DecimalFormat df = new DecimalFormat("00000");
				codEmpleado = "BL" + df.format(Integer.parseInt(rs.getString(1)) + 1); // example -> 003 + 1 = 004
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia generarCodigo --> VENTA" + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return codEmpleado;

	}

	@Override
	public int realizarVenta(Cliente c, Boleta_Cabecera cabBoleta, ArrayList<Boleta_Detalle> detBoleta) {

		int respuesta = -1;
		
		try {
			cn = ConnectionMySQL_8.getConnection();
			cn.setAutoCommit(false);
			
			/** PRIMERA INSTUCCION --> Registro del Cliente si este no existe en la BD 
			 *  si el cliente ya existe no se puede tomar ' c ' para la transaccion porque este cliente tiene 
			 *  un codigo nuevo. pero aunque el cliente ' c ' no exista para evitar añadir mucho codigo, 
			 *  se registra el cliente ' c ' pero luego se transfiere este cliente al otro cliente**/
			
			Cliente cliente = gCliente.buscarPorDniExacto(c.getDni());
			if(cliente == null){ // si no lo encuentra lo registra.
				cs = cn.prepareCall(INSERTCLIENTE);
				int i = 1;
				cs.setString(i++, c.getCod_cliente());
				cs.setString(i++, c.getNombre());
				cs.setString(i++, c.getApellidos());
				cs.setString(i++, c.getDni());
				cs.setString(i++, c.getDireccion());
				cs.setString(i++, c.getTelefono());
				cs.setString(i++, c.getEmail());
				cs.setString(i++, c.getCod_distrito());
				
				respuesta = cs.executeUpdate();
				
				cliente= c;
			}

			/** Segunda Instruccion -->  Registro del Encabezado Boleta **/
			cs = cn.prepareCall(INSERTCABECERA);
			int j = 1;
			cs.setString(j++, cabBoleta.getCod_boleta());
			cs.setString(j++, cliente.getCod_cliente());
			cs.setString(j++, cabBoleta.getCod_empleado());

			respuesta = cs.executeUpdate();
			
			/** Tercera Instruccion --> añade todos los calzados a la boleta**/
			for(Boleta_Detalle d : detBoleta){
				cs = cn.prepareCall(INSERTDETALLE);
				cs.setString(1, cabBoleta.getCod_boleta());
				cs.setString(2, d.getCod_calzado());
				cs.setInt(3, d.getCantidad());
				cs.setDouble(4, d.getImporte());
			
				respuesta = cs.executeUpdate();
			}
			
			/** Cuarta Instruccion --> Actualizacion del stock de los calzados**/
			for(Boleta_Detalle d : detBoleta){
				cs = cn.prepareCall(UPDATESTOCK);
				cs.setString(1, d.getCod_calzado());
				cs.setInt(2, d.getCantidad());
				
				respuesta = cs.executeUpdate();
			}
			
			cn.commit(); // <-- confirma la transaccion
			
		} catch (Exception e) {
			System.out.println("Error al realizar la venta --> " + e.getMessage());
			respuesta = -1;
			try {
				cn.rollback();   // <---
			} catch (Exception e2) {
				System.out.println("Error al Restaurar tablas --> " + e2.getMessage());
			}
		} finally {
			try {
				if(cn != null)
					cn.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar base de datos --> " + e.getMessage() );
			}
		}
		
		return respuesta;
	}
	
	
	
	
	@Override
	public Boleta_Cabecera_Reporte buscarCabezaBoleta(String valor) {
		
		Boleta_Cabecera_Reporte obj = null;
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCH_CABECERA_BOLETA);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			if(rs.next()){
				
				int i=1;
				obj = new Boleta_Cabecera_Reporte(
						rs.getString(i++), // posicion 1
						rs.getTimestamp(i++), // posicion 2
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getDouble(i++)
				);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarCabezaBoleta() - VENTA --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarCabezaBoleta() - VENTA --> " + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return obj;
	}

	
	@Override
	public ArrayList<Boleta_Detalle_Reporte> buscarDetalleBoleta(String valor) {
		
		ArrayList<Boleta_Detalle_Reporte> lista = new ArrayList<Boleta_Detalle_Reporte>();
		Boleta_Detalle_Reporte obj;
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCH_DETALLE_BOLETA);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Boleta_Detalle_Reporte(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 1
						rs.getInt(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getDouble(i++),
						rs.getDouble(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarDetalleBoleta() - VENTA --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarDetalleBoleta() - VENTA --> " + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return lista;
	}
	
	

	@Override
	public int generarBoleta(Boleta_Cabecera_Reporte cabeza, ArrayList<Boleta_Detalle_Reporte> calzados, int tipoComprobante) {
		int respuesta = -1;
		/** existe otra manera, traer el .jrxml , pasarlo a un FileInputStream y resien compilarlo, aca usamos defrente la compilacion ".jasper"  **/
		
		try {
			JasperReport report;
			String comprobante_logo;
			// 0 -> a4
			// 1 -> ticket
			if(tipoComprobante == 1){
				 report = (JasperReport)JRLoader.loadObject( getClass().getResource("/report_template/Comprobante_Ticket.jasper") ) ;
				 comprobante_logo = "logo_black_letter_200x.png";
			}else{
				report = (JasperReport)JRLoader.loadObject( getClass().getResource("/report_template/Comprobante.jasper") ) ;
				comprobante_logo = "logo_reporte.png";
			}
			
			Map<String, Object> parametros = new HashMap<String, Object>();
//			JRBeanCollectionDataSource lista = new JRBeanCollectionDataSource(calzados);
//			parametros.put("DATAEmpleado", lista); // El BeanCollection obtiene los datos de una Collection.
			
			
//			String comprobante_logo = "logo_reporte.png";
			String comprobante_imagen_qr = "imagen_qr_reporte.png";
			
			parametros.put("comprobante_logo","\\img\\" + comprobante_logo);
			parametros.put("comprobante_imagen_qr","\\img\\" + comprobante_imagen_qr);
			parametros.put("nombre_empresa","SHOES FOR MEN");
			parametros.put("direccion_empresa","AV. URUGUAY N 389 ");
			parametros.put("distrito_empresa","SAN ISIDRO");
			parametros.put("telefono_empresa","942184912");
			parametros.put("web_empresa", "www.shoesformen.com.pe");
			parametros.put("ruc_empresa","12345678901");
			
			
			parametros.put("codigo_boleta", cabeza.getCodigo_boleta());
			parametros.put("nombre_cliente", cabeza.getNombre_cliente());
			parametros.put("direccion_cliente", cabeza.getDireccion_cliente());
			parametros.put("distrito_cliente", cabeza.getDistrito_cliente());
			parametros.put("dni_cliente", cabeza.getDni_cliente());
			parametros.put("telefono_cliente", cabeza.getTelefono_cliente());
			parametros.put("fecha_hora_emision", cabeza.getFecha_hora_emision());
			parametros.put("nombre_vendedor", cabeza.getNombre_vendedor());
			parametros.put("total_venta", cabeza.getTotal_venta());
			
			
			JasperPrint jprint = JasperFillManager.fillReport(report, parametros, new JRBeanCollectionDataSource(calzados)); // llenamos los datos, como todo lo llenamos por parametros, le mandamos como data source vacio
			JasperViewer vista = new JasperViewer(jprint, false); // false -> para que al cerrar no se cierre el Viewer no se cierre la aplicacion.
			vista.setVisible(true);
			vista.setTitle("Boleta Electronica");
				 
			respuesta = 1;
//			Desktop.getDesktop().open(archivo);
				
		}catch (JRException e) {
			System.out.println(e);
		}catch (Exception e){
			System.out.println(e);
		}
		
		return respuesta;
		
	}



	
	
}

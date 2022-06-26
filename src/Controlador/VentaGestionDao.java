package Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import entidad.Boleta_Cabecera;
import entidad.Boleta_Detalle;
import entidad.Cliente;
import interfaces.VentaInterfaceDao;
import utils.ConnectionMySQL_8;

public class VentaGestionDao implements VentaInterfaceDao{

	
	private Connection cn;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	
	private ArrayList<Boleta_Detalle> lista;
	
//	ClienteGestionDao gCliente = new ClienteGestionDao();
	
	
	
	// Sentencias
	
	final String LASTCODE = "{call pa_buscar_ultimo_codigo_boleta()}";
	final String INSERTCLIENTE = "{call pa_insertar_cliente(?,?,?,?,?,?,?,?)}"; 
	final String INSERTCABECERA = "{call pa_insertar_boleta(?,?,?)}"; // parametros (codigo_boleta . XfechaX , cod_cliente , cod_empleado ) --> no necesita la fecha
	final String INSERTDETALLE = "{call pa_insertar_detalle_boleta(?,?,?,?)}";
	final String UPDATESTOCK = "{call pa_reducir_stock_calzado(?,?)}"; // parametros (codigo_calzado , cantidad)
	
	
	
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
			
			/** Primera Instruccion --> Registro del Cliente **/
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
			
			/** Segunda Instruccion -->  Registro del Encabezado Boleta **/
			cs = cn.prepareCall(INSERTCABECERA);
			int j = 1;
			cs.setString(j++, cabBoleta.getCod_boleta());
			cs.setString(j++, c.getCod_cliente());
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
			
		} catch (Exception e) {
			System.out.println("Error al realizar la venta" + e.getMessage());
			respuesta = -1;
			try {
				cn.rollback();   // <---
			} catch (Exception e2) {
				System.out.println("Error al Restaurar tablas" + e2.getMessage());
			}
		} finally {
			try {
				if(cn != null)
					cn.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar base de datos " + e.getMessage() );
			}
		}
		
		return respuesta;
	}

	
	
}

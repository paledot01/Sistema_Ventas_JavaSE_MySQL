package Controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entidad.Empleado;
import interfaces.EmpleadoInterfaceDao;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import utils.ConnectionMySQL_8;

public class EmpleadoGestionDao implements EmpleadoInterfaceDao{

	
	private Connection cn;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	private ArrayList<Empleado> lista;
	private Empleado obj;
	
	// Sentencias
	
	final String VALIDATE = "{call pa_validar_empleado(?,?)}";
	final String GETALL = "{call pa_listar_empleado()}";
	final String LASTCODE = "{call pa_buscar_ultimo_codigo_empleado()}";
	final String INSERT = "{call pa_insertar_empleado(?,?,?,?,?,?,?,?,?,?,?,?)}";
	final String UPDATE = "{call pa_actualizar_empleado(?,?,?,?,?,?,?,?,?,?,?,?)}";
	//final String DELETE = "{call pa_eliminar_empleado(?)}";
	
	final String SEARCHCODE = "{call pa_buscar_empleado_por_codigo(?)}";
	final String SEARCHNAME = "{call pa_buscar_empleado_por_nombre_apellido(?)}";
	final String SEARCHDNI = "{call pa_buscar_empleado_por_dni(?)}";
	final String SEARCHDISTRITO = "{call pa_buscar_empleado_por_distrito(?)}";
	

	
	
	
	@Override
	public Empleado validarAcceso(String user, String pass) {
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(VALIDATE);
			cs.setString(1, user);
			cs.setString(2, pass);
			
			rs = cs.executeQuery();
			
			if(rs.next()){
				
				int i=1;
				obj = new Empleado(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getInt(i++)
				);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia ValidarAccesoEmpleado" + e.getMessage());
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
	public ArrayList<Empleado> listar() {
		
		lista = new ArrayList<Empleado>();
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(GETALL);
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Empleado(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getInt(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia listarEmpelado" + e.getMessage());
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
	public int registrar(Empleado e) {
		
		int respuesta = -1;
		try {
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(INSERT);
			
			int i = 1;
			cs.setString(i++, e.getCod_empleado());
			cs.setString(i++, e.getNombre());
			cs.setString(i++, e.getApellidos());
			cs.setString(i++, e.getDni());
			cs.setString(i++, e.getDireccion());
			cs.setString(i++, e.getTelefono());
			cs.setString(i++, e.getEmail());
			cs.setString(i++, e.getCod_distrito());
			cs.setString(i++, e.getCod_cargo());
			cs.setString(i++, e.getUsuario());
			cs.setString(i++, e.getContraseña());
			cs.setInt(i++, e.getEstado());
			
			respuesta = cs.executeUpdate();
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia registrarEmpleado" + e1.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return respuesta;
	}

	
	
	@Override
	public String generarCodigo() {
		
		String codEmpleado = "EM001";
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(LASTCODE);
			rs = cs.executeQuery();
			
			if(rs.next()){
				DecimalFormat df = new DecimalFormat("000");
				codEmpleado = "EM" + df.format(Integer.parseInt(rs.getString(1)) + 1); // example -> 003 + 1 = 004
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia generarCodigoEmpleado" + e.getMessage());
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
	public int actualizar(Empleado e) {

		int respuesta = -1;
		try {
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(UPDATE);
			
			int i = 1;
			cs.setString(i++, e.getCod_empleado());
			cs.setString(i++, e.getNombre());
			cs.setString(i++, e.getApellidos());
			cs.setString(i++, e.getDni());
			cs.setString(i++, e.getDireccion());
			cs.setString(i++, e.getTelefono());
			cs.setString(i++, e.getEmail());
			cs.setString(i++, e.getCod_distrito());
			cs.setString(i++, e.getCod_cargo());
			cs.setString(i++, e.getUsuario());
			cs.setString(i++, e.getContraseña());
			cs.setInt(i++, e.getEstado());
			
			respuesta = cs.executeUpdate();
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia actualizarEmpleado" + e1.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return respuesta;
		
	}


	
//	@Override
//	public int eliminarEmpleado(String codigo) {
//	
//		int respuesta = -1;
//		try {
//			cn = ConnectionMySQL_8.getConnection();
//			cs = cn.prepareCall(DELETE);
//			cs.setString(1, codigo);
//			
//			respuesta = cs.executeUpdate();
//			
//		}catch (SQLException e1) {
//			System.out.println("Error en la sentencia actualizarEmpleado" + e1.getMessage());
//		}finally {
//			try {
//				if( rs != null ) rs.close();
//				if( cs != null ) cs.close();
//				if( cn != null ) cn.close();
//			} catch (SQLException e2) {
//				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
//			}
//		}
//		return respuesta;
//	
//	}
	
	
	@Override
	public Empleado buscarPorCodigo(String codigo) {

		obj = null;
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCHCODE);
			cs.setString(1, codigo);
			
			rs = cs.executeQuery();
			
			if(rs.next()){
				
				int i=1;
				obj = new Empleado(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getInt(i++)
				);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarEmpleadoXCodigo" + e.getMessage());
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
	public ArrayList<Empleado> buscarPorNombre(String valor) {
		
		lista = new ArrayList<Empleado>();
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCHNAME);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Empleado(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getInt(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarEmpleadoXNombre" + e.getMessage());
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
	public ArrayList<Empleado> buscarPorDni(String valor) {
		
		lista = new ArrayList<Empleado>();
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCHDNI);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Empleado(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getInt(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorDni" + e.getMessage());
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



	/**
	 * La busqueda por distrito devuelve 2 tablas juntas, pero este metodo devuelve solo 
	 * un empleado, extrayendo solo los primeros valores.
	 * **/
	@Override
	public ArrayList<Empleado> buscarPorDistrito(String valor) {

		lista = new ArrayList<Empleado>();
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCHDISTRITO);
			cs.setString(1, valor);

			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Empleado(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getInt(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorDistrito" + e.getMessage());
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
	public int exportarTXT(ArrayList<Empleado> empleados) {
		
		int respuesta = -1;
		
		File archivo;
		FileInputStream archivoEntrada = null;
		FileOutputStream archivoSalida = null;
		
		
		JFileChooser ventSeleccion = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", "txt");
		ventSeleccion.setFileFilter(filtro);
		ventSeleccion.setDialogTitle("Guardar Archivo");
        ventSeleccion.setAcceptAllFileFilterUsed(true); // true: muestra el tambien filtro de todos los tipos de archivos, false : muestra solo el filtro seleccionado
		
		
		/** showDialog(componentePadre, nombreBotonAprobado) -- devuelve un numero que representa la eleccion del usuario.*/
		if(ventSeleccion.showDialog(null, "Guardar") == ventSeleccion.APPROVE_OPTION){
			
			// toString(), transforma el archivo seleccionado en un cadena de la ruta del archivo, añadiendole el formarto.
			String ruta = ventSeleccion.getSelectedFile().toString().concat(".txt"); 
			archivo = new File(ruta); //archivo = ventSeleccion.getSelectedFile();
			
			String linea = "";
			String data = linea;
			
			for(Empleado emp: empleados ){
			
				linea = emp.getCod_empleado() + "|" +
						emp.getNombre() + "|" +
						emp.getApellidos() + "|" +
						emp.getDni() + "|" +
						emp.getDireccion() + "|" +
						emp.getTelefono() + "|" +
						emp.getEmail() + "|" +
						emp.getCod_distrito() + "|" +
						emp.getCod_cargo() + "|" +
						emp.getUsuario() + "|" +
						emp.getContraseña() + "|" +
						emp.getEstado() + "\n";
				
				data += linea;
//				data.concat(linea); ESTA LINEA NO FUNCIONA NO SE ¿PORQUE?
			}
			
			byte[] dataByte = data.getBytes();
			
			
			try {
				archivoSalida = new FileOutputStream(archivo); //<<<
					try {
						archivoSalida.write(dataByte); // <<<<
						respuesta = 1;
					} catch (IOException e) {
						System.out.println("Error al escribir los datos" + e.getMessage());
					}
					
			}catch (FileNotFoundException e) {
				System.out.println("Error al crear el archivo de salida" + e.getMessage());
			}catch (Exception e){
				System.out.println(e);
			}finally {
				try {
					archivoSalida.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
				
		}
		return respuesta;
		
	}



	@Override
	public int exportarXLSX(ArrayList<Empleado> empleados) {
		
		int respuesta = -1;
		
		try {
			
			JFileChooser seleccionador = new JFileChooser();
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Excel", "xlsx");
			seleccionador.setFileFilter(filtro);
			seleccionador.setDialogTitle("Guardar Archivo");
			seleccionador.setAcceptAllFileFilterUsed(true); // añade la opcion de mostrar todos los archivos
			
			if( seleccionador.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION ) {
				String ruta = seleccionador.getSelectedFile().toString().concat(".xlsx");
				File archivoSave = new File(ruta);
				
				Workbook book = new XSSFWorkbook();  // XSSFWoorkbook >> crea archivos ".xlsx", Workbook es la coleccion de hojas de calculo.
				Sheet hoja = book.createSheet("Hoja_1");  // Crea una hoja en excel
				hoja.setDisplayGridlines(true);  // Oculta las lineas de la hoja de Excel (son gustos)
				
				// Encabezado
				String [] encabezado = {"CODIGO","NOMBRE","APELLIDOS","DNI","DIRECCION","TELEFONO","EMAIL","DISTRITO","CARGO","USUARIO","CONTRASEÑA","ESTADO"};
				
				Row filaInicial = hoja.createRow(0);
				for( int i = 0; i < encabezado.length; i++ ){
					Cell celda = filaInicial.createCell(i);
					celda.setCellValue(encabezado[i].toString());
				}
				
				// Cuerpo
				for( int j = 0; j < empleados.size(); j++ ){
					Row fila = hoja.createRow(j+1);  // Se crea apartir de la segunda fila
					
					for (int i = 0; i < 12; i++) { // i < numero de columnas 
						Cell celda = fila.createCell(i);
						
						if(i == 11){ // convierte las columnas a entero antes de mandar el dato a la celda
							celda.setCellValue( Integer.parseInt(empleados.get(j).atributoObjeto(i)));
						}else{ // por default manda los datos como "cadena"
							celda.setCellValue( empleados.get(j).atributoObjeto(i) );
						}
						
					}
				}
				
				FileOutputStream archivoSalida = new FileOutputStream(archivoSave);
				book.write(archivoSalida);
				book.close();
				archivoSalida.close();
				 
				respuesta = 1;
//				Desktop.getDesktop().open(archivo);
			}
			
		}catch (FileNotFoundException e) {
			System.out.println("Error en la sentencia exportarXLSX() --> " + e.getMessage());
		}catch (IOException e) {
			System.out.println("Error en la sentencia exportarXLSX() --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia exportarXLSX() --> " + e.getMessage());
		}
		
		return respuesta;
		
	}



	@Override
	public int exportarPDF(ArrayList<Empleado> empleados) {
		
		int respuesta = -1;
		/** existe otra manera, traer el .jrxml , pasarlo a un FileInputStream y resien compilarlo, aca usamos defrente la compilacion ".jasper"  **/
		
		try {
			
			JasperReport report = (JasperReport)JRLoader.loadObject( getClass().getResource("/report_template/reporte_empleado.jasper") ) ;
			
			Map<String, Object> parametros = new HashMap<String, Object>();
			JRBeanCollectionDataSource lista = new JRBeanCollectionDataSource(empleados);
			parametros.put("DATAEmpleado", lista); // El BeanCollection obtiene los datos de una Collection.
			
			String imagen = "logo_reporte.png"; // añadimos la imagen por su nombre completo
			parametros.put("imagen_logo","\\img\\" + imagen); // por alguna razon marca error cuando se coloca de la siguiente forma: "/img/cc.jpg"
			parametros.put("nombre_empresa","SHOES FOR MEN");
			parametros.put("direccion_empresa","AV. URUGUAY N 389 ");
			parametros.put("distrito_empresa","SAN ISIDRO");
			parametros.put("nombre_empleado","KEVIN BASILIO");
			parametros.put("ruc_empresa","12345678901");
			
			JasperPrint jprint = JasperFillManager.fillReport(report, parametros, new JREmptyDataSource()); // llenamos los datos, como todo lo llenamos por parametros, le mandamos como data source vacio
			JasperViewer vista = new JasperViewer(jprint, false); // false -> para que al cerrar no se cierre el Viewer no se cierre la aplicacion.
			vista.setVisible(true);
			vista.setTitle("Reporte Empleados");
				 
			respuesta = 1;
//			Desktop.getDesktop().open(archivo);
				
		}catch (JRException e) {
			System.out.println(e);
		}catch (Exception e){
			System.out.println(e);
		}
		
		return respuesta;
		
		/** Para poder filtrar la prioridad de los formatos permitidos en el JasperViewer(osea que aparesca solo o primero el ".pdf"),
		 *  se requiere de la clase JRViewer importado de "net.sf.jasperreports.view" la cual aparecio por ultima ves en el 
		 *  jasperreport.6.4.0.jar del 2016 y ahora esta DEPRECATE. En la unica posible solucion estaban usan la Api pooq/poor, que permite cambiar las 
		 *  expresiones del lenguaje java por uno mas "expresivo". No logre entender lo suficiente como para pasarlo al Java normal **/
	}


}










//a
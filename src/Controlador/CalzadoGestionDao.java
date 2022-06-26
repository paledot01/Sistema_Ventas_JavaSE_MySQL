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

import entidad.Calzado;
import entidad.CalzadoReporte;
import entidad.CalzadoReporteMini;
import interfaces.CalzadoInterfaceDao;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import utils.ConnectionMySQL_8;

public class CalzadoGestionDao implements CalzadoInterfaceDao{

	private Connection cn;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	
	private ArrayList<Calzado> listaOriginal;
	private ArrayList<CalzadoReporte> listaReporte;
	private ArrayList<CalzadoReporteMini> listaReporteMini;
	
	private Calzado obj;
	private CalzadoReporte objR;
	private CalzadoReporteMini objRM;
	
	
	// Sentencias
	final String GETALL = "{call pa_listar_calzado()}";
	final String GETALLMINI = "{call pa_listar_calzado_mini()}";
	final String LASTCODE = "{call pa_buscar_ultimo_codigo_calzado()}";
	final String INSERT = "{call pa_insertar_calzado(?,?,?,?,?)}";
	final String UPDATE = "{call pa_actualizar_calzado(?,?,?,?,?)}";
	
	final String SEARCH_CODE_SIMPLE = "{call pa_buscar_calzado_solo_por_codigo(?)}";
	final String SEARCH_CODE = "{call pa_buscar_calzado_por_codigo(?)}";
	final String SEARCH_MODEL = "{call pa_buscar_calzado_por_modelo(?)}";
	final String SEARCH_CATEGORY = "{call pa_buscar_calzado_por_categoria(?)}";
	final String SEARCH_BRAND = "{call pa_buscar_calzado_por_marca(?)}";
	final String SEARCH_TALLA = "{call pa_buscar_calzado_por_talla(?)}";
	final String SEARCH_COLOR = "{call pa_buscar_calzado_por_color(?)}";
	
	
	@Override
	public ArrayList<CalzadoReporte> listar() {
		
		listaReporte = new ArrayList<CalzadoReporte>();
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(GETALL);
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				objR = new CalzadoReporte(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getInt(i++),
						rs.getString(i++),
						rs.getDouble(i++),
						rs.getDouble(i++),
						rs.getInt(i++)
				);
				listaReporte.add(objR);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia listar() - CALZADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia listar() - CALZADO --> " + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return listaReporte;
		
	}

	
	

	public ArrayList<CalzadoReporteMini> listarMini() {
		
		listaReporteMini = new ArrayList<CalzadoReporteMini>();
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(GETALLMINI);
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				objRM = new CalzadoReporteMini(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getInt(i++), // ...
						rs.getString(i++),
						rs.getInt(i++)
				);
				listaReporteMini.add(objRM);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia listarMini() - CALZADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia listarMini() - CALZADO --> " + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return listaReporteMini;
		
	}


	
	
	@Override
	public String generarCodigo() {
		
		String codCalzado = "CZ10001";
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(LASTCODE);
			rs = cs.executeQuery();
			
			if(rs.next()){
				DecimalFormat df = new DecimalFormat("00000");
				codCalzado = "CZ" + df.format(Integer.parseInt(rs.getString(1)) + 1); // example -> 003 + 1 = 004
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia generarCodigo() - CALZADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia generarCodigo() - CALZADO --> " + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return codCalzado;
		
	}





	@Override
	public int registrar(Calzado c) {
		
		int respuesta = -1;
		try {
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(INSERT);
			
			int i = 1;
			cs.setString(i++, c.getCod_calzado());
			cs.setString(i++, c.getCod_modelo());
			cs.setInt(i++, c.getTalla());
			cs.setString(i++, c.getColor());
			cs.setInt(i++, c.getStock());
			
			respuesta = cs.executeUpdate();
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia registrar() - CALZADO --> " + e1.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia registrar() - CALZADO --> " + e.getMessage());
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
	public int actualizar(Calzado c) {
		
		int respuesta = -1;
		try {
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(UPDATE);
			
			int i = 1;
			cs.setString(i++, c.getCod_calzado());
			cs.setString(i++, c.getCod_modelo());
			cs.setInt(i++, c.getTalla());
			cs.setString(i++, c.getColor());
			cs.setInt(i++, c.getStock());
			
			respuesta = cs.executeUpdate();
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia actualizar() - CALZADO --> " + e1.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia actualizar() - CALZADO --> " + e.getMessage());
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
	public ArrayList<Calzado> buscarPorCodigoSimple(String valor) {
		
		listaOriginal = new ArrayList<Calzado>();
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCH_CODE_SIMPLE);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Calzado(
						rs.getString(i++), 
						rs.getString(i++), 
						rs.getInt(i++),
						rs.getString(i++),
						rs.getInt(i++)
				);
				listaOriginal.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorCodigoSimple() - CALZADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarPorCodigoSimple() - CALZADO --> " + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return listaOriginal;
		
	}
	
	
	
	


	@Override
	public ArrayList<CalzadoReporte> buscarPorCodigo(String valor) {
		
		listaReporte = new ArrayList<CalzadoReporte>();
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCH_CODE);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				objR = new CalzadoReporte(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getInt(i++),
						rs.getString(i++),
						rs.getDouble(i++),
						rs.getDouble(i++),
						rs.getInt(i++)
				);
				listaReporte.add(objR);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorCodigo() - CALZADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarPorCodigo() - CALZADO --> " + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return listaReporte;
		
	}


	


	@Override
	public ArrayList<CalzadoReporte> buscarPorModelo(String valor) {
		
		listaReporte = new ArrayList<CalzadoReporte>();
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCH_MODEL);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				objR = new CalzadoReporte(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getInt(i++),
						rs.getString(i++),
						rs.getDouble(i++),
						rs.getDouble(i++),
						rs.getInt(i++)
				);
				listaReporte.add(objR);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorModelo() - CALZADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarPorModelo() - CALZADO --> " + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return listaReporte;
		
	}





	@Override
	public ArrayList<CalzadoReporte> buscarPorCategoria(String valor) {
		
		listaReporte = new ArrayList<CalzadoReporte>();
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCH_CATEGORY);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				objR = new CalzadoReporte(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getInt(i++),
						rs.getString(i++),
						rs.getDouble(i++),
						rs.getDouble(i++),
						rs.getInt(i++)
				);
				listaReporte.add(objR);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorCategoria() - CALZADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarPorCategoria() - CALZADO --> " + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return listaReporte;
		
	}





	@Override
	public ArrayList<CalzadoReporte> buscarPorMarca(String valor) {
		
		listaReporte = new ArrayList<CalzadoReporte>();
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCH_BRAND);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				objR = new CalzadoReporte(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getInt(i++),
						rs.getString(i++),
						rs.getDouble(i++),
						rs.getDouble(i++),
						rs.getInt(i++)
				);
				listaReporte.add(objR);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorMarca() - CALZADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarPorMarca() - CALZADO --> " + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return listaReporte;
		
	}





	@Override
	public ArrayList<CalzadoReporte> buscarPorTalla(int valor) {
		
		listaReporte = new ArrayList<CalzadoReporte>();
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCH_TALLA);
			cs.setInt(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				objR = new CalzadoReporte(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getInt(i++),
						rs.getString(i++),
						rs.getDouble(i++),
						rs.getDouble(i++),
						rs.getInt(i++)
				);
				listaReporte.add(objR);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorTalla() - CALZADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarPorTalla() - CALZADO --> " + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return listaReporte;
		
	}





	@Override
	public ArrayList<CalzadoReporte> buscarPorColor(String valor) {

		listaReporte = new ArrayList<CalzadoReporte>();
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCH_COLOR);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				objR = new CalzadoReporte(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getInt(i++),
						rs.getString(i++),
						rs.getDouble(i++),
						rs.getDouble(i++),
						rs.getInt(i++)
				);
				listaReporte.add(objR);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorColor() - CALZADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarPorColor() - CALZADO --> " + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return listaReporte;
		
	}





	@Override
	public int exportarTXT(ArrayList<CalzadoReporte> calzados) {

		int respuesta = -1;
		
		try {
			
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
				
				for(CalzadoReporte cr: calzados ){
				
					linea = cr.getCod_calzado() + "|" + 
							cr.getNombre_modelo() + "|" +
							cr.getNombre_marca() + "|" +
							cr.getDescripcion_categoria() + "|" +
							cr.getTalla() + "|" +
							cr.getColor() + "|" +
							cr.getPrecio_compra() + "|" +
							cr.getPrecio_venta() + "|" +
							cr.getStock() + "\n";
					
					data += linea;
//					data.concat(linea); ESTA LINEA NO FUNCIONA NO SE ¿PORQUE?
				}
				
				byte[] dataByte = data.getBytes();
				
				
				archivoSalida = new FileOutputStream(archivo); //<<<
				archivoSalida.write(dataByte); // <<<<
				archivoSalida.close();
				respuesta = 1;
			}
			
		}catch (FileNotFoundException e) {
			System.out.println("Error en la sentencia exportarTXT() --> " + e.getMessage());
		}catch (IOException e) {
			System.out.println("Error en la sentencia exportarTXT() --> " + e.getMessage());
		}catch (Exception e) {
			System.out.println("Error en la sentencia exportarTXT() --> " + e.getMessage());
		}
		
		return respuesta;
		
	}
	






	@Override
	public int exportarXLSX(ArrayList<CalzadoReporte> calzados) {

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
				String [] encabezado = {"CODIGO","MODELO","MARCA","CATEGORIA","TALLA","COLOR","P.COMPRA","P.VENTA","STOCK"};
				
				Row filaInicial = hoja.createRow(0);
				for( int i = 0; i < encabezado.length; i++ ){
					Cell celda = filaInicial.createCell(i);
					celda.setCellValue(encabezado[i].toString());
				}
				
				// Cuerpo
				for( int j = 0; j < calzados.size(); j++ ){
					Row fila = hoja.createRow(j+1);  // Se crea apartir de la segunda fila
					
					for (int i = 0; i < 9; i++) { // i < numero de columnas
						Cell celda = fila.createCell(i);
						
						if(i == 4 || i == 8){ // convierte las columnas a entero antes de mandar el dato a la celda
							celda.setCellValue( Integer.parseInt(calzados.get(j).atributoObjeto(i)));
						}else if(i == 6 || i == 7){ // convierte las columnas a decimal antes de mandar el dato a la celda
							celda.setCellValue( Double.parseDouble(calzados.get(j).atributoObjeto(i)));
						}else{ // por default manda los datos como "cadena"
							celda.setCellValue( calzados.get(j).atributoObjeto(i) );
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
	public int exportarPDF(ArrayList<CalzadoReporte> calzados) {
		
		int respuesta = -1;
		
		try {
			
			JasperReport report = (JasperReport)JRLoader.loadObject( getClass().getResource("/report_template/reporte_calzado.jasper") ) ;
			
			Map<String, Object> parametros = new HashMap<String, Object>();
			JRBeanCollectionDataSource lista = new JRBeanCollectionDataSource(calzados);
			parametros.put("DATACalzado", lista); // El BeanCollection obtiene los datos de una Collection.
			
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
			vista.setTitle("Reporte Calzados");
				 
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

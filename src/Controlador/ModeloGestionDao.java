package Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import entidad.Modelo;
import entidad.ModeloReporte;
import interfaces.ModeloInterfaceDao;
import utils.ConnectionMySQL_8;

public class ModeloGestionDao implements ModeloInterfaceDao{

	
	private Connection cn;
//	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	
	private ArrayList<Modelo> listaOriginal;
	private ArrayList<ModeloReporte> lista;
//	private Modelo obj;
	
	
	// Sentencias
	
	final String GETALL_ORG = "{call pa_listar_modelo_original()}";
	final String GETALL_MOD = "{call pa_listar_modelo_modificado()}";
	
	final String LASTCODE = "{call pa_buscar_ultimo_codigo_modelo()}";
	final String INSERT = "{call pa_insertar_modelo(?,?,?,?,?,?)}";
	final String UPDATE = "{call pa_actualizar_modelo(?,?,?,?,?,?)}";
	final String SEARCH_ORG_NAME_EXT = "{call pa_buscar_modelo_original_nombre_ext(?)}";
	final String SEARCH_MOD_ALL_IXT = "{call pa_buscar_modelo_modificado_all_ixt(?)}";
	
	
	@Override
	public String generarCodigo() {
		
		
		String codModelo = "M1001";
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(LASTCODE);
			rs = cs.executeQuery();
			
			if(rs.next()){
				DecimalFormat df = new DecimalFormat("0000");
				codModelo = "M" + df.format(Integer.parseInt(rs.getString(1)) + 1); // example -> 003 + 1 = 004
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia generarCodigo() - MODELO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia generarCodigo() - MODELO --> " + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return codModelo;
	}

	@Override
	public ArrayList<Modelo> listarOriginal() {
		
		listaOriginal = new ArrayList<Modelo>();
		Modelo obj;
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(GETALL_ORG);
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Modelo(
						rs.getString(i++),
						rs.getString(i++),
						rs.getDouble(i++),
						rs.getDouble(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
				listaOriginal.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia listarOriginal() - MODELO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia listarOriginal() - MODELO --> " + e.getMessage());
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
	public ArrayList<ModeloReporte> listarModificado() {
		
		lista = new ArrayList<ModeloReporte>();
		ModeloReporte obj = null;
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(GETALL_MOD);
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new ModeloReporte(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getDouble(i++),
						rs.getDouble(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia lista() - MODELO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia lista() - MODELO --> " + e.getMessage());
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
	public int registrar(Modelo m) {
		
		int respuesta = -1;
		try {
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(INSERT);
			
			int i = 1;
			cs.setString(i++, m.getCod_modelo());
			cs.setString(i++, m.getNombre_modelo());
			cs.setDouble(i++, m.getPrecio_compra());
			cs.setDouble(i++, m.getPrecio_venta());
			cs.setString(i++, m.getCod_marca());
			cs.setString(i++, m.getCod_categoria());
			
			respuesta = cs.executeUpdate();
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia registrar() - MODELO --> " + e1.getMessage());
		}catch (Exception e1){
			System.out.println("Error en la sentencia registrar() - MODELO --> " + e1.getMessage());
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
	public int actualizar(Modelo m) {

		int respuesta = -1;
		try {
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(UPDATE);
			
			int i = 1;
			cs.setString(i++, m.getCod_modelo());
			cs.setString(i++, m.getNombre_modelo());
			cs.setDouble(i++, m.getPrecio_compra());
			cs.setDouble(i++, m.getPrecio_venta());
			cs.setString(i++, m.getCod_marca());
			cs.setString(i++, m.getCod_categoria());
			
			respuesta = cs.executeUpdate();
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia actualizar() - MODELO --> " + e1.getMessage());
		}catch (Exception e1){
			System.out.println("Error en la sentencia actualizar() - MODELO --> " + e1.getMessage());
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
	public ArrayList<ModeloReporte> buscarModAllIxt(String valor) {
		lista = new ArrayList<ModeloReporte>();
		ModeloReporte obj = null;
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCH_MOD_ALL_IXT);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new ModeloReporte(
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getDouble(i++),
						rs.getDouble(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscar() - MODELO --> " + e.getMessage());
		}catch (Exception e1){
			System.out.println("Error en la sentencia buscar() - MODELO --> " + e1.getMessage());
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
	public Modelo buscarOrgNombreExt(String nombre) {
		
		Modelo obj = null;
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCH_ORG_NAME_EXT);
			cs.setString(1, nombre);
			
			rs = cs.executeQuery();
			
			if(rs.next()){
				
				obj = new Modelo(
						rs.getString(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getDouble(4),
						rs.getString(5),
						rs.getString(6)
				);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorNombre() - MODELO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarPorNombre() - MODELO --> " + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la base de datos" + e.getMessage());
			}
		}
		
		return obj;
		
	}


	

}

package Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import entidad.Cliente;
import interfaces.ClienteInterfaceDao;
import utils.ConnectionMySQL_8;

public class ClienteGestionDao implements ClienteInterfaceDao{

	
	private Connection cn;
//	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	private ArrayList<Cliente> lista;
//	private Cliente obj;
	
	// Sentencias
	
	final String GETALL_ORG = "{call pa_listar_cliente_original()}";
	final String LASTCODE = "{call pa_buscar_ultimo_codigo_cliente()}";
	final String INSERT = "{call pa_insertar_cliente(?,?,?,?,?,?,?,?)}";
	final String UPDATE = "{call pa_actualizar_cliente(?,?,?,?,?,?,?,?)}";
	//final String DELETE = "{call pa_eliminar_empleado(?)}";
	
	final String SEARCH_ORG_CODE_IXT = "{call pa_buscar_cliente_original_codigo_ixt(?)}";
	final String SEARCH_ORG_NAME_IXT = "{call pa_buscar_cliente_original_nombreapellido_ixt(?)}";
	final String SEARCH_ORG_DNI_IXT = "{call pa_buscar_cliente_original_dni_ixt(?)}";
	final String SEARCH_ORG_DNI_EXT = "{call pa_buscar_cliente_original_dni_ext(?)}";
	final String SEARCH_MOD_DISTRITO_IXT = "{call pa_buscar_cliente_modificado_distrito_ixt(?)}";
	
	
	
	@Override
	public ArrayList<Cliente> listarOriginal() {
		
		lista = new ArrayList<Cliente>();
		Cliente obj = null;
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(GETALL_ORG);
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Cliente(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia listar() - CLIENTE" + e.getMessage());
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
	public String generarCodigo() {

		String codCliente = "CL10001";
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(LASTCODE);
			rs = cs.executeQuery();
			
			if(rs.next()){
				DecimalFormat df = new DecimalFormat("00000");
				codCliente = "CL" + df.format(Integer.parseInt(rs.getString(1)) + 1); // example -> 003 + 1 = 004
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia generarCodigo() - CLIENTE" + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return codCliente;
		
	}

	
	
	@Override
	public int registrar(Cliente c) {
		
		int respuesta = -1;
		try {
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(INSERT);
			
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
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia registrar() - CLIENTE" + e1.getMessage());
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
	public int actualizar(Cliente c) {

		int respuesta = -1;
		try {
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(UPDATE);
			
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
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia actualizar() - CLIENTE" + e1.getMessage());
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
	public Cliente buscarOrgCodigoIxt(String codigo) { // ACA NO ESTABIEN PORQUE EL STORE PROCEDURE DEVUELVE UNA LISTA, LO ARREGLE OBTENIENDO SOLO LA PRIMERA DE ELLAS PERO DEBE CORREGIRSE DESDE LA BD
		
		Cliente obj = null;
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCH_ORG_CODE_IXT);
			cs.setString(1, codigo);
			
			rs = cs.executeQuery();
			
			if(rs.next()){
				
				int i=1;
				obj = new Cliente(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorCodigo() - CLIENTE" + e.getMessage());
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
	public ArrayList<Cliente> buscarOrgNombreIxt(String valor) {

		lista = new ArrayList<Cliente>();
		Cliente obj = null;
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCH_ORG_NAME_IXT);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Cliente(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorNombre() - CLIENTE" + e.getMessage());
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
	public ArrayList<Cliente> buscarOrgDniIxt(String valor) {

		lista = new ArrayList<Cliente>();
		Cliente obj = null;
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCH_ORG_DNI_IXT);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Cliente(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorDni() - CLIENTE" + e.getMessage());
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
	public Cliente buscarOrgDniExt(String valor) {
		
		Cliente obj = null;
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCH_ORG_DNI_EXT);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Cliente(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorDniExacto() - CLIENTE --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarPorDniExacto() - CLIENTE --> " + e.getMessage());
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
	public ArrayList<Cliente> buscarModDistritoIxt(String valor) {

		lista = new ArrayList<Cliente>();
		Cliente obj = null;
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCH_MOD_DISTRITO_IXT);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Cliente(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorDistrito() - CLIENTE" + e.getMessage());
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



}

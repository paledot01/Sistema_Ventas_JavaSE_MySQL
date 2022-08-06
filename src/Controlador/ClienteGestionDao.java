package Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import entidad.CalzadoReporte;
import entidad.Cliente;
import entidad.Empleado;
import interfaces.ClienteInterfaceDao;
import utils.ConnectionMySQL_8;

public class ClienteGestionDao implements ClienteInterfaceDao{

	
	private Connection cn;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	private ArrayList<Cliente> lista;
//	private Cliente obj;
	
	// Sentencias
	
	final String GETALL = "{call pa_listar_cliente()}";
	final String LASTCODE = "{call pa_buscar_ultimo_codigo_cliente()}";
	final String INSERT = "{call pa_insertar_cliente(?,?,?,?,?,?,?,?)}";
	final String UPDATE = "{call pa_actualizar_cliente(?,?,?,?,?,?,?,?)}";
	//final String DELETE = "{call pa_eliminar_empleado(?)}";
	
	final String SEARCHCODE = "{call pa_buscar_cliente_por_codigo(?)}";
	final String SEARCHNAME = "{call pa_buscar_cliente_por_nombre_apellido(?)}";
	final String SEARCHDNI = "{call pa_buscar_cliente_por_dni(?)}";
	final String SEARCH_DNI_EXACT = "{call pa_buscar_cliente_por_dni_exacto(?)}";
	final String SEARCHDISTRITO = "{call pa_buscar_cliente_por_distrito(?)}";

	
	
	@Override
	public ArrayList<Cliente> listar() {
		
		lista = new ArrayList<Cliente>();
		Cliente obj = null;
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(GETALL);
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
	public Cliente buscarPorCodigo(String codigo) {
		
		Cliente obj = null;
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCHCODE);
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
	public ArrayList<Cliente> buscarPorNombre(String valor) {

		lista = new ArrayList<Cliente>();
		Cliente obj = null;
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCHNAME);
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
	public ArrayList<Cliente> buscarPorDni(String valor) {

		lista = new ArrayList<Cliente>();
		Cliente obj = null;
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCHDNI);
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
	public Cliente buscarPorDniExacto(String valor) {
		
		Cliente obj = null;
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCH_DNI_EXACT);
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
	public ArrayList<Cliente> buscarPorDistrito(String valor) {

		lista = new ArrayList<Cliente>();
		Cliente obj = null;
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCHDISTRITO);
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

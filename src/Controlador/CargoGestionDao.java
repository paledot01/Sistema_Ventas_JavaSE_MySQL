package Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Cargo;
import entidad.Distrito;
import interfaces.CargoInterfaceDao;
import utils.ConnectionMySQL_8;

public class CargoGestionDao implements CargoInterfaceDao{

	
	private Connection cn;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	private ArrayList<Cargo> lista;
	private Cargo obj;
	
	
	// Sentencias
	
	final String GETALL = "{call pa_listar_cargo()}";
	final String SEARCH = "{call pa_buscar_cargo(?)}";
	
	@Override
	public ArrayList<Cargo> listarCargo() {
		
		lista = new ArrayList<Cargo>();
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(GETALL);
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Cargo(
						rs.getString(i++),
						rs.getString(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia listarCargo" + e.getMessage());
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
	public Cargo buscarCargo(String valor) {
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCH);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			if(rs.next()){
				
				obj = new Cargo(
						rs.getString(1),
						rs.getString(2)
				);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarCargo" + e.getMessage());
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
	
}








//aa
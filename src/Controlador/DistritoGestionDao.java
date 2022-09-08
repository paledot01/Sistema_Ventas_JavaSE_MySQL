package Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Distrito;
import interfaces.DistritoInterfaceDao;
import utils.ConnectionMySQL_8;

public class DistritoGestionDao implements DistritoInterfaceDao{

	
	private Connection cn;
//	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	private ArrayList<Distrito> lista;
	private Distrito obj;
	
	// Sentencias
	
	final String GETALL_ORG = "{call pa_listar_distrito_original()}";
	final String SEARCH_ORG_ALL_EXT = "{call pa_buscar_distrito_original_all_ext(?)}";
	
	
	@Override
	public ArrayList<Distrito> listarOriginal() {
		
		lista = new ArrayList<Distrito>();
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(GETALL_ORG);
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Distrito(
						rs.getString(i++),
						rs.getString(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia listarDistrito" + e.getMessage());
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
	public Distrito buscarOrgAllExt(String valor) {
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(SEARCH_ORG_ALL_EXT);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			if(rs.next()){
				
				obj = new Distrito(
						rs.getString(1),
						rs.getString(2)
				);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarDistrito" + e.getMessage());
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
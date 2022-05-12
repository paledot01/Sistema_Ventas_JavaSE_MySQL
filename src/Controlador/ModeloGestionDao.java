package Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Marca;
import entidad.Modelo;
import interfaces.ModeloInterfaceDao;
import utils.ConnectionMySQL_8;

public class ModeloGestionDao implements ModeloInterfaceDao{

	
	private Connection cn;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	
	private ArrayList<Modelo> lista;
	private Modelo obj;
	
	
	// Sentencias
	
	final String GETALL = "{call pa_listar_modelo()}";
	
	
	
	
	
	
	
	@Override
	public String generarCodigo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Modelo> listar() {
		
		lista = new ArrayList<Modelo>();
		
		try{
			cn = ConnectionMySQL_8.getConnection();
			cs = cn.prepareCall(GETALL);
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
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia Listar() - MODDELO" + e.getMessage());
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizar(Modelo m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Modelo> buscar(String valor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}

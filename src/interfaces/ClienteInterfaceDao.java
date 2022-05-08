package interfaces;

import java.util.ArrayList;

import entidad.Cliente;


public interface ClienteInterfaceDao {


	public ArrayList<Cliente> listar();
	
	public String generarCodigo();
	
	public int registrar(Cliente c);
	
	public int actualizar(Cliente c);
	
	// public int eliminar(String codigo);
	
	public Cliente buscarPorCodigo(String codigo);
	
	public ArrayList<Cliente> buscarPorNombre(String valor);
	
	public ArrayList<Cliente> buscarPorDni(String valor);
	
	public ArrayList<Cliente> buscarPorDistrito(String valor);
	
	
}

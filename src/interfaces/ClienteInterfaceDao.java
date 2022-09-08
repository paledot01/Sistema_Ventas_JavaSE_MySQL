package interfaces;

import java.util.ArrayList;

import entidad.Cliente;


public interface ClienteInterfaceDao {


	public ArrayList<Cliente> listarOriginal();
	
	public String generarCodigo();
	
	public int registrar(Cliente c);
	
	public int actualizar(Cliente c);
	
	// public int eliminar(String codigo);
	
	public Cliente buscarOrgCodigoIxt(String codigo); // aca no esta bien, porque deberia devolver una lista.
	
	public ArrayList<Cliente> buscarOrgNombreIxt(String valor);
	
	public ArrayList<Cliente> buscarOrgDniIxt(String valor);
	
	public Cliente buscarOrgDniExt(String valor);
	
	public ArrayList<Cliente> buscarModDistritoIxt(String valor); // aca no esta bien.
	
	
}

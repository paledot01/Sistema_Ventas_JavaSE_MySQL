package interfaces;

import java.util.ArrayList;

import entidad.Marca;


public interface MarcaInterfaceDao {

	
	public String generarCodigo();

	public ArrayList<Marca> listarOriginal();
	
	public int registrar(Marca c);
	
	public int actualizar(Marca c);
	
	public ArrayList<Marca> buscarOrgAllIxt(String valor);
	
//	public Marca buscar(String valor); // busca por codigo O descripcion
	
}

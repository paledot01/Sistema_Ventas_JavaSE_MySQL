package interfaces;

import java.util.ArrayList;

import entidad.Marca;


public interface MarcaInterfaceDao {

	
	public String generarCodigo();

	public ArrayList<Marca> listar();
	
	public int registrar(Marca c);
	
	public int actualizar(Marca c);
	
	public ArrayList<Marca> buscar(String valor);
	
//	public Marca buscar(String valor); // busca por codigo O descripcion
	
}

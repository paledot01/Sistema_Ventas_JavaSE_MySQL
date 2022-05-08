package interfaces;

import java.util.ArrayList;

import entidad.Categoria;

public interface CategoriaInterfaceDao {
	
	
	public String generarCodigo();

	public ArrayList<Categoria> listar();
	
	public int registrar(Categoria c);
	
	public int actualizar(Categoria c);
	
	public Categoria buscar(String valor); // busca por codigo O descripcion
	
	
}

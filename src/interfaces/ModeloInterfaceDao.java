package interfaces;

import java.util.ArrayList;

import entidad.Modelo;

public interface ModeloInterfaceDao {

	public String generarCodigo();
	
	public ArrayList<Modelo> listar();
	
	public int registrar (Modelo m);
	
	public int actualizar (Modelo m);
	
	public ArrayList<Modelo> buscar (String valor);
	
//	public Modelo buscar (String valor); // busca por codigo o descripcion.
	
	
	
}

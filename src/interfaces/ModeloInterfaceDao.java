package interfaces;

import java.util.ArrayList;

import entidad.Modelo;

public interface ModeloInterfaceDao {

	public String generarCodigo();
	
	public ArrayList<Modelo> listar();
	
	public int registrar (Modelo m);
	
	public int actualizar (Modelo m);
	
	public ArrayList<Modelo> buscar (String valor); // busca por codigo, nombre, categoria o marca, devolviendo todos los resultados.
	
	public Modelo buscarPorNombre (String nombre); // busca por nombre y devuelve el modelo, es una busqueda simple
	
//	public Modelo buscar (String valor); // busca por codigo o descripcion.
	
	
	
}

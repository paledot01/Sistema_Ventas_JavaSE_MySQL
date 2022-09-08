package interfaces;

import java.util.ArrayList;

import entidad.Modelo;
import entidad.ModeloReporte;

public interface ModeloInterfaceDao {

	public String generarCodigo();
	
	public ArrayList<Modelo> listarOriginal();
	
	public ArrayList<ModeloReporte> listarModificado();
	
	public int registrar (Modelo m);
	
	public int actualizar (Modelo m);
	
	public ArrayList<ModeloReporte> buscarModAllIxt (String valor); // busca por codigo, nombre, categoria o marca, devolviendo todos los resultados.
	
	public Modelo buscarOrgNombreExt (String nombre); // busca por nombre y devuelve el modelo, es una busqueda simple
	
//	public Modelo buscar (String valor); // busca por codigo o descripcion.
	
	
	
}

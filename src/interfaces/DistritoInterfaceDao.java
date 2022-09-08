package interfaces;

import java.util.ArrayList;

import entidad.Distrito;


public interface DistritoInterfaceDao {

	
	public ArrayList<Distrito> listarOriginal(); // --> lista con los atributos originales del objeto
	
	public Distrito buscarOrgAllExt(String valor); // --> busca con cualquiera de todos sus atributos(codigo, descripcion), cuyo 'valor' debe ser igual al resultado (Exacto), y que devuelve un objeto con los atributos originales.
	 
}

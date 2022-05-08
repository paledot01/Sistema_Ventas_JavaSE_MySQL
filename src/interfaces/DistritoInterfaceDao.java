package interfaces;

import java.util.ArrayList;

import entidad.Distrito;
import entidad.Empleado;


public interface DistritoInterfaceDao {

	
	public ArrayList<Distrito> listarDistrito();
	
	public Distrito buscarDistrito(String valor); // --> busca por codigo o descripcion
	
}

package interfaces;

import java.util.ArrayList;

import entidad.Cargo;

public interface CargoInterfaceDao {
	
	
	public ArrayList<Cargo> listarOriginal();
	
	public Cargo buscarOrgAllExt(String valor); // --> busca por codigo o descripcion
	
}

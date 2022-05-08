package interfaces;

import java.util.ArrayList;

import entidad.Cargo;

public interface CargoInterfaceDao {
	
	
	public ArrayList<Cargo> listarCargo();
	
	public Cargo buscarCargo(String valor); // --> busca por codigo o descripcion
	
}

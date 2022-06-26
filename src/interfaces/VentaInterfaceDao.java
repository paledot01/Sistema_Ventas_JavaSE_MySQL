package interfaces;

import java.util.ArrayList;

import entidad.Boleta_Cabecera;
import entidad.Boleta_Detalle;
import entidad.Cliente;

public interface VentaInterfaceDao {

	
	public String generarCodigo();
	
	public int realizarVenta(Cliente c, Boleta_Cabecera cabBoleta, ArrayList<Boleta_Detalle> detBoleta);
	
}

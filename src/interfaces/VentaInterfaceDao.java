package interfaces;

import java.util.ArrayList;

import entidad.Boleta_Cabecera;
import entidad.Boleta_Cabecera_Reporte;
import entidad.Boleta_Detalle;
import entidad.Boleta_Detalle_Reporte;
import entidad.Cliente;

public interface VentaInterfaceDao {

	
	public String generarCodigo();
	
	public int realizarVenta(Cliente c, Boleta_Cabecera cabBoleta, ArrayList<Boleta_Detalle> detBoleta);
	
	public Boleta_Cabecera_Reporte buscarCabezaBoleta(String valor);
	
	public ArrayList<Boleta_Detalle_Reporte> buscarDetalleBoleta(String valor);
	
	public int generarBoleta(Boleta_Cabecera_Reporte cabeza ,ArrayList<Boleta_Detalle_Reporte> calzados, int tipoComprobante);
	
}

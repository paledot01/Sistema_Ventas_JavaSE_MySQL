package interfaces;

import java.util.ArrayList;

import entidad.Calzado;
import entidad.CalzadoReporte;

public interface CalzadoInterfaceDao {

	public ArrayList<CalzadoReporte> listar();
	
	public String generarCodigo();
	
	public int registrar(Calzado c);
	
	public int actualizar(Calzado c);
	
	public ArrayList<Calzado> buscarPorCodigoSimple(String valor);
	
	public ArrayList<CalzadoReporte> buscarPorCodigo(String valor);
	
	public ArrayList<CalzadoReporte> buscarPorModelo(String valor);
	
	public ArrayList<CalzadoReporte> buscarPorCategoria(String valor);
	
	public ArrayList<CalzadoReporte> buscarPorMarca(String valor);
	
	public ArrayList<CalzadoReporte> buscarPorTalla(int valor);
	
	public ArrayList<CalzadoReporte> buscarPorColor(String valor);
	
	public int exportarTXT(ArrayList<CalzadoReporte> calzados);
	
	public int exportarXLSX(ArrayList<CalzadoReporte> calzados);
	
	public int exportarPDF(ArrayList<CalzadoReporte> calzados);
	
}

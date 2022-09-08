package interfaces;

import java.util.ArrayList;

import entidad.Calzado;
import entidad.CalzadoReporte;

public interface CalzadoInterfaceDao {

	public ArrayList<CalzadoReporte> listarModificado();
	
	public String generarCodigo();
	
	public int registrar(Calzado c);
	
	public int actualizar(Calzado c);
	
	
	public ArrayList<Calzado> buscarOrgCodigoIxt(String valor);
	
	public CalzadoReporte buscarModCodigoExt(String valor);
	
	public ArrayList<CalzadoReporte> buscarModCodigoIxt(String valor);
	
	
	public ArrayList<CalzadoReporte> buscarModModeloIxt(String valor);
	
	public ArrayList<CalzadoReporte> buscarModCategoriaIxt(String valor);
	
	public ArrayList<CalzadoReporte> buscarModMarcaIxt(String valor);
	
	public ArrayList<CalzadoReporte> buscarModTallaIxt(int valor);
	
	public ArrayList<CalzadoReporte> buscarModColorIxt(String valor);
	
	
	public int exportarTXT(ArrayList<CalzadoReporte> calzados);
	
	public int exportarXLSX(ArrayList<CalzadoReporte> calzados);
	
	public int exportarPDF(ArrayList<CalzadoReporte> calzados);
	
}

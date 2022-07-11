package interfaces;

import java.util.ArrayList;

import entidad.CalzadoReporte;
import entidad.Empleado;
import entidad.EmpleadoReporte;

public interface EmpleadoInterfaceDao {
	
	
	public ArrayList<Empleado> listarOriginal();
	
	public ArrayList<EmpleadoReporte> listar();
	
	public Empleado validarAcceso(String user, String pass);
	
	public String generarCodigo();
	
	public int registrar(Empleado e);
	
	public int actualizar(Empleado e);
	
	// public int eliminarEmpleado(String codigo);
	
	public ArrayList<Empleado> buscarOriginalPorCodigo(String valor);
	
	public EmpleadoReporte buscarPorCodigoExacto(String valor);
	
	public ArrayList<EmpleadoReporte> buscarPorCodigo(String valor);
	
	
	public ArrayList<EmpleadoReporte> buscarPorNombre(String valor);
	
	public ArrayList<EmpleadoReporte> buscarPorDni(String valor);
	
	public ArrayList<EmpleadoReporte> buscarPorDistrito(String valor);
	
	
	public int exportarTXT( ArrayList<EmpleadoReporte> empleados );
	
	public int exportarXLSX( ArrayList<EmpleadoReporte> empleados );
	
	public int exportarPDF( ArrayList<EmpleadoReporte> empleados );
	
}

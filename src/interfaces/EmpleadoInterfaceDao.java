package interfaces;

import java.util.ArrayList;

import entidad.Empleado;
import entidad.EmpleadoReporte;

public interface EmpleadoInterfaceDao {
	
	
	public ArrayList<Empleado> listarOriginal();
	
	public ArrayList<EmpleadoReporte> listarModificado();
	
	public Empleado validarAcceso(String user, String pass);
	
	public String generarCodigo();
	
	public int registrar(Empleado e);
	
	public int actualizar(Empleado e);
	
	// public int eliminarEmpleado(String codigo);
	
	public ArrayList<Empleado> buscarOrgCodigoIxt(String valor);
	
	public EmpleadoReporte buscarModCodigoExt(String valor);
	
	public ArrayList<EmpleadoReporte> buscarModCodigoIxt(String valor);
	
	
	public ArrayList<EmpleadoReporte> buscarModNombreIxt(String valor);
	
	public ArrayList<EmpleadoReporte> buscarModDniIxt(String valor);
	
	public ArrayList<EmpleadoReporte> buscarModDistritoIxt(String valor);
	
	
	public int exportarTXT( ArrayList<EmpleadoReporte> empleados );
	
	public int exportarXLSX( ArrayList<EmpleadoReporte> empleados );
	
	public int exportarPDF( ArrayList<EmpleadoReporte> empleados );
	
}

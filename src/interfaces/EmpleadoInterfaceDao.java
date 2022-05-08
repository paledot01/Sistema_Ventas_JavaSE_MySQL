package interfaces;

import java.util.ArrayList;

import entidad.Empleado;

public interface EmpleadoInterfaceDao {
	
	
	public ArrayList<Empleado> listar();
	
	public Empleado validarAcceso(String user, String pass);
	
	public String generarCodigo();
	
	public int registrar(Empleado e);
	
	public int actualizar(Empleado e);
	
	// public int eliminarEmpleado(String codigo);
	
	public Empleado buscarPorCodigo(String codigo);
	
	public ArrayList<Empleado> buscarPorNombre(String valor);
	
	public ArrayList<Empleado> buscarPorDni(String valor);
	
	public ArrayList<Empleado> buscarPorDistrito(String valor);
	
	public int exportarTXT( ArrayList<Empleado> empleados );
	
	public int exportarXLSX( ArrayList<Empleado> empleados );
	
	public int exportarPDF( ArrayList<Empleado> empleados );
	
}

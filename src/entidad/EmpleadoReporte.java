package entidad;

public class EmpleadoReporte {

	// Atributos
	private String cod_empleado;
	private String nombre;
	private String apellidos;
	private String dni;
	private String direccion;
	private String telefono;
	private String email;
	private String cod_distrito;
	private String cod_cargo;
	private String usuario;
	private String contraseña;
	private String estado;
	
	// Constructores
	public EmpleadoReporte (){	
	}

	
	// Constructor para recibir empleados de la Base de Datos
	public EmpleadoReporte(String cod_empleado, String nombre, String apellidos, String dni, String direccion, 
			String telefono, String email, String cod_distrito, String cod_cargo, String usuario, 
			String contraseña, String estado) {
		super();
		this.cod_empleado = cod_empleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.cod_distrito = cod_distrito;
		this.cod_cargo = cod_cargo;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.estado = estado;
	}
	
	
	// Metodos GET-SET
	
	public String getCod_empleado() {
		return cod_empleado;
	}

	public void setCod_empleado(String cod_empleado) {
		this.cod_empleado = cod_empleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCod_distrito() {
		return cod_distrito;
	}

	public void setCod_distrito(String cod_distrito) {
		this.cod_distrito = cod_distrito;
	}

	public String getCod_cargo() {
		return cod_cargo;
	}

	public void setCod_cargo(String cod_cargo) {
		this.cod_cargo = cod_cargo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

	
	
	
}

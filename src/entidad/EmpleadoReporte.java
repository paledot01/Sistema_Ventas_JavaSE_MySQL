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
	private String distrito;
	private String cargo;
	private String usuario;
	private String contrasena;
	private String estado;
	
	// Constructores
	public EmpleadoReporte (){	
	}

	// Constructor para recibir empleados de la Base de Datos
	public EmpleadoReporte(String cod_empleado, String nombre, String apellidos, String dni, String direccion,
			String telefono, String email, String distrito, String cargo, String usuario, String contrasena,
			String estado) {
		super();
		this.cod_empleado = cod_empleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.distrito = distrito;
		this.cargo = cargo;
		this.usuario = usuario;
		this.contrasena = contrasena;
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

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	// DEVUELVE EL ATRIBUTO DEL OBJETO DE LA POSICION ESPECIFICADA
	public String atributoObjeto( int position){
		
		String[] atributo = new String[15];
//		int indice = 0;
		
		atributo[0] = getCod_empleado();
		atributo[1] = getNombre();
		atributo[2] = getApellidos();
		atributo[3] = getDni();
		atributo[4] = getDireccion();
		atributo[5] = getTelefono();
		atributo[6] = getEmail();
		atributo[7] = getDistrito();
		atributo[8] = getCargo();
		atributo[9] = getUsuario();
		atributo[10] = getContrasena();
		atributo[11] = getEstado();	
		
		return atributo[position];
	}
	
	
}

package entidad;

public class Empleado {

	
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
	private Integer cod_estado;
	
	// Constructores
	public Empleado (){	
	}
	
	// Constructor para recibir empleados de la Base de Datos
	public Empleado(String cod_empleado, String nombre, String apellidos, String dni, String direccion, 
			String telefono, String email, String cod_distrito, String cod_cargo, String usuario, 
			String contraseña, Integer cod_estado) {
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
		this.cod_estado = cod_estado;
	}
	
	// Constructor para crear un empleado >> sin user, pass, estado
	public Empleado(String cod_empleado, String nombre, String apellidos, String dni, String direccion
			, String telefono, String email, String cod_distrito, String cod_cargo) {
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
		this.usuario = nombre.toLowerCase() + apellidos.toLowerCase().charAt(0);
		this.contraseña = dni;
		this.cod_estado = 1; // por defecto esta en ACTIVO
	}
	
	// Constructor para actualizar un empleado >> sin user, pass
	public Empleado(String cod_empleado, String nombre, String apellidos, String dni, String direccion
			, String telefono, String email, String cod_distrito, String cod_cargo, Integer cod_estado) {
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
		this.usuario = nombre.toLowerCase() + apellidos.toLowerCase().charAt(0);
		this.contraseña = dni;
		this.cod_estado = cod_estado;
	}

	// Metodos get-set
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

	public Integer getCod_estado() {
		return cod_estado;
	}

	public void setCod_estado(Integer cod_estado) {
		this.cod_estado = cod_estado;
	}

	// DEVUELVE EL ATRIBUTO DEL OBJETO DE LA POSICION ESPECIFICADA
	public String atributoObjeto( int position){
		
		String[] atributo = new String[15];
		int indice = 0;
		
		atributo[0] = getCod_empleado();
		atributo[1] = getNombre();
		atributo[2] = getApellidos();
		atributo[3] = getDni();
		atributo[4] = getDireccion();
		atributo[5] = getTelefono();
		atributo[6] = getEmail();
		atributo[7] = getCod_distrito();
		atributo[8] = getCod_cargo();
		atributo[9] = getUsuario();
		atributo[10] = getContraseña();
		atributo[11] = getCod_estado().toString();	
		
		
//		atributo[0] = obj.getCod_empleado();
//		atributo[1] = obj.getNombre();
//		atributo[2] = obj.getApellidos();
//		atributo[3] = obj.getDni();
//		atributo[4] = obj.getDireccion();
//		atributo[5] = obj.getTelefono();
//		atributo[6] = obj.getEmail();
//		atributo[7] = obj.getCod_distrito();
//		atributo[8] = obj.getCod_cargo();
//		atributo[9] = obj.getUsuario();
//		atributo[10] = obj.getContraseña();
//		atributo[11] = obj.getEstado().toString();
			
		
		return atributo[position];
	}
	
	
	
	
	
	
}

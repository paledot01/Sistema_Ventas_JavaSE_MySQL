package entidad;

public class Distrito {

	// Atributos
	private String cod_distrito;
	private String descripcion; 
	
	// Constructores
	public Distrito(){
		
	}

	public Distrito(String cod_distrito, String descripcion) {
		super();
		this.cod_distrito = cod_distrito;
		this.descripcion = descripcion;
	}

	// Metodos get-set
	public String getCod_distrito() {
		return cod_distrito;
	}

	public void setCod_distrito(String cod_distrito) {
		this.cod_distrito = cod_distrito;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}

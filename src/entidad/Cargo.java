package entidad;

public class Cargo {

	// Atributos
	private String cod_cargo;
	private String descripcion;
	
	// Constructores
	public Cargo(){
		
	}

	public Cargo(String cod_cargo, String descripcion) {
		super();
		this.cod_cargo = cod_cargo;
		this.descripcion = descripcion;
	}

	// Metodos get-set
	public String getCod_cargo() {
		return cod_cargo;
	}

	public void setCod_cargo(String cod_cargo) {
		this.cod_cargo = cod_cargo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}

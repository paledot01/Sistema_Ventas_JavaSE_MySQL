package entidad;

public class Marca {

	// Atributos
	private String cod_marca;
	private String nombre_marca;
	
	// Constructores
	public Marca(){
		
	}
	
	public Marca(String cod_marca, String nombre_marca) {
		super();
		this.cod_marca = cod_marca;
		this.nombre_marca = nombre_marca;
	}

	// Metodos get-set
	public String getCod_marca() {
		return cod_marca;
	}

	public void setCod_marca(String cod_marca) {
		this.cod_marca = cod_marca;
	}

	public String getNombre_marca() {
		return nombre_marca;
	}

	public void setNombre_marca(String nombre_marca) {
		this.nombre_marca = nombre_marca;
	}
	
	
}

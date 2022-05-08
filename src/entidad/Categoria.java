package entidad;

public class Categoria {

	// Atributos
	private String cod_categoria;
	private String descripcion;
	
	// Constructores
	public Categoria(){
		
	}

	public Categoria(String cod_categoria, String descripcion) {
		super();
		this.cod_categoria = cod_categoria;
		this.descripcion = descripcion;
	}

	// Metodos get-set
	public String getCod_categoria() {
		return cod_categoria;
	}

	public void setCod_categoria(String cod_categoria) {
		this.cod_categoria = cod_categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}

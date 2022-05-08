package entidad;

public class Calzado {

	// Atributo
	private String cod_calzado;
	private String cod_modelo;
	private int talla;
	private String color;
	private int stock;
	
	// Constructores
	public Calzado(){
		
	}

	public Calzado(String cod_calzado, String cod_modelo, int talla, String color, int stock) {
		super();
		this.cod_calzado = cod_calzado;
		this.cod_modelo = cod_modelo;
		this.talla = talla;
		this.color = color;
		this.stock = stock;
	}

	// Metodos get-set
	public String getCod_calzado() {
		return cod_calzado;
	}

	public void setCod_calzado(String cod_calzado) {
		this.cod_calzado = cod_calzado;
	}

	public String getCod_modelo() {
		return cod_modelo;
	}

	public void setCod_modelo(String cod_modelo) {
		this.cod_modelo = cod_modelo;
	}

	public int getTalla() {
		return talla;
	}

	public void setTalla(int talla) {
		this.talla = talla;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}

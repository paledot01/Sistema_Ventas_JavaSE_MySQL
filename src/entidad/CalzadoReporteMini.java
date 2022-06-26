package entidad;

public class CalzadoReporteMini {

	private String cod_calzado;
	private String nombre_modelo;
	private Integer talla;
	private String color;
	private Integer stock;
	
	public CalzadoReporteMini(){
		
	}

	public CalzadoReporteMini(String cod_calzado, String nombre_modelo, Integer talla, String color, Integer stock) {
		super();
		this.cod_calzado = cod_calzado;
		this.nombre_modelo = nombre_modelo;
		this.talla = talla;
		this.color = color;
		this.stock = stock;
	}

	public String getCod_calzado() {
		return cod_calzado;
	}

	public void setCod_calzado(String cod_calzado) {
		this.cod_calzado = cod_calzado;
	}

	public String getNombre_modelo() {
		return nombre_modelo;
	}

	public void setNombre_modelo(String nombre_modelo) {
		this.nombre_modelo = nombre_modelo;
	}

	public Integer getTalla() {
		return talla;
	}

	public void setTalla(Integer talla) {
		this.talla = talla;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
	
}

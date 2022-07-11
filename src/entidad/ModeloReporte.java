package entidad;

public class ModeloReporte {

	// Atributo
	private String cod_modelo;
	private String nombre_modelo;
	private String marca;
	private String categoria;
	private double precio_compra;
	private double precio_venta;

	// Constructores
	public ModeloReporte(){
		
	}

	public ModeloReporte(String cod_modelo, String nombre_modelo, String marca, String categoria, double precio_compra,
			double precio_venta) {
		super();
		this.cod_modelo = cod_modelo;
		this.nombre_modelo = nombre_modelo;
		this.marca = marca;
		this.categoria = categoria;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
	}

	// Metodos get-set
	public String getCod_modelo() {
		return cod_modelo;
	}


	public void setCod_modelo(String cod_modelo) {
		this.cod_modelo = cod_modelo;
	}


	public String getNombre_modelo() {
		return nombre_modelo;
	}


	public void setNombre_modelo(String nombre_modelo) {
		this.nombre_modelo = nombre_modelo;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public double getPrecio_compra() {
		return precio_compra;
	}


	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}


	public double getPrecio_venta() {
		return precio_venta;
	}


	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
	
	
	
	
}

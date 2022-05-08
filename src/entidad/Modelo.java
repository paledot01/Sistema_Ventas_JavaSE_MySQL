package entidad;

public class Modelo {
	
	// Atributo
	private String cod_modelo;
	private String nombre_modelo;
	private double precio_compra;
	private double precio_venta;
	private String cod_marca;
	private String cod_categoria;
	
	// Constructores
	public Modelo(){
		
	}

	public Modelo(String cod_modelo, String nombre_modelo, double precio_compra, double precio_venta, String cod_marca,
			String cod_categoria) {
		super();
		this.cod_modelo = cod_modelo;
		this.nombre_modelo = nombre_modelo;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
		this.cod_marca = cod_marca;
		this.cod_categoria = cod_categoria;
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

	public String getCod_marca() {
		return cod_marca;
	}

	public void setCod_marca(String cod_marca) {
		this.cod_marca = cod_marca;
	}

	public String getCod_categoria() {
		return cod_categoria;
	}

	public void setCod_categoria(String cod_categoria) {
		this.cod_categoria = cod_categoria;
	}
	
	
}

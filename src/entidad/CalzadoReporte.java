package entidad;

public class CalzadoReporte {

	private String cod_calzado;
	private String nombre_modelo;
	private String nombre_marca;
	private String descripcion_categoria;
	private Integer talla;
	private String color;
	private double precio_compra;
	private double precio_venta;
	private Integer stock;
	
	public CalzadoReporte(){
		
	}

	public CalzadoReporte(String cod_calzado, String nombre_modelo, String nombre_marca, String descripcion_categoria,
			Integer talla, String color, double precio_compra, double precio_venta, Integer stock) {
		super();
		this.cod_calzado = cod_calzado;
		this.nombre_modelo = nombre_modelo;
		this.nombre_marca = nombre_marca;
		this.descripcion_categoria = descripcion_categoria;
		this.talla = talla;
		this.color = color;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
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

	public String getNombre_marca() {
		return nombre_marca;
	}

	public void setNombre_marca(String nombre_marca) {
		this.nombre_marca = nombre_marca;
	}

	public String getDescripcion_categoria() {
		return descripcion_categoria;
	}

	public void setDescripcion_categoria(String descripcion_categoria) {
		this.descripcion_categoria = descripcion_categoria;
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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	// DEVUELVE EL ATRIBUTO DEL OBJETO DE LA POSICION ESPECIFICADA
	public String atributoObjeto(int posicion){
		
		String[] atributo = new String[9];
//		Object[] atributo = new Object[9];
		
		atributo[0] = getCod_calzado();
		atributo[1] = getNombre_modelo();
		atributo[2] = getNombre_marca();
		atributo[3] = getDescripcion_categoria();
		atributo[4] = String.valueOf(getTalla());
		atributo[5] = getColor();
		atributo[6] = String.valueOf(getPrecio_compra());
		atributo[7] = String.valueOf(getPrecio_venta());
		atributo[8] = String.valueOf(getStock());
		
		return atributo[posicion];
				
	}
	
}

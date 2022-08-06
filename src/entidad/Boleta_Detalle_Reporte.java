package entidad;

public class Boleta_Detalle_Reporte {

	// PROPIEDADES
	private String codigo_boleta;
	private String codigo_clz;
	private Integer cantidad_clz;
	private String descripcion_clz;
	private double p_unitario_clz;
	private double importe_clz;
	
	// CONSTRUCTORES
	public Boleta_Detalle_Reporte(){
		
	}

	public Boleta_Detalle_Reporte(String codigo_boleta, String codigo_clz, Integer cantidad_clz, String descripcion_clz,
			double p_unitario_clz, double importe_clz) {
		super();
		this.codigo_boleta = codigo_boleta;
		this.codigo_clz = codigo_clz;
		this.cantidad_clz = cantidad_clz;
		this.descripcion_clz = descripcion_clz;
		this.p_unitario_clz = p_unitario_clz;
		this.importe_clz = importe_clz;
	}

	public String getCodigo_boleta() {
		return codigo_boleta;
	}

	public void setCodigo_boleta(String codigo_boleta) {
		this.codigo_boleta = codigo_boleta;
	}

	public String getCodigo_clz() {
		return codigo_clz;
	}

	public void setCodigo_clz(String codigo_clz) {
		this.codigo_clz = codigo_clz;
	}

	public Integer getCantidad_clz() {
		return cantidad_clz;
	}

	public void setCantidad_clz(Integer cantidad_clz) {
		this.cantidad_clz = cantidad_clz;
	}

	public String getDescripcion_clz() {
		return descripcion_clz;
	}

	public void setDescripcion_clz(String descripcion_clz) {
		this.descripcion_clz = descripcion_clz;
	}

	public double getP_unitario_clz() {
		return p_unitario_clz;
	}

	public void setP_unitario_clz(double p_unitario_clz) {
		this.p_unitario_clz = p_unitario_clz;
	}

	public double getImporte_clz() {
		return importe_clz;
	}

	public void setImporte_clz(double importe_clz) {
		this.importe_clz = importe_clz;
	}
	
	
	
	
	
}

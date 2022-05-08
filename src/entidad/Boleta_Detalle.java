package entidad;

public class Boleta_Detalle {

	// Atributo
	private String cod_boleta;
	private String cod_calzado;
	private int cantidad;
	private int importe;
	
	// Constructores
	public Boleta_Detalle(){
		
	}

	public Boleta_Detalle(String cod_boleta, String cod_calzado, int cantidad, int importe) {
		super();
		this.cod_boleta = cod_boleta;
		this.cod_calzado = cod_calzado;
		this.cantidad = cantidad;
		this.importe = importe;
	}

	// Metodos get-set

	public String getCod_boleta() {
		return cod_boleta;
	}

	public void setCod_boleta(String cod_boleta) {
		this.cod_boleta = cod_boleta;
	}

	public String getCod_calzado() {
		return cod_calzado;
	}

	public void setCod_calzado(String cod_calzado) {
		this.cod_calzado = cod_calzado;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}
	
	
}

package entidad;

import java.sql.Date;
import java.sql.Time;


public class Boleta_Cabecera {

	// Atributo
	private String cod_boleta;
	private Date fecha_emision;
	private Time hora_emision;
	private String cod_cliente;
	private String cod_empleado;
	
	
	public Boleta_Cabecera() {

	}

	public Boleta_Cabecera(String cod_boleta, Date fecha_emision, Time hora_emision, String cod_cliente,
			String cod_empleado) {
		super();
		this.cod_boleta = cod_boleta;
		this.fecha_emision = fecha_emision; // para la creacion se le manda NULL
		this.hora_emision = hora_emision; // para la creacion se le manda NULL
		this.cod_cliente = cod_cliente; // para la creacion se le manda NULL
		this.cod_empleado = cod_empleado;
	}



	public String getCod_boleta() {
		return cod_boleta;
	}


	public void setCod_boleta(String cod_boleta) {
		this.cod_boleta = cod_boleta;
	}


	public Date getFecha_emision() {
		return fecha_emision;
	}


	public void setFecha_emision(Date fecha_emision) {
		this.fecha_emision = fecha_emision;
	}


	public Time getHora_emision() {
		return hora_emision;
	}


	public void setHora_emision(Time hora_emision) {
		this.hora_emision = hora_emision;
	}


	public String getCod_cliente() {
		return cod_cliente;
	}


	public void setCod_cliente(String cod_cliente) {
		this.cod_cliente = cod_cliente;
	}


	public String getCod_empleado() {
		return cod_empleado;
	}


	public void setCod_empleado(String cod_empleado) {
		this.cod_empleado = cod_empleado;
	}
	
	
	
	
	
}

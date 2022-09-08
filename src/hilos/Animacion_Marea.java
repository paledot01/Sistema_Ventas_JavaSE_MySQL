package hilos;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;

import vista.Pnl_Content;

public class Animacion_Marea extends Thread{

	// No se guarda la nueva pocision del JLabel con cada cambio de pocision, siempre toma como referencia 
	// la pocision que tenia al inicio del todo.

//	private String nombre;
	ArrayList<JLabel> labels;
	private int radio;
	private double angulo; // angulo de avance de giro del componente, en radianes. Recuerda que los radianos van desde 0 a 2pi(2*3.14159)
	private int centros [][];
	private int dormir;
	
	public Animacion_Marea(ArrayList<JLabel> labels) {
		super();

		this.labels = labels;
		this.radio = 20;
		this.centros = new int[labels.size()][2];
		this.angulo = Math.toRadians(0); // toma el numero decimal como un angulo sexagecimal y lo comvierte a radian.
		this.dormir = 200;
	}
	

	public void run(){
		// UN LABEL SOLO DEBE ESPERAR AL SIGUIENTE NO A TODOS LOS LABELS DEL ARREGLO
		// ANTES DE QUE CADA ELEMENTO SE MUEVA SE DEBE GUARDAR LA POCISION DE SU CENTRO SOLO UNA VEZ.
		super.run();
		
		for(int i=0; i<labels.size(); i++) {
			centros[i][0] = labels.get(i).getX();
			centros[i][1] = labels.get(i).getY();
		}
		
		while (true){
	
			for(int i=0; i<labels.size(); i++) {
				labels.get(i).setLocation(centros[i][0] + (int) (radio*Math.cos(angulo)), centros[i][1] - (int) (radio*Math.sin(angulo)));

				try {
					Thread.sleep(dormir);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(dormir!=60) {
					dormir-=20;
				}

			}
			
			angulo += Math.toRadians(10); // convierte 10 grados sexagesimales a radianes, y lo sumamos.
			
		}
		
	}
	
}

package hilos;

import javax.swing.JLabel;

public class Animacion_Circular extends Thread{ // --> esta animacion mueve circular e indefinidamente a un JLabel proporcionado

	// No se guarda la nueva pocision del JLabel con cada cambio de pocision, siempre toma como referencia 
	// la pocision que tenia al inicio del todo.
	private boolean detenerHilo; // expresion booleana para poder detener el hilo.
	private String nombre;
	private JLabel label;
	private int radio;
	private int centroX;
	private int centroY;
	private double anguloAvance; // el angulo que varia con cada movimiento
	private double angulo; // angulo de avance de giro del componente, en radianes. Recuerda que los radianos van desde 0 a 2pi(2*3.14159)

	public Animacion_Circular(JLabel label, String nombre, int radio, double anguloAvance) {
		super();
		this.nombre = nombre;
		this.label = label;
		this.radio = radio; // radio de la circunferencia
		this.centroX = this.label.getX() - radio;
		this.centroY = this.label.getY();
		this.anguloAvance = anguloAvance;
		this.angulo = Math.toRadians(0); // toma el numero decimal como un angulo sexagecimal y lo comvierte a radian.
		this.detenerHilo = false;
	}
	

	public void run(){
		
		super.run();
		
		while (!detenerHilo){
			
			label.setLocation(centroX + (int) (radio*Math.cos(angulo)), centroY - (int) (radio*Math.sin(angulo)));
			angulo += Math.toRadians(anguloAvance); // convierte 10 grados sexagesimales a radianes, y lo sumamos.
			
			System.out.println(nombre + " : " + label.getX() + "-" + label.getY());
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		
	}
	
	public void stopHilo() { // metodo para deteber el Hilo
		detenerHilo = true;
	}
	
}

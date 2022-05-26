package hilos;

import java.text.SimpleDateFormat;
import java.util.Date;

import vista.Pnl_Content;

public class Animacion_Reloj extends Thread{

	public void run(){
		
		super.run();
		
		while (true){
			
			Date fecha = new Date();
			
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a"); // obtenemos la hora de la fecha
			Pnl_Content.lblReloj.setText(sdf.format(fecha));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}

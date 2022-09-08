package hilos;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

import vista.Pnl_Content;

public class Animacion_Reloj extends Thread{

	public void run(){
		
		super.run();
		
		while (true){
			
			Date fecha = new Date();
			
			// modificamos el simbolo am y pm
			DateFormatSymbols symbols = new DateFormatSymbols();
			 String[] modifiedAmPm = {"AM", "PM"};
			 symbols.setAmPmStrings(modifiedAmPm);
			
			// cambiamos el formato de la fecha y hora y agregamos el simbolo am y pm creado
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a", symbols); // obtenemos la hora de la fecha
			Pnl_Content.lblReloj.setText(sdf.format(fecha).toUpperCase());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}

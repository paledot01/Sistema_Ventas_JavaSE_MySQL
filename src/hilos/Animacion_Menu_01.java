package hilos;

import javax.swing.JPanel;

import vista.Pnl_Content;

public class Animacion_Menu_01 extends Thread{

	private JPanel panel;
	
	public Animacion_Menu_01(JPanel panel) {
		super();
		this.panel = panel;
	}
	
	public void run(){
		
		super.run();
		if( panel.getY() == 77  ){ // de 77 a 176, diferencia de 99
			while ( Pnl_Content.isActivo() == true ) {
				int bajar = 11; 
				
				panel.setLocation(panel.getX(), panel.getY() + bajar );
				Pnl_Content.pnl_btn_calzado.setVisible(true);
				Pnl_Content.pnl_btn_cliente.setVisible(true);
				Pnl_Content.pnl_btn_empleado.setVisible(true);
				if( panel.getY() == 176){
					Pnl_Content.setActivo(false);
				}
				
				try {
					Thread.sleep(17);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		else{ // de 77 a 176, diferencia de 99
			while ( Pnl_Content.isActivo() == false ) {
				int subir = 11;
				
				panel.setLocation(panel.getX(), panel.getY() - subir );
				
				if( panel.getY() == 77 ){
					Pnl_Content.setActivo(true);
					Pnl_Content.pnl_btn_calzado.setVisible(false);
					Pnl_Content.pnl_btn_cliente.setVisible(false);
					Pnl_Content.pnl_btn_empleado.setVisible(false);
				}
				
				try {
					Thread.sleep(17);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}

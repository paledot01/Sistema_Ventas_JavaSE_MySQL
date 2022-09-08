package vista;

import javax.swing.JPanel;


import hilos.Animacion_Circular;
import utils.Library;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class Pnl_Access_ClickMe extends JPanel implements MouseListener {
	private JPanel pnl_access_clickme;
	private JLabel lbl1;
	private JLabel lblAtras;
	private JLabel lbl4;
	private JLabel lbl3;
	private JLabel lbl2;
	private JTextArea txtMensaje;
	
	Animacion_Circular circular1;
	Animacion_Circular circular2;
	Animacion_Circular circular3;
	Animacion_Circular circular4;

	
	public Pnl_Access_ClickMe() {
		setLayout(null);
		
		pnl_access_clickme = new JPanel();
		pnl_access_clickme.setBackground(Library.Oscuro_2);
		pnl_access_clickme.setBounds(0, 0, 700, 500);
		add(pnl_access_clickme);
		pnl_access_clickme.setLayout(null);
		
		lblAtras = new JLabel("Atras");
		lblAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAtras.addMouseListener(this);
		lblAtras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAtras.setForeground(Library.Font);
		lblAtras.setBounds(335, 245, 30, 14);
		pnl_access_clickme.add(lblAtras);
		
		lbl4 = new JLabel("o");
		lbl4.setForeground(Library.Font);
		lbl4.setFont(new Font("Monospaced", Font.PLAIN, 16));
		lbl4.setBounds(395, 239, 10, 22);
		pnl_access_clickme.add(lbl4);
		
		lbl3 = new JLabel("O");
		lbl3.setForeground(Library.Font);
		lbl3.setFont(new Font("Monospaced", Font.PLAIN, 16));
		lbl3.setBounds(420, 239, 10, 22);
		pnl_access_clickme.add(lbl3);
		
		lbl2 = new JLabel("o");
		lbl2.setForeground(Library.Font);
		lbl2.setFont(new Font("Monospaced", Font.PLAIN, 16));
		lbl2.setBounds(445, 239, 10, 22);
		pnl_access_clickme.add(lbl2);

		lbl1 = new JLabel("O");
		lbl1.setForeground(Library.Font);
		lbl1.setFont(new Font("Monospaced", Font.PLAIN, 16));
		lbl1.setBounds(495, 239, 10, 22);
		pnl_access_clickme.add(lbl1);
		
		txtMensaje = new JTextArea();
		txtMensaje.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtMensaje.setEditable(false);
		txtMensaje.setForeground(Library.Font);
		txtMensaje.setBackground(Library.Oscuro_2);
		txtMensaje.setText("'' Hola me llamo Kevin, gracias por descargar este sistema y espero \r\nque este proyecto apesar de ser basico y no estar terminado pueda \r\nalmenos serte útil. Saludos. ''");
		txtMensaje.setBounds(109, 418, 481, 71);
		pnl_access_clickme.add(txtMensaje);
		
		animacionMarea();
	}
	
	
	void animacionMarea() {
		
		circular1 = new Animacion_Circular(lbl1, "label-1", 145, 1);
		circular2 = new Animacion_Circular(lbl2, "label-2", 95, 3);
		circular3 = new Animacion_Circular(lbl3, "label-3", 70, 5);
		circular4 = new Animacion_Circular(lbl4, "label-4", 45, 10);

		
		circular1.start();
		circular2.start();
		circular3.start();
		circular4.start();
		
	}
	
	//-----------------------------------------------------------------------------------
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == lblAtras) {
			lblAtras.setForeground(Library.AMARILLO);
		}
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == lblAtras) {
			lblAtras.setForeground(Library.Font);
		}
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == lblAtras) {
			Pnl_Access.MostrarEnPanelPrincipal(new Pnl_Access_Login());
			circular1.stopHilo(); // metodo creado en el hilo para detener el proceso.
			circular2.stopHilo();
			circular3.stopHilo();
			circular4.stopHilo();
		}
	}
	
	
	
	
}

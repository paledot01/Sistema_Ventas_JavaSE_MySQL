package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Cursor;

public class Frm_Principal extends JFrame implements MouseListener, MouseMotionListener {

	private JPanel contentPane;
	public static JPanel pnl_strip;
	public static JPanel pnl_principal;
	public static JLabel lblX;

	// EL evento de arrastrar la ventana requiere dos eventos, 
	// al presionar la ventana y al arrastrar la ventana
	/** EVENTO "ARRASTRAR" DE LA BARRA - 01 **/
	int xMouse, yMouse;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Principal frame = new Frm_Principal();
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); // --> CAMBIA EL LOOK AND FEEL ( DISEÑO )
					frame.setVisible(true);
					/** CENTRAR LA VENTANA **/
					frame.setLocationRelativeTo(null); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frm_Principal() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnl_strip = new JPanel();
		pnl_strip.setOpaque(false);
		pnl_strip.addMouseMotionListener(this);
		pnl_strip.addMouseListener(this);
		//pnl_strip.setBackground(Color.WHITE);
		pnl_strip.setBounds(0, 0, 1100, 30);
		contentPane.add(pnl_strip);
		pnl_strip.setLayout(null);
		
		
		lblX = new JLabel("X");
		lblX.setOpaque(true);
		lblX.setForeground(new Color(230,230,230));
		lblX.setBackground(new Color(43, 47, 51));
		lblX.setBounds(1075, 1, 24, 24);
		pnl_strip.add(lblX);
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblX.addMouseListener(this);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		
		pnl_principal = new JPanel();
		pnl_principal.setBounds(0, 0, 1100, 700);
		contentPane.add(pnl_principal);
		pnl_principal.setLayout(null);
		
		// Traemos el panel de Acceso
		Pnl_Access Pnl_Access = new Pnl_Access();
		MostrarEnPanelPrincipal(Pnl_Access);
		
		
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lblX) {
			mouseClickedLblX(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == lblX) {
			mouseEnteredlblX(arg0);
		}
	}
	public void mouseExited(MouseEvent arg0) {
		if (arg0.getSource() == lblX) {
			mouseExitedlblX(arg0);
		}
	}
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource() == pnl_strip) {
			mousePressedPanelStrip(arg0);
		}
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == pnl_strip) {
			mouseDraggedPanelStrip(arg0);
		}
	}
	public void mouseMoved(MouseEvent arg0) {
	}
	/** EVENTO CLICK DEL LABEL X PARA CERRAR LA VENTANA **/
	protected void mouseClickedLblX(MouseEvent arg0) { 
		System.exit(0);
	}
	/** HOVER DEL LABEL X -01  **/
	private void mouseEnteredlblX(MouseEvent arg0) { 
		lblX.setBackground(new Color(27, 31, 35));
		//lblX.setForeground(new Color(230,230,230));
	}
	/** HOVER DEL LABEL X - 02 **/
	private void mouseExitedlblX(MouseEvent arg0) { 
		lblX.setBackground(new Color(43, 47, 51));
		//lblX.setForeground(new Color(230,230,230));
	}
	/** EVENTO "ARRASTRAR" DE LA BARRA - 02 - EVENTO PRESIONAR **/
	protected void mousePressedPanelStrip(MouseEvent arg0) {
		xMouse = arg0.getX();  
		yMouse = arg0.getY();
	}
	/** EVENTO "ARRASTRAR" DE LA BARRA - 03 - EVENTO ARRASTRAR **/
	protected void mouseDraggedPanelStrip(MouseEvent arg0) {
		int x = arg0.getXOnScreen();  
		int y = arg0.getYOnScreen();
		this.setLocation(x-xMouse, y-yMouse);
	}
	
	
	// Mostrar en el panel "p" dentro del panel principal
	static void MostrarEnPanelPrincipal(JPanel p){
		p.setSize(1100,700);
		p.setLocation(0, 0);
		pnl_principal.removeAll();
		pnl_principal.setLayout(null);
		pnl_principal.add(p);
		pnl_principal.revalidate();
		pnl_principal.repaint();
	}
	
}























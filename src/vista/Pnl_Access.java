package vista;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Pnl_Access extends JPanel {
	private JPanel pnl_access;
	public static JPanel pnl_access_main;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public Pnl_Access() {
		setLayout(null);
		
		pnl_access = new JPanel();
		pnl_access.setBorder(new LineBorder(new Color(63, 68, 73), 1, true));
		pnl_access.setBackground(new Color(43, 47, 51));
		pnl_access.setBounds(0, 0, 1100, 700);
		add(pnl_access);
		pnl_access.setLayout(null);
		
		pnl_access_main = new JPanel();
		pnl_access_main.setBackground(SystemColor.activeCaptionBorder);
		pnl_access_main.setBounds(200, 100, 700, 500);
		pnl_access.add(pnl_access_main);
		
		// Traemos el Panel de Login
		Pnl_Access_Login Pnl_Access_Login = new Pnl_Access_Login();
		MostrarEnPanelPrincipal(Pnl_Access_Login);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Pnl_Access.class.getResource("/img/cibertec_50px.png")));
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBounds(1027, 613, 38, 50);
		pnl_access.add(lblNewLabel);

	}
	
	// Mostrar en el panel "p" dentro del panel principal
	static void MostrarEnPanelPrincipal(JPanel p){
		
		p.setSize(700,500);
		p.setLocation(0, 0);
		pnl_access_main.removeAll();
		pnl_access_main.setLayout(null);
		pnl_access_main.add(p);
		pnl_access_main.revalidate();
		pnl_access_main.repaint();
		
	}
	
}

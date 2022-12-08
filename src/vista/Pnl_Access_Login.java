package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controlador.EmpleadoGestionDao;
import entidad.Empleado;
import utils.Library;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class Pnl_Access_Login extends JPanel implements ActionListener, KeyListener, MouseListener {
	public static JPanel pnl_access_login;
	private JPanel pnl_login;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JTextField txtUser;
	private JButton btnEntrar;
	private JLabel lblNewLabel;
	private JPasswordField txtPassword;

	/** -------- **/
	EmpleadoGestionDao empleadoGestion = new EmpleadoGestionDao();
	public static Empleado empleadoConectado = new Empleado();
	private JLabel lblClickme;

	
	/** --- Constructor --- **/
	public Pnl_Access_Login() { 
		setLayout(null);
		
		pnl_access_login = new JPanel();
		pnl_access_login.setBackground(Library.Oscuro_2);
		pnl_access_login.setBounds(0, 0, 700, 500);
		add(pnl_access_login);
		pnl_access_login.setLayout(null);
		
		pnl_login = new JPanel();
		pnl_login.setBorder(new LineBorder(new Color(95,103,112), 2, true));
		pnl_login.setBackground(new Color(63,68,73));
		pnl_login.setBounds(200, 124, 300, 260);
		pnl_access_login.add(pnl_login);
		pnl_login.setLayout(null);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblUsuario.setForeground(new Color(230,230,230));
		lblUsuario.setBounds(37, 31, 91, 20);
		pnl_login.add(lblUsuario);
		
		lblContrasena = new JLabel("Contrase\u00F1a :");
		lblContrasena.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblContrasena.setForeground(new Color(230,230,230));
		lblContrasena.setBounds(37, 98, 91, 20);
		pnl_login.add(lblContrasena);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtUser.setBounds(37, 62, 226, 25);
		pnl_login.add(txtUser);
		txtUser.setColumns(10);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(this);
		btnEntrar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		btnEntrar.setBounds(100, 191, 100, 25);
		pnl_login.add(btnEntrar);
		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(this);
		txtPassword.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setBounds(37, 129, 226, 25);
		pnl_login.add(txtPassword);
		
		lblClickme = new JLabel("click me");
		lblClickme.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClickme.addMouseListener(this);
		lblClickme.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblClickme.setForeground(Library.Font);
		lblClickme.setBounds(207, 236, 56, 13);
		pnl_login.add(lblClickme);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(268, 22, 163, 78);
		pnl_access_login.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Pnl_Access_Login.class.getResource("/img/logo_principal.png")));

	}
	
	private void mensaje(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje, "Error", 1);
	}
	
	private String getPass(){
		String pass = null;
		pass = String.valueOf(txtPassword.getPassword());
		return pass;
	}
	
	private String getUser(){
		String user = null;
		user = txtUser.getText();
		return user;
	}
	
	private void validarAcceso(){
		String user = getUser();
		String pass = getPass();
		
		empleadoConectado = empleadoGestion.validarAcceso(user, pass);
		if (empleadoConectado == null) {
			mensaje("Usuario y/o password incorrecto");
		} else {
			Frm_Principal.MostrarEnPanelPrincipal(new Pnl_Content());
			Frm_Principal.lblX.setVisible(false);
		}
	}
	
	// ----------------------------------------------------------------------------------------------
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEntrar) {
			validarAcceso();
		}
	}
	
	// ----------------------------------------------------------------------------------------------
	
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == txtPassword) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER ) {
				validarAcceso();
			}
		}
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}

	// ----------------------------------------------------------------------------------------------
	
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == lblClickme) {
			lblClickme.setForeground(Library.AMARILLO);
		}
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == lblClickme) {
			lblClickme.setForeground(Library.Font);
		}
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == lblClickme) {
			Pnl_Access.MostrarEnPanelPrincipal(new Pnl_Access_ClickMe());
		}
	}

}












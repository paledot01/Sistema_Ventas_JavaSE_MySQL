package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;


import Controlador.CargoGestionDao;
import hilos.Animacion_Menu_01;
import hilos.Animacion_Reloj;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class Pnl_Content extends JPanel implements MouseListener {
	private JPanel pnl_content;
	private JPanel pnl_content_side;
	public static JPanel pnl_content_body; // --
	private JLabel lblNewLabel;
	private JLabel lblCargo;
	private JLabel lblNombre;
	private JPanel pnl_menu_content_1;
	private JLabel lblNewLabel_2;
	private JLabel lblSignOut;
	private JPanel pnl_top_bar;
	private JLabel lblMantenimiento;
	//-- Componentes estaticos
	public static  JPanel pnl_menu_content_2;
	
	boolean [] boton = {true,false,false,false,false,false}; // para los botones que muestran un panel, y el primero inicie activado <<<<
	
	
	// Atributo y metodos estaticos necesarios
	
	private JPanel pnl_btn_mantenimiento;
	private JLabel lblX;
	private JLabel label;
	private JPanel pnl_btn_venta;
	private JLabel lblVenta;
	private JLabel label_2;
	private JLabel label_3;
	private JPanel pnl_btn_reportes;
	private JLabel lblReportes;
	private JLabel label_5;
	private JLabel label_6;
	private JPanel pnl_btn_dashboard;
	private JLabel lblDashboard;
	private JLabel label_4;
	private JLabel label_7;
	public static JPanel pnl_btn_calzado; //--
	private JLabel lblCalzado;
	private JLabel label_8;
	private JLabel label_9;
	public static JPanel pnl_btn_cliente; //--
	private JLabel lblCliente;
	private JLabel label_10;
	private JLabel label_11;
	public static JPanel pnl_btn_empleado; //--
	private JLabel lblEmpleado;
	private JLabel label_13;
	private JLabel label_14;
	private JPanel pnl_btn_exit;
	private JLabel label_12;
	
	public static boolean activo = true;
	public static boolean isActivo(){
		return activo;
	}
	public static void setActivo(boolean cambia){
		activo = cambia;
	}

	CargoGestionDao gCargo = new CargoGestionDao();
	private JLabel lblFecha;
	private JLabel lblApellidos;
	private JLabel lblPaledotgmailcom;
	private JLabel lblPaledot;
	private JLabel lblGitHub;
	private JLabel lblCorreo;
	public static JLabel lblReloj;
	
	public Pnl_Content() {
		setLayout(null);
		
		pnl_content = new JPanel();
		pnl_content.setBounds(0, 0, 1100, 700);
		add(pnl_content);
		pnl_content.setLayout(null);
		
		pnl_content_side = new JPanel();
		pnl_content_side.setBorder(new LineBorder(new Color(95, 103, 112)));
		pnl_content_side.setBackground(new Color(43, 47, 51));
		pnl_content_side.setBounds(0, 0, 230, 700);
		pnl_content.add(pnl_content_side);
		pnl_content_side.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Pnl_Content.class.getResource("/img/230x3_50px.png")));
		lblNewLabel.setBounds(15, 140, 50, 50);
		pnl_content_side.add(lblNewLabel);
		
		// Encontrando el Cargo del empleado conectado
		String codigo = Pnl_Access_Login.empleadoConectado.getCod_cargo();
		String cargo = gCargo.buscarCargo(codigo).getDescripcion().toUpperCase();
		lblCargo = new JLabel(cargo); // <-------------------------------------------
		lblCargo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargo.setForeground(new Color(230,230,230));
		lblCargo.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblCargo.setBounds(15, 114, 205, 15);
		pnl_content_side.add(lblCargo);
		
		lblNombre = new JLabel( Pnl_Access_Login.empleadoConectado.getNombre() ); // <-----------
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setForeground(new Color(230, 230, 230));
		lblNombre.setFont(new Font("Monospaced", Font.PLAIN, 14));
		lblNombre.setBounds(75, 148, 130, 15);
		pnl_content_side.add(lblNombre);
		
		lblApellidos = new JLabel( Pnl_Access_Login.empleadoConectado.getApellidos() );
		lblApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellidos.setForeground(new Color(230, 230, 230));
		lblApellidos.setFont(new Font("Monospaced", Font.PLAIN, 14));
		lblApellidos.setBounds(75, 167, 130, 15);
		pnl_content_side.add(lblApellidos);
		
		pnl_menu_content_1 = new JPanel();
		pnl_menu_content_1.setBackground(new Color(43, 47, 51));
		pnl_menu_content_1.setBounds(10, 212, 210, 412);
		pnl_content_side.add(pnl_menu_content_1);
		pnl_menu_content_1.setLayout(null);
		
		pnl_menu_content_2 = new JPanel();
		pnl_menu_content_2.setBackground(utils.Library.Oscuro_2);
		pnl_menu_content_2.setBounds(10, 77, 190, 181);
		pnl_menu_content_1.add(pnl_menu_content_2);
		pnl_menu_content_2.setLayout(null);
		
		pnl_btn_reportes = new JPanel();
		pnl_btn_reportes.setLayout(null);
		pnl_btn_reportes.setBackground(new Color(63, 68, 73));
		pnl_btn_reportes.setBounds(0, 33, 190, 22);
		pnl_btn_reportes.addMouseListener(this);
		pnl_menu_content_2.add(pnl_btn_reportes);
		
		lblReportes = new JLabel("REPORTES       ");
		lblReportes.setHorizontalTextPosition(SwingConstants.LEFT);
		lblReportes.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportes.setForeground(SystemColor.menu);
		lblReportes.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblReportes.setBounds(30, 0, 135, 22);
		pnl_btn_reportes.add(lblReportes);
		
		label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Pnl_Content.class.getResource("/img/chart_22px.png")));
		label_5.setOpaque(true);
		label_5.setHorizontalTextPosition(SwingConstants.LEFT);
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(SystemColor.menu);
		label_5.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		label_5.setBackground(new Color(43, 47, 51));
		label_5.setBounds(0, 0, 30, 22);
		pnl_btn_reportes.add(label_5);
		
		label_6 = new JLabel("");
		label_6.setHorizontalTextPosition(SwingConstants.LEFT);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(SystemColor.menu);
		label_6.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		label_6.setBounds(165, 0, 25, 22);
		pnl_btn_reportes.add(label_6);
		
		pnl_btn_dashboard = new JPanel();
		pnl_btn_dashboard.setBounds(0, 0, 190, 22);
		pnl_menu_content_2.add(pnl_btn_dashboard);
		pnl_btn_dashboard.setLayout(null);
		pnl_btn_dashboard.addMouseListener(this);
		pnl_btn_dashboard.setBackground(new Color(63, 68, 73));
		
		lblDashboard = new JLabel("DASHBOARD      ");
		lblDashboard.setHorizontalTextPosition(SwingConstants.LEFT);
		lblDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblDashboard.setForeground(SystemColor.menu);
		lblDashboard.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblDashboard.setBounds(30, 0, 135, 22);
		pnl_btn_dashboard.add(lblDashboard);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Pnl_Content.class.getResource("/img/chart_22px.png")));
		label_4.setOpaque(true);
		label_4.setHorizontalTextPosition(SwingConstants.LEFT);
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setForeground(SystemColor.menu);
		label_4.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		label_4.setBackground(new Color(43, 47, 51));
		label_4.setBounds(0, 0, 30, 22);
		pnl_btn_dashboard.add(label_4);
		
		label_7 = new JLabel("");
		label_7.setHorizontalTextPosition(SwingConstants.LEFT);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(SystemColor.menu);
		label_7.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		label_7.setBounds(165, 0, 25, 22);
		pnl_btn_dashboard.add(label_7);
		
		pnl_btn_mantenimiento = new JPanel();
		pnl_btn_mantenimiento.setBackground(utils.Library.Claro_1);
		pnl_btn_mantenimiento.setBounds(10, 44, 190, 22);
		pnl_menu_content_1.add(pnl_btn_mantenimiento);
		pnl_btn_mantenimiento.setLayout(null);
		pnl_btn_mantenimiento.addMouseListener(this);
		
		lblMantenimiento = new JLabel("MANTENIMIENTO  ");
		lblMantenimiento.setBounds(30, 0, 135, 22);
		pnl_btn_mantenimiento.add(lblMantenimiento);
		lblMantenimiento.setHorizontalTextPosition(SwingConstants.LEFT);
		lblMantenimiento.setIcon(null);
//		lblMantenimiento.addMouseListener(this);
		lblMantenimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimiento.setForeground(SystemColor.menu);
		lblMantenimiento.setFont(new Font("Lucida Console", Font.PLAIN, 12));
//		lblMantenimiento.setBackground(utils.Library.Claro_1);
		
		lblX = new JLabel("");
		lblX.setIcon(new ImageIcon(Pnl_Content.class.getResource("/img/lista.png")));
		lblX.setBounds(0, 0, 30, 22);
		pnl_btn_mantenimiento.add(lblX);
		lblX.setOpaque(true);
		lblX.setHorizontalTextPosition(SwingConstants.LEFT);
		lblX.setHorizontalAlignment(SwingConstants.LEFT);
		lblX.setForeground(SystemColor.menu);
		lblX.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblX.setBackground(utils.Library.Oscuro_2);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Pnl_Content.class.getResource("/img/angle-down-solid_8px.png")));
		label.setHorizontalTextPosition(SwingConstants.LEFT);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(SystemColor.menu);
		label.setFont(new Font("Lucida Console", Font.PLAIN, 12));
//		label.setBackground(utils.Library.Claro_1);
		label.setBounds(165, 0, 25, 22);
		pnl_btn_mantenimiento.add(label);
		
		pnl_btn_calzado = new JPanel();
		pnl_btn_calzado.setLayout(null);
		pnl_btn_calzado.setBackground(new Color(63, 68, 73));
		pnl_btn_calzado.setBounds(40, 77, 160, 22);
		pnl_btn_calzado.addMouseListener(this);
		pnl_menu_content_1.add(pnl_btn_calzado);
		
		lblCalzado = new JLabel("CALZADO  ");
		lblCalzado.setHorizontalTextPosition(SwingConstants.LEFT);
		lblCalzado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalzado.setForeground(SystemColor.menu);
		lblCalzado.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblCalzado.setBounds(29, 0, 105, 22);
		pnl_btn_calzado.add(lblCalzado);
		
		label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Pnl_Content.class.getResource("/img/shoes_22px.png")));
		label_8.setOpaque(true);
		label_8.setHorizontalTextPosition(SwingConstants.LEFT);
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(SystemColor.menu);
		label_8.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		label_8.setBackground(new Color(43, 47, 51));
		label_8.setBounds(0, 0, 30, 22);
		pnl_btn_calzado.add(label_8);
		
		label_9 = new JLabel("");
		label_9.setHorizontalTextPosition(SwingConstants.LEFT);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(SystemColor.menu);
		label_9.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		label_9.setBounds(135, 0, 25, 22);
		pnl_btn_calzado.add(label_9);
		
		pnl_btn_cliente = new JPanel();
		pnl_btn_cliente.setLayout(null);
		pnl_btn_cliente.setBackground(new Color(63, 68, 73));
		pnl_btn_cliente.setBounds(40, 110, 160, 22);
		pnl_btn_cliente.addMouseListener(this);
		pnl_menu_content_1.add(pnl_btn_cliente);
		
		lblCliente = new JLabel("CLIENTE  ");
		lblCliente.setHorizontalTextPosition(SwingConstants.LEFT);
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setForeground(SystemColor.menu);
		lblCliente.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblCliente.setBounds(29, 0, 105, 22);
		pnl_btn_cliente.add(lblCliente);
		
		label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(Pnl_Content.class.getResource("/img/people_22px.png")));
		label_10.setOpaque(true);
		label_10.setHorizontalTextPosition(SwingConstants.LEFT);
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(SystemColor.menu);
		label_10.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		label_10.setBackground(new Color(43, 47, 51));
		label_10.setBounds(0, 0, 30, 22);
		pnl_btn_cliente.add(label_10);
		
		label_11 = new JLabel("");
		label_11.setHorizontalTextPosition(SwingConstants.LEFT);
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(SystemColor.menu);
		label_11.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		label_11.setBounds(135, 0, 25, 22);
		pnl_btn_cliente.add(label_11);
		
		pnl_btn_empleado = new JPanel();
		pnl_btn_empleado.setLayout(null);
		pnl_btn_empleado.setBackground(new Color(63, 68, 73));
		pnl_btn_empleado.setBounds(40, 143, 160, 22);
		pnl_btn_empleado.addMouseListener(this);
		pnl_menu_content_1.add(pnl_btn_empleado);
		
		lblEmpleado = new JLabel("EMPLEADO");
		lblEmpleado.setHorizontalTextPosition(SwingConstants.LEFT);
		lblEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpleado.setForeground(SystemColor.menu);
		lblEmpleado.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblEmpleado.setBounds(29, 0, 105, 22);
		pnl_btn_empleado.add(lblEmpleado);
		
		label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(Pnl_Content.class.getResource("/img/worker.png")));
		label_13.setOpaque(true);
		label_13.setHorizontalTextPosition(SwingConstants.LEFT);
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setForeground(SystemColor.menu);
		label_13.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		label_13.setBackground(new Color(43, 47, 51));
		label_13.setBounds(0, 0, 30, 22);
		pnl_btn_empleado.add(label_13);
		
		label_14 = new JLabel("");
		label_14.setHorizontalTextPosition(SwingConstants.LEFT);
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setForeground(SystemColor.menu);
		label_14.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		label_14.setBounds(135, 0, 25, 22);
		pnl_btn_empleado.add(label_14);
		
		pnl_btn_venta = new JPanel();
		pnl_btn_venta.setBounds(10, 11, 190, 22);
		pnl_menu_content_1.add(pnl_btn_venta);
		pnl_btn_venta.setLayout(null);
		pnl_btn_venta.setBackground(utils.Library.Verde); // Para que inicie resaltado.
		pnl_btn_venta.addMouseListener(this);
		
		lblVenta = new JLabel("VENTA          ");
		lblVenta.setHorizontalTextPosition(SwingConstants.LEFT);
		lblVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenta.setForeground(SystemColor.menu);
		lblVenta.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblVenta.setBounds(30, 0, 135, 22);
		pnl_btn_venta.add(lblVenta);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Pnl_Content.class.getResource("/img/dollar_22px.png")));
		label_2.setOpaque(true);
		label_2.setHorizontalTextPosition(SwingConstants.LEFT);
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(SystemColor.menu);
		label_2.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		label_2.setBackground(new Color(43, 47, 51));
		label_2.setBounds(0, 0, 30, 22);
		pnl_btn_venta.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setHorizontalTextPosition(SwingConstants.LEFT);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(SystemColor.menu);
		label_3.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		label_3.setBounds(165, 0, 25, 22);
		pnl_btn_venta.add(label_3);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Pnl_Content.class.getResource("/img/logo_white_letter_200x.png")));
		lblNewLabel_2.setBounds(15, 45, 200, 28);
		pnl_content_side.add(lblNewLabel_2);
		
		pnl_btn_exit = new JPanel();
		pnl_btn_exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnl_btn_exit.setLayout(null);
		pnl_btn_exit.addMouseListener(this);
		pnl_btn_exit.setBackground(new Color(63, 68, 73));
		pnl_btn_exit.setBounds(10, 667, 130, 22);
		pnl_content_side.add(pnl_btn_exit);
		
		label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(Pnl_Content.class.getResource("/img/exit_230x3_22px.png")));
		label_12.setOpaque(true);
		label_12.setHorizontalTextPosition(SwingConstants.LEFT);
		label_12.setHorizontalAlignment(SwingConstants.LEFT);
		label_12.setForeground(SystemColor.menu);
		label_12.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		label_12.setBackground(new Color(43, 47, 51));
		label_12.setBounds(0, 0, 30, 22);
		pnl_btn_exit.add(label_12);
		
		lblSignOut = new JLabel("Sign out");
		lblSignOut.setBounds(30, 0, 105, 22);
		pnl_btn_exit.add(lblSignOut);
		lblSignOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignOut.setForeground(utils.Library.Font);
		lblSignOut.setBackground(utils.Library.Claro_1);
		lblSignOut.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		
		pnl_content_body = new JPanel();
		pnl_content_body.setBorder(new LineBorder(new Color(95,103,112)));
		pnl_content_body.setBounds(230, 30, 870, 670);
		pnl_content.add(pnl_content_body);
		
		pnl_top_bar = new JPanel();
		pnl_top_bar.setBackground(new Color(63, 68, 73));
		pnl_top_bar.setBorder(new LineBorder(new Color(95, 103, 112)));
		pnl_top_bar.setBounds(230, 0, 870, 30);
		pnl_content.add(pnl_top_bar);
		pnl_top_bar.setLayout(null);
		
		lblFecha = new JLabel("xxxxx");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setForeground(SystemColor.menu);
		lblFecha.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblFecha.setBounds(421, 0, 296, 30);
		pnl_top_bar.add(lblFecha);
		
		lblPaledotgmailcom = new JLabel("paledot01@gmail.com");
		lblPaledotgmailcom.setForeground(SystemColor.menu);
		lblPaledotgmailcom.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblPaledotgmailcom.setBounds(189, 0, 157, 30);
		pnl_top_bar.add(lblPaledotgmailcom);
		
		lblPaledot = new JLabel("paledot01");
		lblPaledot.setForeground(SystemColor.menu);
		lblPaledot.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblPaledot.setBounds(53, 0, 86, 30);
		pnl_top_bar.add(lblPaledot);
		
		lblGitHub = new JLabel("");
		lblGitHub.setIcon(new ImageIcon(Pnl_Content.class.getResource("/img/github.png")));
		lblGitHub.setBounds(13, 0, 30, 30);
		pnl_top_bar.add(lblGitHub);
		
		lblCorreo = new JLabel("");
		lblCorreo.setIcon(new ImageIcon(Pnl_Content.class.getResource("/img/correo.png")));
		lblCorreo.setBounds(149, 0, 30, 30);
		pnl_top_bar.add(lblCorreo);
		
		lblReloj = new JLabel("00:00:00 PM");
		lblReloj.setHorizontalAlignment(SwingConstants.CENTER);
		lblReloj.setFont(new Font("Courier New", Font.BOLD, 16));
		lblReloj.setForeground(SystemColor.menu);
		lblReloj.setBounds(727, 0, 143, 30);
		pnl_top_bar.add(lblReloj);
		
		
		// EL PANEL VENTA INICIA ACTIVADO POR DEFECTO
		Pnl_Content_Venta venta = new Pnl_Content_Venta();
		MostrarEnPanelContentBody(venta);
		
		// ESCONDER LOS PANELES QUE CONTIENEN LOS BOTONES OCULTOS
		pnl_btn_calzado.setVisible(false);
		pnl_btn_cliente.setVisible(false);
		pnl_btn_empleado.setVisible(false);
		
		// SUBIR EL PANEL ANIMADO
		
		
		fechaActual();
		mostrarHora();
		
	}
	
	void mostrarHora(){
		
		Animacion_Reloj reloj = new Animacion_Reloj();
		reloj.start();
	}
	
	public void fechaActual() {
		Date fecha=new Date();
		
		DateFormat df6 =  DateFormat.getDateInstance(DateFormat.FULL);
		lblFecha.setText("Fecha : " + df6.format(fecha));
		
	}
	
	public static void MostrarEnPanelContentBody(JPanel p){
		p.setSize(1100,700);
		p.setLocation(0, 0);
		pnl_content_body.removeAll();
		pnl_content_body.setLayout(null);
		pnl_content_body.add(p);
		pnl_content_body.revalidate();
		pnl_content_body.repaint();
	}
	
	
	/** ------------------- EVENTOS --------------------- **/
	public void mouseClicked(MouseEvent arg0) {

	}
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == pnl_btn_venta) {
			pnl_btn_venta.setBackground(utils.Library.Verde);
		}
		if (arg0.getSource() == pnl_btn_mantenimiento) {
			pnl_btn_mantenimiento.setBackground(utils.Library.Verde);
		}
		if (arg0.getSource() == pnl_btn_calzado) {
			pnl_btn_calzado.setBackground(utils.Library.Verde);
		}
		if (arg0.getSource() == pnl_btn_cliente) {
			pnl_btn_cliente.setBackground(utils.Library.Verde);
		}
		if (arg0.getSource() == pnl_btn_empleado) {
			pnl_btn_empleado.setBackground(utils.Library.Verde);
		}
		if (arg0.getSource() == pnl_btn_dashboard) {
			pnl_btn_dashboard.setBackground(utils.Library.Verde);
		}
		if (arg0.getSource() == pnl_btn_reportes) {
			pnl_btn_reportes.setBackground(utils.Library.Verde);
		}
		if (arg0.getSource() == pnl_btn_exit) {
			pnl_btn_exit.setBackground(utils.Library.Verde);
		}

	}
	public void mouseExited(MouseEvent arg0) {
		if (arg0.getSource() == pnl_btn_venta && boton[0] == false) {
			pnl_btn_venta.setBackground(utils.Library.Claro_1);
		}
		if (arg0.getSource() == pnl_btn_mantenimiento) {
			pnl_btn_mantenimiento.setBackground(utils.Library.Claro_1);
		}
		if (arg0.getSource() == pnl_btn_calzado && boton[1] == false) {
			pnl_btn_calzado.setBackground(utils.Library.Claro_1);
		}
		if (arg0.getSource() == pnl_btn_cliente && boton[2] == false) {
			pnl_btn_cliente.setBackground(utils.Library.Claro_1);
		}
		if (arg0.getSource() == pnl_btn_empleado && boton[3] == false) {
			pnl_btn_empleado.setBackground(utils.Library.Claro_1);
		}
		if (arg0.getSource() == pnl_btn_dashboard && boton[4] == false) {
			pnl_btn_dashboard.setBackground(utils.Library.Claro_1);
		}
		if (arg0.getSource() == pnl_btn_reportes && boton[5] == false) {
			pnl_btn_reportes.setBackground(utils.Library.Claro_1);
		}
		if (arg0.getSource() == pnl_btn_exit) {
			pnl_btn_exit.setBackground(utils.Library.Claro_1);
		}
	}
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource() == pnl_btn_venta) { // indice 0
			MostrarEnPanelContentBody(new Pnl_Content_Venta());
			activarPanel(0, pnl_btn_venta);
		}
		if (arg0.getSource() == pnl_btn_mantenimiento) {
			Animacion_Menu_01 hilo1 = new Animacion_Menu_01(pnl_menu_content_2); // --> HILO
			hilo1.start();
		}
		if (arg0.getSource() == pnl_btn_calzado) { // indice 1
			MostrarEnPanelContentBody(new Pnl_Content_Calzado());
			activarPanel(1, pnl_btn_calzado);
		}
		if (arg0.getSource() == pnl_btn_cliente) { // indice 2
			MostrarEnPanelContentBody(new Pnl_Content_Cliente());
			activarPanel(2, pnl_btn_cliente);
		}
		if (arg0.getSource() == pnl_btn_empleado) { // indice 3
			MostrarEnPanelContentBody(new Pnl_Content_Empleado());
			activarPanel(3, pnl_btn_empleado);
		}
		if (arg0.getSource() == pnl_btn_dashboard) { // indice 4
			activarPanel(4, pnl_btn_dashboard);
		}
		if (arg0.getSource() == pnl_btn_reportes) { // indice 5
			activarPanel(5, pnl_btn_reportes);
		}
		if (arg0.getSource() == pnl_btn_exit) {
			mousePressedPnl_btn_exit(arg0);
		}
		
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	
	
	/** --- EXIT --- **/
	protected void mousePressedPnl_btn_exit(MouseEvent arg0) {
		
		int respuesta;
		respuesta = JOptionPane.showConfirmDialog(pnl_content_body, "¿Estas seguro que deseas cerrar sesion?","Sistema",JOptionPane.YES_NO_OPTION);
		
		if(respuesta == 0){
			setActivo(true);
			Frm_Principal.MostrarEnPanelPrincipal(new Pnl_Access());
			Frm_Principal.lblX.setVisible(true);
			Frm_Principal.pnl_strip.setVisible(false);
			Frm_Principal.pnl_strip.setVisible(true);
			
		}
	}
	
	void activarPanel( int indice , JPanel thisPanel ){
		
		pnl_btn_dashboard.setBackground(utils.Library.Claro_1);
		pnl_btn_calzado.setBackground(utils.Library.Claro_1);
		pnl_btn_cliente.setBackground(utils.Library.Claro_1);
		pnl_btn_empleado.setBackground(utils.Library.Claro_1);
		pnl_btn_venta.setBackground(utils.Library.Claro_1);
		pnl_btn_reportes.setBackground(utils.Library.Claro_1);
		
		for (int i = 0; i < boton.length; i++) {
			if ( i == indice ) {
				boton[i] = true;
				thisPanel.setBackground(utils.Library.Verde);
			}
			else
				boton[i] = false ;
		}

	}
}

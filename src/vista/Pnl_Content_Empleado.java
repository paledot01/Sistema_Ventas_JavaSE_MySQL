package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controlador.CargoGestionDao;
import Controlador.DistritoGestionDao;
import Controlador.EmpleadoGestionDao;
import entidad.Cargo;
import entidad.Distrito;
import entidad.Empleado;
//import utils.SuperTable;//<<<<<<<<<
import utils.RendererTable;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Cursor;

public class Pnl_Content_Empleado extends JPanel implements MouseListener, KeyListener, ActionListener, ChangeListener {
	private JPanel pnl_empleado_main;
	private JLabel lblEmpleado;
	private JLabel lblCodigo;
	private JLabel lblApellido;
	private JLabel lblNombre;
	private JTextField txtApellido;
	private JLabel lblDni;
	private JLabel lblDireccion;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JLabel lblDistrito;
	private JLabel lblCargo;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTable tblEmpleado;
	private JScrollPane scrollPane;

	private JComboBox cboDistrito;
	private JComboBox cboCargo;
	private JTextField txtCodigo;
	private JPanel pnl_datos;
	private JTextField txtDireccion;
	private JTextField txtEmail;
	private JTextField txtNombre;
	private JPanel pnl_codigo;
	private JPanel pnl_acceso;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JTextField txtDni;
	private JTextField txtTelefono;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnCancelar;
	private JPanel panel;
	private JTextField txtBuscar;
	private JLabel lblBuscar;
	private JRadioButton rdbtnNombreapellido;
	private JRadioButton rdbtnCodigo;
	private JRadioButton rdbtnDni;
	private JRadioButton rdbtnDistrito;
	private JLabel lblEstado;
	private JTextField txtActivo;
	private JCheckBox chEstado;
	private JButton btnBuscar;
	
	private DefaultTableModel modelo = new DefaultTableModel(); // <---
	private EmpleadoGestionDao gEmpleado = new EmpleadoGestionDao(); // <---
	private DistritoGestionDao gDistrito = new DistritoGestionDao(); // <---
	private CargoGestionDao gCargo = new CargoGestionDao(); // <---
	
	RendererTable render = new RendererTable(); // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	
	
	private JButton btnExportarTXT;
	private JButton btnExportarXLS;
	private JButton btnExportarPDF;
	
	/**
	 * Create the panel.
	 */
	public Pnl_Content_Empleado() {
		setLayout(null);
		
		pnl_empleado_main = new JPanel();
		pnl_empleado_main.setBackground(SystemColor.menu);
		pnl_empleado_main.setBorder(new LineBorder(utils.Library.Claro_2));
		pnl_empleado_main.setBounds(0, 0, 870, 670);
		add(pnl_empleado_main);
		pnl_empleado_main.setLayout(null);
		
		lblEmpleado = new JLabel("EMPLEADO");
		lblEmpleado.setForeground(SystemColor.menu);
		lblEmpleado.setOpaque(true);
		lblEmpleado.setBackground(SystemColor.controlDkShadow);
		lblEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpleado.setFont(new Font("Courier New", Font.BOLD, 20));
		lblEmpleado.setBounds(10, 11, 850, 24);
		pnl_empleado_main.add(lblEmpleado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 335, 850, 324);
		pnl_empleado_main.add(scrollPane);
		
		tblEmpleado = new JTable();
		tblEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblEmpleado.setBorder(new LineBorder(new Color(95, 103, 112)));
		tblEmpleado.addMouseListener(this);
		tblEmpleado.addKeyListener(this);
		tblEmpleado.setFillsViewportHeight(true);
		tblEmpleado.setDefaultRenderer(Object.class, render); // <<<<<<<<<<<<<<<<<<<<<<<<<<<<
		scrollPane.setViewportView(tblEmpleado);
		
		pnl_datos = new JPanel();
		pnl_datos.setBorder(new LineBorder(new Color(95, 103, 112), 2, true));
		pnl_datos.setBounds(10, 46, 850, 192);
		pnl_empleado_main.add(pnl_datos);
		pnl_datos.setLayout(null);
		
		lblApellido = new JLabel("Apellido *");
		lblApellido.setEnabled(false);
		lblApellido.setBounds(299, 64, 70, 22);
		pnl_datos.add(lblApellido);
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtApellido = new JTextField();
		txtApellido.setDisabledTextColor(Color.GRAY);
		txtApellido.setEnabled(false);
		txtApellido.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellido.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtApellido.setBounds(379, 64, 208, 22);
		pnl_datos.add(txtApellido);
		txtApellido.setColumns(10);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setEnabled(false);
		lblDireccion.setBounds(10, 90, 70, 22);
		pnl_datos.add(lblDireccion);
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblEmail = new JLabel("Email");
		lblEmail.setEnabled(false);
		lblEmail.setBounds(10, 116, 70, 22);
		pnl_datos.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblNombre = new JLabel("Nombre *");
		lblNombre.setEnabled(false);
		lblNombre.setBounds(10, 64, 70, 22);
		pnl_datos.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblDistrito = new JLabel("Distrito *");
		lblDistrito.setEnabled(false);
		lblDistrito.setBounds(299, 90, 70, 22);
		pnl_datos.add(lblDistrito);
		lblDistrito.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		cboDistrito = new JComboBox();
		cboDistrito.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		cboDistrito.setEnabled(false);
		cboDistrito.setBounds(379, 90, 208, 22);
		pnl_datos.add(cboDistrito);
		
		lblDni = new JLabel("DNI *");
		lblDni.setEnabled(false);
		lblDni.setBounds(597, 64, 70, 22);
		pnl_datos.add(lblDni);
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setEnabled(false);
		lblTelefono.setBounds(597, 90, 70, 22);
		pnl_datos.add(lblTelefono);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblCargo = new JLabel("Cargo *");
		lblCargo.setEnabled(false);
		lblCargo.setBounds(299, 116, 70, 22);
		pnl_datos.add(lblCargo);
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		cboCargo = new JComboBox();
		cboCargo.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		cboCargo.setEnabled(false);
		cboCargo.setBounds(379, 116, 208, 22);
		pnl_datos.add(cboCargo);
		
		txtDireccion = new JTextField();
		txtDireccion.setEnabled(false);
		txtDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		txtDireccion.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtDireccion.setDisabledTextColor(Color.GRAY); // --> 
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(90, 90, 199, 22);
		pnl_datos.add(txtDireccion);
		
		txtEmail = new JTextField();
		txtEmail.setDisabledTextColor(Color.GRAY);
		txtEmail.setEnabled(false);
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(90, 116, 199, 22);
		pnl_datos.add(txtEmail);
		
		txtNombre = new JTextField();
		txtNombre.setDisabledTextColor(Color.GRAY);
		txtNombre.setEnabled(false);
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtNombre.setColumns(10);
		txtNombre.setBounds(90, 64, 199, 22);
		pnl_datos.add(txtNombre);
		
		pnl_codigo = new JPanel();
		pnl_codigo.setBackground(new Color(220, 220, 220));
		pnl_codigo.setBounds(10, 11, 165, 36);
		pnl_datos.add(pnl_codigo);
		pnl_codigo.setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setDisabledTextColor(Color.GRAY);
		txtCodigo.setEnabled(false);
		txtCodigo.setText("-----");
		txtCodigo.setBounds(63, 7, 91, 22);
		pnl_codigo.add(txtCodigo);
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtCodigo.setColumns(10);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 7, 42, 22);
		pnl_codigo.add(lblCodigo);
		lblCodigo.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		
		pnl_acceso = new JPanel();
		pnl_acceso.setBackground(new Color(220, 220, 220));
		pnl_acceso.setBounds(485, 11, 355, 36);
		pnl_datos.add(pnl_acceso);
		pnl_acceso.setLayout(null);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 7, 50, 22);
		pnl_acceso.add(lblUsuario);
		lblUsuario.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(171, 7, 70, 22);
		pnl_acceso.add(lblContrasea);
		lblContrasea.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		
		txtUsuario = new JTextField();
		txtUsuario.setDisabledTextColor(Color.GRAY);
		txtUsuario.setEnabled(false);
		txtUsuario.setText("-----");
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(70, 7, 91, 22);
		pnl_acceso.add(txtUsuario);
		
		txtContraseña = new JTextField();
		txtContraseña.setDisabledTextColor(Color.GRAY);
		txtContraseña.setEnabled(false);
		txtContraseña.setText("-----");
		txtContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		txtContraseña.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(251, 7, 91, 22);
		pnl_acceso.add(txtContraseña);
		
		txtDni = new JTextField();
		txtDni.setDisabledTextColor(Color.GRAY);
		txtDni.setEnabled(false);
		txtDni.setHorizontalAlignment(SwingConstants.CENTER);
		txtDni.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtDni.setColumns(10);
		txtDni.setBounds(677, 64, 163, 22);
		pnl_datos.add(txtDni);
		
		txtTelefono = new JTextField();
		txtTelefono.setDisabledTextColor(Color.GRAY);
		txtTelefono.setEnabled(false);
		txtTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefono.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(677, 90, 163, 22);
		pnl_datos.add(txtTelefono);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setHorizontalAlignment(SwingConstants.LEFT);
		btnNuevo.setIcon(new ImageIcon(Pnl_Content_Empleado.class.getResource("/img/nuevo.png")));
		btnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(474, 151, 110, 30);
		pnl_datos.add(btnNuevo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setHorizontalAlignment(SwingConstants.LEFT);
		btnGuardar.setIcon(new ImageIcon(Pnl_Content_Empleado.class.getResource("/img/guardar.png")));
		btnGuardar.addActionListener(this);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(594, 151, 116, 30);
		pnl_datos.add(btnGuardar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificar.setIcon(new ImageIcon(Pnl_Content_Empleado.class.getResource("/img/modificar.png")));
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificar.setEnabled(false);
		btnModificar.setBounds(720, 151, 120, 30);
		pnl_datos.add(btnModificar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setVisible(false);
		btnCancelar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancelar.setIcon(new ImageIcon(Pnl_Content_Empleado.class.getResource("/img/cancelar.png")));
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(10, 151, 116, 30);
		pnl_datos.add(btnCancelar);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setEnabled(false);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(597, 116, 70, 22);
		pnl_datos.add(lblEstado);
		
		txtActivo = new JTextField();
		txtActivo.setEnabled(false);
		txtActivo.setHorizontalAlignment(SwingConstants.CENTER);
		txtActivo.setFont(new Font("Courier New", Font.BOLD, 14));
		txtActivo.setDisabledTextColor(new Color(0, 80, 0));
		txtActivo.setColumns(10);
		txtActivo.setBounds(722, 116, 118, 22);
		pnl_datos.add(txtActivo);
		
		chEstado = new JCheckBox("");
		chEstado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chEstado.addChangeListener(this);
		chEstado.setEnabled(false);
		chEstado.setBounds(677, 116, 39, 22);
		chEstado.addActionListener(this);
		chEstado.setIcon(new ImageIcon(Pnl_Content_Empleado.class.getResource("/img/off_20px.png")));
		pnl_datos.add(chEstado);
		
		

		
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(95, 103, 112), 2, true));
		panel.setBounds(10, 249, 850, 75);
		pnl_empleado_main.add(panel);
		panel.setLayout(null);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtBuscar.setDisabledTextColor(Color.GRAY);
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(78, 11, 251, 22);
		panel.add(txtBuscar);
		
		lblBuscar = new JLabel("Buscar :");
		lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBuscar.setBounds(10, 11, 58, 22);
		panel.add(lblBuscar);
		
		// RADIO BUTTONS DE BUSQUEDA
		rdbtnNombreapellido = new JRadioButton("Nombre/Apellido");
		rdbtnNombreapellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNombreapellido.setBounds(6, 41, 120, 23);
		panel.add(rdbtnNombreapellido);
		rdbtnNombreapellido.setSelected(true);
		
		rdbtnCodigo = new JRadioButton("Codigo");
		rdbtnCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnCodigo.setBounds(128, 41, 70, 23);
		panel.add(rdbtnCodigo);
		
		rdbtnDni = new JRadioButton("DNI");
		rdbtnDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnDni.setBounds(200, 41, 58, 23);
		panel.add(rdbtnDni);
		
		rdbtnDistrito = new JRadioButton("Distrito");
		rdbtnDistrito.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnDistrito.setBounds(260, 41, 73, 23);
		panel.add(rdbtnDistrito);
		
		ButtonGroup grupBusqueda = new ButtonGroup();
		grupBusqueda.add(rdbtnNombreapellido);
		grupBusqueda.add(rdbtnCodigo);
		grupBusqueda.add(rdbtnDni);
		grupBusqueda.add(rdbtnDistrito);
		
		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(Pnl_Content_Empleado.class.getResource("/img/buscar_53px.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		btnBuscar.setBounds(339, 11, 53, 53);
		panel.add(btnBuscar);
		
		btnExportarTXT = new JButton("");
		btnExportarTXT.setIcon(new ImageIcon(Pnl_Content_Empleado.class.getResource("/img/txt_53px.png")));
		btnExportarTXT.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		btnExportarTXT.addActionListener(this);
		btnExportarTXT.setBounds(661, 11, 53, 53);
		panel.add(btnExportarTXT);
		
		btnExportarXLS = new JButton("");
		btnExportarXLS.setIcon(new ImageIcon(Pnl_Content_Empleado.class.getResource("/img/xlsx_53px.png")));
		btnExportarXLS.addActionListener(this);
		btnExportarXLS.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		btnExportarXLS.setBounds(724, 11, 53, 53);
		panel.add(btnExportarXLS);
		
		btnExportarPDF = new JButton("");
		btnExportarPDF.addActionListener(this);
		btnExportarPDF.setIcon(new ImageIcon(Pnl_Content_Empleado.class.getResource("/img/pdf_53px.png")));
		btnExportarPDF.setBounds(787, 11, 53, 53);
		panel.add(btnExportarPDF);
		
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("DNI");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("DISTRITO");
		modelo.addColumn("CARGO");
		modelo.addColumn("ESTADO");
		tblEmpleado.setModel(modelo);
		
		tblEmpleado.getColumnModel().getColumn(0).setPreferredWidth(20);
		tblEmpleado.getColumnModel().getColumn(1).setPreferredWidth(50);
		tblEmpleado.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblEmpleado.getColumnModel().getColumn(3).setPreferredWidth(40);
		tblEmpleado.getColumnModel().getColumn(4).setPreferredWidth(40);
		tblEmpleado.getColumnModel().getColumn(5).setPreferredWidth(60);
		tblEmpleado.getColumnModel().getColumn(6).setPreferredWidth(50);
		tblEmpleado.getColumnModel().getColumn(7).setPreferredWidth(40);
		
		
		listarDistritoCbo(); // -->
		listarCargosCbo(); // --> 
		mostrarDataTabla(); // --> muestra todos los empleados que existen
		
		
	}
	
	public void listarCargosCbo(){
		
		ArrayList<Cargo> lista = gCargo.listarCargo();
		for(Cargo c : lista){
			cboCargo.addItem(c.getDescripcion());
		}
	}
	
	public void listarDistritoCbo(){
		
		ArrayList<Distrito> lista = gDistrito.listarDistrito();
		for(Distrito d : lista){
			cboDistrito.addItem(d.getDescripcion());
		}
	}

	public void mostrarDataTabla(){
		
		modelo.setRowCount(0);
		ArrayList<Empleado> data = gEmpleado.listar();
		
		/** Para mostrar los primeros al final y los ultimos al inicio **/
		for (int i = data.size()-1; i >=0; i--) {
			
			Object fila[] = {
					data.get(i).getCod_empleado(),
					data.get(i).getNombre(),
					data.get(i).getApellidos(),
					data.get(i).getDni(),
					data.get(i).getTelefono(),
					gDistrito.buscarDistrito(data.get(i).getCod_distrito()).getDescripcion(),
					gCargo.buscarCargo(data.get(i).getCod_cargo()).getDescripcion(),
					estado(data.get(i).getEstado())
					
			};
			modelo.addRow(fila);
		
		}
		
	}
	
	public String estado(Integer n){
		if(n == 1){
			return "ACTIVO";
		}else{
			return "INACTIVO";
		}
	}
	
	public void controles(Boolean activo){ // true
	
		txtApellido.setEnabled(activo);
		txtNombre.setEnabled(activo);
		txtDni.setEnabled(activo);
		txtDireccion.setEnabled(activo);
		txtTelefono.setEnabled(activo);
		txtEmail.setEnabled(activo);
		cboDistrito.setEnabled(activo);
		cboCargo.setEnabled(activo);
		chEstado.setEnabled(activo);
		chEstado.setSelected(activo);
		
		btnCancelar.setVisible(activo);
		btnNuevo.setEnabled(!activo); // << desactivado
		btnGuardar.setEnabled(activo);
		
		txtBuscar.setEnabled(!activo);
		btnBuscar.setEnabled(!activo);
		rdbtnNombreapellido.setEnabled(!activo);
		rdbtnCodigo.setEnabled(!activo);
		rdbtnDni.setEnabled(!activo);
		rdbtnDistrito.setEnabled(!activo);
		lblBuscar.setEnabled(!activo);
		
		lblNombre.setEnabled(activo);
		lblApellido.setEnabled(activo);
		lblDni.setEnabled(activo);
		lblDireccion.setEnabled(activo);
		lblDistrito.setEnabled(activo);
		lblTelefono.setEnabled(activo);
		lblEmail.setEnabled(activo);
		lblCargo.setEnabled(activo);
		lblEstado.setEnabled(activo);
		
	}
	
	public void registrarEmpleado(){
		String codigo = txtCodigo.getText();
		String nombre = txtNombre.getText().trim();
		String apellidos = txtApellido.getText().trim();
		String dni = txtDni.getText().trim();
		String direccion = txtDireccion.getText().trim();
		String telefono = txtTelefono.getText().trim();
		String email = txtEmail.getText().trim();
		int estado = 1;
		if(!chEstado.isSelected()){
			estado = 0;
		}
		
		// obtiene el codigo distrito
		String codDistrito = null;
		Distrito d = gDistrito.buscarDistrito(cboDistrito.getSelectedItem().toString()) ;
		if(d == null){
			mensajeError("Escoge un Distrito");
		}else{
			codDistrito = d.getCod_distrito();
		}
		// obtiene el codigo cargo
		String codCargo = null;
		Cargo c = gCargo.buscarCargo(cboCargo.getSelectedItem().toString()) ;
		if(c == null){
			mensajeError("Escoge un Cargo");
		}else{
			codCargo = c.getCod_cargo();
		}
		
		// -->
		if(nombre.equals("") || apellidos.equals("") || dni.equals("")){
			mensajeError("Error en el ingreso de Datos");
		}else{
			Empleado emp = new Empleado(codigo, nombre, apellidos, dni, direccion, telefono, email, codDistrito, codCargo, estado);
			int respuesta = gEmpleado.registrar(emp);
			
			if(respuesta == 0){
				mensajeError("Error en el Registro");
			}else{
				mostrarDataTabla();
				mensajeExito("Registro Exitoso");
				controles(false);
				txtCodigo.setText("-----");
				limpiarDatos();
				//tblEmpleado.setEnabled(true);
			}
		}
	}
	
	void mensajeError(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje, "Error", 0);
	}
	void mensajeExito(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje, "Sistema ", 1);
	}
	
	void mostrarDatosTextBox(int posicionFila){
		// En la fila de la tabla busca el codigo del empleado, con este codigo se busca en la BD al empleado y trae todos sus datos.
		Empleado emp = new Empleado();
		String codigoFila = tblEmpleado.getValueAt(posicionFila, 0).toString();
		
		emp = gEmpleado.buscarPorCodigo(codigoFila);
		
		txtCodigo.setText(emp.getCod_empleado());
		txtNombre.setText(emp.getNombre());
		txtApellido.setText(emp.getApellidos());
		txtDni.setText(emp.getDni());
		txtDireccion.setText(emp.getDireccion());
		txtTelefono.setText(emp.getTelefono());
		txtEmail.setText(emp.getEmail());
		
		Object objDistrito = gDistrito.buscarDistrito(emp.getCod_distrito()).getDescripcion();
		cboDistrito.setSelectedItem(objDistrito);
		
		Object objCargo = gCargo.buscarCargo(emp.getCod_cargo()).getDescripcion();
		cboCargo.setSelectedItem(objCargo);
		
		txtUsuario.setText(emp.getUsuario());
		txtContraseña.setText(emp.getContraseña());
		
		boolean respuesta = true;
		if(emp.getEstado() != 1){
			respuesta = false;
		}
		chEstado.setSelected(respuesta);
		
	}
	
	void limpiarDatos(){
		//txtCodigo.setText("xxxxx");
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtEmail.setText("");
		cboDistrito.setSelectedIndex(0);
		cboCargo.setSelectedIndex(0);
		txtUsuario.setText("-----");
		txtContraseña.setText("-----");
		
		btnModificar.setEnabled(false);

	}
	
	void actualizarEmpleado(){
		
		String codigo = txtCodigo.getText();
		String nombre = txtNombre.getText().trim();
		String apellidos = txtApellido.getText().trim();
		String dni = txtDni.getText().trim();
		String direccion = txtDireccion.getText().trim();
		String telefono = txtTelefono.getText().trim();
		String email = txtEmail.getText().trim();
		int estado = 1;
		if(!chEstado.isSelected()){
			estado = 0;
		}
		
		// obtiene el codigo distrito
		String codDistrito = null;
		Distrito d = gDistrito.buscarDistrito(cboDistrito.getSelectedItem().toString()) ;
		if(d == null){
			mensajeError("Escoge un Distrito");
		}else{
			codDistrito = d.getCod_distrito();
		}
		// obtiene el codigo cargo
		String codCargo = null;
		Cargo c = gCargo.buscarCargo(cboCargo.getSelectedItem().toString()) ;
		if(c == null){
			mensajeError("Escoge un Cargo");
		}else{
			codCargo = c.getCod_cargo();
		}
		
		// -------------->
		if(nombre.equals("") || apellidos.equals("") || dni.equals("")){
			mensajeError("Error en el ingreso de Datos");
		}else{
			Empleado emp = new Empleado(codigo, nombre, apellidos, dni, direccion, telefono, email, codDistrito, codCargo, estado);
			int respuesta = gEmpleado.actualizar(emp); // <---------
			
			if(respuesta == 0){
				mensajeError("Error al actualizar Datos");
			}else{
				mostrarDataTabla();
				mensajeExito("Modificacion Exitosa");
				controles(false);
				txtCodigo.setText("-----");
				limpiarDatos();
				//tblEmpleado.setEnabled(true);
			}
		}
	}
	
	public ArrayList<Empleado> resultadoBusqueda(){
		
		String valor = txtBuscar.getText().trim();
		
		ArrayList<Empleado> data = new ArrayList<Empleado>();
		Empleado emp = null;
		
		if(rdbtnNombreapellido.isSelected()){
			data = gEmpleado.buscarPorNombre(valor);
		}else if(rdbtnCodigo.isSelected()){
			emp = gEmpleado.buscarPorCodigo(valor);
			if(emp != null){
				data.add(emp);
			}
		}else if(rdbtnDni.isSelected()){
			data = gEmpleado.buscarPorDni(valor);
		}else if(rdbtnDistrito.isSelected()){
			data = gEmpleado.buscarPorDistrito(valor);
		}
		
		return data;
	}
	
	void mostrarResultadoBusquedaTabla(ArrayList<Empleado> data){

		modelo.setRowCount(0);
		
		for (Empleado e : data) {
			
			Object fila[] = {
					e.getCod_empleado(),
					e.getNombre(),
					e.getApellidos(),
					e.getDni(),
					e.getTelefono(),
					gDistrito.buscarDistrito(e.getCod_distrito()).getDescripcion(),
					gCargo.buscarCargo(e.getCod_cargo()).getDescripcion(),
					estado(e.getEstado())
			};
			modelo.addRow(fila);
		}
		
	}
	
	
	/** ----------------------------------------------------------------------------------- **/
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExportarPDF) {
			ArrayList<Empleado> data = resultadoBusqueda();
			if(gEmpleado.exportarPDF(data) == -1){
				mensajeError("No se pudo generar el archivo");
			}
		}
		if (e.getSource() == btnExportarXLS) {
			ArrayList<Empleado> data = resultadoBusqueda();
			if(gEmpleado.exportarXLSX(data) != -1){
				mensajeExito("Se guardo correctamente");
			}else{
				mensajeError("Error al guardar el archivo");
			}
		}
		if (e.getSource() == btnExportarTXT) {
			ArrayList<Empleado> data = resultadoBusqueda();
			if(gEmpleado.exportarTXT(data) != -1){
				mensajeExito("Se guardo correctamente");
			}else{
				mensajeError("Error al guardar el archivo");
			}
		}
		if (e.getSource() == btnBuscar) {
			ArrayList<Empleado> data = resultadoBusqueda();
			mostrarResultadoBusquedaTabla(data);
		}
		if (e.getSource() == btnGuardar) {
			String cod = txtCodigo.getText();
			Empleado emp = gEmpleado.buscarPorCodigo(cod);
			if(emp == null){
				registrarEmpleado();
			}else{
				actualizarEmpleado();
			}
		}
		if (e.getSource() == btnCancelar) {
			txtCodigo.setText("-----");
			controles(false);
			limpiarDatos();
		}
		if (e.getSource() == btnNuevo) {
			txtCodigo.setText(gEmpleado.generarCodigo());
			controles(true);
			limpiarDatos();
		}
		if (e.getSource() == btnModificar) {
			controles(true);
			btnModificar.setEnabled(false);
		}

	}
	/** ----------------------------------------------------------------------------------- **/
	public void mouseClicked(MouseEvent arg0) {
		
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource() == tblEmpleado) {

			int posfila;
			posfila = tblEmpleado.getSelectedRow();
			// si presionas la tabla al iniciar en una zona que no posee datos, la fila seleccionada es "-1"
			if(btnNuevo.isEnabled() && posfila != -1){
				mostrarDatosTextBox(posfila);
				btnModificar.setEnabled(true);
			}

		}
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	/** ----------------------------------------------------------------------------------- **/
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getSource() == txtBuscar) {
			if(arg0.getKeyCode() == KeyEvent.VK_ENTER ) {
				ArrayList<Empleado> data =resultadoBusqueda();
				mostrarResultadoBusquedaTabla(data);
			}
		}
		
	}
	public void keyReleased(KeyEvent arg0) {
		// Por defecto puedes usar el teclado para moverte en la tabla pero los datos de la fila no se muestran en las cajas de textos.
		// Existe un desfase de una fila cuando este evento se realiza en " keyPressed "
		if (arg0.getSource() == tblEmpleado) {
			int posfila;
			posfila = tblEmpleado.getSelectedRow();

			if(btnNuevo.isEnabled() && posfila != -1){
				mostrarDatosTextBox(posfila);
				btnModificar.setEnabled(true);
			}
		}
		
	}
	public void keyTyped(KeyEvent arg0) {
	}
	/** ----------------------------------------------------------------------------------- **/
	public void stateChanged(ChangeEvent arg0) {
		if (arg0.getSource() == chEstado) {
			
			if(chEstado.isSelected()){
			chEstado.setIcon(new ImageIcon(Pnl_Content_Empleado.class.getResource("/img/on_20px.png")));
			txtActivo.setText("ACTIVO");
			txtActivo.setDisabledTextColor(new Color(0, 80, 0));
			}else{
				chEstado.setIcon(new ImageIcon(Pnl_Content_Empleado.class.getResource("/img/off_20px.png")));
				txtActivo.setText("INACTIVO");
				txtActivo.setDisabledTextColor(new Color(80, 0, 0));
			}
		
		}
	}
	
}













//aa
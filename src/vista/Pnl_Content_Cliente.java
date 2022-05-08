package vista;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.ClienteGestionDao;
import Controlador.DistritoGestionDao;
import entidad.Cargo;
import entidad.Cliente;
import entidad.Distrito;
import entidad.Empleado;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Pnl_Content_Cliente extends JPanel implements ActionListener, KeyListener, MouseListener {
	private JPanel pnl_cliente_main;
	private JLabel lblCliente;
	private JPanel pnl_datos;
	private JTable tblCliente;
	private JScrollPane scrollPane;

	private DefaultTableModel modeloCliente = new DefaultTableModel(); // <----
	private ClienteGestionDao gCliente = new ClienteGestionDao();
	private DistritoGestionDao gDistrito = new DistritoGestionDao();
	private JPanel panel_1;
	private JTextField txtCodigo;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblDireccion;
	private JTextField txtDireccion;
	private JLabel lblDistrito;
	private JComboBox cboDistrito;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JPanel panel_2;
	private JTextField txtBuscar;
	private JLabel lblBuscar;
	private JRadioButton rbNombreApellido;
	private JRadioButton rbCodigo;
	private JRadioButton rbDni;
	private JRadioButton rbDistrito;
	private JButton btnBuscar;
	
	/**
	 * Create the panel.
	 */
	public Pnl_Content_Cliente() {
		setLayout(null);
		
		pnl_cliente_main = new JPanel();
		pnl_cliente_main.setBorder(new LineBorder(utils.Library.Claro_2));
		pnl_cliente_main.setBounds(0, 0, 870, 670);
		add(pnl_cliente_main);
		pnl_cliente_main.setLayout(null);
		
		lblCliente = new JLabel("CLIENTE");
		lblCliente.setOpaque(true);
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setForeground(SystemColor.menu);
		lblCliente.setFont(new Font("Courier New", Font.BOLD, 20));
		lblCliente.setBackground(SystemColor.controlDkShadow);
		lblCliente.setBounds(10, 11, 850, 24);
		pnl_cliente_main.add(lblCliente);
		
		pnl_datos = new JPanel();
		pnl_datos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.GRAY));
		pnl_datos.setBounds(10, 46, 850, 192);
		pnl_cliente_main.add(pnl_datos);
		pnl_datos.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 11, 165, 42);
		pnl_datos.add(panel_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("xxxxx");
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtCodigo.setEnabled(false);
		txtCodigo.setDisabledTextColor(Color.GRAY);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(63, 10, 91, 22);
		panel_1.add(txtCodigo);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblCodigo.setBounds(10, 10, 42, 22);
		panel_1.add(lblCodigo);
		
		lblNombre = new JLabel("Nombre *");
		lblNombre.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblNombre.setEnabled(false);
		lblNombre.setBounds(10, 64, 70, 22);
		pnl_datos.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtNombre.setEnabled(false);
		txtNombre.setDisabledTextColor(Color.GRAY);
		txtNombre.setColumns(10);
		txtNombre.setBounds(90, 64, 228, 22);
		pnl_datos.add(txtNombre);
		
		lblApellido = new JLabel("Apellido *");
		lblApellido.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblApellido.setEnabled(false);
		lblApellido.setBounds(328, 64, 70, 22);
		pnl_datos.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellido.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtApellido.setEnabled(false);
		txtApellido.setDisabledTextColor(Color.GRAY);
		txtApellido.setColumns(10);
		txtApellido.setBounds(408, 64, 228, 22);
		pnl_datos.add(txtApellido);
		
		lblDni = new JLabel("DNI *");
		lblDni.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblDni.setEnabled(false);
		lblDni.setBounds(328, 90, 70, 22);
		pnl_datos.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setHorizontalAlignment(SwingConstants.CENTER);
		txtDni.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtDni.setEnabled(false);
		txtDni.setDisabledTextColor(Color.GRAY);
		txtDni.setColumns(10);
		txtDni.setBounds(408, 90, 150, 22);
		pnl_datos.add(txtDni);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblDireccion.setEnabled(false);
		lblDireccion.setBounds(10, 90, 70, 22);
		pnl_datos.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		txtDireccion.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtDireccion.setEnabled(false);
		txtDireccion.setDisabledTextColor(Color.GRAY);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(90, 90, 228, 22);
		pnl_datos.add(txtDireccion);
		
		lblDistrito = new JLabel("Distrito *");
		lblDistrito.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblDistrito.setEnabled(false);
		lblDistrito.setBounds(328, 116, 70, 22);
		pnl_datos.add(lblDistrito);
		
		cboDistrito = new JComboBox();
		cboDistrito.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		cboDistrito.setEnabled(false);
		cboDistrito.setBounds(408, 116, 150, 22);
		pnl_datos.add(cboDistrito);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblTelefono.setEnabled(false);
		lblTelefono.setBounds(568, 90, 70, 22);
		pnl_datos.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefono.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtTelefono.setEnabled(false);
		txtTelefono.setDisabledTextColor(Color.GRAY);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(648, 90, 150, 22);
		pnl_datos.add(txtTelefono);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblEmail.setEnabled(false);
		lblEmail.setBounds(10, 116, 70, 22);
		pnl_datos.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtEmail.setEnabled(false);
		txtEmail.setDisabledTextColor(Color.GRAY);
		txtEmail.setColumns(10);
		txtEmail.setBounds(90, 116, 228, 22);
		pnl_datos.add(txtEmail);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setVisible(false);
		btnCancelar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		btnCancelar.setBounds(10, 158, 100, 23);
		pnl_datos.add(btnCancelar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setEnabled(false);
		btnModificar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		btnModificar.setBounds(740, 158, 100, 23);
		pnl_datos.add(btnModificar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setEnabled(false);
		btnGuardar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		btnGuardar.setBounds(630, 158, 100, 23);
		pnl_datos.add(btnGuardar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		btnNuevo.setBounds(520, 158, 100, 23);
		pnl_datos.add(btnNuevo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 341, 850, 318);
		pnl_cliente_main.add(scrollPane);
		
		tblCliente = new JTable();
		tblCliente.addMouseListener(this);
		tblCliente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCliente);
		
		modeloCliente.addColumn("CODIGO");
		modeloCliente.addColumn("NOMBRE");
		modeloCliente.addColumn("APELLIDOS");
		modeloCliente.addColumn("DNI");
		modeloCliente.addColumn("TELEFONO");
		modeloCliente.addColumn("DISTRITO");
		tblCliente.setModel(modeloCliente);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.text, SystemColor.windowBorder));
		panel_2.setBounds(10, 249, 850, 81);
		pnl_cliente_main.add(panel_2);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtBuscar.setDisabledTextColor(Color.GRAY);
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(90, 11, 228, 22);
		panel_2.add(txtBuscar);
		
		lblBuscar = new JLabel("Buscar :");
		lblBuscar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblBuscar.setBounds(10, 11, 70, 22);
		panel_2.add(lblBuscar);
		
		rbNombreApellido = new JRadioButton("Nombre/Apellido");
		rbNombreApellido.setSelected(true);
		rbNombreApellido.setBounds(6, 41, 120, 23);
		panel_2.add(rbNombreApellido);
		
		rbCodigo = new JRadioButton("Codigo");
		rbCodigo.setBounds(128, 41, 70, 23);
		panel_2.add(rbCodigo);
		
		rbDni = new JRadioButton("DNI");
		rbDni.setBounds(200, 41, 58, 23);
		panel_2.add(rbDni);
		
		rbDistrito = new JRadioButton("Distrito");
		rbDistrito.setBounds(260, 41, 73, 23);
		panel_2.add(rbDistrito);
		
		ButtonGroup grupBusqueda = new ButtonGroup();
		grupBusqueda.add(rbNombreApellido);
		grupBusqueda.add(rbCodigo);
		grupBusqueda.add(rbDni);
		grupBusqueda.add(rbDistrito);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		btnBuscar.setBounds(328, 10, 100, 23);
		panel_2.add(btnBuscar);
		
		mostrarDataTabla();
		listarDistritoCbo();
		
	}
	
	public void listarDistritoCbo(){
		
		ArrayList<Distrito> lista = gDistrito.listarDistrito();
		for(Distrito d : lista){
			cboDistrito.addItem(d.getDescripcion());
		}
	}
	
	public void mostrarDataTabla(){
		
		modeloCliente.setRowCount(0);
		ArrayList<Cliente> data = gCliente.listar();
		
		for (Cliente c : data) {
			
			Object fila[] = {
					c.getCod_cliente(),
					c.getNombre(),
					c.getApellidos(),
					c.getDni(),
					c.getTelefono(),
					c.getCod_distrito(),
					
			};
			modeloCliente.addRow(fila);
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
		
		btnCancelar.setVisible(activo);
		btnNuevo.setEnabled(!activo); // << desactivado
		btnGuardar.setEnabled(activo);
		
		txtBuscar.setEnabled(!activo);
		btnBuscar.setEnabled(!activo);
		lblBuscar.setEnabled(!activo);
		rbNombreApellido.setEnabled(!activo);
		rbCodigo.setEnabled(!activo);
		rbDni.setEnabled(!activo);
		rbDistrito.setEnabled(!activo);
		
		lblNombre.setEnabled(activo);
		lblApellido.setEnabled(activo);
		lblDni.setEnabled(activo);
		lblDireccion.setEnabled(activo);
		lblDistrito.setEnabled(activo);
		lblTelefono.setEnabled(activo);
		lblEmail.setEnabled(activo);
		
		
	}
	
	public void registrarCliente(){
		String codigo = txtCodigo.getText().trim();
		String nombre = txtNombre.getText().trim();
		String apellidos = txtApellido.getText().trim();
		String dni = txtDni.getText().trim();
		String direccion = txtDireccion.getText().trim();
		String telefono = txtTelefono.getText().trim();
		String email = txtEmail.getText().trim();
		
		// obtiene el codigo distrito
		String codDistrito = null;
		Distrito d = gDistrito.buscarDistrito(cboDistrito.getSelectedItem().toString()) ;
		if(d == null){
			mensajeError("Escoge un Distrito");
		}else{
			codDistrito = d.getCod_distrito();
		}

		// -->
		if(codigo.equals("") || nombre.equals("") || apellidos.equals("") || dni.equals("")){
			mensajeError("Error en el ingreso de Datos");
		}else{
			Cliente cli = new Cliente(codigo, nombre, apellidos, dni, direccion, telefono, email, codDistrito);
			int respuesta = gCliente.registrar(cli);
			
			if(respuesta == 0){
				mensajeError("Error en el Registro");
			}else{
				mostrarDataTabla();
				mensajeExito("Registro Exitoso");
				controles(false);
				txtCodigo.setText("xxxxx");
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
		Cliente cli = new Cliente();
		String codigoFila = tblCliente.getValueAt(posicionFila, 0).toString();
		cli = gCliente.buscarPorCodigo(codigoFila);
		
		txtCodigo.setText(cli.getCod_cliente());
		txtNombre.setText(cli.getNombre());
		txtApellido.setText(cli.getApellidos());
		txtDni.setText(cli.getDni());
		txtDireccion.setText(cli.getDireccion());
		txtTelefono.setText(cli.getTelefono());
		txtEmail.setText(cli.getEmail());
		
		Object objDistrito = gDistrito.buscarDistrito(cli.getCod_distrito()).getDescripcion();
		cboDistrito.setSelectedItem(objDistrito);
		
		
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
		
		btnModificar.setEnabled(false);

	}
	
	void actualizarCliente(){
		
		String codigo = txtCodigo.getText().trim();
		String nombre = txtNombre.getText().trim();
		String apellidos = txtApellido.getText().trim();
		String dni = txtDni.getText().trim();
		String direccion = txtDireccion.getText().trim();
		String telefono = txtTelefono.getText().trim();
		String email = txtEmail.getText().trim();
		
		// obtiene el codigo distrito
		String codDistrito = null;
		Distrito d = gDistrito.buscarDistrito(cboDistrito.getSelectedItem().toString()) ;
		if(d == null){
			mensajeError("Escoge un Distrito");
		}else{
			codDistrito = d.getCod_distrito();
		}
		
		// -------------->
		if(codigo.equals("") || nombre.equals("") || apellidos.equals("") || dni.equals("")){
			mensajeError("Error en el ingreso de Datos");
		}else{
			Cliente cli = new Cliente(codigo, nombre, apellidos, dni, direccion, telefono, email, codDistrito);
			int respuesta = gCliente.actualizar(cli); // <---------
			
			if(respuesta == 0){
				mensajeError("Error al actualizar Datos");
			}else{
				mostrarDataTabla();
				mensajeExito("Modificacion Exitosa");
				controles(false);
				txtCodigo.setText("xxxxx");
				limpiarDatos();
				//tblEmpleado.setEnabled(true);
			}
		}
	}
	
	void buscarCliente(){
		
		String valor = txtBuscar.getText();
		modeloCliente.setRowCount(0);
		
		ArrayList<Cliente> data = new ArrayList<Cliente>();
		Cliente cli = null;
		
		if(rbNombreApellido.isSelected()){
			data = gCliente.buscarPorNombre(valor);
		}else if(rbCodigo.isSelected()){
			cli = gCliente.buscarPorCodigo(valor);
			if(cli != null){
				data.add(cli);
			}
		}else if(rbDni.isSelected()){
			data = gCliente.buscarPorDni(valor);
		}else if(rbDistrito.isSelected()){
			data = gCliente.buscarPorDistrito(valor);
		}
		
		for (Cliente c : data) {
			
			Object fila[] = {
					c.getCod_cliente(),
					c.getNombre(),
					c.getApellidos(),
					c.getDni(),
					c.getTelefono(),
					c.getCod_distrito(),
					
			};
			modeloCliente.addRow(fila);
		}
		
	}
	/** -------------------------------------------- **/
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			controles(true);
			btnModificar.setEnabled(false);
		}
		if (e.getSource() == btnGuardar) {
			String cod = txtCodigo.getText();
			Cliente cli = gCliente.buscarPorCodigo(cod);
			if(cli == null){
				registrarCliente();
			}else{
				actualizarCliente();
			}
		}
		if (e.getSource() == btnBuscar) {
			buscarCliente();
		}
		if (e.getSource() == btnNuevo) {
			txtCodigo.setText(gCliente.generarCodigo());
			controles(true);
			limpiarDatos();
		}
		if (e.getSource() == btnCancelar) {
			txtCodigo.setText("xxxxx");
			controles(false);
			limpiarDatos();
		}
	}
	/** -------------------------------------------- **/
	public void mouseClicked(MouseEvent arg0) {
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource() == tblCliente) {
			
			int posfila;
			
			if(btnNuevo.isEnabled()){
				posfila = tblCliente.getSelectedRow();
				mostrarDatosTextBox(posfila);
				btnModificar.setEnabled(true);
			}
			
		}
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	/** -------------------------------------------- **/
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getSource() == txtBuscar) {
			if(arg0.getKeyCode() == KeyEvent.VK_ENTER ) {
				buscarCliente();
			}
		}
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
	}
	/** -------------------------------------------- **/

}




















//aa

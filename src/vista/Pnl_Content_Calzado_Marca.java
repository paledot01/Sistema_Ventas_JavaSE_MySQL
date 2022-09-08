package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.MarcaGestionDao;
import entidad.Marca;
import utils.Library;
import utils.RendererTableSimple;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Pnl_Content_Calzado_Marca extends JPanel implements ActionListener, MouseListener, KeyListener {
	private JPanel pnl_marca;
	private JPanel panel_1;
	private JTextField txtCodigo;
	private JLabel label;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JTable tblMarca;
	private JScrollPane scrollPane;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JButton btnNuevo;

	
	private DefaultTableModel modelo;
	private MarcaGestionDao gMarca = new MarcaGestionDao();
	RendererTableSimple render = new RendererTableSimple(); // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	
	
	public Pnl_Content_Calzado_Marca() {
		setLayout(null);
		
		pnl_marca = new JPanel();
		pnl_marca.setBorder(new LineBorder( Library.Claro_2 , 2));
		pnl_marca.setBounds(0, 0, 500, 304);
		add(pnl_marca);
		pnl_marca.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(10, 11, 165, 36);
		pnl_marca.add(panel_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("-----");
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		txtCodigo.setEnabled(false);
		txtCodigo.setDisabledTextColor(Color.GRAY);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(63, 7, 91, 22);
		panel_1.add(txtCodigo);
		
		label = new JLabel("Codigo");
		label.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		label.setBounds(10, 7, 42, 22);
		panel_1.add(label);
		
		lblNombre = new JLabel("Nombre *");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setEnabled(false);
		lblNombre.setBounds(10, 58, 55, 22);
		pnl_marca.add(lblNombre);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 134, 480, 159);
		pnl_marca.add(scrollPane);
		
		tblMarca = new JTable();
		tblMarca.addKeyListener(this);
		tblMarca.addMouseListener(this);
		tblMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblMarca.setBorder(new LineBorder( Library.Claro_2 ));
		tblMarca.setFillsViewportHeight(true);
		tblMarca.setDefaultRenderer(Object.class, render);
		scrollPane.setViewportView(tblMarca);
		
		/** ------------------------------------------------------------- **/
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRE MARCA");
		tblMarca.setModel(modelo);
		
		tblMarca.getColumnModel().getColumn(0).setPreferredWidth(50);
		tblMarca.getColumnModel().getColumn(1).setPreferredWidth(50);
		
		
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		txtNombre.setEnabled(false);
		txtNombre.setDisabledTextColor(Color.GRAY);
		txtNombre.setColumns(10);
		txtNombre.setBounds(82, 58, 150, 22);
		pnl_marca.add(txtNombre);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscar.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		txtBuscar.setDisabledTextColor(Color.GRAY);
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(254, 15, 196, 22);
		pnl_marca.add(txtBuscar);
		
		btnBuscar = new JButton("");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(Pnl_Content_Calzado_Marca.class.getResource("/img/buscar_30px.png")));
		btnBuscar.setBounds(460, 11, 30, 30);
		pnl_marca.add(btnBuscar);
		
		btnModificar = new JButton("");
		btnModificar.addActionListener(this);
		btnModificar.setEnabled(false);
		btnModificar.setIcon(new ImageIcon(Pnl_Content_Calzado_Marca.class.getResource("/img/modificar.png")));
		btnModificar.setBounds(460, 93, 30, 30);
		pnl_marca.add(btnModificar);
		
		btnCancelar = new JButton("");
		btnCancelar.addActionListener(this);
		btnCancelar.setVisible(false);
		btnCancelar.setIcon(new ImageIcon(Pnl_Content_Calzado_Marca.class.getResource("/img/cancelar.png")));
		btnCancelar.setBounds(10, 93, 30, 30);
		pnl_marca.add(btnCancelar);
		
		btnGuardar = new JButton("");
		btnGuardar.addActionListener(this);
		btnGuardar.setEnabled(false);
		btnGuardar.setIcon(new ImageIcon(Pnl_Content_Calzado_Marca.class.getResource("/img/guardar.png")));
		btnGuardar.setBounds(420, 93, 30, 30);
		pnl_marca.add(btnGuardar);
		
		btnNuevo = new JButton("");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(Pnl_Content_Calzado_Marca.class.getResource("/img/nuevo.png")));
		btnNuevo.setBounds(380, 93, 30, 30);
		pnl_marca.add(btnNuevo);

	
		MostrarDataTabla(); // --> Muestra los datos de la tabla Categoria
		
	}
	
	void MostrarDataTabla(){
		
		modelo.setRowCount(0);
		ArrayList<Marca> data = gMarca.listarOriginal();
		
		for( int i = data.size()-1 ; i>=0 ; i-- ){
			
			Object fila[] = {
				data.get(i).getCod_marca(),
				data.get(i).getNombre_marca()
			};
			modelo.addRow(fila);
		}
		
	}
	
	public void controles(Boolean activo){
		
		lblNombre.setEnabled(activo);
		txtNombre.setEnabled(activo);
		
		txtBuscar.setEnabled( !activo );
		btnBuscar.setEnabled( !activo );
		
		btnCancelar.setVisible(activo);
		btnNuevo.setEnabled(!activo); // << desactivado
		btnGuardar.setEnabled(activo);
		
	}
	
	void limpiarDatos(){
		
		txtNombre.setText("");
		btnModificar.setEnabled(false);
	}
	
	
	public void registrarMarca(){
		
		String codigo = txtCodigo.getText();
		String nombre = txtNombre.getText().trim();
		
		
		if(nombre.equals("") ){
			mensajeError("Error en el ingreso de Datos");
		}else{
			Marca mar = new Marca(codigo, nombre);
			int respuesta = gMarca.registrar(mar);
			
			if ( respuesta <= 0 ) {
				mensajeError("Error en el Registro");
			}else{
				MostrarDataTabla();
				mensajeExito("Registro Exitoso");
				controles(false);
				txtCodigo.setText("-----");
				limpiarDatos();
			}
		}
		
	}
	
	void mostrarDatosTextBox(int posicionFila){
		
		Marca mar = new Marca();
		String codigoFila = tblMarca.getValueAt(posicionFila, 0).toString();
		
		mar = gMarca.buscarOrgAllIxt(codigoFila).get(0);
		
		txtCodigo.setText( mar.getCod_marca() );
		txtNombre.setText( mar.getNombre_marca() );
		
	}
	
	void mensajeError( String mensaje ){
		JOptionPane.showMessageDialog(this, mensaje, "Error", 0);
	}
	void mensajeExito(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje, "Sistema ", 1);
	}
	
	
	void actualizarMarca(){
		
		String codigo = txtCodigo.getText();
		String nombre = txtNombre.getText().trim();
		
		if(nombre.equals("")){
			mensajeError("Error en el ingreso de Datos");
		}else{
			Marca mar = new Marca(codigo, nombre);
			
			int respuesta = gMarca.actualizar(mar);
			
			if( respuesta <= 0 ){
				mensajeError("Error al actualizar Datos");
			}else{
				MostrarDataTabla();
				mensajeExito("Actualizacion Exitosa");
				controles(false);
				txtCodigo.setText("-----");
				limpiarDatos();
			}
			
		}
		
	}
	
	public ArrayList<Marca> resultadoBusqueda(){
		
		String valor = txtBuscar.getText();
		
		ArrayList<Marca> data = new ArrayList<Marca>();
		
		data = gMarca.buscarOrgAllIxt(valor);
		
		return data;
		
	}
	
	void mostrarResultadoBusquedaTabla( ArrayList<Marca> data ){
		
		modelo.setRowCount(0);
		
		for( Marca mar : data ){
			
			Object fila[] = {
					mar.getCod_marca(),
					mar.getNombre_marca()
					
			};
			modelo.addRow(fila);
		}
	}
	
	/** ----------------------------------------------------------------------------------- **/
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			ArrayList<Marca> data = resultadoBusqueda();
			mostrarResultadoBusquedaTabla(data);
		}
		if (arg0.getSource() == btnModificar) {
			controles(true);
			btnModificar.setEnabled(false);
		}
		if (arg0.getSource() == btnGuardar) {
			String cod = txtCodigo.getText();
			ArrayList<Marca> mar = gMarca.buscarOrgAllIxt(cod);
			
			if(mar.size() != 1){
				registrarMarca();
			}else{
				actualizarMarca();
			}
		}
		if (arg0.getSource() == btnCancelar) {
			txtCodigo.setText("-----");
			controles(false);
			limpiarDatos();
		}
		if (arg0.getSource() == btnNuevo) {
			txtCodigo.setText( gMarca.generarCodigo() );
			controles(true);
			limpiarDatos();
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
		if (arg0.getSource() == tblMarca) {
			
			int posfila;
			posfila = tblMarca.getSelectedRow();
			
			if(btnNuevo.isEnabled() && posfila != -1 ){
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
			
			if( arg0.getKeyCode() == KeyEvent.VK_ENTER ){
				ArrayList<Marca> data = resultadoBusqueda();
				mostrarResultadoBusquedaTabla(data);
			}
			
		}
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == tblMarca) {
			
			int posfila;
			posfila = tblMarca.getSelectedRow();
			
			if(btnNuevo.isEnabled() && posfila != -1 ){
				mostrarDatosTextBox(posfila);
				btnModificar.setEnabled(true);
			}
			
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}

}





























// ------------

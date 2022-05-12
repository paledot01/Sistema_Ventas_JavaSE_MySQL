package vista;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.CategoriaGestionDao;
import entidad.Categoria;
import utils.Library;
import utils.RendererTable2;

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
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Pnl_Content_Calzado_Categoria extends JPanel implements ActionListener, MouseListener, KeyListener {
	private JPanel panel;
	private JPanel panel_1;
	private JTextField txtCodigo;
	private JLabel label;
	private JTable tblCategoria;
	private JScrollPane scrollPane;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JButton btnBuscar;
	private JTextField txtBuscar;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnGuardar;
	private JButton btnNuevo;

	private DefaultTableModel modelo;
	private CategoriaGestionDao gCategoria = new CategoriaGestionDao();
	RendererTable2 render = new RendererTable2(); // <<<<<<<<<<<<<<<<<<<<<<<<<<<
	
	
	
	/**
	 * Create the panel.
	 */
	public Pnl_Content_Calzado_Categoria() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder( Library.Claro_2 , 2));
		panel.setBounds(0, 0, 500, 304);
		add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(10, 11, 165, 36);
		panel.add(panel_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("xxxxx");
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 134, 480, 159);
		panel.add(scrollPane);
		
		tblCategoria = new JTable();
		tblCategoria.addKeyListener(this);
		tblCategoria.addMouseListener(this);
		tblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblCategoria.setBorder(new LineBorder( Library.Claro_2 ));
		tblCategoria.setFillsViewportHeight(true);
		tblCategoria.setDefaultRenderer(Object.class, render);
		scrollPane.setViewportView(tblCategoria);
		
		/** ------------------------------------------------------------- **/
		modelo = new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRE CATEGORIA");
		tblCategoria.setModel(modelo);
		
		tblCategoria.getColumnModel().getColumn(0).setPreferredWidth(50);
		tblCategoria.getColumnModel().getColumn(1).setPreferredWidth(50);
		
		
		
		lblNombre = new JLabel("Nombre *");
		lblNombre.setEnabled(false);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(10, 58, 55, 22);
		panel.add(lblNombre);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscar.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		txtBuscar.setDisabledTextColor(Color.GRAY);
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(254, 15, 196, 22);
		panel.add(txtBuscar);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		txtNombre.setDisabledTextColor(Color.GRAY);
		txtNombre.setColumns(10);
		txtNombre.setBounds(82, 58, 150, 22);
		panel.add(txtNombre);
		
		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(Pnl_Content_Calzado_Categoria.class.getResource("/img/buscar_30px.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(460, 11, 30, 30);
		panel.add(btnBuscar);
		
		btnCancelar = new JButton("");
		btnCancelar.addActionListener(this);
		btnCancelar.setVisible(false);
		btnCancelar.setIcon(new ImageIcon(Pnl_Content_Calzado_Categoria.class.getResource("/img/cancelarr.png")));
		btnCancelar.setBounds(10, 93, 30, 30);
		panel.add(btnCancelar);
		
		btnModificar = new JButton("");
		btnModificar.addActionListener(this);
		btnModificar.setEnabled(false);
		btnModificar.setIcon(new ImageIcon(Pnl_Content_Calzado_Categoria.class.getResource("/img/modificar.png")));
		btnModificar.setBounds(460, 93, 30, 30);
		panel.add(btnModificar);
		
		btnGuardar = new JButton("");
		btnGuardar.addActionListener(this);
		btnGuardar.setEnabled(false);
		btnGuardar.setIcon(new ImageIcon(Pnl_Content_Calzado_Categoria.class.getResource("/img/guardar.png")));
		btnGuardar.setBounds(420, 93, 30, 30);
		panel.add(btnGuardar);
		
		btnNuevo = new JButton("");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(Pnl_Content_Calzado_Categoria.class.getResource("/img/nuevo.png")));
		btnNuevo.setBounds(380, 93, 30, 30);
		panel.add(btnNuevo);

		
		MostrarDataTabla(); // --> Muestra los datos de la tabla Categoria
		
	}
	
	void MostrarDataTabla(){
		
		modelo.setRowCount(0);
		ArrayList<Categoria> data = gCategoria.listar();
		
		for( int i = data.size()-1 ; i>=0 ; i-- ){
			
			Object fila[] = {
				data.get(i).getCod_categoria(),
				data.get(i).getDescripcion()
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
	
	public void registrarCategoria(){
		
		String codigo = txtCodigo.getText();
		String nombre = txtNombre.getText().trim();
		
		
		if(codigo.equals("") || nombre.equals("") ){
			mensajeError("Error en el ingreso de Datos");
		}else{
			Categoria cat = new Categoria(codigo, nombre);
			int respuesta = gCategoria.registrar(cat);
			
			if ( respuesta <= 0 ) {
				mensajeError("Error en el Registro");
			}else{
				MostrarDataTabla();
				mensajeExito("Registro Exitoso");
				controles(false);
				txtCodigo.setText("xxxxx");
				limpiarDatos();
			}
		}
		
	}
	
	void mostrarDatosTextBox(int posicionFila){
		
		Categoria cat = new Categoria();
		String codigoFila = tblCategoria.getValueAt(posicionFila, 0).toString();
		
		cat = gCategoria.buscar(codigoFila).get(0);
		
		txtCodigo.setText( cat.getCod_categoria() );
		txtNombre.setText( cat.getDescripcion() );
		
	}
	
	
	void actualizarCategoria(){
		
		String codigo = txtCodigo.getText().trim();
		String nombre = txtNombre.getText().trim();
		
		if(  codigo.equals("") || nombre.equals("") ){
			mensajeError("Error en el ingreso de Datos");
		}else{
			Categoria cat = new Categoria(codigo, nombre);
			
			int respuesta = gCategoria.actualizar(cat);
			
			if( respuesta <= 0 ){
				mensajeError("Error al actualizar Datos");
			}else{
				MostrarDataTabla();
				mensajeExito("Actualizacion Exitosa");
				controles(false);
				txtCodigo.setText("xxxxx");
				limpiarDatos();
			}
			
		}
		
	}
	
	void mensajeError( String mensaje ){
		JOptionPane.showMessageDialog(this, mensaje, "Error", 0);
	}
	void mensajeExito(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje, "Sistema ", 1);
	}
	
	public ArrayList<Categoria> resultadoBusqueda(){
		
		String valor = txtBuscar.getText();
		
		ArrayList<Categoria> data = new ArrayList<Categoria>();
		
		data = gCategoria.buscar(valor);
		
		return data;
		
	}
	
	void mostrarResultadoBusquedaTabla( ArrayList<Categoria> data ){
		
		modelo.setRowCount(0);
		
		for( Categoria cat : data ){
			
			Object fila[] = {
					cat.getCod_categoria(),
					cat.getDescripcion()
					
			};
			modelo.addRow(fila);
		}
	}
	
	/** ----------------------------------------------------------------------------------- **/
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			ArrayList<Categoria> data = resultadoBusqueda();
			mostrarResultadoBusquedaTabla(data);
		}
		if (arg0.getSource() == btnModificar) {
			controles(true);
			btnModificar.setEnabled(false);
		}
		if (arg0.getSource() == btnGuardar) {
			String cod = txtCodigo.getText();
			ArrayList<Categoria> cat = gCategoria.buscar(cod);
			
			if(cat.size() != 1){
				registrarCategoria();
			}else{
				actualizarCategoria();
			}
		}
		if (arg0.getSource() == btnCancelar) {
			txtCodigo.setText("xxxxx");
			controles(false);
			limpiarDatos();
		}
		if (arg0.getSource() == btnNuevo) {
			txtCodigo.setText( gCategoria.generarCodigo() );
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
		if (arg0.getSource() == tblCategoria) {
			
			int posfila;
			posfila = tblCategoria.getSelectedRow();
			
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
				ArrayList<Categoria> data = resultadoBusqueda();
				mostrarResultadoBusquedaTabla(data);
			}
			
		}

	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == tblCategoria) {
			int posfila;
			posfila = tblCategoria.getSelectedRow();
			
			if(btnNuevo.isEnabled() && posfila != -1 ){
				mostrarDatosTextBox(posfila);
				btnModificar.setEnabled(true);
			}
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}

	/** ----------------------------------------------------------------------------------- **/
	
}















// ------

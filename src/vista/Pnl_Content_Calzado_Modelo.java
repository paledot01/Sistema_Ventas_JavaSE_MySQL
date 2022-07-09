
package vista;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.CategoriaGestionDao;
import Controlador.MarcaGestionDao;
import Controlador.ModeloGestionDao;
import entidad.Categoria;
import entidad.Marca;
import entidad.Modelo;
import utils.RendererTable6;

import javax.swing.JScrollPane;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ComponentEvent;

public class Pnl_Content_Calzado_Modelo extends JPanel implements ActionListener, MouseListener, KeyListener, ComponentListener {
	private JPanel pnl_content_calzado_modelo;
	private JTable tblModelo;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JTextField txtCodigo;
	private JLabel label;
	private JTextField txtBuscar;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JLabel lblCategoria;
	private JLabel lblMarca;
	private JButton btnModificar;
	private JTextField txtPc;
	private JLabel lblPc;
	private JButton btnBuscar;
	private JButton btnGuardar;
	private JLabel lblPv;
	private JComboBox cboCategoria;
	private JComboBox cboMarca;
	private JTextField txtPv;
	private JButton btnCancelar;
	
	public static JButton btnNuevo;
	public static JButton btnEnviar;
	
	private ModeloGestionDao gModelo = new ModeloGestionDao();
	private MarcaGestionDao gMarca = new MarcaGestionDao();
	private CategoriaGestionDao gCategoria = new CategoriaGestionDao();
	private DefaultTableModel modelo; // <<<<<<<<

	RendererTable6 render = new RendererTable6(); // <<<<<<<<<<<<<<<<<<<
	
	
	
	public Pnl_Content_Calzado_Modelo() {
		setLayout(null);
		
		pnl_content_calzado_modelo = new JPanel();
		pnl_content_calzado_modelo.setBorder(new LineBorder(new Color(95, 103, 112), 2));
		pnl_content_calzado_modelo.setBounds(0, 0, 500, 304);
		add(pnl_content_calzado_modelo);
		pnl_content_calzado_modelo.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 144, 480, 149);
		pnl_content_calzado_modelo.add(scrollPane);
		
		/** ------------------------------------------------------------- **/
		tblModelo = new JTable();
		tblModelo.addKeyListener(this);
		tblModelo.addMouseListener(this);
		tblModelo.setBorder(new LineBorder(new Color(95, 103, 112)));
		tblModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblModelo.setFillsViewportHeight(true);
		tblModelo.setDefaultRenderer(Object.class, render); // <<<<<<<<<<<<<<<<<<<<<<<<<<
		scrollPane.setViewportView(tblModelo);

		modelo = new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("MARCA");
		modelo.addColumn("CATEGORIA");
		modelo.addColumn("P.C");
		modelo.addColumn("P.V");
		tblModelo.setModel(modelo);
		
		
		tblModelo.getColumnModel().getColumn(0).setPreferredWidth(30);
		tblModelo.getColumnModel().getColumn(1).setPreferredWidth(75);
		tblModelo.getColumnModel().getColumn(2).setPreferredWidth(75);
		tblModelo.getColumnModel().getColumn(3).setPreferredWidth(60);
		tblModelo.getColumnModel().getColumn(4).setPreferredWidth(30);
		tblModelo.getColumnModel().getColumn(5).setPreferredWidth(30);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(10, 11, 165, 36);
		pnl_content_calzado_modelo.add(panel);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("-----");
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		txtCodigo.setEnabled(false);
		txtCodigo.setDisabledTextColor(Color.GRAY);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(63, 7, 91, 22);
		panel.add(txtCodigo);
		
		label = new JLabel("Codigo");
		label.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		label.setBounds(10, 7, 42, 22);
		panel.add(label);
		
		lblNombre = new JLabel("Nombre *");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setEnabled(false);
		lblNombre.setBounds(10, 59, 55, 22);
		pnl_content_calzado_modelo.add(lblNombre);
		
		lblCategoria = new JLabel("Categoria *");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCategoria.setEnabled(false);
		lblCategoria.setBounds(10, 85, 62, 22);
		pnl_content_calzado_modelo.add(lblCategoria);
		
		lblMarca = new JLabel("Marca *");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMarca.setEnabled(false);
		lblMarca.setBounds(10, 111, 48, 22);
		pnl_content_calzado_modelo.add(lblMarca);
		
		lblPv = new JLabel("P.V");
		lblPv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPv.setEnabled(false);
		lblPv.setBounds(217, 85, 27, 22);
		pnl_content_calzado_modelo.add(lblPv);
		
		lblPc = new JLabel("P.C");
		lblPc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPc.setEnabled(false);
		lblPc.setBounds(217, 59, 27, 22);
		pnl_content_calzado_modelo.add(lblPc);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscar.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		txtBuscar.setDisabledTextColor(Color.GRAY);
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(254, 15, 196, 22);
		pnl_content_calzado_modelo.add(txtBuscar);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		txtNombre.setDisabledTextColor(Color.GRAY);
		txtNombre.setColumns(10);
		txtNombre.setBounds(82, 59, 125, 22);
		pnl_content_calzado_modelo.add(txtNombre);
		
		txtPv = new JTextField();
		txtPv.setEnabled(false);
		txtPv.setHorizontalAlignment(SwingConstants.CENTER);
		txtPv.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		txtPv.setDisabledTextColor(Color.GRAY);
		txtPv.setColumns(10);
		txtPv.setBounds(254, 85, 69, 22);
		pnl_content_calzado_modelo.add(txtPv);
		
		txtPc = new JTextField();
		txtPc.setEnabled(false);
		txtPc.setHorizontalAlignment(SwingConstants.CENTER);
		txtPc.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		txtPc.setDisabledTextColor(Color.GRAY);
		txtPc.setColumns(10);
		txtPc.setBounds(254, 59, 69, 22);
		pnl_content_calzado_modelo.add(txtPc);
		
		cboMarca = new JComboBox();
		cboMarca.setEnabled(false);
		cboMarca.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		cboMarca.setBounds(82, 111, 125, 22);
		pnl_content_calzado_modelo.add(cboMarca);
		
		cboCategoria = new JComboBox();
		cboCategoria.setEnabled(false);
		cboCategoria.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		cboCategoria.setBounds(82, 85, 125, 22);
		pnl_content_calzado_modelo.add(cboCategoria);
		
		btnBuscar = new JButton("");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(Pnl_Content_Calzado_Modelo.class.getResource("/img/buscar_30px.png")));
		btnBuscar.setBounds(460, 11, 30, 30);
		pnl_content_calzado_modelo.add(btnBuscar);
		
		btnNuevo = new JButton("");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(Pnl_Content_Calzado_Modelo.class.getResource("/img/nuevo.png")));
		btnNuevo.setBounds(420, 62, 30, 30);
		pnl_content_calzado_modelo.add(btnNuevo);
		
		btnGuardar = new JButton("");
		btnGuardar.addActionListener(this);
		btnGuardar.setEnabled(false);
		btnGuardar.setIcon(new ImageIcon(Pnl_Content_Calzado_Modelo.class.getResource("/img/guardar.png")));
		btnGuardar.setBounds(460, 62, 30, 30);
		pnl_content_calzado_modelo.add(btnGuardar);
		
		btnCancelar = new JButton("");
		btnCancelar.addActionListener(this);
		btnCancelar.setVisible(false);
		
		btnEnviar = new JButton("");
		btnEnviar.addComponentListener(this);
//		btnEnviar.addChangeListener(this);
		btnEnviar.setIcon(new ImageIcon(Pnl_Content_Calzado_Modelo.class.getResource("/img/flecha_left.png")));
		btnEnviar.addActionListener(this);
		btnEnviar.setVisible(false);
		btnEnviar.setBounds(420, 103, 30, 30);
		pnl_content_calzado_modelo.add(btnEnviar);
		btnCancelar.setIcon(new ImageIcon(Pnl_Content_Calzado_Modelo.class.getResource("/img/cancelar.png")));
		btnCancelar.setBounds(420, 103, 30, 30);
		pnl_content_calzado_modelo.add(btnCancelar);
		
		btnModificar = new JButton("");
		btnModificar.addActionListener(this);
		btnModificar.setEnabled(false);
		btnModificar.setIcon(new ImageIcon(Pnl_Content_Calzado_Modelo.class.getResource("/img/modificar.png")));
		btnModificar.setBounds(460, 103, 30, 30);
		pnl_content_calzado_modelo.add(btnModificar);
		
		
		mostrarDataTabla(); // --> Muestra los datos de la tabla modelo
		listarDatosCbo();
		
	}
	
	public void listarDatosCbo(){
		
		ArrayList<Categoria> listCategoria = gCategoria.listar();
		ArrayList<Marca> listMarca = gMarca.listar();
		
		for(Categoria cat : listCategoria){
			cboCategoria.addItem(cat.getDescripcion());
		}
		
		for( Marca mar : listMarca ){
			cboMarca.addItem(mar.getNombre_marca());
		}
		
		
	}
	
	void mostrarDataTabla(){
		
		modelo.setRowCount(0);
		ArrayList<Modelo> data = gModelo.listar();
		
		for( int i = data.size()-1 ; i>=0 ; i-- ){
			
			Object fila[] = {
					data.get(i).getCod_modelo(),
					data.get(i).getNombre_modelo(),
					gMarca.buscar(data.get(i).getCod_marca()).get(0).getNombre_marca(),
					gCategoria.buscar( data.get(i).getCod_categoria() ).get(0).getDescripcion(),
					data.get(i).getPrecio_compra(),
					data.get(i).getPrecio_venta()
					
			};
			modelo.addRow(fila);
			
		}
	}
	
	public void controles( Boolean activo ){
		
		lblNombre.setEnabled(activo);
		lblCategoria.setEnabled(activo);
		lblMarca.setEnabled(activo);
		lblPc.setEnabled(activo);
		lblPv.setEnabled(activo);
		
		txtNombre.setEnabled(activo);
		cboCategoria.setEnabled(activo);
		cboMarca.setEnabled(activo);
		txtPc.setEnabled(activo);
		txtPv.setEnabled(activo);
		
		txtBuscar.setEnabled( !activo );
		btnBuscar.setEnabled( !activo );
		
		btnCancelar.setVisible(activo);
		btnNuevo.setEnabled(!activo); // << desactivado
		btnGuardar.setEnabled(activo);
		
	}
	
	void mensajeError(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje, "Error", 0);
	}
	void mensajeExito(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje, "Sistema ", 1);
	}
	
	void limpiarDatos(){

		//txtCodigo.setText("xxxxx");
		txtNombre.setText("");
		txtPc.setText("");
		txtPv.setText("");
		cboMarca.setSelectedIndex(0);
		cboCategoria.setSelectedIndex(0);

		btnModificar.setEnabled(false);

	}
	
	public Double leerPrecioCompra(){
		
		double pc = -1;
		
		try{
			pc = Double.parseDouble(txtPc.getText().trim());
			if(pc <= 0){
				pc = -1;
			}
		}catch (NumberFormatException e) {
			System.out.println("Error en leerPrecioCompra() --> " + e.getMessage());
		}catch (Exception e) {
			System.out.println("Error en leerPrecioCompra() --> " + e.getMessage());
		}
		
		return pc;
	}
	
	public Double leerPrecioVenta(){
		
		double pv = -1;
		
		try{
			pv = Double.parseDouble(txtPv.getText().trim());
			if(pv <= 0){
				pv = -1;
			}
		}catch (NumberFormatException e) {
			System.out.println("Error en leerPrecioVenta() --> " + e.getMessage());
		}catch (Exception e) {
			System.out.println("Error en leerPrecioVenta() --> " + e.getMessage());
		}
		
		return pv;
	}
	
	public void registrarModelo(){
		
		String codigo = txtCodigo.getText();
		String nombre = txtNombre.getText().trim();
		double pc = leerPrecioCompra();
		double pv = leerPrecioVenta();

		// obtiene el codigo Categoria
		String codCategoria = null;
		ArrayList<Categoria> listCat = gCategoria.buscar(cboCategoria.getSelectedItem().toString()) ;
		codCategoria = listCat.get(0).getCod_categoria();

		// obtiene el codigo Marca
		String codMarca = null;
		ArrayList<Marca> listMar = gMarca.buscar(cboMarca.getSelectedItem().toString()) ;
		codMarca = listMar.get(0).getCod_marca();
		
		// -->
		if(nombre.equals("") || pc == -1 || pv == -1 ){
			mensajeError("Error en el ingreso de Datos");
		}else{
			Modelo mod = new Modelo(codigo, nombre, pc, pv, codMarca, codCategoria);
			int respuesta = gModelo.registrar(mod);
			
			if(respuesta <= 0){
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
	
	void mostrarDatosTextBox(int posicionFila){
		// En la fila de la tabla busca el codigo del empleado, con este codigo se busca en la BD al empleado y trae todos sus datos.
		Modelo mod = new Modelo();
		String codigoFila = tblModelo.getValueAt(posicionFila, 0).toString();
		
		mod = gModelo.buscar(codigoFila).get(0);
		
		txtCodigo.setText( mod.getCod_modelo());
		txtNombre.setText( mod.getNombre_modelo() );
		txtPc.setText( String.valueOf( mod.getPrecio_compra() ) );
		txtPv.setText( String.valueOf( mod.getPrecio_venta() ) );
		
		
		Object objCategoria = gCategoria.buscar(mod.getCod_categoria()).get(0).getDescripcion();
		cboCategoria.setSelectedItem(objCategoria);
		
		Object objMarca = gMarca.buscar(mod.getCod_marca()).get(0).getNombre_marca();
		cboMarca.setSelectedItem(objMarca);
		
		
	}
	
	void actualizarModelo(){
		
		String codigo = txtCodigo.getText();
		String nombre = txtNombre.getText().trim();
		double pc = leerPrecioCompra();
		double pv = leerPrecioVenta();
		
		// obtiene el codigo Categoria
		String codCategoria = null;
		ArrayList<Categoria> listCat = gCategoria.buscar(cboCategoria.getSelectedItem().toString()) ;
		codCategoria = listCat.get(0).getCod_categoria();

		// obtiene el codigo Marca
		String codMarca = null;
		ArrayList<Marca> listMar = gMarca.buscar(cboMarca.getSelectedItem().toString()) ;
		codMarca = listMar.get(0).getCod_marca();
		
		if(nombre.equals("") || pc == -1 || pv == -1){
			mensajeError("Error en el ingreso de Datos");
		}else{
			Modelo mod = new Modelo(codigo, nombre, pc, pv, codMarca, codCategoria );
			
			int respuesta = gModelo.actualizar(mod);
			
			if( respuesta <= 0 ){
				mensajeError("Error al actualizar Datos");
			}else{
				mostrarDataTabla();
				mensajeExito("Actualizacion Exitosa");
				controles(false);
				txtCodigo.setText("-----");
				limpiarDatos();
			}
			
		}
		
	}
	
	public ArrayList<Modelo> resultadoBusqueda(){
		
		String valor = txtBuscar.getText().trim();
		
		ArrayList<Modelo> data = new ArrayList<Modelo>();
		
		data = gModelo.buscar(valor);
		
		return data;
		
	}
	
	void mostrarResultadoBusquedaTabla(ArrayList<Modelo> data){

		modelo.setRowCount(0);
		
		for (Modelo mod : data) {
			
			Object fila[] = {
					mod.getCod_modelo(),
					mod.getNombre_modelo(),
					gMarca.buscar(mod.getCod_marca()).get(0).getNombre_marca(),
					gCategoria.buscar(mod.getCod_categoria()).get(0).getDescripcion(),
					mod.getPrecio_compra(),
					mod.getPrecio_venta(),
			};
			modelo.addRow(fila);
		}
		
	}
	
	/** ----------------------------------------------------------------------------------- **/
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEnviar) {
			
			int posFila = tblModelo.getSelectedRow();
			String nomModelo = "";
			if(posFila != -1){
				nomModelo = tblModelo.getValueAt(posFila, 1).toString();
				Pnl_Content_Calzado.txtModelo.setText(nomModelo);
			}
			
			
			
			
//			String nomModelo = txtNombre.getText().trim();
//			if(nomModelo.equals("")){
//				mensajeError("Escoja un modelo de la lista");
//			}else{
//				Pnl_Content_Calzado.txtModelo.setText(nomModelo);
//			}
		}
		if (arg0.getSource() == btnBuscar) {
			ArrayList<Modelo> data = resultadoBusqueda();
			mostrarResultadoBusquedaTabla(data);
		}
		if (arg0.getSource() == btnModificar) {
			controles(true);
			btnModificar.setEnabled(false);
		}
		if (arg0.getSource() == btnGuardar) {
			String cod = txtCodigo.getText();
			ArrayList<Modelo> listModelos = gModelo.buscar(cod);
			
			if( listModelos.size() != 1 ){
				registrarModelo();
			}else{
				actualizarModelo();
			}
		}
		if (arg0.getSource() == btnCancelar) {
			txtCodigo.setText("-----");
			controles(false);
			limpiarDatos();
			
		}
		if (arg0.getSource() == btnNuevo) {
			txtCodigo.setText( gModelo.generarCodigo() );
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
		if (arg0.getSource() == tblModelo) {
			int posfila;
			posfila = tblModelo.getSelectedRow();
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
			if(arg0.getKeyCode() == KeyEvent.VK_ENTER ){
				ArrayList<Modelo> data = resultadoBusqueda();
				mostrarResultadoBusquedaTabla(data);
			}
		}
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == tblModelo) {
			int posfila;
			posfila = tblModelo.getSelectedRow();

			if(btnNuevo.isEnabled() && posfila != -1){
				mostrarDatosTextBox(posfila);
				btnModificar.setEnabled(true);
			}
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}

	/** ----------------------------------------------------------------------------------- **/
	
//	// Detecta el cambio que se realiza al boton enviar que se hara desde el panel calzado. para limpiar todos los datos.
//	public void stateChanged(ChangeEvent arg0) {
//		if (arg0.getSource() == btnEnviar) {
//			
////			txtCodigo.setText("-----");
////			controles(false);
////			limpiarDatos();
//			
//		}
//	}

	/** ----------------------------------------------------------------------------------- **/
	
	public void componentHidden(ComponentEvent arg0) {
	}
	public void componentMoved(ComponentEvent arg0) {
	}
	public void componentResized(ComponentEvent arg0) {
	}
	public void componentShown(ComponentEvent arg0) {
		if (arg0.getSource() == btnEnviar) {
			componentShownBtnEnviar(arg0);
		}
	}
	// El evento solo se activa cuando el boton se muestra, cuando se oculta este evento no se activa
	protected void componentShownBtnEnviar(ComponentEvent arg0) {
		txtCodigo.setText("-----");
		controles(false);
		btnNuevo.setEnabled(false);
		limpiarDatos();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
// ---------

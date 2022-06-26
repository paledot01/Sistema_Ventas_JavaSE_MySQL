package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.CalzadoGestionDao;
import Controlador.ModeloGestionDao;
import entidad.Calzado;
import entidad.CalzadoReporte;
import utils.Library;
import utils.RendererTableCalzado;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Pnl_Content_Calzado extends JPanel implements MouseListener, ActionListener, KeyListener {
	private JPanel pnl_calzado_main;
	private JLabel lblCalzado;
	private JPanel pnl_datos_calzado;
	private JPanel pnl_codigo_calzado;
	private JTextField txtCodigo;
	private JLabel label;
	private JLabel lblModelo;
	public static JTextField txtModelo;  // <<<<<<<<<<<<<<<<<
	private JTextField txtColor;
	private JLabel lblColor;
	private JTextField txtTalla;
	private JLabel lblTalla;
	private JPanel panel;
	private JLabel btnModelo;
	private JButton btnCancelar;
	private JTextField txtBuscar;
	private JRadioButton rbCodigo;
	public static JPanel pnl_mod_mar_cat;
	private JLabel lblStock;
	private JLabel lblBuscar;
	private JButton btnBuscar;
	private JRadioButton rbModelo;
	private JRadioButton rbCategoria;
	private JTable tblCalzado;
	private JScrollPane scrollPane;
	private JTextField txtStock;
	private JPanel pnlSeparador;
	private JRadioButton rbTalla;
	private JButton btnModificar;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JRadioButton rbColor;
	private JRadioButton rbMarca;
	private JButton btnPdf;
	private JButton btnExcel;
	private JButton btnTxt;
	private JLabel btnCategoria;
	private JLabel btnMarca;

	
	boolean [] botones = {true, false, false}; // para los botones que muestran un panel, y para que el primer boton inicie y se mantenga activado<<<<
	private CalzadoGestionDao gCalzado = new CalzadoGestionDao();
	private ModeloGestionDao gModelo = new ModeloGestionDao();
	private DefaultTableModel modelo;
	
	RendererTableCalzado render = new RendererTableCalzado(); // <<<<<<<<<<<<<<<<<<<<<<<<<<<
	private JLabel lblElegir;
	
	
	/**
	 * Create the panel.
	 */
	public Pnl_Content_Calzado() {
		setLayout(null);
		
		pnl_calzado_main = new JPanel();
		pnl_calzado_main.setBorder(new LineBorder(Library.Claro_2));
		pnl_calzado_main.setBounds(0, 0, 870, 670);
		add(pnl_calzado_main);
		pnl_calzado_main.setLayout(null);
		
		lblCalzado = new JLabel("CALZADO");
		lblCalzado.setOpaque(true);
		lblCalzado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalzado.setForeground(SystemColor.menu);
		lblCalzado.setFont(new Font("Courier New", Font.BOLD, 20));
		lblCalzado.setBackground(new Color(95, 103, 112));
		lblCalzado.setBounds(10, 11, 850, 24);
		pnl_calzado_main.add(lblCalzado);
		
		pnl_datos_calzado = new JPanel();
		pnl_datos_calzado.setBorder(new LineBorder(new Color(95, 103, 112), 2));
		pnl_datos_calzado.setBounds(10, 46, 340, 329);
		pnl_calzado_main.add(pnl_datos_calzado);
		pnl_datos_calzado.setLayout(null);
		
		pnl_codigo_calzado = new JPanel();
		pnl_codigo_calzado.setLayout(null);
		pnl_codigo_calzado.setBackground(new Color(220, 220, 220));
		pnl_codigo_calzado.setBounds(10, 11, 165, 36);
		pnl_datos_calzado.add(pnl_codigo_calzado);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("-----");
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtCodigo.setEnabled(false);
		txtCodigo.setDisabledTextColor(Color.GRAY);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(63, 7, 91, 22);
		pnl_codigo_calzado.add(txtCodigo);
		
		label = new JLabel("Codigo");
		label.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		label.setBounds(10, 7, 42, 22);
		pnl_codigo_calzado.add(label);
		
		lblModelo = new JLabel("Modelo *");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModelo.setEnabled(false);
		lblModelo.setBounds(10, 64, 55, 22);
		pnl_datos_calzado.add(lblModelo);
		
		lblColor = new JLabel("Color *");
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblColor.setEnabled(false);
		lblColor.setBounds(10, 90, 60, 22);
		pnl_datos_calzado.add(lblColor);
		
		lblTalla = new JLabel("Talla");
		lblTalla.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTalla.setEnabled(false);
		lblTalla.setBounds(10, 116, 40, 22);
		pnl_datos_calzado.add(lblTalla);
		
		lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStock.setEnabled(false);
		lblStock.setBounds(175, 116, 40, 22);
		pnl_datos_calzado.add(lblStock);
		
		lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBuscar.setEnabled(false);
		lblBuscar.setBounds(10, 203, 55, 22);
		pnl_datos_calzado.add(lblBuscar);
		
		lblElegir = new JLabel("");
		lblElegir.setEnabled(false);
		lblElegir.setHorizontalAlignment(SwingConstants.CENTER);
		lblElegir.setIcon(new ImageIcon(Pnl_Content_Calzado.class.getResource("/img/flecha_right.png")));
		lblElegir.setBounds(290, 64, 40, 22);
		pnl_datos_calzado.add(lblElegir);
		
		txtModelo = new JTextField();
		txtModelo.setEnabled(false);
		txtModelo.setHorizontalAlignment(SwingConstants.CENTER);
		txtModelo.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtModelo.setDisabledTextColor(Color.GRAY);
		txtModelo.setColumns(10);
		txtModelo.setBounds(75, 64, 215, 22);
		pnl_datos_calzado.add(txtModelo);
		
		txtColor = new JTextField();
		txtColor.setEnabled(false);
		txtColor.setHorizontalAlignment(SwingConstants.CENTER);
		txtColor.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtColor.setDisabledTextColor(Color.GRAY);
		txtColor.setColumns(10);
		txtColor.setBounds(75, 90, 255, 22);
		pnl_datos_calzado.add(txtColor);
		
		txtTalla = new JTextField();
		txtTalla.setEnabled(false);
		txtTalla.setHorizontalAlignment(SwingConstants.CENTER);
		txtTalla.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtTalla.setDisabledTextColor(Color.GRAY);
		txtTalla.setColumns(10);
		txtTalla.setBounds(75, 116, 90, 22);
		pnl_datos_calzado.add(txtTalla);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtBuscar.setDisabledTextColor(Color.GRAY);
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(75, 203, 192, 22);
		pnl_datos_calzado.add(txtBuscar);
		
		txtStock = new JTextField();
		txtStock.setEnabled(false);
		txtStock.setHorizontalAlignment(SwingConstants.CENTER);
		txtStock.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtStock.setDisabledTextColor(Color.GRAY);
		txtStock.setColumns(10);
		txtStock.setBounds(240, 116, 90, 22);
		pnl_datos_calzado.add(txtStock);
		
		pnlSeparador = new JPanel();
		pnlSeparador.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlSeparador.setBounds(10, 192, 320, 2);
		pnl_datos_calzado.add(pnlSeparador);
		
		btnCancelar = new JButton("");
		btnCancelar.addActionListener(this);
		btnCancelar.setVisible(false);
		btnCancelar.setIcon(new ImageIcon(Pnl_Content_Calzado.class.getResource("/img/cancelar.png")));
		btnCancelar.setBounds(10, 151, 30, 30);
		pnl_datos_calzado.add(btnCancelar);
		
		btnNuevo = new JButton("");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(Pnl_Content_Calzado.class.getResource("/img/nuevo.png")));
		btnNuevo.setBounds(220, 151, 30, 30);
		pnl_datos_calzado.add(btnNuevo);
		
		btnGuardar = new JButton("");
		btnGuardar.addActionListener(this);
		btnGuardar.setEnabled(false);
		btnGuardar.setIcon(new ImageIcon(Pnl_Content_Calzado.class.getResource("/img/guardar.png")));
		btnGuardar.setBounds(260, 151, 30, 30);
		pnl_datos_calzado.add(btnGuardar);
		
		btnModificar = new JButton("");
		btnModificar.addActionListener(this);
		btnModificar.setEnabled(false);
		btnModificar.setIcon(new ImageIcon(Pnl_Content_Calzado.class.getResource("/img/modificar.png")));
		btnModificar.setBounds(300, 151, 30, 30);
		pnl_datos_calzado.add(btnModificar);
		
		rbCodigo = new JRadioButton("Codigo");
		rbCodigo.setBounds(10, 232, 65, 23);
		pnl_datos_calzado.add(rbCodigo);
		
		rbModelo = new JRadioButton("Modelo");
		rbModelo.setSelected(true);
		rbModelo.setBounds(100, 232, 65, 23);
		pnl_datos_calzado.add(rbModelo);
		
		rbCategoria = new JRadioButton("Categoria");
		rbCategoria.setBounds(190, 232, 75, 23);
		pnl_datos_calzado.add(rbCategoria);
		
		rbMarca = new JRadioButton("Marca");
		rbMarca.setBounds(10, 258, 65, 23);
		pnl_datos_calzado.add(rbMarca);
		
		rbTalla = new JRadioButton("Talla");
		rbTalla.setBounds(100, 258, 65, 23);
		pnl_datos_calzado.add(rbTalla);
		
		rbColor = new JRadioButton("Color");
		rbColor.setBounds(190, 258, 65, 23);
		pnl_datos_calzado.add(rbColor);
		
		ButtonGroup grupoBusqueda = new ButtonGroup();
		grupoBusqueda.add(rbCodigo);
		grupoBusqueda.add(rbModelo);
		grupoBusqueda.add(rbCategoria);
		grupoBusqueda.add(rbMarca);
		grupoBusqueda.add(rbTalla);
		grupoBusqueda.add(rbColor);
		
		
		btnBuscar = new JButton("");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(Pnl_Content_Calzado.class.getResource("/img/buscar_53px.png")));
		btnBuscar.setBounds(277, 202, 53, 53);
		pnl_datos_calzado.add(btnBuscar);
		
		btnPdf = new JButton("PDF");
		btnPdf.addActionListener(this);
		btnPdf.setHorizontalAlignment(SwingConstants.LEFT);
		btnPdf.setIcon(new ImageIcon(Pnl_Content_Calzado.class.getResource("/img/pdf_30px.png")));
		btnPdf.setBounds(255, 288, 75, 30);
		pnl_datos_calzado.add(btnPdf);
		
		btnExcel = new JButton("XLS");
		btnExcel.setHorizontalAlignment(SwingConstants.LEFT);
		btnExcel.setIcon(new ImageIcon(Pnl_Content_Calzado.class.getResource("/img/excel_30px.png")));
		btnExcel.addActionListener(this);
		btnExcel.setBounds(170, 288, 75, 30);
		pnl_datos_calzado.add(btnExcel);
		
		btnTxt = new JButton("TXT");
		btnTxt.addActionListener(this);
		btnTxt.setIcon(new ImageIcon(Pnl_Content_Calzado.class.getResource("/img/texto_30px.png")));
		btnTxt.setBounds(85, 288, 75, 30);
		pnl_datos_calzado.add(btnTxt);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(95, 103, 112), 2));
		panel.setBounds(360, 46, 500, 329);
		pnl_calzado_main.add(panel);
		panel.setLayout(null);
		
		btnModelo = new JLabel("MODELO");
		btnModelo.addMouseListener(this);
		btnModelo.setBounds(0, 0, 166, 25);
		panel.add(btnModelo);
		btnModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModelo.setForeground(SystemColor.text);
		btnModelo.setHorizontalAlignment(SwingConstants.CENTER);
		btnModelo.setOpaque(true);
		btnModelo.setBackground(Library.Verde); // para que inicie activado.
		
		btnMarca = new JLabel("MARCA");
		btnMarca.addMouseListener(this);
		btnMarca.setOpaque(true);
		btnMarca.setHorizontalAlignment(SwingConstants.CENTER);
		btnMarca.setForeground(Color.WHITE);
		btnMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMarca.setBackground(Library.Claro_2);
		btnMarca.setBounds(167, 0, 166, 25);
		panel.add(btnMarca);
		
		btnCategoria = new JLabel("CATEGORIA");
		btnCategoria.addMouseListener(this);
		btnCategoria.setOpaque(true);
		btnCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		btnCategoria.setForeground(Color.WHITE);
		btnCategoria.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCategoria.setBackground(Library.Claro_2);
		btnCategoria.setBounds(334, 0, 166, 25);
		panel.add(btnCategoria);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 386, 850, 273);
		pnl_calzado_main.add(scrollPane);
		
		// ----------------------------------------------------------
		tblCalzado = new JTable();
		tblCalzado.addKeyListener(this);
		tblCalzado.addMouseListener(this);
		tblCalzado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblCalzado.setBorder(new LineBorder(new Color(95, 103, 112)));
		tblCalzado.setFillsViewportHeight(true);
		tblCalzado.setDefaultRenderer(Object.class, render); // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		scrollPane.setViewportView(tblCalzado);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("MODELO");
		modelo.addColumn("MARCA");
		modelo.addColumn("CATEGORIA");
		modelo.addColumn("TALLA");
		modelo.addColumn("COLOR");
		modelo.addColumn("P.COMPRA");
		modelo.addColumn("P.VENTA");
		modelo.addColumn("STOCK");
		tblCalzado.setModel(modelo);
		
		pnl_mod_mar_cat = new JPanel();
		pnl_mod_mar_cat.setBounds(0, 25, 500, 304);
		panel.add(pnl_mod_mar_cat);
		
		// Panel Modelo inicia activado por defecto
		Pnl_Content_Calzado_Modelo pnl_modelo = new Pnl_Content_Calzado_Modelo();
		MostrarPanelModelo( pnl_modelo );
		
		// ---------------------------------
		mostrarDataTabla();
		
	}
	
	static void MostrarPanelModelo(JPanel p){
		
		p.setSize(500, 304);
		p.setLocation(0,0);
		pnl_mod_mar_cat.removeAll();
		pnl_mod_mar_cat.setLayout(null);
		pnl_mod_mar_cat.add(p);
		pnl_mod_mar_cat.revalidate();
		pnl_mod_mar_cat.repaint();
		
	}
	
	void mostrarDataTabla(){
		
		modelo.setRowCount(0);
		ArrayList<CalzadoReporte> data = gCalzado.listar();
		
		for( int i = data.size()-1 ; i>=0 ; i-- ){
			
			Object fila[] = {
					data.get(i).getCod_calzado(),
					data.get(i).getNombre_modelo(),
					data.get(i).getNombre_marca(),
					data.get(i).getDescripcion_categoria(),
					data.get(i).getTalla(),
					data.get(i).getColor(),
					data.get(i).getPrecio_compra(),
					data.get(i).getPrecio_venta(),
					data.get(i).getStock()
					
			};
			modelo.addRow(fila);
			
		}
		
	}
	
	public void controles( Boolean activo ){
		
		lblModelo.setEnabled(activo);
		lblColor.setEnabled(activo);
		lblTalla.setEnabled(activo);
		lblStock.setEnabled(activo);

		txtModelo.setEnabled(activo);
		txtColor.setEnabled(activo);
		txtTalla.setEnabled(activo);
		txtStock.setEnabled(activo);

		lblBuscar.setEnabled( !activo ); // << desactivado
		txtBuscar.setEnabled( !activo );
		btnBuscar.setEnabled( !activo );
		rbCodigo.setEnabled( !activo );
		rbModelo.setEnabled( !activo );
		rbCategoria.setEnabled( !activo );
		rbMarca.setEnabled( !activo );
		rbTalla.setEnabled( !activo );
		rbColor.setEnabled( !activo );

		btnCancelar.setVisible(activo);
		btnNuevo.setEnabled(!activo); 
		btnGuardar.setEnabled(activo);
		
	}
	
	void mensajeError(String mensaje){
		JOptionPane.showMessageDialog(pnl_calzado_main, mensaje, "Error", 0);
	}
	void mensajeExito(String mensaje){
		JOptionPane.showMessageDialog(pnl_calzado_main, mensaje, "Sistema", 1);
	}
	
	
	void limpiarDatos(){

		//txtCodigo.setText("xxxxx");
		txtModelo.setText("");
		txtColor.setText("");
		txtTalla.setText("");
		txtStock.setText("");;

		btnModificar.setEnabled(false);

	}
	
	public String leerModelo(){
		
		String codModelo = "";
		
		try{
			codModelo = gModelo.buscarPorNombre(txtModelo.getText().trim()).getCod_modelo();
		}catch (Exception e) {
			System.out.println("Error en leerModelo() --> " + e.getMessage());
		}
		
		return codModelo;
	}
	
	public String leerColor(){
		
		String color = "";
		
		if(txtColor.getText().trim().length() > 0){
			color = txtColor.getText().trim();
		}
		
		return color;
	}
	
	public int leerTalla(){
		
		int talla = -1;
		
		try{
			talla = Integer.parseInt(txtTalla.getText());
			if(talla <= 0){
				talla = -1;
			}
		}catch (NumberFormatException e) {
			System.out.println("Error en leerTalla() --> " + e.getMessage());
		}catch (Exception e) {
			System.out.println("Error en leerTalla() --> " + e.getMessage());
		}
			
		return talla;
	}
	
	public int leerStock(){
		
		int stock = -1;
		
		try{
			stock = Integer.parseInt(txtStock.getText());
			if(stock <= 0){
				stock = -1;
			}
		}catch (NumberFormatException e) {
			System.out.println("Error en leerStock() --> " + e.getMessage());
		}catch (Exception e) {
			System.out.println("Error en leerStock() --> " + e.getMessage());
		}

		return stock;
		
	}
	
	
	public void registrarCalzado(){
		
		String codigo = txtCodigo.getText();
		String codModelo = leerModelo();
		int talla = leerTalla();
		String color = leerColor();
		int stock = leerStock();
		
		// -->
		if(codModelo.equals("") || color.equals("") || talla == -1 || stock == -1 ){
			mensajeError("Error en el ingreso de Dato");
		}else{
			Calzado calzado = new Calzado(codigo, codModelo, talla, color, stock );
			int respuesta = gCalzado.registrar(calzado);
			
			if(respuesta <= 0){
				mensajeError("Error en el Registro de Datos");
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
	
	void actualizarCalzado(){
		
		String codigo = txtCodigo.getText().trim();
		String codModelo = leerModelo();
		int talla = leerTalla();
		String color = leerColor();
		int stock = leerStock();
		
		// -->
		if(codModelo.equals("") || color.equals("") || talla == -1 || stock == -1 ){
			mensajeError("Error en el ingreso de Datos");
		}else{
			Calzado calzado = new Calzado(codigo, codModelo, talla, color, stock );
			
			int respuesta = gCalzado.actualizar(calzado); // unica diferencia con Registrar
			
			if( respuesta <= 0 ){
				mensajeError("Error al actualizar los Datos");
			}else{
				mostrarDataTabla();
				mensajeExito("Actualizacion Exitosa");
				controles(false);
				txtCodigo.setText("-----");
				limpiarDatos();
			}
			
		}
		
	}
	
	void mostrarDatosTextBox(int posicionFila){
		
		// En la fila de la tabla busca el codigo del Calzado, con este codigo se busca en la BD el calzado y trae todos sus datos.
		Calzado calzado = new Calzado();
		String codigoFila = tblCalzado.getValueAt(posicionFila, 0).toString();
		calzado = gCalzado.buscarPorCodigoSimple(codigoFila).get(0);
		
		// --
		txtCodigo.setText( calzado.getCod_calzado() );
		txtModelo.setText(  gModelo.buscar(calzado.getCod_modelo()).get(0).getNombre_modelo()  );
		txtTalla.setText( String.valueOf(calzado.getTalla()) );
		txtColor.setText( calzado.getColor() );
		txtStock.setText( String.valueOf(calzado.getStock()) );
		
	}
	
	public ArrayList<CalzadoReporte> resultadoBusqueda(){
		
		String valor = txtBuscar.getText().trim();
		
		ArrayList<CalzadoReporte> data = new ArrayList<CalzadoReporte>();
		
		try {
			if(rbCodigo.isSelected()){
				data = gCalzado.buscarPorCodigo(valor);
			}else if(rbModelo.isSelected()){
				data = gCalzado.buscarPorModelo(valor);
			}else if(rbCategoria.isSelected()){
				data = gCalzado.buscarPorCategoria(valor);
			}else if(rbMarca.isSelected()){
				data = gCalzado.buscarPorMarca(valor);
			}else if(rbTalla.isSelected()){
				if(valor.equals("")){
					data = gCalzado.listar();
				}else{
					data = gCalzado.buscarPorTalla(Integer.parseInt(valor));
				}
			}else if(rbColor.isSelected()){
				data = gCalzado.buscarPorColor(valor);
			}
		}catch (NumberFormatException e) {
			System.out.println("Error en la busqueda() --> " + e.getMessage());
		}catch (Exception e) {
			System.out.println("Error en la busqueda() --> " + e.getMessage());
		}
		
		return data;
	}
	
	void mostrarResultadoBusquedaTabla(ArrayList<CalzadoReporte> data){

		modelo.setRowCount(0);
		
		for (CalzadoReporte cr : data) {
			
			Object fila[] = {
					
					cr.getCod_calzado(),
					cr.getNombre_modelo(),
					cr.getNombre_marca(),
					cr.getDescripcion_categoria(),
					cr.getTalla(),
					cr.getColor(),
					cr.getPrecio_compra(),
					cr.getPrecio_venta(),
					cr.getStock()
			
			};
			modelo.addRow(fila);
		}
		
	}
	
	void buscarModelo(boolean activo){

		// si un boton que no es el modelo esta activo, entoces se instancia y cambia al panel modelo, lo cual genera una demora al tener que cargar todo el panel con los datos
		// si no solo se activa los botones. 
		if(botones[0] == false){
			MostrarPanelModelo(new Pnl_Content_Calzado_Modelo());
			activarBoton(0, btnModelo); // <<<<<<<<<<<<<<<<<<<<<<<<<<
		}
		
		lblElegir.setEnabled(activo);
		Pnl_Content_Calzado_Modelo.btnEnviar.setVisible(activo); 
		Pnl_Content_Calzado_Modelo.btnNuevo.setEnabled(!activo);
		
	}
	
	/** ----------------------------------------------------------------------------------- **/
	
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnCategoria) {
			btnCategoria.setBackground(utils.Library.Verde);
		}
		if (e.getSource() == btnMarca) {
			btnMarca.setBackground(utils.Library.Verde);
		}
		if (e.getSource() == btnModelo) {
			btnModelo.setBackground(utils.Library.Verde);
		}
	}
	public void mouseExited(MouseEvent e) { // <<< modificar para mantener el cambio de color del boton activado
		if (e.getSource() == btnModelo && botones[0] == false) {
			btnModelo.setBackground(Library.Claro_2);
		}
		if (e.getSource() == btnMarca && botones[1] == false) {
			btnMarca.setBackground(Library.Claro_2);
		}
		if (e.getSource() == btnCategoria && botones[2] == false) {
			btnCategoria.setBackground(Library.Claro_2);
		}
	}
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == tblCalzado) {
			
			int posFila = tblCalzado.getSelectedRow();
			
			if(btnNuevo.isEnabled() && posFila != -1){
				mostrarDatosTextBox(posFila);
				btnModificar.setEnabled(true);
			}
			
		}
		if (e.getSource() == btnModelo) { // indice 0
			if(btnNuevo.isEnabled()){
				MostrarPanelModelo(new Pnl_Content_Calzado_Modelo());
				activarBoton(0, btnModelo); // <<<<<<<<<<<<<<<<<<<<<<<<<<
			}

		}
		if (e.getSource() == btnMarca) { // indice 1
			if(btnNuevo.isEnabled()){
				MostrarPanelModelo(new Pnl_Content_Calzado_Marca());
				activarBoton(1, btnMarca); // <<<<<<<<<<<<<<<<<<<<<<<<<<
			}

		}
		if (e.getSource() == btnCategoria) { // indice 2
			if(btnNuevo.isEnabled()){
				MostrarPanelModelo(new Pnl_Content_Calzado_Categoria());
				activarBoton(2, btnCategoria); // <<<<<<<<<<<<<<<<<<<<<<<<<<
			}
		}
	}
	public void mouseReleased(MouseEvent e) {
		
		
	}

	/** ----------------------------------------------------------------------------------- **/
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnPdf) {
			ArrayList<CalzadoReporte> data = resultadoBusqueda();
			if(gCalzado.exportarPDF(data) == -1){
				mensajeError("No se pudo generar el archivo");
			}
		}
		if (arg0.getSource() == btnExcel) {
			ArrayList<CalzadoReporte> data = resultadoBusqueda();
			if(gCalzado.exportarXLSX(data) != -1){
				mensajeExito("Se guardo correctamente");
			}else{
				mensajeError("Error al guardar el archivo");
			}
		}
		if (arg0.getSource() == btnTxt) {
			ArrayList<CalzadoReporte> data =resultadoBusqueda();
			if(gCalzado.exportarTXT(data) != -1){
				mensajeExito("Se guardo correctamente");
			}else{
				mensajeError("Error al guardar el archivo");
			}
		}
		if (arg0.getSource() == btnBuscar) {
			ArrayList<CalzadoReporte> data = resultadoBusqueda();
			mostrarResultadoBusquedaTabla(data);
		}
		if (arg0.getSource() == btnModificar) {
			controles(true);
			btnModificar.setEnabled(false);
			buscarModelo(true); // <<<<<<<<<<
		}
		if (arg0.getSource() == btnGuardar) {
			String codigo = txtCodigo.getText();
			ArrayList<Calzado> listaCalzado = gCalzado.buscarPorCodigoSimple(codigo);
			
			if(listaCalzado.size() != 1){
				registrarCalzado();
				buscarModelo(false); // <<<<<<<<<<
			}else{
				actualizarCalzado();
				buscarModelo(false); // <<<<<<<<<<
			}
			
		}
		if (arg0.getSource() == btnCancelar) {
			txtCodigo.setText("-----");
			controles(false);
			limpiarDatos();
			buscarModelo(false); // <<<<<<<<<<
		}
		if (arg0.getSource() == btnNuevo) {
			txtCodigo.setText( gCalzado.generarCodigo() );
			controles(true);
			limpiarDatos();
			buscarModelo(true); // <<<<<<<<<<
			
		}
	}

	/** ----------------------------------------------------------------------------------- **/
	
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getSource() == txtBuscar) {

			if(arg0.getKeyCode() == KeyEvent.VK_ENTER ) {
				ArrayList<CalzadoReporte> data = resultadoBusqueda();
				mostrarResultadoBusquedaTabla(data);
			}
			
		}
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == tblCalzado) {

			int posFila = tblCalzado.getSelectedRow();
			
			if(btnNuevo.isEnabled() && posFila != -1){
				mostrarDatosTextBox(posFila);
				btnModificar.setEnabled(true);
			}
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}

	/** ----------------------------------------------------------------------------------- **/
	
	void activarBoton( int indice , JLabel thisLabel ){ 
		
		// devuelve el color de fondo a todos los labels, y cambia solo el color al Label que tiene el indice que representa
		
		btnModelo.setBackground(Library.Claro_2);
		btnMarca.setBackground(Library.Claro_2);
		btnCategoria.setBackground(Library.Claro_2);

		for (int i = 0; i < botones.length; i++) {
			if ( i == indice ) {
				botones[i] = true;
				thisLabel.setBackground(Library.Verde);
			}
			else
				botones[i] = false ;
		}

	}
}





















//--

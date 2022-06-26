package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import utils.Library;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class Pnl_Content_Venta extends JPanel implements ActionListener {
	private JPanel pnl_venta_main;
	private JLabel lblVenta;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField textField;
	private JLabel lblNroBoleta;
	private JLabel lblVendedor;
	private JTextField textField_1;
	private JLabel lblCliente;
	private JTextField txtNombre;
	private JPanel panel_2;
	private JLabel lblApellido;
	private JTextField textField_3;
	private JLabel lblDni;
	private JTextField textField_4;
	private JLabel lblTelefono;
	private JTextField textField_5;
	private JLabel lblDistrito;
	private JComboBox comboBox;
	private JLabel lblCodigo;
	public static JTextField txtCodigoCalzado; // -----
	private JPanel pnl_calzado;
	private JLabel lblModelo;
	private JLabel lblMarca;
	private JLabel lblCategoria;
	private JLabel lblPrecio;
	private JLabel lblValorPrecio;
	private JLabel lblValorModelo;
	private JLabel lblValorMarca;
	private JLabel lblValorCategoria;
	private JLabel lblValorStock;
	private JLabel lblStock;
	private JLabel lblValorTalla;
	private JLabel lblTalla;
	private JLabel lblColor;
	private JLabel lblValorColor;
	private JLabel lblPares;
	private JLabel lblUnidades;
	private JLabel lblTotal;
	private JTable tblVenta;
	private JScrollPane scrollPane;
	private JButton btnBuscarCalzado;
	private JPanel pnl_Informacion;
	private JButton btnAgregar;
	private JButton btnAumentar;
	private JTextField txtUnidades;
	private JButton btnDisminuir;
	private JPanel pnl_unidades;
	private JTextField txtTotal;

	private DefaultTableModel modelo;
	
	/**
	 * Create the panel.
	 */
	public Pnl_Content_Venta() {
		setLayout(null);
		
		pnl_venta_main = new JPanel();
		pnl_venta_main.setBorder(new LineBorder(Library.Claro_2));
		pnl_venta_main.setBounds(0, 0, 870, 670);
		add(pnl_venta_main);
		pnl_venta_main.setLayout(null);
		
		lblVenta = new JLabel("VENTA");
		lblVenta.setOpaque(true);
		lblVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenta.setForeground(SystemColor.menu);
		lblVenta.setFont(new Font("Courier New", Font.BOLD, 20));
		lblVenta.setBackground(SystemColor.controlDkShadow);
		lblVenta.setBounds(10, 11, 850, 24);
		pnl_venta_main.add(lblVenta);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(Library.Claro_2, 2));
		panel.setBounds(10, 46, 850, 613);
		pnl_venta_main.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(10, 11, 830, 36);
		panel.add(panel_1);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setText("-----");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField.setDisabledTextColor(Color.GRAY);
		textField.setColumns(10);
		textField.setBounds(122, 7, 91, 22);
		panel_1.add(textField);
		
		lblNroBoleta = new JLabel("NUMERO BOLETA");
		lblNroBoleta.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblNroBoleta.setBounds(10, 7, 102, 22);
		panel_1.add(lblNroBoleta);
		
		lblVendedor = new JLabel("VENDEDOR");
		lblVendedor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVendedor.setBounds(468, 7, 85, 22);
		panel_1.add(lblVendedor);
		lblVendedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textField_1 = new JTextField();
		textField_1.setBounds(563, 7, 257, 22);
		panel_1.add(textField_1);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField_1.setEnabled(false);
		textField_1.setDisabledTextColor(Color.GRAY);
		textField_1.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "CLIENTE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel_2.setBounds(10, 58, 830, 90);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(70, 26, 140, 22);
		panel_2.add(txtNombre);
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtNombre.setDisabledTextColor(Color.GRAY);
		txtNombre.setColumns(10);
		
		lblCliente = new JLabel("NOMBRE");
		lblCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCliente.setBounds(10, 24, 50, 22);
		panel_2.add(lblCliente);
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblApellido = new JLabel("APELLIDO");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellido.setBounds(220, 24, 64, 22);
		panel_2.add(lblApellido);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField_3.setDisabledTextColor(Color.GRAY);
		textField_3.setColumns(10);
		textField_3.setBounds(294, 26, 176, 22);
		panel_2.add(textField_3);
		
		lblDni = new JLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDni.setBounds(10, 52, 50, 22);
		panel_2.add(lblDni);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField_4.setDisabledTextColor(Color.GRAY);
		textField_4.setColumns(10);
		textField_4.setBounds(70, 52, 140, 22);
		panel_2.add(textField_4);
		
		lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefono.setBounds(220, 52, 64, 22);
		panel_2.add(lblTelefono);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField_5.setDisabledTextColor(Color.GRAY);
		textField_5.setColumns(10);
		textField_5.setBounds(294, 52, 176, 22);
		panel_2.add(textField_5);
		
		lblDistrito = new JLabel("DISTRITO");
		lblDistrito.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDistrito.setBounds(480, 52, 65, 22);
		panel_2.add(lblDistrito);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		comboBox.setBounds(555, 52, 140, 22);
		panel_2.add(comboBox);
		
		pnl_calzado = new JPanel();
		pnl_calzado.setForeground(Color.DARK_GRAY);
		pnl_calzado.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "CALZADO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		pnl_calzado.setBounds(10, 159, 830, 146);
		panel.add(pnl_calzado);
		pnl_calzado.setLayout(null);
		
		lblCodigo = new JLabel("CODIGO");
		lblCodigo.setBounds(10, 26, 50, 22);
		pnl_calzado.add(lblCodigo);
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtCodigoCalzado = new JTextField();
		txtCodigoCalzado.setBounds(70, 26, 246, 22);
		pnl_calzado.add(txtCodigoCalzado);
		txtCodigoCalzado.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoCalzado.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtCodigoCalzado.setDisabledTextColor(Color.GRAY);
		txtCodigoCalzado.setColumns(10);
		
		btnBuscarCalzado = new JButton("");
		btnBuscarCalzado.setIcon(new ImageIcon(Pnl_Content_Venta.class.getResource("/img/flecha_right.png")));
		btnBuscarCalzado.addActionListener(this);
		btnBuscarCalzado.setBounds(316, 25, 34, 24);
		pnl_calzado.add(btnBuscarCalzado);
		
		lblUnidades = new JLabel("UNID.");
		lblUnidades.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUnidades.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUnidades.setBounds(10, 52, 50, 22);
		pnl_calzado.add(lblUnidades);
		
		lblTotal = new JLabel("TOTAL :");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotal.setBounds(180, 52, 50, 22);
		pnl_calzado.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setEnabled(false);
		txtTotal.setText("S/. 3200.00");
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtTotal.setDisabledTextColor(Color.DARK_GRAY);
		txtTotal.setColumns(10);
		txtTotal.setBounds(240, 52, 110, 22);
		pnl_calzado.add(txtTotal);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAgregar.setBounds(10, 105, 89, 30);
		pnl_calzado.add(btnAgregar);
		
		pnl_Informacion = new JPanel();
		pnl_Informacion.setBackground(Library.Crema);
		pnl_Informacion.setBounds(365, 15, 455, 120);
		pnl_calzado.add(pnl_Informacion);
		pnl_Informacion.setLayout(null);
		
		lblModelo = new JLabel("MODELO :");
		lblModelo.setBounds(64, 37, 75, 22);
		pnl_Informacion.add(lblModelo);
		lblModelo.setForeground(Color.DARK_GRAY);
		lblModelo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblMarca = new JLabel("MARCA :");
		lblMarca.setBounds(64, 63, 75, 22);
		pnl_Informacion.add(lblMarca);
		lblMarca.setForeground(Color.DARK_GRAY);
		lblMarca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblCategoria = new JLabel("CATEGORIA :");
		lblCategoria.setBounds(64, 89, 75, 22);
		pnl_Informacion.add(lblCategoria);
		lblCategoria.setForeground(Color.DARK_GRAY);
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblPrecio = new JLabel("PRECIO :");
		lblPrecio.setBounds(64, 11, 75, 22);
		pnl_Informacion.add(lblPrecio);
		lblPrecio.setForeground(Color.DARK_GRAY);
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblStock = new JLabel("STOCK :");
		lblStock.setBounds(269, 11, 55, 22);
		pnl_Informacion.add(lblStock);
		lblStock.setForeground(Color.DARK_GRAY);
		lblStock.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblTalla = new JLabel("TALLA :");
		lblTalla.setBounds(269, 37, 55, 22);
		pnl_Informacion.add(lblTalla);
		lblTalla.setForeground(Color.DARK_GRAY);
		lblTalla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTalla.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblColor = new JLabel("COLOR :");
		lblColor.setBounds(269, 63, 55, 22);
		pnl_Informacion.add(lblColor);
		lblColor.setForeground(Color.DARK_GRAY);
		lblColor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblValorPrecio = new JLabel("S/. 15.00");
		lblValorPrecio.setBounds(153, 11, 100, 22);
		pnl_Informacion.add(lblValorPrecio);
		lblValorPrecio.setForeground(Color.DARK_GRAY);
		lblValorPrecio.setHorizontalAlignment(SwingConstants.LEFT);
		lblValorPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblValorModelo = new JLabel("1CEA003");
		lblValorModelo.setBounds(153, 37, 100, 22);
		pnl_Informacion.add(lblValorModelo);
		lblValorModelo.setForeground(Color.DARK_GRAY);
		lblValorModelo.setHorizontalAlignment(SwingConstants.LEFT);
		lblValorModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblValorMarca = new JLabel("Basement");
		lblValorMarca.setBounds(153, 63, 100, 22);
		pnl_Informacion.add(lblValorMarca);
		lblValorMarca.setForeground(Color.DARK_GRAY);
		lblValorMarca.setHorizontalAlignment(SwingConstants.LEFT);
		lblValorMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblValorCategoria = new JLabel("Vestir");
		lblValorCategoria.setBounds(153, 89, 100, 22);
		pnl_Informacion.add(lblValorCategoria);
		lblValorCategoria.setForeground(Color.DARK_GRAY);
		lblValorCategoria.setHorizontalAlignment(SwingConstants.LEFT);
		lblValorCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblValorStock = new JLabel("13");
		lblValorStock.setBounds(338, 11, 30, 22);
		pnl_Informacion.add(lblValorStock);
		lblValorStock.setForeground(Color.DARK_GRAY);
		lblValorStock.setHorizontalAlignment(SwingConstants.LEFT);
		lblValorStock.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblValorTalla = new JLabel("41");
		lblValorTalla.setBounds(338, 37, 90, 22);
		pnl_Informacion.add(lblValorTalla);
		lblValorTalla.setForeground(Color.DARK_GRAY);
		lblValorTalla.setHorizontalAlignment(SwingConstants.LEFT);
		lblValorTalla.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblValorColor = new JLabel("NEGRO");
		lblValorColor.setBounds(338, 63, 90, 22);
		pnl_Informacion.add(lblValorColor);
		lblValorColor.setForeground(Color.DARK_GRAY);
		lblValorColor.setHorizontalAlignment(SwingConstants.LEFT);
		lblValorColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblPares = new JLabel("PARES");
		lblPares.setBounds(368, 11, 60, 22);
		pnl_Informacion.add(lblPares);
		lblPares.setForeground(Color.DARK_GRAY);
		lblPares.setHorizontalAlignment(SwingConstants.LEFT);
		lblPares.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		pnl_unidades = new JPanel();
		pnl_unidades.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		pnl_unidades.setBackground(Color.WHITE);
		pnl_unidades.setBounds(70, 52, 90, 22);
		pnl_calzado.add(pnl_unidades);
		pnl_unidades.setLayout(null);
		
		txtUnidades = new JTextField();
		txtUnidades.setText("1");
		txtUnidades.setBounds(0, 0, 44, 22);
		pnl_unidades.add(txtUnidades);
		txtUnidades.setHorizontalAlignment(SwingConstants.CENTER);
		txtUnidades.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUnidades.setDisabledTextColor(Color.GRAY);
		txtUnidades.setColumns(10);
		
		btnAumentar = new JButton("");
		btnAumentar.setBounds(44, 1, 23, 20);
		pnl_unidades.add(btnAumentar);

		btnDisminuir = new JButton("");
		btnDisminuir.setBounds(66, 1, 23, 20);
		pnl_unidades.add(btnDisminuir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 316, 830, 223);
		panel.add(scrollPane);
		
		tblVenta = new JTable();
		tblVenta.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblVenta);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CANTIDAD");
		modelo.addColumn("CODIGO");
		modelo.addColumn("CALZADO");
		modelo.addColumn("PRECIO(PV)");
		modelo.addColumn("IMPORTE");
		tblVenta.setModel(modelo);
		
		
//		txtNombre.requestFocus();

	}
		
	public void paint(Graphics hoja){
		
		super.paint(hoja);
		Graphics2D hoja2d = (Graphics2D)hoja;
		BasicStroke grosor1 = new BasicStroke(2);
		
		// El Rectangulo Crema es un Panel de color Crema no se dibuja
		
		// la sombra
		hoja2d.setColor(Library.Claro_2);
		for (int i = 0; i < 4; i++) {
			hoja2d.fillRect(385, 238 + i*26, 25, 4);
		}
		
		for (int j = 0; j < 4; j++) {
			hoja2d.fillOval(395, 231 + j*26, 18, 18);
		}
		hoja2d.drawLine(385, 340, 839, 340);
		
		
		// la perforacion de la hoja
		hoja2d.setColor(Library.Menu);
		for (int i = 0; i < 4; i++) {
			hoja2d.fillRect(385, 239 + i*26, 25, 4);
		}
		for (int j = 0; j < 4; j++) {
			hoja2d.fillOval(395, 232 + j*26, 18, 18);
		}
		
		// las cuadriculas de la hoja
		hoja2d.setStroke(grosor1);
		
		hoja2d.setColor(Library.Celeste);
		for (int k = 0; k < 5; k++){
			hoja2d.drawLine(390, 228 + k*26, 835, 228 + k*26 );
		}
		
		hoja2d.setColor(Library.Rojo);
		hoja2d.drawLine(420, 222, 420, 338);

		
		
	}
	
	// -------------------------------------------------------------------
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscarCalzado) {
			Dlg_Buscador_Calzado buscadorCalzado = new Dlg_Buscador_Calzado();
			buscadorCalzado.setLocationRelativeTo(pnl_venta_main);
//			buscadorCalzado.setModal(true); --> el modal se configura en las propiedades "Design" dentro del mismos JDialog
			buscadorCalzado.setVisible(true);
		}
	}
}










// -->

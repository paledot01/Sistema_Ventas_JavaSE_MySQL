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
import utils.RendererTableVenta;
import utils.SimpleDocumentListener;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.apache.xmlbeans.GDurationSpecification;

import Controlador.CalzadoGestionDao;
import Controlador.DistritoGestionDao;
import Controlador.VentaGestionDao;
import entidad.Boleta_Detalle;
import entidad.CalzadoReporte;
import entidad.Distrito;
import entidad.Empleado;

import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ContainerListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ContainerEvent;
import java.awt.Cursor;

public class Pnl_Content_Venta extends JPanel implements ActionListener, MouseListener{
	private JPanel pnl_venta_main;
	private JLabel lblVenta;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField txtNumeroBoleta;
	private JLabel lblNroBoleta;
	private JLabel lblVendedor;
	private JTextField txtVendedor;
	private JLabel lblCliente;
	private JTextField txtNombre;
	private JPanel panel_2;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblDistrito;
	private JComboBox cboDistrito;
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
	private CalzadoGestionDao gCalzado = new CalzadoGestionDao(); // --
	private VentaGestionDao gVenta = new VentaGestionDao(); // --
	private DistritoGestionDao gDistrito = new DistritoGestionDao(); // --
	private Empleado empConectado = Pnl_Access_Login.empleadoConectado;
	
	RendererTableVenta render = new RendererTableVenta(); // --
	
	private CalzadoReporte obj = null; // -- Para que mantenga el ultimo valor encontrado y podamos usarlo.
	private JTextField txtTotalVenta;
	private JButton btnNewButton;

//	private JButton btnCancelar = new JButton(); // <<< BOTON ELIMINAR
	private ImageIcon imgCancelar = new ImageIcon(Pnl_Content_Venta.class.getResource("/img/cancelar_red.png"));
	private JLabel btnCancelar = new JLabel(imgCancelar); // BOTON CANCELAR DE LA TABLA
	private JTextField txtTotal_1;
	private JButton btnCancelarVenta;
	private JLabel label;
	private JLabel label_1;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTextField textField_1;
	private JTextField textField_2;
//	private ArrayList<Boleta_Detalle> detBoleta = new ArrayList<Boleta_Detalle>();
	

	
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
		
		txtNumeroBoleta = new JTextField();
		txtNumeroBoleta.setEnabled(false);
		txtNumeroBoleta.setText("-----");
		txtNumeroBoleta.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroBoleta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNumeroBoleta.setDisabledTextColor(Color.GRAY);
		txtNumeroBoleta.setColumns(10);
		txtNumeroBoleta.setBounds(122, 7, 91, 22);
		panel_1.add(txtNumeroBoleta);
		
		lblNroBoleta = new JLabel("NUMERO BOLETA");
		lblNroBoleta.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblNroBoleta.setBounds(10, 7, 102, 22);
		panel_1.add(lblNroBoleta);
		
		lblVendedor = new JLabel("VENDEDOR");
		lblVendedor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVendedor.setBounds(468, 7, 85, 22);
		panel_1.add(lblVendedor);
		lblVendedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtVendedor = new JTextField(empConectado.getNombre() + " " + empConectado.getApellidos()); // <<<<
		txtVendedor.setBounds(563, 7, 257, 22);
		panel_1.add(txtVendedor);
		txtVendedor.setHorizontalAlignment(SwingConstants.CENTER);
		txtVendedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtVendedor.setEnabled(false);
		txtVendedor.setDisabledTextColor(Color.GRAY);
		txtVendedor.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "CLIENTE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel_2.setBounds(10, 58, 830, 90);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(70, 26, 140, 22);
		panel_2.add(txtNombre);
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombre.setDisabledTextColor(Color.GRAY);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtApellido.setDisabledTextColor(Color.GRAY);
		txtApellido.setColumns(10);
		txtApellido.setBounds(294, 26, 176, 22);
		panel_2.add(txtApellido);
		
		txtDni = new JTextField();
		txtDni.setHorizontalAlignment(SwingConstants.CENTER);
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDni.setDisabledTextColor(Color.GRAY);
		txtDni.setColumns(10);
		txtDni.setBounds(70, 52, 140, 22);
		panel_2.add(txtDni);
		
		txtTelefono = new JTextField();
		txtTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTelefono.setDisabledTextColor(Color.GRAY);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(294, 52, 176, 22);
		panel_2.add(txtTelefono);
		
		cboDistrito = new JComboBox();
		cboDistrito.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboDistrito.setBounds(555, 52, 140, 22);
		panel_2.add(cboDistrito);
		
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
		
		lblDni = new JLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDni.setBounds(10, 52, 50, 22);
		panel_2.add(lblDni);
		
		lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefono.setBounds(220, 52, 64, 22);
		panel_2.add(lblTelefono);
		
		lblDistrito = new JLabel("DISTRITO");
		lblDistrito.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDistrito.setBounds(480, 52, 65, 22);
		panel_2.add(lblDistrito);
		
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
		txtCodigoCalzado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodigoCalzado.setDisabledTextColor(Color.GRAY);
		txtCodigoCalzado.setColumns(10);
		txtCodigoCalzado.getDocument().addDocumentListener(new SimpleDocumentListener() { // <<<<<<<<<<<<<<<<< EVENTO
			@Override
			public void update(DocumentEvent e) {
				String valor = txtCodigoCalzado.getText().trim();
				obj = gCalzado.buscarPorCodigoExacto(valor); // en este caso cuando el valor es incorrecto el obj si se le esta cambiando su valor.
				 
				if(obj==null){
					limpiarSeccionCalzado();
				}else{
					mostrarDatosCalzado(obj);
				}
			}
		});

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
		txtTotal.setText("S/. 00.00");
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtTotal.setDisabledTextColor(Color.DARK_GRAY);
		txtTotal.setColumns(10);
		txtTotal.setBounds(240, 52, 110, 22);
		pnl_calzado.add(txtTotal);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setIcon(new ImageIcon(Pnl_Content_Venta.class.getResource("/img/cart_30px.png")));
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAgregar.setBounds(10, 105, 120, 30);
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
		
		lblValorPrecio = new JLabel("S/. 00.00");
		lblValorPrecio.setBounds(153, 11, 100, 22);
		pnl_Informacion.add(lblValorPrecio);
		lblValorPrecio.setForeground(Color.DARK_GRAY);
		lblValorPrecio.setHorizontalAlignment(SwingConstants.LEFT);
		lblValorPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblValorModelo = new JLabel("-");
		lblValorModelo.setBounds(153, 37, 100, 22);
		pnl_Informacion.add(lblValorModelo);
		lblValorModelo.setForeground(Color.DARK_GRAY);
		lblValorModelo.setHorizontalAlignment(SwingConstants.LEFT);
		lblValorModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblValorMarca = new JLabel("-");
		lblValorMarca.setBounds(153, 63, 100, 22);
		pnl_Informacion.add(lblValorMarca);
		lblValorMarca.setForeground(Color.DARK_GRAY);
		lblValorMarca.setHorizontalAlignment(SwingConstants.LEFT);
		lblValorMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblValorCategoria = new JLabel("-");
		lblValorCategoria.setBounds(153, 89, 100, 22);
		pnl_Informacion.add(lblValorCategoria);
		lblValorCategoria.setForeground(Color.DARK_GRAY);
		lblValorCategoria.setHorizontalAlignment(SwingConstants.LEFT);
		lblValorCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblValorStock = new JLabel("-");
		lblValorStock.setBounds(338, 11, 30, 22);
		pnl_Informacion.add(lblValorStock);
		lblValorStock.setForeground(Color.DARK_GRAY);
		lblValorStock.setHorizontalAlignment(SwingConstants.LEFT);
		lblValorStock.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblValorTalla = new JLabel("-");
		lblValorTalla.setBounds(338, 37, 90, 22);
		pnl_Informacion.add(lblValorTalla);
		lblValorTalla.setForeground(Color.DARK_GRAY);
		lblValorTalla.setHorizontalAlignment(SwingConstants.LEFT);
		lblValorTalla.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblValorColor = new JLabel("-");
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
		txtUnidades.setColumns(10);
		txtUnidades.setText("0");
		txtUnidades.setBounds(0, 0, 44, 22);
		txtUnidades.setHorizontalAlignment(SwingConstants.CENTER);
		txtUnidades.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUnidades.setDisabledTextColor(Color.GRAY);
		txtUnidades.getDocument().addDocumentListener(new SimpleDocumentListener() { // <<<<<<<<<<<<<<<<< EVENTO
			@Override
			public void update(DocumentEvent e) {
				
				if(obj != null){
					int unid = leerUnidades();
					generarTotal();
				}
			}
			
		});
		pnl_unidades.add(txtUnidades);

		
		btnAumentar = new JButton("");
		btnAumentar.setIcon(new ImageIcon(Pnl_Content_Venta.class.getResource("/img/mas.png")));
		btnAumentar.addActionListener(this);
		btnAumentar.setBounds(44, 1, 23, 20);
		pnl_unidades.add(btnAumentar);
		
		btnDisminuir = new JButton();
		btnDisminuir.setBounds(66, 1, 23, 20);
		pnl_unidades.add(btnDisminuir);
		btnDisminuir.setIcon(new ImageIcon(Pnl_Content_Venta.class.getResource("/img/menos.png")));
		btnDisminuir.addActionListener(this);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 316, 830, 187);
		panel.add(scrollPane);
		
		tblVenta = new JTable();
		tblVenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblVenta.setFillsViewportHeight(true);
		tblVenta.setRowHeight(23);
		tblVenta.setDefaultRenderer(Object.class, render); // <<<<<<<<
		tblVenta.addMouseListener(this);
		scrollPane.setViewportView(tblVenta);
		
		
		// para que el todo el modelo de la tabla no sea editable, si queremos que solo 
		// la columna 3 no sea editable remplazariamos false por "column == 3"
		modelo = new DefaultTableModel(){
			public boolean isCellEditable(int row, int column){

				return false;
			}
		};
		
		modelo.addColumn("CANTIDAD");
		modelo.addColumn("CODIGO");
		modelo.addColumn("MARCA");
		modelo.addColumn("MODELO");
		modelo.addColumn("PRECIO");
		modelo.addColumn("IMPORTE");
		modelo.addColumn("");
		

		tblVenta.setModel(modelo);
		
		tblVenta.getColumnModel().getColumn(0).setPreferredWidth(90);
		tblVenta.getColumnModel().getColumn(1).setPreferredWidth(90);
		tblVenta.getColumnModel().getColumn(2).setPreferredWidth(190);
		tblVenta.getColumnModel().getColumn(3).setPreferredWidth(190);
		tblVenta.getColumnModel().getColumn(4).setPreferredWidth(120);
		tblVenta.getColumnModel().getColumn(5).setPreferredWidth(120);
		tblVenta.getColumnModel().getColumn(6).setPreferredWidth(23);
		
		btnCancelar.addMouseListener(this);
		btnCancelar.setFocusable(false);
		
		txtNumeroBoleta.setText(gVenta.generarCodigo());
		
		txtTotalVenta = new JTextField();
		txtTotalVenta.setEnabled(false);
		txtTotalVenta.setText("S/. 00.00");
		txtTotalVenta.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalVenta.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtTotalVenta.setDisabledTextColor(Color.DARK_GRAY);
		txtTotalVenta.setColumns(10);
		txtTotalVenta.setBounds(681, 514, 159, 30);
		panel.add(txtTotalVenta);
		
		btnNewButton = new JButton("Realizar Venta");
		btnNewButton.setIcon(new ImageIcon(Pnl_Content_Venta.class.getResource("/img/dollar_32px2.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(596, 555, 244, 47);
		panel.add(btnNewButton);
		
		txtTotal_1 = new JTextField();
		txtTotal_1.setEnabled(false);
		txtTotal_1.setText("TOTAL :");
		txtTotal_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTotal_1.setDisabledTextColor(Color.DARK_GRAY);
		txtTotal_1.setColumns(10);
		txtTotal_1.setBounds(596, 514, 86, 30);
		panel.add(txtTotal_1);
		
		btnCancelarVenta = new JButton("Cancelar Venta");
		btnCancelarVenta.addActionListener(this);
		btnCancelarVenta.setIcon(new ImageIcon(Pnl_Content_Venta.class.getResource("/img/cancelar_red.png")));
		btnCancelarVenta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelarVenta.setBounds(10, 567, 147, 35);
		panel.add(btnCancelarVenta);
		
		label = new JLabel("");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setOpaque(true);
		label.setBackground(SystemColor.inactiveCaption);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Pnl_Content_Venta.class.getResource("/img/recibo_ticket.png")));
		label.setBounds(239, 555, 50, 47);
		panel.add(label);
		
		label_1 = new JLabel("");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setBackground(SystemColor.inactiveCaption);
		label_1.setOpaque(true);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon(Pnl_Content_Venta.class.getResource("/img/recibo_A4.png")));
		label_1.setBounds(179, 555, 50, 47);
		panel.add(label_1);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		panel_3.setBounds(584, 514, 2, 88);
		panel.add(panel_3);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		panel_4.setBounds(167, 514, 2, 88);
		panel.add(panel_4);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setDisabledTextColor(Color.GRAY);
		textField_1.setColumns(10);
		textField_1.setBounds(468, 514, 106, 30);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_2.setDisabledTextColor(Color.GRAY);
		textField_2.setColumns(10);
		textField_2.setBounds(352, 514, 106, 30);
		panel.add(textField_2);
		
		listarDistritosCbo();
		// tblVenta.setValueAt(aValue, row, column); MODIFICAR MODIFICAR MODIFICAR MODIFICAR MODIFICAR MODIFICAR MODIFICAR MODIFICAR MODIFICAR MODIFICAR MODIFICAR 
	}
		
	public void listarDistritosCbo(){
		
		ArrayList<Distrito> listDistrito = gDistrito.listarDistrito();
		
		for(Distrito dis : listDistrito){
			cboDistrito.addItem(dis.getDescripcion());
		}
	}
	
	void limpiarSeccionCliente(){
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		txtTelefono.setText("");
		cboDistrito.setSelectedIndex(0);
		
	}
	
	void limpiarSeccionCalzado(){
		lblValorPrecio.setText("S/. 00.00");
		lblValorStock.setText("-");
		lblValorModelo.setText("-");
		lblValorTalla.setText("-");
		lblValorMarca.setText("-");
		lblValorColor.setText("-");
		lblValorCategoria.setText("-");
		txtUnidades.setText("0");
		txtTotal.setText("S/. 00.00");
	}
	
	void mostrarDatosCalzado(CalzadoReporte obj){
		lblValorPrecio.setText(String.format("S/. %.2f", obj.getPrecio_venta()));
		lblValorStock.setText(String.valueOf(obj.getStock()));
		lblValorModelo.setText(obj.getNombre_modelo());
		lblValorTalla.setText(String.valueOf(obj.getTalla()));
		lblValorMarca.setText(obj.getNombre_marca());
		lblValorColor.setText(obj.getColor());
		lblValorCategoria.setText(obj.getDescripcion_categoria());
		txtUnidades.setText("1");
		txtTotal.setText(String.format("S/. %.2f", obj.getPrecio_venta()));
	}
	
	int leerUnidades(){ // devuelve 0 si no cumple con todas las condiciones.
		int unid = 0;
		try{
			unid = Integer.parseInt(txtUnidades.getText().trim()) ; // no puede ser ni cadena ni vacio
			if(unid < 0 || unid > obj.getStock() ){ // debe ser mayor a 0 pero menor igual que el stock
				unid = 0;
			}
		}catch(NumberFormatException e){
		}
		
		return unid;
	}
	
	void generarTotal(){ // lee las unidades, calcula el total y lo imprime
		
		int unid = leerUnidades();
		if(obj != null){
			txtTotal.setText(String.format("S/. %.2f", obj.getPrecio_venta()*unid));
		}
		
	}
	
	double getTotalVenta(){
		
		int numFilas = modelo.getRowCount();
		double total = 0.0;
		double precio = 0.8;
		for (int i = 0; i < numFilas ; i++){
			precio = Double.parseDouble(tblVenta.getValueAt(i, 5).toString());
			total += precio;
		}
		
		return total;
	}
	
	
//	void guardarCalzadoEnDetalles(){
//		
//		Boleta_Detalle calzado =null;
//		if(obj != null){
//			String codBoleta = txtNumeroBoleta.getText();
//			String codCalzado = txtCodigoCalzado.getText().trim();
//			int cantidad  = Integer.parseInt(txtUnidades.getText());
//			double importe = obj.getPrecio_venta()*cantidad;
//			
//			calzado = new Boleta_Detalle(codBoleta, codCalzado, cantidad, importe);
//			
//			detBoleta.add(calzado);
//		}
//	}
	
	void agregarProductoTabla(){
		
		if(obj != null){
				Object fila[] = {
						leerUnidades(),
						obj.getCod_calzado(),
						obj.getNombre_marca(),
						obj.getNombre_modelo(),
						obj.getPrecio_venta(),
						leerUnidades() * obj.getPrecio_venta(),
						btnCancelar
				};
				modelo.addRow(fila);
		}
	}
	
	public void paint(Graphics hoja){ // Metodo para dibujar la hoja de descripcion del calzado.
		
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
	
	int buscarFilaCalzadoRepetido(){ // si encuentra el calzado en la tabla devuelve la fila, si no -1
		
		int numFilas = modelo.getRowCount();
		String codigo = "";
		
		for(int i = 0; i < numFilas; i++){
			codigo = tblVenta.getValueAt(i, 1).toString();
			if(obj.getCod_calzado().equals(codigo)){ // encuentra el ultimo
				return i;
			}
		}
		return -1; // -1 porque la fila de la tabla puede ser 0
	}
	
	// -----------------------------------------------------------------------------------------
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancelarVenta) {
			modelo.setRowCount(0);
			txtCodigoCalzado.setText("");
			limpiarSeccionCliente();
			txtNombre.requestFocus();
		}
		if (arg0.getSource() == btnAgregar) {
			// Comprueba que el calzado que se va agregar exista
			// Luego que las unidades que se elija sea la correcta
			// Si el calzado no existe en la tabla se agrega si ya existe se modifica
			// Y siempre se actualiza el monto Total de la venta asi se agrege o se modifique.
			if(obj != null){
				int unid = leerUnidades();
				if(unid != 0){
					int fila = buscarFilaCalzadoRepetido();
					if(fila == -1){
						agregarProductoTabla(); // si las unidades es 0(cualquier error) no se llena ninguna fila
					}else{
//						modelo.removeRow(fila);
						tblVenta.setValueAt(unid, fila, 0);
						tblVenta.setValueAt(unid*obj.getPrecio_venta(), fila, 5);
					}
					txtTotalVenta.setText(String.format("S/. %.2f", getTotalVenta())); // si el numero de filas es 0, getToralVenta() siempre regresará 0.0
				}
			}
		}
		if (arg0.getSource() == btnDisminuir) {
			if(obj != null){
				int unidades = leerUnidades();
				if(unidades > 1)
					unidades--;
				txtUnidades.setText(String.valueOf(unidades));
				generarTotal();
			}
		}
		if (arg0.getSource() == btnAumentar) {			
			if(obj != null){
				int unidades = leerUnidades();
				if(unidades < obj.getStock()){
					unidades++;
					txtUnidades.setText(String.valueOf(unidades));
					generarTotal();
				}
			}
		}
		if (arg0.getSource() == btnBuscarCalzado) {
			Dlg_Buscador_Calzado buscadorCalzado = new Dlg_Buscador_Calzado();
			buscadorCalzado.setLocationRelativeTo(pnl_venta_main);
			// buscadorCalzado.setModal(true); --> el modal se configura en las propiedades "Design" dentro del mismos JDialog
			buscadorCalzado.setVisible(true);
		}
	}

	// ------------------------------------------------------------------------------------------
	
	@Override
	public void mouseClicked(MouseEvent e) { }
	@Override
	public void mouseEntered(MouseEvent e) { }
	@Override
	public void mouseExited(MouseEvent e) { }
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == tblVenta){ // << 
			int fila = tblVenta.rowAtPoint(e.getPoint());
			int columna = tblVenta.columnAtPoint(e.getPoint());
			
			
			if( fila != -1){
				if(columna == 6){
					modelo.removeRow(fila);
				}else{
					String codigo = tblVenta.getValueAt(fila, 1).toString();
					txtCodigoCalzado.setText(codigo);
				}
			}
			txtTotalVenta.setText(String.format("S/. %.2f", getTotalVenta()));
		
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) { }
}



// --> MODIFICAR LA CANTIDAD DE LOS CALZADOS YA AGREGADOS

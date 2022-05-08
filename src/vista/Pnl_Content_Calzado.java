package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controlador.MarcaGestionDao;
import entidad.Marca;

import java.awt.SystemColor;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JSplitPane;
import javax.swing.border.EtchedBorder;

public class Pnl_Content_Calzado extends JPanel {
	private JPanel pnl_calzado_main;
	private JTable tblCalzado;
	private JScrollPane scrollPane;

	// Modelo tabla
	private DefaultTableModel modeloCalzado = new DefaultTableModel();
	private DefaultTableModel modeloMarca = new DefaultTableModel();
	private MarcaGestionDao gMarca = new MarcaGestionDao();
	private JLabel lblCodigo;
	private JLabel lblModelo;
	private JLabel lblTalla;
	private JLabel lblColor;
	private JLabel lblStock;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPanel panel_2;
	private JLabel lblCalzado;
	private JPanel panel_1;
	private JPanel panel_3;
	private JLabel lblBuscar;
	private JTextField textField_6;
	private JButton btnNewButton;
	private JLabel lblCodMarca;
	private JLabel lblNombreMarca;
	private JTextField txtNombreMarca;
	private JTextField txtCodMarca;
	private JTable tblMarca;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton_1;
	private JButton btnX;
	private JButton btnG;
	private JButton btnM;
	
	/**
	 * Create the panel.
	 */
	public Pnl_Content_Calzado() {
		setLayout(null);
		
		pnl_calzado_main = new JPanel();
		pnl_calzado_main.setBounds(0, 0, 870, 670);
		add(pnl_calzado_main);
		pnl_calzado_main.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 198, 850, 245);
		pnl_calzado_main.add(scrollPane);
		
		tblCalzado = new JTable();
		tblCalzado.setEnabled(false);
		tblCalzado.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCalzado);
		
		// Modelo tabla calzado
		modeloCalzado.addColumn("CODIGO");
		modeloCalzado.addColumn("MARCA");
		modeloCalzado.addColumn("MODELO");
		modeloCalzado.addColumn("TALLA");
		modeloCalzado.addColumn("COLOR");
		modeloCalzado.addColumn("CATEGORIA");
		modeloCalzado.addColumn("P.VENTA");
		modeloCalzado.addColumn("STOCK");
		
		tblCalzado.setModel(modeloCalzado);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.GRAY));
		panel_2.setBounds(10, 454, 850, 205);
		pnl_calzado_main.add(panel_2);
		panel_2.setLayout(null);
		
		lblCodMarca = new JLabel("Codigo");
		lblCodMarca.setEnabled(false);
		lblCodMarca.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblCodMarca.setBounds(10, 11, 60, 22);
		panel_2.add(lblCodMarca);
		
		lblNombreMarca = new JLabel("Nombre");
		lblNombreMarca.setEnabled(false);
		lblNombreMarca.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblNombreMarca.setBounds(10, 44, 60, 22);
		panel_2.add(lblNombreMarca);
		
		txtNombreMarca = new JTextField();
		txtNombreMarca.setEnabled(false);
		txtNombreMarca.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreMarca.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtNombreMarca.setColumns(10);
		txtNombreMarca.setBounds(68, 44, 114, 22);
		panel_2.add(txtNombreMarca);
		
		txtCodMarca = new JTextField();
		txtCodMarca.setText("xxxxx");
		txtCodMarca.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodMarca.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtCodMarca.setEnabled(false);
		txtCodMarca.setDisabledTextColor(Color.GRAY);
		txtCodMarca.setColumns(10);
		txtCodMarca.setBounds(68, 12, 114, 22);
		panel_2.add(txtCodMarca);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 83, 254, 111);
		panel_2.add(scrollPane_1);
		
		tblMarca = new JTable();
		tblMarca.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tblMarca);
		
		lblCalzado = new JLabel("CALZADO");
		lblCalzado.setOpaque(true);
		lblCalzado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalzado.setForeground(SystemColor.menu);
		lblCalzado.setFont(new Font("Courier New", Font.BOLD, 20));
		lblCalzado.setBackground(SystemColor.controlDkShadow);
		lblCalzado.setBounds(10, 11, 850, 24);
		pnl_calzado_main.add(lblCalzado);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.GRAY));
		panel_1.setBounds(10, 46, 850, 45);
		pnl_calzado_main.add(panel_1);
		panel_1.setLayout(null);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 11, 60, 22);
		panel_1.add(lblCodigo);
		lblCodigo.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		
		lblNewLabel_1 = new JLabel("CZ10001");
		lblNewLabel_1.setBounds(80, 11, 72, 22);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblNewLabel_1.setEnabled(false);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(162, 11, 60, 22);
		panel_1.add(lblModelo);
		lblModelo.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setBounds(220, 11, 100, 22);
		panel_1.add(textField);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField.setColumns(10);
		
		lblTalla = new JLabel("Talla");
		lblTalla.setBounds(330, 11, 53, 22);
		panel_1.add(lblTalla);
		lblTalla.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		
		textField_1 = new JTextField();
		textField_1.setBounds(393, 11, 100, 22);
		panel_1.add(textField_1);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField_1.setColumns(10);
		
		lblColor = new JLabel("Color");
		lblColor.setBounds(503, 11, 53, 22);
		panel_1.add(lblColor);
		lblColor.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		
		textField_2 = new JTextField();
		textField_2.setBounds(566, 11, 100, 22);
		panel_1.add(textField_2);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField_2.setColumns(10);
		
		lblStock = new JLabel("Stock");
		lblStock.setBounds(676, 11, 53, 22);
		panel_1.add(lblStock);
		lblStock.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		
		textField_3 = new JTextField();
		textField_3.setBounds(739, 11, 101, 22);
		panel_1.add(textField_3);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField_3.setColumns(10);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.GRAY));
		panel_3.setLayout(null);
		panel_3.setBounds(10, 102, 850, 45);
		pnl_calzado_main.add(panel_3);
		
		lblBuscar = new JLabel("Buscar");
		lblBuscar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblBuscar.setBounds(10, 11, 60, 22);
		panel_3.add(lblBuscar);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField_6.setColumns(10);
		textField_6.setBounds(80, 12, 143, 22);
		panel_3.add(textField_6);
		
		btnNewButton = new JButton("B");
		btnNewButton.setBounds(233, 11, 39, 23);
		panel_3.add(btnNewButton);
		
		modeloMarca.addColumn("CODIGO");
		modeloMarca.addColumn("NOMBRE");
		tblMarca.setModel(modeloMarca);
		
		btnNewButton_1 = new JButton("N");
		btnNewButton_1.setBounds(200, 11, 39, 23);
		panel_2.add(btnNewButton_1);
		
		btnX = new JButton("X");
		btnX.setVisible(false);
		btnX.setBounds(200, 44, 39, 23);
		panel_2.add(btnX);
		
		btnG = new JButton("G");
		btnG.setBounds(249, 11, 39, 23);
		panel_2.add(btnG);
		
		btnM = new JButton("M");
		btnM.setBounds(249, 44, 40, 23);
		panel_2.add(btnM);
		
		mostrarDataTabla();

	}
	
	public void mostrarDataTabla(){
		
		modeloMarca.setRowCount(0);
		ArrayList<Marca> data = gMarca.listar();
		
		for (Marca m : data) {
			
			Object fila[] = {
					m.getCod_marca(),
					m.getNombre_marca(),
					
			};
			modeloMarca.addRow(fila);

		}
	}
	
	
	
	
	
	
	
}






















// aa

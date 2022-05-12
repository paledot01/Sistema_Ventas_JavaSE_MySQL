package vista;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Controlador.CategoriaGestionDao;
import Controlador.MarcaGestionDao;
import Controlador.ModeloGestionDao;
import entidad.Modelo;
import utils.Library;
import utils.RendererTable;
import utils.RendererTable6;

import javax.swing.JScrollPane;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class Pnl_Content_Calzado_Modelo extends JPanel {
	private JPanel pnl_content_calzado_modelo;
	private JTable tblModelo;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JTextField textField;
	private JLabel label;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNombre;
	private JLabel lblCategoria;
	private JLabel lblMarca;
	private JButton button;
	private JTextField textField_5;
	private JLabel lblPc;
	private JButton button_1;
	private JButton button_2;
	private JLabel lblPv;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JTextField textField_3;
	private JButton button_3;
	
	
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
		
		tblModelo = new JTable();
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
		
		textField = new JTextField();
		textField.setText("xxxxx");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField.setEnabled(false);
		textField.setDisabledTextColor(Color.GRAY);
		textField.setColumns(10);
		textField.setBounds(63, 7, 91, 22);
		panel.add(textField);
		
		label = new JLabel("Codigo");
		label.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		label.setBounds(10, 7, 42, 22);
		panel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField_1.setDisabledTextColor(Color.GRAY);
		textField_1.setColumns(10);
		textField_1.setBounds(254, 15, 196, 22);
		pnl_content_calzado_modelo.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField_2.setDisabledTextColor(Color.GRAY);
		textField_2.setColumns(10);
		textField_2.setBounds(82, 59, 125, 22);
		pnl_content_calzado_modelo.add(textField_2);
		
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
		
		button = new JButton("");
		button.setBounds(460, 103, 30, 30);
		pnl_content_calzado_modelo.add(button);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField_5.setDisabledTextColor(Color.GRAY);
		textField_5.setColumns(10);
		textField_5.setBounds(254, 59, 69, 22);
		pnl_content_calzado_modelo.add(textField_5);
		
		lblPc = new JLabel("P.C");
		lblPc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPc.setEnabled(false);
		lblPc.setBounds(217, 59, 27, 22);
		pnl_content_calzado_modelo.add(lblPc);
		
		button_1 = new JButton("");
		button_1.setBounds(460, 11, 30, 30);
		pnl_content_calzado_modelo.add(button_1);
		
		button_2 = new JButton("");
		button_2.setBounds(460, 62, 30, 30);
		pnl_content_calzado_modelo.add(button_2);
		
		lblPv = new JLabel("P.V");
		lblPv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPv.setEnabled(false);
		lblPv.setBounds(217, 85, 27, 22);
		pnl_content_calzado_modelo.add(lblPv);
		
		comboBox = new JComboBox();
		comboBox.setBounds(82, 85, 125, 22);
		pnl_content_calzado_modelo.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(82, 111, 125, 22);
		pnl_content_calzado_modelo.add(comboBox_1);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField_3.setDisabledTextColor(Color.GRAY);
		textField_3.setColumns(10);
		textField_3.setBounds(254, 85, 69, 22);
		pnl_content_calzado_modelo.add(textField_3);
		
		button_3 = new JButton("");
		button_3.setBounds(420, 103, 30, 30);
		pnl_content_calzado_modelo.add(button_3);
		
		
		mostrarDataTabla(); // --> Muestra los datos de la tabla modelo
		
		
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
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
// ---------

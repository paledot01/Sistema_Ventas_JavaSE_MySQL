package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Pnl_Content_Calzado extends JPanel implements MouseListener {
	private JPanel pnl_calzado_main;
	private JLabel lblCalzado;
	private JPanel pnl_datos_calzado;
	private JPanel pnl_codigo_calzado;
	private JTextField textField;
	private JLabel label;
	private JLabel lblModelo;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblColor;
	private JTextField textField_3;
	private JLabel lblTalla;
	private JButton btnBuscar;
	private JPanel panel;
	private JLabel btnModelo;
	private JButton button_2;
	private JTextField textField_6;
	private JRadioButton rdbtnNewRadioButton;
	public static JPanel pnl_mod_mar_cat;
	private JLabel lblStock;
	private JLabel lblBuscar;
	private JButton button_5;
	private JRadioButton rdbtnMarca;
	private JRadioButton rdbtnCategoria;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textField_4;
	private JPanel panel_1;
	private JRadioButton rdbtnTalla;
	private JButton button;
	private JButton button_1;
	private JButton button_3;
	private JRadioButton rdbtnColor;
	private JRadioButton radioButton;
	private JButton button_4;
	private JButton button_6;
	private JButton button_7;
	private JLabel btnCategoria;
	private JLabel btnMarca;

	/**
	 * Create the panel.
	 */
	public Pnl_Content_Calzado() {
		setLayout(null);
		
		pnl_calzado_main = new JPanel();
		pnl_calzado_main.setBorder(new LineBorder(new Color( 95, 103, 112 )));
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
		
		textField = new JTextField();
		textField.setText("xxxxx");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField.setEnabled(false);
		textField.setDisabledTextColor(Color.GRAY);
		textField.setColumns(10);
		textField.setBounds(63, 7, 91, 22);
		pnl_codigo_calzado.add(textField);
		
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
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField_1.setDisabledTextColor(Color.GRAY);
		textField_1.setColumns(10);
		textField_1.setBounds(75, 64, 190, 22);
		pnl_datos_calzado.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField_2.setDisabledTextColor(Color.GRAY);
		textField_2.setColumns(10);
		textField_2.setBounds(75, 90, 255, 22);
		pnl_datos_calzado.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField_3.setDisabledTextColor(Color.GRAY);
		textField_3.setColumns(10);
		textField_3.setBounds(75, 116, 90, 22);
		pnl_datos_calzado.add(textField_3);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField_6.setDisabledTextColor(Color.GRAY);
		textField_6.setColumns(10);
		textField_6.setBounds(75, 203, 192, 22);
		pnl_datos_calzado.add(textField_6);
		
		btnBuscar = new JButton("Select");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscar.setBounds(265, 63, 65, 24);
		pnl_datos_calzado.add(btnBuscar);
		
		button_2 = new JButton("");
		button_2.setBounds(10, 151, 30, 30);
		pnl_datos_calzado.add(button_2);
		
		button_5 = new JButton("");
		button_5.setBounds(277, 202, 53, 53);
		pnl_datos_calzado.add(button_5);
		
		rdbtnNewRadioButton = new JRadioButton("Codigo");
		rdbtnNewRadioButton.setBounds(10, 232, 65, 23);
		pnl_datos_calzado.add(rdbtnNewRadioButton);
		
		rdbtnMarca = new JRadioButton("Modelo");
		rdbtnMarca.setBounds(100, 232, 65, 23);
		pnl_datos_calzado.add(rdbtnMarca);
		
		rdbtnCategoria = new JRadioButton("Categoria");
		rdbtnCategoria.setBounds(190, 232, 75, 23);
		pnl_datos_calzado.add(rdbtnCategoria);
		
		rdbtnTalla = new JRadioButton("Talla");
		rdbtnTalla.setBounds(100, 258, 65, 23);
		pnl_datos_calzado.add(rdbtnTalla);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textField_4.setDisabledTextColor(Color.GRAY);
		textField_4.setColumns(10);
		textField_4.setBounds(240, 116, 90, 22);
		pnl_datos_calzado.add(textField_4);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 192, 320, 2);
		pnl_datos_calzado.add(panel_1);
		
		button = new JButton("");
		button.setBounds(300, 151, 30, 30);
		pnl_datos_calzado.add(button);
		
		button_1 = new JButton("");
		button_1.setBounds(260, 151, 30, 30);
		pnl_datos_calzado.add(button_1);
		
		button_3 = new JButton("");
		button_3.setBounds(220, 151, 30, 30);
		pnl_datos_calzado.add(button_3);
		
		rdbtnColor = new JRadioButton("Color");
		rdbtnColor.setBounds(190, 258, 65, 23);
		pnl_datos_calzado.add(rdbtnColor);
		
		radioButton = new JRadioButton("Marca");
		radioButton.setBounds(10, 258, 65, 23);
		pnl_datos_calzado.add(radioButton);
		
		button_4 = new JButton("");
		button_4.setBounds(277, 288, 53, 30);
		pnl_datos_calzado.add(button_4);
		
		button_6 = new JButton("");
		button_6.setBounds(214, 288, 53, 30);
		pnl_datos_calzado.add(button_6);
		
		button_7 = new JButton("");
		button_7.setBounds(151, 288, 53, 30);
		pnl_datos_calzado.add(button_7);
		
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
		btnModelo.setBackground(new Color(95, 103, 112));
		
		btnMarca = new JLabel("MARCA");
		btnMarca.addMouseListener(this);
		btnMarca.setOpaque(true);
		btnMarca.setHorizontalAlignment(SwingConstants.CENTER);
		btnMarca.setForeground(Color.WHITE);
		btnMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMarca.setBackground(new Color(95, 103, 112));
		btnMarca.setBounds(167, 0, 166, 25);
		panel.add(btnMarca);
		
		btnCategoria = new JLabel("CATEGORIA");
		btnCategoria.addMouseListener(this);
		btnCategoria.setOpaque(true);
		btnCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		btnCategoria.setForeground(Color.WHITE);
		btnCategoria.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCategoria.setBackground(new Color(95, 103, 112));
		btnCategoria.setBounds(334, 0, 166, 25);
		panel.add(btnCategoria);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 386, 850, 273);
		pnl_calzado_main.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(95, 103, 112)));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		pnl_mod_mar_cat = new JPanel();
		pnl_mod_mar_cat.setBounds(0, 25, 500, 304);
		panel.add(pnl_mod_mar_cat);
		
		Pnl_Content_Calzado_Modelo pnl_modelo = new Pnl_Content_Calzado_Modelo();
		MostrarPanelModelo( pnl_modelo );

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
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnModelo) {
			btnModelo.setBackground(new Color(95, 103, 112));
		}
		if (e.getSource() == btnMarca) {
			btnMarca.setBackground(new Color(95, 103, 112));
		}
		if (e.getSource() == btnCategoria) {
			btnCategoria.setBackground(new Color(95, 103, 112));
		}
	}
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == btnModelo) {
			MostrarPanelModelo(new Pnl_Content_Calzado_Modelo());
		}
		if (e.getSource() == btnMarca) {
			MostrarPanelModelo(new Pnl_Content_Calzado_Marca());
		}
		if (e.getSource() == btnCategoria) {
			MostrarPanelModelo(new Pnl_Content_Calzado_Categoria());
		}
	}
	public void mouseReleased(MouseEvent e) {
		
	}

}





















//--

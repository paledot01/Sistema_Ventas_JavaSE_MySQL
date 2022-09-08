package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.CalzadoGestionDao;
import entidad.CalzadoReporte;
import utils.RendererTableSimple;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Dlg_Buscador_Calzado extends JDialog implements ActionListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel label;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JRadioButton rbCodigo;
	private JRadioButton rbModelo;
	private JRadioButton rbCategoria;
	private JRadioButton rbMarca;
	private JTable tblCalzado;
	private JScrollPane scrollPane;
	private JButton btnEnviar;

	
	private CalzadoGestionDao gCalzado = new CalzadoGestionDao(); //-- para realziar todas las busquedas
	private DefaultTableModel modelo; //-- para el modelo de la tabla
	
	RendererTableSimple render = new RendererTableSimple(); // <<<<<<<<<<<<<<<<<<<
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dlg_Buscador_Calzado dialog = new Dlg_Buscador_Calzado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dlg_Buscador_Calzado() {
		setModal(true);
		setTitle("Buscador");
		setBounds(100, 100, 546, 417);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel.setBounds(10, 11, 510, 356);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		label = new JLabel("BUSCAR");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(10, 11, 55, 22);
		panel.add(label);
		
		txtBuscar = new JTextField();
		txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscar.addKeyListener(this);
		txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBuscar.setDisabledTextColor(Color.GRAY);
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(75, 11, 362, 22);
		panel.add(txtBuscar);
		
		btnBuscar = new JButton("");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(Dlg_Buscador_Calzado.class.getResource("/img/buscar_53px.png")));
		btnBuscar.setBounds(447, 10, 53, 53);
		panel.add(btnBuscar);
		
		rbCodigo = new JRadioButton("Codigo");
		rbCodigo.setSelected(true);
		rbCodigo.setBounds(75, 40, 65, 23);
		panel.add(rbCodigo);
		
		rbModelo = new JRadioButton("Modelo");
		rbModelo.setBounds(165, 40, 65, 23);
		panel.add(rbModelo);
		
		rbCategoria = new JRadioButton("Categoria");
		rbCategoria.setBounds(345, 40, 75, 23);
		panel.add(rbCategoria);
		
		rbMarca = new JRadioButton("Marca");
		rbMarca.setBounds(255, 40, 65, 23);
		panel.add(rbMarca);
		
		ButtonGroup grupoBusqueda = new ButtonGroup();
		grupoBusqueda.add(rbCodigo);
		grupoBusqueda.add(rbModelo);
		grupoBusqueda.add(rbCategoria);
		grupoBusqueda.add(rbMarca);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 490, 230);
		panel.add(scrollPane);
		
		tblCalzado = new JTable();
		tblCalzado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblCalzado.setFillsViewportHeight(true);
		tblCalzado.setDefaultRenderer(Object.class, render); // <<<<<<<<<<<<<<<<<<<<<<<<<<
		scrollPane.setViewportView(tblCalzado);
		
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("MODELO");
		modelo.addColumn("TALLA");
		modelo.addColumn("COLOR");
		modelo.addColumn("STOCK");
		tblCalzado.setModel(modelo);
		
		tblCalzado.getColumnModel().getColumn(0).setPreferredWidth(30);
		tblCalzado.getColumnModel().getColumn(1).setPreferredWidth(75);
		tblCalzado.getColumnModel().getColumn(2).setPreferredWidth(10);
		tblCalzado.getColumnModel().getColumn(3).setPreferredWidth(30);
		tblCalzado.getColumnModel().getColumn(4).setPreferredWidth(10);
		
		
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(this);
		btnEnviar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEnviar.setIcon(new ImageIcon(Dlg_Buscador_Calzado.class.getResource("/img/flecha_left.png")));
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEnviar.setBounds(10, 315, 106, 30);
		panel.add(btnEnviar);
		
		// -------------
		mostrarDataTabla();
		
		
	}
	
	void mostrarDataTabla(){
		
		modelo.setRowCount(0);
		ArrayList<CalzadoReporte> data = gCalzado.listarModificado();
		
		// i >= data.size()-6
		for( int i = data.size()-1 ; i >= 0 ; i-- ){
			
			Object fila[] = {
					data.get(i).getCod_calzado(),
					data.get(i).getNombre_modelo(),
					data.get(i).getTalla(),
					data.get(i).getColor(),
					data.get(i).getStock()					
			};
			modelo.addRow(fila);
			
		}
	}
	
	public ArrayList<CalzadoReporte> resultadoBusqueda(){
		
		String valor = txtBuscar.getText().trim();
		
		ArrayList<CalzadoReporte> data = new ArrayList<CalzadoReporte>();
		
		try{
			
			if(rbCodigo.isSelected()){
				data = gCalzado.buscarModCodigoIxt(valor);
			}else if(rbModelo.isSelected()){
				data = gCalzado.buscarModModeloIxt(valor);
			}else if(rbCategoria.isSelected()){
				data = gCalzado.buscarModCategoriaIxt(valor);
			}else if(rbMarca.isSelected()){
				data = gCalzado.buscarModMarcaIxt(valor);
			}
			
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
					cr.getTalla(),
					cr.getColor(),
					cr.getStock()
			
			};
			modelo.addRow(fila);
		}
		
	}
	
	/** ----------------------------------------------------------------------------------- **/
	
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource() == btnEnviar) {
			int posFila = tblCalzado.getSelectedRow();
			if(posFila != -1){
				String codigoFila = tblCalzado.getValueAt(posFila, 0).toString();
				Pnl_Content_Venta.txtCodigoCalzado.setText(codigoFila);
				this.dispose();
			}
		}
		
		if (arg0.getSource() == btnBuscar) {
			ArrayList<CalzadoReporte> data = resultadoBusqueda();
			mostrarResultadoBusquedaTabla(data);
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
	}
	public void keyTyped(KeyEvent arg0) {
	}


}

































// --

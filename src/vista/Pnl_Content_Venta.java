package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Pnl_Content_Venta extends JPanel {
	private JPanel pnl_venta_main;
	private JLabel lblVenta;

	/**
	 * Create the panel.
	 */
	public Pnl_Content_Venta() {
		setLayout(null);
		
		pnl_venta_main = new JPanel();
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

	}
}

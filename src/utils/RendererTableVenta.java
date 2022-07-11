package utils;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import vista.Pnl_Content_Venta;

public class RendererTableVenta extends DefaultTableCellRenderer{

	
	private Component componente;//<<<<<
	

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		
		componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);//<<<<
		
		
		if(value instanceof JLabel){
			return (JLabel) value;
		}
		
		
		if(row % 2 == 0){
			setBackground(new Color(240,240,240));
		}else{
			setBackground(Color.WHITE);
		}
		
		setHorizontalAlignment(SwingConstants.CENTER);
		
		/** Al repintarse ya no se tiene que volver a cambiarlo para que regrese a la normalidad, CREO¡? **/
		if (isSelected) {
            componente.setBackground( Library.Claro_1 );
        }
        
		return componente;

		
	}
	
}

package utils;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class RendererTableSimple extends DefaultTableCellRenderer{

	
	private Component componente;//<<<<<
	

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);//<<<<
		
		
		if(row % 2 == 0){
			setBackground(new Color(235,235,235));
		}else{
			setBackground(Color.WHITE);
		}
		
		setHorizontalAlignment(SwingConstants.CENTER);
		
		/** Al repintarse ya no se tiene que volver a cambiarlo para que regrese a la normalidad, CREO¡? **/
		if (isSelected) {
            componente.setBackground( Library.Oscuro_2 );
        }
        
		return componente;

	}
	
	
}

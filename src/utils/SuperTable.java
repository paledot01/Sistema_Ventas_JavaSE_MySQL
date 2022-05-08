package utils;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class SuperTable extends JTable{

	
	/** Esto es como un FOR, repite todas las instruccion para todas las celdas, recuerda que 
	 * una ves que cambias el color de un componente este se mantendra para las demas celdas. **/
	
	public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex){
		
		Component componente = super.prepareRenderer(renderer, rowIndex, columnIndex);
		//componente.setBackground(Color.WHITE);
		componente.setForeground(Color.BLACK); // con cada repeticion vuelve al color negro
			
		/** Solo se cambia el color del componente si el nombre de la columna es igual a "Estado" **/
		if( this.getColumnName(columnIndex).equals("ESTADO") ){
			String valor = getValueAt(rowIndex, columnIndex).toString();
			if( valor.equals("ACTIVO") ){
				//componente.setBackground(new Color(186, 223, 179));
				componente.setForeground(new Color(186, 223, 179));
			}
			else{
				//componente.setBackground(new Color(223, 179, 196));
				componente.setForeground(new Color(223, 179, 196));
			}
		}
		return componente;		
	}
	
	
}

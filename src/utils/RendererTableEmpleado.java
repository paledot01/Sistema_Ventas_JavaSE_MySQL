package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class RendererTableEmpleado extends DefaultTableCellRenderer{

	//DefaultTableCellRenderer cellRenderer7 = new DefaultTableCellRenderer();
	private Component componente;//<<<<<
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		/** isSelectd : para saber si la fila ah sido seleccionada */
		
		//cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		//table.getColumnModel().getColumn(7).setCellRenderer(cellRenderer7);
		
		//setHorizontalAlignment(SwingConstants.CENTER);
		/** Basicamente esta instancia lo que hace es repintar todo con cada cambio eso genera por ejemplo
		 * 	que al seleccionar una fila, esta no cambie de color (azul por default) porque al realizar la accion
		 *  este se vuelve a repintar segun el backgraund programado, encambio si no lo usaramos solo se pintaria
		 *  una vez y al seleccionar toda la fila cambiaria ah azul y se quedaria ahi porque tu programacion no se 
		 *  ejecutar.
		 *  Si no lo colocamos tampoco funciona el BOLD creo que es porque requiere conseguir algo que en su 
		 *  creacion aun existe, pero si encambio, si esta constantemente ejecutandose entonces en la segunda 
		 *  pasada ya existe y se aplica correctamente, No estoy seguro.
		 *  Conclusion si quieres **/
		componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);//<<<<
		
		
		if(row % 2 == 0){
			setBackground(new Color(235,235,235));
		}else{
			setBackground(Color.WHITE);
		}
		
		setHorizontalAlignment(SwingConstants.CENTER);
		
		if(column == 7){
//			setHorizontalAlignment(SwingConstants.CENTER);
			setFont(getFont().deriveFont( Font.BOLD));
			String valor = value.toString();
			if( valor.equals("ACTIVO") ){
				setBackground(new Color(186, 223, 179));
			}else{
				setBackground(new Color(223, 179, 196));
			}
		}
		
		
		/** Al repintarse ya no se tiene que volver a cambiarlo para que regrese a la normalidad, CREO¡? **/
		if (isSelected) {
            componente.setBackground( Library.Oscuro_2 );
        }
        


		return componente;

	}
	
}

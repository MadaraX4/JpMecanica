
package RenderTabelas;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import static javax.management.Query.value;

public class Render extends DefaultTableCellRenderer {
    
     @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
          
        
        // Altere a cor das linhas aqui
        if (row % 2 == 0) {
            cell.setBackground(new java.awt.Color(175,238,238));  // Cor para linhas pares
        } else {
            cell.setBackground(new java.awt.Color(0,206,209));  // Cor para linhas ímpares
        }

       if (isSelected) {
            cell.setBackground(new java.awt.Color(70,130,180));  // Cor para a linha selecionada
            cell.setForeground(Color.BLACK);
        }

        return cell;
    }
    
   

}

package Style.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderLinha extends DefaultTableCellRenderer {
    
   

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        ((JLabel) cell).setHorizontalAlignment(JLabel.CENTER);
        if (row % 2 == 0) {
            cell.setBackground(new java.awt.Color(175, 238, 238));  // Cor para linhas pares
        } else {
            cell.setBackground(new java.awt.Color(0, 206, 209));  // Cor para linhas ímpares
        }

        if (isSelected) {
            cell.setBackground(new java.awt.Color(70, 130, 180));  // Cor para a linha selecionada
            cell.setForeground(Color.BLACK);
        }

        String str = (String) value;
        if ("PENDENTE".equals(str)) {
            cell.setForeground(Color.BLUE);
            cell.setFont(new Font("Segoi UI", Font.BOLD, 18));
        } else if ("PAGO".equals(str)) {
            cell.setForeground(Color.GREEN);
            cell.setFont(new Font("Segoi UI", Font.BOLD, 18));
        } else if ("ATRASADO".equals(str)) {
            cell.setForeground(Color.red);
            cell.setFont(new Font("Segoi UI", Font.BOLD, 18));
        }
        
        
        return cell;
    }

}

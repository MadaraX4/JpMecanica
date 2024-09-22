package Style.table;

import java.awt.Color;
import java.awt.Component;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class FormatarTipos extends DefaultTableCellRenderer {

    private DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Formatação de valores
        if (value instanceof Double) {
            setText(decimalFormat.format(value));
            // Formatação de datas
        } else if (value instanceof Date) {
            setText(dateFormat.format((Date) value)); // Casting para Date
        } else {
            setText(value != null ? value.toString() : "");
        }
        // Outras formatações podem ser adicionadas aqui

        if (row % 2 == 0) {
            cell.setBackground(new java.awt.Color(175, 238, 238));  // Cor para linhas pares
        } else {
            cell.setBackground(new java.awt.Color(0, 206, 209));  // Cor para linhas ímpares
        }

        if (isSelected) {
            cell.setBackground(new java.awt.Color(70, 130, 180));  // Cor para a linha selecionada
            cell.setForeground(Color.BLACK);
        }
        
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

        return cell;
    }
}

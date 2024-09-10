
package RenderTabelas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;


public class Cabecalho extends DefaultTableCellRenderer{
   public Cabecalho() {
        
        
        // Configurações padrão para o renderer
        setOpaque(true);  // Garante que o fundo será visível
        setHorizontalAlignment(CENTER);
        setForeground(Color.BLACK);  // Cor do texto
        setBackground(new java.awt.Color(238,221, 130));  // Cor de fundo
        setFont(new Font("Arial", Font.BOLD, 14));  // Fonte
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Ajusta o texto do cabeçalho
      setText(value != null ? value.toString() : "");
        return this;
    }  
}

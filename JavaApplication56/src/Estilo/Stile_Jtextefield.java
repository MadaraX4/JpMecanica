
package Estilo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JTextField;


public class Stile_Jtextefield extends JTextField {
      private int raioBorda;

    public Stile_Jtextefield(JTextField original, int raioBorda) {
        super(original.getText());
        this.raioBorda = raioBorda;
        setForeground(original.getForeground());
        setBackground(original.getBackground());
        setFont(original.getFont());
        setColumns(original.getColumns());
        setBorder(BorderFactory.createEmptyBorder()); // Remove a borda padrão
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), raioBorda, raioBorda);

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getForeground());
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, raioBorda, raioBorda);
    }
}
    


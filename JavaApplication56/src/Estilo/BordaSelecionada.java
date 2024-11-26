/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estilo;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author MadaraX4
 */
public class BordaSelecionada implements FocusListener{
     private BordaCantoArredondado borda;

     

    public BordaSelecionada(BordaCantoArredondado borda) {
        this.borda = borda;
    }

    @Override
    public void focusGained(FocusEvent e) {
       borda.setCor(Color.GREEN); // Altera a cor ao ganhar foco
        JTextField field = (JTextField) e.getComponent();
        field.revalidate(); // Revalida o componente
        field.repaint(); 
    }

    @Override
    public void focusLost(FocusEvent e) {
      borda.setCor(Color.RED); // Altera a cor ao perder foco
        JTextField field = (JTextField) e.getComponent();
        field.revalidate(); // Revalida o componente
        field.repaint();
    }
}


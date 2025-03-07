package Estilo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class PainelCalendario extends JPanel{
    
    private JLabel mesAnoLabel;
    private JButton anteriorButton;
    private JButton proximoButton;
    private JPanel calendarioPanel;
    private Calendar calendario;
    private Map<Date, List<String>> agendamentos;
    
    public PainelCalendario(){
        setLayout(new BorderLayout());
        
        calendario = new GregorianCalendar();
        agendamentos = new HashMap<>();
        
        mesAnoLabel = new JLabel();
        atualizarMesAnolabel();
        
        anteriorButton = new JButton("Anterior");
        anteriorButton.addActionListener(e -> mudarMes(-1));

        proximoButton = new JButton("Próximo");
        proximoButton.addActionListener(e -> mudarMes(1));
        
        JPanel controlePanel = new JPanel();
        controlePanel.add(anteriorButton);
        controlePanel.add(mesAnoLabel);
        controlePanel.add(proximoButton);
        
        calendarioPanel = new JPanel();
        calendarioPanel.setLayout(new GridLayout(0,7));
        
        add(controlePanel, BorderLayout.NORTH);
        add(calendarioPanel, BorderLayout.CENTER);
        
        atualizarCalendario();
    }
    
    private void mudarMes(int deslocamento){
        calendario.add(Calendar.MONTH, deslocamento);
        atualizarMesAnolabel();
        atualizarCalendario();
    }
    
    private void atualizarMesAnolabel(){
        mesAnoLabel.setText(String.format("%1$tB %1$tY", calendario));
    }
    
    private void atualizarCalendario(){
        calendarioPanel.removeAll();
        
        String [] diasDasemana = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb"};
        for (String dia : diasDasemana) {
            calendarioPanel.add(new JLabel(dia, SwingConstants.CENTER));
        }
        
        Calendar cal = (Calendar) calendario.clone();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int primeiroDiaDasemana = cal.get(Calendar.DAY_OF_WEEK);
        int diasNoMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int mesAtual = cal.get(Calendar.MONTH);
        cal.add(Calendar.DAY_OF_MONTH, -(primeiroDiaDasemana - Calendar.SUNDAY));
        
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
             JButton diaButton = new JButton(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
             diaButton.addActionListener(new DiaButtonListener(cal.getTime()));
             
             if (cal.get(Calendar.MONTH) != mesAtual) {
                    diaButton.setForeground(Color.GRAY); // Deixar os dias fora do mês atual em cinza
                }
             
             calendarioPanel.add(diaButton);
             cal.add(Calendar.DAY_OF_MONTH, 1);
            }
            
        }
        
        revalidate();
        repaint();
    }
    
    private class DiaButtonListener implements ActionListener{
        private Date data;
        
        private DiaButtonListener(Date data){
            this.data = data;
        }
        
        @Override
        public void actionPerformed(ActionEvent e){
        mostrarAgendamentos(data);
        }
        
        private void mostrarAgendamentos(Date data){
            List<String> listaAgendamentos = agendamentos.getOrDefault(data, new ArrayList<>());
            String menssagem = listaAgendamentos.isEmpty() ? "Nenhum agendamento." : String.join("\n", listaAgendamentos);
            
            int opcao = JOptionPane.showConfirmDialog(null, menssagem + "\n\nDeseja adicionar um novo agendamento?","Agendamentos em" + data, JOptionPane.YES_NO_OPTION);
            
           if (opcao == JOptionPane.YES_OPTION) {
            String novoAgendamento = JOptionPane.showInputDialog(this, "Digite o novo agendamento:");
            if (novoAgendamento != null && !novoAgendamento.trim().isEmpty()) {
                listaAgendamentos.add(novoAgendamento);
                agendamentos.put(data, listaAgendamentos);
            }
        }
        }
    }
}

package Estilo;

import Model.CarroCliente;
import Model.DAO.CarroDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class PainelCalendario extends JPanel {

    private JLabel mesAnoLabel;
    private JButton anteriorButton;
    private JButton proximoButton;
    private JPanel calendarioPanel;
    private Calendar calendario;
    private Map<Date, List<String>> agendamentos;
    private JTable tabela;

    public PainelCalendario(JTable tabela) {
//        if (tabela == null) {
//            throw new IllegalArgumentException("A tabela não pode ser nula");
//        }

        setLayout(new BorderLayout());
        
        this.tabela = tabela;
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
        calendarioPanel.setLayout(new GridLayout(0, 7));
        
        add(controlePanel, BorderLayout.NORTH);
        add(calendarioPanel, BorderLayout.CENTER);
        
        atualizarCalendario();
    }
    
    private void mudarMes(int deslocamento) {
        calendario.add(Calendar.MONTH, deslocamento);
        atualizarMesAnolabel();
        atualizarCalendario();
    }
    
    private void atualizarMesAnolabel() {
        mesAnoLabel.setText(String.format("%1$tB %1$tY", calendario));
    }
    
    private void atualizarCalendario() {
        calendarioPanel.removeAll();
        
        String[] diasDaSemana = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb"};
        for (String dia : diasDaSemana) {
            calendarioPanel.add(new JLabel(dia, SwingConstants.CENTER));
        }
        
        Calendar cal = (Calendar) calendario.clone();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int primeiroDiaDaSemana = cal.get(Calendar.DAY_OF_WEEK);
        int diasNoMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int mesAtual = cal.get(Calendar.MONTH);
        cal.add(Calendar.DAY_OF_MONTH, -(primeiroDiaDaSemana - Calendar.SUNDAY));
        
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                JButton diaButton = new JButton(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
                diaButton.addActionListener(new DiaButtonListener(cal.getTime(), tabela));
                
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
    
    private class DiaButtonListener implements ActionListener {
        private Date data;
        private JTable tabela;
        
        private DiaButtonListener(Date data, JTable tabela) {
            this.data = data;
            this.tabela = tabela;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            mostrarAgendamentos(data, tabela);
        }
        
        private void mostrarAgendamentos(Date data, JTable tabela) {
//            if (tabela == null) {
//                System.err.println("A tabela é nula!");
//                return;
//            }

            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            modelo.setRowCount(0); // Limpar tabela antes de adicionar novos dados

            CarroDAO dao = new CarroDAO();
            List<CarroCliente> lista = dao.listaManutencao(new java.sql.Date(data.getTime()));

            if (lista == null) {
                System.err.println("A lista de agendamentos é nula!");
                return;
            }

            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            for (CarroCliente carroCliente : lista) {
//                if (carroCliente.getCliente() == null) {
//                    System.err.println("Cliente é nulo para um dos objetos CarroCliente!");
//                    continue;
//                }
//
//                if (carroCliente.getCarro() == null) {
//                    System.err.println("Carro é nulo para um dos objetos CarroCliente!");
//                    continue;
//                }

                Object[] objeto = new Object[4];
                objeto[0] = carroCliente.getCliente().getNome();
                objeto[1] = carroCliente.getCarro().getModelo();
                objeto[2] = carroCliente.getCarro().getPlaca();
                objeto[3] = format.format(carroCliente.getCarro().getManutencao_agendada());

                modelo.addRow(objeto);
            }
        }
    }
}

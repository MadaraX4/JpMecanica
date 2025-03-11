package View;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import Estilo.PainelCalendario;
import Estilo.BotaoRedondo;
import Model.DAO.CarroDAO;
import Style.table.Render;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Agendamentos extends javax.swing.JFrame {
    
    public Agendamentos() {
        initComponents();
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/48x48.png")));
        setLocationRelativeTo(null);
        
        jtAgendamentos.getColumnModel().getColumn(0).setPreferredWidth(250);
        Render render = new Render();
        for (int i = 0; i < jtAgendamentos.getColumnCount(); i++) {
            jtAgendamentos.getColumnModel().getColumn(i).setCellRenderer(render);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpDados = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnAgendar = new BotaoRedondo();
        jcbDia = new javax.swing.JComboBox<>();
        jcbMes = new javax.swing.JComboBox<>();
        jpTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAgendamentos = new javax.swing.JTable();
        btnFinalizar = new BotaoRedondo();
        btnRemarcar = new BotaoRedondo();
        btnCancelar = new BotaoRedondo();
        jpCalendar = new PainelCalendario(jtAgendamentos);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agendamentos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Agendar Manutenção");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        jpDados.setBackground(new java.awt.Color(255, 255, 204));
        jpDados.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Placa");

        txtPlaca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPlaca.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Data Da Manutenção");

        btnAgendar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calendario.png"))); // NOI18N
        btnAgendar.setText("Agendar");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        jcbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DIA", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jcbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mês", "JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL", "MAIO", "JUNHO", "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO" }));

        javax.swing.GroupLayout jpDadosLayout = new javax.swing.GroupLayout(jpDados);
        jpDados.setLayout(jpDadosLayout);
        jpDadosLayout.setHorizontalGroup(
            jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosLayout.createSequentialGroup()
                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDadosLayout.createSequentialGroup()
                        .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDadosLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDadosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpDadosLayout.createSequentialGroup()
                                .addComponent(jcbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbMes, 0, 1, Short.MAX_VALUE))
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpDadosLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jpDadosLayout.setVerticalGroup(
            jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.add(jpDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 330, 150));

        jpTabela.setBackground(new java.awt.Color(255, 255, 204));

        jtAgendamentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Proprietario", "carro", "Placa", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtAgendamentos);

        btnFinalizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFinalizar.setText("Finaliar Agendamento");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnRemarcar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRemarcar.setText("Remarcar Agendamento");
        btnRemarcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemarcarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar Agendamento");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpTabelaLayout = new javax.swing.GroupLayout(jpTabela);
        jpTabela.setLayout(jpTabelaLayout);
        jpTabelaLayout.setHorizontalGroup(
            jpTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jpTabelaLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnRemarcar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jpTabelaLayout.setVerticalGroup(
            jpTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTabelaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizar)
                    .addComponent(btnRemarcar)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jpTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 780, 290));

        jpCalendar.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.add(jpCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 430, 220));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        CarroDAO dao = new CarroDAO();
        int dia = jcbDia.getSelectedIndex();
        int mes = jcbMes.getSelectedIndex();
        if (!txtPlaca.getText().isEmpty()) {
            dao.agendarManutencao(txtPlaca.getText().toUpperCase(), dia, mes);
        } else {
            JOptionPane.showMessageDialog(null, "Digite uma placa!");
        }
    }//GEN-LAST:event_btnAgendarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jtAgendamentos.getModel();
        
        CarroDAO dao = new CarroDAO();
        int linha = jtAgendamentos.getSelectedRow();
        LocalDate data;
        String placa;
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        if (linha != -1) {
            String dataS = (String) jtAgendamentos.getValueAt(linha, 3);
            data = LocalDate.parse(dataS.replace("/", "-"), formater);
            placa = (String) jtAgendamentos.getValueAt(linha, 2);
            dao.finalizarManutencao(placa, data);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum Agendamento selecionado!");
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jtAgendamentos.getModel();
        
        CarroDAO dao = new CarroDAO();
        int linha = jtAgendamentos.getSelectedRow();
        String placa;
        if (linha != -1) {
            placa = (String) jtAgendamentos.getValueAt(linha, 2);
            dao.cancelarManutencao(placa);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum Agendamento selecionado!");
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRemarcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemarcarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jtAgendamentos.getModel();
        
        CarroDAO dao = new CarroDAO();
        int linha = jtAgendamentos.getSelectedRow();
        String placa;
        if (linha != -1) {
            placa = (String) jtAgendamentos.getValueAt(linha, 2);
            String inputData = JOptionPane.showInputDialog("Ensira a nova data no formato\n (dd/MM/yyyy)");
            DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            if (!inputData.isEmpty()) {
                LocalDate data = LocalDate.parse(inputData.replace("/", "-"), formater);
                dao.alterarManutencao(placa, data);
                
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma data enserida!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum Agendamento selecionado!");
        }
    }//GEN-LAST:event_btnRemarcarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agendamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnRemarcar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbDia;
    private javax.swing.JComboBox<String> jcbMes;
    private javax.swing.JPanel jpCalendar;
    private javax.swing.JPanel jpDados;
    private javax.swing.JPanel jpTabela;
    private javax.swing.JTable jtAgendamentos;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}

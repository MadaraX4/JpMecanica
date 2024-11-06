package View;

import Model.DAO.OsDAO;
import Model.Os;
import Style.table.Cabecalho;
import Style.table.Render;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import Estilo.BotaoRedondo;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;

/**
 *
 * @author MadaraX4
 */
public class VerOSs extends javax.swing.JFrame {

    /**
     * Creates new form VerOSs
     */
    public VerOSs() {
        initComponents();
        
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 204));
        jTOs.setBackground(new java.awt.Color(255, 255, 204));
        
        Render render = new Render();
        for (int i = 0; i < jTOs.getColumnCount(); i++) {
            jTOs.getColumnModel().getColumn(i).setCellRenderer(render);
        }
        
        JTableHeader header = jTOs.getTableHeader();
        header.setDefaultRenderer(new Cabecalho());
        
        colunasTabelaOs();
        todasOs();
    }
    
    public void colunasTabelaOs() {
        jTOs.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTOs.getColumnModel().getColumn(1).setPreferredWidth(240);
        jTOs.getColumnModel().getColumn(2).setPreferredWidth(40);
        jTOs.getColumnModel().getColumn(3).setPreferredWidth(30);
        jTOs.getColumnModel().getColumn(4).setPreferredWidth(5);
        jTOs.getColumnModel().getColumn(4).setPreferredWidth(25);
        
    }
    
    public void todasOs() {
        DefaultTableModel modelo = (DefaultTableModel) jTOs.getModel();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,00");
        OsDAO dao = new OsDAO();
        List<Os> oss = dao.listaOs();
        
        for (Os os : oss) {
            Object[] objeto = new Object[6];
            
            objeto[0] = os.getId();
            objeto[1] = os.getClienteNome();
            objeto[2] = os.getPlacaVeiculo();
            objeto[3] = sdf.format(os.getDataOrdem());
            objeto[4] = df.format(os.getValor());
            objeto[5] = os.getStatus();
            
            modelo.addRow(objeto);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        btnPesquisar = new BotaoRedondo();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTOs = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Veja Todas as OSs ou Pesquise Por uma Data Especifica");

        btnSair.setBackground(new java.awt.Color(255, 255, 204));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perto.png"))); // NOI18N
        btnSair.setBorder(null);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Digite uma Placa");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        txtPlaca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel3.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 138, -1));

        btnPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa (2).png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        jPanel3.add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 136, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 470, 60));

        jTOs.setBackground(new java.awt.Color(255, 255, 204));
        jTOs.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTOs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CLIENTE", "PLACA DO VEICULO", "DATA DA ORDEM", "VALOR", "ESTATUS"
            }
        ));
        jTOs.setRowHeight(30);
        jScrollPane1.setViewportView(jTOs);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1070, 540));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 660));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        String placa = txtPlaca.getText();
        DefaultTableModel modelo = (DefaultTableModel) jTOs.getModel();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,00");
        OsDAO dao = new OsDAO();
        List<Os> oss = dao.osPorPlaca(placa);
        
        modelo.setRowCount(0);
        
        for (Os os : oss) {
            Object[] objeto = new Object[6];
            
            objeto[0] = os.getId();
            objeto[1] = os.getClienteNome();
            objeto[2] = os.getPlacaVeiculo();
            objeto[3] = sdf.format(os.getDataOrdem());
            objeto[4] = df.format(os.getValor());
            objeto[5] = os.getStatus();
            
            modelo.addRow(objeto);
        }
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        TelaInicial inicial = new TelaInicial();
        this.dispose();
        inicial.setVisible(true);
    }//GEN-LAST:event_btnSairActionPerformed

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
                new VerOSs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTOs;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
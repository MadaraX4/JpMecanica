package View;

import Model.DAO.VendaDAO;
import Model.Venda;
import Style.table.Cabecalho;
import Style.table.Render;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author MadaraX4
 */
public class VendasDoDia extends javax.swing.JFrame {

    /**
     * Creates new form VendasDoDia
     */
    public VendasDoDia() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/48x48.png")));
        vendas();

        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 204));
        jTVendas.setBackground(new java.awt.Color(255, 255, 204));

        Render render = new Render();
        for (int i = 0; i < jTVendas.getColumnCount(); i++) {
            jTVendas.getColumnModel().getColumn(i).setCellRenderer(render);
        }

        JTableHeader header = jTVendas.getTableHeader();
        header.setDefaultRenderer(new Cabecalho());
        
        titulo();
        colunaTabela();
    }

    public void vendas() {
        DefaultTableModel modelo = (DefaultTableModel) jTVendas.getModel();

        VendaDAO dao = new VendaDAO();
        List<Venda> vendas = dao.listaVenda();

        for (Venda venda : vendas) {
            DecimalFormat df = new DecimalFormat("#.00");
            Object[] objeto = new Object[6];
            objeto[0] = venda.getId();
            objeto[1] = df.format(venda.getValor());
            objeto[2] = venda.getQtdItens();
            objeto[3] = venda.getHora();
            objeto[4] = df.format(venda.getDinheiro());
            objeto[5] = venda.getTipoDePagamento();

            modelo.addRow(objeto);
        }
    }

    public void titulo() {

        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        lblTitulo.setText("VENDAS REALIZADAS HOJE " + formatoData.format(dataAtual));
    }
    
     public void colunaTabela() {
        jTVendas.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTVendas.getColumnModel().getColumn(1).setPreferredWidth(20);
        jTVendas.getColumnModel().getColumn(2).setPreferredWidth(20);
        jTVendas.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTVendas.getColumnModel().getColumn(4).setPreferredWidth(20);
        jTVendas.getColumnModel().getColumn(5).setPreferredWidth(50);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTVendas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vendas do dia");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTVendas.setBackground(new java.awt.Color(255, 255, 204));
        jTVendas.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTVendas.setForeground(new java.awt.Color(0, 0, 0));
        jTVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR", "VALOR", "ITENS DA VENDA", "HORA DA VENDA", "DINHEIRO", "MÉTODO DE PAGAMENTO "
            }
        ));
        jTVendas.setRowHeight(30);
        jScrollPane1.setViewportView(jTVendas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 37, 1110, 680));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setText("jLabel1");
        jPanel2.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnSair.setBackground(new java.awt.Color(255, 255, 204));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perto.png"))); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel2.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(1082, 10, 30, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, -1, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        TelaVenda venda = new TelaVenda();
        this.dispose();
        venda.setVisible(true);
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
                new VendasDoDia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTVendas;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}

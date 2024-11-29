
package View;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author MadaraX4
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form Tela2
     */
    public TelaInicial() {
        initComponents();

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/48x48.png")));
        lblLogo.setIcon(new ImageIcon(getClass().getResource("/img/LOGO-MAIOR (2).png")));
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                if (getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                    lblLogo.setIcon(new ImageIcon(getClass().getResource("/img/LOGO-MAIOR (2).png")));
                } else {
                    lblLogo.setIcon(new ImageIcon(getClass().getResource("/img/LOGO-removebg-preview.png")));
                }
            }
//            

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnCadastrarCarro = new javax.swing.JButton();
        btnCadastrarPecas = new javax.swing.JButton();
        btnCadastrarMecanico = new javax.swing.JButton();
        btnVendas = new javax.swing.JButton();
        btnBackup = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnCadastrarCliente = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnAgendamentos = new javax.swing.JButton();
        btnCadastrarFerramentas = new javax.swing.JButton();
        btnFluxoDeCaixa = new javax.swing.JButton();
        btnNotificacoes = new javax.swing.JButton();
        btnContas = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnVerOss = new javax.swing.JButton();
        btnOrcamento = new javax.swing.JButton();
        btnOs = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(153, 255, 255));
        jPanel4.setMinimumSize(new java.awt.Dimension(100, 220));
        jPanel4.setPreferredSize(new java.awt.Dimension(230, 200));

        btnCadastrarCarro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCadastrarCarro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-carro-48.png"))); // NOI18N
        btnCadastrarCarro.setText("Cadastrar Carro");
        btnCadastrarCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarCarroActionPerformed(evt);
            }
        });

        btnCadastrarPecas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCadastrarPecas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pecas-de-reposicao.png"))); // NOI18N
        btnCadastrarPecas.setText("Cadastrar Peças");
        btnCadastrarPecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarPecasActionPerformed(evt);
            }
        });

        btnCadastrarMecanico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCadastrarMecanico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mecanico.png"))); // NOI18N
        btnCadastrarMecanico.setText("Cadastrar Mecânico");
        btnCadastrarMecanico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarMecanicoActionPerformed(evt);
            }
        });

        btnVendas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/caixa-eletronico.png"))); // NOI18N
        btnVendas.setText("Tela de Vendas");
        btnVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendasActionPerformed(evt);
            }
        });

        btnBackup.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copia-de-seguranca (1).png"))); // NOI18N
        btnBackup.setText("Backup");
        btnBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrarCarro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastrarPecas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastrarMecanico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVendas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBackup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnCadastrarCarro, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(btnCadastrarPecas, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(btnCadastrarMecanico, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(btnVendas, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnBackup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(39, 39, 39))
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.WEST);

        jPanel5.setBackground(new java.awt.Color(153, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1150, 100));

        btnCadastrarCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCadastrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cliente-48.png"))); // NOI18N
        btnCadastrarCliente.setText("Cadastrar Cliente");
        btnCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarClienteActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fechar.png"))); // NOI18N
        btnSair.setText("Fechar Sistema");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 704, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(btnCadastrarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        jPanel2.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel6.setBackground(new java.awt.Color(153, 255, 255));
        jPanel6.setMinimumSize(new java.awt.Dimension(230, 100));
        jPanel6.setPreferredSize(new java.awt.Dimension(230, 512));

        btnAgendamentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agendamento.png"))); // NOI18N
        btnAgendamentos.setText("Agendamentos");
        btnAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendamentosActionPerformed(evt);
            }
        });

        btnCadastrarFerramentas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCadastrarFerramentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-ferramentas-48.png"))); // NOI18N
        btnCadastrarFerramentas.setText("Cadastrar Ferramentas");
        btnCadastrarFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFerramentasActionPerformed(evt);
            }
        });

        btnFluxoDeCaixa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFluxoDeCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-vendas-48.png"))); // NOI18N
        btnFluxoDeCaixa.setText("Finanças");
        btnFluxoDeCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFluxoDeCaixaActionPerformed(evt);
            }
        });

        btnNotificacoes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNotificacoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-notificação-48.png"))); // NOI18N
        btnNotificacoes.setText("Notificações");
        btnNotificacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotificacoesActionPerformed(evt);
            }
        });

        btnContas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pago.png"))); // NOI18N
        btnContas.setText("Contas a Pagar");
        btnContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastrarFerramentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFluxoDeCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNotificacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnContas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnCadastrarFerramentas, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnFluxoDeCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(btnNotificacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(btnContas, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );

        jPanel2.add(jPanel6, java.awt.BorderLayout.EAST);

        jPanel7.setBackground(new java.awt.Color(153, 255, 255));

        btnVerOss.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVerOss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ordem-de-servico.png"))); // NOI18N
        btnVerOss.setText("Ver OS`s");
        btnVerOss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerOssActionPerformed(evt);
            }
        });

        btnOrcamento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/orcamento (1).png"))); // NOI18N
        btnOrcamento.setText("Orçamento");
        btnOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrcamentoActionPerformed(evt);
            }
        });

        btnOs.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-ordem-48.png"))); // NOI18N
        btnOs.setText("OS");
        btnOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btnOs, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addGap(156, 156, 156)
                .addComponent(btnVerOss, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addGap(289, 289, 289)
                .addComponent(btnOrcamento, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnOs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOrcamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVerOss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(40, 40, 40))
        );

        jPanel2.add(jPanel7, java.awt.BorderLayout.SOUTH);

        jPanel8.setBackground(new java.awt.Color(153, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(200, 400));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LOGO-MAIOR (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel8, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsActionPerformed
        CadastroOs os = new CadastroOs();
        os.setVisible(true);
    }//GEN-LAST:event_btnOsActionPerformed

    private void btnOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrcamentoActionPerformed
        TelaOrcamento orcamento = new TelaOrcamento();
        orcamento.setVisible(true);
    }//GEN-LAST:event_btnOrcamentoActionPerformed

    private void btnVerOssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerOssActionPerformed
        VerOSs oss = new VerOSs();
        this.dispose();
        oss.setVisible(true);
    }//GEN-LAST:event_btnVerOssActionPerformed

    private void btnBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackupActionPerformed
        TelaBackup backup = new TelaBackup();
        backup.setVisible(true);
    }//GEN-LAST:event_btnBackupActionPerformed

    private void btnContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContasActionPerformed
        CadastroContas contas = new CadastroContas();
        contas.setVisible(true);
    }//GEN-LAST:event_btnContasActionPerformed

    private void btnFluxoDeCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFluxoDeCaixaActionPerformed
        TelaFinanceiro financeiro = new TelaFinanceiro();
        this.dispose();
        financeiro.setVisible(true);
    }//GEN-LAST:event_btnFluxoDeCaixaActionPerformed

    private void btnCadastrarFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarFerramentasActionPerformed
        CadastroFerramenta ferramenta = new CadastroFerramenta();
        ferramenta.setVisible(true);
    }//GEN-LAST:event_btnCadastrarFerramentasActionPerformed

    private void btnAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendamentosActionPerformed
        Agendamentos agendamentos = new Agendamentos();
        agendamentos.setVisible(true);
    }//GEN-LAST:event_btnAgendamentosActionPerformed

    private void btnNotificacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotificacoesActionPerformed
        this.dispose();
        TelaNotificacoes notificacoes = new TelaNotificacoes();
        notificacoes.setVisible(true);
    }//GEN-LAST:event_btnNotificacoesActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarClienteActionPerformed
        CadastroCliente cadastroCliente = new CadastroCliente();
        cadastroCliente.setVisible(true);
    }//GEN-LAST:event_btnCadastrarClienteActionPerformed

    private void btnCadastrarCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarCarroActionPerformed
        CadastroCarro cadastroCarro = new CadastroCarro();
        cadastroCarro.setVisible(true);
    }//GEN-LAST:event_btnCadastrarCarroActionPerformed

    private void btnVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendasActionPerformed
        TelaVenda venda = new TelaVenda();
        this.dispose();
        venda.setVisible(true);
    }//GEN-LAST:event_btnVendasActionPerformed

    private void btnCadastrarMecanicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarMecanicoActionPerformed
        CadastroMecanico cadastroMecanico = new CadastroMecanico();
        cadastroMecanico.setVisible(true);
    }//GEN-LAST:event_btnCadastrarMecanicoActionPerformed

    private void btnCadastrarPecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarPecasActionPerformed
        CadastroPecas cadastroPecas = new CadastroPecas();
        cadastroPecas.setVisible(true);
    }//GEN-LAST:event_btnCadastrarPecasActionPerformed

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
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendamentos;
    private javax.swing.JButton btnBackup;
    private javax.swing.JButton btnCadastrarCarro;
    private javax.swing.JButton btnCadastrarCliente;
    private javax.swing.JButton btnCadastrarFerramentas;
    private javax.swing.JButton btnCadastrarMecanico;
    private javax.swing.JButton btnCadastrarPecas;
    private javax.swing.JButton btnContas;
    private javax.swing.JButton btnFluxoDeCaixa;
    private javax.swing.JButton btnNotificacoes;
    private javax.swing.JButton btnOrcamento;
    private javax.swing.JButton btnOs;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVendas;
    private javax.swing.JButton btnVerOss;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblLogo;
    // End of variables declaration//GEN-END:variables
}

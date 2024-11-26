/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author lordt
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/48x48.png")));
        btnCadastrarCliente.setBackground(Color.WHITE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        lblLogo.setIcon(new ImageIcon("src/img/LOGO-MAIOR.png"));

        addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                if (getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                    lblLogo.setIcon(new ImageIcon(getClass().getResource("/img/LOGO-MAIOR.png")));
                } else {
                    lblLogo.setIcon(new ImageIcon(getClass().getResource("/img/LOGO-removebg-preview.png")));
                }
            }
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

        jPanel1 = new javax.swing.JPanel();
        btnCadastrarCliente = new javax.swing.JButton();
        btnCadastrarCarro = new javax.swing.JButton();
        btnCadastrarPecas = new javax.swing.JButton();
        btnCadastrarMecanico = new javax.swing.JButton();
        btnVendas = new javax.swing.JButton();
        btnBackup = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        btnOs = new javax.swing.JButton();
        btnVerOs = new javax.swing.JButton();
        btnOrcamento = new javax.swing.JButton();
        btnNotificacoes = new javax.swing.JButton();
        btnContas = new javax.swing.JButton();
        btnFerramentas = new javax.swing.JButton();
        btnFluxoDeCaixa = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnAgendamentos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JpMarket");

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        btnCadastrarCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCadastrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cliente-48.png"))); // NOI18N
        btnCadastrarCliente.setText("Cadastrar Cliente");
        btnCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarClienteActionPerformed(evt);
            }
        });

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
        btnVendas.setText("Tela de vendas");
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

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LOGO-removebg-preview.png"))); // NOI18N

        btnOs.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-ordem-48.png"))); // NOI18N
        btnOs.setText("Ordem de Serviço");
        btnOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOsActionPerformed(evt);
            }
        });

        btnVerOs.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVerOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ordem-de-servico.png"))); // NOI18N
        btnVerOs.setText("Ver Ordens de serviço");
        btnVerOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerOsActionPerformed(evt);
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
        btnContas.setText("Contas a pagar");
        btnContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContasActionPerformed(evt);
            }
        });

        btnFerramentas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFerramentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-ferramentas-48.png"))); // NOI18N
        btnFerramentas.setText("Cadastrar ferramentas");
        btnFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFerramentasActionPerformed(evt);
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

        btnSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fechar.png"))); // NOI18N
        btnSair.setText("Fechar sistema");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agendamento.png"))); // NOI18N
        btnAgendamentos.setText("Agendamentos");
        btnAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendamentosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVendas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastrarCarro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastrarMecanico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastrarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBackup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastrarPecas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnOs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33)
                        .addComponent(btnVerOs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOrcamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFerramentas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(btnContas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFluxoDeCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNotificacoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCadastrarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCadastrarCarro, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                .addGap(12, 12, 12)
                                .addComponent(btnCadastrarPecas, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCadastrarMecanico, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addGap(15, 15, 15)
                                .addComponent(btnVendas, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addGap(8, 8, 8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFluxoDeCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnFerramentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnContas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNotificacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBackup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerOs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOrcamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarPecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarPecasActionPerformed
        // TODO add your handling code here:
        CadastroPecas cadastroPecas = new CadastroPecas();
        cadastroPecas.setVisible(true);
    }//GEN-LAST:event_btnCadastrarPecasActionPerformed

    private void btnVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendasActionPerformed
        // TODO add your handling code here:
        TelaVenda venda = new TelaVenda();
        this.dispose();
        venda.setVisible(true);
    }//GEN-LAST:event_btnVendasActionPerformed

    private void btnCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarClienteActionPerformed
        // TODO add your handling code here:
        CadastroCliente cadastroCliente = new CadastroCliente();
        cadastroCliente.setVisible(true);
    }//GEN-LAST:event_btnCadastrarClienteActionPerformed

    private void btnCadastrarCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarCarroActionPerformed
        // TODO add your handling code here:
        CadastroCarro cadastroCarro = new CadastroCarro();
        cadastroCarro.setVisible(true);
    }//GEN-LAST:event_btnCadastrarCarroActionPerformed

    private void btnCadastrarMecanicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarMecanicoActionPerformed
        // TODO add your handling code here:
        CadastroMecanico cadastroMecanico = new CadastroMecanico();
        cadastroMecanico.setVisible(true);
    }//GEN-LAST:event_btnCadastrarMecanicoActionPerformed

    private void btnContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContasActionPerformed
        // TODO add your handling code here:
        CadastroContas contas = new CadastroContas();
        contas.setVisible(true);
    }//GEN-LAST:event_btnContasActionPerformed

    private void btnOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsActionPerformed
        // TODO add your handling code here:
        CadastroOs os = new CadastroOs();
        os.setVisible(true);
    }//GEN-LAST:event_btnOsActionPerformed

    private void btnNotificacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotificacoesActionPerformed
        // TODO add your handling code here:
        this.dispose();
        TelaNotificacoes notificacoes = new TelaNotificacoes();
        notificacoes.setVisible(true);

    }//GEN-LAST:event_btnNotificacoesActionPerformed

    private void btnOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrcamentoActionPerformed
        // TODO add your handling code here:
        TelaOrcamento orcamento = new TelaOrcamento();
        orcamento.setVisible(true);
    }//GEN-LAST:event_btnOrcamentoActionPerformed

    private void btnVerOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerOsActionPerformed
        // TODO add your handling code here:
        VerOSs oss = new VerOSs();
        this.dispose();
        oss.setVisible(true);
    }//GEN-LAST:event_btnVerOsActionPerformed

    private void btnFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFerramentasActionPerformed
        // TODO add your handling code here:
        CadastroFerramenta ferramenta = new CadastroFerramenta();
        ferramenta.setVisible(true);
    }//GEN-LAST:event_btnFerramentasActionPerformed

    private void btnFluxoDeCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFluxoDeCaixaActionPerformed
        // TODO add your handling code here:
        TelaFinanceiro financeiro = new TelaFinanceiro();
        this.dispose();
        financeiro.setVisible(true);
    }//GEN-LAST:event_btnFluxoDeCaixaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackupActionPerformed
        // TODO add your handling code here:
        TelaBackup backup = new TelaBackup();
        backup.setVisible(true);
    }//GEN-LAST:event_btnBackupActionPerformed

    private void btnAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendamentosActionPerformed
        // TODO add your handling code here:
        Agendamentos agendamentos = new Agendamentos();
        agendamentos.setVisible(true);
    }//GEN-LAST:event_btnAgendamentosActionPerformed

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
    private javax.swing.JButton btnCadastrarMecanico;
    private javax.swing.JButton btnCadastrarPecas;
    private javax.swing.JButton btnContas;
    private javax.swing.JButton btnFerramentas;
    private javax.swing.JButton btnFluxoDeCaixa;
    private javax.swing.JButton btnNotificacoes;
    private javax.swing.JButton btnOrcamento;
    private javax.swing.JButton btnOs;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVendas;
    private javax.swing.JButton btnVerOs;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLogo;
    // End of variables declaration//GEN-END:variables
}

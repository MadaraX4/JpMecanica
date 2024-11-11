/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Conta;
import Model.ContaTableModel;
import Model.DAO.ContaDAO;
import Estilo.BordaCantoArredondado;
import Estilo.BotaoRedondo;
import Estilo.TextoMaisculo;
import Model.DAO.FluxoDeCaixaDAO;
import Model.FluxoDeCaixa;
import Style.table.Cabecalho;
import Style.table.FormatarTipos;
import Style.table.Render;
import Style.table.RenderLinha;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author MadaraX4
 */
public final class CadastroContas extends javax.swing.JFrame {

    private Conta conta = new Conta();
    private ContaDAO dao = new ContaDAO();
    ContaTableModel modelo = new ContaTableModel();
    FormatarTipos tipos = new FormatarTipos();

    private final TableRowSorter<AbstractTableModel> sorter;

    public CadastroContas() {
        initComponents();

        sorter = new TableRowSorter<>(modelo);
        jtContas.setModel(modelo);
        jtContas.setRowSorter(sorter);
        RenderLinha renderL = new RenderLinha();

        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 204));
        jtContas.setBackground(new java.awt.Color(187, 187, 187));

        JTableHeader header = jtContas.getTableHeader();
        header.setDefaultRenderer(new Cabecalho());

        Render render = new Render();
        for (int i = 0; i < jtContas.getColumnCount(); i++) {
            jtContas.getColumnModel().getColumn(i).setCellRenderer(render);
        }

        jtContas.getColumnModel().getColumn(4).setCellRenderer(renderL);

        jtContas.getColumnModel().getColumn(2).setCellRenderer(new FormatarTipos()); // Para coluna de valor
        jtContas.getColumnModel().getColumn(3).setCellRenderer(new FormatarTipos());
        jtContas.getColumnModel().getColumn(5).setCellRenderer(new FormatarTipos());
        jtContas.getColumnModel().getColumn(6).setCellRenderer(new FormatarTipos());

        formatarTabela();
        readJTAble();

        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnMarcarComoPago.setEnabled(false);

        txtReferencia.setEditable(true);

        BordaCantoArredondado bad = new BordaCantoArredondado(Color.GRAY);

        txtReferencia.setBorder(bad);
        txtDataVencimento.setBorder(bad);
        txtTipo.setBorder(bad);
        txtValor.setBorder(bad);
        
        textoMaiusculo();
        
    }
    
    public void textoMaiusculo(){
    
    ((AbstractDocument) txtReferencia.getDocument()).setDocumentFilter(new TextoMaisculo());
    ((AbstractDocument) txtDataVencimento.getDocument()).setDocumentFilter(new TextoMaisculo());
    ((AbstractDocument) txtTipo.getDocument()).setDocumentFilter(new TextoMaisculo());
    ((AbstractDocument) txtValor.getDocument()).setDocumentFilter(new TextoMaisculo());
    
    }

    public void formatarTabela() {

        jtContas.setRowHeight(20);

        TableColumn colunaValor = jtContas.getColumnModel().getColumn(2);
        colunaValor.setPreferredWidth(30);

        TableColumn colunaTipo = jtContas.getColumnModel().getColumn(1);
        colunaTipo.setPreferredWidth(30);

        TableColumn colunaReferencia = jtContas.getColumnModel().getColumn(0);
        colunaReferencia.setPreferredWidth(80);

        TableColumn colunaVencimento = jtContas.getColumnModel().getColumn(3);

        TableColumn colunaEstatus = jtContas.getColumnModel().getColumn(4);
        colunaEstatus.setPreferredWidth(70);

    }

    private java.sql.Date dataMysql(String dataString) {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date data = null;

        try {
            data = formato.parse(dataString);
        } catch (ParseException e) {
            e.printStackTrace(); // Trate o erro adequadamente
        }

        return new java.sql.Date(data.getTime());
    }

    public void limparCampos() {
        txtReferencia.setText("");
        txtTipo.setText("");
        txtDataVencimento.setText("");
        txtValor.setText("");
        jlEstatus.setText("Estado da Conta");
        jlId.setText("ID da Conta");

    }

    public void readJTAble() {

        List<Conta> listaConta = dao.read();
      

        for (Conta conta : listaConta) {

            modelo.addLinha(conta);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDataVencimento = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        btnNovaConta = new BotaoRedondo();
        btnCadastrar = new BotaoRedondo();
        btnAlterar = new BotaoRedondo();
        btnExcluir = new BotaoRedondo();
        btnSair = new BotaoRedondo();
        btnMarcarComoPago = new BotaoRedondo();
        jlId = new javax.swing.JLabel();
        jlEstatus = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtContas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Contas");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastre susa Contas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Referencia");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tipo");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Valor");

        txtTipo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtValor.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Data de Vencimento");

        try {
            txtDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataVencimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDataVencimento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Estatus");

        btnNovaConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novo-documento.png"))); // NOI18N
        btnNovaConta.setText("Nova Conta");
        btnNovaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaContaActionPerformed(evt);
            }
        });

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salve-.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/papel.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bin.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnMarcarComoPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dinheiro.png"))); // NOI18N
        btnMarcarComoPago.setText("Macar como pago");
        btnMarcarComoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcarComoPagoActionPerformed(evt);
            }
        });

        jlId.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jlId.setForeground(new java.awt.Color(0, 0, 0));
        jlId.setText("ID da Conta");

        jlEstatus.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlEstatus.setForeground(new java.awt.Color(0, 0, 0));
        jlEstatus.setText("Estatus da Conta");

        txtReferencia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtReferencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtReferencia.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtReferencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlEstatus)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNovaConta, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(btnMarcarComoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlId)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jlId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jlEstatus))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAlterar)
                        .addComponent(btnExcluir)
                        .addComponent(btnMarcarComoPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair))
                    .addComponent(btnNovaConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jtContas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jtContas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Referencia", "Tipo", "Valor", "Data de Vencimento", "Estatus", "Data de Pagamento"
            }
        ));
        jtContas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtContasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtContas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaContaActionPerformed
        // TODO add your handling code here:
        txtReferencia.setText("");
        txtTipo.setText("");
        txtDataVencimento.setText("");
        txtValor.setText("");
        jlEstatus.setText("Estado da Conta");
        jlEstatus.setForeground(Color.BLACK);
        jlId.setText("ID da Conta");
        jlId.setForeground(Color.BLACK);

    }//GEN-LAST:event_btnNovaContaActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:

        conta.setReferencia(txtReferencia.getText());
        conta.setTipo(txtTipo.getText());
        conta.setData_vencimento(dataMysql(txtDataVencimento.getText()));
        conta.setValor(Double.parseDouble(txtValor.getText().replace(",", ".")));
        conta.setEstatus("PENDENTE");

        dao.create(conta);
        modelo.addLinha(conta);

        limparCampos();


    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void jtContasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtContasMouseClicked
        // TODO add your handling code here:
        int index = jtContas.getSelectedRow();

        conta = dao.read().get(index);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dataFormatada = sdf.format(conta.getData_vencimento());

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        Double valorDouble = conta.getValor();
        String valorFormatado = decimalFormat.format(valorDouble);

        jlId.setText(Integer.toString(conta.getId()));
        jlId.setForeground(Color.red);
        txtReferencia.setText(conta.getReferencia());
        txtTipo.setText(conta.getTipo());
        txtDataVencimento.setText(dataFormatada);
        txtValor.setText(valorFormatado);
        jlEstatus.setText(conta.getEstatus());
        
        if ("PENDENTE".equals(conta.getEstatus())) {
            jlEstatus.setForeground(Color.BLUE);
        } else if (conta.getEstatus().equals("PAGO")) {
            jlEstatus.setForeground(Color.GREEN);
        } else if (conta.getEstatus().equals("ATRASADO")) {
            jlEstatus.setForeground(Color.red);
        }

        btnAlterar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnMarcarComoPago.setEnabled(true);
        btnCadastrar.setEnabled(false);


    }//GEN-LAST:event_jtContasMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:

        String id = jlId.getText().trim();

        ContaDAO dao = new ContaDAO();

        int confirm = JOptionPane.showConfirmDialog(null, "Deseja excluir esta conta?", "Confirmação!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            if (jtContas.getSelectedRow() != -1) {
                modelo.removerLinha(jtContas.getSelectedRow());
                dao.delete(id);
                limparCampos();
                JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
                btnExcluir.setEnabled(false);
                btnAlterar.setEnabled(false);
                btnMarcarComoPago.setEnabled(false);
                btnCadastrar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma conta na tabela!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "CANCELADO!");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        String id = jlId.getText().trim();

        ContaDAO dao = new ContaDAO();
        Conta conta = new Conta();

        conta.setId(Integer.parseInt(jlId.getText()));
        conta.setReferencia(txtReferencia.getText());
        conta.setTipo(txtTipo.getText());
        conta.setData_vencimento(dataMysql(txtDataVencimento.getText()));
        try {
            conta.setValor(Double.parseDouble(txtValor.getText().replace(",", ".")));
        } catch (NumberFormatException e) {
            System.out.println(e);

        }
        int confirm = JOptionPane.showConfirmDialog(null, "Deseja alterar esta conta?", "Confirmação!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            if (jtContas.getSelectedRow() != -1) {
                modelo.setValueAt(txtReferencia.getText(), jtContas.getSelectedRow(), 0);
                modelo.setValueAt(txtTipo.getText(), jtContas.getSelectedRow(), 1);
                modelo.setValueAt(txtValor.getText().replace(",", "."), jtContas.getSelectedRow(), 2);
                modelo.setValueAt(txtDataVencimento.getText(), jtContas.getSelectedRow(), 3);

                dao.update(conta);
                limparCampos();
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

                btnExcluir.setEnabled(false);
                btnAlterar.setEnabled(false);
                btnMarcarComoPago.setEnabled(false);
                btnCadastrar.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "CANCELADO!");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnMarcarComoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcarComoPagoActionPerformed
        // TODO add your handling code here:
        String id = jlId.getText().trim();

        Conta conta = new Conta();
        ContaDAO dao = new ContaDAO();
        
        FluxoDeCaixaDAO daoFluxo = new FluxoDeCaixaDAO();
        FluxoDeCaixa fluxo = new FluxoDeCaixa();

        Date dataLocal = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dataString = sdf.format(dataLocal);
        
        String valorPago = JOptionPane.showInputDialog("Informe o valor Pago!");

        conta.setId(Integer.parseInt(jlId.getText()));
        conta.setReferencia(txtReferencia.getText());
        conta.setData_pagamento(dataMysql(dataString));
        conta.setEstatus("PAGO");
        conta.setValorPago(Double.parseDouble(valorPago.replace(",", ".")));
        
        fluxo.setDescricao(conta.getReferencia());
        fluxo.setDataOperacao(LocalDate.now());
        fluxo.setHoraOperacao(LocalTime.now());
        fluxo.setTipo("SAÍDA");
        fluxo.setValorEntrada(0.0);
        fluxo.setValorSaida(conta.getValorPago());

        jlEstatus.setText("PAGO");

        String message = "Deseja marcar " + conta.getReferencia() + " como pago?";

        int confirm = JOptionPane.showConfirmDialog(null, message, "Confirmação!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            if (jtContas.getSelectedRow() != -1) {
                modelo.setValueAt(jlEstatus.getText(), jtContas.getSelectedRow(), 4);
                modelo.setValueAt(dataString, jtContas.getSelectedRow(), 5);
                modelo.setValueAt(valorPago, jtContas.getSelectedRow(),6 );

                dao.updatePagamento(conta);
                daoFluxo.inserir(fluxo);
                JOptionPane.showMessageDialog(null, "Estatus atualizado com sucesso!");
                limparCampos();

                btnExcluir.setEnabled(false);
                btnAlterar.setEnabled(false);
                btnMarcarComoPago.setEnabled(false);
                btnCadastrar.setEnabled(true);
                btnMarcarComoPago.setEnabled(false);
                System.out.println(dataString);
                System.out.println(dataLocal);

            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma conta!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "CANCELADO!");
        }
    }//GEN-LAST:event_btnMarcarComoPagoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
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
                new CadastroContas().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnMarcarComoPago;
    private javax.swing.JButton btnNovaConta;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlEstatus;
    private javax.swing.JLabel jlId;
    private javax.swing.JTable jtContas;
    private javax.swing.JFormattedTextField txtDataVencimento;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}

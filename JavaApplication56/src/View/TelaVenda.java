package View;

import Estilo.BordaCantoArredondado;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import Estilo.TextoMaisculo;
import Model.DAO.FluxoDeCaixaDAO;
import Model.DAO.ItensVendaDAO;
import Model.DAO.PecasDAO;
import Model.DAO.VendaDAO;
import Model.FluxoDeCaixa;
import Model.ItensVenda;
import Model.Pecas;
import Model.Venda;
import Style.table.CentralizarTexto;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;

public class TelaVenda extends javax.swing.JFrame {

    /**
     * Creates new form TelaVenda
     */
    public TelaVenda() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/48x48.png")));

        Timer timer = new Timer(1000, e -> rodape());
        timer.start();

        String placeRolder = "DIGIGITE O NOME DA PEÇA AQUI...";
        txtPesquisa.setText(placeRolder);

        txtBorda();
        rodape();
        colunasTabelaPecas();
        textoMaiusculo();

        lblRodape.requestFocusInWindow();
        jScrollPaneLista.setVisible(false);
        jPanel1.setComponentZOrder(jScrollPaneLista, 0);

        jTPecas.setDefaultRenderer(Object.class, new CentralizarTexto());

    }

    public void colunasTabelaPecas() {
        jTPecas.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTPecas.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTPecas.getColumnModel().getColumn(2).setPreferredWidth(5);
        jTPecas.getColumnModel().getColumn(3).setPreferredWidth(10);

    }

    public void textoMaiusculo() {
        ((AbstractDocument) txtPesquisa.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtQtdItens.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtValorTotal.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtValorUnitario.getDocument()).setDocumentFilter(new TextoMaisculo());

    }

    public void txtBorda() {
        BordaCantoArredondado bad = new BordaCantoArredondado(Color.WHITE);
        lblRodape.setBorder(bad);
    }

    public void rodape() {
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime horaAtual = LocalDateTime.now();
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        lblRodape.setOpaque(true);
        lblRodape.setForeground(Color.WHITE);
        lblRodape.setText("CAIXA ABERTO                           " + formatoData.format(dataAtual) + "                             " + formatoHora.format(horaAtual));
    }

    public void precoTotalPecas() {
        DefaultTableModel modeloTabela = (DefaultTableModel) jTPecas.getModel();
        double soma = 0;
        int colunaPreco = 3;

        for (int i = 0; i < modeloTabela.getRowCount(); i++) {
            Object valor = modeloTabela.getValueAt(i, colunaPreco);

            if (valor instanceof Number) {
                soma += ((Number) valor).doubleValue();
            }
        }
        DecimalFormat df = new DecimalFormat("#.00");
        txtValorTotal.setText(df.format(soma));
    }

    public void contadorItens() {

        DefaultTableModel modeloTabela = (DefaultTableModel) jTPecas.getModel();
        int contador = modeloTabela.getRowCount();

        txtQtdItens.setText(String.valueOf(contador));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        txtPesquisa = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTPecas = new javax.swing.JTable();
        txtQtdItens = new javax.swing.JTextField();
        txtValorTotal = new javax.swing.JTextField();
        txtValorUnitario = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        lblLogo = new javax.swing.JLabel();
        lblRodape = new javax.swing.JLabel();
        btnVendasDoDia = new javax.swing.JButton();
        btnFinalizarVenda = new javax.swing.JButton();
        jScrollPaneLista = new javax.swing.JScrollPane();
        jListPecas = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        btnRemoverPecas = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela De Venda");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPesquisa.setBackground(new java.awt.Color(51, 153, 255));
        txtPesquisa.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtPesquisa.setForeground(new java.awt.Color(255, 255, 255));
        txtPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPesquisaMouseClicked(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });
        jPanel1.add(txtPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1160, 50));

        jTPecas.setBackground(new java.awt.Color(0, 153, 255));
        jTPecas.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTPecas.setForeground(new java.awt.Color(255, 255, 255));
        jTPecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIÇÃO", "QUANTIDADE", "PREÇO"
            }
        ));
        jScrollPane3.setViewportView(jTPecas);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 80, 590, 400));

        txtQtdItens.setEditable(false);
        txtQtdItens.setBackground(new java.awt.Color(0, 153, 255));
        txtQtdItens.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtQtdItens.setForeground(new java.awt.Color(255, 255, 255));
        txtQtdItens.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQtdItens.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Número de Itens", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Arial", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(txtQtdItens, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 530, 260, 60));

        txtValorTotal.setEditable(false);
        txtValorTotal.setBackground(new java.awt.Color(0, 153, 255));
        txtValorTotal.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtValorTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtValorTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtValorTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor Total", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Arial", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(txtValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 530, 250, 60));

        txtValorUnitario.setEditable(false);
        txtValorUnitario.setBackground(new java.awt.Color(0, 153, 255));
        txtValorUnitario.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtValorUnitario.setForeground(new java.awt.Color(255, 255, 255));
        txtValorUnitario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtValorUnitario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor Unitario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Arial", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(txtValorUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 250, 50));

        txtQuantidade.setBackground(new java.awt.Color(0, 153, 255));
        txtQuantidade.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtQuantidade.setForeground(new java.awt.Color(255, 255, 255));
        txtQuantidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQuantidade.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quantidade", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Arial", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyPressed(evt);
            }
        });
        jPanel1.add(txtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 220, 50));

        lblLogo.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(0, 204, 51));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LOGO.png"))); // NOI18N
        lblLogo.setToolTipText("");
        lblLogo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 540, 420));

        lblRodape.setBackground(new java.awt.Color(0, 153, 255));
        lblRodape.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lblRodape.setForeground(new java.awt.Color(0, 0, 0));
        lblRodape.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRodape.setText("jLabel1");
        jPanel1.add(lblRodape, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 756, 1160, 40));

        btnVendasDoDia.setBackground(new java.awt.Color(0, 153, 255));
        btnVendasDoDia.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btnVendasDoDia.setForeground(new java.awt.Color(255, 255, 255));
        btnVendasDoDia.setText("VENDAS DE HOJE");
        btnVendasDoDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendasDoDiaActionPerformed(evt);
            }
        });
        jPanel1.add(btnVendasDoDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 1160, 40));

        btnFinalizarVenda.setBackground(new java.awt.Color(0, 153, 255));
        btnFinalizarVenda.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btnFinalizarVenda.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizarVenda.setText("FINALIZAR VENDA");
        btnFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarVendaActionPerformed(evt);
            }
        });
        jPanel1.add(btnFinalizarVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 1160, 40));

        jListPecas.setBorder(null);
        jListPecas.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jListPecas.setForeground(new java.awt.Color(0, 0, 0));
        jListPecas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListPecasMouseClicked(evt);
            }
        });
        jScrollPaneLista.setViewportView(jListPecas);

        jPanel1.add(jScrollPaneLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1160, 210));

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("TELA INICIAL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 702, 1170, 40));

        btnRemoverPecas.setBackground(new java.awt.Color(0, 153, 255));
        btnRemoverPecas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRemoverPecas.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoverPecas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remover-do-carrinho.png"))); // NOI18N
        btnRemoverPecas.setText("Remover da Lista");
        btnRemoverPecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPecasActionPerformed(evt);
            }
        });
        jPanel1.add(btnRemoverPecas, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 490, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 810));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        // TODO add your handling code here:
        jScrollPaneLista.setVisible(true);

        DefaultListModel<String> modelo = new DefaultListModel<>();
        jListPecas.setModel(modelo);

        String nome = txtPesquisa.getText();
        PecasDAO dao = new PecasDAO();

        modelo.clear();

        if (!nome.isEmpty()) {
            List<String> nomes = dao.listaNome(nome);

            for (String nomePeca : nomes) {
                modelo.addElement(nomePeca);
            }
        } else {
            jScrollPaneLista.setVisible(false);

        }
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void txtPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisaMouseClicked
        // TODO add your handling code here:
        txtPesquisa.setText("");

    }//GEN-LAST:event_txtPesquisaMouseClicked

    private void jListPecasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPecasMouseClicked
        int linha = jListPecas.getSelectedIndex();

        if (linha != -1) {
            String nome = jListPecas.getModel().getElementAt(linha);
            PecasDAO dao = new PecasDAO();
            Pecas peca = dao.vendaPecas(nome);
            txtPesquisa.setText(nome);
            DecimalFormat df = new DecimalFormat("#.00");
            String preco = df.format(peca.getPreco_venda());
            txtValorUnitario.setText(preco);

            jScrollPaneLista.setVisible(false);
        }
    }//GEN-LAST:event_jListPecasMouseClicked

    private void txtQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyPressed
        // TODO add your handling code here:
        String nome = txtPesquisa.getText();
        PecasDAO dao = new PecasDAO();
        Pecas peca = dao.vendaPecas(nome);

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtValorUnitario.getText().isEmpty() && !txtQuantidade.getText().isEmpty()) {
                Double precoUnitario = Double.parseDouble(txtValorUnitario.getText().replace(",", "."));
                int qtd = Integer.parseInt(txtQuantidade.getText());
                Double PrecoTotal = precoUnitario * qtd;
                DefaultTableModel modelo = (DefaultTableModel) jTPecas.getModel();

                modelo.addRow(new Object[]{
                    peca.getId(),
                    nome,
                    qtd,
                    PrecoTotal
                });
                txtPesquisa.setText("DIGIGITE O NOME DA PEÇA AQUI...");
                txtQtdItens.setText("");
                txtValorUnitario.setText("");
                txtQuantidade.setText("");
            }
            precoTotalPecas();
            contadorItens();
            lblRodape.requestFocus();
        }
    }//GEN-LAST:event_txtQuantidadeKeyPressed

    public void listaItens(int idVenda) {
        DefaultTableModel modelo = (DefaultTableModel) jTPecas.getModel();

        List<ItensVenda> itensVenda = new ArrayList<>();
        try {
            ItensVendaDAO dao = new ItensVendaDAO();

            for (int i = 0; i < modelo.getRowCount(); i++) {
                int idPeca = (int) modelo.getValueAt(i, 0);
                int quantidade = (int) modelo.getValueAt(i, 2);
                ItensVenda itens = new ItensVenda(idVenda, idPeca, quantidade);
                itensVenda.add(itens);
            }
            dao.salvarItens(idVenda, itensVenda);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void btnFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarVendaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) jTPecas.getModel();

        VendaDAO vendaDao = new VendaDAO();
        Venda venda = new Venda();
        LocalDate dataAtual = LocalDate.now();
        LocalTime horaAtual = LocalTime.now();
        venda.setQtdItens(Integer.parseInt(txtQtdItens.getText()));
        venda.setData(dataAtual);
        venda.setHora(horaAtual);
        venda.setValor(Double.parseDouble(txtValorTotal.getText().replace(",", ".")));

        String dinheiro = JOptionPane.showInputDialog(null, "INFORME O VALOR RECEBIDO DO CLIENTE");
        double recebido = Double.parseDouble(dinheiro.replace(",", "."));
        String[] opcoes = {"Dinheiro", "Crédito", "Débito"};
        JComboBox<String> comboBox = new JComboBox<>(opcoes);

        int resposta = JOptionPane.showOptionDialog(
                null, // Contêiner pai (null para centralizar)
                comboBox, // O componente que será exibido
                "Escolha um Metodo de Pagamamento!", // Título da janela
                JOptionPane.DEFAULT_OPTION, // Tipo de opção de botão
                JOptionPane.QUESTION_MESSAGE, // Tipo de mensagem
                null, // Ícone personalizado (null para usar o padrão)
                null, // Não é necessário um array de opções
                null // Não é necessário um valor inicial
        );

        if (resposta == JOptionPane.OK_OPTION) {
            venda.setTipoDePagamento((String) comboBox.getSelectedItem());
        }else{
        JOptionPane.showMessageDialog(null,"Escolha um Método de Pagamento!");
        }
        if (dinheiro != null && recebido >= venda.getValor()) {
            double troco = recebido - venda.getValor();
            DecimalFormat df = new DecimalFormat("#,00");
            JOptionPane.showMessageDialog(null, "TROCO: R$" + df.format(troco));
        }
        venda.setDinheiro(recebido);

        int idVenda = vendaDao.salvarVenda(venda);

        if (idVenda > 0 && recebido >= venda.getValor()) {
            listaItens(idVenda);

            txtValorTotal.setText("0,00");
            txtQtdItens.setText("0");
            modelo.setRowCount(0);

            JOptionPane.showMessageDialog(null, "VENDA REALIZA COM SUCESSO!");
        } else {
            JOptionPane.showMessageDialog(null, "ERRO AO REALIZAR VENDA!");
        }
        
        FluxoDeCaixa fluxo = new FluxoDeCaixa();
        fluxo.setDescricao("VENDA");
        fluxo.setDataOperacao(LocalDate.now());
        fluxo.setHoraOperacao(LocalTime.now());
        fluxo.setTipo("ENTRADA");
        fluxo.setValorEntrada(venda.getValor());
        fluxo.setValorSaida(0.0);
        
        FluxoDeCaixaDAO daoFluxo = new FluxoDeCaixaDAO();
        daoFluxo.inserir(fluxo);
        
    }//GEN-LAST:event_btnFinalizarVendaActionPerformed


    private void btnVendasDoDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendasDoDiaActionPerformed
        // TODO add your handling code here:
        VendasDoDia vendas = new VendasDoDia();
        this.dispose();
        vendas.setVisible(true);
    }//GEN-LAST:event_btnVendasDoDiaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        TelaInicial inicial = new TelaInicial();
        this.dispose();
        inicial.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRemoverPecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPecasActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modeloTabela = (DefaultTableModel) jTPecas.getModel();

        int linha = jTPecas.getSelectedRow();
        System.out.println(linha);

        if (linha != -1) {
            modeloTabela.removeRow(linha);
            precoTotalPecas();
            contadorItens();
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum Serviço selecionada!");
        }
    }//GEN-LAST:event_btnRemoverPecasActionPerformed

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
                new TelaVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizarVenda;
    private javax.swing.JButton btnRemoverPecas;
    private javax.swing.JButton btnVendasDoDia;
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jListPecas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPaneLista;
    private javax.swing.JTable jTPecas;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblRodape;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtQtdItens;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Estilo.BordaCantoArredondado;
import com.formdev.flatlaf.FlatLightLaf;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.UIManager;
import Estilo.BotaoRedondo;
import Estilo.TextoMaisculo;
import GerarPdfs.OrcamentoPDF;
import Model.DAO.PecasDAO;
import Model.DAO.ServicoDAO;
import Model.Pecas;
import Model.Servico;
import Style.table.CentralizarTexto;
import java.awt.Color;
import java.time.LocalTime;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author MadaraX4
 */
public class TelaOrcamento extends javax.swing.JFrame {

    /**
     * Creates new form TelaOrcamento
     */
    public TelaOrcamento() {
        initComponents();

        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        jlbTitulo.setText("Orçamento " + formater.format(dataAtual));

        jSPListaPecas.setVisible(false);
        jPanel2.setComponentZOrder(jSPListaPecas, 0);

        jSPListaServico.setVisible(false);
        jPanel2.setComponentZOrder(jSPListaServico, 0);

        jTPecas.setDefaultRenderer(Object.class, new CentralizarTexto());
        jTServicos.setDefaultRenderer(Object.class, new CentralizarTexto());
        
        txtTotalServicos.setHorizontalAlignment(JTextField.CENTER);
        txtTotalPecas.setHorizontalAlignment(JTextField.CENTER);
        
        txtTotalServicos.setEditable(false);
        txtTotalPecas.setEditable(false);

        txtRedondo();
        textoMaiusculo();
        colunasTabelaPecas();
        colunasTabelaServicos();

    }

    public void txtRedondo() {
        BordaCantoArredondado bad = new BordaCantoArredondado(Color.GRAY);

        txtAno.setBorder(bad);
        txtCarro.setBorder(bad);
        txtChassi.setBorder(bad);
        txtCombustivel.setBorder(bad);
        txtMotor.setBorder(bad);
        txtNome.setBorder(bad);
        txtPecas.setBorder(bad);
        txtServicos.setBorder(bad);
        txtTelefone.setBorder(bad);
        txtTotalPecas.setBorder(bad);
        txtTotalServicos.setBorder(bad);
        jListPecas.setBorder(bad);
        jListServicos.setBorder(bad);
        txtValorServico.setBorder(bad);
    }

    public void textoMaiusculo() {
        ((AbstractDocument) txtAno.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtCarro.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtChassi.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtCombustivel.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtMotor.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtNome.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtPecas.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtServicos.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtTelefone.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtValorServico.getDocument()).setDocumentFilter(new TextoMaisculo());
    }

    public void colunasTabelaPecas() {
        jTPecas.getColumnModel().getColumn(0).setPreferredWidth(250);
        jTPecas.getColumnModel().getColumn(1).setPreferredWidth(5);
        jTPecas.getColumnModel().getColumn(2).setPreferredWidth(5);

    }

    public void colunasTabelaServicos() {
        jTServicos.getColumnModel().getColumn(0).setPreferredWidth(250);
        jTServicos.getColumnModel().getColumn(1).setPreferredWidth(5);
    }

    public void precoTotalPecas() {
        DefaultTableModel modeloTabela = (DefaultTableModel) jTPecas.getModel();
        double soma = 0;
        int colunaPreco = 2;

        for (int i = 0; i < modeloTabela.getRowCount(); i++) {
            Object valor = modeloTabela.getValueAt(i, colunaPreco);

            if (valor instanceof Number) {
                soma += ((Number) valor).doubleValue();
            }
        }
        txtTotalPecas.setText(String.valueOf(soma));
    }

    public void precoTotalServicos() {
        DefaultTableModel modeloTabela = (DefaultTableModel) jTServicos.getModel();
        double soma = 0;
        int colunaPreco = 1;

        for (int i = 0; i < modeloTabela.getRowCount(); i++) {
            Object valor = modeloTabela.getValueAt(i, colunaPreco);

            if (valor instanceof Number) {
                soma += ((Number) valor).doubleValue();
            }
        }
        txtTotalServicos.setText(String.valueOf(soma));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCarro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMotor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCombustivel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtChassi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        txtPecas = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtServicos = new javax.swing.JTextField();
        btnNovoServico = new BotaoRedondo();
        jSPListaPecas = new javax.swing.JScrollPane();
        jListPecas = new javax.swing.JList<>();
        jSPListaServico = new javax.swing.JScrollPane();
        jListServicos = new javax.swing.JList<>();
        jLabel12 = new javax.swing.JLabel();
        txtValorServico = new javax.swing.JTextField();
        jlbTitulo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPecas = new javax.swing.JTable();
        txtTotalPecas = new javax.swing.JTextField();
        btnRemoverPeca = new BotaoRedondo();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTServicos = new javax.swing.JTable();
        txtTotalServicos = new javax.swing.JTextField();
        btnRemoverServico = new BotaoRedondo();
        btnNovoOrcamento = new BotaoRedondo();
        btnEmprimir = new BotaoRedondo();
        btnFechar = new BotaoRedondo();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 27, -1, -1));

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 24, 330, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Telefone");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 85, -1, -1));

        txtTelefone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 82, 312, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Carro");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 134, -1, -1));

        txtCarro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCarro.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(txtCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 131, 330, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Motor");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 177, -1, -1));

        txtMotor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 174, 329, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Ano");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 220, -1, -1));

        txtAno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 217, 105, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Combustivel");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 266, -1, -1));

        txtCombustivel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtCombustivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 263, 280, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Chassi");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 315, -1, -1));

        txtChassi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtChassi, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 312, 329, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Adicionar Peça");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 388, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 410, 385, 10));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Peças");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 429, -1, -1));

        txtPecas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPecas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPecasKeyReleased(evt);
            }
        });
        jPanel2.add(txtPecas, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 426, 335, -1));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 503, 385, 10));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Adicionar Serviços");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 481, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Serviços");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 522, -1, -1));

        txtServicos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtServicos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtServicosKeyReleased(evt);
            }
        });
        jPanel2.add(txtServicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 519, 314, -1));

        btnNovoServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novo servico.png"))); // NOI18N
        btnNovoServico.setText("Novo Serviço");
        btnNovoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoServicoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNovoServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 563, 140, 40));

        jListPecas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jListPecas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListPecasMouseClicked(evt);
            }
        });
        jSPListaPecas.setViewportView(jListPecas);

        jPanel2.add(jSPListaPecas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 330, -1));

        jListServicos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jListServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListServicosMouseClicked(evt);
            }
        });
        jSPListaServico.setViewportView(jListServicos);

        jPanel2.add(jSPListaServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 310, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Valor do Serviço");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, -1, -1));

        txtValorServico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtValorServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 570, -1, -1));

        jlbTitulo.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jlbTitulo.setForeground(new java.awt.Color(0, 0, 0));
        jlbTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/orcamento (2).png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTPecas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTPecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIÇÃO", "QUANTIDADE", "PREÇO"
            }
        ));
        jScrollPane1.setViewportView(jTPecas);

        txtTotalPecas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTotalPecas.setText("0.0");

        btnRemoverPeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remover-do-carrinho.png"))); // NOI18N
        btnRemoverPeca.setText("Remover");
        btnRemoverPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPecaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(btnRemoverPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTotalPecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoverPeca)
                    .addComponent(txtTotalPecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTServicos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIÇÃO", "PREÇO"
            }
        ));
        jScrollPane2.setViewportView(jTServicos);

        txtTotalServicos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTotalServicos.setText("0.0");

        btnRemoverServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remover-do-carrinho.png"))); // NOI18N
        btnRemoverServico.setText("Remover");
        btnRemoverServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverServicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(btnRemoverServico, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTotalServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverServico))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNovoOrcamento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNovoOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novo-documento.png"))); // NOI18N
        btnNovoOrcamento.setText("Novo Orçamento");
        btnNovoOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoOrcamentoActionPerformed(evt);
            }
        });

        btnEmprimir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEmprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/impressora.png"))); // NOI18N
        btnEmprimir.setText("Emprimir Orçamento");
        btnEmprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmprimirActionPerformed(evt);
            }
        });

        btnFechar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sair.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovoOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEmprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jlbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNovoOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEmprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        LocalDate dataAtual = LocalDate.now();

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPecasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPecasKeyReleased
        jSPListaPecas.setVisible(true);
        DefaultListModel<String> modelo = new DefaultListModel<>();
        jListPecas.setModel(modelo);

        String nome = txtPecas.getText();
        PecasDAO dao = new PecasDAO();

        modelo.clear();

        if (!nome.isEmpty()) {
            List<String> nomes = dao.listaNome(nome);

            for (String nomePeca : nomes) {
                modelo.addElement(nomePeca);
            }
        } else {
            jSPListaPecas.setVisible(false);
        }

    }//GEN-LAST:event_txtPecasKeyReleased

    private void jListPecasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPecasMouseClicked
        int linha = jListPecas.getSelectedIndex();

        String input = JOptionPane.showInputDialog(null, "Digite a quantidade:\n");
        if (input != null) {
            int quantidade = Integer.parseInt(input);

            if (linha != -1) {
                String nome = jListPecas.getModel().getElementAt(linha);
                PecasDAO dao = new PecasDAO();
                List<Pecas> pecas = dao.listaPecas(nome);

                if (!pecas.isEmpty()) {
                    DefaultTableModel modeloTabela = (DefaultTableModel) jTPecas.getModel();

                    for (Pecas listaPecas : pecas) {
                        Double precoUnitario = quantidade * listaPecas.getPreco_venda();

                        modeloTabela.addRow(new Object[]{
                            listaPecas.getNome(),
                            quantidade,
                            precoUnitario

                        });
                        txtPecas.setText("");
                        jSPListaPecas.setVisible(false);

                    }
                }
                precoTotalPecas();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe uma quantidade!");
        }
    }//GEN-LAST:event_jListPecasMouseClicked

    private void txtServicosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtServicosKeyReleased
        jSPListaServico.setVisible(true);

        String nome = txtServicos.getText();
        ServicoDAO dao = new ServicoDAO();
        DefaultListModel<String> modeloServico = new DefaultListModel<>();
        jListServicos.setModel(modeloServico);

        if (!nome.isEmpty()) {
            List<String> servicos = dao.listaNomes(nome);

            for (String nomeServico : servicos) {
                modeloServico.addElement(nomeServico);

            }
            jSPListaServico.setVisible(!servicos.isEmpty());
        } else {
            jSPListaServico.setVisible(false);
        }

    }//GEN-LAST:event_txtServicosKeyReleased

    private void jListServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListServicosMouseClicked
        int linha = jListServicos.getSelectedIndex();
        String nomeValor = jListServicos.getModel().getElementAt(linha);
        String[] partes = nomeValor.split("\\s*R\\$\\s*");
        String nome = partes[0].trim(); // Remove espaços em branco
        String valor = partes[1].trim();

        String nomeSql = nome;

        if (linha != -1) {
            ServicoDAO dao = new ServicoDAO();
            List<Servico> servicos = dao.listaServicos(nomeSql);

            if (!servicos.isEmpty()) {
                DefaultTableModel modeloTabela = (DefaultTableModel) jTServicos.getModel();

                for (Servico servico : servicos) {
                    modeloTabela.addRow(new Object[]{
                        servico.getNome(),
                        servico.getPreco()
                    });
                    precoTotalServicos();
                    txtServicos.setText("");
                    jSPListaServico.setVisible(false);
                }
            }

        }
    }//GEN-LAST:event_jListServicosMouseClicked

    private void btnRemoverPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPecaActionPerformed
        DefaultTableModel modeloTabela = (DefaultTableModel) jTPecas.getModel();

        int linha = jTPecas.getSelectedRow();
        System.out.println(linha);

        if (linha != -1) {
            modeloTabela.removeRow(linha);
            precoTotalPecas();
        } else {
            JOptionPane.showMessageDialog(null, "Nenhma peça selecionada!");
        }
    }//GEN-LAST:event_btnRemoverPecaActionPerformed

    private void btnRemoverServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverServicoActionPerformed
        DefaultTableModel modeloTabela = (DefaultTableModel) jTServicos.getModel();

        int linha = jTServicos.getSelectedRow();
        System.out.println(linha);

        if (linha != -1) {
            modeloTabela.removeRow(linha);
            precoTotalServicos();
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum Serviço selecionada!");
        }
    }//GEN-LAST:event_btnRemoverServicoActionPerformed

    private void btnNovoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoServicoActionPerformed
        Servico servico = new Servico();
        ServicoDAO dao = new ServicoDAO();

        servico.setNome(txtServicos.getText());
        servico.setPreco(Double.parseDouble(txtValorServico.getText()));

        dao.create(servico);
        txtServicos.setText("");
        txtValorServico.setText("");

    }//GEN-LAST:event_btnNovoServicoActionPerformed

    private void btnNovoOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoOrcamentoActionPerformed
        // TODO add your handling code here:
        txtAno.setText("");
        txtCarro.setText("");
        txtChassi.setText("");
        txtCombustivel.setText("");
        txtMotor.setText("");
        txtNome.setText("");
        txtTelefone.setText("");
        txtTotalServicos.setText("0.0");
        txtTotalServicos.setText("0.0");

        DefaultTableModel modeloServicos = (DefaultTableModel) jTServicos.getModel();
        modeloServicos.setRowCount(0);
        DefaultTableModel modeloPecas = (DefaultTableModel) jTPecas.getModel();
        modeloPecas.setRowCount(0);

    }//GEN-LAST:event_btnNovoOrcamentoActionPerformed

    private void btnEmprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmprimirActionPerformed
        // TODO add your handling code here:
        OrcamentoPDF pdf = new OrcamentoPDF();
        
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataAtual.format(formatoData);
        
        LocalTime horaAtual = LocalTime.now();
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormatada = horaAtual.format(formatoHora);
        String nome = txtNome.getText();
        String telefone = txtTelefone.getText();
        String carro = txtCarro.getText();
        String motor = txtMotor.getText();
        String ano = txtAno.getText();
        String combustivel = txtCombustivel.getText();
        String chassi = txtChassi.getText();
        Double totalPecas = Double.parseDouble(txtTotalPecas.getText());
        Double totalServicos = Double.parseDouble(txtTotalServicos.getText());
        Double valorTotal = totalPecas + totalServicos;
        pdf.gerarPdf(dataFormatada,horaFormatada,nome,telefone,carro,motor,ano,combustivel,chassi,jTPecas,jTServicos,valorTotal);
    }//GEN-LAST:event_btnEmprimirActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

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
                new TelaOrcamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmprimir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovoOrcamento;
    private javax.swing.JButton btnNovoServico;
    private javax.swing.JButton btnRemoverPeca;
    private javax.swing.JButton btnRemoverServico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListPecas;
    private javax.swing.JList<String> jListServicos;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jSPListaPecas;
    private javax.swing.JScrollPane jSPListaServico;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTPecas;
    private javax.swing.JTable jTServicos;
    private javax.swing.JLabel jlbTitulo;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtCarro;
    private javax.swing.JTextField txtChassi;
    private javax.swing.JTextField txtCombustivel;
    private javax.swing.JTextField txtMotor;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPecas;
    private javax.swing.JTextField txtServicos;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtTotalPecas;
    private javax.swing.JTextField txtTotalServicos;
    private javax.swing.JTextField txtValorServico;
    // End of variables declaration//GEN-END:variables
}
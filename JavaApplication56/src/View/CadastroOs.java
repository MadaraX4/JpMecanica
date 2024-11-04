/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import GerarPdfs.OsPDF;
import Estilo.BordaCantoArredondado;
import Estilo.BotaoRedondo;
import Estilo.TextoMaisculo;
import Model.Carro;
import Model.Cliente;
import Model.DAO.CarroDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.OsDAO;
import Model.DAO.Os_PecasDAO;
import Model.DAO.Os_ServicoDAO;
import Model.DAO.PecasDAO;
import Model.DAO.ServicoDAO;
import Model.ListaPecas;
import Model.Os;
import Model.OsPecas;
import Model.OsServicos;
import Model.Pecas;
import Model.Servico;
import Style.table.CentralizarTexto;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.ui.FlatListCellBorder;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;

public class CadastroOs extends javax.swing.JFrame {

    /**
     * Creates new form CadastroOs
     */
    public CadastroOs() {
        initComponents();
        txtBorda();
        scrollPanelistaServicos.setVisible(false);
        jPanel2.setComponentZOrder(scrollPanelistaServicos, 0);
        textoMaiusculo();
        jScrollpanePecas.setVisible(false);
        jPanel2.setComponentZOrder(jScrollpanePecas, 0);
        jScrollPaneAddServicos.setVisible(false);
        jPanel2.setComponentZOrder(jScrollPaneAddServicos, 0);
        jPanel2.setComponentZOrder(jScrollPaneAddClientes, 0);
        
        colunaTabelaServicos();
        colunaTabelaPecas();
        
        JtPecas.setDefaultRenderer(Object.class, new CentralizarTexto());
        jTServicos.setDefaultRenderer(Object.class, new CentralizarTexto());
        
        txtValorTotalPecas.setText("0.0");
        txtValorTotalServico.setText("0.0");
        
        txtDescricao.setLineWrap(true);
        txtDescricao.setWrapStyleWord(true);
        
        jScrollPaneAddClientes.setVisible(false);
        
    }
    
    public void colunaTabelaServicos() {
        jTServicos.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTServicos.getColumnModel().getColumn(1).setPreferredWidth(210);
        jTServicos.getColumnModel().getColumn(2).setPreferredWidth(25);
    }
    
    public void colunaTabelaPecas() {
        JtPecas.getColumnModel().getColumn(0).setPreferredWidth(5);
        JtPecas.getColumnModel().getColumn(1).setPreferredWidth(200);
        JtPecas.getColumnModel().getColumn(2).setPreferredWidth(5);
        JtPecas.getColumnModel().getColumn(3).setPreferredWidth(20);
    }
    
    public void textoMaiusculo() {
        ((AbstractDocument) txtDescricao.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtModelo.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtMontadora.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtNomeCliente.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtNomeServico.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtPeca.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtPlaca.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtTecnico.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtTelefoneCliente.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtValorServico.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtValorTotalPecas.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtCombustivel.getDocument()).setDocumentFilter(new TextoMaisculo());
        
    }
    
    public void txtBorda() {
        BordaCantoArredondado bad = new BordaCantoArredondado(Color.GRAY);
        
        txtDescricao.setBorder(bad);
        txtNomeCliente.setBorder(bad);
        txtModelo.setBorder(bad);
        txtMontadora.setBorder(bad);
        txtNomeServico.setBorder(bad);
        txtPlaca.setBorder(bad);
        txtPeca.setBorder(bad);
        jListCliente.setBorder(bad);
        jListServicos.setBorder(bad);
        jListpecas.setBorder(bad);
        listaPlacas.setBorder(bad);
        txtTelefoneCliente.setBorder(bad);
        txtValorServico.setBorder(bad);
        txtValorTotalPecas.setBorder(bad);
        txtTecnico.setBorder(bad);
        txtValorTotalServico.setBorder(bad);
        txtCombustivel.setBorder(bad);
    }
    
    public void precoTotalPecas() {
        DefaultTableModel modeloTabela = (DefaultTableModel) JtPecas.getModel();
        double soma = 0;
        int colunaPreco = 3;
        
        for (int i = 0; i < modeloTabela.getRowCount(); i++) {
            Object valor = modeloTabela.getValueAt(i, colunaPreco);
            
            if (valor instanceof Number) {
                soma += ((Number) valor).doubleValue();
            }
        }
        txtValorTotalPecas.setText(String.valueOf(soma));
    }
    
    public void precoTotalServicos() {
        DefaultTableModel modeloTabela = (DefaultTableModel) jTServicos.getModel();
        double soma = 0;
        int colunaPreco = 2;
        
        for (int i = 0; i < modeloTabela.getRowCount(); i++) {
            Object valor = modeloTabela.getValueAt(i, colunaPreco);
            
            if (valor instanceof Number) {
                soma += ((Number) valor).doubleValue();
            }
        }
        txtValorTotalServico.setText(String.valueOf(soma));
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
        txtNomeCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTelefoneCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMontadora = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNomeServico = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtValorServico = new javax.swing.JTextField();
        btnNovoServico = new BotaoRedondo();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        txtPeca = new javax.swing.JTextField();
        jlEstatusOs = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTecnico = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollpanePecas = new javax.swing.JScrollPane();
        jListpecas = new javax.swing.JList<>();
        jlabel = new javax.swing.JLabel();
        jlDataOs = new javax.swing.JLabel();
        jScrollPaneAddClientes = new javax.swing.JScrollPane();
        jListCliente = new javax.swing.JList<>();
        jlOsId = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCombustivel = new javax.swing.JTextField();
        jScrollPaneAddServicos = new javax.swing.JScrollPane();
        jListServicos = new javax.swing.JList<>();
        scrollPanelistaServicos = new javax.swing.JScrollPane();
        listaPlacas = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPaneServicos = new javax.swing.JScrollPane();
        JtPecas = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtValorTotalPecas = new javax.swing.JTextField();
        btnRemoverPeca = new BotaoRedondo();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCadastrarOrdem = new BotaoRedondo();
        btnBurcar = new BotaoRedondo();
        btnDeletar = new BotaoRedondo();
        btnImprimir = new BotaoRedondo();
        btnSair = new BotaoRedondo();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTServicos = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        txtValorTotalServico = new javax.swing.JTextField();
        btnremoverServico = new BotaoRedondo();
        btnAtualizar = new BotaoRedondo();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNomeCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNomeCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeClienteKeyReleased(evt);
            }
        });
        jPanel2.add(txtNomeCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 310, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Cliente");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Telefone");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        txtTelefoneCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtTelefoneCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 240, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Placa do veiculo");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        txtPlaca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPlacaKeyReleased(evt);
            }
        });
        jPanel2.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 120, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Montadora");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        txtMontadora.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtMontadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 190, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Modelo");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        txtModelo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 140, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Dados do cliente");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 43, 390, 10));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 143, 390, 10));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Dados do carro");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa (2).png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 30, 30));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 317, 390, 10));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Peças e Serviços");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Serviço");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        txtNomeServico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNomeServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeServicoKeyReleased(evt);
            }
        });
        jPanel2.add(txtNomeServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 310, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Valor do serviço");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        txtValorServico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtValorServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 90, -1));

        btnNovoServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novo servico.png"))); // NOI18N
        btnNovoServico.setText("Novo Serviço");
        btnNovoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoServicoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNovoServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 130, 50));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 390, 10));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Adicionar peças");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        txtPeca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPeca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPecaKeyReleased(evt);
            }
        });
        jPanel2.add(txtPeca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 380, -1));

        jlEstatusOs.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jlEstatusOs.setForeground(new java.awt.Color(255, 0, 51));
        jlEstatusOs.setText("Estatus");
        jPanel2.add(jlEstatusOs, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Tecnico");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        txtTecnico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtTecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 310, -1));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 400, -1));

        jScrollpanePecas.setBorder(null);

        jListpecas.setBorder(null);
        jListpecas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jListpecas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListpecasMouseClicked(evt);
            }
        });
        jScrollpanePecas.setViewportView(jListpecas);

        jPanel2.add(jScrollpanePecas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 380, 150));

        jlabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlabel.setForeground(new java.awt.Color(0, 0, 0));
        jlabel.setText("OS ID :");
        jPanel2.add(jlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jlDataOs.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlDataOs.setForeground(new java.awt.Color(0, 0, 0));
        jlDataOs.setText("DATA DA OS");
        jPanel2.add(jlDataOs, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, -1));

        jListCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jListCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListClienteMouseClicked(evt);
            }
        });
        jListCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jListClienteKeyReleased(evt);
            }
        });
        jScrollPaneAddClientes.setViewportView(jListCliente);

        jPanel2.add(jScrollPaneAddClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 310, 70));

        jlOsId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlOsId.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jlOsId, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 40, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Combustivel");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        txtCombustivel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtCombustivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 200, -1));

        jListServicos.setBorder(null);
        jListServicos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jListServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListServicosMouseClicked(evt);
            }
        });
        jScrollPaneAddServicos.setViewportView(jListServicos);

        jPanel2.add(jScrollPaneAddServicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 310, 100));

        scrollPanelistaServicos.setBorder(null);

        listaPlacas.setBorder(null);
        listaPlacas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        listaPlacas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaPlacasMouseClicked(evt);
            }
        });
        scrollPanelistaServicos.setViewportView(listaPlacas);

        jPanel2.add(scrollPanelistaServicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 120, 110));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 570));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JtPecas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JtPecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Quantidade", "Preço"
            }
        ));
        jScrollPaneServicos.setViewportView(JtPecas);

        jPanel3.add(jScrollPaneServicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 480, 180));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Total");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 30));

        txtValorTotalPecas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtValorTotalPecas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(txtValorTotalPecas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 80, -1));

        btnRemoverPeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remover-do-carrinho.png"))); // NOI18N
        btnRemoverPeca.setText("Remover");
        btnRemoverPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPecaActionPerformed(evt);
            }
        });
        jPanel3.add(btnRemoverPeca, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 120, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 500, 240));

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDescricao.setColumns(20);
        txtDescricao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDescricao.setRows(5);
        jScrollPane2.setViewportView(txtDescricao);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 480, 100));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Descrição da Ordem de Serviço");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 167, -1, 110));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, 500, 150));

        btnCadastrarOrdem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novo-documento.png"))); // NOI18N
        btnCadastrarOrdem.setText("Cadastrar Ordem");
        btnCadastrarOrdem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarOrdemActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadastrarOrdem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 160, 40));

        btnBurcar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/browser_427831.png"))); // NOI18N
        btnBurcar.setText("Buscar Ordem");
        btnBurcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBurcarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBurcar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 590, 150, 40));

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bin.png"))); // NOI18N
        btnDeletar.setText("Deletar Ordem");
        jPanel1.add(btnDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 590, 160, 40));

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/impressora.png"))); // NOI18N
        btnImprimir.setText("Imprimir Ordem");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 590, 180, 40));

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 590, 90, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTServicos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Valor"
            }
        ));
        jScrollPane3.setViewportView(jTServicos);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 470, 100));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Total");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 40, -1));

        txtValorTotalServico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtValorTotalServico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel5.add(txtValorTotalServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        btnremoverServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remover-do-carrinho.png"))); // NOI18N
        btnremoverServico.setText("Remover");
        btnremoverServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnremoverServicoActionPerformed(evt);
            }
        });
        jPanel5.add(btnremoverServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 120, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 500, 160));

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atualizar.png"))); // NOI18N
        btnAtualizar.setText("Atualizar OS");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 590, 150, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 640));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlacaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlacaKeyReleased
        // TODO add your handling code here:

        scrollPanelistaServicos.setVisible(true);
        DefaultListModel<String> modelo = new DefaultListModel<>();
        listaPlacas.setModel(modelo);
        
        String placa = txtPlaca.getText();
        CarroDAO dao = new CarroDAO();
        
        modelo.clear();
        
        if (!placa.isEmpty()) {
            List<String> placas = dao.listaPlaca(placa);
            for (String placaCarro : placas) {
                modelo.addElement(placaCarro);
            }
        } else {
            scrollPanelistaServicos.setVisible(false);
        }

        //listaPlacas.addListSelectionListener(new ListSelectionListener());
    }//GEN-LAST:event_txtPlacaKeyReleased

    private void listaPlacasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaPlacasMouseClicked
        // TODO add your handling code here:
        int linha = listaPlacas.getSelectedIndex();
        
        if (linha != -1) {
            String placa = listaPlacas.getModel().getElementAt(linha);
            CarroDAO dao = new CarroDAO();
            List<Carro> carros = dao.pesquisa(placa);
            
            if (!carros.isEmpty()) {
                Carro carro = carros.get(linha);
                
                txtPlaca.setText(carro.getPlaca());
                txtModelo.setText(carro.getModelo());
                txtMontadora.setText(carro.getMontadora());
                txtCombustivel.setText(carro.getCobustivel());
                scrollPanelistaServicos.setVisible(false);
                scrollPanelistaServicos.setVisible(false);
            }
            
        }

    }//GEN-LAST:event_listaPlacasMouseClicked

    private void txtPecaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPecaKeyReleased
        // TODO add your handling code here:
        jScrollpanePecas.setVisible(true);
        DefaultListModel<String> modelo = new DefaultListModel<>();
        jListpecas.setModel(modelo);
        
        String nome = txtPeca.getText();
        PecasDAO dao = new PecasDAO();
        
        modelo.clear();
        
        if (!nome.isEmpty()) {
            List<String> nomes = dao.listaNome(nome);
            
            for (String nomePeca : nomes) {
                modelo.addElement(nomePeca);
            }
        } else {
            jScrollpanePecas.setVisible(false);
        }
    }//GEN-LAST:event_txtPecaKeyReleased

    private void jListpecasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListpecasMouseClicked
        // TODO add your handling code here:
        int linha = jListpecas.getSelectedIndex();
        
        String input = JOptionPane.showInputDialog(null, "Digite a quantidade:\n");
        if (input != null) {
            int quantidade = Integer.parseInt(input);
            
            if (linha != -1) {
                String nome = jListpecas.getModel().getElementAt(linha);
                PecasDAO dao = new PecasDAO();
                List<Pecas> pecas = dao.listaPecas(nome);
                
                if (!pecas.isEmpty()) {
                    DefaultTableModel modeloTabela = (DefaultTableModel) JtPecas.getModel();
                    
                    for (Pecas listaPecas : pecas) {
                        Double precoUnitario = quantidade * listaPecas.getPreco_venda();
                        
                        modeloTabela.addRow(new Object[]{
                            listaPecas.getId(),
                            listaPecas.getNome(),
                            quantidade,
                            precoUnitario
                        
                        });
                        txtPeca.setText("");
                        jScrollpanePecas.setVisible(false);
                        
                    }
                }
                precoTotalPecas();
                
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe uma quantidade!");
        }

    }//GEN-LAST:event_jListpecasMouseClicked

    private void btnNovoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoServicoActionPerformed
        // TODO add your handling code here:

        Servico servico = new Servico();
        ServicoDAO dao = new ServicoDAO();

        //String input = JOptionPane.showInputDialog(null,"Informe a quantidade do serviço");
        //int quantidade = Integer.parseInt(input);
        servico.setNome(txtNomeServico.getText());
        servico.setPreco(Double.parseDouble(txtValorServico.getText()));
        
        dao.create(servico);
        txtNomeServico.setText("");
        txtValorServico.setText("");

    }//GEN-LAST:event_btnNovoServicoActionPerformed

    private void txtNomeServicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeServicoKeyReleased
        // TODO add your handling code here:
        jScrollPaneAddServicos.setVisible(true);
        
        String nome = txtNomeServico.getText();
        ServicoDAO dao = new ServicoDAO();
        DefaultListModel<String> modeloServico = new DefaultListModel<>();
        jListServicos.setModel(modeloServico);
        
        if (!nome.isEmpty()) {
            List<String> servicos = dao.listaNomes(nome);
            
            for (String nomeServico : servicos) {
                modeloServico.addElement(nomeServico);
                
            }
            jScrollPaneAddServicos.setVisible(!servicos.isEmpty());
        } else {
            jScrollPaneAddServicos.setVisible(false);
        }

    }//GEN-LAST:event_txtNomeServicoKeyReleased

    private void jListServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListServicosMouseClicked
        // TODO add your handling code here:
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
                        servico.getId(),
                        servico.getNome(),
                        servico.getPreco()
                    });
                    precoTotalServicos();
                    txtNomeServico.setText("");
                    jScrollPaneAddServicos.setVisible(false);
                }
            }
            
        }
        

    }//GEN-LAST:event_jListServicosMouseClicked

    private void btnRemoverPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPecaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modeloTabela = (DefaultTableModel) JtPecas.getModel();
        
        int linha = JtPecas.getSelectedRow();
        System.out.println(linha);
        
        if (linha != -1) {
            modeloTabela.removeRow(linha);
            precoTotalPecas();
        } else {
            JOptionPane.showMessageDialog(null, "Nenhma peça selecionada!");
        }

    }//GEN-LAST:event_btnRemoverPecaActionPerformed

    private void btnremoverServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoverServicoActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modeloTabela = (DefaultTableModel) jTServicos.getModel();
        
        int linha = jTServicos.getSelectedRow();
        System.out.println(linha);
        
        if (linha != -1) {
            modeloTabela.removeRow(linha);
            precoTotalServicos();
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum Serviço selecionada!");
        }
    }//GEN-LAST:event_btnremoverServicoActionPerformed
    
    public void createOsPecas(int os_id) {
        DefaultTableModel modeloPecas = (DefaultTableModel) JtPecas.getModel();
        
        List<OsPecas> OsPecas = new ArrayList<>();
        try {
            Os_PecasDAO dao = new Os_PecasDAO();
            for (int i = 0; i < modeloPecas.getRowCount(); i++) {
                int idPeca = (int) modeloPecas.getValueAt(i, 0);
                int quantidadePeca = (int) modeloPecas.getValueAt(i, 2);
                OsPecas osPecas = new OsPecas(os_id, idPeca, quantidadePeca);
                OsPecas.add(osPecas);
            }
            dao.create(os_id, OsPecas);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void createOsServicos(int os_id) {
        DefaultTableModel modeloServicos = (DefaultTableModel) jTServicos.getModel();
        
        List<OsServicos> OsServico = new ArrayList<>();
        ServicoDAO sDao = new ServicoDAO();
        try {
            Os_ServicoDAO dao = new Os_ServicoDAO();
            for (int i = 0; i < modeloServicos.getRowCount(); i++) {
                int idServico = (int) modeloServicos.getValueAt(i, 0);
                int id = sDao.verificaId(idServico);
                OsServicos osServicos = new OsServicos(os_id, id);
                OsServico.add(osServicos);
            }
            
            dao.create(os_id, OsServico);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    

    private void btnCadastrarOrdemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarOrdemActionPerformed
        // TODO add your handling code here:

        Os os = new Os();
        OsDAO dao = new OsDAO();
        Date dataAtual = new Date();
        
        os.setClienteNome(txtNomeCliente.getText());
        os.setDescricao(txtDescricao.getText());
        os.setModelo(txtModelo.getText());
        os.setMontadora(txtMontadora.getText());
        os.setPlacaVeiculo(txtPlaca.getText());
        os.setStatus("ANALISE");
        os.setDataOrdem(dataAtual);
        os.setTecnico(txtTecnico.getText());
        os.setTelefone(txtTelefoneCliente.getText());
        os.setValor(Double.parseDouble(txtValorTotalPecas.getText()) + Double.parseDouble(txtValorTotalServico.getText()));
        os.setCombustivel(txtCombustivel.getText());
        
        int id_os = dao.salvarOs(os);
        if (id_os > 0) {
            createOsPecas(id_os);
            createOsServicos(id_os);
            
            jlOsId.setText(String.valueOf(id_os));
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
            jlDataOs.setText(sdf.format(dataAtual));
            jlEstatusOs.setText(os.getStatus());
            
            JOptionPane.showMessageDialog(null, "Os Cadastrada com Sucesso!");
        }
        

    }//GEN-LAST:event_btnCadastrarOrdemActionPerformed

    private void jListClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jListClienteKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jListClienteKeyReleased

    private void txtNomeClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeClienteKeyReleased
        // TODO add your handling code here:
        jScrollPaneAddClientes.setVisible(true);
        
        String cpf = txtNomeCliente.getText();
        ClienteDAO dao = new ClienteDAO();
        
        DefaultListModel<String> modelo = new DefaultListModel<>();
        jListCliente.setModel(modelo);
        
        if (!cpf.isEmpty()) {
            List<String> cpfClientes = dao.listaNome(cpf);
            
            for (String cpfCliente : cpfClientes) {
                modelo.addElement(cpfCliente);
            }
            jScrollPaneAddClientes.setVisible(!cpfClientes.isEmpty());
        } else {
            jScrollPaneAddClientes.setVisible(false);
        }
    }//GEN-LAST:event_txtNomeClienteKeyReleased

    private void jListClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListClienteMouseClicked
        // TODO add your handling code here:
        int linha = jListCliente.getSelectedIndex();
        
        String nome = jListCliente.getModel().getElementAt(linha);
        
        if (linha != -1) {
            ClienteDAO dao = new ClienteDAO();
            List<Cliente> clientes = dao.listaCliente(nome);
            
            if (!clientes.isEmpty()) {
                Cliente cliente = clientes.get(linha);
                txtNomeCliente.setText(cliente.getNome());
                txtTelefoneCliente.setText(cliente.getTelefone());
                jScrollPaneAddClientes.setVisible(false);
            }
        }

    }//GEN-LAST:event_jListClienteMouseClicked

    private void btnBurcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBurcarActionPerformed
        // TODO add your handling code here:
        String id = JOptionPane.showInputDialog("Informe o Id da OS");
        int idOs = Integer.parseInt(id);
        
        OsDAO dao = new OsDAO();
        
        if (idOs != 0) {
            Os os = dao.Select(idOs);
            
            if (os != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
                txtDescricao.setText(os.getDescricao());
                txtModelo.setText(os.getModelo());
                txtMontadora.setText(os.getMontadora());
                txtNomeCliente.setText(os.getClienteNome());
                txtPlaca.setText(os.getPlacaVeiculo());
                txtTecnico.setText(os.getTecnico());
                txtTelefoneCliente.setText(os.getTelefone());
                txtCombustivel.setText(os.getCombustivel());
                jlDataOs.setText(sdf.format(os.getDataOrdem()));
                jlEstatusOs.setText(os.getStatus());
                jlOsId.setText(String.valueOf(os.getId()));
                selectTablePecas(idOs);
                precoTotalPecas();
                
                selectTableServicos(idOs);
                precoTotalServicos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe um valor correspondente ao ID!");
        }
    }//GEN-LAST:event_btnBurcarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        int osId = Integer.parseInt(jlOsId.getText());
        
        Os os = new Os();
        OsDAO dao = new OsDAO();
        Date aprovada = new Date();
        os.setId(osId);
        os.setStatus("APROVADA");
        os.setDataAprovação(aprovada);
        
        int confirm = JOptionPane.showConfirmDialog(null, "Deseja auterar o estatus da OS para APROVADA?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_NO_OPTION) {
            dao.atualizarEstatus(os);
            jlEstatusOs.setText(os.getStatus());
        } else {
            JOptionPane.showMessageDialog(null, "CANCELADO!");
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        String id = JOptionPane.showInputDialog("Informe o ID da Os!");
        int idOs =Integer.parseInt(id) ;
       OsPDF pdf = new OsPDF();
       pdf.gerarPdf(idOs);
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed
    
    public void selectTablePecas(int idOs) {
        DefaultTableModel modelo = (DefaultTableModel) JtPecas.getModel();
        
        Os_PecasDAO dao = new Os_PecasDAO();
        
        List<ListaPecas> lista = dao.lista(idOs);
        
        for (ListaPecas listaPecas : lista) {
            Object[] objeto = new Object[4];
            objeto[0] = listaPecas.getPeca().getId();
            objeto[1] = listaPecas.getPeca().getNome();
            objeto[2] = listaPecas.getQuantidade();
            objeto[3] = listaPecas.getPeca().getPreco_venda();
            
            modelo.addRow(objeto);
        }
        
    }
    
    public void selectTableServicos(int idOs) {
        DefaultTableModel modelo = (DefaultTableModel) jTServicos.getModel();
        
        Os_ServicoDAO dao = new Os_ServicoDAO();
        
        List<Servico> lista = dao.lista(idOs);
        
        for (Servico servico : lista) {
            Object[] objeto = new Object[3];
            objeto[0] = servico.getId();
            objeto[1] = servico.getNome();
            objeto[2] = servico.getPreco();
            
            modelo.addRow(objeto);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroOs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtPecas;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBurcar;
    private javax.swing.JButton btnCadastrarOrdem;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnNovoServico;
    private javax.swing.JButton btnRemoverPeca;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnremoverServico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListCliente;
    private javax.swing.JList<String> jListServicos;
    private javax.swing.JList<String> jListpecas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPaneAddClientes;
    private javax.swing.JScrollPane jScrollPaneAddServicos;
    private javax.swing.JScrollPane jScrollPaneServicos;
    private javax.swing.JScrollPane jScrollpanePecas;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTServicos;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlDataOs;
    private javax.swing.JLabel jlEstatusOs;
    private javax.swing.JLabel jlOsId;
    private javax.swing.JLabel jlabel;
    private javax.swing.JList<String> listaPlacas;
    private javax.swing.JScrollPane scrollPanelistaServicos;
    private javax.swing.JTextField txtCombustivel;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtMontadora;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeServico;
    private javax.swing.JTextField txtPeca;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtTecnico;
    private javax.swing.JTextField txtTelefoneCliente;
    private javax.swing.JTextField txtValorServico;
    private javax.swing.JTextField txtValorTotalPecas;
    private javax.swing.JTextField txtValorTotalServico;
    // End of variables declaration//GEN-END:variables
}

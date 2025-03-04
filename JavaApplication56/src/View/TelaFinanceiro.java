package View;

import Model.DAO.FluxoDeCaixaDAO;
import Model.FluxoDeCaixa;
import Style.table.Cabecalho;
import Style.table.Render;
import com.formdev.flatlaf.FlatLightLaf;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import Estilo.BotaoRedondo;
import Model.DAO.CaixaDAO;
import java.awt.Color;
import java.awt.Toolkit;
import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author MadaraX4
 */
public class TelaFinanceiro extends javax.swing.JFrame {

    /**
     * Creates new form TelaFinanceiro
     */
    public TelaFinanceiro() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/48x48.png")));

        Timer timer = new Timer(1000, e -> relogio());
        timer.start();

        colunaTabela();

        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 204));
        jTFluxoDeCaixa.setBackground(new java.awt.Color(255, 255, 204));

        Render render = new Render();
        for (int i = 0; i < jTFluxoDeCaixa.getColumnCount(); i++) {
            jTFluxoDeCaixa.getColumnModel().getColumn(i).setCellRenderer(render);
        }

        JTableHeader header = jTFluxoDeCaixa.getTableHeader();
        header.setDefaultRenderer(new Cabecalho());

        listaFluxo();
        totalEntrada();
        totalSaida();

        txtValorEmCaixa.setEditable(false);
        valorEmCaixa();
        
    }

    private void valorEmCaixa() {

        CaixaDAO dao = new CaixaDAO();
        DecimalFormat df = new DecimalFormat("#,##0.00");
        Double valor = dao.select();
        if (valor > 0) {
            txtValorEmCaixa.setText("R$ " + df.format(valor));
            txtValorEmCaixa.setForeground(Color.BLUE);
        } else {
            txtValorEmCaixa.setText("R$ " + df.format(valor));
            txtValorEmCaixa.setForeground(Color.red);
        }

    }

    public void relogio() {
        LocalTime horaAtual = LocalTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
        lblHora.setText(df.format(horaAtual));

    }

    public void colunaTabela() {
        jTFluxoDeCaixa.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTFluxoDeCaixa.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTFluxoDeCaixa.getColumnModel().getColumn(2).setPreferredWidth(30);
        jTFluxoDeCaixa.getColumnModel().getColumn(3).setPreferredWidth(30);
        jTFluxoDeCaixa.getColumnModel().getColumn(4).setPreferredWidth(20);
        jTFluxoDeCaixa.getColumnModel().getColumn(5).setPreferredWidth(20);
    }

    public void listaFluxo() {

        DefaultTableModel modelo = (DefaultTableModel) jTFluxoDeCaixa.getModel();
        FluxoDeCaixaDAO dao = new FluxoDeCaixaDAO();

        List<FluxoDeCaixa> lista = dao.listaFluxo();
        modelo.setNumRows(0);

        for (FluxoDeCaixa fluxoDeCaixa : lista) {
            Object[] objeto = new Object[6];
            DateTimeFormatter dfData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DecimalFormat decimal = new DecimalFormat("###0.00");
            objeto[0] = fluxoDeCaixa.getDescricao();
            objeto[1] = fluxoDeCaixa.getTipo();
            objeto[2] = dfData.format(fluxoDeCaixa.getDataOperacao());
            objeto[3] = fluxoDeCaixa.getHoraOperacao();
            objeto[4] = decimal.format(fluxoDeCaixa.getValorEntrada());
            objeto[5] = decimal.format(fluxoDeCaixa.getValorSaida());
            modelo.addRow(objeto);
        }

    }

    public void FluxoMes(int mes, int ano) {

        DefaultTableModel modelo = (DefaultTableModel) jTFluxoDeCaixa.getModel();
        FluxoDeCaixaDAO dao = new FluxoDeCaixaDAO();

        List<FluxoDeCaixa> lista = dao.fluxoPorMes(mes,ano);
        modelo.setNumRows(0);

        for (FluxoDeCaixa fluxoDeCaixa : lista) {
            Object[] objeto = new Object[6];
            DateTimeFormatter dfData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DecimalFormat decimal = new DecimalFormat("###0.00");
            objeto[0] = fluxoDeCaixa.getDescricao();
            objeto[1] = fluxoDeCaixa.getTipo();
            objeto[2] = dfData.format(fluxoDeCaixa.getDataOperacao());
            objeto[3] = fluxoDeCaixa.getHoraOperacao();
            objeto[4] = decimal.format(fluxoDeCaixa.getValorEntrada());
            objeto[5] = decimal.format(fluxoDeCaixa.getValorSaida());
            modelo.addRow(objeto);
        }

    }

    public void totalEntrada() {
        DefaultTableModel modelo = (DefaultTableModel) jTFluxoDeCaixa.getModel();

        double soma = 0;
        int coluna = 4;

        for (int i = 0; i < modelo.getRowCount(); i++) {
            Object valor = modelo.getValueAt(i, coluna);
            if (valor != null && valor instanceof String) {
                String valorString = (String) valor;
                valorString = valorString.replace(",", ".");
                try {
                    soma += Double.parseDouble(valorString);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        //System.out.println(soma);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        txtTotalEntrada.setText(df.format(soma));

    }

    public void totalSaida() {

        DefaultTableModel modelo = (DefaultTableModel) jTFluxoDeCaixa.getModel();
        double soma = 0;
        int coluna = 5;

        for (int i = 0; i < modelo.getRowCount(); i++) {
            Object valor = modelo.getValueAt(i, coluna);

            if (valor != null && valor instanceof String) {
                String valorString = (String) valor;
                valorString = valorString.replace(",", "."); // substitui vírgula por ponto

                try {
                    soma += Double.parseDouble(valorString);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        DecimalFormat df = new DecimalFormat("#,##0.00");
        txtTotalSaida.setText(df.format(soma));
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
        lblHora = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTFluxoDeCaixa = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTotalEntrada = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTotalSaida = new javax.swing.JTextField();
        txtNovaEntrada = new BotaoRedondo();
        txtNovaSaida = new BotaoRedondo();
        btnDeletar = new BotaoRedondo();
        jButton2 = new BotaoRedondo();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtValorEmCaixa = new javax.swing.JTextField();
        jCbMes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Financeiro");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(153, 255, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Financeiro");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, -1, -1));

        lblHora.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblHora.setForeground(new java.awt.Color(0, 0, 0));
        lblHora.setText("Hora");
        jPanel2.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 150, 30));

        btnSair.setBackground(new java.awt.Color(255, 255, 204));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perto.png"))); // NOI18N
        btnSair.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel2.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 70, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1010, -1));

        jTFluxoDeCaixa.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTFluxoDeCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIÇÃO", "TIPO", "DATA", "HORA", "VALOR ENTRADA", "VALOR DE SAIDA"
            }
        ));
        jTFluxoDeCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFluxoDeCaixaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTFluxoDeCaixa);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 48, 1010, 497));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("VALOR TOTAL DE ENTRADAS DO MÊS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 560, -1, -1));

        txtTotalEntrada.setEditable(false);
        txtTotalEntrada.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel1.add(txtTotalEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 557, 143, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("VALOR TOTAL DE SAIDAS DO MÊS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 560, -1, -1));

        txtTotalSaida.setEditable(false);
        txtTotalSaida.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel1.add(txtTotalSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(871, 557, 133, -1));

        txtNovaEntrada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNovaEntrada.setText("Adicionar Nova Entrada");
        txtNovaEntrada.setMaximumSize(new java.awt.Dimension(200, 31));
        txtNovaEntrada.setMinimumSize(new java.awt.Dimension(200, 31));
        txtNovaEntrada.setPreferredSize(new java.awt.Dimension(200, 31));
        txtNovaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNovaEntradaActionPerformed(evt);
            }
        });
        jPanel1.add(txtNovaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 591, 234, 43));

        txtNovaSaida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNovaSaida.setText("Adicionar Nova Saida");
        txtNovaSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNovaSaidaActionPerformed(evt);
            }
        });
        jPanel1.add(txtNovaSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 590, 234, 43));

        btnDeletar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remover-do-carrinho.png"))); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 590, 130, 40));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/papel.png"))); // NOI18N
        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 590, 130, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Valor Em Caixa");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        txtValorEmCaixa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtValorEmCaixa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(txtValorEmCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 230, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 1010, 50));

        jCbMes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL", "JUNHO", "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO" }));
        jCbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbMesActionPerformed(evt);
            }
        });
        jPanel1.add(jCbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 590, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 690));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        TelaInicial inicial = new TelaInicial();
        this.dispose();
        inicial.setVisible(true);
    }//GEN-LAST:event_btnSairActionPerformed

    private void txtNovaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNovaEntradaActionPerformed
        // TODO add your handling code here:

        String descricao = JOptionPane.showInputDialog("Digite a Descrição");
        String valor = JOptionPane.showInputDialog("Digite o Valor\n");

        FluxoDeCaixa fluxo = new FluxoDeCaixa();

        if (descricao != null) {
            fluxo.setDescricao(descricao);
        } else {
            JOptionPane.showMessageDialog(null, "Digite uma descrição para a entrada!");
        }

        fluxo.setDataOperacao(LocalDate.now());
        fluxo.setHoraOperacao(LocalTime.now());
        fluxo.setTipo("ENTRADA");

        if (valor != null) {
            fluxo.setValorEntrada(Double.parseDouble(valor.replace(",", ".")));
        } else {
            JOptionPane.showMessageDialog(null, "Degite um valor para a entrada!");
        }

        fluxo.setValorSaida(0.0);

        FluxoDeCaixaDAO dao = new FluxoDeCaixaDAO();
        CaixaDAO novoCaixa = new CaixaDAO();

        dao.inserir(fluxo);
        novoCaixa.soma(Double.parseDouble(valor.replace(",", ".")));

        listaFluxo();
        totalEntrada();
        totalSaida();
        valorEmCaixa();


    }//GEN-LAST:event_txtNovaEntradaActionPerformed

    private void txtNovaSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNovaSaidaActionPerformed
        // TODO add your handling code here:

        String descricao = JOptionPane.showInputDialog("Digite a Descrição");
        String valor = JOptionPane.showInputDialog("Digite o Valor");

        FluxoDeCaixa fluxo = new FluxoDeCaixa();

        if (descricao != null) {
            fluxo.setDescricao(descricao);
        } else {
            JOptionPane.showMessageDialog(null, "Digite uma descrição para a saida!");
        }

        fluxo.setDataOperacao(LocalDate.now());
        fluxo.setHoraOperacao(LocalTime.now());
        fluxo.setTipo("SAÍDA");

        if (valor != null) {
            fluxo.setValorSaida(Double.parseDouble(valor.replace(",", ".")));
        } else {
            JOptionPane.showMessageDialog(null, "Degite um valor para a saida!");
        }

        fluxo.setValorEntrada(0.0);

        FluxoDeCaixaDAO dao = new FluxoDeCaixaDAO();
        CaixaDAO novoCaixa = new CaixaDAO();

        dao.inserir(fluxo);
        novoCaixa.subtracao(Double.parseDouble(valor.replace(",", ".")));

        listaFluxo();
        totalEntrada();
        totalSaida();
        valorEmCaixa();
    }//GEN-LAST:event_txtNovaSaidaActionPerformed

    private void jTFluxoDeCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFluxoDeCaixaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFluxoDeCaixaMouseClicked

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int linha = jTFluxoDeCaixa.getSelectedRow();

        if (linha != -1) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse((String) jTFluxoDeCaixa.getValueAt(linha, 2), df);
            LocalTime hora = (LocalTime) jTFluxoDeCaixa.getValueAt(linha, 3);

            if (jTFluxoDeCaixa.getValueAt(linha, 1).equals("ENTRADA")) {
                int confirm = JOptionPane.showConfirmDialog(null, "Deseja excluir esta ENTRADA?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    FluxoDeCaixaDAO dao = new FluxoDeCaixaDAO();
                    CaixaDAO novoCaixa = new CaixaDAO();
                    dao.delete(hora, data);
                    novoCaixa.subtracao(Double.parseDouble((String) jTFluxoDeCaixa.getValueAt(linha, 4).toString().replace(".", "").replace(",", ".")));

                    listaFluxo();
                    totalEntrada();
                    totalSaida();
                    valorEmCaixa();

                } else {
                    JOptionPane.showMessageDialog(null, "Exclusão cancelada!");
                }
            } else if (jTFluxoDeCaixa.getValueAt(linha, 1).equals("SAÍDA")) {
                int confirm = JOptionPane.showConfirmDialog(null, "Deseja excluir esta ENTRADA?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    FluxoDeCaixaDAO dao = new FluxoDeCaixaDAO();
                    CaixaDAO novoCaixa = new CaixaDAO();
                    dao.delete(hora, data);

                    novoCaixa.soma(Double.parseDouble(jTFluxoDeCaixa.getValueAt(linha, 5).toString().replace(".", "").replace(",", ".")));

                    listaFluxo();
                    totalEntrada();
                    totalSaida();
                    valorEmCaixa();
                }
            }

        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int linha = jTFluxoDeCaixa.getSelectedRow();

        if (linha != -1) {
            String valor = JOptionPane.showInputDialog("Insira o novo Valor!");
            FluxoDeCaixaDAO dao = new FluxoDeCaixaDAO();
            FluxoDeCaixa fluxo = new FluxoDeCaixa();
            CaixaDAO novoCaixa = new CaixaDAO();
            fluxo.setDescricao((String) jTFluxoDeCaixa.getValueAt(linha, 0));
            fluxo.setTipo((String) jTFluxoDeCaixa.getValueAt(linha, 1));
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            fluxo.setDataOperacao(LocalDate.parse((String) jTFluxoDeCaixa.getValueAt(linha, 2), df));
            fluxo.setHoraOperacao((LocalTime) jTFluxoDeCaixa.getValueAt(linha, 3));

            if (jTFluxoDeCaixa.getValueAt(linha, 1).equals("ENTRADA")) {
                Double entrada = Double.parseDouble(valor.replace(",", "."));
                fluxo.setValorEntrada(entrada);
                fluxo.setValorSaida(0.0);
                dao.updateEntrada(fluxo);
                Double valor1 = Double.parseDouble(jTFluxoDeCaixa.getValueAt(linha, 4).toString().replace(".", "").replace(",", "."));

                listaFluxo();
                totalEntrada();
                totalSaida();

                if (entrada < valor1) {
                    novoCaixa.subtracao(valor1 - entrada);
                } else {
                    novoCaixa.soma(entrada - valor1);
                }
                valorEmCaixa();

            } else if (jTFluxoDeCaixa.getValueAt(linha, 1).equals("SAÍDA")) {
                Double saida = Double.parseDouble(valor.replace(",", "."));
                fluxo.setValorEntrada(0.0);
                fluxo.setValorSaida(saida);
                dao.updateSaida(fluxo);
                Double valor1 = Double.parseDouble(jTFluxoDeCaixa.getValueAt(linha, 5).toString().replace(".", "").replace(",", "."));

                listaFluxo();
                totalEntrada();
                totalSaida();
                listaFluxo();
                totalEntrada();
                totalSaida();

                if (saida < valor1) {
                    novoCaixa.soma(valor1 - saida);
                } else {
                    novoCaixa.subtracao(saida - valor1);
                }
                valorEmCaixa();
            }

        } else if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Nenhuma ENTRADA ou SAÍDA selecionada!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbMesActionPerformed

        String mesEscolhido = jCbMes.getSelectedItem().toString();
        int mes;
        int anoAtual = LocalDate.now().getYear();
        FluxoDeCaixaDAO dao = new FluxoDeCaixaDAO();
        if (mesEscolhido.equals("JANEIRO")) {
            mes = 1;
            FluxoMes(mes,anoAtual);
            totalEntrada();
            totalSaida();
        } else if (mesEscolhido.equals("FEVEREIRO")) {
            mes = 2;
            FluxoMes(mes,anoAtual);
            totalEntrada();
            totalSaida();
        } else if (mesEscolhido.equals("MARÇO")) {
            mes = 3;
            FluxoMes(mes,anoAtual);
            totalEntrada();
            totalSaida();
        } else if (mesEscolhido.equals("ABRIL")) {
            mes = 4;
            FluxoMes(mes,anoAtual);
            totalEntrada();
            totalSaida();
        } else if (mesEscolhido.equals("MAIO")) {
            mes = 5;
            FluxoMes(mes,anoAtual);
            totalEntrada();
            totalSaida();
        } else if (mesEscolhido.equals("JUNHO")) {
            mes = 6;
            FluxoMes(mes,anoAtual);
            totalEntrada();
            totalSaida();
        } else if (mesEscolhido.equals("JULHO")) {
            mes = 7;
            FluxoMes(mes,anoAtual);
            totalEntrada();
            totalSaida();
        } else if (mesEscolhido.equals("AGOSTO")) {
            mes = 8;
            FluxoMes(mes,anoAtual);
            totalEntrada();
            totalSaida();
        } else if (mesEscolhido.equals("SETEMBRO")) {
            mes = 9;
            FluxoMes(mes,anoAtual);
            totalEntrada();
            totalSaida();
        } else if (mesEscolhido.equals("OUTUBRO")) {
            mes = 10;
            FluxoMes(mes,anoAtual);
            totalEntrada();
            totalSaida();
        } else if (mesEscolhido.equals("NOVEMBRO")) {
            mes = 11;
            FluxoMes(mes,anoAtual);
            totalEntrada();
            totalSaida();
        } else if (mesEscolhido.equals("DEZEMBRO")) {
            mes = 12;
            int anoPassado = anoAtual -1;
            FluxoMes(mes,anoPassado);
            totalEntrada();
            totalSaida();
        }
    }//GEN-LAST:event_jCbMesActionPerformed

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
                new TelaFinanceiro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCbMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTFluxoDeCaixa;
    private javax.swing.JLabel lblHora;
    private javax.swing.JButton txtNovaEntrada;
    private javax.swing.JButton txtNovaSaida;
    private javax.swing.JTextField txtTotalEntrada;
    private javax.swing.JTextField txtTotalSaida;
    private javax.swing.JTextField txtValorEmCaixa;
    // End of variables declaration//GEN-END:variables
}


package View;

import Estilo.BordaCantoArredondado;
import Model.Carro;
import Model.DAO.CarroDAO;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import Estilo.BotaoRedondo;
import Estilo.TextoMaisculo;
import java.awt.Color;
import java.awt.Toolkit;
import java.time.format.DateTimeFormatter;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author MadaraX4
 */
public class CadastroCarro extends javax.swing.JFrame {

    /**
     * Creates new form CadastroCarro
     */
    public CadastroCarro() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/48x48.png")));
        setLocationRelativeTo(null);

        btnAlterar.setEnabled(false);
        btnDeletar.setEnabled(false);
        txtBorda();
        textoMaiusculo();
    }

    public void txtBorda() {
        BordaCantoArredondado bad = new BordaCantoArredondado(Color.GRAY);

        txtCilindro.setBorder(bad);
        txtCpfProprietario.setBorder(bad);
        txtModelo.setBorder(bad);
        txtMontadora.setBorder(bad);
        txtMotor.setBorder(bad);
        txtPlaca.setBorder(bad);
        txtValvula.setBorder(bad);
        txtCombustivel.setBorder(bad);
        txtAno.setBorder(bad);
        txtCambio.setBorder(bad);
    }

    public void textoMaiusculo() {
        ((AbstractDocument) txtCilindro.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtCpfProprietario.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtModelo.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtMontadora.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtMotor.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtPlaca.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtValvula.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtCombustivel.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtAno.getDocument()).setDocumentFilter(new TextoMaisculo());
        ((AbstractDocument) txtCambio.getDocument()).setDocumentFilter(new TextoMaisculo());

    }

    public void limparCampos() {
        txtCilindro.setText("");
        txtModelo.setText("");
        txtMontadora.setText("");
        txtMotor.setText("");
        txtPlaca.setText("");
        txtValvula.setText("");
        txtCpfProprietario.setText("");
        jblDtAgendada.setText("");
        jblDtManutencao.setText("");
        txtCombustivel.setText("");
        txtAno.setText("");
        txtCambio.setText("");

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
        txtPlaca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCpfProprietario = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMontadora = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMotor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtValvula = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCilindro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCombustivel = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jblDtManutencao = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jblDtAgendada = new javax.swing.JLabel();
        btnCadastrar = new BotaoRedondo();
        btnBuscar = new BotaoRedondo();
        btnAlterar = new BotaoRedondo();
        btnDeletar = new BotaoRedondo();
        btnSair = new BotaoRedondo();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Carros");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Carro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Placa");

        txtPlaca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPlaca.setForeground(new java.awt.Color(0, 0, 0));
        txtPlaca.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CPF ");

        txtCpfProprietario.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtCpfProprietario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpfProprietario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCpfProprietario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("*Digite o cpf de um cliente já cadastrado!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCpfProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtCpfProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 570, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Especificações do Carro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Modelo");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 32, -1, -1));

        txtModelo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(0, 0, 0));
        txtModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 29, 270, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Montadora");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        txtMontadora.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMontadora.setForeground(new java.awt.Color(0, 0, 0));
        txtMontadora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(txtMontadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 131, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Motor");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        txtMotor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMotor.setForeground(new java.awt.Color(0, 0, 0));
        txtMotor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(txtMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 87, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Válvulas");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));

        txtValvula.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtValvula.setForeground(new java.awt.Color(0, 0, 0));
        txtValvula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtValvula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValvulaActionPerformed(evt);
            }
        });
        jPanel3.add(txtValvula, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 42, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Cilindros");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        txtCilindro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCilindro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(txtCilindro, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 44, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Combustivel");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        txtCombustivel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel3.add(txtCombustivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 122, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Ano");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        txtAno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel3.add(txtAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 86, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Cambio");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

        txtCambio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel3.add(txtCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 230, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 600, 150));

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manutenções", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Última Manutenção");

        jblDtManutencao.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jblDtManutencao.setForeground(new java.awt.Color(255, 0, 0));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Manutenção Agendada");

        jblDtAgendada.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jblDtAgendada.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jblDtManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jblDtAgendada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jblDtManutencao, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(jblDtAgendada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 600, -1));

        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus4274912.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 143, 46));

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/searching_4274998.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 143, 48));

        btnAlterar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gear_4274909.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 143, 48));

        btnDeletar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minus_4274919 (1).png"))); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 143, 49));

        btnSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/previous_left_document_page_16679.png"))); // NOI18N
        btnSair.setText("Fechar");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 143, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        Carro carro = new Carro();
        CarroDAO dao = new CarroDAO();

        carro.setPlaca(txtPlaca.getText());
        carro.setCpf_proprietario(txtCpfProprietario.getText());
        carro.setModelo(txtModelo.getText());
        carro.setMontadora(txtMontadora.getText());
        carro.setMotor(txtMotor.getText());
        carro.setNum_cilindros(Integer.parseInt(txtCilindro.getText()));
        carro.setNum_valvulas(Integer.parseInt(txtValvula.getText()));
        carro.setCobustivel(txtCombustivel.getText());
        carro.setAno(Integer.parseInt(txtAno.getText()));
        carro.setCambio(txtCambio.getText());
        
        dao.create(carro);
        limparCampos();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtValvulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValvulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValvulaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String placa = txtPlaca.getText().trim();

        boolean validacao = placa.isEmpty();
        CarroDAO dao = new CarroDAO();

        if (validacao == false) {
            Carro carro = dao.select(placa);

            if (carro.getData_manutencao() != null && carro.getManutencao_agendada() == null) {
                DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                txtCpfProprietario.setText(carro.getCpf_proprietario());
                txtModelo.setText(carro.getModelo());
                txtMontadora.setText(carro.getMontadora());
                txtMotor.setText(carro.getMotor());
                txtValvula.setText(Integer.toString(carro.getNum_valvulas()));
                txtCilindro.setText(Integer.toString(carro.getNum_cilindros()));
                //jblDtAgendada.setText(agendaFormatada);
                jblDtManutencao.setText(formater.format(carro.getData_manutencao()));
                txtCombustivel.setText(carro.getCobustivel());
                txtAno.setText(Integer.toString(carro.getAno()));
                txtCambio.setText(carro.getCambio());
                txtPlaca.setEditable(false);

                btnCadastrar.setEnabled(false);
                btnAlterar.setEnabled(true);
                btnDeletar.setEnabled(true);
                txtPlaca.setEditable(false);
                btnBuscar.setEnabled(false);

            } else if (carro.getData_manutencao() != null && carro.getManutencao_agendada() != null) {
                DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                txtCpfProprietario.setText(carro.getCpf_proprietario());
                txtModelo.setText(carro.getModelo());
                txtMontadora.setText(carro.getMontadora());
                txtMotor.setText(carro.getMotor());
                txtValvula.setText(Integer.toString(carro.getNum_valvulas()));
                txtCilindro.setText(Integer.toString(carro.getNum_cilindros()));
                jblDtAgendada.setText(formater.format(carro.getManutencao_agendada()));
                jblDtManutencao.setText(formater.format(carro.getData_manutencao()));
                txtCombustivel.setText(carro.getCobustivel());
                txtAno.setText(Integer.toString(carro.getAno()));
                txtCambio.setText(carro.getCambio());
                txtPlaca.setEditable(false);

                btnCadastrar.setEnabled(false);
                btnAlterar.setEnabled(true);
                btnDeletar.setEnabled(true);
                txtPlaca.setEditable(false);
                btnBuscar.setEnabled(false);
            } else {

                txtCpfProprietario.setText(carro.getCpf_proprietario());
                txtModelo.setText(carro.getModelo());
                txtMontadora.setText(carro.getMontadora());
                txtMotor.setText(carro.getMotor());
                txtValvula.setText(Integer.toString(carro.getNum_valvulas()));
                txtCilindro.setText(Integer.toString(carro.getNum_cilindros()));
                txtCombustivel.setText(carro.getCobustivel());
                txtAno.setText(Integer.toString(carro.getAno()));
                txtCambio.setText(carro.getCambio());
                jblDtAgendada.setText("");
                jblDtManutencao.setText("");

                //Habilitando botões na tela!
                btnCadastrar.setEnabled(false);
                btnAlterar.setEnabled(true);
                btnDeletar.setEnabled(true);
                txtPlaca.setEditable(false);
                btnBuscar.setEnabled(false);
            }

        } else {
            JOptionPane.showMessageDialog(null, "<html><p>Campo Placa Vazio!</p></html>");

        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        Carro carro = new Carro();
        CarroDAO dao = new CarroDAO();
        String placa = txtPlaca.getText().trim();
        boolean validacao = placa.isEmpty();

        carro.setPlaca(txtPlaca.getText());
        carro.setModelo(txtModelo.getText());
        carro.setMontadora(txtMontadora.getText());
        carro.setMotor(txtMotor.getText());
        carro.setNum_valvulas(Integer.parseInt(txtValvula.getText()));
        carro.setNum_cilindros(Integer.parseInt(txtCilindro.getText()));
        carro.setCobustivel(txtCombustivel.getText());
        carro.setAno(Integer.parseInt(txtAno.getText()));
        carro.setCambio(txtCambio.getText());

        int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja Alterar este carro?", "Confirmação!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (validacao == false) {
            if (confirmacao == JOptionPane.YES_OPTION) {
                dao.update(carro);
                JOptionPane.showMessageDialog(null, "<html><p>Carro alterado com sucesso!</p></html>");
                limparCampos();
                btnAlterar.setEnabled(false);
                btnDeletar.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "<html><p>Operação Cancelada!</p></html>");
            }
        } else {
            JOptionPane.showMessageDialog(null, "<html><p>Campo placa está em branco!</p></html>");
        }

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // TODO add your handling code here:
        String placa = txtPlaca.getText().trim();
        boolean validacao = placa.isEmpty();

        int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja deletar este Carro?", "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        CarroDAO dao = new CarroDAO();

        if (validacao == false) {
            if (confirmacao == JOptionPane.YES_OPTION) {
                dao.delete(placa);
                limparCampos();
                btnAlterar.setEnabled(false);
                btnDeletar.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "<html><p>Operação cancelada!</p></html>");
            }
        } else {
            JOptionPane.showMessageDialog(null, "<html><p>Campo placa está vazio!</p></html>");
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

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
                new CadastroCarro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jblDtAgendada;
    private javax.swing.JLabel jblDtManutencao;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtCilindro;
    private javax.swing.JTextField txtCombustivel;
    private javax.swing.JFormattedTextField txtCpfProprietario;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtMontadora;
    private javax.swing.JTextField txtMotor;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtValvula;
    // End of variables declaration//GEN-END:variables
}

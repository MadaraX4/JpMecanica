package Model.DAO;

import ConnectionFactory.ConexaoBanco;
import Model.Conta;
import Model.ContaTableModel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ContaDAO {

    public void create(Conta conta) {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("INSERT INTO conta (referencia,tipo,valor,data_vencimento,estatus) VALUES(?,?,?,?,)");
            stmt.setString(1, conta.getReferencia());
            stmt.setString(2, conta.getTipo());
            stmt.setDouble(3, conta.getValor());
            stmt.setDate(4, (Date) conta.getData_vencimento());
            stmt.setString(5, conta.getEstatus());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar conta!\n" + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }

    }

    public List<Conta> read() {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Conta> contas = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM conta ORDER BY ABS(DATEDIFF(data_vencimento, CURRENT_DATE))");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Conta conta = new Conta();
                ContaTableModel modelo = new ContaTableModel();

                if (rs.getDate("data_pagamento") != null) {

                    double valor = rs.getDouble("valor");
                    BigDecimal bigDecimal = new BigDecimal(valor).setScale(2, RoundingMode.HALF_UP);
                    double valorFormatado = bigDecimal.doubleValue();

                    Date vencimentoSql = rs.getDate("data_vencimento");
                    LocalDate vencimento = vencimentoSql.toLocalDate();

                    Date pagamentoSql = rs.getDate("data_pagamento");
                    LocalDate pagamento = pagamentoSql.toLocalDate();

                    conta.setId(rs.getInt("id"));
                    conta.setReferencia(rs.getString("referencia"));
                    conta.setTipo(rs.getString("tipo"));
                    conta.setValor(valorFormatado);
                    conta.setData_vencimento(rs.getDate("data_vencimento"));
                    conta.setEstatus(rs.getString("estatus"));
                    conta.setData_pagamento(rs.getDate("data_pagamento"));
                    conta.setValorPago(rs.getDouble("valorPago"));

                    contas.add(conta);
                } else {
                    double valor = rs.getDouble("valor");
                    BigDecimal bigDecimal = new BigDecimal(valor).setScale(2, RoundingMode.HALF_UP);
                    double valorFormatado = bigDecimal.doubleValue();

                    Date vencimentoSql = rs.getDate("data_vencimento");
                    LocalDate vencimento = vencimentoSql.toLocalDate();

                    conta.setId(rs.getInt("id"));
                    conta.setReferencia(rs.getString("referencia"));
                    conta.setTipo(rs.getString("tipo"));
                    conta.setValor(valorFormatado);
                    conta.setData_vencimento(rs.getDate("data_vencimento"));
                    conta.setEstatus(rs.getString("estatus"));
                    conta.setValorPago(rs.getDouble("valorPago"));

                    contas.add(conta);
                }
                modelo.setContas(contas);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }

        return contas;
    }

    public void update(Conta conta) {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE conta SET referencia =?,data_vencimento=?,tipo=?,valor=? WHERE id=?");
            stmt.setString(1, conta.getReferencia());
            stmt.setDate(2, (Date) conta.getData_vencimento());
            stmt.setString(3, conta.getTipo());
            stmt.setDouble(4, conta.getValor());
            stmt.setInt(5, conta.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar conta!\n" + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }

    }

    public void delete(String id) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM conta WHERE id=?");
            stmt.setString(1, id);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir conta!\n" + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }
    }

    public void updatePagamento(Conta conta) {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE conta SET data_pagamento =?,estatus=?,valorPago=? WHERE id=?");
            stmt.setDate(1, (Date) conta.getData_pagamento());
            stmt.setString(2, conta.getEstatus());
            stmt.setDouble(3, conta.getValorPago());
            stmt.setInt(4, conta.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO!" + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }

    }

    private void modificarEstatusConta(int idConta, String novoEstatus) {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE conta SET estatus=? WHERE id=?");
            stmt.setString(1, novoEstatus);
            stmt.setInt(2, idConta);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void atualizarEstatusContasAtrasadas() {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        java.sql.Date dataAtual = new java.sql.Date(System.currentTimeMillis());

        try {
            stmt = con.prepareStatement("SELECT id FROM conta WHERE data_vencimento=?");
            stmt.setDate(1, dataAtual);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                modificarEstatusConta(id, "ATRASADO");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<String> verificaConta() {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<String> lista = new ArrayList<>();

        LocalDate dataAtual = LocalDate.now();
//        int diaAtual = dataAtual.getDayOfMonth();
//        int mesAtual = dataAtual.getMonthValue();
//        int diaProximo = diaAtual + 5;

        boolean temConta = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM conta");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Conta conta = new Conta();
                conta.setReferencia(rs.getString("referencia"));
                conta.setValor(rs.getDouble("valor"));
                conta.setData_vencimento(rs.getDate("data_vencimento"));
                Date data = rs.getDate("data_vencimento");
                
              

                if (data != null) {
                     LocalDate vencimento = data.toLocalDate();


                    if (vencimento.isAfter(dataAtual) && vencimento.isBefore(dataAtual.plusDays(5))) {
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        String aviso = "A Conta " + conta.getReferencia() + " irá se Vencer em Alguns Dias Com Valor de R$" + conta.getValor() + " Vencimento " + formato.format(conta.getData_vencimento());
                        String espaco = "----------------------------------------------------------------*----------------------------------------------------------------";
                        temConta = true;
                        lista.add(aviso + "\n" + espaco);

                    } else if (vencimento.equals(dataAtual)) {
                        String aviso = "A Conta " + conta.getReferencia() + " Venceu Hoje Com Valor de R$" + conta.getValor();
                        String espaco = "----------------------------------------------------------------*----------------------------------------------------------------";
                        temConta = true;
                        lista.add(aviso + "\n" + espaco);

                    }
                }
            }
            if (!temConta) {
                String aviso = "Sem Contas Próximas ou Vencendo";
                lista.add(aviso);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }

        return lista;
    }

}

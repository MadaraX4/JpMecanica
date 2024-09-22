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
import java.time.LocalDate;
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
            stmt = con.prepareStatement("INSERT INTO conta (referencia,tipo,valor,data_vencimento,estatus) VALUES(?,?,?,?,?)");
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

}

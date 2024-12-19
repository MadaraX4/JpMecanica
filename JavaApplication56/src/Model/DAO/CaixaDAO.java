package Model.DAO;

import ConnectionFactory.ConexaoBanco;
import Model.Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class CaixaDAO {

    public void create(Double caixa) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO caixa(valorEmCaixa) VALUES(?)");
            stmt.setDouble(1, caixa);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Valor Em Caixa adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            JOptionPane.showMessageDialog(null, "Erro ao adicionar Valor Em Caixa!");
        }
    }

    public boolean verificaCaixa() {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT COUNT(*) FROM caixa WHERE valorEmCaixa IS NULL");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Double valor = rs.getDouble(1);

                return valor > 0;
            }
        } catch (Exception e) {
            System.out.println("Erro:" + e);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return false;

    }

    public Double select() {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Double valor = 0.0;

        try {
            stmt = con.prepareStatement("SELECT valorEmCaixa FROM caixa");
            rs = stmt.executeQuery();

            if (rs.next()) {
                valor = rs.getDouble("valorEmCaixa");
            }
        } catch (Exception e) {
            System.out.println("Erro:" + e);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return valor;
    }

    public void soma(Double valorSoma) {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        
       
        try {
         stmt = con.prepareStatement("UPDATE caixa SET valorEmCaixa = valorEmCaixa + ?");
         stmt.setDouble(1,valorSoma);
         stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERRO:" + e);
        }finally{
            ConexaoBanco.closeConnection(con, stmt);
        }

    }
    public void subtracao(Double valorSubtracao) {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        
       
        try {
         stmt = con.prepareStatement("UPDATE caixa SET valorEmCaixa = valorEmCaixa - ?");
         stmt.setDouble(1,valorSubtracao);
         stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERRO:" + e);
        }finally{
            ConexaoBanco.closeConnection(con, stmt);
        }
    }
}

package Model.DAO;

import ConnectionFactory.ConexaoBanco;
import Model.OsServicos;
import Model.Servico;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Os_ServicoDAO {

    public void create(int os_id, List<OsServicos> servicos) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO os_servicos (os_id,servico_id) VALUES (?,?)");
            for (OsServicos servico : servicos) {
                stmt.setInt(1, os_id);
                stmt.setInt(2, servico.getServico_id());
                //stmt.addBatch();
                stmt.executeUpdate();
            }

            //stmt.executeBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }
    }

    public List<Servico> lista(int osId) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Servico> listaServico = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT os_servicos.servico_id,servicos.nome,servicos.preco FROM os_servicos INNER JOIN servicos"
                    + " on os_servicos.servico_id = servicos.id WHERE os_servicos.os_id=?");
            stmt.setInt(1, osId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Servico servicos = new Servico();
                servicos.setId(rs.getInt("servico_id"));
                servicos.setNome(rs.getString("nome"));
                servicos.setPreco(rs.getDouble("preco"));
                listaServico.add(servicos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Serviços não encontrados!");
            ex.printStackTrace();
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return listaServico;
    }

    public List<Servico> pdfLista(int osId) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Servico> lista = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT os_servicos.servico_id,servicos.nome,servicos.preco FROM os_servicos INNER JOIN servicos "
                    + "ON os_servicos.servico_id = servicos.id WHERE os_servicos.os_id=?");
            stmt.setInt(1, osId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Servico servicos = new Servico();
                servicos.setNome(rs.getString("nome"));
                servicos.setPreco(rs.getDouble("preco"));
                lista.add(servicos);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return lista;
    }
}

package Model.DAO;

import ConnectionFactory.ConexaoBanco;
import Model.ListaServicos;
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
            stmt = con.prepareStatement("INSERT INTO os_servicos (os_id,descricao,valor) VALUES (?,?,?)");
            for (OsServicos servico : servicos) {
                stmt.setInt(1, os_id);
                stmt.setString(2, servico.getDescricao());
                stmt.setDouble(3, servico.getValor());
                stmt.executeUpdate();
            }

            //stmt.executeBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }
    }

    public List<ListaServicos> lista(int osId) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ListaServicos> servicos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT descricao,valor FROM os_servicos WHERE os_id=?");

            stmt.setInt(1, osId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ListaServicos lista = new ListaServicos();
                lista.setDescricao(rs.getString("descricao"));
                lista.setValor(rs.getDouble("valor"));
                servicos.add(lista);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Serviços não encontrados!");
            ex.printStackTrace();
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return servicos;
    }

    public List<ListaServicos> pdfLista(int osId) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ListaServicos> servicos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT descricao,valor FROM os_servicos WHERE os_id=?");
            stmt.setInt(1, osId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ListaServicos lista = new ListaServicos();
                lista.setDescricao(rs.getString("descricao"));
                lista.setValor(rs.getDouble("valor"));
                servicos.add(lista);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return servicos;
    }

    public void deletar(int osId) {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt=con.prepareStatement("DELETE FROM os_servicos WHERE os_id=?");
            stmt.setInt(1, osId);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERRO:" + ex);
        }
    }
}

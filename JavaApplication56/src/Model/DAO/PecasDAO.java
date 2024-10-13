package Model.DAO;

import ConnectionFactory.ConexaoBanco;
import Model.Pecas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PecasDAO {

    public void create(Pecas peca) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("INSERT INTO pecas(cod_identificacao,nome,carro,referencia,quantidade,preco_compra,preco_venda,fornecedor) VALUES(?,?,?,?,?,?,?,?)");
            stmt.setInt(1, peca.getCod_identificacao());
            stmt.setString(2, peca.getNome());
            stmt.setString(3, peca.getCarro());
            stmt.setString(4, peca.getReferencia());
            stmt.setInt(5, peca.getQuantidade());
            stmt.setDouble(6, peca.getPreco_compra());
            stmt.setDouble(7, peca.getPreco_venda());
            stmt.setString(8, peca.getFornecedor());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar peça!\n" + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }
    }

    public Pecas select(String cod_identificacao) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Pecas peca = new Pecas();
        try {
            stmt = con.prepareStatement("SELECT id,nome,carro,referencia,quantidade,preco_compra,preco_venda,fornecedor FROM pecas WHERE cod_identificacao=?");
            stmt.setString(1, cod_identificacao);

            rs = stmt.executeQuery();

            while (rs.next()) {
                peca.setId(rs.getInt("id"));
                peca.setNome(rs.getString("nome"));
                peca.setCarro(rs.getString("carro"));
                peca.setReferencia(rs.getString("referencia"));
                peca.setQuantidade(rs.getInt("quantidade"));
                peca.setPreco_compra(rs.getDouble("preco_compra"));
                peca.setPreco_venda(rs.getDouble("preco_venda"));
                peca.setFornecedor(rs.getString("fornecedor"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Peça não encontra\n" + "Ou não cadastrada!\n" + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);

        }

        return peca;
    }

    public void update(Pecas peca) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("UPDATE pecas SET nome=?, carro=?, referencia=?, quantidade=?, preco_compra=?, preco_venda=?, fornecedor=? WHERE cod_identificacao=?");
            stmt.setString(1, peca.getNome());
            stmt.setString(2, peca.getCarro());
            stmt.setString(3, peca.getReferencia());
            stmt.setInt(4, peca.getQuantidade());
            stmt.setDouble(5, peca.getPreco_compra());
            stmt.setDouble(6, peca.getPreco_venda());
            stmt.setString(7, peca.getFornecedor());
            stmt.setInt(8, peca.getCod_identificacao());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar peça!\n" + ex);
        } finally {

            ConexaoBanco.closeConnection(con, stmt);
        }
    }

    public boolean delete(String cod_identificacao) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM pecas WHERE cod_identificacao=?");
            stmt.setString(1, cod_identificacao);

            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!\n" + ex);
            return false;
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }
    }

    public List<String> listaNome(String nome) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<String> listaNomes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM pecas WHERE nome LIKE ? ORDER BY nome");
            stmt.setString(1, nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
               
               listaNomes.add(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }

        return listaNomes;
    }
    
    public List<Pecas> listaPecas(String nome){
     
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
    
        List<Pecas> listaPecas = new ArrayList<>();
        
        try {
            stmt=con.prepareStatement("SELECT * FROM pecas WHERE nome=?");
            stmt.setString(1, nome);
            rs=stmt.executeQuery();
            
            while (rs.next()) {                
                Pecas pecas = new Pecas();
                pecas.setId(rs.getInt("id"));
                pecas.setCod_identificacao(rs.getInt("cod_identificacao"));
                pecas.setNome(rs.getString("nome"));
                pecas.setCarro(rs.getString("carro"));
                pecas.setReferencia(rs.getString("referencia"));
                pecas.setQuantidade(rs.getInt("quantidade"));
                pecas.setPreco_venda(rs.getDouble("preco_venda"));
                listaPecas.add(pecas);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
        ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return listaPecas;
    }

}

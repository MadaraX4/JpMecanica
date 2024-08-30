package Model.DAO;

import ConnectionFactory.ConexaoBanco;
import Model.Pecas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PecasDAO {
    
    Connection con = ConexaoBanco.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    public void create(Pecas peca) {
        
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
    
}

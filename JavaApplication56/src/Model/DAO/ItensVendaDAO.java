package Model.DAO;

import ConnectionFactory.ConexaoBanco;
import Model.ItensVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItensVendaDAO {

    public void salvarItens(int id_venda, List<ItensVenda> itensVenda) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt=con.prepareStatement("INSERT INTO itensvenda (id_venda,id_pecas,quantidade) VALUES (?,?,?)");
            
            for (ItensVenda itens : itensVenda) {
                stmt.setInt(1, id_venda);
                stmt.setInt(2, itens.getId_pecas());
                stmt.setInt(3, itens.getQuantidade());
                stmt.executeUpdate();
            }
            
        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex);
        }finally{
        ConexaoBanco.closeConnection(con, stmt);
        }
    }
}

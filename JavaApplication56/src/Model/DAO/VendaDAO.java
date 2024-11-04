package Model.DAO;

import ConnectionFactory.ConexaoBanco;
import Model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaDAO {

    public int salvarVenda(Venda venda) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "INSERT INTO venda (data_da_venda,hora_da_venda,qtdItens,valor,dinheiro) VALUES (?,?,?,?,?)";

        int id_venda = 0;
        try {
            java.sql.Date dataSql = java.sql.Date.valueOf(venda.getData());
            java.sql.Time horaSql = java.sql.Time.valueOf(venda.getHora());
            stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setDate(1, dataSql);
            stmt.setTime(2, horaSql);
            stmt.setInt(3, venda.getQtdItens());
            stmt.setDouble(4, venda.getValor());
            stmt.setDouble(5, venda.getDinheiro());
            stmt.executeUpdate();

            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id_venda = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }

        return id_venda;
    }

    public List<Venda> listaVenda() {
        
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Venda> vendas = new ArrayList<>();
        
        try {
            stmt=con.prepareStatement("SELECT id,valor,qtdItens,hora_da_venda,dinheiro FROM venda WHERE Date (data_da_venda) = CURRENT_DATE");
            rs=stmt.executeQuery();
            
            while (rs.next()) {                
                Venda venda = new Venda();
                venda.setId(rs.getInt("id"));
                venda.setValor(rs.getDouble("valor"));
                venda.setQtdItens(rs.getInt("qtdItens"));
                venda.setHora(rs.getTime("hora_da_venda").toLocalTime());
                venda.setDinheiro(rs.getDouble("dinheiro"));
                
                vendas.add(venda);
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }finally{
        ConexaoBanco.closeConnection(con, stmt, rs);
        }

        return vendas;
    }

}

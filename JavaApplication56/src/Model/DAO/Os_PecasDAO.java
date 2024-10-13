/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.OsPecas;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import ConnectionFactory.ConexaoBanco;
import Model.ListaPecas;
import Model.Pecas;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Os_PecasDAO {
    
    public void create(int os_id, List<OsPecas> pecasOs) {
        
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO os_pecas (os_id,id_pecas,quantidade) VALUES (?,?,?)");
            
            for (OsPecas peca : pecasOs) {
                stmt.setInt(1, os_id);
                stmt.setInt(2, peca.getId_pecas());
                stmt.setInt(3, peca.getQuantidade());
                stmt.executeUpdate();
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }
    }
    
    public List<ListaPecas> lista(int osId) {
        
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<ListaPecas> listaPecas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT os_pecas.id_pecas,pecas.nome,pecas.preco_venda,os_pecas.quantidade FROM os_pecas "
                    + "INNER JOIN pecas ON os_pecas.id_pecas=pecas.id WHERE os_pecas.os_id=?");
            stmt.setInt(1, osId);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Pecas peca = new Pecas();
                ListaPecas lista = new ListaPecas();
                peca.setId(rs.getInt("id_pecas"));
                peca.setNome(rs.getString("nome"));
                peca.setPreco_venda(rs.getDouble("preco_venda"));
                lista.setPeca(peca);
                lista.setQuantidade(rs.getInt("quantidade"));
                listaPecas.add(lista);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Peças não encontradadas!" + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return listaPecas;
    }
}

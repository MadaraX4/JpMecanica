/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import ConnectionFactory.ConexaoBanco;
import Model.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ServicoDAO {

    public void create(Servico servico) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO servicos (nome,preco) values (?,?)");
            stmt.setString(1, servico.getNome());
            stmt.setDouble(2, servico.getPreco());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Serviço!\n" + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }

    }

    public List<String> listaNomes(String nome) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<String> nomesServicos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM servicos WHERE nome LIKE ? ORDER BY nome");
            stmt.setString(1, nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                nomesServicos.add(rs.getString("nome") + " R$ " + rs.getDouble("preco"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return nomesServicos;
    }

    public List<Servico> listaServicos(String nome) {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Servico> servicos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM servicos WHERE nome=?");
            stmt.setString(1, nome);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Servico servico = new Servico();
                servico.setId(rs.getInt("id"));
                servico.setNome(rs.getString("nome"));
                servico.setPreco(rs.getDouble("preco"));
                servicos.add(servico);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return servicos;
    }

    public int verificaId(int id) {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int id_servico=0;
        try {
            stmt=con.prepareStatement("SELECT * FROM servicos WHERE id=?");
            stmt.setInt(1, id);
            rs=stmt.executeQuery();
            
            if(rs.next()){
            id_servico= rs.getInt("id");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Serviço não encontrado"+ex);
        }finally{
        ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return id_servico;
    }
}

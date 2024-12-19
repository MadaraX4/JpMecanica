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
            stmt = con.prepareStatement("INSERT INTO os_pecas (os_id,descricao,quantidade,valor) VALUES (?,?,?,?)");

            for (OsPecas pecas : pecasOs) {
                stmt.setInt(1, os_id);
                stmt.setString(2, pecas.getDescricao());
                stmt.setInt(3, pecas.getQuantidade());
                stmt.setDouble(4, pecas.getValor());
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
            stmt = con.prepareStatement("SELECT os_pecas.descricao,os_pecas.quantidade,os_pecas.valor FROM os_pecas WHERE os_id=?");

            stmt.setInt(1, osId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ListaPecas lista = new ListaPecas();
                lista.setDescricao(rs.getString("descricao"));
                lista.setQuantidade(rs.getInt("quantidade"));
                lista.setValor(rs.getDouble("valor"));
                listaPecas.add(lista);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Peças não encontradadas!" + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return listaPecas;
    }

    public List<ListaPecas> pdfOs_pecas(int osId) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ListaPecas> listaPecas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT os_pecas.descricao,os_pecas.quantidade,os_pecas.valor FROM os_pecas WHERE os_id=?");
            stmt.setInt(1, osId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ListaPecas lista = new ListaPecas();
                lista.setDescricao(rs.getString("descricao"));
                lista.setQuantidade(rs.getInt("quantidade"));
                lista.setValor(rs.getDouble("valor"));
                listaPecas.add(lista);
            }
        } catch (SQLException ex) {
            System.out.println("erro: " + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }

        return listaPecas;
    }

    public void deletar(int osId) {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM os_pecas WHERE os_id=?");
            stmt.setInt(1, osId);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERRO:" + ex);
        }

    }
}

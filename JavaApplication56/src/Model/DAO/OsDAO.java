package Model.DAO;

import ConnectionFactory.ConexaoBanco;
import Model.Os;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class OsDAO {

    public int salvarOs(Os os) {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "INSERT INTO os (clienteNome,telefone,placaVeiculo,montadora,modelo,dataDaOrdem,valor,tecnico,descricao,estatus) VALUES (?,?,?,?,?,?,?,?,?,?)";

        int id_os = 0;

        try {

            java.sql.Date dataSql = new java.sql.Date(os.getDataOrdem().getTime());

            stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, os.getClienteNome());
            stmt.setString(2, os.getTelefone());
            stmt.setString(3, os.getPlacaVeiculo());
            stmt.setString(4, os.getMontadora());
            stmt.setString(5, os.getModelo());
            stmt.setDate(6, dataSql);
            stmt.setDouble(7, os.getValor());
            stmt.setString(8, os.getTecnico());
            stmt.setString(9, os.getDescricao());
            stmt.setString(10, os.getStatus());
            stmt.executeUpdate();

            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id_os = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return id_os;
    }

    public Os Select(int id) {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Os os = new Os();

        try {
            stmt = con.prepareStatement("SELECT * FROM os WHERE id=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                os.setId(rs.getInt("id"));
                os.setClienteNome(rs.getString("clienteNome"));
                os.setDataOrdem(rs.getDate("dataDaOrdem"));
                os.setDescricao(rs.getString("descricao"));
                os.setModelo(rs.getString("modelo"));
                os.setMontadora(rs.getString("montadora"));
                os.setPlacaVeiculo(rs.getString("placaVeiculo"));
                os.setStatus(rs.getString("estatus"));
                os.setTecnico(rs.getString("tecnico"));
                os.setTelefone(rs.getString("telefone"));
                os.setValor(rs.getDouble("valor"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Os não encontrada!\n" + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return os;
    }

    public void atualizarEstatus(Os os) {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        
        java.sql.Date dataMysql = new java.sql.Date(os.getDataAprovação().getTime());
        
        try {
            stmt= con.prepareStatement("UPDATE os SET estatus=?,data_aprovacao=? WHERE id=?");
            stmt.setString(1,os.getStatus());
            stmt.setDate(2, dataMysql);
            stmt.setInt(3, os.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atulizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro a atualizar estatus\n" + ex);
        }

    }
}
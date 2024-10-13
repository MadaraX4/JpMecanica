/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import ConnectionFactory.ConexaoBanco;
import Model.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MadaraX4
 */
public class CarroDAO {

    Connection con = ConexaoBanco.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public void create(Carro carro) {
        try {
            stmt = con.prepareStatement("INSERT INTO carro(placa,modelo,montadora,motor,num_valvulas,num_cilindros,proprietario) VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, carro.getPlaca());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getMontadora());
            stmt.setString(4, carro.getMotor());
            stmt.setInt(5, carro.getNum_valvulas());
            stmt.setInt(6, carro.getNum_cilindros());
            stmt.setString(7, carro.getCpf_proprietario());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Carro cadastrado com Sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar ou falha na conexão\n" + ex);

        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }
    }

    public Carro select(String placa) {

        Carro carro = new Carro();

        try {
            stmt = con.prepareStatement("SELECT proprietario,modelo,montadora,motor,num_valvulas,num_cilindros,data_manutencao,proprietario,manutencao_agendada FROM carro WHERE placa=?");
            stmt.setString(1, placa);

            rs = stmt.executeQuery();

            while (rs.next()) {
                carro.setCpf_proprietario(rs.getString("proprietario"));
                carro.setModelo(rs.getString("modelo"));
                carro.setMontadora(rs.getString("montadora"));
                carro.setMotor(rs.getString("motor"));
                carro.setNum_valvulas(rs.getInt("num_valvulas"));
                carro.setNum_cilindros(rs.getInt("num_cilindros"));
                carro.setData_manutencao(rs.getDate("data_manutencao"));
                carro.setManutencao_agendada(rs.getDate("manutencao_agendada"));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Carro Não encontrado!\n" + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return carro;

    }

    public void update(Carro carro) {

        try {
            stmt = con.prepareStatement("UPDATE carro SET modelo=?,montadora=?,motor=?,num_valvulas=?,num_cilindros=? WHERE placa=?");
            stmt.setString(1, carro.getModelo());
            stmt.setString(2, carro.getMontadora());
            stmt.setString(3, carro.getMotor());
            stmt.setInt(4, carro.getNum_valvulas());
            stmt.setInt(5, carro.getNum_cilindros());
            stmt.setString(6, carro.getPlaca());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar carro?\n" + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }

    }

    public boolean delete(String placa) {
        try {
            stmt = con.prepareStatement("DELETE FROM carros WHERE placa=?");
            stmt.setString(1, placa);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar carro!\n" + ex);
            return false;
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }
    }

    public List<String> listaPlaca(String placa) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<String> placas = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM carro WHERE placa LIKE ? ORDER BY placa");
            stmt.setString(1, placa + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                placas.add(rs.getString("placa"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Placa não encontrada!\n" + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }

        return placas;
    }

    public List<Carro> pesquisa(String placa) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Carro> carros = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM carro WHERE placa LIKE ?");
            stmt.setString(1, placa + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Carro carro = new Carro();
                carro.setPlaca(rs.getString("placa"));
                carro.setCpf_proprietario(rs.getString("proprietario"));
                carro.setMontadora(rs.getString("montadora"));
                carro.setModelo(rs.getString("modelo"));
                carros.add(carro);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }

        return carros;
    }

}

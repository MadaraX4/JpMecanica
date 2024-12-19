package Model.DAO;

import ConnectionFactory.ConexaoBanco;
import Model.FluxoDeCaixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FluxoDeCaixaDAO {

    public void inserir(FluxoDeCaixa fluxo) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            java.sql.Date data = java.sql.Date.valueOf(fluxo.getDataOperacao());
            java.sql.Time hora = java.sql.Time.valueOf(fluxo.getHoraOperacao());
            stmt = con.prepareStatement("INSERT INTO fluxodecaixa(descricao,tipo,dataOperacao,horaOperacao,valorEntrada,valorSaida) VALUES(?,?,?,?,?,?)");
            stmt.setString(1, fluxo.getDescricao());
            stmt.setString(2, fluxo.getTipo());
            stmt.setDate(3, data);
            stmt.setTime(4, hora);
            stmt.setDouble(5, fluxo.getValorEntrada());
            stmt.setDouble(6, fluxo.getValorSaida());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERRO:" + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }
    }

    public List<FluxoDeCaixa> listaFluxo() {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<FluxoDeCaixa> lista = new ArrayList<>();

        LocalDate dataAtual = LocalDate.now();
        int mesAtual = dataAtual.getMonthValue();
        int anoAtual = dataAtual.getYear();

        try {
            stmt = con.prepareStatement("SELECT * FROM fluxodecaixa");
            rs = stmt.executeQuery();

            while (rs.next()) {
                FluxoDeCaixa fluxo = new FluxoDeCaixa();
                fluxo.setDescricao(rs.getString("descricao"));
                fluxo.setTipo(rs.getString("tipo"));
                fluxo.setDataOperacao(rs.getDate("dataOperacao").toLocalDate());
                fluxo.setHoraOperacao(rs.getTime("horaOperacao").toLocalTime());
                fluxo.setValorEntrada(rs.getDouble("valorEntrada"));
                fluxo.setValorSaida(rs.getDouble("valorSaida"));

                LocalDate dataOp = rs.getDate("dataOperacao").toLocalDate();

                if (dataOp.getMonthValue() == mesAtual && dataOp.getYear() == anoAtual) {
                    lista.add(fluxo);
                }
            }
        } catch (SQLException ex) {
            System.out.println("ERRO:" + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return lista;
    }
    public List<FluxoDeCaixa> fluxoPorMes(int mes, int ano) {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<FluxoDeCaixa> lista = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM fluxodecaixa");
            rs = stmt.executeQuery();

            while (rs.next()) {
                FluxoDeCaixa fluxo = new FluxoDeCaixa();
                fluxo.setDescricao(rs.getString("descricao"));
                fluxo.setTipo(rs.getString("tipo"));
                fluxo.setDataOperacao(rs.getDate("dataOperacao").toLocalDate());
                fluxo.setHoraOperacao(rs.getTime("horaOperacao").toLocalTime());
                fluxo.setValorEntrada(rs.getDouble("valorEntrada"));
                fluxo.setValorSaida(rs.getDouble("valorSaida"));

                LocalDate dataOp = rs.getDate("dataOperacao").toLocalDate();

                if (dataOp.getMonthValue() == mes && dataOp.getYear() == ano) {
                    lista.add(fluxo);
                }
            }
        } catch (SQLException ex) {
            System.out.println("ERRO:" + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return lista;
    }

    public void updateEntrada(FluxoDeCaixa entrada) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE fluxodecaixa set valorEntrada=? WHERE horaOperacao=? AND dataOperacao=?");
            stmt.setDouble(1, entrada.getValorEntrada());
            java.sql.Time horaOperacao = java.sql.Time.valueOf(entrada.getHoraOperacao());
            java.sql.Date dataOperacao = java.sql.Date.valueOf(entrada.getDataOperacao());
            stmt.setTime(2, horaOperacao);
            stmt.setDate(3, dataOperacao);
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Entrada Alterada com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro:" + e);
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }
    }

    public void updateSaida(FluxoDeCaixa saida) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE fluxodecaixa set valorSaida=? WHERE horaOperacao=? AND dataOperacao=?");
            stmt.setDouble(1, saida.getValorSaida());
            java.sql.Time horaOperacao = java.sql.Time.valueOf(saida.getHoraOperacao());
            java.sql.Date dataOperacao = java.sql.Date.valueOf(saida.getDataOperacao());
            stmt.setTime(2, horaOperacao);
            stmt.setDate(3, dataOperacao);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saída Alterada com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro:" + e);
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }
    }

    public boolean delete(LocalTime hora,LocalDate data) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM fluxodecaixa WHERE horaOperacao=? AND dataOperacao=?");
            java.sql.Time horaOperacao = java.sql.Time.valueOf(hora);
            java.sql.Date dataOperacao = java.sql.Date.valueOf(data);
            stmt.setTime(1, horaOperacao);
            stmt.setDate(2, dataOperacao);
            
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERRO: " + e);
            return false;
        }finally{
        ConexaoBanco.closeConnection(con, stmt);
        }
    }
}

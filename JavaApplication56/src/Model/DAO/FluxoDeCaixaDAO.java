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
import java.util.ArrayList;

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
        
        try {
            stmt = con.prepareStatement("SELECT * FROM fluxodecaixa");
            rs=stmt.executeQuery();
            
            while (rs.next()) {                
                FluxoDeCaixa fluxo = new FluxoDeCaixa();
                fluxo.setDescricao(rs.getString("descricao"));
                fluxo.setTipo(rs.getString("tipo"));
                fluxo.setDataOperacao(rs.getDate("dataOperacao").toLocalDate());
                fluxo.setHoraOperacao(rs.getTime("horaOperacao").toLocalTime());
                fluxo.setValorEntrada(rs.getDouble("valorEntrada"));
                fluxo.setValorSaida(rs.getDouble("valorSaida"));
                
                
               LocalDate dataOp = rs.getDate("dataOperacao").toLocalDate();
               
                if (dataOp.getMonthValue() == mesAtual) {
                    lista.add(fluxo);
                }
            }
        } catch (SQLException ex) {
            System.out.println("ERRO:" + ex);
        }finally{
        ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return lista;
    }
}

package Model.DAO;

import ConnectionFactory.ConexaoBanco;
import Model.Carro;
import Model.CarroCliente;
import Model.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            stmt = con.prepareStatement("INSERT INTO carro(placa,modelo,montadora,motor,num_valvulas,num_cilindros,proprietario,combustivel,ano,cambio) VALUES (?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, carro.getPlaca());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getMontadora());
            stmt.setString(4, carro.getMotor());
            stmt.setInt(5, carro.getNum_valvulas());
            stmt.setInt(6, carro.getNum_cilindros());
            stmt.setString(7, carro.getCpf_proprietario());
            stmt.setString(8, carro.getCobustivel());
            stmt.setInt(9, carro.getAno());
            stmt.setString(10, carro.getCambio());

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
            stmt = con.prepareStatement("SELECT proprietario,modelo,montadora,motor,num_valvulas,num_cilindros,data_manutencao,proprietario,manutencao_agendada,combustivel,ano,cambio FROM carro WHERE placa=?");
            stmt.setString(1, placa);

            rs = stmt.executeQuery();

            while (rs.next()) {
                carro.setCpf_proprietario(rs.getString("proprietario"));
                carro.setModelo(rs.getString("modelo"));
                carro.setMontadora(rs.getString("montadora"));
                carro.setMotor(rs.getString("motor"));
                carro.setNum_valvulas(rs.getInt("num_valvulas"));
                carro.setNum_cilindros(rs.getInt("num_cilindros"));
                
                //Date manutencaoSql = rs.getDate("data_manutencao");
                
                if (rs.getDate("data_manutencao") != null) {
                    carro.setData_manutencao(rs.getDate("data_manutencao").toLocalDate());
                } else {
                    carro.setData_manutencao(null);
                }
                
                Date agendaSql = rs.getDate("manutencao_agendada");
                
                if (rs.getDate("manutencao_agendada") != null) {
                    carro.setManutencao_agendada(rs.getDate("manutencao_agendada").toLocalDate());
                } else {
                    carro.setManutencao_agendada(null);
                }
                carro.setCobustivel(rs.getString("combustivel"));
                carro.setAno(rs.getInt("ano"));
                carro.setCambio(rs.getString("cambio"));

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
            stmt = con.prepareStatement("UPDATE carro SET modelo=?,montadora=?,motor=?,num_valvulas=?,num_cilindros=?,combustivel=?,ano=?,cambio=? WHERE placa=?");
            stmt.setString(1, carro.getModelo());
            stmt.setString(2, carro.getMontadora());
            stmt.setString(3, carro.getMotor());
            stmt.setInt(4, carro.getNum_valvulas());
            stmt.setInt(5, carro.getNum_cilindros());
            stmt.setString(6, carro.getCobustivel());
            stmt.setString(7, carro.getCobustivel());
            stmt.setInt(8, carro.getAno());
            stmt.setString(9, carro.getCambio());
            stmt.setString(10, carro.getPlaca());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar carro?\n" + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }

    }

    public boolean delete(String placa) {
        try {
            stmt = con.prepareStatement("DELETE FROM carro WHERE placa=?");
            stmt.setString(1, placa);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao deletar carro!\n" + "Exclua as OS`s relacionadas ao carro primeiro!");
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
                carro.setCobustivel(rs.getString("combustivel"));
                carro.setAno(rs.getInt("ano"));
                carros.add(carro);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }

        return carros;
    }

    public void agendarManutencao(String placa, int dia, int mes) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE carro SET manutencao_agendada=? WHERE placa=?");
            int ano = LocalDate.now().getYear();
            LocalDate data = LocalDate.of(ano,mes,dia);
            java.sql.Date datasql = java.sql.Date.valueOf(data);
            stmt.setDate(1, datasql);
            stmt.setString(2, placa);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Manutenção Agendada com Sucesso!");
        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex);
            JOptionPane.showMessageDialog(null, "Erro ao Agendar Manutenção!");
        } catch(java.time.DateTimeException te){
            te.printStackTrace();
            JOptionPane.showMessageDialog(null, "informe uma Data Valida!");
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }
    }

    public void alterarManutencao(String placa,LocalDate data) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE carro SET manutencao_agendada=? WHERE placa=?");
            java.sql.Date datasql = java.sql.Date.valueOf(data);
            stmt.setDate(1, datasql);
            stmt.setString(2, placa);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Alterada com Sucesso!");
        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }
    }

    public void cancelarManutencao(String placa) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE carro SET manutencao_agendada=NULL WHERE placa=?");
            stmt.setString(1, placa);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Manutenção Cancelada com Sucesso!");
        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }
    }

    public void finalizarManutencao(String placa,LocalDate data) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE carro SET manutencao_agendada=NULL,data_manutencao=? WHERE placa=?");
            
            java.sql.Date dataAgendada = java.sql.Date.valueOf(data);
            stmt.setDate(1, dataAgendada);
            stmt.setString(2, placa);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Manutenção Finalizada Com Sucesso!");
        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }
    }

    public List<CarroCliente> listaManutencao(Date data) {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CarroCliente> lista = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT clientes.nome,carro.modelo,carro.placa,carro.manutencao_agendada FROM clientes INNER JOIN carro ON carro.proprietario=clientes.cpf WHERE carro.manutencao_agendada=? ");
            stmt.setDate(1, data);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Carro carro = new Carro();
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                carro.setModelo(rs.getString("modelo"));
                carro.setPlaca(rs.getString("placa"));
                carro.setManutencao_agendada(rs.getDate("manutencao_agendada").toLocalDate());
                CarroCliente listaManutencao = new CarroCliente(cliente, carro);
                lista.add(listaManutencao);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }

        return lista;
    }

}

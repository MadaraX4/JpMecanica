package Model.DAO;

import ConnectionFactory.ConexaoBanco;
import Model.Carro;
import Model.Cliente;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void create(Cliente cliente) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO clientes (nome,rg,cpf,email,dataNascimento,telefone,endereco)VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getRg());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getEmail());
            stmt.setDate(5, (Date) cliente.getDataNascimento());
            stmt.setString(6, cliente.getTelefone());
            stmt.setString(7, cliente.getEndereco());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }

    }

    public Cliente select(String cpf) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT nome,rg,email,dataNascimento,telefone,endereco FROM clientes WHERE cpf=?");
            stmt.setString(1, cpf);

            rs = stmt.executeQuery();
            Cliente clienteBusca = new Cliente();

            if (rs.next()) {
                clienteBusca.setNome(rs.getString("nome"));
                clienteBusca.setRg(rs.getString("rg"));
                clienteBusca.setEmail(rs.getString("email"));
                clienteBusca.setDataNascimento(rs.getDate("dataNascimento"));
                clienteBusca.setTelefone(rs.getString("telefone"));
                clienteBusca.setEndereco(rs.getString("endereco"));

                return clienteBusca;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return null;

    }

    public List<Carro> read(String proprietario) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Carro> carros = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT DISTINCT placa,modelo,montadora,data_manutencao from carro where proprietario = ?");
            stmt.setString(1, proprietario);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Carro listaCarro = new Carro();
                listaCarro.setPlaca(rs.getString("placa"));
                listaCarro.setModelo(rs.getString("modelo"));
                listaCarro.setMontadora(rs.getString("montadora"));
                listaCarro.setData_manutencao(rs.getDate("data_manutencao"));

                carros.add(listaCarro);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);

        }

        return carros;

    }

    public boolean delete(String cpf) {

        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM clientes WHERE CPF=?");
            stmt.setString(1, cpf);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente deletado!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "<html>Cliente não encontrado ou<br>Caso cliente tenha um carro cadastrado delete o carro primeiro!</html>" + ex);
            return false;
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }

    }

    public void alterarCliente(Cliente cliente) {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE clientes set nome=?, rg=?, email=?, dataNascimento=?, telefone=?, endereco=? WHERE cpf=? ");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getRg());
            stmt.setString(3, cliente.getEmail());
            stmt.setDate(4, (Date) cliente.getDataNascimento());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getEndereco());
            stmt.setString(7, cliente.getCpf());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }
    }

    public List<String> listaNome(String cpf) {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<String> listaCliente = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM clientes WHERE cpf LIKE ?");
            stmt.setString(1, cpf + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                listaCliente.add(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return listaCliente;
    }

    public List<Cliente> listaCliente(String nome) {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> listaCliente = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM clientes WHERE nome LIKE ?");
            stmt.setString(1, nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                listaCliente.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }
        return listaCliente;
    }

    public List<String> verificarAniversario() {
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<String> aniversariantes = new ArrayList<>();

        LocalDate dataAtual = LocalDate.now();
        int diaAtual = dataAtual.getDayOfMonth();
        int mesAtual = dataAtual.getMonthValue();

        boolean temAniverssariante = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM clientes");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                Date data = rs.getDate("dataNascimento");

                if (data != null) {

                    LocalDate dataAniversario = data.toLocalDate();

                    if (dataAniversario.getDayOfMonth() == diaAtual && dataAniversario.getMonthValue() == mesAtual) {
                        String menssagem = "Hoje é Aniverssario de " + cliente.getNome() + " Mande uma menssagem de parabéns para seu Telefone:" + cliente.getTelefone() + " ou Email: " + cliente.getEmail();
                        String espaco = "----------------------------------------------------------------*----------------------------------------------------------------";
                        aniversariantes.add(menssagem +"\n"+ espaco);
                        temAniverssariante = true;
                    }
                }
            }
            
            if (!temAniverssariante) {
                aniversariantes.add("Não temos aniversariantes no dia de hoje!");
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }

        return aniversariantes;
    }

}

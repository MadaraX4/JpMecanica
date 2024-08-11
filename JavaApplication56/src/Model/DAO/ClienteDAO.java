package Model.DAO;

import ConnectionFactory.ConexaoBanco;
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

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

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

}

package Model.DAO;

import ConnectionFactory.ConexaoBanco;
import Model.Mecanico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MecanicoDAO {

    Connection con = ConexaoBanco.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public void create(Mecanico mecanico) {

        try {
            stmt = con.prepareStatement("INSERT INTO mecanico(nome,rg,cpf,telefone,data_nascimento,categoria,email,endereco,referencia) VALUES(?,?,?,?,?,?,?,?,?)");
            java.sql.Date datasql = java.sql.Date.valueOf(mecanico.getData_nascimento());
            stmt.setString(1, mecanico.getNome());
            stmt.setString(2, mecanico.getRg());
            stmt.setString(3, mecanico.getCpf());
            stmt.setString(4, mecanico.getTelefone());
            stmt.setDate(5, datasql);
            stmt.setString(6, mecanico.getCategoria());
            stmt.setString(7, mecanico.getEmail());
            stmt.setString(8, mecanico.getEndereco());
            stmt.setString(9, mecanico.getReferencia());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Mecanico!\n" + ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }

    }

    public Mecanico select(String cpf) {

        Mecanico mecanico = new Mecanico();
        try {
            stmt = con.prepareStatement("SELECT nome,rg,telefone,data_nascimento,categoria,email,endereco,referencia FROM mecanico WHERE cpf=?");
            stmt.setString(1, cpf);

            rs = stmt.executeQuery();

            while (rs.next()) {
                mecanico.setCategoria(rs.getString("categoria"));
                mecanico.setData_nascimento(rs.getDate("data_nascimento").toLocalDate());
                mecanico.setEmail(rs.getString("email"));
                mecanico.setEndereco(rs.getString("endereco"));
                mecanico.setNome(rs.getString("nome"));
                mecanico.setReferencia(rs.getString("referencia"));
                mecanico.setRg(rs.getString("rg"));
                mecanico.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mecânico não cadastrado ou não encontrado!\n " + ex);
        }finally{
        ConexaoBanco.closeConnection(con, stmt, rs);
        }

        return mecanico;
    }
    
    public void update(Mecanico mecanico){
        
        try {
            stmt=con.prepareStatement("UPDATE mecanico SET nome=?,rg=?,telefone=?,data_nascimento=?,categoria=?,email=?,endereco=?,referencia=? WHERE cpf=?");
             java.sql.Date datasql = java.sql.Date.valueOf(mecanico.getData_nascimento());
            stmt.setString(1, mecanico.getNome());
            stmt.setString(2, mecanico.getRg());
            stmt.setString(3, mecanico.getTelefone());
            stmt.setDate(4, datasql);
            stmt.setString(5, mecanico.getCategoria());
            stmt.setString(6, mecanico.getEmail());
            stmt.setString(7, mecanico.getEndereco());
            stmt.setString(8, mecanico.getReferencia());
            stmt.setString(9, mecanico.getCpf());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao aterar mecanico!\n" + ex);
        }finally{
        ConexaoBanco.closeConnection(con, stmt);
        }
    }
    
    public boolean delete(String cpf){
    
        try {
            stmt=con.prepareStatement("DELETE FROM mecanico WHERE cpf=?");
            stmt.setString(1, cpf);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!\n"+ex);
            return false;
        }finally{
        ConexaoBanco.closeConnection(con, stmt);
        }
    
    }
}

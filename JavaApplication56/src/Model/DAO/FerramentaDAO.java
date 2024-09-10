package Model.DAO;

import ConnectionFactory.ConexaoBanco;
import Model.Ferramenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FerramentaDAO {

    Connection con = ConexaoBanco.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public void create(Ferramenta ferramenta) {

        try {
            stmt = con.prepareStatement("INSERT INTO ferramenta(nome,quantidade,usuario) VALUES (?,?,?)");
            stmt.setString(1, ferramenta.getNome());
            stmt.setInt(2, ferramenta.getQuantidade());
            stmt.setString(3, ferramenta.getUsuario());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar ferramenta!\n" + ex);
        }
    }

    public List<Ferramenta> read() {

        List<Ferramenta> ferramentas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM ferramenta");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Ferramenta ferramenta = new Ferramenta();

                ferramenta.setId(rs.getInt("id"));
                ferramenta.setNome(rs.getString("nome"));
                ferramenta.setQuantidade(rs.getInt("quantidade"));
                ferramenta.setUsuario(rs.getString("usuario"));

                ferramentas.add(ferramenta);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }

        return ferramentas;
    }
}

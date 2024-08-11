package ConnectionFactory;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexaoBanco {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/jpmarket";
    private static final String USER = "root";
    private static final String PASSWORD = "";

   

    public static Connection getConnection(){
        
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão:",ex);
        }
    }
    
    public static void closeConnection(Connection con){
        if (con!=null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void closeConnection(Connection con, PreparedStatement stmt){
        closeConnection(con);
        
       
        if (stmt!=null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        
       
        if (rs!=null) {
            try {
              
                rs.close();
              
            } catch (SQLException ex) {
                
                Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}


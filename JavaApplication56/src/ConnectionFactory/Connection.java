package ConnectionFactory;


import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private static final String url = "jdbc:mysql://localhost:3306/jpmarket";
    private static final String user = "root";
    private static final String password = "";

    private static Connection conn;

    public static Connection getConexao() throws SQLException  {
       return (Connection) DriverManager.getConnection(url, user, password);
    }
}

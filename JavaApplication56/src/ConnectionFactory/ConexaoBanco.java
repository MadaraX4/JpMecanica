package ConnectionFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoBanco {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/jpmarket";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private String dataBase = "jpmarket";

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão:", ex);
        }
    }

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con, stmt);

        if (rs != null) {
            try {

                rs.close();

            } catch (SQLException ex) {

                Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void backup() {
        String caminho = "c:/Documentos/JpMarcket/Backup/backup.sql";

        File backupFile = new File(caminho);
        File backupDir = backupFile.getParentFile();

        if (!backupDir.exists()) {
            backupDir.mkdirs();
            System.out.println("Diretório de backup criado em: " + backupDir.getAbsolutePath());
        }

        String dumpCommand = "mysqldump -u" + USER + " -p" + PASSWORD + " --no-create-info" + dataBase + " -r" + caminho;

        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", dumpCommand);

        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();

            if (exitCode == 0) {
                JOptionPane.showMessageDialog(null, "Backup realizado com sucesso em: " + caminho);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao realizar o backup.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void restaurarBackup() {
        String caminho = "c:/Documentos/JpMarcket/Backup/backup.sql";

        // Comando para restaurar o backup
        String restoreCommand = "mysql -u" + USER + " -p" + PASSWORD + " " + dataBase + " < " + caminho;

        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", restoreCommand);

        try {
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();

            if (exitCode == 0) {
                JOptionPane.showMessageDialog(null, "Backup restaurado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao restaurar o backup.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

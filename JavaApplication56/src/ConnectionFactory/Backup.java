/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectionFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author MadaraX4
 */
public class Backup {

    private static final String USER = "root"; // Substitua pelo seu usuário do MySQL
    private static final String PASSWORD = "OYK2Ld5kj3"; // Substitua pela sua senha do MySQL
    private static final String DATABASE = "jpmarket"; // Nome do banco de dados
    private static final String BACKUP_PATH = "C:\\backup\\"; // Caminho para salvar o backup
    private static final String MYSQLDUMP_PATH = "\"C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump\"";

    public static void realizarBackup(String database, String backupPath) {
         // Diretório de backup
        File backupDir = new File(backupPath);
        if (!backupDir.exists()) {
            backupDir.mkdirs();
        }

        // Caminho completo do arquivo de backup
        String caminho = backupPath + File.separator + "backup.sql";

        // Comando mysqldump
        String dumpCommand = "cmd.exe /c \"" + MYSQLDUMP_PATH + "\""
        + " -u" + USER
        + " -p" + PASSWORD
        + " " + database
        + " > \"" + caminho + "\"";

        try {
            // Configura o ProcessBuilder
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", dumpCommand);
            processBuilder.redirectErrorStream(true); // Redireciona erros para a saída padrão

            Process process = processBuilder.start();

            // Lê a saída do comando
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Mostra a saída do comando mysqldump
               
            }

            // Verifica o código de saída
            int exitCode = process.waitFor();
            System.out.println("Código de saída: " + exitCode);


            if (exitCode == 0) {
                JOptionPane.showMessageDialog(null, "Backup realizado com sucesso em: " + caminho);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao realizar o backup. Verifique os logs.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar o backup: " + e.getMessage());
            e.printStackTrace();
        }
    
    
    }
    
    public static void restaurarBackup(String database, String backupPath) {
        // Caminho do arquivo de backup
        File backupFile = new File(backupPath);

        // Verifica se o arquivo de backup existe
        if (!backupFile.exists()) {
            JOptionPane.showMessageDialog(null, "Arquivo de backup não encontrado: " + backupPath);
            return;
        }

        // Comando para restaurar o backup
        String restoreCommand =  "cmd.exe /c \"" + MYSQLDUMP_PATH + "\""
        + " -u" + USER
        + " -p" + PASSWORD
        + " " + database
                + " < \"" + backupFile.getAbsolutePath() + "\"";

        System.out.println("Executando comando: " + restoreCommand);

        try {
            // Configura o ProcessBuilder para executar o comando no shell
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", restoreCommand);
            Process process = processBuilder.start();

            // Lê a saída e os erros do processo
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String line;
            while ((line = inputReader.readLine()) != null) {
                System.out.println("OUTPUT: " + line);
            }

            while ((line = errorReader.readLine()) != null) {
                System.err.println("ERROR: " + line);
            }

            // Verifica o código de saída
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                JOptionPane.showMessageDialog(null, "Backup restaurado com sucesso para o banco: " + database);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao restaurar o backup. Verifique os logs.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a restauração: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

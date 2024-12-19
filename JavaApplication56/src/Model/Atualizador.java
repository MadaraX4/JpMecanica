package Model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;

public class Atualizador {

    private static final String version_url = "https://raw.githubusercontent.com/MadaraX4/JpMecanica/refs/heads/master/JavaApplication56/src/Version/Version.txt";
    private static final String FILE_URL = "https://github.com/MadaraX4/JpMecanica/releases/download/v1.0.0/JpMarket.jar";
    private static final String DESTINO = "‪C:\\Program Files (x86)\\JpMarket\\JpMarket.jar";

    public static String getRemoteVersion() {
        try {
            URL url = new URL(version_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String version = reader.readLine();
            reader.close();

            return version.trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para realizar o download do arquivo
    public static void downloadFile(String fileUrl, String destino) {
        try (BufferedInputStream in = new BufferedInputStream(new URL(fileUrl).openStream()); FileOutputStream fileOutputStream = new FileOutputStream(destino)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            System.out.println("Arquivo baixado com sucesso em: " + destino);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para reiniciar a aplicação
    public static void reiniciarAplicacao() {
        try {
            // Obtendo o caminho absoluto do arquivo JAR e adicionando aspas
            String comando = "java -jar \"" + new File(DESTINO).getAbsolutePath() + "\"";

            // Exibindo o comando para debug
            System.out.println("Comando para reiniciar: " + comando);

            // Criando o processo
            ProcessBuilder processBuilder = new ProcessBuilder(comando.split(" "));
            Process processo = processBuilder.start();

            // Espera o processo finalizar
            int exitCode = processo.waitFor();
            System.out.println("Código de saída do processo: " + exitCode);

            // Finaliza a aplicação atual
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getLocalVersion() {
        try (InputStream inputStream = Atualizador.class.getResourceAsStream("/version.txt")) {
        if (inputStream == null) {
            System.out.println("Arquivo version.txt não encontrado!");
            return "1.0.0"; // Versão padrão
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String version = reader.readLine();
        return version != null ? version.trim() : "1.0.0"; // Se não houver versão, retorna a versão padrão
    } catch (IOException e) {
        e.printStackTrace();
        return "1.0.0"; // Em caso de erro, retorna a versão padrão
    }
    }
    
    public static void atualizarVersaoLocal(String novaVersao) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("version.txt"))) {
        writer.write(novaVersao);
        System.out.println("Versão local atualizada para: " + novaVersao);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    // Método para verificar a atualização
    public static void verificaAtualizacao() {
        String localVersion = getLocalVersion();  // Versão local
        String remoteVersion = getRemoteVersion();  // Obtendo a versão remota

        // Verificando se a versão remota é diferente da local
        if (remoteVersion != null && !localVersion.equals(remoteVersion)) {
            JOptionPane.showMessageDialog(null, "Nova versão disponível: " + remoteVersion);

            // Baixando a atualização
            JOptionPane.showMessageDialog(null, "Baixando atualização...");

            downloadFile(FILE_URL, DESTINO);

            atualizarVersaoLocal(remoteVersion);
            JOptionPane.showMessageDialog(null, "Atualização concluída. Reiniciando a aplicação.");

            // Reiniciando a aplicação
            reiniciarAplicacao();
        } else {
            System.out.println("Aplicação já está atualizada.");
        }

    }

}

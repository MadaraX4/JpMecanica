package Model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;

public class Atualizador {

    private static final String version_url = "https://raw.githubusercontent.com/MadaraX4/JpMecanica/refs/heads/Trabalhando/JavaApplication56/src/Version/Version.txt";
    private static final String FILE_URL = "https://github.com/MadaraX4/JpMecanica/releases/download/v1.0.0/JpMarket.jar";
    private static final String Destino = "JpMarket.jar";

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
    
    public static void reniciarAplicacao(){
        try {
            String comando = "Java -jar" + Destino;
            Runtime.getRuntime().exec(comando);
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verificaAtualizacao() {
        String localVersion = "1.0.0";
        String remoteVersion = getRemoteVersion();

        if (remoteVersion != null && !localVersion.equals(remoteVersion)) {
            JOptionPane.showMessageDialog(null, "Nova Versão Disponivel: " + remoteVersion);
            JOptionPane.showMessageDialog(null, "Baixando Atualização\n" + "Confirme para continuar!");
            downloadFile(FILE_URL, Destino);
            JOptionPane.showMessageDialog(null,"Atualização concluída. Reiniciando a Apllicação." );
            reniciarAplicacao();

        } else {
            System.out.println("Aplicação ja está atualizada.");
        }
    }

}

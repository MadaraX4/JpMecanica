package GerarPdfs;

import static GerarPdfs.OsPDF.openFile;
import Model.DAO.FluxoDeCaixaDAO;
import Model.FluxoDeCaixa;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;
import java.io.*;
import java.nio.file.*;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CaixaPdf {

    public void gerarPdf(int mes, int ano) {

        Document documento = new Document();
        documento.setMargins(40f, 40f, 5f, 5f);

        try {
            // Definir caminho para os documentos
            String publicUserHome = "C:\\Users\\Public\\Documents";
            Path documentosPath = Paths.get(publicUserHome, "Caixa");

            if (!Files.exists(documentosPath)) {
                Files.createDirectories(documentosPath);
            }

            // Nome do arquivo PDF
            String dataName = "Caixa " + mes + "-" + ano;
            String fileName = dataName + ".pdf";
            Path pdfPath = documentosPath.resolve(fileName);

            // Criação do arquivo PDF
            PdfWriter.getInstance(documento, new FileOutputStream(pdfPath.toFile()));
            documento.open();

            // Fontes e estilo do título
            Font fontePadrao = FontFactory.getFont(FontFactory.HELVETICA, 30, Font.BOLD);
            Paragraph titulo = new Paragraph("Caixa", fontePadrao);
            titulo.setAlignment(Element.ALIGN_CENTER);

            // Linha em branco para espaçamento
            Paragraph linhaEmBranco = new Paragraph("                                                            ");

            // Criar a tabela
            PdfPTable tabelaMes = new PdfPTable(6);
            tabelaMes.setWidthPercentage(100);
            tabelaMes.setWidths(new float[]{35, 15, 15, 15, 10, 10});

            // Adicionando cabeçalho da tabela
            tabelaMes.addCell(createHeaderCell("DESCRIÇÃO"));
            tabelaMes.addCell(createHeaderCell("TIPO"));
            tabelaMes.addCell(createHeaderCell("DATA"));
            tabelaMes.addCell(createHeaderCell("HORA"));
            tabelaMes.addCell(createHeaderCell("ENTRADA"));
            tabelaMes.addCell(createHeaderCell("SAÍDA"));

            // Carregar dados do banco
            FluxoDeCaixaDAO dao = new FluxoDeCaixaDAO();
            List<FluxoDeCaixa> fluxo = dao.fluxoPorMes(mes, ano);

            // Preenchendo a tabela com os dados
            DecimalFormat formatoValor = new DecimalFormat("#,##0.00");
            DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            for (FluxoDeCaixa fluxoDeCaixa : fluxo) {
                tabelaMes.addCell(createDataCell(fluxoDeCaixa.getDescricao()));
                tabelaMes.addCell(createDataCell(fluxoDeCaixa.getTipo()));
                tabelaMes.addCell(createDataCell(fluxoDeCaixa.getDataOperacao().format(formater)));
                tabelaMes.addCell(createDataCell(fluxoDeCaixa.getHoraOperacao().toString()));
                tabelaMes.addCell(createDataCell(formatoValor.format(fluxoDeCaixa.getValorEntrada())));
                tabelaMes.addCell(createDataCell(formatoValor.format(fluxoDeCaixa.getValorSaida())));
            }

            // Adicionar conteúdo no documento
            documento.add(titulo);
            documento.add(linhaEmBranco);
            documento.add(tabelaMes);

            // Abrir o PDF gerado
            openFile(pdfPath.toFile());
            documento.close();

        } catch (Exception e) {
            // Melhorar tratamento de exceções
            System.out.println("Erro ao gerar o PDF: " + e.getMessage());
            e.printStackTrace(); // Adicionar informações de erro para facilitar a depuração
        }
    }

    // Método para criar uma célula de cabeçalho
    private PdfPCell createHeaderCell(String texto) {
        PdfPCell cell = new PdfPCell(new Paragraph(texto));
        cell.setBorderWidth(1);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        return cell;
    }

    // Método para criar uma célula de dados
    private PdfPCell createDataCell(String texto) {
        PdfPCell cell = new PdfPCell(new Paragraph(texto));
        cell.setBorderWidth(1);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        return cell;
    }

    // Método para abrir o arquivo PDF gerado
    public static void openFile(File file) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop desktop = Desktop.getDesktop();
                if (file.exists()) {
                    desktop.open(file);  // Abre o arquivo com o programa padrão associado
                } else {
                    System.out.println("Erro: Arquivo não encontrado!");
                }
            } catch (IOException e) {
                System.out.println("Erro ao tentar abrir o arquivo: " + e.getMessage());
            }
        } else {
            System.out.println("Abertura de arquivos não é suportada no sistema.");
        }
    }
}

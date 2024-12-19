package GerarPdfs;

import static GerarPdfs.OsPDF.openFile;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class OrcamentoPDF {

    public void gerarPdf(String data, String hora, String nomeCliente, String telefoneCliente, String nomeCarro, String motor, String ano, String combustivel, String chassi, JTable tabelaPecas, JTable tabelaServicos, Double total) {

        Document documento = new Document();

        documento.setMargins(40f, 40f, 5f, 5f);

        String cliente = nomeCliente.replaceAll(" ", "_");

        try {

           String publicUserHome = "C:\\Users\\Public\\Documents";
            Path documentosPath = Paths.get(publicUserHome, "Orçamentos");

            // Cria a pasta "Orçamentos" se ela não existir
            if (!Files.exists(documentosPath)) {
                Files.createDirectories(documentosPath);
            }

            // Nome do arquivo PDF
            // Substitua pelo nome do cliente
            String fileName = "Orçamento_" + cliente + ".pdf";
            //String caminho = System.getProperty("user.home") + "\\Documents\\Orçamentos\\" + fileName; // Caminho completo do arquivo
            Path pdfPath = documentosPath.resolve(fileName);

            // Criação do PDF usando iText
            PdfWriter.getInstance(documento, new FileOutputStream(pdfPath.toFile()));

            //abrindo documento
            documento.open();

//            BaseFont fonteTexto = BaseFont.createFont("src/Fontes/ARIAL.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//            Font arial = new Font(fonteTexto);
//
//            BaseFont fonteItalico = BaseFont.createFont("src/Fontes/ARIALI.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//            Font arialItalico = new Font(fonteItalico);
            Font fontePadrao = FontFactory.getFont(FontFactory.TIMES_BOLD,30,Font.BOLD);
            Paragraph orcamento = new Paragraph(new Phrase(30, "Orçamento",fontePadrao));
            orcamento.setAlignment(Element.ALIGN_CENTER);

//            BaseFont fonteTitulo = BaseFont.createFont("src/Fontes/Simply Rounded Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//            Font font = new Font(fonteTitulo, 25f);
//
//            BaseFont fonteMarcador = BaseFont.createFont("src/Fontes/ARIALBD.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//            Font arialBold = new Font(fonteMarcador);

            Paragraph tituloDaOs = new Paragraph(new Phrase(30f, "JP Mecânica e Injeção"));

            tituloDaOs.setAlignment(Element.ALIGN_RIGHT);

            Paragraph linhaEmBranco = new Paragraph(new Phrase(1f, "                                                            "));

            PdfPTable imagemSubTitulo = new PdfPTable(2);
            imagemSubTitulo.setWidthPercentage(100);
            imagemSubTitulo.setWidths(new float[]{35, 65});

            Image imgLogo = Image.getInstance(getClass().getResource("/resources/img/LOGO-removebg-preview.png"));
            imgLogo.scaleToFit(150, 150);
            PdfPCell cellImagem = new PdfPCell(imgLogo);
            cellImagem.setBorder(PdfPCell.NO_BORDER);
            cellImagem.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellImagem.setVerticalAlignment(Element.ALIGN_CENTER);

            imagemSubTitulo.addCell(cellImagem);

            Paragraph subtitulo = new Paragraph();
            subtitulo.add(new Chunk("MECCÂNICA GERAL • CÂMBIO AUTOMATICO\n"));
            subtitulo.add(new Chunk("CÂMBIOAUTOMATIZADO • CORREIA DENTADA\n"));
            subtitulo.add(new Chunk("SUSPENSÃO • FREIO • ARREFECIMENTO \n"));
            subtitulo.add(new Chunk("LIMPEZA DE BICO • SCANEAMENTO COMPUTADORIZADO • REVISÃO MECÂNICA\n"));
            subtitulo.add(new Chunk("BOMBA DE COMBUSTÍVEL • REVISÃO ELÉTRICA"));
            PdfPCell cellSubtitulo = new PdfPCell(subtitulo);
            cellSubtitulo.setBorder(PdfPCell.NO_BORDER);
            cellSubtitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSubtitulo.setVerticalAlignment(Element.ALIGN_CENTER);
            imagemSubTitulo.addCell(cellSubtitulo);

            Paragraph aviso = new Paragraph();
            aviso.add(new Chunk("Este Orçamento é valido até 7 dias após a data " + data + " " + hora));

            Paragraph nome = new Paragraph();
            nome.add(new Chunk("NOME: "));
            nome.add(new Chunk(nomeCliente));

            Paragraph telefone = new Paragraph();
            telefone.add(new Chunk("TELEFONE: "));
            telefone.add(new Chunk(telefoneCliente));

            Paragraph carro = new Paragraph();
            carro.add(new Chunk("CARRO: "));
            carro.add(new Chunk(nomeCarro));
            carro.add(new Chunk("        "));
            carro.add(new Chunk("MOTOR: "));
            carro.add(new Chunk(motor));

            Paragraph anoCombustivel = new Paragraph();
            anoCombustivel.add(new Chunk("ANO: "));
            anoCombustivel.add(new Chunk(ano));
            anoCombustivel.add(new Chunk("        "));
            anoCombustivel.add(new Chunk("COMBUSTIVEL: "));
            anoCombustivel.add(new Chunk(combustivel));

            Paragraph paragrafoChassi = new Paragraph();
            paragrafoChassi.add(new Chunk("CHASSI: "));
            paragrafoChassi.add(new Chunk(chassi));

            Paragraph solicitacao = new Paragraph(30, "SOLIÇITAÇÃO DE ORÇAMENTO");
            solicitacao.setAlignment(Element.ALIGN_CENTER);

            //tabela de peças usadas
            PdfPTable pecas = new PdfPTable(tabelaPecas.getColumnCount());
            pecas.setWidthPercentage(100);
            pecas.setWidths(new float[]{60, 15, 15});

            for (int i = 0; i < tabelaPecas.getColumnCount(); i++) {
                pecas.addCell(tabelaPecas.getColumnName(i));
            }

            for (int i = 0; i < tabelaPecas.getRowCount(); i++) {
                for (int j = 0; j < tabelaPecas.getColumnCount(); j++) {
                    pecas.addCell(tabelaPecas.getValueAt(i, j).toString());
                }
            }

            //tabela de serviços
            PdfPTable servicos = new PdfPTable(tabelaServicos.getColumnCount());
            servicos.setWidthPercentage(80);
            servicos.setWidths(new float[]{60, 20});

            for (int i = 0; i < tabelaServicos.getColumnCount(); i++) {
                servicos.addCell(tabelaServicos.getColumnName(i));
            }

            for (int i = 0; i < tabelaServicos.getRowCount(); i++) {
                for (int j = 0; j < tabelaServicos.getColumnCount(); j++) {
                    servicos.addCell(tabelaServicos.getValueAt(i, j).toString());
                }
            }

            DecimalFormat formatoValor = new DecimalFormat("#,##0.00");
            Paragraph valorTotal = new Paragraph(new Phrase(25, "TOTAL= R$ " + formatoValor.format(total)));

            //adicionando ao documento
            documento.add(orcamento);
            documento.add(linhaEmBranco);
            documento.add(tituloDaOs);
            documento.add(linhaEmBranco);
            documento.add(imagemSubTitulo);
            documento.add(linhaEmBranco);
            documento.add(aviso);
            documento.add(linhaEmBranco);
            documento.add(nome);
            documento.add(telefone);
            documento.add(carro);
            documento.add(anoCombustivel);
            documento.add(paragrafoChassi);
            documento.add(linhaEmBranco);
            documento.add(solicitacao);
            documento.add(pecas);
            documento.add(linhaEmBranco);
            documento.add(servicos);
            documento.add(linhaEmBranco);
            documento.add(valorTotal);
            //abrindo documento windows
          openFile(pdfPath.toFile());
            //fechando edição
            documento.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
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

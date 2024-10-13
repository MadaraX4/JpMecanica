package Controler;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OsPDF {

    public void gerarPdf() {
        //instancia do documento
        Document documento = new Document(PageSize.A4);

        //margen do documento
        documento.setMargins(40f, 40f, 40f, 40f);

        try {
            PdfWriter.getInstance(documento, new FileOutputStream("Os.pdf"));

            //abrindo edição
            documento.open();

            BaseFont fonteTitulo = BaseFont.createFont("src/Fontes/Simply Rounded Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(fonteTitulo, 25f);
            
            Paragraph tituloDaOs = new Paragraph(new Phrase(30f, "JP Mecânica e Injeção", font));

            tituloDaOs.setAlignment(Element.ALIGN_RIGHT);
            
            Paragraph linhaEmBranco = new Paragraph(new Phrase(30f,"                                                            "));

            PdfPTable imagemSubTitulo = new PdfPTable(2);
            imagemSubTitulo.setWidthPercentage(100);

            Image imgLogo = Image.getInstance("src/img/LOGO-removebg-preview.png");
            imgLogo.scaleToFit(150, 150);
            PdfPCell cellImagem = new PdfPCell(imgLogo);
            cellImagem.setBorder(PdfPCell.NO_BORDER);
            imagemSubTitulo.addCell(cellImagem);

            Paragraph subtitulo = new Paragraph("MECCÂNICA GERAL • CÂMBIO AUTOMATICO\nCÂMBIOAUTOMATIZADO • CORREIA DENTADA\n");
            PdfPCell cellSubtitulo = new PdfPCell(subtitulo);
            cellSubtitulo.setBorder(PdfPCell.NO_BORDER);
            imagemSubTitulo.addCell(cellSubtitulo);

            //adicionar inten ao documento
            documento.add(tituloDaOs);
            documento.add(linhaEmBranco);
            documento.add(imagemSubTitulo);

            //abrindo documento na máquina
            Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start", "Os.pdf"});

            //fechando edição
            documento.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (DocumentException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
}

package Controler;

import Model.DAO.OsDAO;
import Model.DAO.Os_PecasDAO;
import Model.DAO.Os_ServicoDAO;
import Model.ListaPecas;
import Model.Os;
import Model.Servico;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
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
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DrawInterface;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OsPDF {

    public void gerarPdf(int idOs) {
        //instancia do documento
        Document documento = new Document(PageSize.A4);

        //margen do documento
        documento.setMargins(40f, 40f, 40f, 40f);

        try {
            PdfWriter.getInstance(documento, new FileOutputStream("Os.pdf"));

            //abrindo edição
            documento.open();

            //Adicionando fonte ao projeto
            BaseFont fonteTitulo = BaseFont.createFont("src/Fontes/Simply Rounded Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(fonteTitulo, 25f);

            Paragraph tituloDaOs = new Paragraph(new Phrase(30f, "JP Mecânica e Injeção", font));

            tituloDaOs.setAlignment(Element.ALIGN_RIGHT);

            Paragraph linhaEmBranco = new Paragraph(new Phrase(15f, "                                                            "));

            PdfPTable imagemSubTitulo = new PdfPTable(2);
            imagemSubTitulo.setWidthPercentage(100);
            imagemSubTitulo.setWidths(new float[]{35, 65});

            Image imgLogo = Image.getInstance("src/img/LOGO-removebg-preview.png");
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

            //CONTATOS
            Image whatsappIcon = Image.getInstance("src/img/icons8-whatsapp-16.png");
            whatsappIcon.scaleToFit(16, 16);

            Image emailIcon = Image.getInstance("src/img/icons8-nova-mensagem-16.png");
            emailIcon.scaleToFit(16, 16);

            Paragraph contatos = new Paragraph();
            Chunk iconChunk = new Chunk(whatsappIcon, 0, -5); // Ajuste a posição vertical se necessário
            Chunk iconeEmail = new Chunk(emailIcon, 0, -5);
            contatos.add(iconChunk);
            contatos.add(" ");
            contatos.add(" (19) 99411-67012");
            contatos.add("                   ");
            contatos.add(iconeEmail);
            contatos.add("joaopazdesousa@gmail.com");
            contatos.setAlignment(Element.ALIGN_CENTER);

            //Bucando os
            OsDAO dao = new OsDAO();
            Os os = dao.Select(idOs);

            //separador
            Paragraph separador = new Paragraph("_____________________________________________________________________________");

            //colocando dados da os
            BaseFont fonteMarcador = BaseFont.createFont("src/Fontes/ARIALBD.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font arialBold = new Font(fonteMarcador);

            BaseFont fonteTexto = BaseFont.createFont("src/Fontes/ARIAL.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font arial = new Font(fonteTexto);

            //Converter data para texto
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");

            Paragraph clienteEdata = new Paragraph();
            Chunk marcadorCliente = new Chunk("Cliente : ", arialBold);
            Chunk nomeCliente = new Chunk(os.getClienteNome(), arial);
            Chunk espaco = new Chunk("                  ");
            Chunk marcadorData = new Chunk("Data da OS: ", arialBold);
            Chunk dataOs = new Chunk(format.format(os.getDataOrdem()), arial);
            clienteEdata.add(marcadorCliente);
            clienteEdata.add(nomeCliente);
            clienteEdata.add(espaco);
            clienteEdata.add(marcadorData);
            clienteEdata.add(dataOs);

            Paragraph telefone = new Paragraph();
            Chunk marcadorTelefone = new Chunk("Telefone: ", arialBold);
            Chunk textoTelefone = new Chunk(os.getTelefone(), arial);
            telefone.add(marcadorTelefone);
            telefone.add(textoTelefone);

            Paragraph carro = new Paragraph();
            Chunk marcadorPlaca = new Chunk("Placa do Véiculo: ", arialBold);
            Chunk placa = new Chunk(os.getPlacaVeiculo(), arial);
            Chunk espaco2 = new Chunk("        ");
            Chunk marcadorModelo = new Chunk("Modelo: ", arialBold);
            Chunk modelo = new Chunk(os.getModelo(), arial);
            Chunk marcadorCombustivel = new Chunk("Combustivel: ", arialBold);
            Chunk combustivel = new Chunk(os.getCombustivel(), arial);
            carro.add(marcadorPlaca);
            carro.add(placa);
            carro.add(espaco2);
            carro.add(marcadorModelo);
            carro.add(modelo);
            carro.add(espaco2);
            carro.add(marcadorCombustivel);
            carro.add(combustivel);

            Paragraph tecnico = new Paragraph();
            Chunk marcadortecnico = new Chunk("Tecnico: ", arialBold);
            Chunk textoTecnico = new Chunk(os.getTecnico(), arial);
            tecnico.add(marcadortecnico);
            tecnico.add(textoTecnico);

            Paragraph id = new Paragraph(new Phrase(25f, "ID da OS = " + os.getId(), arialBold));

            //tabela de peças a serem usadas
            Paragraph tituloPecas = new Paragraph(new Phrase(20, "Peças a Serem Usadas", arialBold));
            tituloPecas.setAlignment(Element.ALIGN_CENTER);

            PdfPTable tabelaPecas = new PdfPTable(3);
            tabelaPecas.setWidthPercentage(100);
            tabelaPecas.setWidths(new float[]{60, 20, 20});

            //celulas da tabela pecas
            Paragraph nomePecas = new Paragraph("NOME", arialBold);
            nomePecas.setAlignment(Element.ALIGN_CENTER);
            Paragraph quantidadePecas = new Paragraph("QUANTIDADE", arialBold);
            quantidadePecas.setAlignment(Element.ALIGN_CENTER);
            Paragraph precoPecas = new Paragraph("PREÇO", arialBold);
            precoPecas.setAlignment(Element.ALIGN_CENTER);

            PdfPCell celulaNome = new PdfPCell(nomePecas);
            celulaNome.setBorderWidth(2);
            celulaNome.setBorderColor(BaseColor.YELLOW);

            PdfPCell celulaQuantidade = new PdfPCell(quantidadePecas);
            celulaQuantidade.setBorderWidth(2);
            celulaQuantidade.setBorderColor(BaseColor.YELLOW);

            PdfPCell celulaPreco = new PdfPCell(precoPecas);
            celulaPreco.setBorderWidth(2);
            celulaPreco.setBorderColor(BaseColor.YELLOW);

            tabelaPecas.addCell(celulaNome);
            tabelaPecas.addCell(celulaQuantidade);
            tabelaPecas.addCell(celulaPreco);

            Os_PecasDAO pecasDao = new Os_PecasDAO();
            List<ListaPecas> lista = pecasDao.pdfOs_pecas(idOs);

            for (ListaPecas itens : lista) {
                PdfPCell nome = new PdfPCell(new Paragraph(itens.getPeca().getNome()));
                nome.setBorderWidth(2);
                nome.setBorderColor(BaseColor.YELLOW);
                tabelaPecas.addCell(nome);
                PdfPCell quantidade = new PdfPCell(new Paragraph(String.valueOf(itens.getQuantidade())));
                quantidade.setBorderWidth(2);
                quantidade.setBorderColor(BaseColor.YELLOW);
                tabelaPecas.addCell(quantidade);
                PdfPCell preco = new PdfPCell(new Paragraph(String.valueOf(itens.getQuantidade() * itens.getPeca().getPreco_venda())));
                preco.setBorderWidth(2);
                preco.setBorderColor(BaseColor.YELLOW);
                tabelaPecas.addCell(preco);
            }

            //adicionando servicos
            Paragraph tituloServicos = new Paragraph(20, "Serviços a Serem Efetuados", arialBold);
            tituloServicos.setAlignment(Element.ALIGN_CENTER);

            PdfPTable tabelaServicos = new PdfPTable(2);
            tabelaServicos.setWidthPercentage(80);
            tabelaServicos.setWidths(new float[]{60, 20});

            //celas de serviços
            Paragraph nomeServicos = new Paragraph("NOME", arialBold);
            nomeServicos.setAlignment(Element.ALIGN_CENTER);
            Paragraph valorServicos = new Paragraph("VALOR", arialBold);
            valorServicos.setAlignment(Element.ALIGN_CENTER);

            PdfPCell celulaNomeServico = new PdfPCell(nomeServicos);
            celulaNomeServico.setBorderWidth(2);
            celulaNomeServico.setBorderColor(new BaseColor(100, 149, 237));

            PdfPCell celulaValorServico = new PdfPCell(valorServicos);
            celulaValorServico.setBorderWidth(2);
            celulaValorServico.setBorderColor(new BaseColor(100, 149, 237));

            tabelaServicos.addCell(celulaNomeServico);
            tabelaServicos.addCell(celulaValorServico);

            Os_ServicoDAO servicoDao = new Os_ServicoDAO();
            List<Servico> listaServico = servicoDao.pdfLista(idOs);

            for (Servico item : listaServico) {
                PdfPCell celulaNomeS = new PdfPCell(new Paragraph(item.getNome()));
                celulaNomeS.setBorderWidth(2);
                celulaNomeS.setBorderColor(new BaseColor(100, 149, 237));
                tabelaServicos.addCell(celulaNomeS);
                PdfPCell celulaValorS = new PdfPCell(new Paragraph(String.valueOf(item.getPreco())));
                celulaValorS.setBorderWidth(2);
                celulaValorS.setBorderColor(new BaseColor(100, 149, 237));
                tabelaServicos.addCell(celulaValorS);
            }

            Paragraph total = new Paragraph(25);
            Chunk marcadorTotal = new Chunk("TOTAL: ", arialBold);
            Chunk valorTotal = new Chunk(String.valueOf(os.getValor()), arial);
            total.add(marcadorTotal);
            total.add(valorTotal);

            //metodo de pagamento
            Paragraph pagamento = new Paragraph(new Phrase(25, "FORMA DE PAGAMENTO:__________________________", arialBold));

            Paragraph assinaturaCliente = new Paragraph(new Phrase(20, "Cliente:____________________________________________________", arial));
            Paragraph assinaturaJpMecanica = new Paragraph(new Phrase(20, "JP MECÂNICA:____________________________________________________", arial));

            //adicionar item ao documento
            documento.add(id);
            documento.add(tituloDaOs);
            documento.add(linhaEmBranco);
            documento.add(imagemSubTitulo);
            documento.add(linhaEmBranco);
            documento.add(contatos);
            documento.add(separador);
            documento.add(linhaEmBranco);
            documento.add(clienteEdata);
            documento.add(telefone);
            documento.add(carro);
            documento.add(tecnico);
            documento.add(linhaEmBranco);
            documento.add(separador);
            documento.add(tituloPecas);
            documento.add(linhaEmBranco);
            documento.add(tabelaPecas);
            documento.add(linhaEmBranco);
            documento.add(separador);
            documento.add(tituloServicos);
            documento.add(linhaEmBranco);
            documento.add(tabelaServicos);
            documento.add(linhaEmBranco);
            documento.add(separador);
            documento.add(total);
            documento.add(linhaEmBranco);
            documento.add(pagamento);
            documento.add(linhaEmBranco);
            documento.add(linhaEmBranco);
            documento.add(assinaturaCliente);
            documento.add(assinaturaJpMecanica);

            //abrindo documento windows
            Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start", "Os.pdf"});
            //abrindo no linux
            //Runtime.getRuntime().exec(new String[]{"xdg-open", "Os.pdf"});

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

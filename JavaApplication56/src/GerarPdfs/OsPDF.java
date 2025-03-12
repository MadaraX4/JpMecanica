package GerarPdfs;

import Model.DAO.OsDAO;
import Model.DAO.Os_PecasDAO;
import Model.DAO.Os_ServicoDAO;
import Model.ListaPecas;
import Model.ListaServicos;
import Model.Os;
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
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;

public class OsPDF {

    public void gerarPdf(int idOs) {
        //instancia do documento
        Document documento = new Document(PageSize.A4);

        //margen do documento
        documento.setMargins(40f, 40f, 5f, 5f);

        try {
            //Bucando os
            OsDAO dao = new OsDAO();
            Os os = dao.Select(idOs);

            String publicUserHome = "C:\\Users\\Public\\Documents";
            Path documentosPath = Paths.get(publicUserHome, "Os");

            // Cria a pasta "Orçamentos" se ela não existir
            if (!Files.exists(documentosPath)) {
                Files.createDirectories(documentosPath);
            }

            // Nome do arquivo PDF
            // Substitua pelo nome do cliente
            String fileName = "Os" + os.getClienteNome() + ".pdf";
            //String caminho = System.getProperty("user.home") + "\\Documents\\Os\\" + fileName; // Caminho completo do arquivo
            Path pdfPath = documentosPath.resolve(fileName);

            // Criação do PDF usando iText
            PdfWriter.getInstance(documento, new FileOutputStream(pdfPath.toFile()));

            //abrindo edição
            documento.open();

            //Adicionando fonte ao projeto
//
//            BaseFont fonteTitulo = BaseFont.createFont(getClass().getResource("/resources/Fontes/Simply Rounded Bold.ttf").getPath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//            Font font = new Font(fonteTitulo, 25f);
            Font fontePadrao = FontFactory.getFont(FontFactory.TIMES_BOLD, 30, Font.BOLD);
            Paragraph tituloDaOs = new Paragraph(30f, "JP Mecânica e Injeção", fontePadrao);

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

            //CONTATOS
            Image whatsappIcon = Image.getInstance(getClass().getResource("/resources/img/icons8-whatsapp-16.png"));
            whatsappIcon.scaleToFit(16, 16);

            Image emailIcon = Image.getInstance(getClass().getResource("/resources/img/icons8-nova-mensagem-16.png"));
            emailIcon.scaleToFit(16, 16);

            Paragraph contatos = new Paragraph();
            Chunk iconChunk = new Chunk(whatsappIcon, 0, -5); // Ajuste a posição vertical se necessário
            Chunk iconeEmail = new Chunk(emailIcon, 0, -5);
            contatos.add(iconChunk);
            contatos.add(" ");
            contatos.add(" (19) 99416-7012");
            contatos.add("                   ");
            contatos.add(iconeEmail);
            contatos.add(" joaopazdesousa@gmail.com");
            contatos.setAlignment(Element.ALIGN_CENTER);

            //separador
            Paragraph separador = new Paragraph("_____________________________________________________________________________");

            //colocando dados da os
//            BaseFont fonteMarcador = BaseFont.createFont(getClass().getResource("/resources/Fontes/ARIALBD.TTF").getPath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//            Font arialBold = new Font(fonteMarcador);
//
//            BaseFont fonteTexto = BaseFont.createFont(getClass().getResource("/resources/Fontes/ARIAL.TTF").getPath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//            Font arial = new Font(fonteTexto);
            //Converter data para texto
            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/YYYY");

            Paragraph clienteEdata = new Paragraph();
            Chunk marcadorCliente = new Chunk("Cliente : ");
            Chunk nomeCliente = new Chunk(os.getClienteNome());
            Chunk espaco = new Chunk("                  ");
            Chunk marcadorData = new Chunk("Data da OS: ");
            Chunk dataOs = new Chunk(formatoData.format(os.getDataOrdem()));
            clienteEdata.add(marcadorCliente);
            clienteEdata.add(nomeCliente);
            clienteEdata.add(espaco);
            clienteEdata.add(marcadorData);
            clienteEdata.add(dataOs);

            Paragraph telefone = new Paragraph();
            Chunk marcadorTelefone = new Chunk("Telefone: ");
            Chunk textoTelefone = new Chunk(os.getTelefone());
            telefone.add(marcadorTelefone);
            telefone.add(textoTelefone);

            Paragraph carro = new Paragraph();
            Chunk marcadorPlaca = new Chunk("Placa do Véiculo: ");
            Chunk placa = new Chunk(os.getPlacaVeiculo());
            Chunk espaco2 = new Chunk("        ");
            Chunk marcadorModelo = new Chunk("Modelo: ");
            Chunk modelo = new Chunk(os.getModelo());
            Chunk marcadorCombustivel = new Chunk("Combustivel: ");
            Chunk combustivel = new Chunk(os.getCombustivel());
            Chunk marcadorAno = new Chunk("ANO:");
            Chunk ano = new Chunk(String.valueOf(os.getAno()));
            Chunk marcadorKm = new Chunk("KM:");
            Chunk km = new Chunk(String.valueOf(os.getKm()));
            carro.add(marcadorPlaca);
            carro.add(placa);
            carro.add(espaco2);
            carro.add(marcadorModelo);
            carro.add(modelo);
            carro.add(espaco2);
            carro.add(marcadorCombustivel);
            carro.add(combustivel);
            carro.add(espaco2);
            carro.add(marcadorAno);
            carro.add(ano);
            carro.add(espaco2);
            carro.add(marcadorKm);
            carro.add(km);

            Paragraph tecnico = new Paragraph();
            Chunk marcadortecnico = new Chunk("Tecnico: ");
            Chunk textoTecnico = new Chunk(os.getTecnico());
            tecnico.add(marcadortecnico);
            tecnico.add(textoTecnico);

            Paragraph id = new Paragraph(new Phrase(25f, "ID da OS = " + os.getId()));

            //tabela de peças a serem usadas
            Paragraph tituloPecas = new Paragraph(new Phrase(20, "Peças a Serem Usadas"));
            tituloPecas.setAlignment(Element.ALIGN_CENTER);

            PdfPTable tabelaPecas = new PdfPTable(3);
            tabelaPecas.setWidthPercentage(100);
            tabelaPecas.setWidths(new float[]{60, 20, 20});

            //celulas da tabela pecas
            Paragraph nomePecas = new Paragraph("NOME");
            nomePecas.setAlignment(Element.ALIGN_CENTER);
            Paragraph quantidadePecas = new Paragraph("QUANTIDADE");
            quantidadePecas.setAlignment(Element.ALIGN_CENTER);
            Paragraph precoPecas = new Paragraph("PREÇO");
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

            double totalPecas = 0.0;
               DecimalFormat formatoValor = new DecimalFormat("#,##0.00");
            for (ListaPecas itens : lista) {
             
                PdfPCell nome = new PdfPCell(new Paragraph(itens.getDescricao()));
                nome.setBorderWidth(2);
                nome.setBorderColor(BaseColor.YELLOW);
                tabelaPecas.addCell(nome);
                PdfPCell quantidade = new PdfPCell(new Paragraph(String.valueOf(itens.getQuantidade())));
                quantidade.setBorderWidth(2);
                quantidade.setBorderColor(BaseColor.YELLOW);
                tabelaPecas.addCell(quantidade);
                PdfPCell preco = new PdfPCell(new Paragraph(String.valueOf(formatoValor.format(itens.getValor()))));
                preco.setBorderWidth(2);
                preco.setBorderColor(BaseColor.YELLOW);
                tabelaPecas.addCell(preco);
                double precoPeca = itens.getValor();
                totalPecas += precoPeca;
            }

            PdfPCell totalCell = new PdfPCell(new Paragraph("Total"));
            totalCell.setColspan(2); // Se você quiser que o total ocupe duas colunas
            totalCell.setBorderWidth(2);
            totalCell.setBorderColor(BaseColor.YELLOW);
            tabelaPecas.addCell(totalCell);

            PdfPCell precoTotalCell = new PdfPCell(new Paragraph(formatoValor.format(totalPecas)));
            precoTotalCell.setBorderWidth(2);
            precoTotalCell.setBorderColor(BaseColor.YELLOW);
            tabelaPecas.addCell(precoTotalCell);

            //adicionando servicos
            Paragraph tituloServicos;
            if (os.getStatus().equals("ANALISE")) {
                tituloServicos = new Paragraph(20, "Serviços a Serem Efetuados");
                tituloServicos.setAlignment(Element.ALIGN_CENTER);
            } else {
                tituloServicos = new Paragraph(20, "Serviços executados");
                tituloServicos.setAlignment(Element.ALIGN_CENTER);
            }

            PdfPTable tabelaServicos = new PdfPTable(2);
            tabelaServicos.setWidthPercentage(80);
            tabelaServicos.setWidths(new float[]{60, 20});

            //celas de serviços
            Paragraph nomeServicos = new Paragraph("NOME");
            nomeServicos.setAlignment(Element.ALIGN_CENTER);
            Paragraph valorServicos = new Paragraph("VALOR");
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
            List<ListaServicos> listaServico = servicoDao.pdfLista(idOs);

            for (ListaServicos item : listaServico) {
                //DecimalFormat formatoValor = new DecimalFormat("#,##0.00");
                PdfPCell celulaNomeS = new PdfPCell(new Paragraph(item.getDescricao()));
                celulaNomeS.setBorderWidth(2);
                celulaNomeS.setBorderColor(new BaseColor(100, 149, 237));
                tabelaServicos.addCell(celulaNomeS);
                PdfPCell celulaValorS = new PdfPCell(new Paragraph(String.valueOf(formatoValor.format(item.getValor()))));
                celulaValorS.setBorderWidth(2);
                celulaValorS.setBorderColor(new BaseColor(100, 149, 237));
                tabelaServicos.addCell(celulaValorS);
            }

            //DecimalFormat formatoValor = new DecimalFormat("#,##0.00");
            Paragraph total = new Paragraph(25);
            Chunk marcadorTotal = new Chunk("TOTAL: ");
            Chunk valorTotal = new Chunk(String.valueOf(formatoValor.format(os.getValor())));
            total.add(marcadorTotal);
            total.add(valorTotal);

            //metodo de pagamento
            Paragraph pagamento = new Paragraph(new Phrase(25, "FORMA DE PAGAMENTO:__________________________"));

            Paragraph assinaturaCliente = new Paragraph(20, "Cliente:____________________________________________________");
            Paragraph assinaturaJpMecanica = new Paragraph(20, "JP MECÂNICA:____________________________________________________");
            
            Paragraph paragraphGarantia = new Paragraph();
            Chunk marcadorGarantia = new Chunk("Garantia: ");
            Chunk garantia = new Chunk(String.valueOf(os.getGarantia()) + " Dias");
            paragraphGarantia.add(marcadorGarantia);
            paragraphGarantia.add(garantia);
            
             Paragraph paragraphDescricao = new Paragraph();
            Chunk marcadorDescricao = new Chunk("Descrição: ");
            Chunk descricao = new Chunk(os.getDescricao());
            paragraphDescricao.add(marcadorDescricao);
            paragraphDescricao.add(descricao);
            
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
            documento.add(paragraphDescricao);
            documento.add(separador);
            documento.add(paragraphGarantia);
            documento.add(total);
            documento.add(linhaEmBranco);
            documento.add(pagamento);
            documento.add(linhaEmBranco);
            documento.add(linhaEmBranco);
            documento.add(assinaturaCliente);
            documento.add(assinaturaJpMecanica);

            //abrindo documento windows
            openFile(pdfPath.toFile());
            //abrindo no linux
            //Runtime.getRuntime().exec(new String[]{"xdg-open", "Os.pdf"});
            //fechando edição
            documento.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        } catch (DocumentException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
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

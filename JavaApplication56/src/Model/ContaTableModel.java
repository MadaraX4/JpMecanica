package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class ContaTableModel extends AbstractTableModel {

    private List<Conta> contas = new ArrayList<>();
    private String[] colunas = {"REFERÊNCIA", "TIPO", "VALOR", "DADA DE VENCIMENTO", "ESTATUS", "DATA DE PAGAMENTO", "VALOR PAGO"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {

        return contas.size();
    }

    @Override
    public int getColumnCount() {

        return colunas.length;
    }

    @Override
    public Object getValueAt(int linhaIndex, int colunaIndex) {
        Conta conta = contas.get(linhaIndex);
        switch (colunaIndex) {

            case 0:
                return contas.get(linhaIndex).getReferencia();
            case 1:
                return contas.get(linhaIndex).getTipo();
            case 2:
                return contas.get(linhaIndex).getValor();
            case 3:
                return contas.get(linhaIndex).getData_vencimento() != null ? conta.getData_vencimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : null;
            case 4:
                return contas.get(linhaIndex).getEstatus();
            case 5:
                return contas.get(linhaIndex).getData_pagamento() != null ? conta.getData_pagamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : null;
            case 6:
                return contas.get(linhaIndex).getValorPago();

        }
        fireTableCellUpdated(linhaIndex, colunaIndex);

        return null;
    }

    @Override
    public void setValueAt(Object valor, int linhaIndex, int colunaIndex) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Conta conta = contas.get(linhaIndex);
        switch (colunaIndex) {

            case 0:
                contas.get(linhaIndex).setReferencia((String) valor);
                break;
            case 1:
                contas.get(linhaIndex).setTipo((String) valor);
                break;
            case 2:
                contas.get(linhaIndex).setValor(Double.parseDouble((String) valor));
                break;
            case 3: {
                try {
                    contas.get(linhaIndex).setData_vencimento(LocalDate.parse(valor.toString(), formatter));
                } catch (DateTimeParseException ex) {
                    Logger.getLogger(ContaTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 4:
                contas.get(linhaIndex).setEstatus((String) valor);
                break;
            case 5: {
                try {
                    contas.get(linhaIndex).setData_pagamento(LocalDate.parse(valor.toString(), formatter));
                } catch (DateTimeParseException ex) {
                    Logger.getLogger(ContaTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case 6: {
               contas.get(linhaIndex).setValorPago(Double.parseDouble(((String) valor).replace(",", ".")));
            }
        }
        this.fireTableRowsUpdated(linhaIndex, linhaIndex);
    }

    public void setContas(List<Conta> novasContas) {
        this.contas.clear(); // Limpa a lista atual
        this.contas.addAll(novasContas); // Adiciona todas as novas contas
        fireTableDataChanged();
    }

    public void addLinha(Conta conta) {
        this.contas.add(conta);
        this.fireTableDataChanged();
    }

    public void removerLinha(int linha) {
        this.contas.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

}

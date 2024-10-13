package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class ContaTableModel extends AbstractTableModel {

    private List<Conta> contas = new ArrayList<>();
    private String[] colunas = {"REFERÊNCIA", "TIPO", "VALOR", "DADA DE VENCIMENTO", "ESTATUS", "DATA DE PAGAMENTO"};

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

        switch (colunaIndex) {

            case 0:
                return contas.get(linhaIndex).getReferencia();
            case 1:
                return contas.get(linhaIndex).getTipo();
            case 2:
                return contas.get(linhaIndex).getValor();
            case 3:
                return contas.get(linhaIndex).getData_vencimento();
            case 4:
                return contas.get(linhaIndex).getEstatus();
            case 5:
                return contas.get(linhaIndex).getData_pagamento();

        }
        fireTableCellUpdated(linhaIndex, colunaIndex);

        return null;
    }

    @Override
    public void setValueAt(Object valor, int linhaIndex, int colunaIndex) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
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
                    contas.get(linhaIndex).setData_vencimento(sdf.parse((String) valor));
                } catch (ParseException ex) {
                    Logger.getLogger(ContaTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 4:
                contas.get(linhaIndex).setEstatus((String) valor);
                break;
            case 5: {
                try {
                    contas.get(linhaIndex).setData_pagamento(sdf.parse((String) valor));
                } catch (ParseException ex) {
                    Logger.getLogger(ContaTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
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

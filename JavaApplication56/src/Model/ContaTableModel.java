package Model;

import java.util.ArrayList;
import java.util.List;
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

    public void setContas(List<Conta> novasContas) {
        this.contas.clear(); // Limpa a lista atual
        this.contas.addAll(novasContas); // Adiciona todas as novas contas
        fireTableDataChanged();
    }

    public void addLinha(Conta conta) {
        this.contas.add(conta);
        this.fireTableDataChanged();
    }

}

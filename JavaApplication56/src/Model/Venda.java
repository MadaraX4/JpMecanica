package Model;

import java.time.LocalDateTime;

public class Venda {

    private LocalDateTime data_venda;
    private double valor_total;

    public Venda(LocalDateTime data_venda, double valor_total) {
        this.data_venda = data_venda;
        this.valor_total = valor_total;

    }

    public LocalDateTime getData_venda() {
        return data_venda;
    }

    public void setData_venda(LocalDateTime data_venda) {
        this.data_venda = data_venda;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

}

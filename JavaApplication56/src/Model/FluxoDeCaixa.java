
package Model;

import java.time.LocalDate;
import java.time.LocalTime;


public class FluxoDeCaixa {
   private String descricao;
   private String tipo;
   private LocalDate dataOperacao;
   private LocalTime horaOperacao;
   private Double valorEntrada;
   private Double valorSaida;

    public FluxoDeCaixa() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(LocalDate dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public LocalTime getHoraOperacao() {
        return horaOperacao;
    }

    public void setHoraOperacao(LocalTime horaOperacao) {
        this.horaOperacao = horaOperacao;
    }

    public Double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(Double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public Double getValorSaida() {
        return valorSaida;
    }

    public void setValorSaida(Double valorSaida) {
        this.valorSaida = valorSaida;
    }

   
}

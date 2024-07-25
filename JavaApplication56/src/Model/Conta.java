package Model;

public class Conta {

    private String referencia;
    private String tipo;
    private double valor;
    private String data_vencimento;
    private boolean paga;

    public Conta(String referencia, String tipo, double valor, String data_vencimento, boolean paga) {
        this.referencia = referencia;
        this.tipo = tipo;
        this.valor = valor;
        this.data_vencimento = data_vencimento;
        this.paga = paga;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    
}

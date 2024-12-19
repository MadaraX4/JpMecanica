package Model;

public class OsPecas {

    private int os_id;
    private String descricao;
    private int quantidade;
    private Double valor;

    public OsPecas(int os_id, String descricao, int quantidade, Double valor) {
        this.os_id = os_id;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getOs_id() {
        return os_id;
    }

    public void setOs_id(int os_id) {
        this.os_id = os_id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}

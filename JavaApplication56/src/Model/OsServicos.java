package Model;


public class OsServicos {

    private int os_id;
private String descricao;
private Double valor;

    public OsServicos(int os_id, String descricao, Double valor) {
        this.os_id = os_id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getOs_id() {
        return os_id;
    }

    public void setOs_id(int os_id) {
        this.os_id = os_id;
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

    

}

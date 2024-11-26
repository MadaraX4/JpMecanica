package Model;

public class OsPecas {

    private int os_id;
    private int id_pecas;
    private int quantidade;

    public OsPecas(int os_id, int id_pecas, int quantidade) {
        this.os_id = os_id;
        this.id_pecas = id_pecas;
        this.quantidade = quantidade;
    }

    public int getOs_id() {
        return os_id;
    }

    public void setOs_id(int os_id) {
        this.os_id = os_id;
    }

    public int getId_pecas() {
        return id_pecas;
    }

    public void setId_pecas(int id_pecas) {
        this.id_pecas = id_pecas;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}

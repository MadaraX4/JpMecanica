package Model;

public class ItensVenda {

    private int id_venda;
    private int id_pecas;
    private int quantidade;

    public ItensVenda(int id_venda, int id_pecas, int quantidade) {
        this.id_venda = id_venda;
        this.id_pecas = id_pecas;
        this.quantidade = quantidade;
    }

  
    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
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

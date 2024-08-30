package Model;

public class Pecas {

    private int id;
    private int cod_identificacao;
    private String nome;
    private String carro;
    private String referencia;
    private int quantidade;
    private double preco_compra;
    private double preco_venda;
    private String fornecedor;

    public Pecas() {
        this.id = id;
        this.cod_identificacao = cod_identificacao;
        this.nome = nome;
        this.carro = carro;
        this.referencia = referencia;
        this.quantidade = quantidade;
        this.preco_compra = preco_compra;
        this.preco_venda = preco_venda;
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public int getCod_identificacao() {
        return cod_identificacao;
    }

    public void setCod_identificacao(int cod_identificacao) {
        this.cod_identificacao = cod_identificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(double preco_compra) {
        this.preco_compra = preco_compra;
    }

    public double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

}

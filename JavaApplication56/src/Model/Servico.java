package Model;

import java.text.DecimalFormat;

public class Servico {

    private int id;
    private String nome;
    private double preco;
   

    public Servico() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.parseDouble(df.format(preco).replace(",", "."));
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nome + " - R$ " + preco; // Formatação que será exibida na JList
    }

}

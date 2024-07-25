
package Model;


public class Ferramenta {
  private String nome; 
  private int quantidade;
  private String usuario;

    public Ferramenta(String nome, int quantidade, String usuario) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
  
  
}

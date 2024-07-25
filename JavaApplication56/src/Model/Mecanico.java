
package Model;


public class Mecanico {
   private String nome;
   private String rg;
   private String cpf;
   private String categoria;
   private String email;
   private String endereco;
   private String referencia;

    public Mecanico(String nome, String rg, String cpf, String categoria, String email, String endereco, String referencia) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.categoria = categoria;
        this.email = email;
        this.endereco = endereco;
        this.referencia = referencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
   
   
}

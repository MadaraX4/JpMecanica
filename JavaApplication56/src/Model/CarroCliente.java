
package Model;


public class CarroCliente {
   private Cliente cliente;
   private Carro carro;

    public CarroCliente(Cliente cliente, Carro carro) {
        this.cliente = cliente;
        this.carro = carro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
   
   
}

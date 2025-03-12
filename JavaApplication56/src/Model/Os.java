
package Model;

import java.time.LocalDate;
import java.util.Date;

public class Os {
    
    private int id;
    private String clienteNome;
    private String telefone;
    private String placaVeiculo;
    private String montadora;
    private String modelo;
    private LocalDate dataOrdem;
    private Double valor;
    private String tecnico;
    private String descricao;
    private String status;
    private LocalDate dataAprovação;
    private String combustivel;
    private Double km;
    private int ano;
    private long garantia;

    public Os() {
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getDataOrdem() {
        return dataOrdem;
    }

    public void setDataOrdem(LocalDate dataOrdem) {
        this.dataOrdem = dataOrdem;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataAprovação() {
        return dataAprovação;
    }

    public void setDataAprovação(LocalDate dataAprovação) {
        this.dataAprovação = dataAprovação;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public Double getKm() {
        return km;
    }

    public void setKm(Double km) {
        this.km = km;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public long getGarantia() {
        return garantia;
    }

    public void setGarantia(long garantia) {
        this.garantia = garantia;
    }
    
    
    
}

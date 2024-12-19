package Model;


import java.time.LocalDate;
import java.util.Date;

public class Carro {

    private String placa;
    private String cpf_proprietario;
    private String modelo;
    private String montadora;
    private String motor;
    private int num_valvulas;
    private int num_cilindros;
    private LocalDate data_manutencao;
    private LocalDate manutencao_agendada;
    private String cobustivel;
    private int ano;
    private String cambio;
    

    public Carro() {
       
    }

    public LocalDate getManutencao_agendada() {
        return manutencao_agendada;
    }

    public void setManutencao_agendada(LocalDate manutencao_agendada) {
        this.manutencao_agendada = manutencao_agendada;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCpf_proprietario() {
        return cpf_proprietario;
    }

    public void setCpf_proprietario(String cpf_proprietario) {
        this.cpf_proprietario = cpf_proprietario;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getNum_valvulas() {
        return num_valvulas;
    }

    public void setNum_valvulas(int num_valvulas) {
        this.num_valvulas = num_valvulas;
    }

    public int getNum_cilindros() {
        return num_cilindros;
    }

    public void setNum_cilindros(int num_cilindros) {
        this.num_cilindros = num_cilindros;
    }

    public LocalDate getData_manutencao() {
        return data_manutencao;
    }

    public void setData_manutencao(LocalDate data_manutencao) {
        this.data_manutencao = data_manutencao;
    }

    public String getCobustivel() {
        return cobustivel;
    }

    public void setCobustivel(String cobustivel) {
        this.cobustivel = cobustivel;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }
    
    
    

}

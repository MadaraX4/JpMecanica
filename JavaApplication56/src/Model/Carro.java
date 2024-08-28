package Model;


import java.util.Date;

public class Carro {

    private String placa;
    private String cpf_proprietario;
    private String modelo;
    private String montadora;
    private String motor;
    private int num_valvulas;
    private int num_cilindros;
    private Date data_manutencao;
    private Date manutencao_agendada;

    public Carro() {
        this.placa = placa;
        this.cpf_proprietario = cpf_proprietario;
        this.modelo = modelo;
        this.montadora = montadora;
        this.motor = motor;
        this.num_valvulas = num_valvulas;
        this.num_cilindros = num_cilindros;
        this.data_manutencao = data_manutencao;
        this.manutencao_agendada = manutencao_agendada;
    }

    public Date getManutencao_agendada() {
        return manutencao_agendada;
    }

    public void setManutencao_agendada(Date manutencao_agendada) {
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

    public Date getData_manutencao() {
        return data_manutencao;
    }

    public void setData_manutencao(Date data_manutencao) {
        this.data_manutencao = data_manutencao;
    }
    

}

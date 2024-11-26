
package Model;
 import java.time.LocalDateTime;

public class OrdemDeServico {
   private LocalDateTime dataHoraOrdem;
   private String descr_pecas;
   private String descr_servico;
   private String tecnico;

    public OrdemDeServico(LocalDateTime dataHoraOrdem, String descr_pecas, String descr_servico, String tecnico) {
        this.dataHoraOrdem = dataHoraOrdem;
        this.descr_pecas = descr_pecas;
        this.descr_servico = descr_servico;
        this.tecnico = tecnico;
    }

    public LocalDateTime getDataHoraOrdem() {
        return dataHoraOrdem;
    }

    public void setDataHoraOrdem(LocalDateTime dataHoraOrdem) {
        this.dataHoraOrdem = dataHoraOrdem;
    }

    public String getDescr_pecas() {
        return descr_pecas;
    }

    public void setDescr_pecas(String descr_pecas) {
        this.descr_pecas = descr_pecas;
    }

    public String getDescr_servico() {
        return descr_servico;
    }

    public void setDescr_servico(String descr_servico) {
        this.descr_servico = descr_servico;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }
   
   
}

package Model;


public class OsServicos {

    private int os_id;
    private int servico_id;

    public OsServicos(int os_id ,int servico_id) {
        this.os_id = os_id;
        this.servico_id = servico_id;
    }

    public int getOs_id() {
        return os_id;
    }

    public void setOs_id(int os_id) {
        this.os_id = os_id;
    }

    public int getServico_id() {
        return servico_id;
    }

    public void setServico_id(int servico_id) {
        this.servico_id = servico_id;
    }

}

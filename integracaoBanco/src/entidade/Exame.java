package entidade;
import java.util.Date;

public class Exame {
    private int idExame;
    private int idPaciente;
    private String descricao;
    private Date dataExame;
    private String resultado;
    private String status;

    public Exame(int idExame, int idPaciente, String descricao, Date dataExame, String resultado, String status) {
        this.idExame = idExame;
        this.idPaciente = idPaciente;
        this.descricao = descricao;
        this.dataExame = dataExame;
        this.resultado = resultado;
        this.status = status;
    }

    // Getters e Setters
    public int getIdExame() {
        return idExame;
    }

    public void setIdExame(int idExame) {
        this.idExame = idExame;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataExame() {
        return dataExame;
    }

    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

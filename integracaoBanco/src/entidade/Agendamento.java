package entidade;
import java.util.Date;

public class Agendamento {
    private int idAgendamento;
    private int idConsulta;
    private Date dataHora;
    private String status;

    public Agendamento(int idAgendamento, int idConsulta, Date dataHora, String status) {
        this.idAgendamento = idAgendamento;
        this.idConsulta = idConsulta;
        this.dataHora = dataHora;
        this.status = status;
    }

    // Getters e Setters
    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

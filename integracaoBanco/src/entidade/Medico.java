package entidade;

public class Medico {
    private int idMedico;
    private String nome;
    private String especialidade;
    private String crm;
    private String telefone;

    public Medico(int idMedico, String nome, String especialidade, String crm, String telefone) {
        this.idMedico = idMedico;
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
        this.telefone = telefone;
    }

    // Getters e Setters
    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

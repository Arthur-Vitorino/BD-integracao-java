package teste;

import DAO.PacienteDAO;
import entidade.Paciente;

import java.util.Date;

public class TestePacienteDAO {
    public static void main(String[] args) {
        PacienteDAO pacienteDAO = new PacienteDAO();

        Paciente novoPaciente = new Paciente(6, "Renata Souza", new Date(), "12345678900", "Rua F, 789", "34567-8900", "Feminino", "Nenhuma");
        pacienteDAO.inserirPaciente(novoPaciente);

        Paciente pacienteObtido = pacienteDAO.obterPaciente(6);
        if (pacienteObtido != null) {
            System.out.println("Paciente obtido: " + pacienteObtido.getNome() + ", CPF: " + pacienteObtido.getCpf());
        }

        pacienteObtido.setNome("Renata Souza Lima");
        pacienteDAO.atualizarPaciente(pacienteObtido);
        System.out.println("Paciente atualizado.");

        pacienteDAO.deletarPaciente(6);
        System.out.println("Paciente deletado.");
    }
}

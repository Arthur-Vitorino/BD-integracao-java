package teste;

import DAO.MedicoDAO;
import entidade.Medico;

public class TesteMedicoDAO {
    public static void main(String[] args) {
        MedicoDAO medicoDAO = new MedicoDAO();

        Medico novoMedico = new Medico(6, "Dr. Pedro Fernandes", "Cardiologista", "678901", "98765-4321");
        medicoDAO.inserirMedico(novoMedico);

        Medico medicoObtido = medicoDAO.obterMedico(6);
        if (medicoObtido != null) {
            System.out.println("Médico obtido: " + medicoObtido.getNome() + ", CRM: " + medicoObtido.getCrm());
        }

        medicoObtido.setNome("Dr. Pedro Fernando Silva");
        medicoDAO.atualizarMedico(medicoObtido);
        System.out.println("Médico atualizado.");

        medicoDAO.deletarMedico(6);
        System.out.println("Médico deletado.");
    }
}

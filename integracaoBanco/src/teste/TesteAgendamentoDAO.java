package teste;

import DAO.AgendamentoDAO;
import entidade.Agendamento;

import java.util.Date;

public class TesteAgendamentoDAO {
    public static void main(String[] args) {
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();

        Agendamento novoAgendamento = new Agendamento(6, 1, new Date(), "Pendente");
        agendamentoDAO.inserirAgendamento(novoAgendamento);

        Agendamento agendamentoObtido = agendamentoDAO.obterAgendamento(6);
        if (agendamentoObtido != null) {
            System.out.println("Agendamento obtido para a consulta: " + agendamentoObtido.getIdConsulta());
        }

        agendamentoObtido.setStatus("Confirmado");
        agendamentoDAO.atualizarAgendamento(agendamentoObtido);
        System.out.println("Agendamento atualizado.");

        agendamentoDAO.deletarAgendamento(6);
        System.out.println("Agendamento deletado.");
    }
}

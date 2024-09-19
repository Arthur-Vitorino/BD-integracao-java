package teste;

import DAO.ConsultaDAO;
import entidade.Consulta;

import java.util.Date;

public class TesteConsultaDAO {
    public static void main(String[] args) {
        ConsultaDAO consultaDAO = new ConsultaDAO();

        Consulta novaConsulta = new Consulta(6, 1, 2, new Date(), "Consulta de retorno");
        consultaDAO.inserirConsulta(novaConsulta);

        Consulta consultaObtida = consultaDAO.obterConsulta(6);
        if (consultaObtida != null) {
            System.out.println("Consulta obtida para o paciente: " + consultaObtida.getIdPaciente());
        }

        consultaObtida.setObservacoes("Consulta de retorno - avaliação completa");
        consultaDAO.atualizarConsulta(consultaObtida);
        System.out.println("Consulta atualizada.");

        consultaDAO.deletarConsulta(6);
        System.out.println("Consulta deletada.");
    }
}

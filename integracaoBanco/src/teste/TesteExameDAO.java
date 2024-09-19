package teste;

import DAO.ExameDAO;
import entidade.Exame;

import java.util.Date;

public class TesteExameDAO {
    public static void main(String[] args) {
        ExameDAO exameDAO = new ExameDAO();

        Exame novoExame = new Exame(6, 1, "Exame de Sangue", new Date(), "Normal", "Concluído");
        exameDAO.inserirExame(novoExame);

        Exame exameObtido = exameDAO.obterExame(6);
        if (exameObtido != null) {
            System.out.println("Exame obtido para o paciente: " + exameObtido.getIdPaciente());
        }

        exameObtido.setResultado("Leve alteração");
        exameDAO.atualizarExame(exameObtido);
        System.out.println("Exame atualizado.");

        exameDAO.deletarExame(6);
        System.out.println("Exame deletado.");
    }
}

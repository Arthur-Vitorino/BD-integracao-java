package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.conexao;
import entidade.Medico;

public class MedicoDAO {

    public void inserirMedico(Medico medico) {
        String sql = "INSERT INTO Medico (ID_Medico, Nome, Especialidade, CRM, Telefone) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, medico.getIdMedico());
            stmt.setString(2, medico.getNome());
            stmt.setString(3, medico.getEspecialidade());
            stmt.setString(4, medico.getCrm());
            stmt.setString(5, medico.getTelefone());

            stmt.executeUpdate();
            System.out.println("Médico inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Medico obterMedico(int id) {
        String sql = "SELECT * FROM Medico WHERE ID_Medico = ?";
        Medico medico = null;

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                medico = new Medico(
                        rs.getInt("ID_Medico"),
                        rs.getString("Nome"),
                        rs.getString("Especialidade"),
                        rs.getString("CRM"),
                        rs.getString("Telefone")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medico;
    }

    public void atualizarMedico(Medico medico) {
        String sql = "UPDATE Medico SET Nome = ?, Especialidade = ?, CRM = ?, Telefone = ? WHERE ID_Medico = ?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getEspecialidade());
            stmt.setString(3, medico.getCrm());
            stmt.setString(4, medico.getTelefone());
            stmt.setInt(5, medico.getIdMedico());

            stmt.executeUpdate();
            System.out.println("Médico atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarMedico(int id) {
        String sql = "DELETE FROM Medico WHERE ID_Medico = ?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Médico deletado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

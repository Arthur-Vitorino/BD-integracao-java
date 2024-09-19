package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.conexao;
import entidade.Consulta;

public class ConsultaDAO {

    public void inserirConsulta(Consulta consulta) {
        String sql = "INSERT INTO Consulta (ID_Consulta, ID_Paciente, ID_Medico, Data_Consulta, Observacoes) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, consulta.getIdConsulta());
            stmt.setInt(2, consulta.getIdPaciente());
            stmt.setInt(3, consulta.getIdMedico());
            stmt.setDate(4, new Date(consulta.getDataConsulta().getTime()));
            stmt.setString(5, consulta.getObservacoes());

            stmt.executeUpdate();
            System.out.println("Consulta inserida com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Consulta obterConsulta(int id) {
        String sql = "SELECT * FROM Consulta WHERE ID_Consulta = ?";
        Consulta consulta = null;

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                consulta = new Consulta(
                        rs.getInt("ID_Consulta"),
                        rs.getInt("ID_Paciente"),
                        rs.getInt("ID_Medico"),
                        rs.getDate("Data_Consulta"),
                        rs.getString("Observacoes")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consulta;
    }

    public void atualizarConsulta(Consulta consulta) {
        String sql = "UPDATE Consulta SET ID_Paciente = ?, ID_Medico = ?, Data_Consulta = ?, Observacoes = ? WHERE ID_Consulta = ?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, consulta.getIdPaciente());
            stmt.setInt(2, consulta.getIdMedico());
            stmt.setDate(3, new Date(consulta.getDataConsulta().getTime()));
            stmt.setString(4, consulta.getObservacoes());
            stmt.setInt(5, consulta.getIdConsulta());

            stmt.executeUpdate();
            System.out.println("Consulta atualizada com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarConsulta(int id) {
        String sql = "DELETE FROM Consulta WHERE ID_Consulta = ?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Consulta deletada com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

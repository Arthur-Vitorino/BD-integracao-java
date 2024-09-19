package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import conexao.conexao;
import entidade.Agendamento;

public class AgendamentoDAO {

    public void inserirAgendamento(Agendamento agendamento) {
        String sql = "INSERT INTO Agendamento (ID_Agendamento, ID_Consulta, Data_Hora, Status) VALUES (?, ?, ?, ?)";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, agendamento.getIdAgendamento());
            stmt.setInt(2, agendamento.getIdConsulta());
            stmt.setTimestamp(3, new Timestamp(agendamento.getDataHora().getTime()));
            stmt.setString(4, agendamento.getStatus());

            stmt.executeUpdate();
            System.out.println("Agendamento inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Agendamento obterAgendamento(int id) {
        String sql = "SELECT * FROM Agendamento WHERE ID_Agendamento = ?";
        Agendamento agendamento = null;

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                agendamento = new Agendamento(
                        rs.getInt("ID_Agendamento"),
                        rs.getInt("ID_Consulta"),
                        rs.getTimestamp("Data_Hora"),
                        rs.getString("Status")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agendamento;
    }

    public void atualizarAgendamento(Agendamento agendamento) {
        String sql = "UPDATE Agendamento SET ID_Consulta = ?, Data_Hora = ?, Status = ? WHERE ID_Agendamento = ?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, agendamento.getIdConsulta());
            stmt.setTimestamp(2, new Timestamp(agendamento.getDataHora().getTime()));
            stmt.setString(3, agendamento.getStatus());
            stmt.setInt(4, agendamento.getIdAgendamento());

            stmt.executeUpdate();
            System.out.println("Agendamento atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarAgendamento(int id) {
        String sql = "DELETE FROM Agendamento WHERE ID_Agendamento = ?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Agendamento deletado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

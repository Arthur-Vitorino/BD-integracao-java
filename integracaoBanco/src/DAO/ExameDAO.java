package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.conexao;
import entidade.Exame;

public class ExameDAO {

    public void inserirExame(Exame exame) {
        String sql = "INSERT INTO Exame (ID_Exame, ID_Paciente, Descricao, Data_Exame, Resultado, Status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, exame.getIdExame());
            stmt.setInt(2, exame.getIdPaciente());
            stmt.setString(3, exame.getDescricao());
            stmt.setDate(4, new Date(exame.getDataExame().getTime()));
            stmt.setString(5, exame.getResultado());
            stmt.setString(6, exame.getStatus());

            stmt.executeUpdate();
            System.out.println("Exame inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Exame obterExame(int id) {
        String sql = "SELECT * FROM Exame WHERE ID_Exame = ?";
        Exame exame = null;

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                exame = new Exame(
                        rs.getInt("ID_Exame"),
                        rs.getInt("ID_Paciente"),
                        rs.getString("Descricao"),
                        rs.getDate("Data_Exame"),
                        rs.getString("Resultado"),
                        rs.getString("Status")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exame;
    }

    public void atualizarExame(Exame exame) {
        String sql = "UPDATE Exame SET ID_Paciente = ?, Descricao = ?, Data_Exame = ?, Resultado = ?, Status = ? WHERE ID_Exame = ?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, exame.getIdPaciente());
            stmt.setString(2, exame.getDescricao());
            stmt.setDate(3, new Date(exame.getDataExame().getTime()));
            stmt.setString(4, exame.getResultado());
            stmt.setString(5, exame.getStatus());
            stmt.setInt(6, exame.getIdExame());

            stmt.executeUpdate();
            System.out.println("Exame atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarExame(int id) {
        String sql = "DELETE FROM Exame WHERE ID_Exame = ?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Exame deletado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

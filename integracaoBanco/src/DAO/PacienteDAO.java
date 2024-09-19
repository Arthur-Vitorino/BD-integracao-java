package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.conexao;
import entidade.Paciente;

public class PacienteDAO {

    public void inserirPaciente(Paciente paciente) {
        String sql = "INSERT INTO Paciente (ID_Paciente, Nome, Data_Nascimento, CPF, Endereco, Telefone, Genero, Alergias) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, paciente.getIdPaciente());
            stmt.setString(2, paciente.getNome());
            stmt.setDate(3, new Date(paciente.getDataNascimento().getTime()));
            stmt.setString(4, paciente.getCpf());
            stmt.setString(5, paciente.getEndereco());
            stmt.setString(6, paciente.getTelefone());
            stmt.setString(7, paciente.getGenero());
            stmt.setString(8, paciente.getAlergias());

            stmt.executeUpdate();
            System.out.println("Paciente inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Paciente obterPaciente(int id) {
        String sql = "SELECT * FROM Paciente WHERE ID_Paciente = ?";
        Paciente paciente = null;

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                paciente = new Paciente(
                        rs.getInt("ID_Paciente"),
                        rs.getString("Nome"),
                        rs.getDate("Data_Nascimento"),
                        rs.getString("CPF"),
                        rs.getString("Endereco"),
                        rs.getString("Telefone"),
                        rs.getString("Genero"),
                        rs.getString("Alergias")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }

    public void atualizarPaciente(Paciente paciente) {
        String sql = "UPDATE Paciente SET Nome = ?, Data_Nascimento = ?, CPF = ?, Endereco = ?, Telefone = ?, Genero = ?, Alergias = ? WHERE ID_Paciente = ?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, paciente.getNome());
            stmt.setDate(2, new Date(paciente.getDataNascimento().getTime()));
            stmt.setString(3, paciente.getCpf());
            stmt.setString(4, paciente.getEndereco());
            stmt.setString(5, paciente.getTelefone());
            stmt.setString(6, paciente.getGenero());
            stmt.setString(7, paciente.getAlergias());
            stmt.setInt(8, paciente.getIdPaciente());

            stmt.executeUpdate();
            System.out.println("Paciente atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarPaciente(int id) {
        String sql = "DELETE FROM Paciente WHERE ID_Paciente = ?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Paciente deletado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

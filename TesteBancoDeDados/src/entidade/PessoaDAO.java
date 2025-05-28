package entidade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    public void criar(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome, email) VALUES (?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.executeUpdate();
            System.out.println("Pessoa inserida!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pessoa> listar() {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";
        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
                pessoas.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    public void atualizar(Pessoa pessoa) {
        String sql = "UPDATE pessoa SET nome = ?, email = ? WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.setInt(3, pessoa.getId());
            stmt.executeUpdate();
            System.out.println("Pessoa atualizada!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM pessoa WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Pessoa deletada!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


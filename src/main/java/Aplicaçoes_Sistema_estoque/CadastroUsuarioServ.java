package Aplicaçoes_Sistema_estoque;
import ConexaoBD.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroUsuarioServ {

    public void adicionaUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getSenha());
            pstmt.executeUpdate();
            System.out.println("Usuário adicionado com sucesso.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Usuário com email " + email + " não encontrado.");
        return null;
    }

    public boolean registrarUsuario(Usuario novoUsuario) {
        if (buscarUsuarioPorEmail(novoUsuario.getEmail()) == null) {
            adicionaUsuario(novoUsuario);
            return true;
        } else {
            System.out.println("Email já registrado.");
            return false;
        }
    }
}

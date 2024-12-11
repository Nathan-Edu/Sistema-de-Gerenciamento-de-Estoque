package Aplicaçoes_Sistema_estoque;
import ConexaoBD.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroRequisicaoServ {

    public void adicionaRequisicao(Requisicao requisicao) {
        String sql = "INSERT INTO requisicoes (id_usuario, id_material, quantidade) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, requisicao.getId_usuario());
            pstmt.setInt(2, requisicao.getId_material());
            pstmt.setInt(3, requisicao.getQuantidade());
            pstmt.executeUpdate();
            System.out.println("Requisição adicionada com sucesso.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

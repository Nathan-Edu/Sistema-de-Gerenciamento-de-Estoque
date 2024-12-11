package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/estoque";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createTables() {
        String sqlUsuarios = "CREATE TABLE IF NOT EXISTS usuarios ("
                + "id_usuario INT PRIMARY KEY AUTO_INCREMENT,"
                + "nome VARCHAR(255) NOT NULL,"
                + "email VARCHAR(255) NOT NULL UNIQUE,"
                + "senha VARCHAR(255) NOT NULL,"
                + "data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                + ");";

        String sqlProduto = "CREATE TABLE IF NOT EXISTS produtos ("
                + "id_material INT PRIMARY KEY,"
                + "descricao_curta VARCHAR(255),"
                + "descricao_longa TEXT,"
                + "quantidade INT,"
                + "unidade_medida VARCHAR(50),"
                + "deposito VARCHAR(100)"
                + ");";

        String sqlMovimentacao = "CREATE TABLE IF NOT EXISTS movimentacoes ("
                + "id INT PRIMARY KEY AUTO_INCREMENT,"
                + "id_material INT,"
                + "tipo_acao VARCHAR(50),"
                + "quantidade INT,"
                + "datahora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                + "FOREIGN KEY (id_material) REFERENCES produtos(id_material)"
                + ");";

        String sqlRequisicoes = "CREATE TABLE IF NOT EXISTS requisicoes ("
                + "id_requisicao INT PRIMARY KEY AUTO_INCREMENT,"
                + "id_usuario INT,"
                + "id_material INT,"
                + "quantidade INT,"
                + "datahora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                + "FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),"
                + "FOREIGN KEY (id_material) REFERENCES produtos(id_material)"
                + ");";

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sqlUsuarios);
            stmt.execute(sqlProduto);
            stmt.execute(sqlMovimentacao);
            stmt.execute(sqlRequisicoes);
            System.out.println("Tabelas criadas com sucesso.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


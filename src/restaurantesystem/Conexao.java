package restaurantesystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe utilitária para conexão com o banco de dados MySQL.
 *
 * @author Pedro Seudo Valenti e Henry Guilherme Barbosa de Araujo
 */
public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/Restaurante";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static Connection getConexao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC não encontrado.", e);
        }
    }
}

package restaurantesystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe DAO para operações de Pedido no banco de dados.
 *
 * @author Pedro Seudo Valenti e Henry Guilherme Barbosa de Araujo
 */
public class PedidoDAO {
    public void inserirPedido(Pedido pedido) throws SQLException {
        String sql = "INSERT INTO Pedidos (prato, bebida, observacoes, mesa) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pedido.getPrato());
            stmt.setString(2, pedido.getBebida());
            stmt.setString(3, pedido.getObservacoes());
            stmt.setInt(4, pedido.getMesa());
            stmt.executeUpdate();
        }
    }
}

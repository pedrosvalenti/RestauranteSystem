package restaurantesystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDAO {
    public void salvar(Pedido pedido) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurante", "root", "");
        String sql = "INSERT INTO pedidos (prato, bebida, observacoes, mesa) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, pedido.getPrato());
        stmt.setString(2, pedido.getBebida());
        stmt.setString(3, pedido.getObservacoes());
        stmt.setInt(4, pedido.getMesa());
        stmt.executeUpdate();
        con.close();
    }
}

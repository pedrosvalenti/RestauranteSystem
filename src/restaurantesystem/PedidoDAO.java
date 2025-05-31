package restaurantesystem;

import java.sql.*;
import java.util.List;

public class PedidoDAO {
    public void salvar(Pedido pedido) throws Exception {
        Connection con = Conexao.getConnection();
        try {
            con.setAutoCommit(false);
            String sqlPedido = "INSERT INTO pedidos (id_cliente, mesa, observacoes) VALUES (?, ?, ?)";
            PreparedStatement stmtPedido = con.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);
            stmtPedido.setInt(1, pedido.getCliente().getId());
            stmtPedido.setInt(2, pedido.getMesa());
            stmtPedido.setString(3, pedido.getObservacoes());
            stmtPedido.executeUpdate();
            ResultSet rs = stmtPedido.getGeneratedKeys();
            int idPedido = 0;
            if (rs.next()) {
                idPedido = rs.getInt(1);
            }
            rs.close();
            stmtPedido.close();

            String sqlPedidoProduto = "INSERT INTO pedido_produto (id_pedido, id_produto) VALUES (?, ?)";
            PreparedStatement stmtPedidoProduto = con.prepareStatement(sqlPedidoProduto);
            for (Produto produto : pedido.getProdutos()) {
                stmtPedidoProduto.setInt(1, idPedido);
                stmtPedidoProduto.setInt(2, produto.getId());
                stmtPedidoProduto.executeUpdate();
            }
            stmtPedidoProduto.close();
            con.commit();
        } catch (Exception e) {
            con.rollback();
            throw e;
        } finally {
            con.setAutoCommit(true);
            con.close();
        }
    }
}

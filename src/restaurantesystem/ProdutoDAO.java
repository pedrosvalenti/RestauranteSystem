package restaurantesystem;

import java.sql.*;
import java.util.*;

public class ProdutoDAO {
    public void inserir(Produto produto) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "INSERT INTO produto (nome, preco) VALUES (?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, produto.getNome());
        stmt.setDouble(2, produto.getPreco());
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public void atualizar(Produto produto) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "UPDATE produto SET nome=?, preco=? WHERE id=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, produto.getNome());
        stmt.setDouble(2, produto.getPreco());
        stmt.setInt(3, produto.getId());
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public void excluir(int id) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "DELETE FROM produto WHERE id=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public Produto buscarPorId(int id) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "SELECT * FROM produto WHERE id=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Produto produto = null;
        if (rs.next()) {
            produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getDouble("preco"));
        }
        rs.close();
        stmt.close();
        con.close();
        return produto;
    }

    public List<Produto> listarTodos() throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "SELECT * FROM produto";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Produto> lista = new ArrayList<>();
        while (rs.next()) {
            Produto produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getDouble("preco"));
            lista.add(produto);
        }
        rs.close();
        stmt.close();
        con.close();
        return lista;
    }
}

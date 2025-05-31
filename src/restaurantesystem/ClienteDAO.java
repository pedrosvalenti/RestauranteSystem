package restaurantesystem;

import java.sql.*;
import java.util.*;

public class ClienteDAO {
    public void inserir(Cliente cliente) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "INSERT INTO cliente (nome, telefone) VALUES (?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getTelefone());
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public void atualizar(Cliente cliente) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "UPDATE cliente SET nome=?, telefone=? WHERE id=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getTelefone());
        stmt.setInt(3, cliente.getId());
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public void excluir(int id) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "DELETE FROM cliente WHERE id=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public Cliente buscarPorId(int id) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "SELECT * FROM cliente WHERE id=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Cliente cliente = null;
        if (rs.next()) {
            cliente = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"));
        }
        rs.close();
        stmt.close();
        con.close();
        return cliente;
    }

    public List<Cliente> listarTodos() throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "SELECT * FROM cliente";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Cliente> lista = new ArrayList<>();
        while (rs.next()) {
            Cliente cliente = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"));
            lista.add(cliente);
        }
        rs.close();
        stmt.close();
        con.close();
        return lista;
    }
}

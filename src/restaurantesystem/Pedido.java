package restaurantesystem;

import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Produto> produtos;
    private String observacoes;
    private int mesa;

    public Pedido(int id, Cliente cliente, List<Produto> produtos, String observacoes, int mesa) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = produtos;
        this.observacoes = observacoes;
        this.mesa = mesa;
    }

    // Construtor antigo para compatibilidade
    public Pedido(String prato, String bebida, String observacoes, int mesa) {
        this.id = 0;
        this.cliente = null;
        this.produtos = null;
        this.observacoes = observacoes;
        this.mesa = mesa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }
}

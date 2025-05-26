package restaurantesystem;

/**
 * Classe que representa um Pedido.
 *
 * @author Pedro Seudo Valenti e Henry Guilherme Barbosa de Araujo
 */
public class Pedido {
    private int id;
    private String prato;
    private String bebida;
    private String observacoes;
    private int mesa;

    public Pedido(String prato, String bebida, String observacoes, int mesa) {
        this.prato = prato;
        this.bebida = bebida;
        this.observacoes = observacoes;
        this.mesa = mesa;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getPrato() { return prato; }
    public void setPrato(String prato) { this.prato = prato; }
    public String getBebida() { return bebida; }
    public void setBebida(String bebida) { this.bebida = bebida; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
    public int getMesa() { return mesa; }
    public void setMesa(int mesa) { this.mesa = mesa; }
}

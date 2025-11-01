import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido {

    private List<Produto> produtos;
    private StatusPedido status;

    private final String id;
    private Cliente cliente;


    public Pedido(Cliente cliente) {
        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.status = StatusPedido.PENDENTE;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }


    public void cancelar() {
        if (status == StatusPedido.PENDENTE) {
            status = StatusPedido.CANCELADO;
        }
    }


    public void pagar() {
        if (status == StatusPedido.PENDENTE) {
            status = StatusPedido.PAGO;
        }
    }

    public String getId() {
        return this.id;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public StatusPedido getStatus() {
        return this.status;
    }
}

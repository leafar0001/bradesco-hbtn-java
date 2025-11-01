import java.util.HashMap;
import java.util.Map;

public class PedidoRepository {

    private final Map<String, Pedido> pedidos = new HashMap<>();

public Pedido buscarPorId(String id) {
        return pedidos.get(id);
    }

    public void salvar(Pedido pedido) {
        pedidos.put(pedido.getId(), pedido);



    }

    
}

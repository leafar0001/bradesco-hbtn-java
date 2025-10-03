import java.util.List;
import java.util.stream.Collectors;

public class Consulta {

    // Método existente: obter livros
    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        return pedido.getProdutos()
                     .stream()
                     .filter(p -> p.getCategoria() == CategoriaProduto.LIVRO)
                     .collect(Collectors.toList());
    }

    // Método existente: obter produto maior preço
    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        return produtos.stream()
                       .max((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco()))
                       .orElse(null);
    }

    // Método existente: obter produtos por preço mínimo
    public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {
        return produtos.stream()
                       .filter(p -> p.getPreco() >= precoMinimo)
                       .collect(Collectors.toList());
    }

    // Novo método: obter pedidos que possuem pelo menos um produto eletrônico
    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {
        return pedidos.stream()
                      .filter(pedido -> pedido.getProdutos()
                                              .stream()
                                              .anyMatch(p -> p.getCategoria() == CategoriaProduto.ELETRONICO))
                      .collect(Collectors.toList());
    }
}

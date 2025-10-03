import java.util.List;
import java.util.stream.Collectors;

public class Consulta {

    // Método existente: obter livros do pedido
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

    // Método existente: obter pedidos com produtos eletrônicos
    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {
        return pedidos.stream()
                      .filter(pedido -> pedido.getProdutos()
                                              .stream()
                                              .anyMatch(prod -> prod.getCategoria() == CategoriaProduto.ELETRONICO))
                      .collect(Collectors.toList());
    }

    // Novo método: aplicar 15% de desconto nos eletrônicos
    public static List<Produto> aplicar15PorcentoDescontoEletronicos(List<Produto> produtos) {
        return produtos.stream()
                       .map(prod -> {
                           if (prod.getCategoria() == CategoriaProduto.ELETRONICO) {
                               // aplica 15% de desconto
                               prod.setPreco(prod.getPreco() * 0.85);
                           }
                           return prod;
                       })
                       .collect(Collectors.toList());
    }
}

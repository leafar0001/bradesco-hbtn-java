import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Consulta {

    // Método existente: obtém livros do pedido
    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        return pedido.getProdutos()
                     .stream()
                     .filter(p -> p.getCategoria() == CategoriaProduto.LIVRO)
                     .collect(Collectors.toList());
    }

    // Método existente: obtém o produto com maior preço
    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        return produtos.stream()
                       .max(Comparator.comparing(Produto::getPreco))
                       .orElse(null); // Retorna null se lista vazia
    }

    // Novo método: obtém produtos com preço maior ou igual ao preço mínimo
    public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {
        return produtos.stream()
                       .filter(p -> p.getPreco() >= precoMinimo)
                       .collect(Collectors.toList());
    }
}

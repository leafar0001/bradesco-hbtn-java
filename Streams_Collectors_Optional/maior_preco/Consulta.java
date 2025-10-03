import java.util.Comparator;
import java.util.List;

public class Consulta {

    // Método já existente para obter livros
    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        return pedido.getProdutos()
                     .stream()
                     .filter(p -> p.getCategoria() == CategoriaProduto.LIVRO)
                     .toList();
    }

    // Novo método para obter o produto com maior preço
    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        return produtos.stream()
                       .max(Comparator.comparing(Produto::getPreco))
                       .orElse(null); // Retorna null caso a lista seja vazia
    }
}

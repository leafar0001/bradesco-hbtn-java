import produtos.Produto;
import produtos.Livro;
import produtos.Dvd;
import java.util.Locale;

public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getProduto().obterPrecoLiquido() * item.getQuantidade();
        }
        return total * (1 - percentualDesconto / 100.0);
    }

    public void apresentarResumoPedido() {
        double totalProdutos = 0.0;

        System.out.println("------- RESUMO PEDIDO -------");
        for (ItemPedido item : itens) {
            Produto p = item.getProduto();
            double preco = p.obterPrecoLiquido();
            int qtd = item.getQuantidade();
            double totalItem = preco * qtd;
            totalProdutos += totalItem;

            String tipo = (p instanceof Livro) ? "Livro" : (p instanceof Dvd ? "Dvd" : "Produto");
            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n",
                    tipo, p.getTitulo(), preco, qtd, totalItem);
        }
        totalProdutos = totalProdutos;
        double desconto = totalProdutos * percentualDesconto/ 100.0;
        double totalPedido = (totalProdutos - desconto) / 100.0;
        System.out.println("----------------------------");
        System.out.printf("DESCONTO: %.2f\n", desconto);
        System.out.printf("TOTAL PRODUTOS: %.2f\n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f\n", totalPedido);
        System.out.println("----------------------------");
    }
}

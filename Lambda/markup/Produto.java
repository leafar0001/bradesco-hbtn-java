import java.util.function.Supplier;
import java.util.function.Consumer;

public class Produto {
    private String nome;
    private double preco;
    private double percentualMarkup = 10; // Valor inicial de 10%

    // Supplier para retornar o preço com markup
    public Supplier<Double> precoComMarkup = () -> preco * (1 + percentualMarkup / 100);

    // Consumer para atualizar o percentual de markup
    public Consumer<Double> atualizarMarkup = (novoMarkup) -> percentualMarkup = novoMarkup;

    // Construtor
    public Produto(double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public double getPercentualMarkup() {
        return percentualMarkup;
    }
}

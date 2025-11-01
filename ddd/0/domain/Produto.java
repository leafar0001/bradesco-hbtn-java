import java.math.BigDecimal;
import java.util.Objects;


public class Produto {

    private final BigDecimal preco;

    private final String nome;


    public Produto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }


    public String getNome() {
        return nome;
    }


    public BigDecimal getPreco() {
        return this.preco;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome);
    }


    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
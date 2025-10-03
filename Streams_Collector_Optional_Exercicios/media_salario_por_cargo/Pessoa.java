import java.util.*;
import java.util.stream.Collectors;

class Pessoa implements Comparable<Pessoa> {
    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

   public int getIdade() {   
        return idade;
    }

public double getSalario() {
    return salario;
}

    @Override
    public int compareTo(Pessoa outra) {
        // Ordena pelo código, conforme a saída desejada
        return Integer.compare(this.codigo, outra.codigo);
    }

    @Override
    public String toString() {
        return String.format("[%d] %s %s %d R$ %.6f", codigo, nome, cargo, idade, salario);
    }
}

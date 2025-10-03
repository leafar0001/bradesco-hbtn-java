import java.util.*;
import java.util.stream.Collectors;

// Classe Pessoa
class Pessoa {
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

    @Override
    public String toString() {
        String salarioFormatado = String.format("%.6f", salario).replace('.', ',');
        return "[" + codigo + "] " + nome + " " + cargo + " " + idade + " R$ " + salarioFormatado;
    }
}
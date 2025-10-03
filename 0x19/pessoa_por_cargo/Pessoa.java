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

    @Override
    public String toString() {
        return "[" + codigo + "] " + nome + " " + cargo + " " + idade + " R$ " + salario;
    }
}

// Classe ConsultaPessoas
class ConsultaPessoas {
    public static Map<String, List<Pessoa>> obterPessoasPorCargo(List<Pessoa> pessoas) {
        return pessoas.stream()
                      .collect(Collectors.groupingBy(Pessoa::getCargo));
    }
}

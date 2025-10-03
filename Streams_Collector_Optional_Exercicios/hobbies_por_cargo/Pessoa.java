import java.util.List;

public class Pessoa {
    private int id;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;
    private List<String> hobbies;   // novo atributo

    public Pessoa(int id, String nome, String cargo, int idade, double salario, List<String> hobbies) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
        this.hobbies = hobbies;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
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

    public List<String> getHobbies() {
        return hobbies;
    }
}

import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {
    private List<Aluno> alunos;

    public GestaoAlunos() {
        alunos = new ArrayList<>();
    }

    public void adicionarAluno(String nome, int idade) {
        alunos.add(new Aluno(nome, idade));
        System.out.println("Aluno adicionado: " + nome);
    }

    public void excluirAluno(String nome) {
        boolean removido = alunos.removeIf(aluno -> aluno.getNome().equalsIgnoreCase(nome));
        if (removido) {
            System.out.println("Aluno removido: " + nome);
        } else {
            System.out.println("Aluno não encontrado para remoção: " + nome);
        }
    }

    public void buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Aluno encontrado: " + aluno);
                return;
            }
        }
        System.out.println("Aluno não encontrado: " + nome);
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Lista de Alunos:");
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }

    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();

        // Adicionando alunos
        gestao.adicionarAluno("João", 20);
        gestao.adicionarAluno("Maria", 22);
        gestao.adicionarAluno("Pedro", 19);

        // Listando todos
        gestao.listarAlunos();

        // Buscando um aluno
        gestao.buscarAluno("Maria");

        // Excluindo um aluno
        gestao.excluirAluno("João");

        // Tentando excluir um aluno que não existe
        gestao.excluirAluno("Lucas");

        // Buscando um aluno que não existe
        gestao.buscarAluno("Lucas");

        // Listando novamente
        gestao.listarAlunos();
    }
}

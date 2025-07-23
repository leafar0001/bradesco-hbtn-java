import java.io.*;
import java.util.*;

public class Estoque {
    private List<Produto> produtos = new ArrayList<>();
    private String arquivo;

    public Estoque(String arquivo) {
        this.arquivo = arquivo;
        carregarProdutos();
    }

    private void carregarProdutos() {
        produtos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 4) {
                    int id = Integer.parseInt(dados[0]);
                    String nome = dados[1];
                    int quantidade = Integer.parseInt(dados[2]);
                    double preco = Double.parseDouble(dados[3]);
                    produtos.add(new Produto(id, nome, quantidade, preco));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar produtos: " + e.getMessage());
        }
    }

    private void salvarProdutos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Produto p : produtos) {
                bw.write(p.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }

    private int gerarNovoId() {
        int maxId = 0;
        for (Produto p : produtos) {
            if (p.getId() > maxId) {
                maxId = p.getId();
            }
        }
        return maxId + 1;
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        int id = gerarNovoId();
        Produto novo = new Produto(id, nome, quantidade, preco);
        produtos.add(novo);
        salvarProdutos();
        System.out.println("Produto adicionado com sucesso.");
    }

    public void excluirProduto(int id) {
        boolean removido = produtos.removeIf(p -> p.getId() == id);
        if (removido) {
            salvarProdutos();
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void exibirEstoque() {
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    public void atualizarQuantidade(int id, int novaQuantidade) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                salvarProdutos();
                System.out.println("Quantidade atualizada com sucesso.");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }
}

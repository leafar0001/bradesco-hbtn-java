public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes = new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    // implementar o método de buscaLinear com tratamento de exceção
    public void buscaLinear(String nome){
        if (nome == null) {
            throw new IllegalArgumentException("O nome fornecido é nulo.");
        }

        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] != null && nomes[i].equalsIgnoreCase(nome.trim())) {
                System.out.println("Nome " + nome + " encontrado na posição " + i);
                return;
            }
        }

        throw new IllegalArgumentException("Nome " + nome + " não encontrado na lista.");
    }
}
public class Program {

    public static void main(String[] args) {
        PessoasArray p = new PessoasArray();

        try {
            p.buscaLinear("Otavio");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            p.buscaLinear("Isabela");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            p.buscaLinear("Anderson");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
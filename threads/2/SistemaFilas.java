// Classe principal SistemaFilas
public class SistemaFilas {
    public static void main(String[] args) {
        Fila fila = new Fila(10); // Fila com capacidade para 10 itens

        // Cria 2 produtores e 2 consumidores
        Produtor produtor1 = new Produtor(fila);
        Produtor produtor2 = new Produtor(fila);
        Consumidor consumidor1 = new Consumidor(fila);
        Consumidor consumidor2 = new Consumidor(fila);

        // Inicia as threads
        produtor1.start();
        produtor2.start();
        consumidor1.start();
        consumidor2.start();

        // Executa por 20 segundos
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Encerrando o sistema...");
        System.exit(0);
    }
}

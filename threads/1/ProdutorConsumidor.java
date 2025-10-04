public class ProdutorConsumidor {
    public static void main(String[] args) {
        // Cria o buffer compartilhado
        Buffer buffer = new Buffer();

        // Cria o produtor e o consumidor
        Produtor produtor = new Produtor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        // Inicia as threads
        produtor.start();
        consumidor.start();

        // Aguarda as threads terminarem
        try {
            produtor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Produção e consumo finalizados.");
    }
}

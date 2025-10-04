public class Principal {
    public static void main(String[] args) {
        // Instancia o contador
        Contador contador = new Contador();

        // Cria duas threads que irão incrementar o contador
        Thread t1 = new ThreadContador(contador);
        Thread t2 = new ThreadContador(contador);

        // Inicia as threads
        t1.start();
        t2.start();

        // Aguarda as threads terminarem
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Imprime o valor final do contador
        System.out.println("Valor final do contador: " + contador.getContagem());
    }
}

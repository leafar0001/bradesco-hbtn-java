// Classe Consumidor
class Consumidor extends Thread {
    private Fila fila;

    public Consumidor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int numero = fila.retirar(); // Retira item da fila
                // Simula o processamento do item por 500ms
                System.out.println("Consumidor processando: " + numero);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

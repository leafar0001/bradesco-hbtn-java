// Classe Produtor
class Produtor extends Thread {
    private Fila fila;
    private Random random = new Random();

    public Produtor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int numero = random.nextInt(100) + 1; // Gera número entre 1 e 100
                fila.adicionar(numero);
                Thread.sleep(1000); // Simula tempo de produção
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


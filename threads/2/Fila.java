import java.util.LinkedList;
import java.util.Random;

// Classe Fila com capacidade limitada
class Fila {
    private LinkedList<Integer> lista = new LinkedList<>();
    private int capacidade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
    }

    // Adiciona item à fila
    public synchronized void adicionar(int item) throws InterruptedException {
        while (lista.size() >= capacidade) {
            wait(); // Espera se a fila estiver cheia
        }
        lista.add(item);
        System.out.println("Produtor adicionou: " + item);
        notifyAll(); // Notifica consumidores que há um item disponível
    }

    // Retira item da fila
    public synchronized int retirar() throws InterruptedException {
        while (lista.isEmpty()) {
            wait(); // Espera se a fila estiver vazia
        }
        int item = lista.removeFirst();
        System.out.println("Consumidor retirou: " + item);
        notifyAll(); // Notifica produtores que há espaço disponível
        return item;
    }
}


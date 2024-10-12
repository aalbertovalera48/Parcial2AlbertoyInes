package CampanaGauss;

import java.util.concurrent.BlockingQueue;

public class LineaEnsamblaje implements Runnable {
    private final BlockingQueue<Componente> buffer;

    public LineaEnsamblaje(BlockingQueue<Componente> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Componente componente = buffer.take();  // Tomar componente del buffer
                System.out.println("Consumido: " + componente.getTipo());
                // Lógica de ensamblaje aquí
                Thread.sleep(1000);  // Simula tiempo de ensamblaje
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

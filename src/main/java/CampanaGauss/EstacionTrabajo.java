package CampanaGauss;

import java.util.concurrent.BlockingQueue;

public class EstacionTrabajo implements Runnable {
    private final BlockingQueue<Componente> buffer;
    private final String tipoComponente;

    public EstacionTrabajo(BlockingQueue<Componente> buffer, String tipoComponente) {
        this.buffer = buffer;
        this.tipoComponente = tipoComponente;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Componente componente = new Componente(tipoComponente);
                buffer.put(componente);  // Poner componente en el buffer
                System.out.println("Producido: " + tipoComponente);
                Thread.sleep(500); // Simula tiempo de producción
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

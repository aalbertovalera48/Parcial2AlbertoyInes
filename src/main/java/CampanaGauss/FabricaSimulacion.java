package CampanaGauss;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FabricaSimulacion {
    public static void main(String[] args) {
        BlockingQueue<Componente> buffer = new ArrayBlockingQueue<>(10);

        // Crear estaciones de trabajo (productores) y línea de ensamblaje (consumidor)
        EstacionTrabajo estacion1 = new EstacionTrabajo(buffer, "Clavo");
        EstacionTrabajo estacion2 = new EstacionTrabajo(buffer, "Bola");
        LineaEnsamblaje ensamblaje = new LineaEnsamblaje(buffer);

        // Crear un ExecutorService con un número fijo de hilos
        ExecutorService executorService = Executors.newFixedThreadPool(3); // 2 productores + 1 consumidor

        // Enviar las estaciones de trabajo y la línea de ensamblaje al pool de hilos
        executorService.submit(estacion1);
        executorService.submit(estacion2);
        executorService.submit(ensamblaje);

        // Agregar un shutdown para cerrar el ExecutorService correctamente
        try {
            executorService.shutdown();
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

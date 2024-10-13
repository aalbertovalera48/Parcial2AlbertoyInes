package GaltonSpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Controller
public class SimulacionController {
    private final TableroGalton1 board;
    private final ExecutorService executor;

    public SimulacionController() {
        this.board = new TableroGalton1(11); // 11 contenedores
        this.executor = Executors.newFixedThreadPool(4); // Pool de hilos
    }

    @GetMapping("/simulacion")
    public String simulacion() {
        return "simulacion";
    }

    @GetMapping("/simular")
    @ResponseBody
    public int[] simular(@RequestParam int numBalls) {
        for (int i = 0; i < numBalls; i++) {
            executor.execute(new Pelota1(board)); // Ejecutar la caída de cada bola
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return board.getBins(); // Devolver los resultados
    }
}
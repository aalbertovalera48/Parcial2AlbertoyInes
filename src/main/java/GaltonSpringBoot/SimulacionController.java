package GaltonSpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class SimulacionController {
    private final TableroGalton1 board;
    private final ExecutorService executor;

    public SimulacionController() {
        this.board = new TableroGalton1(11); // 11 contenedores
        this.executor = Executors.newFixedThreadPool(4); // Pool de hilos
    }

    @GetMapping("/")
    public String simulacion(Model model) {
        return "simulacion";
    }

    @GetMapping("/simular")
    @ResponseBody
    public int[] simular(int numBalls) {
        for (int i = 0; i < numBalls; i++) {
            executor.execute(new Pelota1(board)); // Ejecutar la caída de cada bola
        }

        return board.getBins(); // Devolver los resultados
    }
}


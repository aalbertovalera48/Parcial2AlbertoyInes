
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimulacionController {

    @GetMapping("/simulacion")
    public String iniciarSimulacion() {
        // Lógica para iniciar la simulación
        return "Simulación iniciada";
    }
}
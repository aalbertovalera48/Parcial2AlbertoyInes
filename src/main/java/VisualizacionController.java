
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class VisualizacionController {

    @GetMapping(value = "/visualizacion", produces = "text/event-stream")
    public Flux<String> streamBolas() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> "Bola " + sequence + " cayó en el contenedor");
    }
}
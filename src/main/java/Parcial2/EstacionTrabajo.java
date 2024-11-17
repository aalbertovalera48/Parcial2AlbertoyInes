package Parcial2;

import CampanaGauss.Componente;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
@Component
public class EstacionTrabajo {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final String tipoComponente;
    private final String queueName;

    public EstacionTrabajo(String tipoComponente, String queueName) {
        this.tipoComponente = tipoComponente;
        this.queueName = queueName;
    }

    @PostConstruct
    public void startProducing() {
        Flux.interval(Duration.ofMillis(500))
                .publishOn(Schedulers.boundedElastic())
                .subscribe(i -> {
                    Componente componente = new Componente(tipoComponente);
                    rabbitTemplate.convertAndSend(queueName, componente);
                    System.out.println("Producido: " + tipoComponente);
                });
    }
}
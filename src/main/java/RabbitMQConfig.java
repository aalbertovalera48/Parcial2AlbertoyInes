
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue ensamblajeQueue() {
        return new Queue("ensamblajeQueue", false);
    }

    @Bean
    public EstacionTrabajo estacion1() {
        return new EstacionTrabajo("Clavo", "ensamblajeQueue");
    }

    @Bean
    public EstacionTrabajo estacion2() {
        return new EstacionTrabajo("Bola", "ensamblajeQueue");
    }
}
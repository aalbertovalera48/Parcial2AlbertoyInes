package Parcial2;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SimulacionGalton2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RabbitMQConfig.class);
        RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);

        int numBalls = 1000;
        for (int i = 0; i < numBalls; i++) {
            rabbitTemplate.convertAndSend("simulacionQueue", "Ball " + i);
            try {
                Thread.sleep(10); // Interval between each ball for visualization
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Keep the application context open
        synchronized (SimulacionGalton2.class) {
            try {
                SimulacionGalton2.class.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
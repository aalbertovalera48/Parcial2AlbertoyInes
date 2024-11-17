package Parcial2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PelotaConsumer {

    @RabbitListener(queues = "simulacionQueue")
    public void consumeMessage(String message) {
        System.out.println("Received: " + message);

        String[] parts = message.split(" ");
        int ballNumber = Integer.parseInt(parts[1]);

        int bin = ballNumber % 11;
        updateDistribution(bin);
    }

    private void updateDistribution(int bin) {
        System.out.println("Ball placed in bin: " + bin);
        // Add your logic to update the distribution here
    }
}
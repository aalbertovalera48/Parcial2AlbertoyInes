package Parcial2;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PelotaProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final String queueName = "simulacionQueue";

    public void sendBallMessage(int ballNumber) {
        String message = "Ball " + ballNumber;
        rabbitTemplate.convertAndSend(queueName, message);
        System.out.println("Sent: " + message);
    }
}
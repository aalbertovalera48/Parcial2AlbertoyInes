package Parcial2;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimulacionController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/simular")
    public String simular(@RequestParam int numBalls) {
        for (int i = 0; i < numBalls; i++) {
            rabbitTemplate.convertAndSend("simulacionQueue", "Ball " + i);
        }
        return "Simulación iniciada con " + numBalls + " bolas.";
    }
}

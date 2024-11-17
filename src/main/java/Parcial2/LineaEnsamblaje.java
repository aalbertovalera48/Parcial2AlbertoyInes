package Parcial2;

import CampanaGauss.Componente;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class LineaEnsamblaje {

    @RabbitListener(queues = "ensamblajeQueue")
    public void consumeComponent(Componente componente) {
        System.out.println("Consumido: " + componente.getTipo());
        // Lógica de ensamblaje aquí
        try {
            // Simula el tiempo de ensamblaje
            Thread.sleep(1000);
            System.out.println("Ensamblado: " + componente.getTipo());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Error en el ensamblaje del componente: " + componente.getTipo());
        }
    }
}
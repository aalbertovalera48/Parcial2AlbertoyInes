package Parcial2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SimulacionGaltonVista {
    private static final int NUM_BALLS = 110;
    private static int ballsDropped = 0;
    private static Timer timer;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Distribución Normal en Tiempo Real");
        VisualizacionDistribucion panel = new VisualizacionDistribucion();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(600, 400);
        frame.setVisible(true);

        // Simulación de actualización de la distribución
        timer = new Timer(100, e -> {
            if (ballsDropped < NUM_BALLS) {
                panel.actualizarDistribucion(simularCaidaBola());
                ballsDropped++;
            } else {
                timer.stop();
            }
        });
        timer.start();
    }

    private static int simularCaidaBola() {
        Random random = new Random();
        int posicion = 5; // Comienza en el centro
        for (int i = 0; i < 10; i++) {
            posicion += random.nextBoolean() ? 1 : -1;
        }
        return Math.max(0, Math.min(10, posicion)); // Asegura que esté dentro de los límites
    }
}
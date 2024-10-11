package Galton;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulacionGalton {
    public static void main(String[] args) {
        int numBins = 11;
        int numBalls = 1000;
        int rows = 10;

        // Crear el tablero de Galton
        TableroGalton board = new TableroGalton(numBins);
        GraficoDistribucion grafico = new GraficoDistribucion(numBins); // Crear el gráfico

        // Configurar el marco de la ventana
        JFrame frame = new JFrame("Tablero de Galton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(board, BorderLayout.CENTER);
        frame.add(grafico, BorderLayout.SOUTH); // Añadir el gráfico en la parte inferior
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Ejecutar bolas concurrentemente para simular la caída
        ExecutorService executor = Executors.newFixedThreadPool(4);  // Usa 4 hilos en el pool
        for (int i = 0; i < numBalls; i++) {
            Pelota pelota = new Pelota(board, rows, grafico); // Pasar el gráfico a la pelota
            executor.execute(pelota);
            try {
                Thread.sleep(10); // Intervalo entre cada bola para visualización
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        executor.shutdown();
    }
}

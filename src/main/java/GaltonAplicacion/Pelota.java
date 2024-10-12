package GaltonAplicacion;

import java.awt.*;
import java.util.Random;

public class Pelota implements Runnable {
    private final TableroGalton board;
    private final int rows;
    private final GraficoDistribucion grafico; // Añadir el gráfico
    private final Random random;

    public Pelota(TableroGalton board, int rows, GraficoDistribucion grafico) {
        this.board = board;
        this.rows = rows;
        this.grafico = grafico; // Inicializar el gráfico
        this.random = new Random();
    }

    @Override
    public void run() {
        int x = board.getWidth() / 2;
        int y = 30; // Comienza en la parte superior

        // Caída simulada a través de los clavos
        for (int i = 0; i < rows; i++) {
            x += (random.nextBoolean() ? 1 : -1) * 10; // Desplazamiento aleatorio izquierda/derecha
            y += 30;
            board.addBallPosition(new Point(x, y));  // Actualiza la posición de la bola para la visualización

            try {
                Thread.sleep(100);  // Simula la caída lenta para la visualización
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Determinar el contenedor final y añadir la bola allí
        int bin = x / (board.getWidth() / board.getNumBins());
        board.addToBin(bin);

        // Actualizar el gráfico con la cantidad de bolas en cada contenedor
        grafico.setBins(board.getBins()); // Pasar los bins al gráfico
    }
}

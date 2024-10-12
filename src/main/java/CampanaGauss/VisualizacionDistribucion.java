package CampanaGauss;

import javax.swing.*;
import java.awt.*;

public class VisualizacionDistribucion extends JPanel {
    private int[] contenedores = new int[10];

    public VisualizacionDistribucion() {
        Timer timer = new Timer(100, e -> repaint()); // Actualizar cada 100 ms
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < contenedores.length; i++) {
            g.fillRect(50 * i, 300 - contenedores[i] * 10, 40, contenedores[i] * 10);
        }
    }

    public void actualizarDistribucion(int contenedor) {
        contenedores[contenedor]++;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Distribución Normal en Tiempo Real");
        VisualizacionDistribucion panel = new VisualizacionDistribucion();
        frame.add(panel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Simulación de actualización de contenedores
        new Thread(() -> {
            while (true) {
                int contenedorAleatorio = (int) (Math.random() * 10);
                panel.actualizarDistribucion(contenedorAleatorio);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}

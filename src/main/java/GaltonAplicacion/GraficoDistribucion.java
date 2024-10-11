package Galton;

import javax.swing.*;
import java.awt.*;

public class GraficoDistribucion extends JPanel {
    private final int[] bins;
    private int maxValue;

    public GraficoDistribucion(int numBins) {
        this.bins = new int[numBins];
        this.maxValue = 0;
        setPreferredSize(new Dimension(600, 200));
    }

    public void setBins(int[] bins) {
        System.arraycopy(bins, 0, this.bins, 0, bins.length);
        this.maxValue = findMaxValue(bins);
        repaint();
    }

    private int findMaxValue(int[] bins) {
        int max = 0;
        for (int bin : bins) {
            if (bin > max) {
                max = bin;
            }
        }
        return max;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth() / bins.length;
        int height = getHeight();

        // Dibujar las barras del gráfico
        for (int i = 0; i < bins.length; i++) {
            int barHeight = (int) ((double) bins[i] / maxValue * height);
            g.setColor(Color.BLUE);
            g.fillRect(i * width, height - barHeight, width, barHeight);
            g.setColor(Color.BLACK);
            g.drawRect(i * width, height - barHeight, width, barHeight);
        }
    }
}

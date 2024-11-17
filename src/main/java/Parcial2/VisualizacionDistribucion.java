package Parcial2;

import javax.swing.*;
import java.awt.*;

public class VisualizacionDistribucion extends JPanel {
    private final int[] bins;
    private int maxValue;

    public VisualizacionDistribucion() {
        this.bins = new int[11]; // Assuming 11 bins
        this.maxValue = 0;
        setPreferredSize(new Dimension(600, 200));
    }

    public void actualizarDistribucion(int bin) {
        if (bin >= 0 && bin < bins.length) {
            bins[bin]++;
            maxValue = Math.max(maxValue, bins[bin]);
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth() / bins.length;
        int height = getHeight();

        for (int i = 0; i < bins.length; i++) {
            int barHeight = (int) ((double) bins[i] / maxValue * height);
            g.setColor(Color.BLUE);
            g.fillRect(i * width, height - barHeight, width, barHeight);
            g.setColor(Color.BLACK);
            g.drawRect(i * width, height - barHeight, width, barHeight);
        }
    }
}

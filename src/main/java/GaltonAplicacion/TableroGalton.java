package GaltonAplicacion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TableroGalton extends JPanel {
    private final int numBins;
    private final int[] bins;
    private final List<Point> ballPositions; // Almacena las posiciones de las bolas mientras caen

    public TableroGalton(int numBins) {
        this.numBins = numBins;
        this.bins = new int[numBins];
        this.ballPositions = new ArrayList<>();
        setPreferredSize(new Dimension(600, 400));
    }
    public int[] getBins() {
        return bins.clone(); // Devuelve una copia de los bins
    }

    // Método para acceder a numBins desde fuera
    public int getNumBins() {
        return numBins;
    }

    // Método para agregar la posición de una bola
    public synchronized void addBallPosition(Point position) {
        ballPositions.add(position);
        repaint();
    }

    // Método para mover la bola a un contenedor
    public synchronized void addToBin(int bin) {
        bins[bin]++;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar los clavos en el tablero
        g.setColor(Color.BLACK);
        int rows = 10;
        int clavoSeparacion = getWidth() / (numBins + 1);
        for (int row = 1; row <= rows; row++) {
            int y = row * 30;
            for (int i = 0; i < row; i++) {
                int x = (getWidth() / 2) - (row / 2) * clavoSeparacion + i * clavoSeparacion;
                g.fillOval(x, y, 8, 8);  // Dibujar el clavo como un pequeño círculo
            }
        }

        // Dibujar las bolas mientras caen
        g.setColor(Color.RED);
        for (Point position : ballPositions) {
            g.fillOval(position.x, position.y, 10, 10);
        }

        // Dibujar los contenedores en la parte inferior
        g.setColor(Color.BLUE);
        int baseY = getHeight() - 50;
        for (int i = 0; i < numBins; i++) {
            int x = i * clavoSeparacion + clavoSeparacion / 2;
            g.drawRect(x, baseY, clavoSeparacion, 50);
            g.drawString(Integer.toString(bins[i]), x + clavoSeparacion / 4, baseY + 25);
        }
    }
}

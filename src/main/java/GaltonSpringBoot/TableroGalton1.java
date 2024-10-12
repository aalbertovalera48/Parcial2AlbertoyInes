package GaltonSpringBoot;


import java.util.Random;

public class TableroGalton1 {
    private final int numBins;
    private final int[] bins;
    private final Random random;

    public TableroGalton1(int numBins) {
        this.numBins = numBins;
        this.bins = new int[numBins];
        this.random = new Random();
    }

    public void addToBin(int bin) {
        if (bin >= 0 && bin < numBins) {
            bins[bin]++;
        }
    }

    public int[] getBins() {
        return bins.clone(); // Devuelve una copia de los bins
    }

    public int getNumBins() {
        return numBins;
    }

    public int dropBall() {
        // Simula la caída de una bola y devuelve en qué contenedor cae
        int position = 0;
        for (int i = 0; i < 10; i++) { // Suponiendo 10 filas de clavos
            position += (random.nextBoolean() ? 1 : -1);
        }
        return Math.max(0, Math.min(numBins - 1, position)); // Asegura que esté dentro de los límites
    }
}


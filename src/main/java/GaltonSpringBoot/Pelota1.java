package GaltonSpringBoot;

public class Pelota1 implements Runnable {
    private final TableroGalton1 board;

    public Pelota1(TableroGalton1 board) {
        this.board = board;
    }

    @Override
    public void run() {
        int bin = board.dropBall(); // La bola cae y se obtiene el bin
        board.addToBin(bin); // Añadir a la colección
    }
}


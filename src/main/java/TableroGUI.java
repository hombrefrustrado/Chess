import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import piezas.*;
public class TableroGUI extends JPanel {
        private final int TILE_SIZE = 64; // Tamaño de cada casilla
        private final int BOARD_SIZE = 8; // Tamaño del tablero
        private Tablero tablero;

        public TableroGUI() {
            setPreferredSize(new Dimension(TILE_SIZE * BOARD_SIZE, TILE_SIZE * BOARD_SIZE));
        }

        public void setTablero(Tablero tablero) {
            this.tablero = tablero;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (tablero == null) return;

            Pieza[][] piezas = tablero.getTablero();
            for (int row = 0; row < BOARD_SIZE; row++) {
                for (int col = 0; col < BOARD_SIZE; col++) {
                    boolean isWhite = (row + col) % 2 == 0;
                    g.setColor(isWhite ? Color.WHITE : Color.GRAY);
                    g.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);

                    Pieza pieza = piezas[row][col];
                    if (pieza != null) {
                        BufferedImage image = loadImage(pieza);
                        g.drawImage(image, col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
                    }
                }
            }
        }

        private BufferedImage loadImage(Pieza pieza) {
            String fileName = getFileName(pieza);
            try {
                return ImageIO.read(new File("assets/" + fileName));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }


    private String getFileName(Pieza pieza) {
        // Devuelve el nombre del archivo basado en el tipo y color de la pieza
        String ruta = "src/main/java/assets/";
        String color = pieza.getColor() == piezas.color.blanco ? "" : "Negro";
        if (pieza instanceof Torre) return ruta + "Torre" + color + ".png";
        if (pieza instanceof Caballo) return ruta + "Caballo" + color + ".png";
        if (pieza instanceof Alfil) return ruta + "Alfil" + color + ".png";
        if (pieza instanceof Dama) return ruta + "Reina" + color + ".png";
        if (pieza instanceof Rey) return ruta + "Rey" + color + ".png";
        if (pieza instanceof Peon) return ruta + "Peon" + color + ".png";
        return "";
    }

}

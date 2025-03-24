
import piezas.*;
import java.util.Scanner;

public class Tablero {
        Pieza[][] tablero;
        color ultimoColorEmpleado;
        boolean partidaTerminada=false;
        private TableroGUI tableroGUI;
    public Tablero(){
        tablero = new Pieza[][]{{new Torre(color.blanco), new Caballo(color.blanco), new Alfil(color.blanco), new Dama(color.blanco), new Rey(color.blanco), new Alfil(color.blanco)  , new Caballo(color.blanco),new Torre(color.blanco)},
                {new Peon(color.blanco),new Peon(color.blanco),new Peon(color.blanco),new Peon(color.blanco),new Peon(color.blanco),new Peon(color.blanco),new Peon(color.blanco),new Peon(color.blanco)},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {new Peon(color.negro),new Peon(color.negro),new Peon(color.negro),new Peon(color.negro),new Peon(color.negro),new Peon(color.negro),new Peon(color.negro),new Peon(color.negro)},
                {new Torre(color.negro), new Caballo(color.negro), new Alfil(color.negro), new Dama(color.negro), new Rey(color.negro), new Alfil(color.negro)  , new Caballo(color.negro),new Torre(color.negro)},
        };
    }

    public void setUltimoColorEmpleado(color ultimoColorEmpleado) {
        this.ultimoColorEmpleado = ultimoColorEmpleado;
    }

    public int obtenerNumero(String a){

        return switch (a) {
            case "a" -> 0;
            case "b" -> 1;
            case "c" -> 2;
            case "d" -> 3;
            case "e" -> 4;
            case "f" -> 5;
            case "g" -> 6;
            case "h" -> 7;
            default -> throw new IllegalArgumentException("La letras que has introducido no es valida");
        };
    }
        public void mover(String letraOriginal, int numeroOriginal, String letraLlegada, int numeroLlegada){
            movimiento(letraOriginal,numeroOriginal-1,letraLlegada,numeroLlegada-1);
        }

        public void movimiento(String letraOriginal, int numeroOriginal, String letraLlegada, int numeroLlegada){
                color coloractual;
                try {
                    Pieza pieza = tablero[numeroOriginal][obtenerNumero(letraOriginal)];
                    if (pieza == null) {
                        throw new IllegalArgumentException("No hay ninguna pieza en la posición de origen.");
                    }

                    coloractual = pieza.getColor();
                    if(letraOriginal.equals(letraLlegada) && numeroOriginal==numeroLlegada){
                        throw new IllegalArgumentException("Debes mover la pieza");
                    }
                    if(coloractual==ultimoColorEmpleado){
                        throw new IllegalArgumentException("No intentes mover dos veces");
                    }
                    if (!pieza.mover(obtenerNumero(letraOriginal), numeroOriginal, obtenerNumero(letraLlegada), numeroLlegada, tablero)) {
                        throw new IllegalArgumentException("Movimiento invalido");
                    }
                    tablero[numeroOriginal][obtenerNumero(letraOriginal)]=null;
                    tablero[numeroLlegada][pieza.obtenerNumero(letraLlegada)] = pieza;
                    ultimoColorEmpleado=pieza.getColor();

                } catch (Exception e) {
                    System.out.println("Asegurate de que has introduce adecuadamente los estamentos: "+e.getMessage());
                }
        }


    @Override
    public String toString() {
        String piezas="";
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(tablero[i][j]!=null){
                    piezas+=tablero[i][j].pieza();
                }else{
                    piezas+=" ";
                }
            }
            piezas+="\n";
        }
        return piezas;
    }

       public static void main(String[] args) {
            Tablero tablero1 = new Tablero();
            tablero1.ultimoColorEmpleado=color.negro;
                try(Scanner teclado = new Scanner(System.in)){
                    for (int i = 0; i<100;i++){
                    String letraoriginal = teclado.next();
                    int numeroOriginal = teclado.nextInt();
                    String letraLlegada=teclado.next();
                    int numeroLlegada = teclado.nextInt();
                    tablero1.mover(letraoriginal,numeroOriginal,letraLlegada,numeroLlegada);
                    System.out.println(tablero1.toString());
                    }
                }
        }
    public void setTableroGUI(TableroGUI tableroGUI) {
        this.tableroGUI = tableroGUI;
    }

    public Pieza[][] getTablero() {
    return tablero;
    }
}

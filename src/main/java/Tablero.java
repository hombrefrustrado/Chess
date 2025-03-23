
import piezas.*;

import javax.swing.*;
import java.util.Arrays;
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
/*
    public Tablero(TableroGUI tableroGUI) {
        this.tableroGUI = tableroGUI;
        tablero = new Pieza[][]{
                {new Torre(color.blanco), new Caballo(color.blanco), new Alfil(color.blanco), new Dama(color.blanco), new Rey(color.blanco), new Alfil(color.blanco), new Caballo(color.blanco), new Torre(color.blanco)},
                {new Peon(color.blanco),new Peon(color.blanco),new Peon(color.blanco),new Peon(color.blanco),new Peon(color.blanco),new Peon(color.blanco),new Peon(color.blanco),new Peon(color.blanco)},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {new Peon(color.negro),new Peon(color.negro),new Peon(color.negro),new Peon(color.negro),new Peon(color.negro),new Peon(color.negro),new Peon(color.negro),new Peon(color.negro)},
                {new Torre(color.negro), new Caballo(color.negro), new Alfil(color.negro), new Dama(color.negro), new Rey(color.negro), new Alfil(color.negro), new Caballo(color.negro),new Torre(color.negro)},
        };
    }
*/
    public void setUltimoColorEmpleado(color ultimoColorEmpleado) {
        this.ultimoColorEmpleado = ultimoColorEmpleado;
    }

    public int obtenerNumero(String a){

        switch (a){
            case "a": return 0;
            case "b": return 1;
            case "c": return 2;
            case "d": return 3;
            case "e": return 4;
            case "f": return 5;
            case "g": return 6;
            case "h": return 7;
            default: throw new IllegalArgumentException("La letras que has introducido no es valida");
        }

    }
        public void mover(String letraOriginal, int numeroOriginal, String letraLlegada, int numeroLlegada){
            movimiento(letraOriginal,numeroOriginal-1,letraLlegada,numeroLlegada-1);
            //actualizarTablero();
        }
        public void movimiento(String letraOriginal, int numeroOriginal, String letraLlegada, int numeroLlegada){
                color coloractual;
                try {
                        Pieza pieza = tablero[numeroOriginal][obtenerNumero(letraOriginal)];
                        coloractual = pieza.getColor();

                        if((letraOriginal==letraLlegada) && (numeroOriginal==numeroLlegada)){
                            throw new Exception("Debes mover la pieza");
                        }
                        if(coloractual!=ultimoColorEmpleado){
                            int deltax = obtenerNumero(letraLlegada)-obtenerNumero(letraOriginal);
                            int deltay = numeroLlegada-numeroOriginal;
                            if(pieza.mover(obtenerNumero(letraOriginal),numeroOriginal,obtenerNumero(letraLlegada),numeroLlegada,tablero)){
                                tablero[numeroOriginal][obtenerNumero(letraOriginal)]=null;
                                tablero[numeroLlegada][pieza.obtenerNumero(letraLlegada)] = pieza;
                                ultimoColorEmpleado=pieza.getColor();
                            }else{
                                throw new Exception("Movimiento invalido");
                            }
                        }else{
                            throw new Exception("No intentes mover dos veces");
                        }
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

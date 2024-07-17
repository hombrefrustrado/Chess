
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
        int i = 0;
        switch (a){
            case "a":
                i=0;
                break;
            case "b":
                i=1;
                break;
            case "c":
                i=2;
                break;
            case "d":
                i=3;
                break;
            case "e":
                i=4;
                break;
            case "f":
                i=5;
                break;
            case "g":
                i=6;
                break;
            case "h":
                i=7;
                break;
        }
        return i;
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
    /*public void usarTeclado(){

    }*/
    /*
    public void actualizarTablero() {

        tableroGUI.repaint();
    }*/
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
    /*
       public static void main(String[] args) {
           JFrame frame = new JFrame("Tablero de Ajedrez");

           TableroGUI tableroGUI = new TableroGUI();
           Tablero tablero = new Tablero();
           tablero.setTableroGUI(tableroGUI);
           tableroGUI.setTablero(tablero);

           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.add(tableroGUI);
           frame.pack();
           frame.setLocationRelativeTo(null);
           frame.setVisible(true);
       }*/
    public void setTableroGUI(TableroGUI tableroGUI) {
        this.tableroGUI = tableroGUI;
    }

    public Pieza[][] getTablero() {
    return tablero;
    }
}

package piezas;
import java.math.*;
public class Alfil extends Pieza{

    public Alfil(color piel) {
        super(piel);
    }

    @Override
    public boolean mover(int origenX, int origenY, int destinoX, int destinoY, Pieza[][] tablero) {
        boolean Medio=enMedio(origenX,origenY,destinoX,destinoY,tablero);
        return moverDelta(destinoX-origenX,destinoY-origenY)&&(!Medio);
    }


    @Override
    public boolean moverDelta(int ejex, int ejey) {
        return Math.abs(ejex) == Math.abs(ejey) && ejex!=0;
    }
    public boolean enMedio(int origenX, int origenY, int destinoX, int destinoY,Pieza[][] tablero){
        int ejex=destinoX-origenX;
        int ejey=destinoY-origenY;
        int auxOrigenX = origenX;
        int auxOrigenY = origenY;
        int desplazamientoX,desplazamientoY;
        if(ejex>0){
            desplazamientoX = 1;
        }else{
            desplazamientoX = -1;
        }
        if(ejey>0){
            desplazamientoY=1;
        }else{
            desplazamientoY=-1;
        }
        for(int i = 1; i<Math.abs(ejex);i++){
            auxOrigenX+=desplazamientoX;
            auxOrigenY+=desplazamientoY;
            if(tablero[origenY][origenX]==null){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "A"+super.toString();
    }

    @Override
    public String pieza() {
        if(piel.equals(color.blanco)){
            return "♗";
        }else{
            return "♝";
        }
    }
}

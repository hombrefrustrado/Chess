package piezas;
import java.math.*;
public class Alfil extends Pieza{

    public Alfil(color piel) {
        super(piel);
    }

    @Override
    public boolean mover(int origenX, int origenY, int destinoX, int destinoY, Pieza[][] tablero) {
        return false;
    }


    @Override
    public boolean moverDelta(int ejex, int ejey) {
        return Math.abs(ejex) == Math.abs(ejey) && ejex!=0;
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

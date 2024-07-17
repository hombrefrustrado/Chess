package piezas;

public class Rey extends Pieza{
    public Rey(color piel) {
        super(piel);
    }

    @Override
    public boolean mover(int origenX, int origenY, int destinoX, int destinoY, Pieza[][] tablero) {
        Pieza original = tablero[origenY][origenX];
        Pieza captura = tablero[destinoY][destinoX];
        return  captura==null || captura.getColor()!=original.getColor() ? moverDelta(destinoX-origenX,destinoY-origenY):false;
        //pendiente de cambio

    }

    @Override
    public boolean moverDelta(int ejex, int ejey) {
        return Math.abs(ejex)<=1 && Math.abs(ejey)<=1;
    }

    @Override
    public String pieza() {
        if(piel.equals(color.blanco)){
            return "♔";
        }else {
            return "♚";
        }
    }
}

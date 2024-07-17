package piezas;

public class Torre extends Pieza{

    public Torre(color piel) {
        super(piel);
    }

    @Override
    public boolean mover(int origenX, int origenY, int destinoX, int destinoY, Pieza[][] tablero) {
        Pieza original = tablero[origenY][origenX];
        Pieza captura = tablero[destinoY][destinoX];
        return  captura==null || captura.getColor()!=original.getColor() ? moverDelta(destinoX-origenX,destinoY-origenY):false;
    }
    @Override
    public boolean moverDelta(int ejex, int ejey) {
        return (ejex)==0 || (ejey)==0;
    }

    @Override
    public String toString(){
        return "T"+super.toString();
    }

    @Override
    public String pieza() {
        if(piel.equals(color.blanco)){
        return "♖";
        }else {
            return "♜";
        }
    }
}

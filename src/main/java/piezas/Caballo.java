package piezas;

public class Caballo extends Pieza{
    public Caballo(color piel) {
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
        int x = Math.abs(ejex);
        int y = Math.abs(ejey);
        return ((x==2) && (y==1)) || ((x==1)&&(y==2));
    }

    @Override
    public String pieza() {
        if(piel.equals(color.blanco)){
            return "♘";
        }else {
            return "♞";
        }
    }
}

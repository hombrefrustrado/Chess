package piezas;

public class Peon extends Pieza{
    private boolean movido=false;

    public Peon(color piel){
        super(piel);
    }

    @Override
    public boolean mover(int origenX, int origenY, int destinoX, int destinoY, Pieza[][] tablero) {
        Pieza original = tablero[origenY][origenX];
        Pieza captura = tablero[destinoY][destinoX];
        int ejex = destinoX-origenX;
        int ejey = destinoY-origenY;
        if(captura==null){
            return moverDelta(ejex,ejey);
        } else{
            if(piel==color.negro){
                ejey=-ejey;
            }
            if(Math.abs(ejex)==1&&ejey==1){
                return true;
            }
        }
        return false;
        //pendiente de cambio
    }

    @Override
    public boolean moverDelta(int ejex, int ejey) {
        if(piel==color.negro){
            ejey=-ejey;
        }
        if( ejey<=2 && ejey>=0 && ejex==0){
            if(!movido){
                movido=true;
                return true;
            } else if (ejey<2) {
                return true;
            }
        }
        //si hay algo a los lados debe detectarlo
        return false;
    }

    @Override
    public String pieza() {
        if(piel.equals(color.blanco)){
            return "♙";
        }else {
            return "♟";
        }
    }
}

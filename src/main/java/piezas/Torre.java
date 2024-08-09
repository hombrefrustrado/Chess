package piezas;

public class Torre extends Pieza{

    public Torre(color piel) {
        super(piel);
    }

    @Override
    public boolean mover(int origenX, int origenY, int destinoX, int destinoY, Pieza[][] tablero) {
        boolean hayAlgoEnMedio=enMedio(origenX,origenY,destinoX,destinoY,tablero);
        Pieza original = tablero[origenY][origenX];
        Pieza captura = tablero[destinoY][destinoX];
        return (!hayAlgoEnMedio) && (captura==null || captura.getColor()!=original.getColor()) ? moverDelta(destinoX-origenX,destinoY-origenY):false;
    }
    @Override
    public boolean moverDelta(int ejex, int ejey) {
        return (ejex)==0 || (ejey)==0;
    }

    @Override
    public boolean enMedio(int origenX, int origenY, int destinoX, int destinoY,Pieza[][] tablero){

        if(origenX<destinoX){
            for(int i = origenX+1; i < destinoX; i++){
                if(tablero[origenY][i]!=null){
                    return true;
                }
            }
        }
        else{
            for(int i = destinoX+1; i < origenX; i++){
                if(tablero[origenY][i]!=null){
                    return true;
                }
            }
        }

        if(origenY<destinoY){
            for(int i = origenY+1; i < destinoY; i++){
                if(tablero[i][origenX]!=null){
                    return true;
                }
            }
        }
        else{
            for(int i = destinoY+1; i < origenY; i++){
                if(tablero[i][origenX]!=null){
                    return true;
                }
            }
        }
        return false;
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

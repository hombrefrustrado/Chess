package piezas;

public class Dama extends Pieza{
    public Dama(color piel) {
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
        return (ejex==0 || ejey==0) || (Math.abs(ejex) == Math.abs(ejey));
    }
    @Override
    public boolean enMedio(int origenX, int origenY, int destinoX, int destinoY,Pieza[][] tablero){
        //movimiento torre
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
    public String pieza() {
        if(piel.equals(color.blanco)){
            return "♕";
        }else {
            return "♛";
        }
    }
}

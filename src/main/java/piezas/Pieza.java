package piezas;

;
public abstract class Pieza {
    color piel;

    public Pieza(color piel) {
        this.piel=piel;

    }
    public color getColor(){
        return piel;
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
    public String obtenerLetra(int i){
        String letra = "";
        switch (i){
            case 0:
                letra="a";
                break;
            case 1:
                letra="b";
                break;
            case 2:
                letra="c";
                break;
            case 3:
                letra="d";
                break;
            case 4:
                letra="e";
                break;
            case 5:
                letra="f";
                break;
            case 6:
                letra="g";
                break;
            case 7:
                letra="h";
                break;
            default:
                letra="invalido";
                break;
        }
        return letra;
    }
    public abstract boolean mover(int origenX, int origenY, int destinoX, int destinoY,Pieza[][] tablero);
    public boolean enMedio(int origenX, int origenY, int destinoX, int destinoY,Pieza[][] tablero){
        return false;
    }

    //mover delta debe tener acceso al tablero para saber si la casilla a la que se va esta ocupada o crear un procedimiento a parte que use este
    public abstract boolean moverDelta(int ejex,int ejey);

    abstract public String pieza();
}

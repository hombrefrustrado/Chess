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
        return switch (a){
            case "a" -> 0;
            case "b" -> 1;
            case "c" -> 2;
            case "d" -> 3;
            case "e" -> 4;
            case "f" -> 5;
            case "g" -> 6;
            case "h" -> 7;
            default -> throw new IllegalArgumentException("Introduce un estamento valido");
        };
    }
    public String obtenerLetra(int i){
        return switch (i) {
            case 0 -> "a";
            case 1 -> "b";
            case 2 -> "c";
            case 3 -> "d";
            case 4 -> "e";
            case 5 -> "f";
            case 6 -> "g";
            case 7 -> "h";
            default -> throw new IllegalArgumentException("Has introducido un valor fuera de indice");
        };
    }
    public abstract boolean mover(int origenX, int origenY, int destinoX, int destinoY,Pieza[][] tablero);
    public boolean enMedio(int origenX, int origenY, int destinoX, int destinoY,Pieza[][] tablero){
        return false;
    }

    //mover delta debe tener acceso al tablero para saber si la casilla a la que se va esta ocupada o crear un procedimiento a parte que use este
    public abstract boolean moverDelta(int ejex,int ejey);

    abstract public String pieza();
}

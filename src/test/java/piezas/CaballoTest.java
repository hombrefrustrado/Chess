package piezas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CaballoTest {
    Caballo caballo;
    @BeforeEach
    void empezar(){
        caballo= new Caballo(color.blanco);
    }
    @Test
    void mov1(){
        assertTrue(caballo.moverDelta(2,1));
    }
}
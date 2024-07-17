package piezas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.SupportedSourceVersion;

import static org.junit.jupiter.api.Assertions.*;

class AlfilTest {
    Alfil alfil;
    @BeforeEach
    void empezar(){
        alfil = new Alfil(color.blanco);
    }
    @Test
    void mover() {
        assertTrue(alfil.moverDelta(2,2));
    }
    @Test
    void mover2(){
        assertTrue(alfil.moverDelta(3,3));
        assertFalse(alfil.moverDelta(3,1));
    }
}
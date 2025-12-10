package edu.proyectofinal.movimientoarmonico;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class sumas2Test {

    @Test
    void suma_dos_positivos() {
        double resultado = sumas2.sumar(3.0, 4.0);
        assertEquals(7.0, resultado, 0.0001);
    }

    @Test
    void suma_positivo_y_negativo() {
        double resultado = sumas2.sumar(5.0, -2.0);
        assertEquals(3.0, resultado, 0.0001);
    }

    @Test
    void suma_con_cero() {
        double resultado = sumas2.sumar(0.0, 10.0);
        assertEquals(10.0, resultado, 0.0001);
    }
}

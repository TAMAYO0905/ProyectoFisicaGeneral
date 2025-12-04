package edu.proyectofinal.movimientoarmonico;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Pruebas muy simples para LinearLeastSquares.
 *
 * Nota: estos tests son solo un ejemplo. Puedes ampliarlos para cubrir los casos
 * específicos que pida tu docente (coeficiente A, B y errores por separado).
 */
public class LinearLeastSquaresTest {

    @Test
    public void testAjusteLineaIdentidad() {
        double[] x = {0.0, 1.0, 2.0, 3.0};
        double[] y = {0.0, 1.0, 2.0, 3.0};

        LinearLeastSquares.Result result = LinearLeastSquares.fit(x, y);

        assertEquals(0.0, result.a(), 1e-6);
        assertEquals(1.0, result.b(), 1e-6);
    }
}

package edu.proyectofinal.movimientoarmonico;

import org.junit.jupiter.api.Test;

public class CoeficientesTest {

    @Test
    public void mostrarCoeficientesEnGithubActions() {

        // Datos de ejemplo (línea aproximadamente y = 1 + 2x)
        double[] x = {0.0, 1.0, 2.0, 3.0, 4.0};
        double[] y = {1.1, 2.9, 5.2, 6.8, 9.0};

        LinearLeastSquares.Result result = LinearLeastSquares.fit(x, y);

        System.out.println("===== COEFICIENTES (Mínimos Cuadrados) =====");
        System.out.println("A     = " + result.a());
        System.out.println("B     = " + result.b());
        System.out.println("sigmaA = " + result.sigmaA());
        System.out.println("sigmaB = " + result.sigmaB());
        System.out.println("============================================");
    }
}

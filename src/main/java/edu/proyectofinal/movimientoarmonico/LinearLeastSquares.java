package edu.proyectofinal.movimientoarmonico;

/**
 * Implementación sencilla del Método de Mínimos Cuadrados para un modelo lineal
 * y = A + Bx.
 *
 * Esta clase se puede reutilizar para la cuarta y quinta semana del proyecto.
 */
public class LinearLeastSquares {

    public record Result(double a, double b, double sigmaA, double sigmaB) {}

    /**
     * Ajusta un modelo y = A + Bx a los datos dados.
     *
     * @param x valores de la variable independiente
     * @param y valores de la variable dependiente
     * @return Result con A, B y sus errores estándar.
     */
    public static Result fit(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("x e y deben tener el mismo tamaño");
        }
        int n = x.length;
        if (n < 2) {
            throw new IllegalArgumentException("Se necesitan al menos dos puntos para ajustar");
        }

        double sumX = 0.0;
        double sumY = 0.0;
        double sumXX = 0.0;
        double sumXY = 0.0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXX += x[i] * x[i];
            sumXY += x[i] * y[i];
        }

        double denominator = n * sumXX - sumX * sumX;
        if (Math.abs(denominator) < 1e-12) {
            throw new IllegalStateException("Denominador ~ 0, los datos no permiten ajuste lineal.");
        }

        double b = (n * sumXY - sumX * sumY) / denominator;
        double a = (sumY - b * sumX) / n;

        // Calcular errores estándar de A y B
        double chi2 = 0.0;
        for (int i = 0; i < n; i++) {
            double yFit = a + b * x[i];
            double diff = y[i] - yFit;
            chi2 += diff * diff;
        }

        double sigma2 = chi2 / (n - 2); // varianza residual
        double sigmaB = Math.sqrt(n * sigma2 / denominator);
        double sigmaA = Math.sqrt(sigma2 * sumXX / denominator);

        return new Result(a, b, sigmaA, sigmaB);
    }
}

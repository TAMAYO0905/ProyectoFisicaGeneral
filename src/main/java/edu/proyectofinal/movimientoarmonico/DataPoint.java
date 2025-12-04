package edu.proyectofinal.movimientoarmonico;

/**
 * Representa un punto de datos (t, x, v) del problema.
 */
public class DataPoint {

    private final double t; // tiempo [s]
    private final double x; // posición [m]
    private final double v; // velocidad [m/s]

    public DataPoint(double t, double x, double v) {
        this.t = t;
        this.x = x;
        this.v = v;
    }

    public double getT() {
        return t;
    }

    public double getX() {
        return x;
    }

    public double getV() {
        return v;
    }
}

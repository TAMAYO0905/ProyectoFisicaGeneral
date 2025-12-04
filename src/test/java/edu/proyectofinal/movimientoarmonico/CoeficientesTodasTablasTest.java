package edu.proyectofinal.movimientoarmonico;

import org.junit.jupiter.api.Test;
import java.util.List;

public class CoeficientesTodasTablasTest {

    @Test
    public void calcularCoeficientesDeTodasLasTablas() {

        String[] tablas = {
                "tabla1_4m.csv",
                "tabla2_3m.csv",
                "tabla3_3m.csv",
                "tabla4_2m.csv",
                "tabla5_2m.csv",
                "tabla6_1m.csv"
        };

        DataReader reader = new DataReader();

        for (String tabla : tablas) {
            List<DataPoint> datos = reader.readFromResource(tabla);

            double[] t = datos.stream().mapToDouble(DataPoint::getT).toArray();
            double[] x = datos.stream().mapToDouble(DataPoint::getX).toArray();

            LinearLeastSquares.Result r = LinearLeastSquares.fit(t, x);

            System.out.println("===== " + tabla + " =====");
            System.out.println("A      = " + r.a());
            System.out.println("B      = " + r.b());
            System.out.println("sigmaA = " + r.sigmaA());
            System.out.println("sigmaB = " + r.sigmaB());
            System.out.println("==============================");
        }
    }
}

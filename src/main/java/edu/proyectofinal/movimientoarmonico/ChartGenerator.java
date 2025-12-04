package edu.proyectofinal.movimientoarmonico;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utilidades para generar gráficos usando XChart.
 */
public class ChartGenerator {

    /**
     * Grafica x(t) y v(t) para una lista de puntos y guarda las imágenes como PNG.
     *
     * @param data  datos experimentales
     * @param baseFilename nombre base del archivo (sin extensión)
     * @throws IOException si ocurre un error al escribir el archivo
     */
    public void plotPositionAndVelocity(List<DataPoint> data, String baseFilename) throws IOException {
        List<Double> t = data.stream().map(DataPoint::getT).collect(Collectors.toList());
        List<Double> x = data.stream().map(DataPoint::getX).collect(Collectors.toList());
        List<Double> v = data.stream().map(DataPoint::getV).collect(Collectors.toList());

        XYChart chartX = new XYChartBuilder()
                .width(800)
                .height(600)
                .title("Posición vs Tiempo")
                .xAxisTitle("t [s]")
                .yAxisTitle("x [m]")
                .build();
        chartX.addSeries("x(t)", t, x);
        BitmapEncoder.saveBitmap(chartX, baseFilename + "_x_t", BitmapFormat.PNG);

        XYChart chartV = new XYChartBuilder()
                .width(800)
                .height(600)
                .title("Velocidad vs Tiempo")
                .xAxisTitle("t [s]")
                .yAxisTitle("v [m/s]")
                .build();
        chartV.addSeries("v(t)", t, v);
        BitmapEncoder.saveBitmap(chartV, baseFilename + "_v_t", BitmapFormat.PNG);
    }
}

package edu.proyectofinal.movimientoarmonico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Lee los archivos CSV con los datos experimentales desde src/main/resources/datos.
 */
public class DataReader {

    public List<DataPoint> readFromResource(String resourceName) {
        String path = "/datos/" + resourceName;
        InputStream input = getClass().getResourceAsStream(path);
        if (input == null) {
            throw new IllegalArgumentException("No se encontró el recurso: " + path);
        }

        List<DataPoint> points = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(input, StandardCharsets.UTF_8))) {

            // Saltar cabecera
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                double t = Double.parseDouble(parts[0]);
                double x = Double.parseDouble(parts[1]);
                double v = Double.parseDouble(parts[2]);
                points.add(new DataPoint(t, x, v));
            }

        } catch (IOException e) {
            throw new RuntimeException("Error al leer datos", e);
        }

        return points;
    }
}

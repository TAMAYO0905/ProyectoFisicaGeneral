package edu.proyectofinal.movimientoarmonico;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Punto de entrada simple para generar gráficos a partir de los datos del problema.
 *
 * Uso:
 *   mvn -q exec:java -Dexec.mainClass=edu.proyectofinal.movimientoarmonico.Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Proyecto Movimiento Armónico Simple ===");
        System.out.println("Elige tabla de datos:");
        System.out.println("1 - masa 4m (tabla1_4m)");
        System.out.println("2 - masa 3m (tabla2_3m)");
        System.out.println("3 - masa 3m (tabla3_3m)");
        System.out.println("4 - masa 2m (tabla4_2m)");
        System.out.println("5 - masa 2m (tabla5_2m)");
        System.out.println("6 - masa m  (tabla6_1m)");
        System.out.print("Opción: ");

        int option = scanner.nextInt();
        scanner.close();

        String resource;
        switch (option) {
            case 1 -> resource = "tabla1_4m.csv";
            case 2 -> resource = "tabla2_3m.csv";
            case 3 -> resource = "tabla3_3m.csv";
            case 4 -> resource = "tabla4_2m.csv";
            case 5 -> resource = "tabla5_2m.csv";
            case 6 -> resource = "tabla6_1m.csv";
            default -> {
                System.out.println("Opción no válida.");
                return;
            }
        }

        DataReader reader = new DataReader();
        List<DataPoint> data = reader.readFromResource(resource);

        ChartGenerator chartGenerator = new ChartGenerator();
        String baseFilename = "graficos/" + resource.replace(".csv", "");
        try {
            // Guardar en carpeta 'graficos' relativa al directorio de ejecución
            java.nio.file.Files.createDirectories(java.nio.file.Path.of("graficos"));
            chartGenerator.plotPositionAndVelocity(data, baseFilename);
            System.out.println("Gráficos generados en la carpeta 'graficos'.");
        } catch (IOException e) {
            System.err.println("Error al generar gráficos: " + e.getMessage());
        }
    }
}

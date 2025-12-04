# Proyecto Laboratorio de Física General

Repositorio base para el proyecto de Movimiento Armónico Simple descrito en el enunciado del laboratorio.fileciteturn0file0

## Estructura principal

- `pom.xml` — configuración de Maven (Java 17, XChart, JUnit 5).
- `src/main/java/edu/proyectofinal/movimientoarmonico/`
  - `Main.java` — punto de entrada para generar gráficos.
  - `DataPoint.java` — representa un dato experimental (t, x, v).
  - `DataReader.java` — lee los archivos CSV de `src/main/resources/datos`.
  - `ChartGenerator.java` — genera gráficos usando XChart.
  - `LinearLeastSquares.java` — implementación genérica del Método de Mínimos Cuadrados lineal.
- `src/main/resources/datos` — tablas del enunciado en formato CSV.
- `src/test/java/...` — pruebas unitarias con JUnit 5.
- `.github/workflows/ci.yml` — workflow de GitHub Actions para ejecutar `mvn test` automáticamente.
- `teoria_git.md`, `teoria_maven.md`, `teoria_unittest.md` — archivos de teoría.
- `informe.md` — borrador del informe final.

## Cómo compilar y ejecutar

Desde la carpeta raíz del proyecto:

```bash
mvn clean test
```

Para generar gráficos:

```bash
mvn -q package
java -cp target/movimiento-armonico-1.0-SNAPSHOT.jar:target/dependency/* \
  edu.proyectofinal.movimientoarmonico.Main
```

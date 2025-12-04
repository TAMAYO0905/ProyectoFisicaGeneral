# Proyecto Laboratorio de Física General

Repositorio base para el proyecto de Movimiento Armónico Simple descrito en el enunciado del laboratorio.fileciteturn0file0

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

# Proyecto Laboratorio de Física General

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
Prueba de pull request y Java CI

package edu.proyectofinal.movimientoarmonico;
import java.util.Scanner;

public class sumas2 {

    // 👉 Método que vamos a testear
    public static double sumar(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ingresar el primer coeficiente: ");
        double cof_1 = sc.nextDouble();

        System.out.print("ingresar el segundo coeficiente: ");
        double cof_2 = sc.nextDouble();

        double suma = sumar(cof_1, cof_2);

        System.out.println("la suma de los coeficientes es : " + suma);
    }
}

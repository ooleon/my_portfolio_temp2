package practica.basica;
/**
Ejercicios básicos Java con estructura secuencial

Relación Nº 3: Ejercicios 8, 9 y 10

Ejercicio 8:
Programa que tome como dato de entrada un número que corresponde
 a la longitud del radio una esfera y nos calcula y escribe el volumen de la esfera que se corresponden con dicho radio.

La fórmula para calcular el volumen de la esfera es
v = (4/3)*PI*r^3
 * Programa que calcula el volumen de una esfera
 */

import java.util.*;
public class EsferaVolumen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radio, volumen;
        System.out.print("Introduzca radio de la esfera: ");
        radio = sc.nextDouble();
        System.out.println("Volumen de la esfera de radio " + radio + " = "
                        + (4.0/3)* Math.PI * Math.pow(radio, 3));
    }
}


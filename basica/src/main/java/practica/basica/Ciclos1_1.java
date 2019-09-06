package practica.basica;
/**
------  Estructura Repetitiva  --------

 Estructura Repetitiva en Java. Ejercicios Básicos Resueltos 1
Relación Nº 1: Ejercicios 1, 2, 3, 4, 5 y 6
Ejercicios básicos que utilizan la estructura repetitiva.

Se trata de mostrar los números desde el 1 hasta el 100 utilizando las instrucciones repetitivas while, do while y for.

1. Ejemplo de uso de while: Programa Java que muestre los números del 1 al 100 utilizando la instrucción while.
 * Ejercicios básicos java con estructura iterativa o repetitiva
 * Mostrar los números del 1 al 100
 * utilizando un bucle while
 */
public class Ciclos1_1 {
    public static void main(String[] args) {
         System.out.println("Numeros del 1 al 100: ");
         int i=1;
         while(i<=100) {
                   System.out.println(i);
                   i++;
         }
    }
}

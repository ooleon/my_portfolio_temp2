package practica.basica;
/**
Java Ejercicios Básicos Resueltos 1
Relación Nº 1: Ejercicios 1, 2 y 3

Empezaremos por unos ejercicios básicos de programas Java con estructura secuencial, es decir, en estos programas no hay instrucciones condicionales ni repetitivas. En la mayoría de ellos las operaciones a realizar son: lectura de datos por teclado, realizar alguna operación con esos datos y mostrar resultados por pantalla.

Ejercicios Básicos Resueltos con estructura secuencial

 1.      Programa Java que lea dos números enteros por teclado y los muestre por pantalla.
*/

import java.util.*;
public class EntradaSalidaEntero{
    public static void main(String[] args){
        //declaración de variables
        int n1, n2;
        Scanner sc = new Scanner(System.in);
        //leer el primer número
        System.out.println("Introduce un número entero: ");
        n1 = sc.nextInt();      //lee un entero por teclado
        //leer el segundo número
        System.out.println("Introduce otro número entero: ");
        n2 = sc.nextInt();      //lee un entero por teclado
        //mostrar resultado
        System.out.println("Ha introducido los números: " + n1 + " y " + n2);

    }
}

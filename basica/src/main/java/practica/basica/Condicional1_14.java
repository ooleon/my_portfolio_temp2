package practica.basica;
/**
 Java Ejercicios Básicos Resueltos Estructura Condicional 1
Los siguiente ejercicios utilizan la estructura condicional también llamada estructura alternativa o selectiva.

14. Programa Java que lea un número entero por teclado y calcule si es par o impar.

Podemos saber si un número es par si el resto de dividir el número entre 2 es igual a cero. 
 En caso contrario el número es impar

El operador Java que calcula el resto de la división entre dos números enteros o no es el operador %

El programa que calcula si un número entero es par o impar es el siguiente:
*/

import java.util.*;
public class Condicional1_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        System.out.print("Introduzca Número entero: ");
        N = sc.nextInt();
        if(N%2==0)
           System.out.println("Par");   
        else
            System.out.println("Impar"); 
    }
}
 

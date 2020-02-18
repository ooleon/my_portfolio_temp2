package practica.basica;
/**
Taller Java Ejercicios Básicos de Arrays Resueltos 1
Relación Nº 1: Ejercicios 1 y 2

1. Calcular la media de una serie de números que se leen por teclado.

Programa Java que lea por teclado 10 números enteros y los guarde en un array. A continuación calcula y muestra por separado la media de los valores positivos y la de los valores negativos.
*/
/*
 * Programa que lea por teclado 10 números enteros y los guarde en un array.
 * A continuación calcula y muestra la media de los valores positivos y la  de los valores negativos.
 */

import java.util.*;
public class Media1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        int pos = 0, neg = 0; //contadores de los números positivos y negativos
        int[] numeros = new int[10]; //array que contendrá los números leídos por teclado
        double sumaPos = 0, sumaNeg = 0; //acumuladores para las sumas de positivos y negativos
        
        //lectura de datos y llenar el array
        System.out.println("Lectura de los elementos del array: ");
        for (i = 0; i < 10; i++) {
            System.out.print("numeros[" + i + "]= ");
            numeros[i]=sc.nextInt();
        }

        //recorrer el array para sumar por separado los números positivos 
         // y los negativos 
        for (i = 0; i < 10; i++) {
            if (numeros[i] > 0){ //sumar positivos
                sumaPos += numeros[i];
                pos++;
            } else if (numeros[i] < 0){ //sumar negativos
                sumaNeg += numeros[i];
                neg++;
            }
        }

        //Calcular y mostrar las medias
        if (pos != 0) {
            System.out.println("Media de los valores positivos: " + sumaPos / pos);
        } else {
            System.out.println("No ha introducido numeros positivos");
        }
        if (neg != 0) {
            System.out.println("Media de los valores negativos: " + sumaNeg / neg);
        } else {
            System.out.println("No ha introducido numeros negativos");
        }
    }
}



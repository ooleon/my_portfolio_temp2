package practica.basica;
/**
2. Programa Java que lea 10 números enteros por teclado y los guarde en un array. Calcula y muestra la media de los números que estén en las posiciones pares del array.

Considera la primera posición del array (posición 0) como par.

*/
/*
 * Leer 10 números enteros y guardarlos
 * en un array. Calcular la media de los
 * que estén en las posiciones pares.
 */
import java.util.*;

public class Arrays1_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int i;
        int[] numeros = new int[10];
        double media = 0;

        //lectura de datos y llenar el array
        System.out.println("Lectura de los elementos del array: ");
        for (i = 0; i < 10; i++) {
            System.out.print("numeros[" + i + "]= ");
            numeros[i] = sc.nextInt();
        }
        
        //Recorrer el array y calcular la media
        for (i = 0; i < 10; i++) {
            if (i % 2 == 0){ //si la posición actual es par
                media = media + numeros[i]; //se suma el valor de esa posición
            }
        }
        //Calcular y mostrar la media
        System.out.println("Media de los valores que se encuentran en posiciones pares: "+ media/5);
    }
}


package practica.basica;
/**
Ejercicio 12:
Programa Java que lea un número entero N de 5 cifras y muestre
 sus cifras igual que en el ejemplo.
Por ejemplo para un número N = 12345    La salida debe ser:

5
45
345
2345
12345



 *
 * N = 12345    La salida debe ser:
 * 5
 * 45
 * 345
 * 2345
 * 12345
 */

import java.util.*;
public class Entero5Cifras2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        System.out.print("Introduzca valor de N: ");
        N = sc.nextInt();  //supondremos que el número introducido tiene 5 cifras
        System.out.println(N%10);
        System.out.printf("%02d %n",N%100);
        System.out.printf("%03d %n",N%1000);
        System.out.printf("%04d %n",N%10000);
        System.out.printf("%05d %n",N);
    }
}


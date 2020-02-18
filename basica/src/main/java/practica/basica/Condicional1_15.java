package practica.basica;

/**

15. Programa que lea un número entero y muestre si el número es múltiplo de 10.

Podemos comprobar si un número entero es múltiplo de 10 si al dividirlo por 10 es resto de esta división es cero.
*/
/* Programa que lea un número entero y muestre si el número es múltiplo de 10 */

import java.util.*;
public class Condicional1_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        System.out.print("Número entero: ");
        N = sc.nextInt();
        if(N%10==0)
           System.out.println("Es múltiplo de 10");   
        else
         System.out.println("No es múltiplo de 10");
    }
}

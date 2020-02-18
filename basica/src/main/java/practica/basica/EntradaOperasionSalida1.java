package practica.basica;
/**
3.      Lee un número entero por teclado y obtiene y muestra por pantalla el doble y el triple de ese número.
*/

import java.util.*;
public class EntradaOperasionSalida1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.println("Introduce un número entero:");
        numero = sc.nextInt();
        System.out.println("Número introducido: " + numero);
        System.out.println("Doble de " + numero + " -> "+ 2*numero);
        System.out.println("Triple de " + numero + " -> "+ 3*numero);
       
    }
}

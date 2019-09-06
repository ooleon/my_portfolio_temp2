package practica.basica;
/**
 * Ejercicio 10:
  Programa Java que lea un número entero de 3 cifras y muestre por
   separado las cifras del número.
 * Programa que lea un número de 3 cifras y muestre por pantalla
  las cifras del número

Recuerda que la división entre enteros da como resultado la parte
 entera de la división (sin decimales). Si por ejemplo N = 123 la 
 operación N/10 da como resultado 12 y no 12.3 
Recuerda que el operador % obtiene el resto de la división.
 */
import java.util.*;
public class Entero3Cifras{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        System.out.print("Introduzca valor de N: ");
        N = sc.nextInt(); //supondremos que el número introducido tiene 3 cifras
        System.out.println("Primera cifra de " + N + " -> " + (N/100));
        System.out.println("Cifra central de " + N + " -> " + (N/10)%10);
        System.out.println("Última cifra  de " + N + " -> " + (N%10));
        
    }  
} 


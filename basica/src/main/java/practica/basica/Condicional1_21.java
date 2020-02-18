package practica.basica;
/**
La otra solución es directa y consiste en comprobar si el carácter que se ha leído por teclado es mayor o igual que el carácter 0 y menor o igual que el carácter 9.

// Versión alternativa comparando con
// los caracteres '0' ... '9'

     if(car1>='0' && car1<='9')
           System.out.println("Es un número");
        else
           System.out.println("No es un número");
  
Ejercicio 21: Programa que lea dos números por teclado y muestre el resultado de la división del primer número por el segundo. Se debe comprobar que el divisor no puede ser cero.
 * Ejemplo de programa con estructura condicional
 * Programa que lea dos números por teclado y muestre el resultado de la división del primero por el segundo.
 * Se comprueba que el divisor es distinto de cero.
 */
import java.util.*;
public class Condicional1_21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double dividendo, divisor;
        System.out.print("Introduzca el dividendo: ");
        dividendo = sc.nextDouble();
        System.out.print("Introduzca el divisor: ");
        divisor = sc.nextDouble();
        if(divisor==0)
           System.out.println("No se puede dividir por cero");   
        else{
            System.out.println(dividendo + " / " + divisor + " = " + dividendo/divisor);  
            System.out.printf("%.2f / %.2f = %.2f %n" , dividendo, divisor , dividendo/divisor);
        }
    }
}

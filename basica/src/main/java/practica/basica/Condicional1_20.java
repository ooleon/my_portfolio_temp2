package practica.basica;
/**
Una forma alternativa de resolver este ejercicio es comparando directamente las dos variables
 con las letras minúsculas       

        if(car1>='a' && car1<='z'){
            if(car2>='a' && car2<='z')
               System.out.println("Los dos son letras minúsculas");
           else
               System.out.println("El primero es una letra minúscula pero el segundo no");
        }
        else{
            if(car2>='a' && car2<='z')
               System.out.println("El segundo es una letra minúscula pero el primero no");
           else
               System.out.println("Ninguno es una letra minúscula");
        }


 Java Ejercicios Estructura Condicional 3
Aquí teneis otra entrega de ejercicios básicos con estructura condicional.

Relación Nº 3: Ejercicios 20 y 21

Ejercicio 20: Programa java que lea un carácter por teclado y compruebe si es un dígito numérico (cifra entre 0 y 9).

Vamos a escribir dos soluciones a este ejercicio. 

La primera consiste en comprobar si el carácter es un dígito mediante el método isDigit de la clase Character.
 Este método devuelve true si el carácter que se le pasa como parámetro es una cifra entre 0 y 9:

 * Ejemplo de programa con estructura condicional
 * Programa que lea un carácter por teclado y compruebe si es un número
 */
import java.io.*;
public class Condicional1_20 {
   public static void main(String[] args) throws IOException {
        char car1;
        System.out.print("Introduzca carácter: ");
        car1 = (char)System.in.read(); //lee un carácter
        if(Character.isDigit(car1)) //utilizamos el método isDigit de la clase Character
           System.out.println("Es un número");
        else
           System.out.println("No es un número");
  }
}

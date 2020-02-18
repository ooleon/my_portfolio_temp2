package practica.basica;
/**
 Java Ejercicios Básicos Resueltos Estructura Condicional 2
Continuamos con más ejercicios básicos que usan la estructura condicional.
Relación Nº 2: Ejercicios 4 y 5
Ejercicio 4: Programa que lea dos caracteres y compruebe si son iguales.
 *  Ejemplo básico java
 * Programa con estructura condicional
 * Programa que lea dos caracteres y compruebe
 * si son iguales.
 */
import java.io.*;
public class condicional1_17 {
    public static void main(String[] args) throws IOException {
        char car1, car2;
        System.out.print("Introduzca primer carácter: ");
        car1 = (char)System.in.read(); //lee un carácter
        System.in.read();  //saltar el intro que ha quedado en el buffer
        System.out.print("Introduzca segundo carácter: ");
        car2 = (char)System.in.read(); //lee el segundo carácter

        if(car1 == car2)
           System.out.println("Son iguales");   
        else
           System.out.println("No son iguales");        
    }
} 

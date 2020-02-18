package practica.basica;
/**
Ejercicio 19: Programa java que lea dos caracteres por teclado y compruebe si los dos son letras minúsculas

 Ejemplo básico java de programa con estructura condicional
 * Programa que lea dos caracteres y compruebe si los dos son letras minúsculas
 */
import java.io.*;
public class Condicional1_19 {
public static void main(String[] args) throws IOException {
        char car1, car2;
        System.out.println("Introduzca primer carácter: ");
        car1 = (char)System.in.read(); //lee un carácter
        System.in.read();  //saltar el intro que ha quedado
        System.out.println("Introduzca segundo carácter: ");
        car2 = (char)System.in.read(); //lee el segundo carácter     
        if(Character.isLowerCase(car1)){ //utilizamos el método isLowerCase de la clase Character
           if(Character.isLowerCase(car2))
               System.out.println("Los dos son letras minúsculas");
           else
               System.out.println("El primero es una letra minúscula pero el segundo no");
        }
        else{
            if(Character.isLowerCase(car2))
               System.out.println("El segundo es una letra minúscula pero el primero no");
           else
               System.out.println("Ninguno es una letra minúscula");
        }
   }
}

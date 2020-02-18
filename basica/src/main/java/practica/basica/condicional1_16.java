package practica.basica;
/**
16. Programa que lea un carácter por teclado y compruebe si es una letra mayúscula
 */
import java.io.*;
import java.util.*;
public class condicional1_16 {
/*
Forma alternativa de comprobar si un carácter es una letra mayúscula sin utilizar el método 
 isUpperCase, en este caso comparando directamente con los caracteres A y Z
       
        if(car>='A' && car <='Z')
           System.out.println("Es una letra mayúscula");   
        else
           System.out.println("No es una letra mayúscula");  
           
*/


    public static void main(String[] args) throws IOException{
          Scanner sc = new Scanner(System.in);
          char car, car1;
          System.out.print("Introduzca un carácter: ");
          car = (char)System.in.read(); //lee un solo caracter
        
          if(Character.isUpperCase(car)) //utilizamos el método isUpperCase de la clase Character
             System.out.println("Es una letra mayúscula");   
          else
              System.out.println("No es una letra mayúscula");  
     }

}


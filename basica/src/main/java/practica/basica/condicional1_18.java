package practica.basica;
/** 
Ejercicio 18: Una forma alternativa de hacer este programa es creando dos objetos Character a partir
 de los caracteres que se han leído y compararlos utilizando el método equals
*/
import java.io.*;
public class condicional1_18 {
    public static void main(String[] args) throws IOException {
        char car1, car2;
        System.out.print("Introduzca primer carácter: ");
        car1 = (char)System.in.read(); //lee un carácter
        System.in.read();  //saltar el intro que ha quedado en el buffer
        System.out.print("Introduzca segundo carácter: ");
        car2 = (char)System.in.read(); //lee el segundo carácter
        Character c1 = new Character(car1);
        Character c2 = new Character(car2);
        if(c1.equals(c2))  //comparamos dos objetos Character mediante el método equals
            System.out.println("Son iguales");   
        else
            System.out.println("No son iguales");
    }  
}


package practica.basica;
/**
La operación para calcular el volumen es: 
(4.0/3)* Math.PI * Math.pow(radio, 3))

Debemos tener cuidado con la división entre números enteros. 
Si hacemos 4/3 nos da como resultado 1, por eso se debe escribir
 al menos uno de los dos números como double. En este caso se 
 ha puesto el numerador como double simplemente escribiendo 4.0 
 y de esta forma el resultado de la división 4.0/3 será de tipo double.

Ejercicio 9:
Programa Java que calcule el área de un triángulo en función de las 
longitudes de sus lados (a, b, c), según la siguiente fórmula:  
Area = RaizCuadrada(p*(p-a)*(p-b)*(p-c))
donde p =  (a+b+c)/2
Para calcular la raíz cuadrada se utiliza el método Math.sqrt() 

 * Programa que calcule el área de un triángulo en función de las longitudes de sus lados (a, b, c)
 * según la siguiente fórmula: area=raiz2(p(p-a)(p-b)(p-c)) donde p = (a+b+c)/2
 */

import java.util.*;
public class Pitagoras2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a,b,c,p;
        System.out.print("Introduzca longitud del primer lado del triángulo: ");
        a = sc.nextDouble();
        System.out.print("Introduzca longitud del segundo lado del triángulo: ");
        b = sc.nextDouble();
        System.out.print("Introduzca longitud del tercer lado del triángulo: ");
        c = sc.nextDouble();
        p = (a+b+c)/2;
    System.out.println("Area -> " +  Math.sqrt(p*(p-a)*(p-b)*(p-c)));
    }
}



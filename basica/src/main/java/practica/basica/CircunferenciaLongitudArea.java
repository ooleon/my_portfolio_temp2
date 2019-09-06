package practica.basica;
/**
5.   Ejercicio 5. Programa que lee por teclado el valor del radio 
 de una circunferencia y calcula y muestra por pantalla la longitud 
 y el área de la circunferencia. 
Longitud de la circunferencia = 2*PI*Radio, 
Area de la circunferencia = PI*Radio^2
*/

import java.util.*;

public class CircunferenciaLongitudArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radio, longitud, area;
        System.out.println("Introduce radio de la circunferencia:");
        radio = sc.nextDouble();
        longitud = 2 * Math.PI * radio;
        area = Math.PI * Math.pow(radio, 2);
        System.out.println("Longitud de la circunferencia -> " + longitud);
        System.out.println("Area de la circunferencia -> " + area);
    }
}

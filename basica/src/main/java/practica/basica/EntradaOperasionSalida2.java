package practica.basica;

/**
Java Ejercicios Básicos estructura secuencial
Relación Nº 2: Ejercicios 4, 5, 6 y 7

4.   Lea una cantidad de grados centígrados y la pase a grados Fahrenheit.
La fórmula correspondiente para pasar de grados centígrados a fahrenheit es:
F = 32 + ( 9 * C / 5)
*/

import java.util.*;
public class EntradaOperasionSalida2 {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      double gradosC, gradosF;
      System.out.println("Introduce grados Centígrados:");
      gradosC = sc.nextDouble();
      gradosF = 32 + (9 * gradosC / 5);
      System.out.println(gradosC +" ºC = " + gradosF + " ºF");
  }
}


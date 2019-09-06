package practica.basica;
/**
--------------------------Recuersividad-------------------
Ejemplos 2:
 Suma Recursiva de números desde 1 hasta N en Java
Programa recursivo que calcula la suma desde 1 hasta un número entero N leído por teclado.
*/
/*
Caso Base: Si n == 1 la suma es 1   

Si n > 1
la suma es n + (la suma de los anteriores números hasta 1)
Por ejemplo, si n = 5, la suma es 5 más la suma desde 1 hasta 4. A su vez la suma si n = 4 es 4 + la suma desde 1 hasta 3 y así sucesivamente hasta llegar al caso base como se muestra en la imagen.

El programa que calcula la suma desde 1 hasta N de forma recursiva es el siguiente:
*/
import java.util.*;
public class Suma1N {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        do{
           System.out.print("Introduce un numero entero >0 ");
           num = sc.nextInt();
        }while(num<=0);
        System.out.println("Suma desde 1 hasta " + num + " = " + suma1N(num));

    }

    /**
    * Método recursivo para calcular la suma desde 1 hasta N
    */
    public static double suma1N(int n){
           if(n == 1)  //caso base
              return 1;
           else
              return n + suma1N(n-1);
    }
}



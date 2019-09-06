package practica.basica;
/**
La instrucción que comprueba si la hora leída por teclado es correcta es:
if(H>=0 && H<24 && M>=0 && M<60 && S>=0 && S<60)
Esta condición da como resultado true cuando la hora es mayor o igual a 0 y menor que 24,
 los minutos son mayores o iguales a 0 y menores que 60 y los segundos son mayores 0 iguales a cero y menores a 60.

Ejercicio 23:
Programa que lea una variable entera mes y compruebe si el valor corresponde a un mes de 30 días, de 31 o de 28.
 Supondremos que febrero tiene 28 días. Se mostrará además el nombre del mes. Se debe comprobar que el valor
 introducido esté comprendido entre 1 y 12.

 * Programa java que lea una variable entera mes y compruebe si el valor corresponde
 * a un mes de 30 días. Se debe comprobar que el valor introducido esté
 * comprendido entre 1 y 12
 */
import java.util.*;
public class Condicional1_23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mes;
        System.out.print("Introduzca número de mes: ");
        mes =  sc.nextInt();
        if(mes < 1 || mes > 12) //se comprueba que el valor del mes es correcto
            System.out.println("Mes incorrecto");
        else{  //si el mes es correcto
            switch(mes){  //se muestra el nombre mediante una instrucción switch
                case 1: System.out.print("Enero");
                        break;
                case 2: System.out.print("Febrero");
                        break;
                case 3: System.out.print("Marzo");
                        break;
                case 4: System.out.print("Abril");
                        break;
                case 5: System.out.print("Mayo");
                        break;
                case 6: System.out.print("Junio");
                        break;
                case 7: System.out.print("Julio");
                        break;
                case 8: System.out.print("Agosto");
                        break;
                case 9: System.out.print("Septiembre");
                        break;
                case 10: System.out.print("Octubre");
                        break;
                case 11: System.out.print("Noviembre");
                        break;
                case 12: System.out.print("Diciembre");
                        break;
            }
            // mostrar si es un mes de 30, 31 0 28 días
            if(mes == 4 || mes == 6 || mes == 9 || mes == 11)       
               System.out.println(" es un mes de 30 días");
            else if(mes == 2)
                     System.out.println(" es un mes de 28 días");
                   else
                      System.out.println(" es un mes de 31 días");
        }
    }
}

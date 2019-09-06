package practica.basica;
/**
2. Ejemplo de uso de do-while. Programa Java que muestre los números del 1 al 100 utilizando la instrucción do..while.

 * Ejercicios básicos java con estructura iterativa o repetitiva
 * Mostrar los números del 1 al 100 utilizando un bucle do while
 */
public class Ciclos1_2 {
    public static void main(String[] args) {
        int i = 1;
        System.out.println("Numeros del 1 al 100: ");
        do{
                   System.out.println(i);
                   i++;
        }while(i<=100);
    }
}

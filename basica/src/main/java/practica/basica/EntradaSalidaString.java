package practica.basica;
/**
2.      Programa Java que lea un nombre y muestre por pantalla: “Buenos dias nombre_introducido”
*/

 import java.util.*;
 public class EntradaSalidaString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena;
        System.out.println("Introduce un nombre: ");
        cadena = sc.nextLine();
        System.out.println("Buenos Días " + cadena);
    }
}


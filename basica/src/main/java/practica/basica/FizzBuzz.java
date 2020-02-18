package practica.basica;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FizzBuzz {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter( "./out.txt" ));

        //Cantidad de Casos de Test que serán recibidos y procesados.
        int n = scanner.nextInt();
        //Delimitador "Enter" para finalizar la lectura del dato anterior.
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        //Delimitador "Enter" para finalizar la lectura del dato anterior.
        System.out.println();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        String result = fizzBuzzCaso(n, ar);

        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.write( result );
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    static String fizzBuzzCaso(int n, int[] ar) {
        for(int t = n; t>0; t--){
        fizzBuzz(ar[ t - 1 ]);
        System.out.println();
        }
      return String.valueOf("n: " + n);
    }

    static void fizzBuzz(int j) {
        if (j < 0 ) j = j * -1;

        //for(int i = j; i>0; i--){
        for(int i = j; i>0; i--){
          if(i % 3 == 0)System.out.print("Fizz");
          if(i%5==0)System.out.print("Buzz");
          else if(i%3 != 0)System.out.print(i);
          System.out.print(" ");
        }
    }

}

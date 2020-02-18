package practica.basica;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FizzBuzzSimple{
  public static void main(String[]args){
    int n = 50;
    for(int i = n; i>0; i--){
      if(i % 3 == 0)System.out.print("Fizz");
      if(i%5==0)System.out.print("Buzz");
      else if(i%3 != 0)System.out.print(i);
      System.out.println();
    }
  }
}

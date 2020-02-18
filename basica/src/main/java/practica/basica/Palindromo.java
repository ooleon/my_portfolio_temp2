package practica.basica;
//Ejemplo de usando funciones recursivas para determinar si una frace es palindromo :

import java.util.*;
public class Palindromo {
    public static void main(String[] args) {
		Palindromo p = new Palindromo();
		System.out.println("Palindromo: " + p.ajustar("apa"));
    }
	public static boolean ajustar(String word){
			word.toLowerCase();
			String sinespacios = word.replaceAll(" ", "");
			return comprobar(sinespacios);
		}
	public static boolean comprobar(String word){
			if(word.length() == 1 || word.length() == 0)
				return true;
			else{
				if(word.charAt(0) == word.charAt(word.length()-1) )            
					return comprobar(word.substring(1,word.length()-1));
							return false;            
			}
		}
}
    


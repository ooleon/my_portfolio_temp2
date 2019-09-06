package main;

public abstract class Configuracion {

	/**
	 * 
	 * Este es un atributo global que indica el comportamiento del metodo
	 * perteneceA(T) en las clases CriterioCaso1(3) en relacion a como usar los
	 * String que se pasan por parámetro. el valor {@value #str_contar_vocales}
	 * falso retorna la longitud de la palabra, en caso contrario, true retorna la
	 * cantidad de vocales en la palabra.
	 */
	static public boolean str_contar_vocales = false;

	static public int int_divisor = 5;
}

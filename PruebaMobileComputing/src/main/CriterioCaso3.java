package main;

import java.util.Collection;
import java.util.Map;

/**
 * Clase generica que da la solución al caso 3º.
 */

public class CriterioCaso3<T, G> implements Criterio<T, G> {

	@Override
	public G perteneceA(T miObjeto) {
		String s = null;
		Integer r = null;
		Integer l = null;
		Integer v = null;

		if (miObjeto.getClass() == Integer.class) {
			// System.out.println("es Integer");

			r = new Integer((Integer) miObjeto % 5);
			// System.out.println("Integer r es: " + r);
		}

		if (miObjeto.getClass() == String.class) {
			
			s = ((String) miObjeto).toLowerCase();

			if (!Configuracion.str_contar_vocales) { 
				//Esta puede ser otra forma de resolver evitando usar mas clases. pero es un antipatron.
				v = new Integer(s.length() - s.replaceAll("a|e|i|o|u", "").length());
				r = v;
			} else {
				//aqui se estaría resolviendo el caso 2.
				l = new Integer(s.length());
				r = l;
			}

		}

		if (miObjeto.getClass() == Double.class)
			System.out.println("es Double");
		if (miObjeto.getClass() == Number.class)
			System.out.println("es Number");

		return (G) r;
	}

}
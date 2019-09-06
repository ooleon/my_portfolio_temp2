package main;

import java.util.Collection;
import java.util.Map;

/**
 * Clase generica que da la solución al caso 1º.
 */

public class CriterioCaso1<T, G> implements Criterio<T, G> {

	@Override
	public G perteneceA(T miObjeto) {
		String s = null;
		Integer r = null;
		Integer l = null;
		Integer v = null;

		if (miObjeto.getClass() == Integer.class) {

			r = new Integer((Integer) miObjeto % Configuracion.int_divisor);

		}

		if (miObjeto.getClass() == String.class) {

			s = ((String) miObjeto).toLowerCase();

			if (Configuracion.str_contar_vocales) {
				v = new Integer(s.length() - s.replaceAll("a|e|i|o|u", "").length());
				r = v;
			} else {
				l = new Integer(s.length());
				r = l;
			}

		}

		return (G) r;
	}

}
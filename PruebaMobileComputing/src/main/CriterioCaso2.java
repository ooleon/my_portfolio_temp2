package main;

import java.util.Collection;
import java.util.Map;

/**
 * Clase generica que da la solución al caso 2º.
 */

public class CriterioCaso2<T, G> implements Criterio<T, G> {

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

			r = new Integer(s.length());

		}

		return (G) r;
	}

}
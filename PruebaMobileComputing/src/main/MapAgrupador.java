package main;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapAgrupador<T, G> implements Agrupador<T, G> {

	@Override
	public Map<G, Collection<T>> agruparPor(Collection<T> coleccion, Criterio<T, G> criterio) {
		// public Map<G, Collection<T>> agruparPor(Collection<?> coleccion,
		// Criterio<? extend T, ? extend G> criterio) {
		// TODO Auto-generated method stub
		Map m = new HashMap<>();
		// if (criterio.perteneceA(T miObjeto) ) {
		//
		// }
		// List<String> s1 = new ArrayList<>()
		// String[] s1 = coleccion.toArray(new String[0]);
		// System.out.println( s1);
		// List<T> l = new ArrayList<T>();
		Set<T> l = new HashSet<>();

		for (Object s : coleccion.toArray()) {
			Integer i = (Integer) criterio.perteneceA((T) s);
			// List<T> ltm = new ArrayList<T>();
			Set<T> ltm = new HashSet<T>();
			if (m.get(i) == null) {
				m.put(i, ltm);
			} else {
				// ltm=((List<T>) m.get(i));
				ltm = ((Set<T>) m.get(i));
				// System.out.println( ((List) m.get(i)) );
			}
			l = ltm;
			// m.put(i, l.add((T) s) );
			// System.out.println(l);
			// System.out.println(m);
			l.add((T) s);
			// m.put(i, ((List) m.get(i)).add(s) );
			m.put(i, l);
			// System.out.println(m);
		}
		// System.out.println(m);
		// System.out.println(coleccion.toArray()[0].toString());

		return m;
	}
	/* */

}

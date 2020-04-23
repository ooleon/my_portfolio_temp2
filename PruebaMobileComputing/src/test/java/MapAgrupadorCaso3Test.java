import static org.junit.Assert.*;

import org.junit.Test;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
import java.util.*;

/**
 * Caso3: agrupar por cantidad de vocales.
 */

public class MapAgrupadorCaso3Test {

	@Test
	public void testAgruparPorCaso1() {
		Map actuals;

		Set<String> l1 = new HashSet<>();
		Agrupador agrp1 = new MapAgrupador();
		Criterio cri = new CriterioCaso3();


		// l1 = new ArrayList<>();
		l1 = new HashSet<>();
		l1.add("Caracas");
		l1.add("mesera");
		l1.add("lo");
		l1.add("mesa");
		l1.add("casa");
		l1.add("teclado");
		l1.add("si");
		l1.add("hilo");
		l1.add("no");
		// Configuracion.str_contar_vocales=true;
		actuals = agrp1.agruparPor(l1, cri);
		System.out.println("actuals: " + actuals);

		Set<String> s1 = new HashSet<>();
		s1 = new HashSet<>();
		s1.add("si");
		s1.add("no");
		s1.add("lo");

		Set<String> s2 = new HashSet<>();
		s2 = new HashSet<>();
		s2.add("casa");
		s2.add("mesa");
		s2.add("hilo");

		Set<String> s3 = new HashSet<>();
		s3 = new HashSet<>();
		s3.add("Caracas");
		s3.add("mesera");
		s3.add("teclado");

		Map expecteds;
		expecteds = new HashMap<Integer, Arrays>();
		expecteds.put(new Integer(1), s1);
		expecteds.put(new Integer(2), s2);
		expecteds.put(new Integer(3), s3);
		System.out.println("expecteds: " + expecteds);

		String message = "respuesta";
		// assertArrayEquals(message , expecteds.toArray(), actuals.toArray());
		assertEquals(message, expecteds, actuals);

	}

}

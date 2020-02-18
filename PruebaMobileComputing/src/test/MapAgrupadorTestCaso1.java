package test;

import static org.junit.Assert.*;

import org.junit.Test;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
import java.util.*;

import main.*;

public class MapAgrupadorTestCaso1 {

	/**
	 * Caso1: agrupar por longitud.
	 */

	@Test
	public void testAgruparPorCaso1() {
		Map actuals;

		Set<String> l1 = new HashSet<>();
		Agrupador agrp1 = new MapAgrupador();
		Criterio cri = new CriterioCaso1();

		l1 = new HashSet<>();

		l1 = new HashSet<>();
		l1.add("Caracas");
		l1.add("meseras");
		l1.add("lo");
		l1.add("mesa");
		l1.add("casa");
		l1.add("soborno");
		l1.add("si");
		l1.add("hilo");
		l1.add("no");

		actuals = agrp1.agruparPor(l1, cri);
		System.out.println("actuals: " + actuals);

		Set<String> s2 = new HashSet<>();
		s2 = new HashSet<>();
		s2.add("si");
		s2.add("no");
		s2.add("lo");

		Set<String> s4 = new HashSet<>();
		s4 = new HashSet<>();
		s4.add("casa");
		s4.add("mesa");
		s4.add("hilo");

		Set<String> s7 = new HashSet<>();
		s7 = new HashSet<>();
		s7.add("Caracas");
		s7.add("meseras");
		s7.add("soborno");

		Map expecteds;
		expecteds = new HashMap<Integer, Arrays>();
		expecteds.put(new Integer(2), s2);
		expecteds.put(new Integer(4), s4);
		expecteds.put(new Integer(7), s7);
		System.out.println("expecteds: " + expecteds);

		String message = "respuesta";

		assertEquals(message, expecteds, actuals);

	}

}

import static org.junit.Assert.*;

import org.junit.Test;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
import java.util.*;

/**
 * Caso2: residuo entre 5.
 */

public class MapAgrupadorCaso2Test {

	@Test
	public void testAgruparPorCaso2() {
		Map actuals;
		Agrupador agrp1 = new MapAgrupador();
		Criterio cri = new CriterioCaso2();

		Set<Integer> i = new HashSet<>();
		i.add(1);
		i.add(2);
		i.add(3);
		i.add(4);
		i.add(5);
		i.add(6);
		i.add(7);
		i.add(8);
		i.add(9);
		i.add(10);
		i.add(11);
		i.add(12);
		i.add(13);
		i.add(14);
		i.add(15);
		i.add(16);
		i.add(17);
		i.add(18);
		i.add(19);
		actuals = agrp1.agruparPor(i, cri);
		System.out.println("actuals: " + actuals);

		Set<Integer> i0 = new HashSet<>();
		i0.add(5);
		i0.add(10);
		i0.add(15);

		Set<Integer> i1 = new HashSet<>();
		i1.add(1);
		i1.add(6);
		i1.add(11);
		i1.add(16);

		Set<Integer> i2 = new HashSet<>();
		i2.add(2);
		i2.add(7);
		i2.add(12);
		i2.add(17);

		Set<Integer> i3 = new HashSet<>();
		i3.add(3);
		i3.add(8);
		i3.add(13);
		i3.add(18);

		Set<Integer> i4 = new HashSet<>();
		i4.add(4);
		i4.add(9);
		i4.add(14);
		i4.add(19);

		Map expecteds;
		expecteds = new HashMap<Integer, Arrays>();
		expecteds.put(new Integer(0), i0);
		expecteds.put(new Integer(1), i1);
		expecteds.put(new Integer(2), i2);
		expecteds.put(new Integer(3), i3);
		expecteds.put(new Integer(4), i4);
		System.out.println("expecteds: " + expecteds);

		String message = "respuesta";
		// assertArrayEquals(message , expecteds.toArray(), actuals.toArray());
		assertEquals(message, expecteds, actuals);

	}

}

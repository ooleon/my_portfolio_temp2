package main;

import java.util.ArrayList;
import java.util.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// List<Integer>[] intList = new List<Integer>[5];
		List<Integer> intList = new ArrayList<>();
		intList.add(20);
		intList.add(21);
		intList.add(22);
		Map m;
		// List<String> s1 = new ArrayList<>();
		Set<String> s1 = new HashSet<>();

		Set<String> st = new HashSet<>();
		st.add("seat1");
		st.add("seat2");
		st.add("cat");
		st.add("cat");
		System.out.println("Set: " + st);

		// Arrays a= s1.toArray();

		// Map m = new HashMap<>();
		// m.put(1, intList);
		// m.put(2, "b");
		// m.put(3, 3.4);
		Agrupador agrp1 = new MapAgrupador();
		Criterio cri = new CriterioCaso1();

		/*
		 * Caso1: agrupar por longitud.
		 */
		// Map m = agrp.agruparPor(intList, new MapCriterio());
		s1.add("casa");
		s1.add("meses");
		s1.add("iris");
		m = agrp1.agruparPor(st, cri);
		System.out.println(m);

		// s1 = new ArrayList<>();
		s1 = new HashSet<>();
		s1.add("qwerqwer");
		s1.add("qwersdcooo");
		s1.add("er");
		s1.add("qwerqwaw");
		s1.add("io");
		s1.add("aT");
		s1.add("qwerqwiw");
		s1.add("io");
		s1.add("aT");
		String[] a1 = { "mesa", "silla", "nota", "pera", "cinco", "hola", "la", "guitarra" };
		System.out.println("a1:" + a1.getClass());
		m = agrp1.agruparPor(s1, cri);
		System.out.println(m);

		/*
		 * Caso2: agrupar por residuo de division entre 5.
		 */
		List<Integer> i1 = new ArrayList<>();
		i1.add(1);
		i1.add(2);
		i1.add(3);
		i1.add(4);
		i1.add(5);
		i1.add(6);
		i1.add(7);
		i1.add(8);
		i1.add(9);
		i1.add(10);
		i1.add(30);
		i1.add(34);
		i1.add(11);
		i1.add(12);
		i1.add(13);
		i1.add(14);
		// m = agrp1.agruparPor(i1, cri);
		// System.out.println(m);

		/*
		 * Caso1: agrupar por residuo de division entre 5.
		 */
		Configuracion.str_contar_vocales = true;
		System.out.println(Configuracion.str_contar_vocales);
		m = agrp1.agruparPor(s1, cri);
		System.out.println(m);

	}

}

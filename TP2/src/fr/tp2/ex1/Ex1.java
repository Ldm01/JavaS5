package fr.tp2.ex1;

import java.util.ArrayList;
import java.util.HashSet;

public class Ex1 {

	public static <T> HashSet<Integer> indexSet(ArrayList<T> list, T element) {
		HashSet<Integer> set = new HashSet<>();
		if (list.contains(element)) {					/* Si la liste entrée en paramètres contient l'élément entré en paramètres 
																on parcourt la liste et à chaque fois qu'on tombe sur une occurence de l'élément
																        recherché, sa position dans la liste est ajouté au set d'index		*/
			for (int i=0 ; i<list.size() ; i++) {                                     
				if (list.get(i).equals(element)) {
					set.add(i);
				}
			}
		}
		return set;
	}
	
	public static void main(String[] args) {
		ArrayList<Double> l = new ArrayList<Double>();
		Double e = 9.7;
		
	        l.add(9.7);
	        l.add(9.9);
	        l.add(9.2);
	        l.add(8.5);
	        l.add(9.5);
	        l.add(9.7);
	        l.add(9.0);
	        l.add(9.9);
	        l.add(9.4);
	        l.add(8.5);
	        l.add(8.5);
	        l.add(9.7);
	        l.add(8.8);
	        l.add(8.9);
	        l.add(9.7);
	        l.add(9.5);
	        l.add(8.6);
	        l.add(9.5);
	        l.add(9.8);
	        l.add(9.3);

	        System.out.println(indexSet(l,e));

	}

}

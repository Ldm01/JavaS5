package fr.tp1;

import java.util.ArrayList;
import java.util.HashSet;

public class Ex1 {
	
	public static HashSet<Integer> indexSet(ArrayList<String> list, String element) {
		HashSet<Integer> set = new HashSet<>();
		if (list.contains(element)) {					/* Si la liste entr�e en param�tres contient l'�l�ment entr� en param�tres 
																on parcourt la liste et � chaque fois qu'on tombe sur une occurence de l'�l�ment
																        recherch�, sa position dans la liste est ajout� au set d'index		*/
			for (int i=0 ; i<list.size() ; i++) {                                     
				if (element == list.get(i)) {
					set.add(i);
				}
			}
		}
		return set;
	}
		
	public static void main(String[] args) {
		ArrayList<String> l = new ArrayList<>();
		String e = "adj";
		
	        l.add("det");
	        l.add("adj");
	        l.add("noum");
	        l.add("adj");
	        l.add("verb");
	        l.add("det");
	        l.add("verb");
	        l.add("det");
	        l.add("adj");
	        l.add("noum");
	        l.add("adj");
	        l.add("punc");

	        System.out.println(indexSet(l,e));

	}

}

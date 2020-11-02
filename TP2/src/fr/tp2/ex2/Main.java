package fr.tp2.ex2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Animaux aList = new Animaux();
		ArrayList<Animal> males = new ArrayList<>();
		ArrayList<Animal> femelles = new ArrayList<>();
		
		// On entre les animaux dans la liste;
		aList.add(new Chien("Max", 5.5, false, true));
		aList.add(new Chat("Jupiter", 2.6, false));
		aList.add(new Poisson("Lili", 0.05, true, true, 25));
		aList.add(new Poisson("Dory", 0.04, true, false, 14));
		aList.add(new Chien("Maya", 4, true, false));
		aList.add(new Chat("Obelix", 3.2, false));
		
		// Animal le plus lourd entre les index 1 et 4 :
		aList.maxIntervalle(1,4);
		
		System.out.println("=====================================");
		
		// On construit les listes de genres
		femelles = aList.genre(true);
		males = aList.genre(false);
		
		
		// Affichage listes genres
		System.out.println("Voici toutes les femelles : ");
		for (int i=0 ; i<femelles.size() ; i++) {
			System.out.println(femelles.get(i).getNom());
		}
		
		System.out.println("=====================================");
		
		System.out.println("Voici tous les males : ");
		for (int i=0 ; i<males.size() ; i++) {
			System.out.println(males.get(i).getNom());
		}
		
		

	}

}

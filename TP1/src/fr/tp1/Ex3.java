package fr.tp1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		Anime a1 = new Anime("Attaque des titans", 9.7, 9.9, 9.2, 8.5);
		Anime a2 = new Anime("Naruto Shippuden", 9.5, 9.7, 9, 9.9);
		Anime a3 = new Anime("Hunter X Hunter", 9.4, 8.5, 8.5, 9.7);
		Anime a4 = new Anime("Fullmetal Alchemist : Brotherhood", 8.8, 8.9, 9.7, 9.5);
		Anime a5 = new Anime("Death Note", 8.6, 9.5, 9.8, 9.3);
		
		ArrayList<Anime> animes = new ArrayList<>();
		animes.add(a1);
		animes.add(a2);
		animes.add(a3);
		animes.add(a4);
		animes.add(a5);
		System.out.println("Voici la liste des Animes !");
		for (Object o : animes) {
			System.out.println(o);
		}
		
		
		Scanner scan = new Scanner(System.in);
		int quit = 0;
		
		while (quit == 0) {
			System.out.println("Sélectionnez une option :");
			System.out.println("Tri par titre alphabétique : 1 \n Tri par moyenne décroissante : 2 \n Quitter le programme : 3");
			int choice = scan.nextInt();
			if (choice == 1) {
				Collections.sort(animes, new Anime.ComparerNomAnime());
				for (Object o : animes) {
					System.out.println(o);
				}
			} else if (choice == 2) {
				Collections.sort(animes, new Anime.ComparerMoyenneAnime().reversed());
				for (Object o : animes) {
					System.out.println(o);
				}
			} else if (choice == 3) {
				System.out.println("Au revoir !");
				quit = 1;
			} else {
				System.out.println("Veuillez rentrer un chiffre correspondant au menu svp");
			}
		}	
		
	}

}

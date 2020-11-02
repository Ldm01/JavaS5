package fr.tp2.ex2;

import java.util.ArrayList;

public class Animaux extends ArrayList<Animal> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void maxIntervalle(int index1, int index2) {
		Animal plusLourd = null; // Permet de rentrer dans le parcours de la liste
		for (int i = index1 ; i<=index2 ; i++) {
			if (plusLourd == null || plusLourd.getPoids() < this.get(i).getPoids()) { // Première itération, le premier animal de l'intervalle prend la place du plus lourd
				plusLourd = this.get(i);
			}
		}
		System.out.println("L'animal le plus lourd compris entre " + index1 + " et " + index2 + " est : " + plusLourd.getNom()); // Affiche l'animal le plus lourd compris entre les 2 index
	}
	
	public ArrayList<Animal> genre(boolean g) {
		ArrayList<Animal> genreAnimaux = new ArrayList<Animal>();
		Animal a;
		for (int i=0 ; i<this.size() ; i++) {
			a = this.get(i);
			if (a.isSexe() == g) {
				genreAnimaux.add(a);
			}
		}
		return genreAnimaux;
	}
}

package fr.tp1;

import java.util.ArrayList;
import java.util.Random;

	

public class Ex2 {

	public static void main(String[] args) {
		 
		ArrayList<Integer> aRandom = new ArrayList<>();
		Random rdm = new Random();
		ArrayList<Integer> desSum = new ArrayList<>();
		Des d1 = new Des();
		Des d2 = new Des();
		Des d3 = new Des();
		int s1 = 0,s2 = 0,s3 = 0;
		int sumLancer = 0;
		
		for (int i=0 ; i<300 ; i++) {
			int number = rdm.nextInt((100 - 1) + 1) + 1; // On génére 300 nombres aléatoires compris entre 1 et 100 et on les ajoute au fur et à mesure dans l'ArrayList aRandom
			aRandom.add(i,number);
		}
		System.out.println(aRandom);
	
		
		for (int i=0 ; i<200 ; i++) { // On génére 200 lancers de 3 dés puis on fait la somme de ceux-ci tout en les ajoutant au fur et à mesure dans l'ArrayList desSum
			s1 = d1.lancer();
			s2 = d2.lancer();
			s3 = d3.lancer();
			sumLancer += s1+s2+s3;
			desSum.add(i, sumLancer);
		}
		System.out.println(desSum);

	}
	
	/*public HashMap<Integer[],Integer> histogramme (ArrayList<Integer> list,int pas) {
		
	}*/

}

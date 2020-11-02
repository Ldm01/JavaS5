package fr.tp3.ex1;
import java.util.*;
import java.util.stream.*;

public class Thrds {
	
	public static class Divisible extends Thread {
		private int divisiblePar = 2;
		public List<Integer> list = new ArrayList<Integer>();
		
		/**
		 * Permet de savoir si un element d'un thread est divisible par 2, 3, 5 
		 * @param divs
		 * @param name
		 * @param div
		 */
		public Divisible(ThreadGroup divs, String name, int div) {
			super(divs, name);
			this.divisiblePar = div;
		}
		
		/**
		 * Permet de définir l'action que le thread va executer
		 */
		public void run() {
			List<Integer> dlist = new ArrayList<Integer>();
			for(Integer l:list) {
				if(l % divisiblePar == 0){
					dlist.add(l);
				}
			}
			System.out.println(this.getName() + " est terminé :" + dlist);
		}
	}

	public static void main(String[] args) {
		// On crée les différentes listes de nombres via les streams
		List<Integer> list2 = IntStream.
				range(1, 11).
				boxed().
				collect(Collectors.toList());
		List<Integer> list3 = IntStream.
				range(1, 1001).
				boxed().
				collect(Collectors.toList());
		List<Integer> list5 = IntStream.
				range(1, 100001).
				boxed().
				collect(Collectors.toList());
		
		// On crée les threads
		ThreadGroup divs = new ThreadGroup("Groupe de division");
		Divisible div2 = new Divisible(divs, "div2", 2);
		Divisible div3 = new Divisible(divs, "div3", 3);
		Divisible div5 = new Divisible(divs, "div5", 5);
		
		div2.list = list2;
		div3.list = list3;
		div5.list = list5;
		div2.start();
		div3.start();
		div5.start();
		
		// On execute chaque thread
		//while (div2.isAlive() && div3.isAlive() && div5.isAlive()) {
		while (div5.isAlive() || div3.isAlive() || div2.isAlive()) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		divs.stop();
		System.out.println("Division terminée");
	}
}

/* Tous les résultats ne sont pas affichés. En effet, il manque la liste des diviseurs de 5. Pour l'afficher, il suffit de changer les && en || dans le while, car quand les
 * threads de la liste des 2 et 3 a fini, le 5 n'est pas forcément fini, il fallait donc un moyen de continuer la boucle malgré cela */ 

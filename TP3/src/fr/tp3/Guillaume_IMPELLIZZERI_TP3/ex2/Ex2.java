package fr.tp3.ex2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ex2 {
	public static class Mapping extends Thread {
		String input_string;
		Map<String,Integer> output_map;
		
		public void run() {
			// REGEX
			input_string = input_string.replaceAll(",", " ,");
			input_string = input_string.replaceAll("'", " ");
			input_string = input_string.replaceAll("\\.", " \\.");
			String mots[] = input_string.split(" ");
			
			// Map de sortie
			output_map = new HashMap<String,Integer>();
			
			for (String e : mots) {
				if (output_map.containsKey(e)) { // Si le mot est deja pr�sent, on rajoute 1 � son nombre d'occurences
					output_map.put(e, output_map.get(e) + 1);
				} else {
					output_map.put(e, 1);
				}
					
			}
			output_map.remove(" ");
			System.out.println("Mapping : " +  output_map.toString() + "\n");
		}
		
	}
	
	public static class Reduce extends Thread {
		ArrayList<Map<String,Integer>> input_list;
		Map<String,Integer> output_map;
		
		public void run() { 
		int index = 0;
		output_map = new HashMap<String,Integer>();
			
			// On rajoute 1 � la valeur si on est d�j� tomb� dessus
			for (Map.Entry<String,Integer> e : input_list.get(index).entrySet()) {
				if (!output_map.containsKey(e)) {
					output_map.put(e.getKey(), e.getValue());
				} else {
					Integer u = output_map.get(e.getValue());
					output_map.replace(e.getKey(), e.getValue() + u);
				}
			}
		}
	}
	
	public static void main (String [] args) {
		// Initialisation des String
		String s1 = "Un jeune et timide 'Hobbit', Frodon Sacquet, h�rite d'un anneau magique. Bien loin d'�tre\r\n" + 
				"une simple babiole, il s'agit d'un instrument de pouvoir absolu qui permettrait � Sauron,\r\n" + 
				"le 'Seigneur des t�n�bres', de r�gner sur la 'Terre du Milieu' et de r�duire en esclavage ses\r\n" + 
				"peuples. Frodon doit parvenir jusqu'� la 'Crevasse du Destin' pour d�truire l'anneau.\r\n" + 
				"";
		String s2 = "Apr�s la mort de Boromir et la disparition de Gandalf, la 'Communaut�' s'est scind�e en\r\n" + 
				"trois. Perdus dans les collines d''Emyn Muil', Frodon et Sam d�couvrent qu'ils sont suivis\r\n" + 
				"par Gollum, une cr�ature versatile corrompue par l'anneau magique. Gollum promet de\r\n" + 
				"conduire les 'Hobbits' jusqu'� la 'Porte Noire' du 'Mordor'. A travers la 'Terre du Milieu',\r\n" + 
				"Aragorn, Legolas et Gimli font route vers le 'Rohan', le royaume assi�g� de Theoden.\r\n" + 
				"";
		String s3 = "Les arm�es de Sauron ont attaqu� 'Minas Tirith', la capitale de 'Gondor'. Jamais ce\r\n" + 
				"royaume autrefois puissant n'a eu autant besoin de son roi. Cependant, Aragorn\r\n" + 
				"trouvera-t-il en lui la volont� d'accomplir sa destin�e ? Tandis que Gandalf s'efforce de\r\n" + 
				"soutenir les forces bris�es de Gondor, Th�oden exhorte les guerriers de Rohan � se joindre\r\n" + 
				"au combat. Cependant, malgr� leur courage et leur loyaut�, les forces des Hommes ne\r\n" + 
				"sont pas de taille � lutter contre les innombrables l�gions d'ennemis";
		
		// Initialisation des threads
		Mapping t1 = new Mapping();
		Mapping t2 = new Mapping();
		Mapping t3 = new Mapping();
		
		Reduce firstReducer = new Reduce();
		Reduce secondReducer = new Reduce();
		Reduce thirdReducer = new Reduce();
		
		// On met les string dans les threads Mapping
		t1.input_string = s1;
		t2.input_string = s2;
		t3.input_string = s3;
		
		t1.start();
		t2.start();
		t3.start();
		
		// Execution des threads
		while (t1.isAlive() || t2.isAlive() || t3.isAlive()) {
			try {
				Thread.sleep(1);
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		// Dans une liste de map on rajoute le resultat des threads Mapping
		ArrayList<Map<String,Integer>> forReduce = new ArrayList<Map<String,Integer>>();
		forReduce.add(t1.output_map);
		forReduce.add(t2.output_map);
		forReduce.add(t3.output_map);
		
		// Variable permettant d'initialiser le thread
		Reduce rT = new Reduce();
		rT.input_list = forReduce;
		
		// Execution du thread Mapping
		while (rT.isAlive()) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		System.out.println("\n" + forReduce.toString());
		
		
		
		
		
		

	}
}

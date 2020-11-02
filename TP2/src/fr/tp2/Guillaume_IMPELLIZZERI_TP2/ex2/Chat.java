package fr.tp2.ex2;

public class Chat extends Animal {

	public Chat(String nom, double poids, boolean sexe) {
		super(nom, poids, sexe);
		this.setType(Type_animal.CHAT);
	}

}

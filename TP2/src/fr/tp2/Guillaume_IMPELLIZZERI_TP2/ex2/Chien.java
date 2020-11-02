package fr.tp2.ex2;

public class Chien extends Animal {
	private boolean chien_de_chasse;

	public Chien(String nom, double poids, boolean sexe, boolean chien_de_chasse) {
		super(nom, poids, sexe);
		this.setType(Type_animal.CHIEN);
		this.chien_de_chasse = chien_de_chasse;
	}

	public boolean isChien_de_chasse() {
		return chien_de_chasse;
	}

	public void setChien_de_chasse(boolean chien_de_chasse) {
		this.chien_de_chasse = chien_de_chasse;
	}

}

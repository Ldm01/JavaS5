package fr.tp2.ex2;

public abstract class Animal {
	private String nom;
	private Type_animal type;
	private double poids;
	private boolean sexe; // true = F / false = H
	
	public Animal(String nom, double poids, boolean sexe) {
		this.nom = nom;
		this.poids = poids;
		this.sexe = sexe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Type_animal getType() {
		return type;
	}

	public void setType(Type_animal type) {
		this.type = type;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public boolean isSexe() {
		return sexe;
	}

	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}
	
	

}

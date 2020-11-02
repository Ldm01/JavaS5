package fr.tp2.ex2;

public class Poisson extends Animal {
	private boolean eaux_douces;
	private int temperature;

	public Poisson(String nom, double poids, boolean sexe, boolean eaux_douces, int temperature) {
		super(nom, poids, sexe);
		this.setType(Type_animal.POISSON);
		this.eaux_douces = eaux_douces;
		this.temperature = temperature;
	}

	public boolean isEaux_douces() {
		return eaux_douces;
	}

	public void setEaux_douces(boolean eaux_douces) {
		this.eaux_douces = eaux_douces;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

}

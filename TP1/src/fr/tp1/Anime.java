package fr.tp1;

import java.util.Comparator;

public class Anime {
	private String titre;
	private double musique;
	private double graphique;
	private double storyline;
	private double personnages;
	private Double moyenne;
	
	public Anime(String titre, double musique, double graphique, double storyline, double personnages) {
		this.titre = titre;
		this.musique = musique;
		this.graphique = graphique;
		this.storyline = storyline;
		this.personnages = personnages;
		moyenne = (this.musique + this.graphique + this.storyline + this.personnages) / 4;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public double getMusique() {
		return musique;
	}

	public void setMusique(double musique) {
		this.musique = musique;
	}

	public double getGraphique() {
		return graphique;
	}

	public void setGraphique(double graphique) {
		this.graphique = graphique;
	}

	public double getStoryline() {
		return storyline;
	}

	public void setStoryline(double storyline) {
		this.storyline = storyline;
	}

	public double getPersonnages() {
		return personnages;
	}

	public void setPersonnages(double personnages) {
		this.personnages = personnages;
	}
	
	public Double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(Double moyenne) {
		this.moyenne = moyenne;
	}
	
	@Override
	public String toString() {
		return "Titre : " + this.titre + ", Musique : " + this.musique + ", Graphique : " + this.graphique + ", Storyline : " + this.storyline + ", Personnages : " + this.personnages + "\n";  
	}
	
	static class ComparerNomAnime implements Comparator<Object> {
		@Override
		public int compare(Object aCompare1, Object aCompare2) {
			Anime anime1 = (Anime)aCompare1;
			Anime anime2 = (Anime)aCompare2;
			
			return anime1.titre.compareTo(anime2.titre);
		}
	}
	
	static class ComparerMoyenneAnime implements Comparator<Object> {
		@Override
		public int compare(Object aCompare1, Object aCompare2) {
			Anime anime1 = (Anime)aCompare1;
			Anime anime2 = (Anime)aCompare2;
			
			return anime1.getMoyenne().compareTo(anime2.getMoyenne());
		}
	}

}

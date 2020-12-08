package fr.moviesproject.app;

import java.util.ArrayList;

public class People {
	protected int peoId = 0;
	protected String peoName = "";
	protected String role = "";
	protected ArrayList<Movie> movies = new ArrayList<Movie>();
	
	public People(int peoId, String peoName, String role) {
		this.peoId = peoId;
		this.peoName = peoName;
		this.role = role;
	}

	public int getPeoId() {
		return peoId;
	}

	public void setPeoId(int peoId) {
		this.peoId = peoId;
	}

	public String getPeoName() {
		return peoName;
	}

	public void setPeoName(String peoName) {
		this.peoName = peoName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}
	
	public ArrayList<Movie> getMovies() {
		return movies;
	}


}

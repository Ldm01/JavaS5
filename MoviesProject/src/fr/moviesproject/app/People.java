package fr.moviesproject.app;

import java.util.ArrayList;

public class People {
	protected int peoId = 0;
	protected String peoName = "";
	protected String role = "";
	protected Movie movie = new Movie(0,"");
	
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
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public Movie getMovie() {
		return movie;
	}


}

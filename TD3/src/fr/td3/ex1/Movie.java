package fr.td3.ex1;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Movie {
	protected int id = 0;
	protected String title = "";
	protected String poster = "";
	protected int year = 1995;
	
	public Movie(int id, String title) {
		this.id = id;
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Titre du film : " + title + "\n Année de sortie : " + year;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
	
	public Image getPoster() {
		Image img = null;
		try {
			URL url = new URL(this.poster);
			img = ImageIO.read(url);
		} catch (IOException e) {
			return img;
		}
		return img;
	}
}

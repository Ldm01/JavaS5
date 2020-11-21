package fr.moviesproject.app;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Movie {
	protected int id = 0;
	protected String title = "";
	protected String poster = "";
	protected int year = 1995;
	protected String genres = "";
	//protected String releaseDate = "";
	protected String synopsis = "";
	protected double rating;
	
	public Movie(int id, String title) {
		this.id = id;
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		} catch(IOException e) {
			return img;
		}
		return img;
	}
}

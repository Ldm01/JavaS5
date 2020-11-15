package fr.td3.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Connexion {
	public String host = "localhost";
	public int port = 3306;
	public String db = "movielens";
	public String user = "root";	
	public String pass = "";
	private Boolean connected = false;
	private Connection connexion;
	private Statement sql;
	private List<Integer> MoviesId = new ArrayList<Integer>();
	private int currentId = 0;
	
	public Connexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String lien = "jdbc:mysql://" + host + ":" + port + "/" + db;
			System.out.println(lien);
			this.connexion = DriverManager.getConnection(lien,this.user,this.pass);
			this.connected = true;
			
			sql = this.connexion.createStatement();
			ResultSet rs = sql.executeQuery("SELECT * FROM movie");
			MoviesId.clear();
			currentId = 0;
			while (rs.next()) {
				MoviesId.add(rs.getInt(1));
			}
			
			System.out.println("Connection...");
			this.connected = true;
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Movie getMovie() {
		Movie movie = new Movie(0, "");
		try {
			sql = this.connexion.createStatement();
			ResultSet rs = sql.executeQuery("SELECT * FROM movie WHERE mov_id = " + this.MoviesId.get(this.currentId));
			while (rs.next()) {
				movie = new Movie(rs.getInt(1), rs.getString(3));
				movie.setPoster(rs.getString(4));
				movie.setYear(rs.getInt("year"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movie;
	}
	
	public void deconnexion() {
		try {
			this.connexion.close();
			connected = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Movie nextMovie() {
		this.currentId = (this.currentId + 1) % this.MoviesId.size();
		return this.getMovie();
	}
}

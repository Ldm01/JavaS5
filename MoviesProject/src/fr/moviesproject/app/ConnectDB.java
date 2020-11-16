package fr.moviesproject.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectDB {
	public String host = "localhost";
	public int port = 3306;
	public String db = "movielens";
	public String user = "root";	
	public String pass = "";
	private Boolean connected = false;
	private Connection connection;
	private Statement sql;
	private List<Integer> MoviesId = new ArrayList<Integer>();
	private int currentId = 0;
	
	public ConnectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String link = "jdbc:mysql://" + host + ":" + port + "/" + db;
			
			System.out.println("Database used : " + link);
			
			this.connection = DriverManager.getConnection(link,this.user,this.pass);
			this.connected = true;
			
			sql = this.connection.createStatement();
			ResultSet rs = sql.executeQuery("SELECT * FROM movie");
			MoviesId.clear();
			currentId = 0;
			
			while(rs.next()) {
				MoviesId.add(rs.getInt("mov_id"));
			}
			
			System.out.println("Connection to the database... Please wait...");
			this.connected = true;
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Movie getMovie() {
		Movie movie = new Movie(0,"");
		try {
			sql = this.connection.createStatement();
			ResultSet rs = sql.executeQuery("SELECT * FROM movie WHERE mov_id = " + this.MoviesId.get(this.currentId));
			
			while (rs.next()) {
				movie = new Movie(rs.getInt("mov_id"), rs.getString("title"));
				movie.setPoster(rs.getString("poster"));
				movie.setYear(rs.getInt("year"));
				movie.setRating(rs.getDouble("rating"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movie;
	}
	
	public void disconnect() {
		try {
			this.connection.close();
			connected = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Movie nextMovie() {
		this.currentId = (this.currentId + 1) % this.MoviesId.size();
		return this.getMovie();
	}
	
	public Movie lastMovie() {
		this.currentId = (this.currentId - 1) % this.MoviesId.size();
		return this.getMovie();
	}
	
	public Movie selectMovie() {
		this.currentId = MainFrame.getMainPanel().getIdMovieField() - 1;
		return this.getMovie();
	}
}

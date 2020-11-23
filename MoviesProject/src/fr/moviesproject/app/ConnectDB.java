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
	
	public int getCurrentId() {
		return currentId;
	}

	public void setCurrentId(int currentId) {
		this.currentId = currentId;
	}

	public Movie getMovie() {
		Movie movie = new Movie(0,"");
		try {
			sql = this.connection.createStatement();
			System.out.println(this.currentId);
			ResultSet rs = sql.executeQuery("SELECT * FROM movie WHERE mov_id = " + this.MoviesId.get(this.currentId));
			
			while (rs.next()) {
				movie = new Movie(rs.getInt("mov_id"), rs.getString("title"));
				movie.setPoster(rs.getString("poster"));
				movie.setYear(rs.getInt("year"));
				movie.setRating(rs.getDouble("rating"));
				movie.setGenres(rs.getString("genres"));
				movie.setSynopsis(rs.getString("synopsis"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movie;
	}
	
	public ArrayList<People> getInfos(int id) {
		ArrayList<People> peopleList = new ArrayList<People>();
		try {
			sql = this.connection.createStatement();
			ResultSet rs = sql.executeQuery("SELECT * FROM role INNER JOIN people ON people.peo_id = role.peo_id WHERE mov_id = " + id);
			
			int i = 0;
			while (rs.next()) {
				peopleList.add(i, new People(rs.getInt("peo_id"), rs.getString("peo_name"), rs.getString("rol_name")));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return peopleList;
	}
	
	public ArrayList<Movie> searchMovie(String movieTitle) {
		ArrayList<Movie> arrayMovie = new ArrayList<Movie>();
		try {
			sql = this.connection.createStatement();
			ResultSet rs = sql.executeQuery("SELECT * FROM movie WHERE title LIKE \""+ movieTitle +"%\" ");
			
			int i = 0;
			while (rs.next()) {
				arrayMovie.add(new Movie(rs.getInt("mov_id"), rs.getString("title")));
				arrayMovie.get(i).setYear(rs.getInt("year"));
				arrayMovie.get(i).setPoster(rs.getString("poster"));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayMovie;
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
		if (this.currentId == -1) {
			this.currentId = MoviesId.size() - 1;
		}
		return this.getMovie();
	}
	
	public Movie selectMovie(int idMovie) {
		this.currentId = idMovie - 1;
		this.currentId = this.MoviesId.indexOf(idMovie);
		System.out.println("ID : " + this.MoviesId.get(this.currentId));
		return this.getMovie();
	}
}

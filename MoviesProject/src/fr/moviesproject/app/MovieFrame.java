package fr.moviesproject.app;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MovieFrame extends JFrame {
	private static MainFrame mainFrame;
	private static MovieFrame movieFrame;
	private static MoviePanel moviePanel;
	private static ConnectDB connexion = new ConnectDB();
	private int id;
	
	public MovieFrame(int id) {
		this.setSize(550, 860);
		this.setLocationRelativeTo(null); // Permet de centrer la fenêtre à l'ouverture
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.id = id;
		
		this.setTitle("Movies Project - " + connexion.selectMovie(id).getTitle());
		
		this.setContentPane(moviePanel = new MoviePanel(this));
		
		this.setVisible(true);
	}
	
	public static MovieFrame getMovieFrame() {
		return movieFrame;
	}
	
	public static MoviePanel getMoviePanel() {
		return moviePanel;
	}
	
	public int getId() {
		return id;
	}
}

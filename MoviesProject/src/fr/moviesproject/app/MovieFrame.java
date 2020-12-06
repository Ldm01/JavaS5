package fr.moviesproject.app;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MovieFrame extends JFrame {
	private static MainFrame mainFrame;
	private static MovieFrame movieFrame;
	private static MoviePanel moviePanel;
	
	public MovieFrame() {
		this.setTitle("Movies Project - Titre film");
		this.setSize(550, 860);
		this.setLocationRelativeTo(null); // Permet de centrer la fenêtre à l'ouverture
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setContentPane(moviePanel = new MoviePanel());
		
		this.setVisible(true);
	}
	
	public static MovieFrame getMovieFrame() {
		return movieFrame;
	}
	
	public static MoviePanel getMoviePanel() {
		return moviePanel;
	}
}

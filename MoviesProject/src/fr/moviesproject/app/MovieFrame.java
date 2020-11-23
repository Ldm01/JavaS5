package fr.moviesproject.app;

import javax.swing.JFrame;

public class MovieFrame extends JFrame {
	private static MainFrame mainFrame;
	private static MovieFrame movieFrame;
	private static MainPanel mainPanel;
	
	public MovieFrame() {
		this.setTitle("Movies Project");
		this.setSize(550, 950);
		this.setLocationRelativeTo(null); // Permet de centrer la fenêtre à l'ouverture
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setContentPane(mainPanel = new MainPanel());
		
		this.setVisible(true);
	}
}

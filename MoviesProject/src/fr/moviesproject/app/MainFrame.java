package fr.moviesproject.app;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private static MainFrame mainFrame;
	private static MainPanel mainPanel;
	private static MovieFrame movieFrame;

	public MainFrame() {
		this.setTitle("Movies Project");
		this.setSize(550, 950);
		this.setLocationRelativeTo(null); // Permet de centrer la fen�tre � l'ouverture
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setContentPane(mainPanel = new MainPanel());
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		mainFrame = new MainFrame();
		//PeopleFrame pF = new PeopleFrame();
	}
	
	public static MainFrame getMainFrame() {
		return mainFrame;
	}

	public static MainPanel getMainPanel() {
		return mainPanel;
	}

}

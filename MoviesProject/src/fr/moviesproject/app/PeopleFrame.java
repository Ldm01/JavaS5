package fr.moviesproject.app;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class PeopleFrame extends JFrame {
	private static PeopleFrame peoFrame;
	private static PeoplePanel peoPanel;

	public PeopleFrame() {
		this.setTitle("Movies Project");
		this.setSize(550, 950);
		this.setLocationRelativeTo(null); // Permet de centrer la fenêtre à l'ouverture
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setContentPane(peoPanel = new PeoplePanel());
		
		this.setVisible(true);
	}
	
	public static PeopleFrame getPeoFrame() {
		return peoFrame;
	}

	public static PeoplePanel getPeoPanel() {
		return peoPanel;
	}
}

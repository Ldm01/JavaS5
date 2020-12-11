package fr.moviesproject.app;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class PeopleFrame extends JFrame {
	private static PeopleFrame peoFrame;
	private static PeoplePanel peoPanel;
	private static ConnectDB connexion = new ConnectDB();
	private int idPeople;
	
	public PeopleFrame(int id) {
		this.setSize(950, 680);
		this.setLocationRelativeTo(null); // Permet de centrer la fenêtre à l'ouverture
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.idPeople = id;
		this.setTitle("Movies Project - " + connexion.getPeopleMovies(id).get(0).getPeoName());
		System.out.println("id people " + this.idPeople);
		
		this.setContentPane(peoPanel = new PeoplePanel(this));
		
		this.setVisible(true);
	}
	
	public static PeopleFrame getPeoFrame() {
		return peoFrame;
	}

	public static PeoplePanel getPeoPanel() {
		return peoPanel;
	}
	
	public void setIdPeople(int idPeople) {
		this.idPeople = idPeople;
	}
	
	public int getIdPeople() {
		return idPeople;
	}
}

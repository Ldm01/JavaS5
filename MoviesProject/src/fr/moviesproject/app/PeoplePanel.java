package fr.moviesproject.app;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class PeoplePanel extends JPanel {
	private static ConnectDB connexion = new ConnectDB();
	
	private static People peo;
	
	private JButton backBtn = new JButton("Retour");
	
	private JLabel peoName = new JLabel("Harrison Ford");
	private JLabel moviePoster = new JLabel(new ImageIcon()); // faire en boucle
	private JLabel movieTitle = new JLabel("Titre"); // faire en boucle
	private JLabel movieYear = new JLabel("1996"); // faire en boucle
	private JLabel role = new JLabel("role"); // faire en boucle
	
	
	public PeoplePanel() {
		this.setLayout(null);
		
		JPanel actorBox = new JPanel();
		actorBox.setLayout(null);
		actorBox.setSize(950, 680);
		
		backBtn.setBounds(10, 10, 100, 35);
		backBtn.setFont(new Font("Verdana", Font.PLAIN, 15));
		backBtn.setBackground(Color.BLACK);
		backBtn.setForeground(Color.WHITE);
		this.add(backBtn);
		
		peoName.setOpaque(true);
		peoName.setBounds(10, 55, 910, 50);
		peoName.setBackground(Color.BLACK);
		peoName.setHorizontalAlignment(JLabel.CENTER);
		peoName.setFont(new Font("Verdana", Font.PLAIN, 18));
		peoName.setForeground(Color.WHITE);
		this.add(peoName);
		
		moviePoster.setOpaque(true);
		moviePoster.setBounds(10, 125, 303, 400);
		moviePoster.setBackground(Color.YELLOW);
		actorBox.add(moviePoster);
		
		movieTitle.setOpaque(true);
		movieTitle.setBounds(10, 525, 303, 35);
		movieTitle.setBackground(Color.BLACK);
		movieTitle.setHorizontalAlignment(JLabel.CENTER);
		movieTitle.setFont(new Font("Verdana", Font.PLAIN, 18));
		movieTitle.setForeground(Color.WHITE);
		actorBox.add(movieTitle);
		
		movieYear.setOpaque(true);
		movieYear.setBounds(10, 560, 303, 35);
		movieYear.setBackground(Color.ORANGE);
		movieYear.setHorizontalAlignment(JLabel.CENTER);
		movieYear.setFont(new Font("Verdana", Font.PLAIN, 18));
		movieYear.setForeground(Color.WHITE);
		actorBox.add(movieYear);
		
		role.setOpaque(true);
		role.setBounds(10, 595, 303, 35);
		role.setBackground(Color.GREEN);
		role.setHorizontalAlignment(JLabel.CENTER);
		role.setFont(new Font("Verdana", Font.PLAIN, 18));
		role.setForeground(Color.WHITE);
		actorBox.add(role);
		
		this.add(actorBox);
	}
}

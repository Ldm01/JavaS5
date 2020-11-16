package fr.moviesproject.app;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	private static ConnectDB connexion = new ConnectDB();
	private static Movie currentMovie = connexion.getMovie();
	
	
	private JTextField searchTitle = new JTextField("Recherche par titre");
	private JTextField searchName = new JTextField("Recherche par nom (acteur, ...)");
	
	private JTextField idMovieField = new JTextField(Integer.toString(currentMovie.getId()));
	
	private JButton goTitle = new JButton("Go");
	private JButton goName = new JButton("Go");
	private JButton lastMovie = new JButton("Précédent");
	private JButton nextMovie = new JButton("Suivant");
	
	private Font fontBtn = new Font("Verdana", Font.PLAIN, 15);
	
	private JLabel movieTitle = new JLabel(currentMovie.getTitle());
	private JLabel moviePoster = new JLabel(new ImageIcon(currentMovie.getPoster()));
	
	
	public MainPanel() {
		this.setLayout(null);
	    
		try {
	        initComponents();
	    } catch (Exception e) {
	    	System.out.println(e);
	    }
		
	}
	
	public void initComponents() {

		searchTitle.setBounds(10, 10, 410, 35);
		searchTitle.setFont(fontBtn);
		
		goTitle.setBounds(420, 10, 100, 35);
		goTitle.setFont(fontBtn);
		goTitle.setBackground(Color.BLACK);
		goTitle.setForeground(Color.WHITE);
		
		searchName.setBounds(10, 50, 410, 35);
		searchName.setFont(fontBtn);
		
		goName.setBounds(420, 50, 100, 35);
		goName.setFont(fontBtn);
		goName.setBackground(Color.BLACK);
		goName.setForeground(Color.WHITE);
		
		lastMovie.setBounds(10, 100, 150, 35);
		lastMovie.setFont(fontBtn);
		lastMovie.setBackground(Color.BLACK);
		lastMovie.setForeground(Color.WHITE);
		
		idMovieField.setBounds(165, 100, 200, 35);
		idMovieField.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		nextMovie.setBounds(370, 100, 150, 35);
		nextMovie.setFont(fontBtn);
		nextMovie.setBackground(Color.BLACK);
		nextMovie.setForeground(Color.WHITE);
		
		idMovieField.setHorizontalAlignment(JTextField.CENTER);
		
		movieTitle.setBounds(10, 150, 520, 35);
		movieTitle.setFont(new Font("Verdana", Font.PLAIN, 20));
		movieTitle.setHorizontalAlignment(JLabel.CENTER);
		movieTitle.setBackground(Color.BLACK);
		movieTitle.setForeground(Color.WHITE);
		
		moviePoster.setBounds(112, 200, 300, 448);
		
		this.add(searchTitle);
		this.add(goTitle);
		this.add(searchName);
		this.add(goName);
		this.add(lastMovie);
		this.add(idMovieField);
		this.add(nextMovie);
		this.add(movieTitle);
		this.add(moviePoster);
		
		nextMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentMovie = connexion.nextMovie();
				movieTitle.setText(currentMovie.getTitle());
				idMovieField.setText(Integer.toString(currentMovie.getId()));
				if (currentMovie.getPoster() != null) {
					moviePoster.setIcon(new ImageIcon(currentMovie.getPoster()));
				} else {
					moviePoster.setIcon(null);
				}
				MainFrame.getMainFrame().repaint();
			}
		});

		lastMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentMovie = connexion.lastMovie();
				movieTitle.setText(currentMovie.getTitle());
				idMovieField.setText(Integer.toString(currentMovie.getId()));
				if (currentMovie.getPoster() != null) {
					moviePoster.setIcon(new ImageIcon(currentMovie.getPoster()));
				} else {
					moviePoster.setIcon(null);
				}
				MainFrame.getMainFrame().repaint();
			}
		});
	}
}

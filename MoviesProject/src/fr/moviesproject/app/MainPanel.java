package fr.moviesproject.app;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	private JTextField searchTitle = new JTextField("Recherche par titre");
	private JTextField searchName = new JTextField("Recherche par nom (acteur, ...)");
	private JTextField idMovieField = new JTextField("0");
	
	private JButton goTitle = new JButton("Go");
	private JButton goName = new JButton("Go");
	private JButton lastMovie = new JButton("Précédent");
	private JButton nextMovie = new JButton("Suivant");
	
	private Font fontBtn = new Font("Verdana", Font.PLAIN, 15);
	
	public MainPanel() {
		this.setLayout(null);
		
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
		
		this.add(searchTitle);
		this.add(goTitle);
		this.add(searchName);
		this.add(goName);
		this.add(lastMovie);
		this.add(idMovieField);
		this.add(nextMovie);
	}
}

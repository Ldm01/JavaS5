package fr.td3.ex1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Main {
	public static JLabel lbl_image;
	public static JLabel lbl_title;
	public static Movie currentMovie;
	
	public static void main(String[] args) {
		Connexion connexion = new Connexion();
		currentMovie = connexion.getMovie();
		
		lbl_title = new JLabel(currentMovie.getTitle());
		lbl_image = new JLabel(new ImageIcon(currentMovie.getPoster()));
		
		JFrame frame = new JFrame();
		
		JButton btn_next = new JButton("Suivant");
		btn_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentMovie = connexion.nextMovie();
				lbl_title.setText(currentMovie.getTitle());
				if (currentMovie.getPoster() != null) {
					lbl_image.setIcon(new ImageIcon(currentMovie.getPoster()));
				} else {
					lbl_image.setIcon(null);
				}
				frame.repaint();
			}
		});
		
		frame.setSize(600, 600);
		
		btn_next.setBounds(10, 10, 100, 30);
		frame.add(btn_next);
		
		lbl_title.setBounds(150, 10, 300, 30);
		frame.add(lbl_title);
		frame.add(lbl_image);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}

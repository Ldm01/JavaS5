package fr.moviesproject.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private static MainFrame mainFrame;
	private static MainPanel mainPanel;

	public MainFrame() {
		this.setTitle("Movies Project");
		this.setSize(550, 900);
		this.setLocationRelativeTo(null); // Permet de centrer la fenêtre à l'ouverture
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setContentPane(mainPanel = new MainPanel());
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		mainFrame = new MainFrame();
	}
	
	public static MainFrame getMainFrame() {
		return mainFrame;
	}

	public static MainPanel getMainPanel() {
		return mainPanel;
	}

}

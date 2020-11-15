package fr.moviesproject.app;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	private JTextField searchTitle = new JTextField("Recherche par titre");
	private JTextField searchName = new JTextField("Recherche par nom (acteur, ...)");
	
	private JButton goTitle = new JButton("Go");
	private JButton goName = new JButton("Go");
	
	public MainPanel() {
		
	}
}

package fr.moviesproject.app;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	protected static JTextField searchTitle = new JTextField("Recherche par titre");
	protected JTextField searchName = new JTextField("Recherche par nom (acteur, ...)");
	
	protected JButton goTitle = new JButton("Go");
	protected JButton goName = new JButton("Go");
	
	public MainPanel() {
		this.setLayout(null);
		
		searchTitle.setBounds(10, 10, 410, 35);
		goTitle.setBounds(420, 10, 100, 35);
		searchName.setBounds(10, 55, 410, 35);
		goName.setBounds(420, 55, 100, 35);
		
		this.add(searchTitle);
		this.add(goTitle);
		this.add(searchName);
		this.add(goName);
	}
}

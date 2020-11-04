package fr.td2.ex2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class FirstSwingExample {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		JButton btn_ouvrir = new JButton("Ouvrir");
		
		JLabel lbl_file = new JLabel("hello");
		JButton btn_a = new JButton("filtre");
		
		JTextArea jt_resultat = new JTextArea("", 10, 10);
		JScrollPane scroll = new JScrollPane(jt_resultat);
		
		scroll.setBounds(10, 60, 350, 350);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frame.add(scroll);
		
		btn_a.setBounds(400,60,100,40);
		frame.add(btn_a);
		
		btn_ouvrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(btn_ouvrir);
				lbl_file.setText(fc.getSelectedFile().getAbsolutePath());
			}
		});
		
		btn_a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Stream<String> stream = Files.lines(Paths.get(lbl_file.getText()));
					jt_resultat.setText("");
					stream
					.filter(a -> a.endsWith("a"))
					.forEach(m -> jt_resultat.append(m + "\n"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		lbl_file.setBounds(120,10,350,20);
		frame.add(lbl_file);
		
		btn_ouvrir.setBounds(10,10,100,40);// x axis, y axis, width, height
		frame.add(btn_ouvrir);
		
		frame.setSize(600, 600);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}

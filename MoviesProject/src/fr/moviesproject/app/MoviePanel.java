package fr.moviesproject.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class MoviePanel extends JPanel {
	private static ConnectDB connexion = new ConnectDB();
	private static Movie currentMovie = connexion.selectMovie(MainFrame.getMainPanel().getId());
	private static ArrayList<People> infos = connexion.getInfos(currentMovie.getId());
	
	private ArrayList<JLabel> accessInfosList = new ArrayList<JLabel>();
	
	private Font fontBtn = new Font("Verdana", Font.PLAIN, 15);
	
	private JButton backBtn = new JButton("Retour");
	
	private JLabel movieTitle = new JLabel(currentMovie.getTitle());
	private JLabel moviePoster = new JLabel(new ImageIcon(currentMovie.getPoster()));
	private JLabel movieRating = new JLabel("Note : \n" + Double.toString(currentMovie.getRating()) + "/10");
	private JTextArea movieYear = new JTextArea("         Année \n    de production : \n          "+ Integer.toString(currentMovie.getYear()));
	
	private JLabel partTitle = new JLabel("Participants :");
	private JPanel boxInfos = new JPanel();
	private JPanel contentBox = new JPanel();
	private JScrollPane scroll = new JScrollPane(boxInfos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	private JLabel genres = new JLabel("Genres : " + currentMovie.getGenres());
	private JLabel synTitle = new JLabel("Synopsis");
	private JLabel synopsis = new JLabel("<html>" + currentMovie.getSynopsis() + " <br/> </html>");
	
	public MoviePanel() {
		this.setLayout(null);
	    
		try {
	        initComponents();
	    } catch (Exception e) {
	    	System.out.println(e);
	    }
		
	}
	
	public void initComponents() {
		this.repaint();
		System.out.println("Id movie Panel = " + currentMovie.getId());
		backBtn.setBounds(10, 10, 100, 35);
		backBtn.setFont(fontBtn);
		backBtn.setBackground(Color.BLACK);
		backBtn.setForeground(Color.WHITE);
		
		movieTitle.setBounds(10, 55, 510, 35);
		movieTitle.setFont(new Font("Verdana", Font.PLAIN, 20));
		movieTitle.setHorizontalAlignment(JLabel.CENTER);
		movieTitle.setBackground(Color.BLACK);
		movieTitle.setForeground(Color.WHITE);
		movieTitle.setOpaque(true);
		
		moviePoster.setBounds(10, 105, 300, 448);
		
		movieYear.setBounds(320, 105, 200, 80);
		movieYear.setFont(new Font("Verdana", Font.PLAIN, 20));
		movieYear.setBackground(Color.ORANGE);
		movieYear.setEditable(false);
		movieYear.setOpaque(true);
		
		movieRating.setBounds(320, 190, 200, 35);
		movieRating.setHorizontalAlignment(JLabel.CENTER);
		movieRating.setFont(new Font("Verdana", Font.PLAIN, 20));
		movieRating.setBackground(Color.ORANGE);
		movieRating.setOpaque(true);
		
		partTitle.setBounds(320, 235, 200, 35);
		partTitle.setBorder(BorderFactory.createMatteBorder(2, 2, 1, 2, Color.BLACK));
		partTitle.setOpaque(true);
		partTitle.setBackground(Color.ORANGE);
		partTitle.setFont(new Font("Verdana", Font.PLAIN, 20));
		partTitle.setHorizontalAlignment(JLabel.CENTER);
		this.add(partTitle);
		
		boxInfos.setLayout(new BoxLayout(boxInfos, BoxLayout.Y_AXIS));
		scroll.setBounds(320, 270, 200, 281);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		scroll.getVerticalScrollBar().setBorder(BorderFactory.createMatteBorder(1, 0, 0, 2, Color.BLACK));
		this.add(scroll);
		
		genres.setBounds(10, 555, 510, 35);
		genres.setFont(new Font("Verdana", Font.PLAIN, 20));
		genres.setHorizontalAlignment(JLabel.CENTER);
		genres.setBackground(Color.BLACK);
		genres.setForeground(Color.WHITE);
		genres.setOpaque(true);
		
		for (int i=0 ; i<infos.size() ; i++) {
			JLabel infosBtn = new JLabel();
			infosBtn.setText("<html> <B> Personne : </B> " + infos.get(i).getPeoName() + " <br/> <B> Rôle : </B> " + infos.get(i).getRole() + "</html>");
			infosBtn.setPreferredSize(new Dimension(150, 35));
			infosBtn.setBackground(Color.ORANGE);
			infosBtn.setOpaque(true);
			infosBtn.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.BLACK));
			infosBtn.setFont(new Font("Verdana", Font.PLAIN, 10));
			accessInfosList.add(i, infosBtn);
			contentBox.add(accessInfosList.get(i));
		}
			
		contentBox.setLayout(new GridLayout(0,1));
		
		boxInfos.add(contentBox);

		
		synTitle.setBounds(10, 595, 510, 35);
		synTitle.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
		synTitle.setBackground(Color.BLACK);
		synTitle.setForeground(Color.WHITE);
		synTitle.setFont(new Font("Verdana", Font.PLAIN, 20));
		synTitle.setHorizontalAlignment(JLabel.CENTER);
		synTitle.setOpaque(true);
		
		this.add(synTitle);
		
		synopsis.setBounds(10, 630, 510, 180);
		synopsis.setVerticalAlignment(JLabel.TOP);
		synopsis.setBorder(new MatteBorder(0, 2, 2, 2, Color.BLACK));
		synopsis.setFont(new Font("Verdana", Font.PLAIN, 11));
		
		this.add(backBtn);
		this.add(movieTitle);
		this.add(moviePoster);
		this.add(movieRating);
		this.add(movieYear);
		this.add(genres);
		this.add(synopsis);
		
		this.repaint();
		
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getMainFrame().setVisible(true);
				MainFrame.getMainPanel().getMovieFrame().dispose();
			}
		});
	}
}

package fr.moviesproject.app;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class PeoplePanel extends JPanel {
	private static ConnectDB connexion = new ConnectDB();
	private static PeopleFrame pf;
	
	private static ArrayList<People> peo = new ArrayList<People>();
	
	private JButton backBtn = new JButton("Retour");
	
	private JPanel actorBox = new JPanel();
	private JScrollPane scroll = new JScrollPane(actorBox, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	private JLabel peoName = new JLabel();
	
	public PeoplePanel(PeopleFrame pf) {
		this.setLayout(null);
		
		this.pf = pf;
		
		peo = connexion.getPeopleMovies(pf.getIdPeople());
		
		scroll.setBounds(10, 125, 910, 500);
		
		actorBox.setLayout(new GridLayout(0,3));
		
		backBtn.setBounds(10, 10, 100, 35);
		backBtn.setFont(new Font("Verdana", Font.PLAIN, 15));
		backBtn.setBackground(Color.BLACK);
		backBtn.setForeground(Color.WHITE);
		this.add(backBtn);
		
		peoName.setText(peo.get(0).getPeoName());
		peoName.setOpaque(true);
		peoName.setBounds(10, 55, 910, 50);
		peoName.setBackground(Color.BLACK);
		peoName.setHorizontalAlignment(JLabel.CENTER);
		peoName.setFont(new Font("Verdana", Font.PLAIN, 18));
		peoName.setForeground(Color.WHITE);
		this.add(peoName);
		
		for (int i=0 ; i<peo.size() ; i++) {
			JPanel infos = new JPanel();
			infos.setLayout(new BoxLayout(infos, BoxLayout.PAGE_AXIS));
			
			JLabel moviePoster = new JLabel(new ImageIcon());
			if (peo.get(i).getMovie().getPoster() != null) {
				moviePoster.setIcon(new ImageIcon(peo.get(i).getMovie().getPoster().getScaledInstance(200, 250, Image.SCALE_DEFAULT)));
			} else {
				moviePoster.setIcon(new ImageIcon("https://developers.google.com/maps/documentation/streetview/images/error-image-generic.png"));
			}
			moviePoster.setOpaque(true);
			moviePoster.setAlignmentX(CENTER_ALIGNMENT);
			moviePoster.setHorizontalAlignment(JLabel.CENTER);
			moviePoster.setFont(new Font("Verdana", Font.PLAIN, 18));
			moviePoster.setForeground(Color.WHITE);
			moviePoster.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
			infos.add(moviePoster);
			
			JLabel movieInfos = new JLabel("<html>" + peo.get(i).getMovie().getTitle() + "<br/> Année : " + peo.get(i).getMovie().getYear() + "<br/> Rôle : " + peo.get(i).getRole() + "</html>");
			movieInfos.setOpaque(true);
			movieInfos.setBackground(Color.ORANGE);
			movieInfos.setAlignmentX(CENTER_ALIGNMENT);
			movieInfos.setHorizontalAlignment(JLabel.CENTER);
			movieInfos.setFont(new Font("Verdana", Font.PLAIN, 18));
			movieInfos.setForeground(Color.WHITE);
			movieInfos.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
			infos.add(movieInfos);
			
			infos.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
			actorBox.add(infos);
			
		}
		
		this.add(scroll);
		
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getMainFrame();
				if (MainFrame.getMainPanel().getMovieFrame() != null) {
					MainFrame.getMainPanel().getMovieFrame().setVisible(true);
					pf.dispose();
				} else if (MainFrame.getMainPanel().getMovieFrame() == null) {
					MainFrame.getMainFrame().setVisible(true);
					pf.dispose();
				/*} else {
					MainFrame.getMainFrame().setVisible(true);
					pf.dispose();*/
				}
			}
		});
	}
}

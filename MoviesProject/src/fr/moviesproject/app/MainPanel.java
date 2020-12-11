package fr.moviesproject.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	private static ConnectDB connexion = new ConnectDB();
	private static Movie currentMovie = connexion.getMovie();
	private static ArrayList<People> infos = connexion.getInfos(currentMovie.getId());
	private static MovieFrame movieFrame;
	private static PeopleFrame peopleFrame;
	
	
	private JTextField searchTitle = new JTextField("Recherche par titre");
	private JTextField searchName = new JTextField("Recherche par nom (acteur, ...)");
	
	private JTextField idMovieField = new JTextField(Integer.toString(currentMovie.getId()));
	
	private JButton goTitle = new JButton("Go");
	private JButton goName = new JButton("Go");
	private JButton lastMovie = new JButton("Précédent");
	private JButton nextMovie = new JButton("Suivant");
	
	private ArrayList<JLabel> accessInfosList = new ArrayList<JLabel>();
	
	private Font fontBtn = new Font("Verdana", Font.PLAIN, 15);
	
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
	
	private JPanel searchBoxMv = new JPanel();
	private JPanel searchMovie = new JPanel();
	private JScrollPane scrollMv = new JScrollPane(searchBoxMv, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	private static ArrayList<Movie> listMovies = new ArrayList<Movie>();
	

	
	
	public MainPanel() {
		this.setLayout(null);
	    
		try {
	        initComponents();
	    } catch (Exception e) {
	    	System.out.println(e);
	    }
		
	}
	
	public void initComponents() {

		this.add(scrollMv);
		scrollMv.setVisible(false);
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
		
		movieTitle.setBounds(10, 150, 510, 35);
		movieTitle.setFont(new Font("Verdana", Font.PLAIN, 20));
		movieTitle.setHorizontalAlignment(JLabel.CENTER);
		movieTitle.setBackground(Color.BLACK);
		movieTitle.setForeground(Color.WHITE);
		movieTitle.setOpaque(true);
		movieTitle.setToolTipText(currentMovie.getTitle());
		
		moviePoster.setBounds(10, 200, 300, 448);
		
		movieRating.setBounds(320, 285, 200, 35);
		movieRating.setHorizontalAlignment(JLabel.CENTER);
		movieRating.setFont(new Font("Verdana", Font.PLAIN, 20));
		movieRating.setBackground(Color.ORANGE);
		movieRating.setOpaque(true);
		
		movieYear.setBounds(320, 200, 200, 80);
		movieYear.setFont(new Font("Verdana", Font.PLAIN, 20));
		movieYear.setBackground(Color.ORANGE);
		movieYear.setEditable(false);
		movieYear.setOpaque(true);
		
		partTitle.setBounds(320, 330, 200, 35);
		partTitle.setBorder(BorderFactory.createMatteBorder(2, 2, 1, 2, Color.BLACK));
		partTitle.setOpaque(true);
		partTitle.setBackground(Color.ORANGE);
		partTitle.setFont(new Font("Verdana", Font.PLAIN, 20));
		partTitle.setHorizontalAlignment(JLabel.CENTER);
		this.add(partTitle);
		
		boxInfos.setLayout(new BoxLayout(boxInfos, BoxLayout.Y_AXIS));
		scroll.setBounds(320, 365, 200, 281);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		scroll.getVerticalScrollBar().setBorder(BorderFactory.createMatteBorder(1, 0, 0, 2, Color.BLACK));
		this.add(scroll);
		
		genres.setBounds(10, 650, 510, 35);
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
			accessInfosList.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));
			int idPeople = infos.get(i).getPeoId();
			
			infosBtn.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					MainFrame.getMainFrame().setVisible(false);
					peopleFrame = new PeopleFrame(idPeople);
					System.out.println(idPeople);
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					//setCursor(new Cursor(Cursor.HAND_CURSOR));
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});	
		}
			
		contentBox.setLayout(new GridLayout(0,1));
		
		boxInfos.add(contentBox);

		
		synTitle.setBounds(10, 690, 510, 35);
		synTitle.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
		synTitle.setBackground(Color.BLACK);
		synTitle.setForeground(Color.WHITE);
		synTitle.setFont(new Font("Verdana", Font.PLAIN, 20));
		synTitle.setHorizontalAlignment(JLabel.CENTER);
		synTitle.setOpaque(true);
		
		this.add(synTitle);
		
		synopsis.setBounds(10, 725, 510, 180);
		synopsis.setVerticalAlignment(JLabel.TOP);
		synopsis.setBorder(new MatteBorder(0, 2, 2, 2, Color.BLACK));
		synopsis.setFont(new Font("Verdana", Font.PLAIN, 11));
		
		searchBoxMv.setLayout(new BoxLayout(searchBoxMv, BoxLayout.Y_AXIS));
		scrollMv.setBounds(10, 45, 410, 200);
		scrollMv.setBorder(BorderFactory.createEmptyBorder());
		scrollMv.setBackground(Color.BLACK);
		scrollMv.setOpaque(true);
		scrollMv.getVerticalScrollBar().setBorder(BorderFactory.createMatteBorder(1, 0, 0, 2, Color.BLACK));
		
		searchBoxMv.add(searchMovie);
		searchBoxMv.setVisible(false);

		
		System.out.println("Taille de la liste people : " + infos.size());		
		
		this.add(searchTitle);
		this.add(goTitle);
		this.add(searchName);
		this.add(goName);
		this.add(lastMovie);
		this.add(idMovieField);
		this.add(nextMovie);
		this.add(movieTitle);
		this.add(moviePoster);
		this.add(movieRating);
		this.add(movieYear);
		this.add(genres);
		this.add(synopsis);
		
		nextMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentMovie = connexion.nextMovie();
				infos.clear();
				infos = connexion.getInfos(currentMovie.getId());
				movieTitle.setText(currentMovie.getTitle());
				movieRating.setText("Note : \n" + Double.toString(currentMovie.getRating()) + "/10");
				movieYear.setText("         Année \n    de production : \n          "+ Integer.toString(currentMovie.getYear()));
				idMovieField.setText(Integer.toString(currentMovie.getId()));
				genres.setText("Genres : " + currentMovie.getGenres());
				synopsis.setText("<html>" + currentMovie.getSynopsis() + "<br/> </html>");

				
				contentBox.removeAll();
				for (int i=0 ; i<infos.size() ; i++) {
					JLabel infosBtn = new JLabel();
					infosBtn.setText("<html> <B> Personne : </B> " + infos.get(i).getPeoName() + " <br/> <B> Rôle : </B> " + infos.get(i).getRole() + "</html>");
					infosBtn.setPreferredSize(new Dimension(150, 40));
					infosBtn.setBackground(Color.ORANGE);
					infosBtn.setOpaque(true);
					infosBtn.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.BLACK));
					infosBtn.setFont(new Font("Verdana", Font.PLAIN, 10));
					infosBtn.setToolTipText(infos.get(i).getPeoName());
					accessInfosList.add(i, infosBtn);
					contentBox.add(accessInfosList.get(i));
					
					accessInfosList.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));
					int idPeople = infos.get(i).getPeoId();
					
					infosBtn.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mousePressed(MouseEvent e) {
							MainFrame.getMainFrame().setVisible(false);
							peopleFrame = new PeopleFrame(idPeople);
							System.out.println(idPeople);
						}
						
						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseEntered(MouseEvent e) {
							//setCursor(new Cursor(Cursor.HAND_CURSOR));
							
						}
						
						@Override
						public void mouseClicked(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
					});	
				}
	
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
				infos.clear();
				infos = connexion.getInfos(currentMovie.getId());
				movieTitle.setText(currentMovie.getTitle());
				movieRating.setText("Note : \n" + Double.toString(currentMovie.getRating()) + "/10");
				movieYear.setText("         Année \n    de production : \n          "+ Integer.toString(currentMovie.getYear()));
				idMovieField.setText(Integer.toString(currentMovie.getId()));
				genres.setText("Genres : " + currentMovie.getGenres());
				synopsis.setText("<html>" + currentMovie.getSynopsis() + "<br/> </html>");
				
				contentBox.removeAll();
				for (int i=0 ; i<infos.size() ; i++) {
					JLabel infosBtn = new JLabel();
					infosBtn.setText("<html> <B> Personne : </B> " + infos.get(i).getPeoName() + " <br/> <B> Rôle : </B> " + infos.get(i).getRole() + "</html>");
					infosBtn.setPreferredSize(new Dimension(150, 40));
					infosBtn.setBackground(Color.ORANGE);
					infosBtn.setOpaque(true);
					infosBtn.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.BLACK));
					infosBtn.setFont(new Font("Verdana", Font.PLAIN, 10));
					accessInfosList.add(i, infosBtn);
					accessInfosList.add(i, infosBtn);
					System.out.println("Test");
					contentBox.add(accessInfosList.get(i));
					
					accessInfosList.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));
					int idPeople = infos.get(i).getPeoId();
					
					infosBtn.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mousePressed(MouseEvent e) {
							MainFrame.getMainFrame().setVisible(false);
							peopleFrame = new PeopleFrame(idPeople);
							System.out.println(idPeople);
						}
						
						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseEntered(MouseEvent e) {
							//setCursor(new Cursor(Cursor.HAND_CURSOR));
							
						}
						
						@Override
						public void mouseClicked(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
					});	
				}
	
				if (currentMovie.getPoster() != null) {
					moviePoster.setIcon(new ImageIcon(currentMovie.getPoster()));
				} else {
					moviePoster.setIcon(null);
				}
				MainFrame.getMainFrame().repaint();
			}
		});
		
	    idMovieField.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
				currentMovie = connexion.selectMovie(Integer.valueOf(idMovieField.getText()));
				infos.clear();
				infos = connexion.getInfos(currentMovie.getId());
				movieTitle.setText(currentMovie.getTitle());
				movieRating.setText("Note : \n" + Double.toString(currentMovie.getRating()) + "/10");
				movieYear.setText("         Année \n    de production : \n          "+ Integer.toString(currentMovie.getYear()));
				idMovieField.setText(String.valueOf(currentMovie.getId()));
				genres.setText("Genres : " + currentMovie.getGenres());
				synopsis.setText("<html>" + currentMovie.getSynopsis() + "<br/> </html>");
				
				contentBox.removeAll();
				for (int i=0 ; i<infos.size() ; i++) {
					JLabel infosBtn = new JLabel();
					infosBtn.setText("<html> <B> Personne : </B> " + infos.get(i).getPeoName() + " <br/> <B> Rôle : </B> " + infos.get(i).getRole() + "</html>");
					infosBtn.setPreferredSize(new Dimension(150, 40));
					infosBtn.setBackground(Color.ORANGE);
					infosBtn.setOpaque(true);
					infosBtn.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.BLACK));
					infosBtn.setFont(new Font("Verdana", Font.PLAIN, 10));
					accessInfosList.add(i, infosBtn);
					contentBox.add(accessInfosList.get(i));
					
					accessInfosList.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));
					int idPeople = infos.get(i).getPeoId();
					
					infosBtn.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mousePressed(MouseEvent e) {
							MainFrame.getMainFrame().setVisible(false);
							peopleFrame = new PeopleFrame(idPeople);
							System.out.println(idPeople);
						}
						
						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseEntered(MouseEvent e) {
							//setCursor(new Cursor(Cursor.HAND_CURSOR));
							
						}
						
						@Override
						public void mouseClicked(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
					});	
				}
				
				if (currentMovie.getPoster() != null) {
					moviePoster.setIcon(new ImageIcon(currentMovie.getPoster()));
				} else {
					moviePoster.setIcon(null);
				}
				MainFrame.getMainFrame().repaint();
	        }
	    });
	    
	    goTitle.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	searchMovie.removeAll();
				MainFrame.getMainFrame().repaint();
				listMovies.clear();
				System.out.println(listMovies);
				listMovies = connexion.searchMovie(searchTitle.getText());

				for (int i=0 ; i<listMovies.size() ; i++) {
					JLabel movieResult = new JLabel();
					movieResult.setText("<html>" + listMovies.get(i).getTitle() + " <br/> " + listMovies.get(i).getYear());
					movieResult.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
					searchMovie.add(movieResult);
				}
				
				searchMovie.setLayout(new GridLayout(0,1));
				searchBoxMv.setVisible(true);
				scrollMv.setVisible(true);
				nextMovie.setVisible(false);
				lastMovie.setVisible(false);
				searchName.setVisible(false);
				idMovieField.setVisible(false);
				MainFrame.getMainFrame().repaint();
	        }
	    });
	    
	    searchTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchMovie.removeAll();
				MainFrame.getMainFrame().repaint();
				listMovies.clear();
				System.out.println(listMovies);
				listMovies = connexion.searchMovie(searchTitle.getText());

				for (int i=0 ; i<listMovies.size() ; i++) {
					JLabel movieResult = new JLabel();
					movieResult.setText("<html>" + listMovies.get(i).getTitle() + " <br/> " + listMovies.get(i).getYear());
					movieResult.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
					searchMovie.add(movieResult);
					
					movieResult.setCursor(new Cursor(Cursor.HAND_CURSOR));
					int idMovie = listMovies.get(i).getId();
					
					movieResult.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mousePressed(MouseEvent e) {
							MainFrame.getMainFrame().setVisible(false);
							movieFrame = new MovieFrame(idMovie);
						}
						
						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseEntered(MouseEvent e) {
							//setCursor(new Cursor(Cursor.HAND_CURSOR));
							
						}
						
						@Override
						public void mouseClicked(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
					});	
				}
				
				searchMovie.setLayout(new GridLayout(0,1));
				searchBoxMv.setVisible(true);
				scrollMv.setVisible(true);
				nextMovie.setVisible(false);
				lastMovie.setVisible(false);
				searchName.setVisible(false);
				idMovieField.setVisible(false);
				MainFrame.getMainFrame().repaint();
			}
		});
	    
	    movieTitle.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
					MainFrame.getMainFrame().setVisible(false);
					movieFrame = new MovieFrame(currentMovie.getId());			
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				movieTitle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	    
	    searchTitle.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == e.VK_ESCAPE && scrollMv.isVisible()) {
					searchBoxMv.setVisible(false);
					scrollMv.setVisible(false);
					nextMovie.setVisible(true);
					lastMovie.setVisible(true);
					searchName.setVisible(true);
					idMovieField.setVisible(true);
					searchTitle.setText("Recherche par titre");
					MainFrame.getMainFrame().repaint();
					System.out.println("ESCAPE");
				}
				
			}
		});
	    
	    searchTitle.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				searchTitle.setText("");
				
			}
		});
	    
	}
	
	public MovieFrame getMovieFrame() {
		return movieFrame;
	}

	public int getId() {
		System.out.println(currentMovie.getId());
		return currentMovie.getId();
	}
}

package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import Controleur.ControleurAccueil;
import Controleur.ControleurAccueil.Etat;
import DBlink.ConnexionBase;
import DBlink.Ecurie;
import DBlink.Equipe;
import DBlink.Jeu;
import DBlink.Joueur;
import DBlink.Rencontre;
import DBlink.Tournoi;

public class AccueilV2 {
	private static MouseAdapter ma;
	private JFrame frame;
	private JPanel panel_side;
	private JPanel panel_main;
	private ControleurAccueil controleur;

	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccueilV2 window = new AccueilV2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AccueilV2() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ConnexionBase.getConnectionBase();
		controleur = new ControleurAccueil(this);
		frame = new JFrame();
		frame.setTitle("ESporter");
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();
		borderLayout.setVgap(10);
		borderLayout.setHgap(10);
		//frame.setBounds(100, 100, 933, 592);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);			//Pour l'app directement en full screen décommenter cette ligne
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelHeader = new JPanel();
		frame.getContentPane().add(panelHeader, BorderLayout.NORTH);
		panelHeader.setLayout(new BorderLayout(0, 0));

		JLabel lblNomApp = new JLabel("Nom App");
		lblNomApp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelHeader.add(lblNomApp, BorderLayout.CENTER);

		JPanel panelEspace = new JPanel();
		FlowLayout fl_panelEspace = (FlowLayout) panelEspace.getLayout();
		panelHeader.add(panelEspace, BorderLayout.WEST);

		JPanel panelFonctionalites = new JPanel();
		frame.getContentPane().add(panelFonctionalites, BorderLayout.WEST);
		panelFonctionalites.setLayout(new BorderLayout(0, 0));

		JPanel panelFiltrePlusAdmin = new JPanel();
		panelFiltrePlusAdmin.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFonctionalites.add(panelFiltrePlusAdmin);
		panelFiltrePlusAdmin.setLayout(new BorderLayout(0, 0));

		JComboBox comboFiltre = new JComboBox();
		comboFiltre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboFiltre.setModel(new DefaultComboBoxModel(new String[] { "tri", "tri2", "tri 3" }));
		panelFiltrePlusAdmin.add(comboFiltre, BorderLayout.NORTH);

		JPanel panelFiltre = new JPanel();
		panelFiltrePlusAdmin.add(panelFiltre, BorderLayout.CENTER);

		JPanel panelAdmin = new JPanel();
		panelFiltrePlusAdmin.add(panelAdmin, BorderLayout.SOUTH);
		panelAdmin.setLayout(new GridLayout(2, 2, 0, 0));

		JLabel lbladmin = new JLabel("administration");
		panelAdmin.add(lbladmin);

		BtnStyle btnCreeTournois = new BtnStyle(new Color(0, 153, 255), new Color(51, 102, 255),new Color(26, 83, 255), 10);
		btnCreeTournois.setText("Creer Tournoi");
		btnCreeTournois.setForeground(Color.WHITE);
		btnCreeTournois.setName("btnCreerTournoi");
		btnCreeTournois.addActionListener(controleur);
		panelAdmin.add(btnCreeTournois);

		JLabel lblConnecteEnTantQue = new JLabel("Connecte:gestionaire");
		panelAdmin.add(lblConnecteEnTantQue);

		BtnStyle btnDeconnexion = new BtnStyle(new Color(0, 153, 255), new Color(51, 102, 255),new Color(26, 83, 255), 10);
		btnDeconnexion.setText("Se déconnecter");
		btnDeconnexion.setForeground(Color.WHITE);
		panelAdmin.add(btnDeconnexion);

		JPanel panelBtnSelection = new JPanel();
		panelFonctionalites.add(panelBtnSelection, BorderLayout.NORTH);
		panelBtnSelection.setLayout(new GridLayout(0, 2, 20, 20));

		JButton btnTournois = new JButton("Tournois");
		btnTournois.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTournois.addActionListener(controleur);
		btnTournois.setName("Tournois");
		panelBtnSelection.add(btnTournois);

		JButton btnMatch = new JButton("Match");
		btnMatch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMatch.addActionListener(controleur);
		btnMatch.setName("Match");
		panelBtnSelection.add(btnMatch);

		JButton btnJeu = new JButton("Jeu");
		btnJeu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnJeu.addActionListener(controleur);
		btnJeu.setName("Jeu");
		panelBtnSelection.add(btnJeu);

		JButton btnEquipe = new JButton("Equipe");
		btnEquipe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEquipe.addActionListener(controleur);
		btnEquipe.setName("Equipe");
		panelBtnSelection.add(btnEquipe);

		JButton btnEcurie = new JButton("Ecurie");
		btnEcurie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEcurie.addActionListener(controleur);
		btnEcurie.setName("Ecurie");
		panelBtnSelection.add(btnEcurie);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		panel_main = new JPanel();
		scrollPane.setViewportView(panel_main);
		panel_main.setLayout(new GridLayout(12, 3, 10, 10));

		panel_side = new JPanel();
		frame.getContentPane().add(panel_side, BorderLayout.EAST);
		/*
		
		
		
		*/
		for (Component ie : panel_main.getComponents()) {
			ie.addMouseListener(ma);
		}
		frame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent componentEvent) {
				ajusterGrille();
			}
		});
		frame.setMinimumSize(new Dimension(800, 600));

		ma = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object obj = e.getSource();
				switch (controleur.getState()) {
				case ACCUEIL_SANS_VOLET:
					System.out.println("bouboule");
					controleur.setState(Etat.ACCUEIL_AVEC_VOLET);
					if (obj instanceof CarteEcurie) {
						CarteEcurie ce = (CarteEcurie) obj;
						panel_side.add(new PanelEcurie(ce.getEcurie()));
						panel_side.updateUI();
					} else if (obj instanceof CarteTournois) {
						CarteTournois ct = (CarteTournois) obj;
						panel_side.add(new PanelTournois(ct.getTournoi()));
						panel_side.updateUI();
					} else if (obj instanceof CarteEquipe) {
						CarteEquipe ce = (CarteEquipe) obj;
						panel_side.add(new PanelEquipe(ce.getEquipe()));
						panel_side.updateUI();

					} else if (obj instanceof CarteJeu) {
						CarteJeu ce = (CarteJeu) obj;
						panel_side.add(new PanelJeu(ce.getJeu()));
						panel_side.updateUI();

					} else if (obj instanceof CarteRencontre) {
						System.out.println("ca");
						CarteRencontre cr = (CarteRencontre) obj;
						panel_side.add(new PanelRencontre(cr.getRencontre()));
						panel_side.updateUI();
					}
					break;
				case ACCUEIL_AVEC_VOLET:
					if (obj instanceof CarteEcurie) {
						CarteEcurie ce = (CarteEcurie) obj;
						viderSide();
						panel_side.add(new PanelEcurie(ce.getEcurie()));
						panel_side.updateUI();
					} else if (obj instanceof CarteTournois) {
						CarteTournois ct = (CarteTournois) obj;
						viderSide();
						panel_side.add(new PanelTournois(ct.getTournoi()));
						panel_side.updateUI();
					} else if (obj instanceof CarteEquipe) {
						CarteEquipe ce = (CarteEquipe) obj;
						viderSide();
						panel_side.add(new PanelEquipe(ce.getEquipe()));
						panel_side.updateUI();

					} else if (obj instanceof CarteJeu) {
						CarteJeu ce = (CarteJeu) obj;
						viderSide();
						panel_side.add(new PanelJeu(ce.getJeu()));
						panel_side.updateUI();

					} else if (obj instanceof CarteRencontre) {
						System.out.println("ca");
						CarteRencontre cr = (CarteRencontre) obj;
						viderSide();
						System.out.println("marche");
						panel_side.add(new PanelRencontre(cr.getRencontre()));
						panel_side.updateUI();
					} else if (obj instanceof JLabel) {
						JLabel jl = (JLabel) obj;
						switch (jl.getName()) {
						case "Joueur":
							System.out.println(Joueur.getJoueurFromPseudo(jl.getText()));
							break;
						case "Equipe":
							System.out.println(jl.getName()+"   "+ jl.getText() );
							System.out.println(Equipe.getEquipeFromNom(jl.getText()));
							break;
						case "Ecurie":
							System.out.println(Ecurie.getEcurieFromNom(jl.getText()));
							break;
						case "Tournoi":
							System.out.println(Tournoi.getTournoiFromNom(jl.getText()));
							break;
						case "Rencontre":
							System.out.println("lol je sais pas comment faire pour ca");
							break;
						default:
							throw new IllegalArgumentException("Unexpected value: " + jl.getName());
						}
					}
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + controleur.getState());
				}

			}
		};
	}

	/**
	 * ajuste la taille de la grille en fonction de la taille de la fenetre
	 */
	public void ajusterGrille() {
		if (frame.getWidth() < 1200) {
			panel_main.setLayout(new GridLayout((panel_main.getComponentCount() / 2) + 1, 2, 10, 10));
		} else if (frame.getWidth() >= 1200) {
			panel_main.setLayout(new GridLayout((panel_main.getComponentCount() / 3) + 1, 3, 10, 10));
			if (frame.getWidth() >= 1900) {
				panel_main.setLayout(new GridLayout((panel_main.getComponentCount() / 4) + 1, 4, 10, 10));
			}
		}

		panel_main.updateUI();
	}

	/**
	 * vide le volet
	 */
	public void viderSide() {
		panel_side.removeAll();
		panel_side.updateUI();
	}

	/**
	 * vide la gille principale
	 */
	public void viderCartes() {
		panel_main.removeAll();
		panel_main.updateUI();
	}

	/**
	 * 
	 * @param ecuries
	 */
	public void ajouterCartesEcurie(List<Ecurie> ecuries) {
		CarteEcurie ce;
		for (Ecurie ecurie : ecuries) {
			ce = new CarteEcurie(ecurie);
			ce.setName("CarteEcurie");
			ce.setBorder(new LineBorder(new Color(0, 0, 0)));
			ce.addMouseListener(ma);
			panel_main.add(ce);
		}
		ajusterGrille();
	}

	public void ajouterCartesTournois(List<Tournoi> tournois) {
		CarteTournois ct;
		for (Tournoi tournoi : tournois) {
			ct = new CarteTournois(tournoi);
			ct.setName("CarteTournois");
			ct.setBorder(new LineBorder(new Color(0, 0, 0)));
			ct.addMouseListener(ma);
			panel_main.add(ct);
		}
		ajusterGrille();
	}

	public void ajouterCartesMatch(List<Rencontre> rencontres) {
		CarteRencontre ct;
		for (Rencontre rencontre : rencontres) {
			ct = new CarteRencontre(rencontre);

			ct.setName("CarteRencontre");
			ct.setBorder(new LineBorder(new Color(0, 0, 0)));
			ct.addMouseListener(ma);
			panel_main.add(ct);
		}
		ajusterGrille();

	}

	public void ajouterCartesJeu(List<Jeu> jeux) {
		CarteJeu ct;
		for (Jeu jeu : jeux) {
			ct = new CarteJeu(jeu);
			ct.setName("CarteJeu");
			ct.setBorder(new LineBorder(new Color(0, 0, 0)));
			ct.addMouseListener(ma);
			;
			panel_main.add(ct);
		}
		ajusterGrille();

	}

	public void ajouterCartesEquipe(List<Equipe> equipes) {
		CarteEquipe ct;
		for (Equipe equipe : equipes) {
			ct = new CarteEquipe(equipe);
			ct.setName("CarteJeu");
			ct.setBorder(new LineBorder(new Color(0, 0, 0)));
			ct.addMouseListener(ma);
			panel_main.add(ct);
		}
		ajusterGrille();
	}

	public static MouseAdapter getMa() {
		return ma;
	}
	
	private Component getBtn(String string, ControleurAccueil controleur2) {

		JButton j = new JButton(string);
		j.setFont(new Font("Tahoma", Font.PLAIN, 20));
		j.addActionListener(controleur2);
		j.setName(string);
		return j;
	}

}

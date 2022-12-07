package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
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
import DBlink.Ecurie;
import DBlink.Equipe;
import DBlink.Jeu;
import DBlink.Joueur;
import DBlink.Poule;
import DBlink.Rencontre;
import DBlink.Tournoi;

public class AccueilV2 {
	private MouseAdapter ma;
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
		controleur = new ControleurAccueil(this);
		frame = new JFrame();
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();
		borderLayout.setVgap(10);
		borderLayout.setHgap(10);
		frame.setBounds(100, 100, 960, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Nom App");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel, BorderLayout.CENTER);

		JPanel panel_17 = new JPanel();
		panel.add(panel_17, BorderLayout.WEST);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(20, 10));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "tri", "tri2", "tri 3" }));
		panel_2.add(comboBox, BorderLayout.NORTH);

		JPanel panel_filtre = new JPanel();
		panel_2.add(panel_filtre, BorderLayout.CENTER);

		JPanel panel_admin = new JPanel();
		panel_2.add(panel_admin, BorderLayout.SOUTH);
		panel_admin.setLayout(new GridLayout(2, 2, 0, 0));

		JLabel lbladmin = new JLabel("administration");
		panel_admin.add(lbladmin);

		JButton btnCreeTournois = new JButton("Cr\u00E9er tournois");
		panel_admin.add(btnCreeTournois);

		JLabel lblNewLabel_2 = new JLabel("Connecte:gestionaire");
		panel_admin.add(lblNewLabel_2);

		JButton btnDeconnection = new JButton("D\u00E9connection");
		panel_admin.add(btnDeconnection);

		JPanel panel_16 = new JPanel();
		panel_3.add(panel_16, BorderLayout.NORTH);
		panel_16.setLayout(new GridLayout(0, 2, 20, 20));

		JButton btnTournois = new JButton("Tournois");
		btnTournois.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTournois.addActionListener(controleur);
		panel_16.add(btnTournois);

		JButton btnMatch = new JButton("Match");
		btnMatch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMatch.addActionListener(controleur);
		panel_16.add(btnMatch);

		JButton btnJeu = new JButton("Jeu");
		btnJeu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnJeu.addActionListener(controleur);
		panel_16.add(btnJeu);

		JButton btnEquipe = new JButton("Equipe");
		btnEquipe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEquipe.addActionListener(controleur);
		panel_16.add(btnEquipe);

		JButton btnEcurie = new JButton("Ecurie");
		btnEcurie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEcurie.addActionListener(controleur);
		panel_16.add(btnEcurie);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		panel_main = new JPanel();
		scrollPane.setViewportView(panel_main);
		panel_main.setLayout(new GridLayout(12, 3, 10, 10));

		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_main.add(panel_14);

		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_main.add(panel_13);

		CarteRencontre panel_12 = new CarteRencontre(new Rencontre(0));
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_main.add(panel_12);

		CarteRencontre panel_15 = new CarteRencontre(new Rencontre(1));
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_main.add(panel_15);

		CartePoule panel_11 = new CartePoule(new Poule(0));
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_main.add(panel_11);

		CarteJeu panel_8 = new CarteJeu("Vervatch");
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_main.add(panel_8);

		CarteEquipe panel_9 = new CarteEquipe(new Equipe(1));
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_main.add(panel_9);

		CarteJoueur panel_10 = new CarteJoueur(new Joueur(0));
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_main.add(panel_10);

		CarteTournois panel_7 = new CarteTournois(new Tournoi(1));
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_main.add(panel_7);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_main.add(panel_6);

		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_main.add(panel_6_1);

		JPanel panel_6_3 = new JPanel();
		panel_6_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_main.add(panel_6_3);

		JPanel panel_6_2 = new JPanel();
		panel_6_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_main.add(panel_6_2);

		JPanel panel_6_4 = new JPanel();
		panel_6_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_main.add(panel_6_4);

		panel_side = new JPanel();
		frame.getContentPane().add(panel_side, BorderLayout.EAST);
		/*
		
		
		
		*/
		for (Component ie : panel_main.getComponents()) {
			ie.addMouseListener(ma);
		}
		panel_7.addMouseListener(ma);
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
				if (obj instanceof CarteEcurie) {
					CarteEcurie ce = (CarteEcurie) obj;
					panel_side.add(new PanelEcurie());
					panel_side.updateUI();
					System.out.println(ce);
				}

				System.out.println(obj.getClass());

				String equipes[] = new String[16];
				for (int i = 0; i < equipes.length; i++) {
					equipes[i] = i + " aaaaaaaaaaa";
				}
				if (panel_side.getComponentCount() >= 1) {
					JPanel temp = (JPanel) panel_side.getComponent(0);
					temp = new PanelTournois("Bouboule", "dateD", "DateF", equipes);
				} else {
					panel_side.add(new PanelTournois("Bouboule", "12/12/22", "12/01/23", equipes));
					panel_side.getComponent(0).setMinimumSize(new Dimension(frame.getWidth() / 4, 0));
					panel_side.setSize(0, panel_main.getHeight());
					panel_side.updateUI();
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
			ct.addMouseListener(null);
			panel_main.add(ct);
		}
		ajusterGrille();

	}

	public void ajouterCartesJeu(List<Jeu> jeux) {
		CarteJeu ct;
		for (Jeu jeu : jeux) {
			ct = new CarteJeu(jeu.getNom());
			ct.setName("CarteJeu");
			ct.setBorder(new LineBorder(new Color(0, 0, 0)));
			ct.addMouseListener(null);
			;
			panel_main.add(ct);
		}
		ajusterGrille();

	}

	public void ajouterCartesEquipe(List<Equipe> equipes) {
		CarteEquipe ct;
		for (Equipe equipe : equipes) {
			Ecurie e = equipe.getEcurie();
			ct = new CarteEquipe(equipe);
			ct.setName("CarteJeu");
			ct.setBorder(new LineBorder(new Color(0, 0, 0)));
			ct.addMouseListener(null);
			panel_main.add(ct);
		}
		ajusterGrille();
	}
}

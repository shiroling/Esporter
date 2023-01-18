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

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controleur.ControleurAccueil;
import Controleur.ControleurAccueil.Etat;
import DBlink.BDEntity;
import DBlink.BDSelect;
import DBlink.ConnexionBase;
import DBlink.Ecurie;
import DBlink.Equipe;
import DBlink.Jeu;
import DBlink.Joueur;
import DBlink.Rencontre;
import DBlink.Tournoi;
import IHM.PanelSelection.Selection;
import base.ConnexionState;
import java.awt.FlowLayout;
import java.awt.Toolkit;

public class Accueil {
	private static MouseAdapter ma;
	private JFrame frame;
	private JPanel panelCartes;
	private static ControleurAccueil controleur;
	private JLabel lblTitreCarte;
	private JLabel lblEtatConx;
	private BtnStyleV2 btnDeconnexion;
	private BtnStyleV2 btnSeConnecter;
	private JPanel panelFiltre;
	private int tailleCarte;
	private JPanel panelLblTitreCartes;
	private JScrollPane scrollPaneMain;
	private JLabel lblCreerEquipe;
	private BtnStyleV2 btnCreerEquipe;
	private JLabel lblCreerTournoi;
	private BtnStyleV2 btnCreeTournois;
	private JLabel lblTitreFiltre;
	private JPanel panelEspace;
	private List<Tournoi> tournois;

	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil window = new Accueil();
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
	public Accueil() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		tailleCarte=0;
		ConnexionBase.getConnectionBase();
		controleur = new ControleurAccueil(this);
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Accueil.class.getResource("/icon/icon.png")));
		frame.setTitle("EMA");
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();
		borderLayout.setVgap(10);
		borderLayout.setHgap(10);
		// frame.setBounds(100, 100, 933, 592);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Pour l'app directement en full screen décommenter cette ligne
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelFonctionalites = new JPanel();
		frame.getContentPane().add(panelFonctionalites, BorderLayout.WEST);
		panelFonctionalites.setLayout(new BorderLayout(0, 0));

		JPanel panelFiltrePlusAdmin = new JPanel();
		panelFiltrePlusAdmin.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFonctionalites.add(panelFiltrePlusAdmin);
		panelFiltrePlusAdmin.setLayout(new BorderLayout(0, 15));
		
		panelFiltre = new JPanel();
		panelFiltrePlusAdmin.add(panelFiltre, BorderLayout.CENTER);
		panelFiltre.setLayout(new GridLayout(0, 1, 0, 0));
		
		controleur.setPanelFiltresTournois();

		JPanel panelAdmin = new JPanel();
		panelFiltrePlusAdmin.add(panelAdmin, BorderLayout.SOUTH);
		panelAdmin.setLayout(new GridLayout(4, 2, 0, 0));
		
		lblCreerEquipe = new JLabel("Manager :");
		lblCreerEquipe.setVisible(false);
		panelAdmin.add(lblCreerEquipe);
		
		btnCreerEquipe = new BtnStyleV2(BtnStyleV2.COLOR_BASE_BLEU, BtnStyleV2.COLOR_OVER_BLEU, BtnStyleV2.COLOR_CLIC_BLEU, 30);
		btnCreerEquipe.setVisible(false);
		btnCreerEquipe.setText("Creer Equipe");
		btnCreerEquipe.setForeground(Color.WHITE);
		btnCreerEquipe.setName("btnCreerEquipe");
		btnCreerEquipe.addActionListener(controleur);
		panelAdmin.add(btnCreerEquipe);

		lblCreerTournoi = new JLabel("Gestionaire :");
		lblCreerTournoi.setVisible(false);
		panelAdmin.add(lblCreerTournoi);

		btnCreeTournois = new BtnStyleV2(BtnStyleV2.COLOR_BASE_BLEU, BtnStyleV2.COLOR_OVER_BLEU, BtnStyleV2.COLOR_CLIC_BLEU, 30);
		btnCreeTournois.setText("Creer Tournoi");
		btnCreeTournois.setForeground(Color.WHITE);
		btnCreeTournois.setName("btnCreerTournoi");
		btnCreeTournois.addActionListener(controleur);
		btnCreeTournois.setVisible(false);
		panelAdmin.add(btnCreeTournois);

		lblEtatConx = new JLabel("Connecte:gestionaire");
		lblEtatConx.setVisible(false);
		panelAdmin.add(lblEtatConx);

		btnDeconnexion = new BtnStyleV2(BtnStyleV2.COLOR_BASE_BLEU, BtnStyleV2.COLOR_OVER_BLEU, BtnStyleV2.COLOR_CLIC_BLEU, 30);
		btnDeconnexion.addActionListener(controleur);
		btnDeconnexion.setName("btnDeconnexion");
		btnDeconnexion.setText("Se déconnecter");
		btnDeconnexion.setForeground(Color.WHITE);

		btnDeconnexion.setVisible(false);
		panelAdmin.add(btnDeconnexion);
		
		btnSeConnecter = new BtnStyleV2(BtnStyleV2.COLOR_BASE_BLEU, BtnStyleV2.COLOR_OVER_BLEU, BtnStyleV2.COLOR_CLIC_BLEU, 30);
		panelAdmin.add(btnSeConnecter);
		btnSeConnecter.setText("Se connecter");
		btnSeConnecter.setForeground(Color.WHITE);
		btnSeConnecter.addActionListener(getControleur());
		btnSeConnecter.setName("seConnecter");
		
		JPanel panelTitreFiltre = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitreFiltre.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelFiltrePlusAdmin.add(panelTitreFiltre, BorderLayout.NORTH);
		
		lblTitreFiltre = new JLabel("Filtrer les résultats");
		lblTitreFiltre.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
		panelTitreFiltre.add(lblTitreFiltre);

		JPanel panelBtnSelection = new JPanel();
		panelFonctionalites.add(panelBtnSelection, BorderLayout.NORTH);
		panelBtnSelection.setLayout(new GridLayout(0, 1, 0, 0));
		//panelBtnSelection.setLayout(new GridLayout(0, 2, 20, 20));
		
		/*JPanel panelEspaceFoctionalite = new JPanel();
		panelEspaceFoctionalite.setPreferredSize(new Dimension(0, 20));
		panelBtnSelection.add(panelEspaceFoctionalite, BorderLayout.NORTH);*/
		
		PanelSelection selectTournoi = new PanelSelection(this, Selection.TOURNOI);
		PanelSelection selectRencontre = new PanelSelection(this, Selection.RENCONTRE);
		PanelSelection selectEquipe = new PanelSelection(this, Selection.EQUIPE);
		PanelSelection selectEcurie = new PanelSelection(this, Selection.ECURIE);
		
		panelEspace = new JPanel();
		panelEspace.setLayout(null);
		panelEspace.setPreferredSize(new Dimension(0, 10));
		panelBtnSelection.add(panelEspace);
		
		
		panelBtnSelection.add(selectTournoi);
		panelBtnSelection.add(selectRencontre);
		panelBtnSelection.add(selectEquipe);
		panelBtnSelection.add(selectEcurie);
		PanelSelection selectJeu = new PanelSelection(this, Selection.JEU);
		panelBtnSelection.add(selectJeu);

		JPanel panelMain = new JPanel();
		frame.getContentPane().add(panelMain, BorderLayout.CENTER);
		panelMain.setBorder(new EmptyBorder(0,0,0,0));
		panelMain.setLayout(new BorderLayout(0, 0));

		scrollPaneMain = new JScrollPane();
		panelMain.add(scrollPaneMain);
		scrollPaneMain.setBorder(new EmptyBorder(0,0,0,0));

		panelCartes = new JPanel();
		scrollPaneMain.setViewportView(panelCartes);
		panelCartes.setLayout(new GridLayout(12, 3, 40, 10));
		
		panelLblTitreCartes = new JPanel();
		panelMain.add(panelLblTitreCartes, BorderLayout.NORTH);
		
		lblTitreCarte = new JLabel();
		lblTitreCarte.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		panelLblTitreCartes.add(lblTitreCarte);
		
		for (Component ie : panelCartes.getComponents()) {
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
					controleur.setState(Etat.ACCUEIL_AVEC_VOLET);
					if (obj instanceof CarteEcurie) {
						CarteEcurie ce = (CarteEcurie) obj;
						procedureCreePopupEcurie(ce.getEcurie());
					} else if (obj instanceof CarteTournois) {
						CarteTournois ct = (CarteTournois) obj;
						procedureCreePopupTournoi(ct.getTournoi());
					} else if (obj instanceof CarteEquipe) {
						CarteEquipe ce = (CarteEquipe) obj;
						procedureCreePopupEquipe(ce.getEquipe());
					} else if (obj instanceof CarteJeu) {
						CarteJeu ce = (CarteJeu) obj;
						procedureCreePopupJeu(ce.getJeu());
					} else if (obj instanceof CarteRencontre) {
						CarteRencontre cr = (CarteRencontre) obj;
						procedureCreePopupRencontre(cr.getRencontre());
					}
					break;
				case ACCUEIL_AVEC_VOLET:
					if (obj instanceof CarteEcurie) {
						CarteEcurie ce = (CarteEcurie) obj;
						procedureCreePopupEcurie(ce.getEcurie());
					} else if (obj instanceof CarteTournois) {
						CarteTournois ct = (CarteTournois) obj;
						procedureCreePopupTournoi(ct.getTournoi());
					} else if (obj instanceof CarteEquipe) {
						CarteEquipe ce = (CarteEquipe) obj;
						procedureCreePopupEquipe(ce.getEquipe());
					} else if (obj instanceof CarteJeu) {
						CarteJeu ce = (CarteJeu) obj;
						procedureCreePopupJeu(ce.getJeu());
					} else if (obj instanceof CarteRencontre) {
						CarteRencontre cr = (CarteRencontre) obj;
						procedureCreePopupRencontre(cr.getRencontre());
					} else if (obj instanceof JLabel) {
						JLabel jl = (JLabel) obj;
						switch (jl.getName()) {
						case "Joueur":
							procedureCreerPopup(Joueur.getJoueurFromPseudo(jl.getText()), controleur);
							break;
						case "Equipe":
							procedureCreerPopup(Equipe.getEquipeFromNom(jl.getText()), controleur);
							break;
						case "Ecurie":
							procedureCreerPopup(Ecurie.getEcurieFromNom(jl.getText()), controleur);
							break;
						case "Tournoi":
							procedureCreerPopup(Tournoi.getTournoiFromNom(jl.getText()), controleur);
							break;
						default:
							break;
						}
					}
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: ");
				}

			}
		};
		
		this.controleur.updateTournois();
		this.ajouterCartesTournois(this.getControleur().getTournois());
		this.getLblTitreCartes().setText("Tournois");
	}

	/**
	 * @author benli
	 * ajuste la taille de la grille en fonction de la taille de la fenetre
	 */
	public void ajusterGrille() {
		frame.setVisible(true);
		int temp =frame.getWidth()-panelFiltre.getWidth()-scrollPaneMain.getVerticalScrollBar().getWidth()-20-10;
		// si les cartes ont une largeure superieur a 300 pixel on reduit le nombre de colone pour ne pas avoir de scroll horizontaux  
		
		if (temp < tailleCarte*2) {
			// on set la taille de la grille pour eviter d'avoir trop de colones
			// le +1 est pour de la securité au niveau de l'interface
			panelCartes.setLayout(new GridLayout(panelCartes.getComponentCount() + 1, 1, 20, 20));
		} else if (temp >= tailleCarte*2) {
			if (temp >= tailleCarte*3) {
				panelCartes.setLayout(new GridLayout((panelCartes.getComponentCount() / 3) + 1, 3, 20, 20));
			}else {
				panelCartes.setLayout(new GridLayout((panelCartes.getComponentCount() / 2) + 1, 2, 20, 20));
			}
		}
		
		
		//corriger problemes d'actualisation 
		
		panelCartes.updateUI();
	}
	
	private void ajusterGrilleQuandAjout() {
		panelCartes.setLayout(new GridLayout((panelCartes.getComponentCount() / 4) + 1, 4, 20, 20));
		frame.setVisible(true);
		tailleCarte=panelCartes.getComponent(0).getWidth();
		scrollPaneMain.getVerticalScrollBar().setUnitIncrement(20);
		ajusterGrille();
	}


	/**
	 * vide la gille principale
	 */
	public void viderCartes() {
		tailleCarte=0;
		panelCartes.removeAll();
		panelCartes.updateUI();
	}

	public void ajouterCartes(List<BDEntity> l) {
		if (l.size() == 0) {
			ajusterGrilleQuandAjout();
			return;
		}
		if (l.get(0) instanceof Ecurie)	{
			CarteEcurie ce;
			for (BDEntity bdEntity : l) {
				ce = new CarteEcurie((Ecurie) bdEntity);
				ce.addMouseListener(ma);
				panelCartes.add(ce);
			}
		}
		if (l.get(0) instanceof Tournoi)	{
			CarteTournois ce;
			for (BDEntity bdEntity : l) {
				ce = new CarteTournois((Tournoi) bdEntity);
				ce.addMouseListener(ma);
				panelCartes.add(ce);
			}
		}
		if (l.get(0) instanceof Rencontre)	{
			CarteRencontre ct;
			for (BDEntity bdEntity : l) {
				ct = new CarteRencontre((Rencontre) bdEntity);
				ct.addMouseListener(ma);
				panelCartes.add(ct);
			}
		}
		if (l.get(0) instanceof Jeu)	{
			CarteJeu ce;
			for (BDEntity bdEntity : l) {
				ce = new CarteJeu((Jeu) bdEntity);
				ce.addMouseListener(ma);
				panelCartes.add(ce);
			}
		}
		if (l.get(0) instanceof Jeu)	{
			CarteJeu ce;
			for (BDEntity bdEntity : l) {
				ce = new CarteJeu((Jeu) bdEntity);
				ce.addMouseListener(ma);
				panelCartes.add(ce);
			}
		}
		ajusterGrilleQuandAjout();
	}

	@Deprecated
	public void ajouterCartesEcurie(List<Ecurie> ecuries) {
		CarteEcurie ce;
		for (Ecurie ecurie : ecuries) {
			ce = new CarteEcurie(ecurie);
			ce.addMouseListener(ma);
			panelCartes.add(ce);
		}
		ajusterGrilleQuandAjout();
	}

	@Deprecated
	public void ajouterCartesTournois(List<Tournoi> tournois) {
		CarteTournois ct;
		for (Tournoi tournoi : tournois) {
			ct = new CarteTournois(tournoi);
			ct.addMouseListener(ma);
			panelCartes.add(ct);
		}
		ajusterGrilleQuandAjout();
		
	}

	@Deprecated
	public void ajouterCartesMatch(List<Rencontre> rencontres) {
		CarteRencontre ct;
		for (Rencontre rencontre : rencontres) {
			ct = new CarteRencontre(rencontre);
			ct.addMouseListener(ma);
			panelCartes.add(ct);
		}
		ajusterGrilleQuandAjout();

	}

	@Deprecated
	public void ajouterCartesJeu(List<Jeu> jeux) {
		CarteJeu ct;
		for (Jeu jeu : jeux) {
			ct = new CarteJeu(jeu);
			ct.addMouseListener(ma);
			panelCartes.add(ct);
		}
		ajusterGrilleQuandAjout();

	}

	@Deprecated
	public void ajouterCartesEquipe(List<Equipe> equipes) {
		CarteEquipe ct;
		for (Equipe equipe : equipes) {
			ct = new CarteEquipe(equipe);
			ct.addMouseListener(ma);
			panelCartes.add(ct);
		}
		ajusterGrilleQuandAjout();
	}

	public static MouseAdapter getMa() {
		return ma;
	}

	public void ChangementConx(ConnexionState c) {
		switch (c) {
		case ARBITRE:
			lblEtatConx.setText("Connecté : Arbitre");
			break;
		case MANAGER:
			lblEtatConx.setText("Connecté : Manager");
			break;
		case GESTIONNAIRE:
			lblEtatConx.setText("Connecté : Gestionaire");
			break;
		case NON_CONNECTE:
			lblEtatConx.setText("");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + c);
		}
		lblEtatConx.setVisible(c != ConnexionState.NON_CONNECTE);
		btnDeconnexion.setVisible(c != ConnexionState.NON_CONNECTE);
		ajusterGrille();
	}
	
	public static void procedureCreerPopup(BDEntity e, ControleurAccueil controleurAccueil) {
		JDialog pop = null;
		if (e instanceof Ecurie)	{
			pop = new PopupEcurie((Ecurie) e);
		}
		if (e instanceof Joueur)	{
			pop = new PopupJoueur((Joueur) e);
		}
		if (e instanceof Jeu)	{
			pop = new PopupJeu((Jeu) e);
		}
		if (e instanceof Equipe)	{
			pop = new PopupEquipe((Equipe) e);
		}
		if (e instanceof Tournoi)	{
			pop = new PopupTournoi((Tournoi) e);
		}
		if (e instanceof Rencontre)	{
			pop = new PopupRencontre((Rencontre) e, controleurAccueil);
		}
		
		pop.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		pop.setVisible(true);
	}
	
	@Deprecated
	private void procedureCreePopupJoueur(Joueur j) {
		procedureCreerPopup(j, controleur);
	}
	
	@Deprecated
	public void procedureCreePopupJeu(Jeu j) {
		procedureCreerPopup(j, controleur);
	}
	
	@Deprecated
	public void procedureCreePopupEcurie(Ecurie e) {
		procedureCreerPopup(e, controleur);
	}

	@Deprecated
	public void procedureCreePopupEquipe(Equipe e) {
		procedureCreerPopup(e, controleur);
	}

	@Deprecated
	public void procedureCreePopupTournoi(Tournoi t) {
		procedureCreerPopup(t, controleur);
	}

	@Deprecated
	public void procedureCreePopupRencontre(Rencontre r) {
		procedureCreerPopup(r, controleur);
	}

	public static ControleurAccueil getControleur() {
		return controleur;
	}
	
	public JLabel getLblTitreCartes() {
		return this.lblTitreCarte;
	}
	
	public void afficherBtnSeConnecter(){
		btnSeConnecter.setVisible(true);
	}
	
	public void cacherBtnSeConnecter(){
		btnSeConnecter.setVisible(false);
	}
	
	public JPanel getPanelFiltre() {
		return this.panelFiltre;
	}
	
	public JPanel getPanelCartes() {
		return this.panelCartes;
	}

	public JLabel getLblCreerEquipe() {
		return lblCreerEquipe;
	}

	public BtnStyleV2 getBtnCreerEquipe() {
		return btnCreerEquipe;
	}

	public JLabel getLblBtnCreerTournoi() {
		return lblCreerTournoi;
	}

	public BtnStyleV2 getBtnCreeTournois() {
		return btnCreeTournois;
	}

	public JLabel getLblTitreFiltre() {
		return lblTitreFiltre;
	}

}

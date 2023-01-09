package Controleur;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DBlink.BDSelect;
import DBlink.Ecurie;
import DBlink.Equipe;
import DBlink.Jeu;
import DBlink.Tournoi;
import IHM.AccueilV2;
import IHM.ConnexionV2;
import IHM.FormCreerTournoi;
import base.ConnexionState;
import base.Portee;

public class ControleurAccueil implements ActionListener {

	private Etat state;
	private AccueilV2 vue;
	private Object obj;
	private JButton btn;
	private static ConnexionState connexionState;
	private int idLog;	//Pour Manager => id de l'ecurie
	private JComboBox comboFiltreAvencementTournoi;
	private JComboBox comboFiltreInscriptionTournoi;
	private JComboBox comboFiltreMultiTournoi;
	private JComboBox comboFiltreJeuTournoi;
	private JComboBox comboFiltrePorteeTournoi;
	private JComboBox comboFiltreAvencementRencontre;
	private JComboBox comboFiltreEquipeRencontre;
	private JComboBox comboFiltreTournoiRencontre;
	private JComboBox comboFiltreJeuRencontre;
	private JComboBox comboFiltreEcuriesEquipe;
	private JComboBox comboFiltreJeuEquipe;

	public ControleurAccueil(AccueilV2 vue) {
		this.state = Etat.ACCUEIL_SANS_VOLET;
		this.vue = vue;
		this.idLog = -1;
		connexionState = ConnexionState.NON_CONNECTE;
	}

	public enum Etat {
		ACCUEIL_SANS_VOLET, ACCUEIL_AVEC_VOLET
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		obj = e.getSource();
		if (obj instanceof JButton) {
			btn = (JButton) obj;
			switch (this.state) {
			case ACCUEIL_SANS_VOLET:
				switch (btn.getName()) {
				case "seConnecter":
					new ConnexionV2(this, ConnexionState.NON_CONNU);
					break;
				case "btnInscription":
					// procedureInscriptionTournoi(AccueilV2.getPanel_sideQuandTournoi().getTournoi());
					break;
				case "btnCreerTournoi":
					procedureCreerTournoi();
					break;
				case "btnDeconnexion":
					setConnexionState(ConnexionState.NON_CONNECTE);
					afficherBtnConnexion();
					break;
				case "Tournois":
					vue.viderCartes();
					vue.ajouterCartesTournois(BDSelect.getListeTournois());
					vue.getLblTitreCartes().setText("Tournois");
					vue.ajusterGrille();
					this.setPanelFiltresTournois();
					break;
				case "Match":
					vue.viderCartes();
					vue.getLblTitreCartes().setText("Matchs");
					vue.ajouterCartesMatch(BDSelect.getListeRencontre());
					vue.ajusterGrille();
					this.setPanelFiltresRencontres();
					break;
				case "Jeu":
					vue.viderCartes();
					vue.ajouterCartesJeu(BDSelect.getListeJeux());
					vue.getLblTitreCartes().setText("Jeux");
					vue.ajusterGrille();
					break;
				case "Equipe":
					vue.viderCartes();
					vue.ajouterCartesEquipe(BDSelect.getListeEquipes());
					vue.getLblTitreCartes().setText("Equipes");
					vue.ajusterGrille();
					this.setPanelFiltresEquipes();
					break;
				case "Ecurie":
					vue.viderCartes();
					vue.ajouterCartesEcurie(BDSelect.getListeEcurie());
					vue.getLblTitreCartes().setText("Ecuries");
					vue.ajusterGrille();
					break;
				}
				break;
			case ACCUEIL_AVEC_VOLET:

				switch (btn.getName()) {
				case "seConnecter":
					new ConnexionV2(this, ConnexionState.NON_CONNU);
					break;
				case "btnInscription":
					// procedureInscriptionTournoi(AccueilV2.getPanel_sideQuandTournoi().getTournoi());
					break;
				case "btnCreerTournoi":
					procedureCreerTournoi();
					break;
				case "Tournois":
					vue.viderCartes();
					vue.ajouterCartesTournois(BDSelect.getListeTournois());
					vue.getLblTitreCartes().setText("Tournois");
					vue.viderSide();
					vue.ajusterGrille();
					break;
				case "Match":
					vue.viderCartes();
					vue.getLblTitreCartes().setText("Matchs");
					vue.ajouterCartesMatch(BDSelect.getListeRencontre());
					vue.viderSide();
					vue.ajusterGrille();
					break;
				case "Jeu":
					vue.viderCartes();
					vue.ajouterCartesJeu(BDSelect.getListeJeux());
					vue.getLblTitreCartes().setText("Jeux");
					vue.viderSide();
					vue.ajusterGrille();
					break;
				case "Equipe":
					vue.viderCartes();
					vue.ajouterCartesEquipe(BDSelect.getListeEquipes());
					vue.getLblTitreCartes().setText("Equipes");
					vue.viderSide();
					vue.ajusterGrille();
					break;
				case "Ecurie":
					vue.viderCartes();
					vue.ajouterCartesEcurie(BDSelect.getListeEcurie());
					vue.getLblTitreCartes().setText("Ecuries");
					vue.viderSide();
					vue.ajusterGrille();
					break;
				case "btnDeconnexion":
					setConnexionState(ConnexionState.NON_CONNECTE);
					afficherBtnConnexion();
					break;
				}

				break;
			}

		}
		vue.ajusterGrille();
	}
	
	public AccueilV2 getVueAccueil() {
		return this.vue;
	}

	public void setIdLog(int id) {
		this.idLog = id;
	}

	private void procedureCreerTournoi() {
		if (connexionState != ConnexionState.GESTIONNAIRE) {
			new ConnexionV2(this, ConnexionState.GESTIONNAIRE);
		}
		if (connexionState == ConnexionState.GESTIONNAIRE) {
			FormCreerTournoi formTournoi = new FormCreerTournoi(this.idLog);
			formTournoi.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			formTournoi.setVisible(true);
		}
	}

	public void procedureInscriptionTournoi(Tournoi t) {
		if (connexionState != ConnexionState.MANAGER) {
			ConnexionV2 fenetreConnnexion = new ConnexionV2(this, ConnexionState.GESTIONNAIRE);
		}
		if (connexionState == ConnexionState.MANAGER) {
			System.out.println(t);
			//
			//
			//
			//
		}
	}

	public Etat getState() {
		return state;
	}

	public void setState(Etat state) {
		this.state = state;
	}

	public void setConnexionState(ConnexionState c) {
		vue.ChangementConx(c);
		this.connexionState = c;
	}

	public static ConnexionState getConnexionState() {
		return connexionState;
	}

	public void afficherBtnConnexion() {
		vue.afficherBtnSeConnecter();
	}

	public void cacherBtnConnexion() {
		vue.cacherBtnSeConnecter();
	}
	
	public int getIdLog() {
		return this.idLog;
	}
	
	public void setPanelFiltresTournois() {
		this.vue.getPanelFiltre().removeAll();
		this.vue.getPanelFiltre().setLayout(new GridLayout(6, 1, 0, 0));
		
		ItemListnerComboFiltre itemListner = new ItemListnerComboFiltre(this, ItemListnerComboFiltre.Etat.TOURNOI);		
		{
			JPanel panelComboAvancement = new JPanel();
			this.vue.getPanelFiltre().add(panelComboAvancement);
			panelComboAvancement.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel lblComboAvencement = new JLabel("Avancement");
			lblComboAvencement.setFont(new Font("Tahoma", Font.PLAIN, 15));
			JPanel panelComboLbl = new JPanel();
			FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
			flowLayout2.setAlignment(FlowLayout.LEFT);
			panelComboAvancement.add(panelComboLbl);
			panelComboLbl.add(lblComboAvencement);
			
			JPanel panelCombo = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelComboAvancement.add(panelCombo);
			
			comboFiltreAvencementTournoi = new JComboBox();
			comboFiltreAvencementTournoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
			comboFiltreAvencementTournoi.setPreferredSize(new Dimension(140, 30));
			comboFiltreAvencementTournoi.setModel(new DefaultComboBoxModel(new String[] { "Tous" ,"En Cours", "A Venir", "Finis" }));
			comboFiltreAvencementTournoi.addItemListener(itemListner);
			panelCombo.add(comboFiltreAvencementTournoi);
		}
		{
			JPanel panelComboInscription = new JPanel();
			this.vue.getPanelFiltre().add(panelComboInscription);
			panelComboInscription.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel lblComboInscription = new JLabel("Inscription");
			lblComboInscription.setFont(new Font("Tahoma", Font.PLAIN, 15));
			JPanel panelComboLbl = new JPanel();
			FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
			flowLayout2.setAlignment(FlowLayout.LEFT);
			panelComboInscription.add(panelComboLbl);
			panelComboLbl.add(lblComboInscription);
			
			JPanel panelCombo = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelComboInscription.add(panelCombo);
			
			comboFiltreInscriptionTournoi = new JComboBox();
			comboFiltreInscriptionTournoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
			comboFiltreInscriptionTournoi.setPreferredSize(new Dimension(140, 30));
			comboFiltreInscriptionTournoi.setModel(new DefaultComboBoxModel(new String[] { "Tous" ,"En Cours", "Finis" }));
			comboFiltreInscriptionTournoi.addItemListener(itemListner);
			panelCombo.add(comboFiltreInscriptionTournoi);
		}
		{
			JPanel panelComboMulti = new JPanel();
			this.vue.getPanelFiltre().add(panelComboMulti);
			panelComboMulti.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel lblComboMulti = new JLabel("Multigaming");
			lblComboMulti.setFont(new Font("Tahoma", Font.PLAIN, 15));
			JPanel panelComboLbl = new JPanel();
			FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
			flowLayout2.setAlignment(FlowLayout.LEFT);
			panelComboMulti.add(panelComboLbl);
			panelComboLbl.add(lblComboMulti);
			
			JPanel panelCombo = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelComboMulti.add(panelCombo);
			
			comboFiltreMultiTournoi = new JComboBox();
			comboFiltreMultiTournoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
			comboFiltreMultiTournoi.setPreferredSize(new Dimension(140, 30));
			comboFiltreMultiTournoi.setModel(new DefaultComboBoxModel(new String[] { "Tous" ,"Multigaming", "Jeu unique" }));
			comboFiltreMultiTournoi.addItemListener(itemListner);
			panelCombo.add(comboFiltreMultiTournoi);
		}
		{
			JPanel panelComboJeu = new JPanel();
			this.vue.getPanelFiltre().add(panelComboJeu);
			panelComboJeu.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel lblComboJeu = new JLabel("Jeu");
			lblComboJeu.setFont(new Font("Tahoma", Font.PLAIN, 15));
			JPanel panelComboLbl = new JPanel();
			FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
			flowLayout2.setAlignment(FlowLayout.LEFT);
			panelComboJeu.add(panelComboLbl);
			panelComboLbl.add(lblComboJeu);
			
			JPanel panelCombo = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelComboJeu.add(panelCombo);
			
			comboFiltreJeuTournoi = new JComboBox();
			comboFiltreJeuTournoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
			comboFiltreJeuTournoi.setPreferredSize(new Dimension(140, 30));
			List<Jeu> jeux = BDSelect.getListeJeux();
			String[] nomJeux = new String[jeux.size() + 1];
			nomJeux[0] = "Tous";
			for(int i = 0; i < jeux.size() ; i++) {
				nomJeux[i + 1] = jeux.get(i).getNom();
			}
			comboFiltreJeuTournoi.setModel(new DefaultComboBoxModel(nomJeux));
			comboFiltreJeuTournoi.addItemListener(itemListner);
			panelCombo.add(comboFiltreJeuTournoi);
		}
		{
			JPanel panelComboPortee = new JPanel();
			this.vue.getPanelFiltre().add(panelComboPortee);
			panelComboPortee.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel lblComboPortee = new JLabel("Portée");
			lblComboPortee.setFont(new Font("Tahoma", Font.PLAIN, 15));
			JPanel panelComboLbl = new JPanel();
			FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
			flowLayout2.setAlignment(FlowLayout.LEFT);
			panelComboPortee.add(panelComboLbl);
			panelComboLbl.add(lblComboPortee);
			
			JPanel panelCombo = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelComboPortee.add(panelCombo);
			
			comboFiltrePorteeTournoi = new JComboBox();
			comboFiltrePorteeTournoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
			comboFiltrePorteeTournoi.setPreferredSize(new Dimension(140, 30));

			String[] portees = Portee.toStrings();
			String[] porteesTous = new String[portees.length + 1];
			porteesTous[0] = "Tous";
			for(int i = 0; i < portees.length ; i++) {
				porteesTous[i + 1] = portees[i];
			}
			comboFiltrePorteeTournoi.setModel(new DefaultComboBoxModel(porteesTous));
			comboFiltrePorteeTournoi.addItemListener(itemListner);
			panelCombo.add(comboFiltrePorteeTournoi);
		}
		this.vue.getPanelFiltre().updateUI();
	}

	public JComboBox getComboFiltreAvencementTournoi() {
		return comboFiltreAvencementTournoi;
	}

	public JComboBox getComboFiltreInscriptionTournoi() {
		return comboFiltreInscriptionTournoi;
	}

	public JComboBox getComboFiltreMultiTournoi() {
		return comboFiltreMultiTournoi;
	}

	public JComboBox getComboFiltreJeuTournoi() {
		return comboFiltreJeuTournoi;
	}

	public JComboBox getComboFiltrePorteeTournoi() {
		return comboFiltrePorteeTournoi;
	}
	
	public void setPanelFiltresRencontres() {
		this.vue.getPanelFiltre().removeAll();
		this.vue.getPanelFiltre().setLayout(new GridLayout(6, 1, 0, 0));
		
		ItemListnerComboFiltre itemListner = new ItemListnerComboFiltre(this, ItemListnerComboFiltre.Etat.RENCONTRE);		
		{
			JPanel panelComboAvancement = new JPanel();
			this.vue.getPanelFiltre().add(panelComboAvancement);
			panelComboAvancement.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel lblComboAvencement = new JLabel("Avancement");
			lblComboAvencement.setFont(new Font("Tahoma", Font.PLAIN, 15));
			JPanel panelComboLbl = new JPanel();
			FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
			flowLayout2.setAlignment(FlowLayout.LEFT);
			panelComboAvancement.add(panelComboLbl);
			panelComboLbl.add(lblComboAvencement);
			
			JPanel panelCombo = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelComboAvancement.add(panelCombo);
			
			comboFiltreAvencementRencontre = new JComboBox();
			comboFiltreAvencementRencontre.setFont(new Font("Tahoma", Font.PLAIN, 15));
			comboFiltreAvencementRencontre.setPreferredSize(new Dimension(140, 30));
			comboFiltreAvencementRencontre.setModel(new DefaultComboBoxModel(new String[] { "Tous", "A Venir", "Finis" }));
			comboFiltreAvencementRencontre.addItemListener(itemListner);
			panelCombo.add(comboFiltreAvencementRencontre);
		}
		{
			JPanel panelComboJeu = new JPanel();
			this.vue.getPanelFiltre().add(panelComboJeu);
			panelComboJeu.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel lblComboJeu = new JLabel("Jeu");
			lblComboJeu.setFont(new Font("Tahoma", Font.PLAIN, 15));
			JPanel panelComboLbl = new JPanel();
			FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
			flowLayout2.setAlignment(FlowLayout.LEFT);
			panelComboJeu.add(panelComboLbl);
			panelComboLbl.add(lblComboJeu);
			
			JPanel panelCombo = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelComboJeu.add(panelCombo);
			
			comboFiltreJeuRencontre = new JComboBox();
			comboFiltreJeuRencontre.setFont(new Font("Tahoma", Font.PLAIN, 15));
			comboFiltreJeuRencontre.setPreferredSize(new Dimension(140, 30));
			List<Jeu> jeux = BDSelect.getListeJeux();
			String[] nomJeux = new String[jeux.size() + 1];
			nomJeux[0] = "Tous";
			for(int i = 0; i < jeux.size() ; i++) {
				nomJeux[i + 1] = jeux.get(i).getNom();
			}
			comboFiltreJeuRencontre.setModel(new DefaultComboBoxModel(nomJeux));
			comboFiltreJeuRencontre.addItemListener(itemListner);
			panelCombo.add(comboFiltreJeuRencontre);
		}
		{
			JPanel panelComboTournoi = new JPanel();
			this.vue.getPanelFiltre().add(panelComboTournoi);
			panelComboTournoi.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel lblComboTournoi = new JLabel("Tournoi");
			lblComboTournoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
			JPanel panelComboLbl = new JPanel();
			FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
			flowLayout2.setAlignment(FlowLayout.LEFT);
			panelComboTournoi.add(panelComboLbl);
			panelComboLbl.add(lblComboTournoi);
			
			JPanel panelCombo = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelComboTournoi.add(panelCombo);
			
			comboFiltreTournoiRencontre = new JComboBox();
			comboFiltreTournoiRencontre.setFont(new Font("Tahoma", Font.PLAIN, 15));
			comboFiltreTournoiRencontre.setPreferredSize(new Dimension(140, 30));
			List<Tournoi> tournois = BDSelect.getListeTournois();
			String[] nomTournois = new String[tournois.size() + 1];
			nomTournois[0] = "Tous";
			for(int i = 0; i < tournois.size() ; i++) {
				nomTournois[i + 1] = tournois.get(i).getNom();
			}
			comboFiltreTournoiRencontre.setModel(new DefaultComboBoxModel(nomTournois));
			comboFiltreTournoiRencontre.addItemListener(itemListner);
			panelCombo.add(comboFiltreTournoiRencontre);
		}
		{
			JPanel panelComboEquipe = new JPanel();
			this.vue.getPanelFiltre().add(panelComboEquipe);
			panelComboEquipe.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel lblComboEquipe = new JLabel("Equipe");
			lblComboEquipe.setFont(new Font("Tahoma", Font.PLAIN, 15));
			JPanel panelComboLbl = new JPanel();
			FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
			flowLayout2.setAlignment(FlowLayout.LEFT);
			panelComboEquipe.add(panelComboLbl);
			panelComboLbl.add(lblComboEquipe);
			
			JPanel panelCombo = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelComboEquipe.add(panelCombo);
			
			comboFiltreEquipeRencontre = new JComboBox();
			comboFiltreEquipeRencontre.setFont(new Font("Tahoma", Font.PLAIN, 15));
			comboFiltreEquipeRencontre.setPreferredSize(new Dimension(140, 30));
			List<Equipe> equipes = BDSelect.getListeEquipes();
			String[] nomEquipes = new String[equipes.size() + 1];
			nomEquipes[0] = "Tous";
			for(int i = 0; i < equipes.size() ; i++) {
				nomEquipes[i + 1] = equipes.get(i).getNom();
			}
			comboFiltreEquipeRencontre.setModel(new DefaultComboBoxModel(nomEquipes));
			comboFiltreEquipeRencontre.addItemListener(itemListner);
			panelCombo.add(comboFiltreEquipeRencontre);
		}
		this.vue.getPanelFiltre().updateUI();
	}

	public JComboBox getComboFiltreAvencementRencontre() {
		return comboFiltreAvencementRencontre;
	}

	public JComboBox getComboFiltreEquipeRencontre() {
		return comboFiltreEquipeRencontre;
	}

	public JComboBox getComboFiltreTournoiRencontre() {
		return comboFiltreTournoiRencontre;
	}

	public JComboBox getComboFiltreJeuRencontre() {
		return comboFiltreJeuRencontre;
	}
	
	
	public void setPanelFiltresEquipes() {
		this.vue.getPanelFiltre().removeAll();
		this.vue.getPanelFiltre().setLayout(new GridLayout(6, 1, 0, 0));
		
		ItemListnerComboFiltre itemListner = new ItemListnerComboFiltre(this, ItemListnerComboFiltre.Etat.EQUIPE);		
		{
			JPanel panelComboEcuries = new JPanel();
			this.vue.getPanelFiltre().add(panelComboEcuries);
			panelComboEcuries.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel lblComboEcuries = new JLabel("Ecuries");
			lblComboEcuries.setFont(new Font("Tahoma", Font.PLAIN, 15));
			JPanel panelComboLbl = new JPanel();
			FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
			flowLayout2.setAlignment(FlowLayout.LEFT);
			panelComboEcuries.add(panelComboLbl);
			panelComboLbl.add(lblComboEcuries);
			
			JPanel panelCombo = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelComboEcuries.add(panelCombo);
			
			comboFiltreEcuriesEquipe = new JComboBox();
			comboFiltreEcuriesEquipe.setFont(new Font("Tahoma", Font.PLAIN, 15));
			comboFiltreEcuriesEquipe.setPreferredSize(new Dimension(140, 30));
			List<Ecurie> ecuries = BDSelect.getListeEcurie();
			String[] nomEcuries = new String[ecuries.size() + 1];
			nomEcuries[0] = "Tous";
			for(int i = 0; i < ecuries.size() ; i++) {
				nomEcuries[i + 1] = ecuries.get(i).getNom();
			}
			comboFiltreEcuriesEquipe.setModel(new DefaultComboBoxModel(nomEcuries));
			comboFiltreEcuriesEquipe.addItemListener(itemListner);
			panelCombo.add(comboFiltreEcuriesEquipe);
		}
		{
			JPanel panelComboJeu = new JPanel();
			this.vue.getPanelFiltre().add(panelComboJeu);
			panelComboJeu.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel lblComboJeu = new JLabel("Jeu");
			lblComboJeu.setFont(new Font("Tahoma", Font.PLAIN, 15));
			JPanel panelComboLbl = new JPanel();
			FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
			flowLayout2.setAlignment(FlowLayout.LEFT);
			panelComboJeu.add(panelComboLbl);
			panelComboLbl.add(lblComboJeu);
			
			JPanel panelCombo = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelComboJeu.add(panelCombo);
			
			comboFiltreJeuEquipe = new JComboBox();
			comboFiltreJeuEquipe.setFont(new Font("Tahoma", Font.PLAIN, 15));
			comboFiltreJeuEquipe.setPreferredSize(new Dimension(140, 30));
			List<Jeu> jeux = BDSelect.getListeJeux();
			String[] nomJeux = new String[jeux.size() + 1];
			nomJeux[0] = "Tous";
			for(int i = 0; i < jeux.size() ; i++) {
				nomJeux[i + 1] = jeux.get(i).getNom();
			}
			comboFiltreJeuEquipe.setModel(new DefaultComboBoxModel(nomJeux));
			comboFiltreJeuEquipe.addItemListener(itemListner);
			panelCombo.add(comboFiltreJeuEquipe);
		}
	}

	public JComboBox getComboFiltreEcuriesEquipe() {
		return comboFiltreEcuriesEquipe;
	}

	public JComboBox getComboFiltreJeuEquipe() {
		return comboFiltreJeuEquipe;
	}
	
}

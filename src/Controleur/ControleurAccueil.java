package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import DBlink.BDSelect;
import DBlink.Joueur;
import IHM.AccueilV2;
import IHM.Connexion;
import IHM.FormCreerTournoi;
import IHM.PopupJoueur;
import base.ConnexionState;

public class ControleurAccueil implements ActionListener  {

	private Etat state;
	private AccueilV2 vue;
	private Object obj;
	private JButton btn;
	private ConnexionState connexionState;
	private int idLog;

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
		obj =  e.getSource();
		if (obj instanceof JButton) {
			btn = (JButton) obj;
			switch (this.state) {
			case ACCUEIL_SANS_VOLET:
				switch (btn.getName()) {
				case "btnCreerTournoi":
					procedureCreerTournoi();
					break;
				case "btnDeconnexion":
					setConnexionState(connexionState.NON_CONNECTE);
					break;
				case "Tournois":
					vue.viderCartes();
					vue.ajouterCartesTournois(BDSelect.getListeTournois());
					break;
				case "Match":
					vue.viderCartes();
					vue.ajouterCartesMatch(BDSelect.getListeRencontre());
					break;
				case "Jeu":
					vue.viderCartes();
					vue.ajouterCartesJeu(BDSelect.getListeJeux());
					break;
				case"Equipe":
					vue.viderCartes();
					vue.ajouterCartesEquipe(BDSelect.getListeEquipes());
					break;
				case"Ecurie":
					vue.viderCartes();
					vue.ajouterCartesEcurie(BDSelect.getListeEcurie());
					break;
				}
				break;
			case ACCUEIL_AVEC_VOLET:
				
				switch (btn.getName()) {
				case "btnCreerTournoi":
					System.out.println("coucou2");
					procedureCreerTournoi();
					break;
				case "Tournois":
					vue.viderCartes();
					vue.ajouterCartesTournois(BDSelect.getListeTournois());
					break;
				case "Match":
					vue.viderCartes();
					vue.ajouterCartesMatch(BDSelect.getListeRencontre());
					break;
				case "Jeu":
					vue.viderCartes();
					vue.ajouterCartesJeu(BDSelect.getListeJeux());
					break;
				case"Equipe":
					vue.viderCartes();
					vue.ajouterCartesEquipe(BDSelect.getListeEquipes());
					break;
				case"Ecurie":
					vue.viderCartes();
					vue.ajouterCartesEcurie(BDSelect.getListeEcurie());
					break;
				}
				vue.viderSide();
				break;
			}

		}
		
	}

	
	public void setIdLog(int id) {
		this.idLog = id;
	}

	private void procedureCreerTournoi() {
		if (connexionState != ConnexionState.GESTIONNAIRE) {
			Connexion fenetreConnnexion = new Connexion(this, ConnexionState.GESTIONNAIRE);
		}
		if (connexionState == ConnexionState.GESTIONNAIRE) {
			FormCreerTournoi formTournoi = new FormCreerTournoi(this.idLog);
			formTournoi.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			formTournoi.setVisible(true);
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
	public ConnexionState getConnexionState() {
		return this.connexionState;
	}

	

}

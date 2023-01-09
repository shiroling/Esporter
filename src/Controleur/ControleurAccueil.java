package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import DBlink.BDSelect;
import DBlink.Tournoi;
import IHM.AccueilV2;
import IHM.ConnexionV2;
import IHM.FormCreerTournoi;
import base.ConnexionState;

public class ControleurAccueil implements ActionListener {

	private Etat state;
	private AccueilV2 vue;
	private Object obj;
	private JButton btn;
	private static ConnexionState connexionState;
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
					break;
				case "Match":
					vue.viderCartes();
					vue.getLblTitreCartes().setText("Matchs");
					vue.ajouterCartesMatch(BDSelect.getListeRencontre());
					vue.ajusterGrille();
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

}

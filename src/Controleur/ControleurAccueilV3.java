package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import DBlink.BDSelect;
import DBlink.Tournoi;
import IHM.AccueilV2;
import IHM.AccueilV3;
import IHM.Connexion;
import IHM.ConnexionV2;
import IHM.FormCreerTournoi;
import base.ConnexionState;

public class ControleurAccueilV3 implements ActionListener  {

	private Etat state;
	private AccueilV3 vue;
	private Object obj;
	private JButton btn;
	private static ConnexionState connexionState;
	private int idLog;

	public ControleurAccueilV3(AccueilV3 vue) {
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
				case "btnInscription":
					//procedureInscriptionTournoi(AccueilV2.getPanel_sideQuandTournoi().getTournoi());
					break;
				case "btnCreerTournoi":
					procedureCreerTournoi();
					break;
				case "btnDeconnexion":
					setConnexionState(ConnexionState.NON_CONNECTE);
					break;
				case "Tournois":
					vue.viderCartes();
					vue.ajouterCartesTournois(BDSelect.getListeTournois());
					vue.getLblTitreCartes().setText("Tournois");
					break;
				case "Match":
					vue.viderCartes();
					vue.getLblTitreCartes().setText("Matchs");
					vue.ajouterCartesMatch(BDSelect.getListeRencontre());
					break;
				case "Jeu":
					vue.viderCartes();
					vue.ajouterCartesJeu(BDSelect.getListeJeux());
					vue.getLblTitreCartes().setText("Jeux");
					break;
				case"Equipe":
					vue.viderCartes();
					vue.ajouterCartesEquipe(BDSelect.getListeEquipes());
					vue.getLblTitreCartes().setText("Equipes");
					break;
				case"Ecurie":
					vue.viderCartes();
					vue.ajouterCartesEcurie(BDSelect.getListeEcurie());
					vue.getLblTitreCartes().setText("Ecuries");
					break;
				}
				break;
			case ACCUEIL_AVEC_VOLET:
				
				switch (btn.getName()) {
				case "btnInscription":
					//procedureInscriptionTournoi(AccueilV2.getPanel_sideQuandTournoi().getTournoi());
					break;
				case "btnCreerTournoi":
					System.out.println("coucou2");
					procedureCreerTournoi();
					break;
				case "Tournois":
					vue.viderCartes();
					vue.ajouterCartesTournois(BDSelect.getListeTournois());
					vue.getLblTitreCartes().setText("Tournois");
					vue.viderSide();
					break;
				case "Match":
					vue.viderCartes();
					vue.getLblTitreCartes().setText("Matchs");
					vue.ajouterCartesMatch(BDSelect.getListeRencontre());
					vue.viderSide();
					break;
				case "Jeu":
					vue.viderCartes();
					vue.ajouterCartesJeu(BDSelect.getListeJeux());
					vue.getLblTitreCartes().setText("Jeux");
					vue.viderSide();
					break;
				case"Equipe":
					vue.viderCartes();
					vue.ajouterCartesEquipe(BDSelect.getListeEquipes());
					vue.getLblTitreCartes().setText("Equipes");
					vue.viderSide();
					break;
				case"Ecurie":
					vue.viderCartes();
					vue.ajouterCartesEcurie(BDSelect.getListeEcurie());
					vue.getLblTitreCartes().setText("Ecuries");
					vue.viderSide();
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
			//new ConnexionV2(this, ConnexionState.GESTIONNAIRE);
		}
		if (connexionState == ConnexionState.GESTIONNAIRE) {
			FormCreerTournoi formTournoi = new FormCreerTournoi(this.idLog);
			formTournoi.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			formTournoi.setVisible(true);
		}
	}
	
	public void procedureInscriptionTournoi(Tournoi t) {
		if (connexionState != ConnexionState.MANAGER) {
		//	Connexion fenetreConnnexion = new Connexion(this, ConnexionState.GESTIONNAIRE);
		}
		if (connexionState == ConnexionState.MANAGER) {
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
	public ConnexionState getConnexionState() {
		return this.connexionState;
	}

	
	

}

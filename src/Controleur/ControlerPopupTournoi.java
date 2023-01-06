package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import IHM.Connexion;
import IHM.PopupTournoi;
import base.ConnexionState;

public class ControlerPopupTournoi implements ActionListener {
	
	private PopupTournoi vue;
	private ControleurAccueil controleurAccueil;
	
	public ControlerPopupTournoi(PopupTournoi vue, ControleurAccueil controleurAccueil) {
		super();
		this.vue = vue;
		this.controleurAccueil = controleurAccueil;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		
		switch (btn.getName()) {
		case "inscription":
			if (controleurAccueil.getConnexionState() != ConnexionState.MANAGER) {
				Connexion fenetreConnnexion = new Connexion(controleurAccueil, ConnexionState.MANAGER);
			}
			if (controleurAccueil.getConnexionState() == ConnexionState.MANAGER) {
				System.out.println("yeeeeeee");
				//Popup liste des équipe de l'equrie
				//Inscrire l'équipe sélctionner
			}
			break;
		case "voirRencontres" :
			
			break;
		}
	}

}

package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import DBlink.Rencontre;
import IHM.Accueil;
import IHM.ConnexionV2;
import IHM.FormCreerTournoi;
import IHM.PopupIndiquerVainqueur;
import IHM.PopupRencontre;
import base.ConnexionState;

public class ControleurPopupRencontre implements ActionListener{
	
	private ControleurAccueil controleurAccueil;
	private PopupRencontre vue;

	public ControleurPopupRencontre(PopupRencontre vue, ControleurAccueil controleurAccueil) {
		super();
		this.vue = vue;
		this.controleurAccueil = controleurAccueil;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		
		switch(btn.getName()) {
		case "btnRenseignerVainqueur":
			if (controleurAccueil.getConnexionState() != ConnexionState.ARBITRE) {
				new ConnexionV2(controleurAccueil, ConnexionState.ARBITRE);
			}
			if (controleurAccueil.getConnexionState() == ConnexionState.ARBITRE && this.vue.getRencontre().isArbitre(controleurAccueil.getIdLog())) {
				new PopupIndiquerVainqueur(this.vue.getRencontre());
			} else if(controleurAccueil.getConnexionState() == ConnexionState.ARBITRE) {
				//Ouvre une fenetre "Vous n'etes pas l'arbitre du match"
			} else {
				//Vous n'etes pas arbitre
			}
			break;
		}
				
	}
	
}

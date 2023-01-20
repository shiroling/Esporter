package controleur_ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import commun.ConnexionState;
import interfaces.ConnexionV2;
import interfaces.FenMessage;
import interfaces.PopupIndiquerVainqueur;
import interfaces.PopupRencontre;

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
				//dk,dkd,
			} else {
				//Vous n'etes pas arbitre
			}
			break;
		}
				
	}
	
}

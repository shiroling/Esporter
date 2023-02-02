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
				PopupIndiquerVainqueur indiquerVainqueur = new PopupIndiquerVainqueur(this.vue.getRencontre());
				indiquerVainqueur.setVisible(true);
			} else if(controleurAccueil.getConnexionState() == ConnexionState.ARBITRE) {
				FenMessage dialog = new FenMessage("Vous n'êtes pas arbitre de ce match");
				dialog.setVisible(true);
			} else {
				FenMessage dialog = new FenMessage("Vous n'êtes pas arbitre");
				dialog.setVisible(true);
			}
			break;
		}
				
	}
	
}

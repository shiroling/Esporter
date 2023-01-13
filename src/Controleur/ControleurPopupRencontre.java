package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import IHM.AccueilV2;
import IHM.ConnexionV2;
import IHM.FormCreerTournoi;
import IHM.PopupRencontre;
import base.ConnexionState;

public class ControleurPopupRencontre implements ActionListener{
	
	private AccueilV2 vueAccueil;
	private PopupRencontre vue;

	public ControleurPopupRencontre(PopupRencontre vue, AccueilV2 vueAccueil) {
		super();
		this.vue = vue;
		this.vueAccueil = vueAccueil;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		
		switch(btn.getName()) {
		case "btnRenseignerVainqueur":
			if (vueAccueil.getControleur().getConnexionState() != ConnexionState.ARBITRE) {
				new ConnexionV2(vueAccueil.getControleur(), ConnexionState.ARBITRE);
			}
			if (vueAccueil.getControleur().getConnexionState() == ConnexionState.ARBITRE) {
				
			}
			break;
		}
				
	}
	
}

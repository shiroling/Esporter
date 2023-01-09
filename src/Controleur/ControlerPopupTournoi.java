package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import IHM.AccueilV2;
import IHM.Connexion;
import IHM.ConnexionV2;
import IHM.PopupTournoi;
import base.ConnexionState;

public class ControlerPopupTournoi implements ActionListener {
	
	private PopupTournoi vue;
	private ControleurAccueil controleurAccueil;
	
	public ControlerPopupTournoi(PopupTournoi vue) {
		super();
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		
		switch (btn.getName()) {
		case "inscription":
			if (ControleurAccueil.getConnexionState() != ConnexionState.MANAGER) {
				ConnexionV2 fenetreConnnexion = new ConnexionV2(AccueilV2.getControleur(), ConnexionState.MANAGER);
			}
			if (ControleurAccueil.getConnexionState() == ConnexionState.MANAGER) {
				System.out.println("BANGERANG");
				//Popup liste des équipe de l'equrie
				//Inscrire l'équipe sélctionner
			}
			break;
		case "voirRencontres" :
			
			break;
		}
	}

}

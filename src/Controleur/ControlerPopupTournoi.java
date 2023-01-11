package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import DBlink.Ecurie;
import IHM.AccueilV2;
import IHM.ConnexionV2;
import IHM.PopupSelectionEquipePourInscription;
import IHM.PopupTournoi;
import base.ConnexionState;

public class ControlerPopupTournoi implements ActionListener {
	
	private PopupTournoi vue;
	private ControleurAccueil controleurAccueil;
	
	public ControlerPopupTournoi(PopupTournoi vue) {
		super();
		this.vue = vue;
		this.controleurAccueil = AccueilV2.getControleur();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		
		switch (btn.getName()) {
		case "inscription":
			if (controleurAccueil.getConnexionState() != ConnexionState.MANAGER) {
				ConnexionV2 fenetreConnnexion = new ConnexionV2(AccueilV2.getControleur(), ConnexionState.MANAGER);
			}
			if (controleurAccueil.getConnexionState() == ConnexionState.MANAGER) {
				PopupSelectionEquipePourInscription dialog = new PopupSelectionEquipePourInscription(new Ecurie(this.controleurAccueil.getIdLog()), this.vue.getTournoi());
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
			break;
		case "voirRencontres" :
			
			break;
		}
	}

}

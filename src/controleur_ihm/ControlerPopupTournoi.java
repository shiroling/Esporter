package controleur_ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import commun.ConnexionState;
import contoleur_bd.Ecurie;
import interfaces.Accueil;
import interfaces.ConnexionV2;
import interfaces.PopupSelectionEquipePourInscription;
import interfaces.PopupTournoi;

public class ControlerPopupTournoi implements ActionListener {
	
	private PopupTournoi vue;
	private ControleurAccueil controleurAccueil;
	
	public ControlerPopupTournoi(PopupTournoi vue) {
		super();
		this.vue = vue;
		this.controleurAccueil = Accueil.getControleur();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		
		switch (btn.getName()) {
		case "inscription":
			if (controleurAccueil.getConnexionState() != ConnexionState.MANAGER) {
				ConnexionV2 fenetreConnnexion = new ConnexionV2(Accueil.getControleur(), ConnexionState.MANAGER);
			}
			if (controleurAccueil.getConnexionState() == ConnexionState.MANAGER) {
				PopupSelectionEquipePourInscription dialog = new PopupSelectionEquipePourInscription(new Ecurie(this.controleurAccueil.getIdLog()), this.vue);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
			break;
		case "voirRencontres" :
			
			break;
		}
	}

}

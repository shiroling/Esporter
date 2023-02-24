package controleur_ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;

import commun.ConnexionState;
import contoleur_bd.BDPredicats;
import contoleur_bd.BDSelect;
import interfaces.ConnexionV2;

public class ControleurConnexion implements ActionListener{
	
	private ConnexionState connexionVisee;
	private ConnexionV2 connexionVue;
	private ControleurAccueil controleurAccueil;
	
	public ControleurConnexion(ConnexionState connexionVisee, ConnexionV2 connexionVue, ControleurAccueil controleurAccueil) {
		super();
		this.connexionVisee = connexionVisee;
		this.connexionVue = connexionVue;
		this.controleurAccueil = controleurAccueil;
	}
	
	protected void procedureConnexionEchouee() {
		LineBorder border = new LineBorder(Color.RED);
		this.connexionVue.getTextFieldUsername().setBorder(border);
		this.connexionVue.getTextFieldPassword().setBorder(border);
		controleurAccueil.setConnexionState(ConnexionState.NON_CONNECTE);
		controleurAccueil.afficherBtnConnexion();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		switch (connexionVisee) {
		case ARBITRE:
			System.out.println("arbitre");
			if (BDPredicats.isArbitre(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword()))) {
				controleurAccueil.setConnexionState(ConnexionState.ARBITRE);
				controleurAccueil.cacherBtnConnexion();
				controleurAccueil.setIdLog(BDSelect.getIdArbitreFromLogs(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword())));
				this.connexionVue.dispose();
			} else {
				procedureConnexionEchouee();
			}
			break;
		case GESTIONNAIRE:
			if (BDPredicats.isGestionnaire(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword()))) {
				controleurAccueil.setConnexionState(ConnexionState.GESTIONNAIRE);
				controleurAccueil.cacherBtnConnexion();
				controleurAccueil.setIdLog(BDSelect.getIdGerantFromLogs(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword())));
				this.connexionVue.dispose();
			} else {
				procedureConnexionEchouee();
			}
			break;
		case MANAGER:
			if (BDPredicats.isManager(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword()))) {
				controleurAccueil.setConnexionState(ConnexionState.MANAGER);
				controleurAccueil.cacherBtnConnexion();
				controleurAccueil.setIdLog(BDSelect.getIdManagerFromLogs(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword())));
				this.connexionVue.dispose();
			} else {
				procedureConnexionEchouee();
			}
			break;
		case NON_CONNU:
			if (BDPredicats.isManager(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword()))) {
				controleurAccueil.setConnexionState(ConnexionState.MANAGER);
				controleurAccueil.cacherBtnConnexion();
				controleurAccueil.setIdLog(BDSelect.getIdManagerFromLogs(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword())));
				this.connexionVue.dispose();
			}
			else if ((BDPredicats.isGestionnaire(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword()))) ) {
				controleurAccueil.setConnexionState(ConnexionState.GESTIONNAIRE);
				controleurAccueil.cacherBtnConnexion();
				controleurAccueil.setIdLog(BDSelect.getIdGerantFromLogs(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword())));
				this.connexionVue.dispose();
			}
			else if ((BDPredicats.isArbitre(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword()))) ) {
				controleurAccueil.setConnexionState(ConnexionState.ARBITRE);
				controleurAccueil.cacherBtnConnexion();
				controleurAccueil.setIdLog(BDSelect.getIdArbitreFromLogs(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword())));
				this.connexionVue.dispose();
			}
			else {
				procedureConnexionEchouee();
			}
			break;
		default:
			controleurAccueil.setConnexionState(ConnexionState.NON_CONNECTE);
			controleurAccueil.afficherBtnConnexion();
		}
	}
}

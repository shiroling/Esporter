package Controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;

import DBlink.BDPredicats;
import DBlink.BDSelect;
import IHM.Connexion;
import IHM.ConnexionV2;
import base.ConnexionState;

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



	@Override
	public void actionPerformed(ActionEvent e) {
		switch (connexionVisee) {
		case ARBITRE:
			break;
		case GESTIONNAIRE:
			if (BDPredicats.isGestionnaire(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword()))) {
				controleurAccueil.setConnexionState(ConnexionState.GESTIONNAIRE);
				controleurAccueil.setIdLog(BDSelect.getIdGerantFromLogs(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword())));
				this.connexionVue.dispose();

			} else {
				LineBorder border = new LineBorder(Color.RED);
				this.connexionVue.getTextFieldUsername().setBorder(border);
				this.connexionVue.getTextFieldPassword().setBorder(border);
				controleurAccueil.setConnexionState(ConnexionState.NON_CONNECTE);
			}
			break;
		case MANAGER:
			if (BDPredicats.isManager(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword()))) {
				controleurAccueil.setConnexionState(ConnexionState.MANAGER);
				controleurAccueil.setIdLog(BDSelect.getIdGerantFromLogs(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword())));
				this.connexionVue.dispose();
			} else {
				LineBorder border = new LineBorder(Color.RED);
				this.connexionVue.getTextFieldUsername().setBorder(border);
				this.connexionVue.getTextFieldPassword().setBorder(border);
				controleurAccueil.setConnexionState(ConnexionState.NON_CONNECTE);
			}
			break;
		default:
			controleurAccueil.setConnexionState(ConnexionState.NON_CONNECTE);
		}
	}
}

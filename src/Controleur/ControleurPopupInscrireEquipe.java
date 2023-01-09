package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import IHM.PopupSelectionEquipePourInscription;

public class ControleurPopupInscrireEquipe implements ActionListener{

	private PopupSelectionEquipePourInscription vue;
	
	public ControleurPopupInscrireEquipe(PopupSelectionEquipePourInscription vue) {
		super();
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		
		switch (btn.getName()) {
		case "Inscrire":
			
			break;
		case "Annuler" :
			this.vue.dispose();
			break;
		}
	}
	

}

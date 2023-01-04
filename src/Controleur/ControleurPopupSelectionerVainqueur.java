package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DBlink.Tournoi;
import IHM.BtnStyleV2;
import IHM.PopupIndiquerVainqueur;

public class ControleurPopupSelectionerVainqueur implements ActionListener {
	
	private PopupIndiquerVainqueur vue;
	
	public ControleurPopupSelectionerVainqueur(PopupIndiquerVainqueur vue) {
		super();
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BtnStyleV2 btn = (BtnStyleV2) e.getSource();
		
		switch (btn.getName())	{
		case "btnConfirmer" :
			Tournoi.setFinalist(this.vue.getVainqueur().getId(), this.vue.getRencontre().getId());
			this.vue.dispose();
			break;
		case "btnAnnuler" :
			this.vue.dispose();
			break;
		}
	}

}

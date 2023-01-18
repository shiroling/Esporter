package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			try {
				this.vue.getRencontre().designerVainceur(this.vue.getVainqueur().getId());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.vue.dispose();
			break;
		case "btnAnnuler" :
			this.vue.dispose();
			break;
		}
	}

}

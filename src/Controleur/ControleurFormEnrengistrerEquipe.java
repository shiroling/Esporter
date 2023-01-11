package Controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import IHM.FormEnregistrerEquipe;

public class ControleurFormEnrengistrerEquipe implements ActionListener{
	
	private FormEnregistrerEquipe vue;

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		
		switch(btn.getName()) {
		case "CreerEquipe":
			String nomEquipe = this.vue.getTextFieldNomEquipe().getText();
			if(nomEquipe.equals("")) {
				this.vue.getLblnomEquipe().setText("Nom (vide)");
				this.vue.getLblnomEquipe().setForeground(Color.RED);
			}
			break;
		case "Annuler":
			this.vue.dispose();
			break;
		}
	}

}

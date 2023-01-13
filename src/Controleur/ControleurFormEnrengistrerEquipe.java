package Controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import DBlink.BDSelect;
import DBlink.Equipe;
import DBlink.Jeu;
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
			} else if(BDSelect.equipeDejaPresente(nomEquipe)){
				this.vue.getLblnomEquipe().setText("Nom (déjà pris)");
				this.vue.getLblnomEquipe().setForeground(Color.RED);
			} else {
				//Equipe.inserer(nomEquipe, Jeu.getJeuFromName(this.vue.getComboJeux().getSelectedItem().toString()).getId(), this.vue.getEcurie().getId());
			}
			this.vue.dispose();
			break;
		case "Annuler":
			this.vue.dispose();
			break;
		}
	}

}

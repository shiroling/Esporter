package Controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import DBlink.BDSelect;
import DBlink.Equipe;
import DBlink.Jeu;
import DBlink.PreJoueur;
import IHM.FormEnregistrerEquipe;

public class ControleurFormEnrengistrerEquipe implements ActionListener{
	
	private FormEnregistrerEquipe vue;
	private List<PreJoueur> preJoueurs;

	public ControleurFormEnrengistrerEquipe(FormEnregistrerEquipe vue) {
		super();
		this.vue = vue;
		this.preJoueurs = new ArrayList<>();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		
		switch(btn.getName()) {
		case "CreerEquipe":
			String nomEquipe = this.vue.getTextFieldNomEquipe().getText();
			if(nomEquipe.equals("")) {
				this.vue.getLblnomEquipe().setText("Nom (vide)");
				this.vue.getLblnomEquipe().setForeground(Color.RED);
				this.vue.getLblnomEquipe().updateUI();
			} else if(BDSelect.equipeDejaPresente(nomEquipe)){
				this.vue.getLblnomEquipe().setText("Nom (déjà pris)");
				this.vue.getLblnomEquipe().setForeground(Color.RED);
			} else {
				//Appeller 4 fois form creer Joueur
				Equipe.inserer(nomEquipe, Jeu.getJeuFromName(this.vue.getComboJeux().getSelectedItem().toString()).getId(), this.vue.getEcurie().getId());
				this.vue.dispose();
			}
			break;
		case "AjouterJoueurs":
			break;
		case "Annuler":
			this.vue.dispose();
			break;
		}
	}

}

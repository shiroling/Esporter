package Controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import IHM.FormEnregistrerJoueur;
import base.Mois;
import base.PreDate;

public class ControleurFormEnrengistrerJoueur implements ActionListener {
	
	private FormEnregistrerJoueur vue;
	private ControleurFormEnrengistrerEquipe controleurForEquipe;

	public ControleurFormEnrengistrerJoueur(FormEnregistrerJoueur vue, ControleurFormEnrengistrerEquipe controleurForEquipe) {
		super();
		this.vue = vue;
		this.controleurForEquipe = controleurForEquipe;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		
		switch(btn.getName()) {
		case "Creer":
			String nomJoueur = this.vue.getTextFieldNomJoueur().getText();
			String prenomJoueur = this.vue.getTextFieldPrenomJoueur().getText();
			String pseudoJoueur = this.vue.getTextFieldPseudo().getText();
			
			if(nomJoueur.equals((""))) {
				this.vue.getLblNomJoueur().setForeground(Color.RED);
			} else {
				this.vue.getLblNomJoueur().setForeground(Color.BLACK);
			}
				
			if(prenomJoueur.equals((""))) {
				this.vue.getLblPrenomJoueur().setForeground(Color.RED);
			} else {
				this.vue.getLblPrenomJoueur().setForeground(Color.BLACK);
			}
			
			if(pseudoJoueur.equals((""))) {
				this.vue.getLblPseudoJoueur().setForeground(Color.RED);
			} else {
				this.vue.getLblPseudoJoueur().setForeground(Color.BLACK);
			}
			
			
			PreDate dateNaissance = new PreDate(Integer.parseInt(this.vue.getComboAnneeNaissance().getSelectedItem().toString()), Mois.stringToMois(this.vue.getComboMoiNaissance().getSelectedItem().toString()).getMoisChiffre(), Integer.parseInt(this.vue.getComboJourNaissance().getSelectedItem().toString()));
			
			if(!(dateNaissance.estDateValide())) {
				this.vue.getLblDateNaissance().setForeground(Color.RED);
			} else {
				this.vue.getLblDateNaissance().setForeground(Color.BLACK);
			}
			
			if(this.estFormulaireValide()) {
				this.controleurForEquipe.addPreJoueur(nomJoueur, prenomJoueur, dateNaissance.toDate(), pseudoJoueur);
				this.vue.dispose();
			}
			
			break;
		case "Annuler":
			this.vue.dispose();
			break;
		}
	}
	
	private boolean estFormulaireValide() {
		return (this.vue.getLblNomJoueur().getForeground().equals(Color.BLACK) 
				&& this.vue.getLblPrenomJoueur().getForeground().equals(Color.BLACK) 
				&& this.vue.getLblPseudoJoueur().getForeground().equals(Color.BLACK)
				&& this.vue.getLblDateNaissance().getForeground().equals(Color.BLACK));
	}

}

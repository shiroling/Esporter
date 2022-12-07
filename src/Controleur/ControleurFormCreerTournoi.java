package Controleur;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import DBlink.Jeu;
import DBlink.Tournoi;
import IHM.CreerTournoi;
import IHM.FormCreerTournoi;
import base.Mois;
import base.Portee;
import base.PreDate;

public class ControleurFormCreerTournoi implements ActionListener {

	private FormCreerTournoi vue;
	private JButton btn;
	private List<Jeu> jeux;

	public ControleurFormCreerTournoi(FormCreerTournoi vue) {
		this.vue = vue;
		this.jeux = new ArrayList<>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.btn = (JButton) e.getSource();
		switch (btn.getName()) {
		case "btnAjouterJeu":
			this.jeux.add(new Jeu(BDSelect.getIdJeu(this.vue.getComboJeux().getSelectedItem().toString())));// Stockage du jeu selectionné
			this.vue.getPanelJeuxAjoutes().setLayout(new GridLayout(this.jeux.size(), 1, 0, 0));
			JLabel lblNomJeu = new JLabel(this.vue.getComboJeux().getSelectedItem().toString()); // Créer le label concernant le jeu selectionné dans le combo
			this.vue.getPanelJeuxAjoutes().add(lblNomJeu);		// Ajout du label dans le pannel
			this.vue.getPanelJeuxAjoutes().updateUI(); 		// Maj du panel
			this.vue.getComboJeux().removeItem(this.vue.getComboJeux().getSelectedItem()); // Enleve le jeu du combo apres l'avoir ajouté
			if (this.vue.getComboJeux().getItemCount() == 0) {		// Si il n'y a plus de jeu rendre invisible le bouton et le combo
				this.vue.getComboJeux().setVisible(false);
				this.vue.getBtnAjouterJeux().setVisible(false); 
			}
			break;
		case "btnInserer" :
			if(this.vue.getTextFieldNom().getText().compareTo("") == 0 && !(this.vue.getLabelNom().getForeground().equals(new Color(255, 0, 0)))) {
				this.vue.getLabelNom().setText(this.vue.getLabelNom().getText() + "      *vide*");
				this.vue.getLabelNom().setForeground(new Color(255, 0, 0));
			} else if (!(this.vue.getTextFieldNom().getText().compareTo("") == 0)){
				this.vue.getLabelNom().setText("Nom ");
				this.vue.getLabelNom().setForeground(new Color(51, 51, 51));
			}

			if(this.jeux.size() == 0 && !(this.vue.getLabelJeuxAjoutes().getForeground().equals(new Color(255, 0, 0)))) {
				this.vue.getLabelJeuxAjoutes().setText(this.vue.getLabelJeuxAjoutes().getText() + "      *vide*");
				this.vue.getLabelJeuxAjoutes().setForeground(new Color(255, 0, 0));
			} else if(this.jeux.size() != 0) {
				this.vue.getLabelJeuxAjoutes().setText("Jeux Ajoutés :");
				this.vue.getLabelJeuxAjoutes().setForeground(new Color(51, 51, 51));
			}

			PreDate dateDebutTournois = new PreDate(Integer.parseInt(this.vue.getSelectedValueComboAnneeDebutTournoi()), Mois.stringToMois(this.vue.getSelectedValueComboMoiDebutTournoi()).getMoisChiffre(), Integer.parseInt(this.vue.getSelectedValueComboJourDebutTournoi()));
			PreDate dateFinTournois =  new PreDate(Integer.parseInt(this.vue.getSelectedValueComboAnneeFinInscription()), Mois.stringToMois(this.vue.getSelectedValueComboMoiFinTournoi()).getMoisChiffre(), Integer.parseInt(this.vue.getSelectedValueComboJourFinTournoi()));
			PreDate dateFinInscription = new PreDate(Integer.parseInt(this.vue.getSelectedValueComboAnneeFinInscription()), Mois.stringToMois(this.vue.getSelectedValueComboMoiFinInscription()).getMoisChiffre(), Integer.parseInt(this.vue.getSelectedValueComboJourFinInscription()));
			PreDate dateTest = new PreDate(2022, 1, 31);
		
			if (!(dateDebutTournois.estDateValide()) && !(this.vue.getLabelDateDebutTournoi().getForeground().equals(new Color(255, 0, 0)))) {
				this.vue.getLabelDateDebutTournoi().setText(this.vue.getLabelDateDebutTournoi().getText() + "*");
				this.vue.getLabelDateDebutTournoi().setForeground(new Color(255, 0, 0));
			} else if (dateDebutTournois.estDateValide()) {
				this.vue.getLabelDateDebutTournoi().setText("Date Début Tournoi");
				this.vue.getLabelDateDebutTournoi().setForeground(new Color(51, 51, 51));
			}
			
			if (!(dateFinTournois.estDateValide()) && !(this.vue.getLabelDateFinTournoi().getForeground().equals(new Color(255, 0, 0)))) {
				this.vue.getLabelDateFinTournoi().setText(this.vue.getLabelDateFinTournoi().getText() + "*");
				this.vue.getLabelDateFinTournoi().setForeground(new Color(255, 0, 0));
			} else if (dateFinTournois.estDateValide()) {
				this.vue.getLabelDateFinTournoi().setText("Date Fin Tournoi");
				this.vue.getLabelDateFinTournoi().setForeground(new Color(51, 51, 51));
			} 
			
			if (!(dateFinInscription.estDateValide()) && !(this.vue.getLabelDateFinInscription().getForeground().equals(new Color(255, 0, 0)))) {
				this.vue.getLabelDateFinInscription().setText(this.vue.getLabelDateFinInscription().getText() + "*");
				this.vue.getLabelDateFinInscription().setForeground(new Color(255, 0, 0));
			} else if (dateFinInscription.estDateValide()) {
				this.vue.getLabelDateFinInscription().setText("Date Fin Inscription");
				this.vue.getLabelDateFinInscription().setForeground(new Color(51, 51, 51));
			}
			
			if(dateFinTournois.toDate().compareTo(dateDebutTournois.toDate()) < 0) {
				if (!(this.vue.getLabelDateDebutTournoi().getForeground().equals(new Color(255, 0, 0)))) {
					this.vue.getLabelDateDebutTournoi().setText(this.vue.getLabelDateDebutTournoi().getText() + "*");
					this.vue.getLabelDateDebutTournoi().setForeground(new Color(255, 0, 0));
				}
				if (!(this.vue.getLabelDateFinTournoi().getForeground().equals(new Color(255, 0, 0)))) {
					this.vue.getLabelDateFinTournoi().setText(this.vue.getLabelDateFinTournoi().getText() + "*");
					this.vue.getLabelDateFinTournoi().setForeground(new Color(255, 0, 0));
				}
			}
			
			if(dateFinInscription.toDate().compareTo(dateDebutTournois.toDate()) > 0) {
				if (!(this.vue.getLabelDateFinTournoi().getForeground().equals(new Color(255, 0, 0)))) {
					this.vue.getLabelDateFinInscription().setText(this.vue.getLabelDateFinInscription().getText() + "*");
					this.vue.getLabelDateFinInscription().setForeground(new Color(255, 0, 0));
				}
			}
			
			if(this.estFormulaireValide()) {
				if(this.jeux.size() == 1) {
					Tournoi.insererTournoi(this.vue.getTextFieldNom().getText(), Portee.stringToPortee(this.vue.getComboPortee().getSelectedItem().toString()), dateFinInscription.toDate(), dateDebutTournois.toDate(), dateFinTournois.toDate(), this.jeux.get(0), this.vue.getIdGerant());
				} else {
					Tournoi.insererTournoisMultigaming(this.vue.getTextFieldNom().getText(), Portee.stringToPortee(this.vue.getComboPortee().getSelectedItem().toString()), dateFinInscription.toDate(), dateDebutTournois.toDate(), dateFinTournois.toDate(), this.jeux, this.vue.getIdGerant());
				}
				this.vue.dispose();
			}
			break;
		case "btnCancel" :
			this.vue.dispose();
			break;
		}
	}
	
	private boolean estFormulaireValide() {
		if(this.vue.getLabelNom().getForeground().equals(new Color(255, 0, 0)) ||
				this.vue.getLabelJeuxAjoutes().getForeground().equals(new Color(255, 0, 0)) ||
				this.vue.getLabelDateDebutTournoi().getForeground().equals(new Color(255, 0, 0)) ||
				this.vue.getLabelDateFinTournoi().getForeground().equals(new Color(255, 0, 0)) ||
				this.vue.getLabelDateFinInscription().getForeground().equals(new Color(255, 0, 0))
				) {
			return false;
		}
		return true;
	}

}

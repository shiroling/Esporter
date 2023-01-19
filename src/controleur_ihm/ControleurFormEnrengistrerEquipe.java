package controleur_ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;

import contoleur_bd.BDInsert;
import contoleur_bd.BDSelect;
import contoleur_bd.Equipe;
import contoleur_bd.Jeu;
import contoleur_bd.PreJoueur;
import interfaces.FenMessage;
import interfaces.FormEnregistrerEquipe;
import interfaces.FormEnregistrerJoueur;

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
			} else if(this.preJoueurs.size() < 4) {
				this.vue.getLblJoueurNonAjoutes().setVisible(true);
			} else {
				System.out.println("tout bon");
				Equipe.inserer(nomEquipe, Jeu.getJeuFromName(this.vue.getComboJeux().getSelectedItem().toString()).getId(), this.vue.getEcurie().getId());
				Equipe equipe = Equipe.getEquipeFromNom(nomEquipe);
				
				for(PreJoueur j : this.preJoueurs) {
					BDInsert.insererJoueur(j.getNom(), j.getPrenom(), j.getNaissance(), j.getPseudo(), equipe.getId());
				}
				
				FenMessage fen = new FenMessage("Equipe '" + equipe.getNom() + "' à bien été créée");
				fen.setVisible(true);
				this.vue.dispose();
			}
			break;
		case "AjouterJoueurs":
			while(this.preJoueurs.size() < 4) {
				FormEnregistrerJoueur formJoueur = new FormEnregistrerJoueur(this);
				formJoueur.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				formJoueur.setVisible(true);
			}
			break;
		case "Annuler":
			this.vue.dispose();
			break;
		}
	}
	
	public void addPreJoueur(String nom, String prenom, Date naissance, String pseudo) throws IllegalArgumentException {
		this.preJoueurs.add(new PreJoueur(nom, prenom, naissance, pseudo));
		switch(this.preJoueurs.size()) {
		case 1:
			this.vue.getLblJoueur1().setText(this.vue.getLblJoueur1().getText() + " " + pseudo);
			this.vue.getLblJoueur1().updateUI();
			break;
		case 2:
			this.vue.getLblJoueur2().setText(this.vue.getLblJoueur2().getText() + " " + pseudo);
			this.vue.getLblJoueur2().updateUI();
			break;
		case 3:
			this.vue.getLblJoueur3().setText(this.vue.getLblJoueur3().getText() + " " + pseudo);
			this.vue.getLblJoueur3().updateUI();
			break;
		case 4:
			this.vue.getLblJoueur4().setText(this.vue.getLblJoueur4().getText() + " " + pseudo);
			this.vue.getLblJoueur4().updateUI();
			break;
		default :
			throw new IllegalArgumentException("AddPreJoueur Exception : nbPreJoueur invalide");
		}
	}

}

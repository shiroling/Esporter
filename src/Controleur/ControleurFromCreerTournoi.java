	package Controleur;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import IHM.FormCreerTournoi;
import DBlink.*;

public class ControleurFromCreerTournoi implements ActionListener {
	
	private FormCreerTournoi vue;
	private JButton btn;
	private List<Jeu> jeux;
	
	public ControleurFromCreerTournoi(FormCreerTournoi vue) {
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
			break;
		case "combo" :
			break;
		}
	}

}

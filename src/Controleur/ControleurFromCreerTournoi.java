package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import IHM.FormCreerTournoi;
import modeleBD.ControleurBD;
import modeleBD.Jeu;

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
			this.jeux.add(new Jeu(ControleurBD.getIdJeu(this.vue.getComboJeux().getSelectedItem().toString())));// Stockage du jeu selectionné
			this.vue.ajouterJeuDansPanel(this.vue.getComboJeux().getSelectedItem().toString());
			this.vue.getComboJeux().removeItem(this.vue.getComboJeux().getSelectedItem());;
			break;
		case "btnInserer" :
			break;
		}
	}

}

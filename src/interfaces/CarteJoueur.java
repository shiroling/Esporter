package interfaces;

import java.awt.Font;

import javax.swing.JLabel;

import contoleur_bd.Joueur;

public class CarteJoueur extends Carte {

	/**
	 * Create the panel.
	 */
	public CarteJoueur(Joueur j) {
		super();
		JLabel lblecurie = new JLabel("Ecurie : "+j.getEquipe().getEcurie().toString());
		JLabel lblEquipe =new JLabel("Equipe : "+j.getEquipe().toString());
		lblecurie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblecurie);
	}
	
}

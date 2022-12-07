package IHM;
import javax.swing.JPanel;

import DBlink.Jeu;

public class CarteJeu extends Carte {

	/**
	 * Create the panel.
	 */
	public CarteJeu(Jeu j) {
		super("Jeu",j.getNom());
	}

}

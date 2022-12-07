package IHM;
import javax.swing.JPanel;

import DBlink.Jeu;

public class CarteJeu extends Carte {
	private Jeu jeu;
	/**
	 * Create the panel.
	 */
	public CarteJeu(Jeu j) {
		super("Jeu",j.getNom());
		this.jeu=j;
	}

	public Jeu getJeu() {
		return jeu;
	}
}

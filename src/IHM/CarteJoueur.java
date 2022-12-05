package IHM;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarteJoueur extends Carte {

	/**
	 * Create the panel.
	 */
	public CarteJoueur(String nom, String ecurie) {
		super(nom);
		JLabel lblecurie = new JLabel(ecurie);
		lblecurie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblecurie);
	}

}

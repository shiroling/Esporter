package interfaces;
import java.awt.Font;

import javax.swing.JLabel;

import contoleur_bd.Poule;

public class CartePoule extends Carte {

	/**
	 * Create the panel.
	 */
	public CartePoule(Poule p) {
		super();
		JLabel lbltournois	 = new JLabel(p.getTournoi().toString());
		lbltournois.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lbltournois);
	}

}

package IHM;
import java.awt.Font;

import javax.swing.JLabel;

import DBlink.Poule;

public class CartePoule extends Carte {

	/**
	 * Create the panel.
	 */
	public CartePoule(Poule p) {
		super("Poule",null);
		JLabel lbltournois	 = new JLabel(p.getTournoi().toString());
		lbltournois.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lbltournois);
	}

}

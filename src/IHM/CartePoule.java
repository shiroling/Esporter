package IHM;
import java.awt.Font;

import javax.swing.JLabel;

public class CartePoule extends Carte {

	/**
	 * Create the panel.
	 */
	public CartePoule(String nom,String tournois) {
		super(nom);
		JLabel lbltournois	 = new JLabel(tournois);
		lbltournois.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lbltournois);
	}

}

package IHM;
import java.awt.Font;

import javax.swing.JLabel;

public class CarteTournois extends Carte {

	/**
	 * Create the panel.
	 */
	public CarteTournois(String nom,String dateDebut,String dateFin) {
		super(nom);
		JLabel lbldate = new JLabel(dateDebut+" - "+dateFin);
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lbldate);
	}

}

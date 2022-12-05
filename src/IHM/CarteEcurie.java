package IHM;
import java.awt.Font;

import javax.swing.JLabel;

public class CarteEcurie extends Carte {

	/**
	 * Create the panel.
	 */
	public CarteEcurie(String nom,String manager) {
		super(nom);
		JLabel lblmanager = new JLabel(manager);
		lblmanager.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblmanager);
	}

}

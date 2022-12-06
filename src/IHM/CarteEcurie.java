package IHM;
import java.awt.Font;

import javax.swing.JLabel;

import DBlink.Ecurie;

public class CarteEcurie extends Carte {

	private Ecurie ecurie;
	/**
	 * Create the panel.
	 */
	public CarteEcurie(Ecurie ec) {
		super(ec.getNom());
		JLabel lblmanager = new JLabel(ec.getNomManager());
		lblmanager.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblmanager);
		ecurie=ec;
	}
	public Ecurie getEcurie() {
		return ecurie;
	}
}

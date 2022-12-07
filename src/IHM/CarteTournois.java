package IHM;
import java.awt.Font;

import javax.swing.JLabel;

import DBlink.Tournoi;

public class CarteTournois extends Carte {
	private Tournoi tournoi;
	/**
	 * Create the panel.
	 */
	public CarteTournois(Tournoi tournoi) {
		super("Tournoi",tournoi.getNom());
		this.tournoi = tournoi;
		JLabel lbldate = new JLabel("Du :"+ tournoi.getDateDebut()+" au "+tournoi.getDateFin());
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lbldate);
	}

}

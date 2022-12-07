package IHM;
import java.awt.Font;

import javax.swing.JLabel;

import DBlink.Rencontre;

public class CarteRencontre extends Carte {

	/**
	 * Create the panel.
	 */
	public CarteRencontre(Rencontre r) {
		
		super("Match", nomCopose(r));
		JLabel lbldate = new JLabel(r.getDate().toString());
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lbldate);
		if (r.estResultatRenseigne()) {
			JLabel lblgagnant = new JLabel(r.getVainqueur().toString());
			lblgagnant.setFont(new Font("Tahoma", Font.PLAIN, 20));
			add(lblgagnant);
		}
	}

	public static String nomCopose(Rencontre r) {
		return r.getEquipes().get(0).toString()+ " - " +r.getEquipes().get(1).toString();
	}


}

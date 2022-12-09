package IHM;
import java.awt.Font;

import javax.swing.JLabel;

import DBlink.Rencontre;

public class CarteRencontre extends Carte {
	private Rencontre rencontre;
	/**
	 * Create the panel.
	 */
	public CarteRencontre(Rencontre rencontre) {
		//super("Match",r.getEquipes().get(0).toString()+" - "+r.getEquipes().get(1).toString());
		super();
		this.rencontre = rencontre;
		
		//JLabel lbldate = new JLabel(rencontre.getDate().toString());
		/*
		if (rencontre.estResultatRenseigne()) {
			JLabel lblgagnant = new JLabel(rencontre.getVainqueur().toString());
			lblgagnant.setFont(new Font("Tahoma", Font.PLAIN, 20));
			add(lblgagnant);
		}
		*/
	}
	public Rencontre getRencontre() {
		return rencontre;
	}



}

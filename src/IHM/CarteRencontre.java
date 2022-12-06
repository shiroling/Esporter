package IHM;
import java.awt.Font;

import javax.swing.JLabel;

import DBlink.Rencontre;

public class CarteRencontre extends Carte {

	/**
	 * Create the panel.
	 */
	public CarteRencontre(String equipe1,String equipe2,String date,String gagnant) {
		super(equipe1+" - "+equipe2);
		JLabel lbldate = new JLabel(date);
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lbldate);
		if (gagnant != null) {
			JLabel lblgagnant = new JLabel(gagnant);
			lblgagnant.setFont(new Font("Tahoma", Font.PLAIN, 20));
			add(lblgagnant);
		}
	}

	public CarteRencontre(Rencontre rencontre) {
		
		// TODO Auto-generated constructor stub
	}

}

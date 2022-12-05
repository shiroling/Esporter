package IHM;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarteEquipe extends Carte {

	/**
	 * Create the panel.
	 */
	public CarteEquipe(String nom,String manager,String ecurie) {
		super(nom);
		JLabel lblManager = new JLabel(manager);
		lblManager.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblManager);
		JLabel lblecurie = new JLabel(ecurie);
		lblecurie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblecurie);
		

	}

}

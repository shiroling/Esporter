package IHM;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Carte extends JPanel {

	/**
	 * Create the panel.
	 */
	public Carte(String nom) {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNom = new JLabel(nom);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblNom);

	}
}

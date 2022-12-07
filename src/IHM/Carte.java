package IHM;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Carte extends JPanel {
	protected final static String newLine = System.getProperty("line.separator");
	/**
	 * Create the panel.
	 */
	public Carte(String categ,String nom) {
		setLayout(new GridLayout(0, 1, 0, 0));
		JLabel lblCat = new JLabel(categ);
		lblCat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblCat);
		
		JLabel lblNom = new JLabel(nom);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblNom);

	}
}

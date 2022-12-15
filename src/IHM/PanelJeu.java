package IHM;

import javax.swing.JPanel;

import DBlink.Jeu;
import javax.swing.JLabel;

public class PanelJeu extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelJeu(Jeu j) {
		
		JPanel panelNom = new JPanel();
		add(panelNom);
		JLabel lblLogo = new JLabel();

		//lblLogo.setIcon(j.getPathLogo());
		//panelNom.add(lblLogo);
		
		JLabel lblnom = new JLabel(j.getNom());
		panelNom.add(lblnom);
		
		/*
		 * a mediter vu qu'il y a rine de ouf a mettre
		 */
	}

}

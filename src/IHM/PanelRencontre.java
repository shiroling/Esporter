package IHM;

import javax.swing.JLabel;
import javax.swing.JPanel;

import DBlink.Poule;
import DBlink.Rencontre;
import DBlink.Tournoi;

import java.awt.GridLayout;
import javax.swing.JScrollPane;

public class PanelRencontre extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelRencontre(Rencontre r) {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelRencontre = new JPanel();
		add(panelRencontre);
		
		JLabel lblNomRencontre = new JLabel(r.getTournoi().getNom());
		panelRencontre.add(lblNomRencontre);
		
		
		
		JPanel panelEquipe1 = new JPanel();
		add(panelEquipe1);
		
		JPanel panelEquipe2 = new JPanel();
		add(panelEquipe2);
		

	}

}

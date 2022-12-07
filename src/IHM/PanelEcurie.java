package IHM;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Controleur.ControleurAccueil;
import DBlink.ControleurBD;
import DBlink.Ecurie;
import DBlink.Equipe;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PanelEcurie extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelEcurie(Ecurie ec) {
		setLayout(new GridLayout(5, 1, 0, 0));
		
		JLabel lblNom = new JLabel(ec.getNom());
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(lblNom);
		
		JLabel lblmanager = new JLabel("Manager : "+ec.getNomManager());
		lblmanager.setHorizontalAlignment(SwingConstants.LEFT);
		lblmanager.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblmanager);
		
		JScrollPane scroll = new JScrollPane();
		add(scroll);
		
		JPanel panel = new JPanel();
		scroll.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		for (Equipe eq : ControleurBD.getListeEquipes()) {
			JLabel lblequipe = new JLabel(eq.getNom());
			lblequipe.setHorizontalAlignment(SwingConstants.LEFT);
			lblequipe.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblequipe.addMouseListener(AccueilV2.getMa());
			panel.add(lblequipe);
		}
		

	}

}

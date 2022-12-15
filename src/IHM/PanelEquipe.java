package IHM;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import DBlink.Equipe;
import DBlink.Joueur;
import java.awt.BorderLayout;

public class PanelEquipe extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelEquipe(Equipe eq) {
		JPanel panel_main = new JPanel();
		panel_main.setLayout(new GridLayout(5, 1, 0, 0));;
		setLayout(new BorderLayout(0, 0));
		add(panel_main);
		
		JLabel lblNom = new JLabel(eq.getNom());
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_main.add(lblNom);
		
		JLabel lblmanager = new JLabel(eq.getEcurie().getNomManager());
		lblmanager.setHorizontalAlignment(SwingConstants.LEFT);
		lblmanager.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblmanager.setName("lblmanager");
		panel_main.add(lblmanager);
		
		JLabel lblEcurie = new JLabel(eq.getEcurie().getNom());
		lblEcurie.setHorizontalAlignment(SwingConstants.LEFT);
		lblEcurie.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEcurie.setName("Ecurie");
		lblEcurie.addMouseListener(AccueilV2.getMa());
		panel_main.add(lblEcurie);
		
		JLabel lbljoueur;
		
		JScrollPane scroll = new JScrollPane();
		panel_main.add(scroll);
		
		JPanel panel = new JPanel();
		scroll.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		for (Joueur j : eq.getListJoueur()) {
			lbljoueur = new JLabel(j.getPseudo());
			lbljoueur.setName("Joueur");
			lbljoueur.setHorizontalAlignment(SwingConstants.LEFT);
			lbljoueur.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lbljoueur.addMouseListener(AccueilV2.getMa());
			panel.add(lbljoueur);
		}
		panel.setLayout(new GridLayout(panel.getComponentCount()+1, 1, 0, 0));
	}

}

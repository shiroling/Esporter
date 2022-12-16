package IHM;

import javax.swing.JLabel;
import javax.swing.JPanel;

import DBlink.Equipe;
import DBlink.Joueur;
import DBlink.Poule;
import DBlink.Rencontre;
import DBlink.Tournoi;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class PanelRencontre extends JPanel {
	private int idRencontre; 

	/**
	 * Create the panel.
	 */
	public PanelRencontre(Rencontre r) {
		
		idRencontre = r.getId();
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelRencontre = new JPanel();
		add(panelRencontre);
		
		JLabel lbllblNomRencontre = new JLabel("Rencontre du tournoi  : ");
		panelRencontre.add(lbllblNomRencontre);
		
		JLabel lblNomRencontre = new JLabel(r.getTournoi().toString());
		lblNomRencontre.setName("Tournoi");
		lblNomRencontre.addMouseListener(AccueilV2.getMa());
		panelRencontre.add(lblNomRencontre);
		
		
		
		JPanel panelEquipe1 = new JPanel();
		add(panelEquipe1);
		
		JScrollPane scrollE1 = new JScrollPane();
		panelEquipe1.add(scrollE1);
		
		JPanel panelJoueurE1 = new JPanel();
		scrollE1.setViewportView(panelJoueurE1);
		panelJoueurE1.setLayout(new GridLayout(0, 1, 0, 0));
		
		Equipe tempE = r.getEquipes().get(0);
		JLabel lbljoueur;
		for (Joueur j : tempE.getListJoueur()) {
			lbljoueur = new JLabel(j.getPseudo());
			lbljoueur.setName("Joueur");
			lbljoueur.setHorizontalAlignment(SwingConstants.LEFT);
			lbljoueur.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lbljoueur.addMouseListener(AccueilV2.getMa());
			panelJoueurE1.add(lbljoueur);
		}
		
		
		
		JPanel panelEquipe2 = new JPanel();
		add(panelEquipe2);
		
		JScrollPane scrollE2 = new JScrollPane();
		panelEquipe2.add(scrollE2);

		JPanel panelJoueurE2 = new JPanel();
		scrollE2.setViewportView(panelJoueurE2);
		panelJoueurE2.setLayout(new GridLayout(0, 1, 0, 0));

		Equipe temp  = r.getEquipes().get(1);
		for (Joueur j : temp.getListJoueur()) {
			lbljoueur = new JLabel(j.getPseudo());
			lbljoueur.setName("Joueur");
			lbljoueur.setHorizontalAlignment(SwingConstants.LEFT);
			lbljoueur.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lbljoueur.addMouseListener(AccueilV2.getMa());
			panelJoueurE2.add(lbljoueur);
		}
		
		
		
		
	}

}

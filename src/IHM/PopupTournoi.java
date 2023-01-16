package IHM;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Controleur.ControlerPopupTournoi;
import Controleur.ControleurAccueil;
import DBlink.BDSelect;
import DBlink.Equipe;
import DBlink.Poule;
import DBlink.Rencontre;
import DBlink.Tournoi;

public class PopupTournoi extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Tournoi tournoi;
	private JPanel panellblEquipe;
	private JPanel panelEquipes;

	/**
	 * Create the dialog.
	 */
	public PopupTournoi(Tournoi t) {
		ControlerPopupTournoi controleur = new ControlerPopupTournoi(this);

		tournoi = t;
		setBounds(100, 100, 450, 300);
		setTitle("Tournoi : " + this.getTournoi().getNom());
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JPanel panelHead = new JPanel();
		contentPanel.add(panelHead, BorderLayout.NORTH);
		panelHead.setLayout(new GridLayout(3, 1, 0, 0));

		JPanel panelNom = new JPanel();
		panelHead.add(panelNom);

		JLabel lblNom = new JLabel(t.getNom().toString());
		panelNom.add(lblNom);

		JPanel panelDates = new JPanel();
		panelHead.add(panelDates);

		JLabel lblDateDebut = new JLabel(t.getDateDebut().toString());
		panelDates.add(lblDateDebut);

		JLabel lblSeparateur = new JLabel(" - ");
		panelDates.add(lblSeparateur);

		JLabel lblDateFin = new JLabel(t.getDateFin().toString());
		panelDates.add(lblDateFin);



		

		JPanel panelCorp = new JPanel();
		contentPanel.add(panelCorp, BorderLayout.CENTER);
		panelCorp.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPaneEquipe = new JScrollPane();
		panelCorp.add(scrollPaneEquipe);

		JPanel panelEquipes = new JPanel();
		scrollPaneEquipe.setViewportView(panelEquipes);
		panelEquipes.setLayout(new GridLayout(t.getListEquipesParticipantes().size() + 1, 1, 0, 0));

		JPanel panellblEquipe = new JPanel();
		panelEquipes.add(panellblEquipe);

		if (t.isFini()) {
			JLabel lbllblEquipe = new JLabel("Classement des equipes:");
			panellblEquipe.add(lbllblEquipe);
		} else {
			JLabel lbllblEquipe = new JLabel("Classement temporaire des equipes:");
			panellblEquipe.add(lbllblEquipe);
		}

		JPanel panelInscription = new JPanel();
		contentPanel.add(panelInscription, BorderLayout.SOUTH);
		JLabel lblInscription = new JLabel("Date limite d'inscription : " + t.getDateFinInscriptions().toString());
		panelInscription.add(lblInscription);
		
		if (!t.isTournoiPlein()) {
			JButton btnInscription = new JButton("Inscrire une équipe");
			btnInscription.addActionListener(controleur);
			btnInscription.setName("inscription");
			panelInscription.add(btnInscription);
		} else {
			JLabel lblPlein = new JLabel("Le tournoi est plein");
			panelInscription.add(lblPlein);
		}

		for (Equipe e : tournoi.getClassement()) {
			JPanel panelEquipe = new JPanel();
			panelEquipes.add(panelEquipe);
			if (e == tournoi.getClassement().get(0)) {
				JLabel equipe = new JLabel(e.getNom() + "-- Vainqueur");
			} else {
				JLabel equipe = new JLabel(e.getNom());
				equipe.setName("Equipe");
				equipe.addMouseListener(AccueilV2.getMa());
				panelEquipe.add(equipe);
			}
			JLabel equipe = new JLabel(e.getNom());
			equipe.setName("Equipe");
			equipe.addMouseListener(AccueilV2.getMa());
			panelEquipe.add(equipe);

		}
	}

	public Tournoi getTournoi() {
		return this.tournoi;
	}
	
	public void actualiserPopupTournoi() {
		panelEquipes.removeAll();
		for (Equipe e : tournoi.getListEquipesParticipantes()) {
			JPanel panelEquipe = new JPanel();
			panelEquipes.add(panelEquipe);
			JLabel equipe = new JLabel(e.getNom());
			equipe.setName("Equipe");
			equipe.addMouseListener(AccueilV2.getMa());
			panelEquipe.add(equipe);
		}
		panelEquipes.updateUI();
	}

}

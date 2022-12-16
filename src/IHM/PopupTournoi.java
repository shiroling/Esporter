package IHM;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import DBlink.Equipe;
import DBlink.Rencontre;
import DBlink.Tournoi;

public class PopupTournoi extends JDialog {

	private final JPanel contentPanel = new JPanel();



	/**
	 * Create the dialog.
	 */
	public PopupTournoi(Tournoi t) {
		setBounds(100, 100, 450, 300);
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
		
		JPanel panelInscription = new JPanel();
		panelHead.add(panelInscription);
		
		JLabel lblInscription = new JLabel("Date limite d'inscription : "+t.getDateFinInscriptions().toString());
		panelInscription.add(lblInscription);
		
		JButton btnNewButton = new JButton("S'inscrire");
		panelInscription.add(btnNewButton);
		
		JPanel panelCorp = new JPanel();
		contentPanel.add(panelCorp, BorderLayout.CENTER);
		panelCorp.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JScrollPane scrollPaneEquipe = new JScrollPane();
		panelCorp.add(scrollPaneEquipe);
		
		JPanel panelEquipes = new JPanel();
		scrollPaneEquipe.setViewportView(panelEquipes);
		panelEquipes.setLayout(new GridLayout(t.getListEquipesParticipantes().size()+1, 1, 0, 0));
		
		JPanel panellblEquipe = new JPanel();
		panelEquipes.add(panellblEquipe);
		
		JLabel lbllblEquipe = new JLabel("Equipes:");
		panellblEquipe.add(lbllblEquipe);
		
		for (Equipe e : t.getListEquipesParticipantes()) {
			JPanel panelEquipe = new JPanel();
			panelEquipes.add(panelEquipe);
			JLabel equipe = new JLabel(e.getNom());
			equipe.setName("Equipe");
			equipe.addMouseListener(AccueilV2.getMa());
			panelEquipe.add(equipe);
		}
		
	}

}

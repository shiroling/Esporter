package IHM;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBlink.Equipe;
import DBlink.Rencontre;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class PopupRencontre extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Equipe equipe1;
	private Equipe equipe2;

	/**
	 * Create the dialog.
	 */
	public PopupRencontre(Rencontre r) {
		equipe1 = r.getEquipes().get(0);
		equipe2 = r.getEquipes().get(1);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelHead = new JPanel();
		contentPanel.add(panelHead, BorderLayout.NORTH);
		panelHead.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panelTournoisRencontre = new JPanel();
		panelHead.add(panelTournoisRencontre);
		
		JLabel lblNomTournoi = new JLabel(r.getTournoi().getNom());
		panelTournoisRencontre.add(lblNomTournoi);
		
		JPanel panelEquipes = new JPanel();
		panelHead.add(panelEquipes);
		

		
		JLabel lblEquipe1 = new JLabel(r.getEquipes().get(0).getNom());
		lblEquipe1.addMouseListener(AccueilV2.getMa());
		lblEquipe1.setName("Equipe");
		panelEquipes.add(lblEquipe1);
		
		JLabel lblseparateur = new JLabel(" - ");
		panelEquipes.add(lblseparateur);
		
		JLabel lblEquipe2 = new JLabel(r.getEquipes().get(1).getNom());
		lblEquipe1.addMouseListener(AccueilV2.getMa());
		lblEquipe1.setName("Equipe");
		panelEquipes.add(lblEquipe2);
		
		JPanel panelDate = new JPanel();
		panelHead.add(panelDate);
		
		JLabel lblDate = new JLabel(r.getDate().toString());
		panelDate.add(lblDate);
		
		JPanel panelVainqueur = new JPanel();
		panelHead.add(panelVainqueur);
		
		if (r.estResultatRenseigne()) {
			JLabel lblNewLabel = new JLabel("Vainqueur : ");
			panelVainqueur.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel(r.getVainqueur().getNom());
			panelVainqueur.add(lblNewLabel_1);
		}
		else {
			JButton btnNewButton = new JButton("Renseigner Vainqueur");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("connexction puis verifi si est bien un arbitre puis arbitre de la rencontre");
				}
			});
			panelVainqueur.add(btnNewButton);
		}
		
		
		JPanel panelCorp = new JPanel();
		contentPanel.add(panelCorp, BorderLayout.CENTER);
		panelCorp.setLayout(new GridLayout(0, 2, 0, 0));
		
		JScrollPane scrollPaneEq1 = new JScrollPane();
		panelCorp.add(scrollPaneEq1);
		
		JPanel panelEq1 = new JPanel();
		scrollPaneEq1.setViewportView(panelEq1);
		panelEq1.setLayout(new GridLayout(6, 1, 0, 0));
		
		JLabel panelNomEq1 = new JLabel(equipe1.getNom()+" : ");
		panelEq1.add(panelNomEq1);
		
		JLabel panelEQ1J1 = new JLabel(equipe1.getListJoueur().get(0).getPseudo());
		panelEQ1J1.setName("Joueur");
		panelEQ1J1.addMouseListener(AccueilV2.getMa());
		panelEq1.add(panelEQ1J1);
		
		JLabel panelEQ1J2 = new JLabel(equipe1.getListJoueur().get(1).getPseudo());
		panelEq1.add(panelEQ1J2);
		
		JLabel panelEQ1J3 = new JLabel(equipe1.getListJoueur().get(2).getPseudo());
		panelEq1.add(panelEQ1J3);
		
		JLabel panelEQ1J4 = new JLabel(equipe1.getListJoueur().get(3).getPseudo());
		panelEq1.add(panelEQ1J4);
		
		JScrollPane scrollPaneEq2 = new JScrollPane();
		panelCorp.add(scrollPaneEq2);
		
		for (Component c : panelEq1.getComponents()) {
			JLabel panel = (JLabel)c;
			panel.setName("Joueur");
			panel.addMouseListener(AccueilV2.getMa());
		}
		
		JPanel panelEq2 = new JPanel();
		scrollPaneEq2.setViewportView(panelEq2);
		panelEq2.setLayout(new GridLayout(6, 1, 0, 0));
		
		JLabel panelNomEq2 = new JLabel(equipe2.getNom()+" : ");
		panelEq2.add(panelNomEq2);
		
		JLabel panelEQ2J1 = new JLabel(equipe2.getListJoueur().get(0).getPseudo());
		panelEq2.add(panelEQ2J1);
		
		JLabel panelEQ2J2 = new JLabel(equipe2.getListJoueur().get(1).getPseudo());
		panelEq2.add(panelEQ2J2);
		
		JLabel panelEQ2J3 = new JLabel(equipe2.getListJoueur().get(2).getPseudo());
		panelEq2.add(panelEQ2J3);
		
		JLabel panelEQ2J4 = new JLabel(equipe2.getListJoueur().get(3).getPseudo());
		panelEq2.add(panelEQ2J4);
		
	}

}

package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBlink.Rencontre;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class PopupRencontre extends JDialog {

	private final JPanel contentPanel = new JPanel();



	/**
	 * Create the dialog.
	 */
	public PopupRencontre(Rencontre r) {
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
		
		JPanel panelNomEq1 = new JPanel();
		panelEq1.add(panelNomEq1);
		
		JPanel panelEQ1J1 = new JPanel();
		panelEq1.add(panelEQ1J1);
		
		JPanel panelEQ1J2 = new JPanel();
		panelEq1.add(panelEQ1J2);
		
		JPanel panelEQ1J3 = new JPanel();
		panelEq1.add(panelEQ1J3);
		
		JPanel panelEQ1J4 = new JPanel();
		panelEq1.add(panelEQ1J4);
		
		JPanel panelEQ1J5 = new JPanel();
		panelEq1.add(panelEQ1J5);
		
		JScrollPane scrollPaneEq2 = new JScrollPane();
		panelCorp.add(scrollPaneEq2);
		
		JPanel panelEq2 = new JPanel();
		scrollPaneEq2.setViewportView(panelEq2);
		panelEq2.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panelNomEq2 = new JPanel();
		panelEq2.add(panelNomEq2);
		
		JPanel panelEQ2J1 = new JPanel();
		panelEq2.add(panelEQ2J1);
		
		JPanel panelEQ2J2 = new JPanel();
		panelEq2.add(panelEQ2J2);
		
		JPanel panelEQ2J3 = new JPanel();
		panelEq2.add(panelEQ2J3);
		
		JPanel panelEQ2J4 = new JPanel();
		panelEq2.add(panelEQ2J4);
		
		JPanel panelEQ2J5 = new JPanel();
		panelEq2.add(panelEQ2J5);
		
	}

}

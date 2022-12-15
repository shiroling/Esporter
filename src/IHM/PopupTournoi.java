package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBlink.Tournoi;
import javax.swing.JLabel;
import java.awt.GridLayout;

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
		
		
	}

}

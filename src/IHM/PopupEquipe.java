package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBlink.Equipe;
import DBlink.Joueur;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;

public class PopupEquipe extends JDialog {

	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public PopupEquipe(Equipe e) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelHead = new JPanel();
		contentPanel.add(panelHead, BorderLayout.NORTH);
		
		JPanel panelNom = new JPanel();
		panelHead.add(panelNom);
		
		JLabel lblNom = new JLabel(e.getNom());
		panelNom.add(lblNom);
		
		JPanel panelCorp = new JPanel();
		contentPanel.add(panelCorp, BorderLayout.CENTER);
		panelCorp.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPaneJoueurs = new JScrollPane();
		panelCorp.add(scrollPaneJoueurs);
		
		JPanel panelJoueurs = new JPanel();
		scrollPaneJoueurs.setViewportView(panelJoueurs);
		panelJoueurs.setLayout(new GridLayout(5, 0, 0, 0));
		
		for (Joueur j : e.getListJoueur()) {	
			JLabel lblJoueur = new JLabel(j.getNom());
			panelJoueurs.add(lblJoueur);
		}
	}

}

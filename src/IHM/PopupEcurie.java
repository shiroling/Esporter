package IHM;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBlink.Ecurie;
import DBlink.Equipe;

public class PopupEcurie extends JDialog {

	private final JPanel contentPanel = new JPanel();



	/**
	 * Create the dialog.
	 */
	public PopupEcurie(Ecurie e) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelEnTete = new JPanel();
		contentPanel.add(panelEnTete, BorderLayout.NORTH);
		
		JLabel photo = new JLabel("");
		panelEnTete.add(photo);
		
		JLabel lblNom = new JLabel(e.getNom());
		lblNom.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		panelEnTete.add(lblNom);
		
		JPanel panelCorp = new JPanel();
		contentPanel.add(panelCorp);
		
		JPanel panelListeEquipe = new JPanel();
		for (Equipe eq : e.getListeEquipe()) {
			JLabel lblEquipe = new JLabel(eq.getNom());
			panelListeEquipe.add(lblEquipe);
		}
		panelCorp.add(panelListeEquipe);
		panelListeEquipe.setLayout(new GridLayout(0, 1, 0, 0));
	}

}

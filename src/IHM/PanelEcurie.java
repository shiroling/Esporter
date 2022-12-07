package IHM;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import DBlink.Ecurie;

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
		
		JLabel lblNewLabel_1 = new JLabel(ec.getNomManager());
		lblNom.setHorizontalAlignment(SwingConstants.LEFT);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		add(panel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton);

	}

}

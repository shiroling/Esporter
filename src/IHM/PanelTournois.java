package IHM;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import DBlink.Equipe;
import DBlink.Tournoi;

public class PanelTournois extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelTournois(Tournoi t) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNom = new JLabel(t.getNom());
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNom.setName("Tournoi");
		panel.add(lblNom);
		
		JLabel lblDates = new JLabel(t.getDateDebut()+" - "+t.getDateFin());
		lblDates.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDates.setName("Date");
		panel.add(lblDates);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JButton btnMatch = new JButton("Voir Les Matchs");
		btnMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnMatch);
		
		JPanel main = new JPanel();
		add(main, BorderLayout.CENTER);
		main.setLayout(new GridLayout(16, 1, 0, 0));
		for (Equipe eq : t.getListEquipesParticipantes()) {
			JLabel lblequipe = new JLabel(eq.toString());
			lblequipe.setName("Equipe");
			lblequipe.setHorizontalAlignment(SwingConstants.CENTER);
			lblequipe.setFont(new Font("Tahoma", Font.PLAIN, 16));
			main.add(lblequipe);
		}

	}

}

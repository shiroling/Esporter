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

import Controleur.ControleurAccueil;
import DBlink.Equipe;
import DBlink.Tournoi;

public class PanelTournois extends JPanel {
	private static Tournoi tournoi;
	/**
	 * Create the panel.
	 */
	public PanelTournois(Tournoi t) {
		tournoi = t;
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
		
		JPanel panelBtn = new JPanel();
		add(panelBtn, BorderLayout.SOUTH);
		
		JButton btnMatch = new JButton("Voir Les Matchs");
		btnMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelBtn.add(btnMatch);
		
		JButton btnInscription = new JButton("S'inscrire");
		btnInscription.setName("btnInscription");
		btnInscription.addActionListener(AccueilV2.getControleur());
		panelBtn.add(btnInscription);
		
		JPanel main = new JPanel();
		add(main, BorderLayout.CENTER);
		main.setLayout(new GridLayout(16, 1, 0, 0));
		for (Equipe eq : t.getListEquipesParticipantes()) {
			JLabel lblequipe = new JLabel(eq.toString());
			lblequipe.setName("Equipe");
			lblequipe.setHorizontalAlignment(SwingConstants.CENTER);
			lblequipe.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblequipe.addMouseListener(AccueilV2.getMa());
			main.add(lblequipe);
		}

	}
	public static Tournoi getTournoi() {
		return tournoi;
	}
	

}

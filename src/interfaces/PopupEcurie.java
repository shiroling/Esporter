package interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import contoleur_bd.Ecurie;
import contoleur_bd.Equipe;

public class PopupEcurie extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public PopupEcurie(Ecurie e) {
		
		setTitle("Ecurie : "+e.getNom());
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JPanel panelEnTete = new JPanel();
		contentPanel.add(panelEnTete, BorderLayout.NORTH);
				panelEnTete.setLayout(new GridLayout(2, 0, 0, 0));
		
				JLabel lblNom = new JLabel(e.getNom());
				lblNom.setHorizontalAlignment(SwingConstants.CENTER);
				lblNom.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
				panelEnTete.add(lblNom);
		
		JLabel lblNewLabel = new JLabel("Manager : "+ e.getNomManager());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelEnTete.add(lblNewLabel);

		JPanel panelCorp = new JPanel();
		contentPanel.add(panelCorp);
		
		JPanel panelListeEquipe = new JPanel();
		JLabel lblEquipe = new JLabel();
		JPanel panelEquipe = new JPanel();
		if (e.getListeEquipe().size() == 0) {
			panelEquipe = new JPanel();
			lblEquipe = new JLabel("Cette écurie n'a pas encore enregistré d'équipe.");
			lblEquipe.setHorizontalAlignment(SwingConstants.LEFT);
			panelEquipe.add(lblEquipe);
			panelListeEquipe.add(panelEquipe);
		} else {
			for (Equipe eq : e.getListeEquipe()) {
				panelEquipe = new JPanel();
				JPanel panelNomEquipe = new JPanel();
				lblEquipe = new JLabel(eq.getNom());
				lblEquipe.setName("Equipe");
				lblEquipe.addMouseListener(Accueil.getMa());
				lblEquipe.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblEquipe.setHorizontalAlignment(SwingConstants.LEFT);
				panelNomEquipe.add(lblEquipe);
				panelEquipe.add(panelNomEquipe);
				panelListeEquipe.add(panelEquipe);
				FlowLayout flowLayout = (FlowLayout) panelEquipe.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
			}
		}
		panelCorp.setLayout(new BorderLayout(0, 0));
		panelListeEquipe.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lbltitreequipe = new JLabel("Equipes : ");
		lbltitreequipe.setHorizontalAlignment(SwingConstants.LEFT);
		panelCorp.add(lbltitreequipe, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		panelCorp.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(panelListeEquipe);
		
		
		setVisible(true);
		this.setMinimumSize(new Dimension(contentPanel.getWidth(),
				(e.getListeEquipe().size() + 1) * panelEquipe.getHeight() + panelEnTete.getHeight()));
	}

}

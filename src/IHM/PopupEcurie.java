package IHM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DBlink.Ecurie;
import DBlink.Equipe;
import DBlink.Joueur;

public class PopupEcurie extends JDialog {

	private final JPanel contentPanel = new JPanel();



	/**
	 * Create the dialog.
	 */
	public PopupEcurie(Ecurie e) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
		JLabel lblEquipe=new JLabel();
		JPanel panelEquipe = new JPanel();
		for (Equipe eq : e.getListeEquipe()) {
			panelEquipe = new JPanel();
			JPanel panelNomEquipe = new JPanel();
			lblEquipe = new JLabel(eq.getNom());
			lblEquipe.setName("Equipe");
			lblEquipe.addMouseListener(AccueilV2.getMa());
			lblEquipe.setFont(new Font("Tahoma", Font.BOLD, 20));
			panelNomEquipe.add(lblEquipe);
			panelNomEquipe.add(new JLabel(":"));
			panelEquipe.add(panelNomEquipe);
			JPanel panelJoueurs = new JPanel();
			
			for (Joueur joueur : eq.getListJoueur()) {
				JLabel lbljoueur = new JLabel(joueur.getPseudo());
				lbljoueur.setName("Joueur");
				lbljoueur.setHorizontalAlignment(SwingConstants.LEFT);
				lbljoueur.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lbljoueur.addMouseListener(AccueilV2.getMa());
				panelJoueurs.add(lbljoueur);
			}
			panelEquipe.add(panelJoueurs);
			panelEquipe.setLayout(new GridLayout(0, 1, 0, 0));
			panelListeEquipe.add(panelEquipe);
		}
		panelCorp.add(panelListeEquipe);
		panelListeEquipe.setLayout(new GridLayout(0, 1, 0, 0));
		setVisible(true);
		this.setMinimumSize(new Dimension(contentPanel.getWidth()*2,(e.getListeEquipe().size()+1)*panelEquipe.getHeight()+panelEnTete.getHeight()));		
	}

}

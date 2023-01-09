package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import DBlink.Ecurie;
import DBlink.Equipe;
import DBlink.Tournoi;
import javax.swing.SwingConstants;

public class PopupSelectionEquipePourInscription extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Ecurie ecurie;
	private JScrollPane scrollPane;
	private Equipe equipeSelectionnee;
	private Tournoi tournoi;
	private JPanel panelListEquipes;
	private JLabel lblAucuneEquipeSelectionnee;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PopupSelectionEquipePourInscription dialog = new PopupSelectionEquipePourInscription(new Ecurie(2), new Tournoi(172));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PopupSelectionEquipePourInscription(Ecurie ecurie, Tournoi tournoi) {
		this.ecurie = ecurie;
		this.tournoi = tournoi;
		
		List<Equipe> equipes = this.ecurie.getListeEquipe().stream().filter(e -> e.getJeu().getId() == tournoi.getIdJeu()).filter(e -> tournoi.isInscrit(e) == false).toList();
		setBounds(100, 100, 450, 300);
		setTitle("Inscrire Equipe");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(10, 10));
		{
			JPanel panelTitre = new JPanel();
			contentPanel.add(panelTitre, BorderLayout.NORTH);
			{
				JLabel lblTitre = new JLabel("Mes Equipes");
				panelTitre.add(lblTitre);
			}
		}
		{
			scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
		}
		{
			panelListEquipes = new JPanel();
			scrollPane.setViewportView(panelListEquipes);
			panelListEquipes.setLayout(new GridLayout(equipes.size(), 1, 5, 5));
			System.out.println(equipes.size());
			for(Equipe e : equipes) {
				PanelEquipePourInscriptionTournoi panelEquipe = new PanelEquipePourInscriptionTournoi(e, this);
				panelListEquipes.add(panelEquipe);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(1, 2, 0, 0));
			
			JPanel panelLblAucuneEquipeSelectionee = new JPanel();
			FlowLayout flowLayout_1 = (FlowLayout) panelLblAucuneEquipeSelectionee.getLayout();
			flowLayout_1.setVgap(10);
			flowLayout_1.setAlignment(FlowLayout.LEFT);
			buttonPane.add(panelLblAucuneEquipeSelectionee);
			{
				lblAucuneEquipeSelectionnee = new JLabel("* Aucune équipe selelectionée");
				lblAucuneEquipeSelectionnee.setForeground(Color.RED);
				lblAucuneEquipeSelectionnee.setVisible(false);
				panelLblAucuneEquipeSelectionee.add(lblAucuneEquipeSelectionnee);
			}
			
			
			JPanel panelBtn = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelBtn.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			buttonPane.add(panelBtn);
			
			{
				JButton okButton = new JButton("Inscrire");
				okButton.setActionCommand("OK");
				okButton.setName("Inscrire");
				panelBtn.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Annuler");
				cancelButton.setActionCommand("Cancel");
				panelBtn.add(cancelButton);
			}
			
		}
	}
	
	public Equipe getEquipeSelectionee() {
		return this.equipeSelectionnee;
	}
	
	public void setEquipeSelectionee(Equipe equipe) {
		for(Component p : panelListEquipes.getComponents()) {
			PanelEquipePourInscriptionTournoi panel = (PanelEquipePourInscriptionTournoi) p;
			if(panel.getEquipe().equals(equipeSelectionnee)) {
				panel.setBorder(new EmptyBorder(0,0,0,0));
			}
			if(panel.getEquipe().equals(equipe)) {
				panel.setBorderBleu();
			}
		}
		this.equipeSelectionnee = equipe;
	}
	
	public Ecurie getEcurie() {
		return this.ecurie;
	}
	
	public Tournoi getTournoi() {
		return this.tournoi;
	}
	
	public JLabel getLblAucuneEquipeSelectionee() {
		return this.lblAucuneEquipeSelectionnee;
	}
}

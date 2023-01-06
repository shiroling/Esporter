package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Controleur.HoverPanelEquipePourInscription;
import DBlink.Ecurie;
import DBlink.Equipe;

public class PopupSelectionEquipePourInscription extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Ecurie ecurie;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PopupSelectionEquipePourInscription dialog = new PopupSelectionEquipePourInscription(new Ecurie(2));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PopupSelectionEquipePourInscription(Ecurie ecurie) {
		this.ecurie = ecurie;
		
		List<Equipe> equipes = this.ecurie.getListeEquipe();
		setBounds(100, 100, 450, 300);
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
			JPanel panelListEquipes = new JPanel();
			scrollPane.setViewportView(panelListEquipes);
			panelListEquipes.setLayout(new GridLayout(equipes.size(), 1, 5, 5));
			System.out.println(equipes.size());
			for(Equipe e : equipes) {
				panelListEquipes.add(new PanelEquipePourInscriptionTournoi(e));
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}

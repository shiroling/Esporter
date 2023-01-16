package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import DBlink.BDSelect;
import DBlink.Filters;
import DBlink.Rencontre;
import DBlink.Tournoi;
import java.awt.GridLayout;

public class PopupVoirRencontreTournoi extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Tournoi tournoi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PopupVoirRencontreTournoi dialog = new PopupVoirRencontreTournoi(new Tournoi(262));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PopupVoirRencontreTournoi(Tournoi tournoi) {
		this.tournoi = tournoi;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelTitre = new JPanel();
			contentPanel.add(panelTitre, BorderLayout.NORTH);
			{
				JLabel lblTitre = new JLabel("" + this.tournoi.getNom() + " (Matchs)");
				panelTitre.add(lblTitre);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				JPanel panelCartes = new JPanel();
				scrollPane.setViewportView(panelCartes);
				panelCartes.setLayout(new GridLayout(0, 1, 12, 12));
				
				List<Rencontre> rencontres = BDSelect.getListeRencontre();
				rencontres = Filters.filtrer(rencontres, Filters.estRencontreDansTournoi, this.tournoi.getId());
				
				CarteRencontre ct;
				for (Rencontre rencontre : rencontres) {
					ct = new CarteRencontre(rencontre);
					panelCartes.add(ct);
				}
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
		}
	}

}

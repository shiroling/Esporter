package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FormEnregistrerEquipe extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNomEquipe;
	private JTextField textFieldNomJeu;
	private JTextField textFieldNomEcurie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormEnregistrerEquipe dialog = new FormEnregistrerEquipe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormEnregistrerEquipe() {
		setTitle("Nouvelle equipe");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelLbl = new JPanel();
			contentPanel.add(panelLbl, BorderLayout.WEST);
			panelLbl.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JPanel panelLblNomEquipe = new JPanel();
				panelLbl.add(panelLblNomEquipe);
				{
					JLabel lblNomEquipe = new JLabel("Nom de l'equipe");
					panelLblNomEquipe.add(lblNomEquipe);
				}
			}
			{
				JPanel panelLblNomJeu = new JPanel();
				panelLbl.add(panelLblNomJeu);
				{
					JLabel lblNomJeu = new JLabel("Nom du jeu de l'equipe");
					panelLblNomJeu.add(lblNomJeu);
				}
			}
			{
				JPanel panelLblNomEcurie = new JPanel();
				panelLbl.add(panelLblNomEcurie);
				{
					JLabel lblNomEcurie = new JLabel("Nom de l'equipe");
					panelLblNomEcurie.add(lblNomEcurie);
				}
			}
		}
		{
			JPanel panelChampsSaisie = new JPanel();
			contentPanel.add(panelChampsSaisie, BorderLayout.CENTER);
			panelChampsSaisie.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JPanel panelTextFieldNomEquipe = new JPanel();
				panelChampsSaisie.add(panelTextFieldNomEquipe);
				panelTextFieldNomEquipe.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));
				{
					textFieldNomEquipe = new JTextField();
					panelTextFieldNomEquipe.add(textFieldNomEquipe);
					textFieldNomEquipe.setColumns(10);
				}
			}
			{
				JPanel panelTextFieldNomJeu = new JPanel();
				panelChampsSaisie.add(panelTextFieldNomJeu);
				panelTextFieldNomJeu.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));
				{
					textFieldNomJeu = new JTextField();
					textFieldNomJeu.setColumns(10);
					panelTextFieldNomJeu.add(textFieldNomJeu);
				}
			}
			{
				JPanel panelTextFieldNomEcurie = new JPanel();
				panelChampsSaisie.add(panelTextFieldNomEcurie);
				panelTextFieldNomEcurie.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));
				{
					textFieldNomEcurie = new JTextField();
					textFieldNomEcurie.setColumns(10);
					panelTextFieldNomEcurie.add(textFieldNomEcurie);
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
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}

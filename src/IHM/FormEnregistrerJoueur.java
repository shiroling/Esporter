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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FormEnregistrerJoueur extends JDialog {
	private JTextField textFieldNomJoueur;
	private JTextField textFieldPrenomJoueur;
	private JTextField textFieldNomEquipe;
	private JTextField textFieldPseudo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormEnregistrerJoueur dialog = new FormEnregistrerJoueur();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormEnregistrerJoueur() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
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
		{
			JPanel contentPanel = new JPanel();
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panelLbl = new JPanel();
				contentPanel.add(panelLbl, BorderLayout.WEST);
				panelLbl.setLayout(new GridLayout(0, 1, 0, 0));
				{
					JPanel panelLblNomJoueur = new JPanel();
					panelLbl.add(panelLblNomJoueur);
					{
						JLabel lblNomJoueur = new JLabel("Nom du joueur");
						panelLblNomJoueur.add(lblNomJoueur);
					}
				}
				{
					JPanel panelLblNomJeu = new JPanel();
					panelLbl.add(panelLblNomJeu);
					{
						JLabel lblPrenomJoueur = new JLabel("Prenom joueur");
						panelLblNomJeu.add(lblPrenomJoueur);
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
				{
					JPanel panelLblPseudo = new JPanel();
					panelLbl.add(panelLblPseudo);
					{
						JLabel lblPseudoJoueur = new JLabel("Pseudo joueur");
						panelLblPseudo.add(lblPseudoJoueur);
					}
				}
				{
					JPanel panelLblDateNaissance = new JPanel();
					panelLbl.add(panelLblDateNaissance);
					{
						JLabel lblDateNaissance = new JLabel("Date naissance");
						panelLblDateNaissance.add(lblDateNaissance);
					}
				}
			}
			{
				JPanel panelChampsSaisie = new JPanel();
				contentPanel.add(panelChampsSaisie);
				panelChampsSaisie.setLayout(new GridLayout(0, 1, 0, 0));
				{
					JPanel panelTextFieldNomJoueur = new JPanel();
					panelChampsSaisie.add(panelTextFieldNomJoueur);
					panelTextFieldNomJoueur.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));
					{
						textFieldNomJoueur = new JTextField();
						textFieldNomJoueur.setColumns(10);
						panelTextFieldNomJoueur.add(textFieldNomJoueur);
					}
				}
				{
					JPanel panelTextFieldPrenomJoueur = new JPanel();
					panelChampsSaisie.add(panelTextFieldPrenomJoueur);
					panelTextFieldPrenomJoueur.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));
					{
						textFieldPrenomJoueur = new JTextField();
						textFieldPrenomJoueur.setColumns(10);
						panelTextFieldPrenomJoueur.add(textFieldPrenomJoueur);
					}
				}
				{
					JPanel panelTextFieldNomEcurie = new JPanel();
					panelChampsSaisie.add(panelTextFieldNomEcurie);
					panelTextFieldNomEcurie.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));
					{
						textFieldNomEquipe = new JTextField();
						textFieldNomEquipe.setColumns(10);
						panelTextFieldNomEcurie.add(textFieldNomEquipe);
					}
				}
				{
					JPanel panelTextFieldPseudo = new JPanel();
					panelChampsSaisie.add(panelTextFieldPseudo);
					panelTextFieldPseudo.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));
					{
						textFieldPseudo = new JTextField();
						textFieldPseudo.setColumns(10);
						panelTextFieldPseudo.add(textFieldPseudo);
					}
				}
				{
					JPanel panelTextFieldDateNaissance = new JPanel();
					panelChampsSaisie.add(panelTextFieldDateNaissance);
					panelTextFieldDateNaissance.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));
					{
						JComboBox comboJourNaissance = new JComboBox();
						comboJourNaissance.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
						comboJourNaissance.setName("combo");
						panelTextFieldDateNaissance.add(comboJourNaissance);
					}
					{
						JComboBox comboMoiNaissance = new JComboBox();
						comboMoiNaissance.setModel(new DefaultComboBoxModel(new String[] {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"}));
						comboMoiNaissance.setName("combo");
						panelTextFieldDateNaissance.add(comboMoiNaissance);
					}
					{
						JComboBox comboAnneeNaissance = new JComboBox();
						comboAnneeNaissance.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
						comboAnneeNaissance.setName("combo");
						panelTextFieldDateNaissance.add(comboAnneeNaissance);
					}
				}
			}
		}
	}

}

package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controleur.ControleurFormEnrengistrerEquipe;
import Controleur.ControleurFormEnrengistrerJoueur;
import DBlink.Equipe;

public class FormEnregistrerJoueur extends JDialog {
	private JTextField textFieldNomJoueur;
	private JTextField textFieldPrenomJoueur;
	private JTextField textFieldPseudo;
	private JLabel lblNomJoueur;
	private JLabel lblPrenomJoueur;
	private JLabel lblPseudoJoueur;
	private JComboBox comboJourNaissance;
	private JComboBox comboMoiNaissance;
	private JComboBox comboAnneeNaissance;
	private JLabel lblDateNaissance;
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			FormEnregistrerJoueur dialog = new FormEnregistrerJoueur(new Equipe(1));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public JTextField getTextFieldNomJoueur() {
		return textFieldNomJoueur;
	}

	public JTextField getTextFieldPrenomJoueur() {
		return textFieldPrenomJoueur;
	}

	public JTextField getTextFieldPseudo() {
		return textFieldPseudo;
	}

	public JLabel getLblNomJoueur() {
		return lblNomJoueur;
	}

	public JLabel getLblPrenomJoueur() {
		return lblPrenomJoueur;
	}

	public JLabel getLblPseudoJoueur() {
		return lblPseudoJoueur;
	}

	public JComboBox getComboJourNaissance() {
		return comboJourNaissance;
	}

	public JComboBox getComboMoiNaissance() {
		return comboMoiNaissance;
	}

	public JComboBox getComboAnneeNaissance() {
		return comboAnneeNaissance;
	}
	
	public JLabel getLblDateNaissance() {
		return lblDateNaissance;
	}

	/**
	 * Create the dialog.
	 */
	public FormEnregistrerJoueur(ControleurFormEnrengistrerEquipe controleurFormEquipe) {
		setModal(true);
		setLocation(300,300);
		
		ControleurFormEnrengistrerJoueur controleur = new ControleurFormEnrengistrerJoueur(this, controleurFormEquipe);
		
		setTitle("Nouveau Joueur");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Créer");
				okButton.setName("Creer");
				okButton.addActionListener(controleur);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Annuler");
				cancelButton.setName("Annuler");
				cancelButton.addActionListener(controleur);
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
						lblNomJoueur = new JLabel("Nom du joueur");
						panelLblNomJoueur.add(lblNomJoueur);
					}
				}
				{
					JPanel panelLblNomJeu = new JPanel();
					panelLbl.add(panelLblNomJeu);
					{
						lblPrenomJoueur = new JLabel("Prenom joueur");
						panelLblNomJeu.add(lblPrenomJoueur);
					}
				}
				{
					JPanel panelLblPseudo = new JPanel();
					panelLbl.add(panelLblPseudo);
					{
						lblPseudoJoueur = new JLabel("Pseudo joueur");
						panelLblPseudo.add(lblPseudoJoueur);
					}
				}
				{
					JPanel panelLblDateNaissance = new JPanel();
					panelLbl.add(panelLblDateNaissance);
					{
						lblDateNaissance = new JLabel("Date naissance");
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
						comboJourNaissance = new JComboBox();
						comboJourNaissance.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
						comboJourNaissance.setName("combo");
						panelTextFieldDateNaissance.add(comboJourNaissance);
					}
					{
						comboMoiNaissance = new JComboBox();
						comboMoiNaissance.setModel(new DefaultComboBoxModel(new String[] {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"}));
						comboMoiNaissance.setName("combo");
						panelTextFieldDateNaissance.add(comboMoiNaissance);
					}
					{
						comboAnneeNaissance = new JComboBox();
						
						List<Integer> annees = new ArrayList<>();
						for(int i = 0; i + 1900 < 2024 ; i++) {
							annees.add(i + 1900);
						}
						
						String[] anneesToString = annees.stream().map(Object::toString).toArray(String[]::new);
						
						comboAnneeNaissance.setModel(new DefaultComboBoxModel(anneesToString));
						comboAnneeNaissance.setName("combo");
						panelTextFieldDateNaissance.add(comboAnneeNaissance);
					}
				}
			}
		}
	}

}

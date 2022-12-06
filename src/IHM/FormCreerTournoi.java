package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controleur.ControleurFromCreerTournoi;
import DBlink.Jeu;
import base.Mois;

public class FormCreerTournoi extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPanel panelJeuxAjoutes;
	private JComboBox comboPortee;
	private JComboBox comboJourDebutTournoi;
	private JComboBox comboMoiDebutTournoi;
	private JComboBox comboAnneeDebutTournoi;
	private JComboBox comboJourFinTournoi;
	private JComboBox comboMoiFinTournoi;
	private JComboBox comboAnneeFinTournoi;
	private JComboBox comboJourFinInscription;
	private JComboBox comboMoiFinInscription;
	private JComboBox comboAnneeFinInscription;
	private JComboBox comboJeux;
	private JButton btnAjouterJeu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormCreerTournoi dialog = new FormCreerTournoi();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public JPanel getPanelJeuxAjoutes() {
		return this.panelJeuxAjoutes;
	}
	
	public JButton getBtnAjouterJeux() {
		return this.btnAjouterJeu;
	}
	
	public JComboBox getComboJeux() {
		return this.comboJeux;
	}
	
	public String getSelectedValueComboAnneeDebutTournoi() {
		return this.comboAnneeDebutTournoi.getSelectedItem().toString();
	}
	
	public String getSelectedValueComboAnneeFinInscription() {
		return this.comboAnneeFinInscription.getSelectedItem().toString();
	}

	public String getSelectedValueComboFinTournoi() {
		return this.comboAnneeFinTournoi.getSelectedItem().toString();
	}
	
	public String getSelectedValueComboJourDebutTournoi() {
		return this.comboJourDebutTournoi.getSelectedItem().toString();
	}
	
	public String getSelectedValueComboJourFinInscription() {
		return this.comboJourFinInscription.getSelectedItem().toString();
	}
	
	public String getSelectedValueComboJourFinTournoi() {
		return this.comboJourFinTournoi.getSelectedItem().toString();
	}
	
	public String getSelectedValueComboMoiDebutTournoi() {
		return this.comboMoiDebutTournoi.getSelectedItem().toString();
	}
	
	public String getSelectedValueComboMoiFinInscription() {
		return this.comboMoiFinInscription.getSelectedItem().toString();
	}
	
	public String getSelectedValueComboMoiFinTournoi() {
		return this.comboMoiFinTournoi.getSelectedItem().toString();
	}

	/**
	 * Create the dialog.
	 */
	public FormCreerTournoi() {
		ControleurFromCreerTournoi c = new ControleurFromCreerTournoi(this);
		setBounds(100, 100, 364, 430);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel PanelLbl = new JPanel();
			contentPanel.add(PanelLbl, BorderLayout.WEST);
			PanelLbl.setLayout(new GridLayout(6, 1, 0, 0));
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				PanelLbl.add(panel);
				{
					JLabel lblNom = new JLabel("Nom ");
					panel.add(lblNom);
				}
			}
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				PanelLbl.add(panel);
				{
					JLabel lblPortee = new JLabel("Portée");
					panel.add(lblPortee);
				}
			}
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				PanelLbl.add(panel);
				{
					JLabel lblDateDebutTournoi = new JLabel("Date Début Tournoi");
					panel.add(lblDateDebutTournoi);
				}
			}
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				PanelLbl.add(panel);
				{
					JLabel lblDateFinTournois = new JLabel("Date Fin Tournois");
					panel.add(lblDateFinTournois);
				}
			}
			{
				JPanel panel = new JPanel();
				PanelLbl.add(panel);
				{
					JLabel lblDateFinInscription = new JLabel("Date Fin Inscription");
					panel.add(lblDateFinInscription);
				}
			}
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				PanelLbl.add(panel);
				{
					btnAjouterJeu = new JButton("Ajouter Jeu");
					btnAjouterJeu.addActionListener(c);
					btnAjouterJeu.setName("btnAjouterJeu");
					panel.add(btnAjouterJeu);
				}
			}
		}
		{
			JPanel PanelChampsSaisie = new JPanel();
			contentPanel.add(PanelChampsSaisie, BorderLayout.CENTER);
			PanelChampsSaisie.setLayout(new GridLayout(6, 1, 0, 0));
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				PanelChampsSaisie.add(panel);
				{
					textField = new JTextField();
					panel.add(textField);
					textField.setColumns(15);
				}
			}
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				PanelChampsSaisie.add(panel);
				{
					comboPortee = new JComboBox();
					comboPortee.setModel(new DefaultComboBoxModel(new String[] {"Local", "National", "International"}));
					panel.add(comboPortee);
				}
			}
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				PanelChampsSaisie.add(panel);
				{
					comboJourDebutTournoi = new JComboBox();
					comboJourDebutTournoi.addActionListener(c);
					comboJourDebutTournoi.setName("combo");
					comboJourDebutTournoi.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
					panel.add(comboJourDebutTournoi);
				}
				{
					comboMoiDebutTournoi = new JComboBox();
					comboMoiDebutTournoi.addActionListener(c);
					comboMoiDebutTournoi.setName("combo");
					comboMoiDebutTournoi.setModel(new DefaultComboBoxModel(Mois.toStrings()));
					panel.add(comboMoiDebutTournoi);
				}
				{
					comboAnneeDebutTournoi = new JComboBox();
					comboAnneeDebutTournoi.addActionListener(c);
					comboAnneeDebutTournoi.setName("combo");
					comboAnneeDebutTournoi.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
					panel.add(comboAnneeDebutTournoi);
				}
			}
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				PanelChampsSaisie.add(panel);
				{
					comboJourFinTournoi = new JComboBox();
					comboJourFinTournoi.addActionListener(c);
					comboJourFinTournoi.setName("combo");
					comboJourFinTournoi.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
					panel.add(comboJourFinTournoi);
				}
				{
					comboMoiFinTournoi = new JComboBox();
					comboMoiFinTournoi.addActionListener(c);
					comboMoiFinTournoi.setName("combo");
					comboMoiFinTournoi.setModel(new DefaultComboBoxModel(Mois.toStrings()));
					panel.add(comboMoiFinTournoi);
				}
				{
					comboAnneeFinTournoi = new JComboBox();
					comboAnneeFinTournoi.addActionListener(c);
					comboAnneeFinTournoi.setName("combo");
					comboAnneeFinTournoi.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
					panel.add(comboAnneeFinTournoi);
				}
			}
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				PanelChampsSaisie.add(panel);
				{
					comboJourFinInscription = new JComboBox();
					comboJourFinInscription.addActionListener(c);
					comboJourFinInscription.setName("combo");
					comboJourFinInscription.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
					panel.add(comboJourFinInscription);
				}
				{
					comboMoiFinInscription = new JComboBox();
					comboMoiFinInscription.addActionListener(c);
					comboMoiFinInscription.setName("combo");
					comboMoiFinInscription.setModel(new DefaultComboBoxModel(Mois.toStrings()));
					panel.add(comboMoiFinInscription);
				}
				{
					comboAnneeFinInscription = new JComboBox();
					comboAnneeFinInscription.addActionListener(c);
					comboAnneeFinInscription.setName("combo");
					comboAnneeFinInscription.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
					panel.add(comboAnneeFinInscription);
				}
			}
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				PanelChampsSaisie.add(panel);
				{
					comboJeux = new JComboBox();
					comboJeux.setModel(new DefaultComboBoxModel(Jeu.toStrings()));
					panel.add(comboJeux);
				}
			}
		}
		{
			JPanel panelJeux = new JPanel();
			contentPanel.add(panelJeux, BorderLayout.SOUTH);
			panelJeux.setLayout(new BorderLayout(0, 0));
			{
				JLabel lblJeuxAjoutes = new JLabel("Jeux Ajoutés :"); 
				panelJeux.add(lblJeuxAjoutes, BorderLayout.NORTH);
			}
			{
				panelJeuxAjoutes = new JPanel();
				panelJeux.add(panelJeuxAjoutes, BorderLayout.CENTER);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnInserer = new JButton("Créer");
				btnInserer.setName("btnInserer");
				btnInserer.setActionCommand("OK");
				buttonPane.add(btnInserer);
				getRootPane().setDefaultButton(btnInserer);
			}
			{
				JButton cancelButton = new JButton("Annuler");
				cancelButton.setActionCommand("Cancel");
				cancelButton.setName("btnCancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

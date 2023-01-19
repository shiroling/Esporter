package interfaces;

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

import commun.Mois;
import contoleur_bd.Jeu;
import controleur_ihm.ControleurFormCreerTournoi;

import java.awt.Color;

public class FormCreerTournoi extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Accueil vueAccueil;
	private JTextField textFieldNom;
	private JLabel lblNom;
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
	private JLabel lblDateDebutTournoi;
	private JLabel lblDateFinTournoi;
	private JLabel lblDateFinInscription;
	private JComboBox comboJeux;
	private JButton btnAjouterJeu;
	private JLabel lblJeuxAjoutes;
	private int idGerant;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			FormCreerTournoi dialog = new FormCreerTournoi(2);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public int getIdGerant() {
		return this.idGerant;
	}
	
	public Accueil getVueAccueil() {
		return this.vueAccueil;
	}
	
	public JTextField getTextFieldNom() {
		return this.textFieldNom;
	}
	
	public JLabel getLabelNom() {
		return this.lblNom;
	}
	
	public JPanel getPanelJeuxAjoutes() {
		return this.panelJeuxAjoutes;
	}
	
	public JButton getBtnAjouterJeux() {
		return this.btnAjouterJeu;
	}
	
	public JLabel getLabelJeuxAjoutes() {
		return this.lblJeuxAjoutes;
	}
	
	public JLabel getLabelDateDebutTournoi() {
		return this.lblDateDebutTournoi;
	}
	
	public JLabel getLabelDateFinTournoi() {
		return this.lblDateFinTournoi;
	}
	
	public JLabel getLabelDateFinInscription() {
		return this.lblDateFinInscription;
	}
	
	public JComboBox getComboJeux() {
		return this.comboJeux;
	}
	
	public JComboBox getComboPortee() {
		return this.comboPortee;
	}
	
	public String getSelectedValueComboAnneeDebutTournoi() {
		return this.comboAnneeDebutTournoi.getSelectedItem().toString();
	}
	
	public String getSelectedValueComboAnneeFinInscription() {
		return this.comboAnneeFinInscription.getSelectedItem().toString();
	}

	public String getSelectedValueComboAnneeFinTournoi() {
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
	public FormCreerTournoi(int idGerant, Accueil vueAccueil) {
		this.idGerant = idGerant;
		this.vueAccueil = vueAccueil;
		ControleurFormCreerTournoi c = new ControleurFormCreerTournoi(this, vueAccueil.getControleur());
		setTitle("Nouveau tournoi");
		setBounds(100, 100, 379, 438);
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
					lblNom = new JLabel("Nom ");
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
					lblDateDebutTournoi = new JLabel("Date Début Tournoi");
					panel.add(lblDateDebutTournoi);
				}
			}
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				PanelLbl.add(panel);
				{
					lblDateFinTournoi = new JLabel("Date Fin Tournoi");
					panel.add(lblDateFinTournoi);
				}
			}
			{
				JPanel panel = new JPanel();
				PanelLbl.add(panel);
				{
					lblDateFinInscription = new JLabel("Date Fin Inscription");
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
					textFieldNom = new JTextField();
					textFieldNom.setText("");
					panel.add(textFieldNom);
					textFieldNom.setColumns(15);
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
					comboJourDebutTournoi.setName("combo");
					comboJourDebutTournoi.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
					panel.add(comboJourDebutTournoi);
				}
				{
					comboMoiDebutTournoi = new JComboBox();
					comboMoiDebutTournoi.setName("combo");
					comboMoiDebutTournoi.setModel(new DefaultComboBoxModel(Mois.toStrings()));
					panel.add(comboMoiDebutTournoi);
				}
				{
					comboAnneeDebutTournoi = new JComboBox();
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
					comboJourFinTournoi.setName("combo");
					comboJourFinTournoi.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
					panel.add(comboJourFinTournoi);
				}
				{
					comboMoiFinTournoi = new JComboBox();
					comboMoiFinTournoi.setName("combo");
					comboMoiFinTournoi.setModel(new DefaultComboBoxModel(Mois.toStrings()));
					panel.add(comboMoiFinTournoi);
				}
				{
					comboAnneeFinTournoi = new JComboBox();
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
					comboJourFinInscription.setName("combo");
					comboJourFinInscription.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
					panel.add(comboJourFinInscription);
				}
				{
					comboMoiFinInscription = new JComboBox();
					comboMoiFinInscription.setName("combo");
					comboMoiFinInscription.setModel(new DefaultComboBoxModel(Mois.toStrings()));
					panel.add(comboMoiFinInscription);
				}
				{
					comboAnneeFinInscription = new JComboBox();
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
				lblJeuxAjoutes = new JLabel("Jeux Ajoutés :"); 
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
				btnInserer.addActionListener(c);
				btnInserer.setName("btnInserer");
				btnInserer.setActionCommand("OK");
				buttonPane.add(btnInserer);
				getRootPane().setDefaultButton(btnInserer);
			}
			{
				JButton cancelButton = new JButton("Annuler");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(c);
				cancelButton.setName("btnCancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

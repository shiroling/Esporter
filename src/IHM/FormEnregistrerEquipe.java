package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controleur.ControleurFormEnrengistrerEquipe;
import DBlink.Ecurie;
import DBlink.Jeu;
import java.awt.Color;

public class FormEnregistrerEquipe extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Ecurie ecurie;
	private JTextField textFieldNomEquipe;
	private JComboBox comboJeux;
	private JLabel lblNomEquipe;
	private JLabel lblJoueur1;
	private JLabel lblJoueur2;
	private JLabel lblJoueur3;
	private JLabel lblJoueur4;
	private JLabel lblJoueurNonAjoutes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormEnregistrerEquipe dialog = new FormEnregistrerEquipe(new Ecurie(1));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormEnregistrerEquipe(Ecurie ecurie) {
		this.ecurie = ecurie;
		
		ControleurFormEnrengistrerEquipe controleur = new ControleurFormEnrengistrerEquipe(this);
		
		setTitle("Nouvelle equipe");
		setBounds(100, 100, 484, 288);
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
				FlowLayout flowLayout = (FlowLayout) panelLblNomEquipe.getLayout();
				flowLayout.setVgap(25);
				flowLayout.setAlignment(FlowLayout.LEFT);
				panelLbl.add(panelLblNomEquipe);
				{
					lblNomEquipe = new JLabel("Nom");
					panelLblNomEquipe.add(lblNomEquipe);
				}
			}
			{
				JPanel panelLblNomJeu = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panelLblNomJeu.getLayout();
				flowLayout.setVgap(18);
				flowLayout.setAlignment(FlowLayout.LEFT);
				panelLbl.add(panelLblNomJeu);
				{
					JLabel lblNomJeu = new JLabel("Jeu de l'equipe");
					panelLblNomJeu.add(lblNomJeu);
				}
			}
			{
				JPanel panelLblAjouterJoueurs = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panelLblAjouterJoueurs.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				flowLayout.setVgap(18);
				panelLbl.add(panelLblAjouterJoueurs);
				{
					lblJoueurNonAjoutes = new JLabel("Joueurs manquant");
					lblJoueurNonAjoutes.setForeground(new Color(255, 0, 0));
					lblJoueurNonAjoutes.setVisible(false);
					panelLblAjouterJoueurs.add(lblJoueurNonAjoutes);
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
				panelTextFieldNomEquipe.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 25));
				{
					textFieldNomEquipe = new JTextField();
					panelTextFieldNomEquipe.add(textFieldNomEquipe);
					textFieldNomEquipe.setColumns(15);
				}
			}
			{
				JPanel panelComboJeu = new JPanel();
				panelChampsSaisie.add(panelComboJeu);
				panelComboJeu.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 15));
				{
					comboJeux = new JComboBox();
					comboJeux.setModel(new DefaultComboBoxModel(Jeu.toStrings()));
					panelComboJeu.add(comboJeux);
				}
			}
			{
				JPanel panelAjouterJoueurs = new JPanel();
				panelChampsSaisie.add(panelAjouterJoueurs);
				panelAjouterJoueurs.setLayout(new GridLayout(0, 2, 0, 0));
				{
					JPanel panelBtnAjouterJoueur = new JPanel();
					FlowLayout flowLayout = (FlowLayout) panelBtnAjouterJoueur.getLayout();
					flowLayout.setHgap(30);
					flowLayout.setVgap(15);
					panelAjouterJoueurs.add(panelBtnAjouterJoueur);
					{
						JButton btnAjouterJoueurs = new JButton("Ajouter Les Joueurs");
						btnAjouterJoueurs.setName("AjouterJoueurs");
						btnAjouterJoueurs.addActionListener(controleur);
						panelBtnAjouterJoueur.add(btnAjouterJoueurs);
					}
				}
				{
					JPanel panelListJoueurs = new JPanel();
					panelAjouterJoueurs.add(panelListJoueurs);
					panelListJoueurs.setLayout(new GridLayout(4, 1, 0, 0));
					{
						lblJoueur1 = new JLabel("Joueur 1 :");
						panelListJoueurs.add(lblJoueur1);
					}
					{
						lblJoueur2 = new JLabel("Joueur 2 :");
						panelListJoueurs.add(lblJoueur2);
					}
					{
						lblJoueur3 = new JLabel("Joueur 3 :");
						panelListJoueurs.add(lblJoueur3);
					}
					{
						lblJoueur4 = new JLabel("Joueur 4 :");
						panelListJoueurs.add(lblJoueur4);
					}
				}
			}
		}
		{
			JPanel panelTitre = new JPanel();
			contentPanel.add(panelTitre, BorderLayout.NORTH);
			{
				JLabel lblTitre = new JLabel("Nouvelle équipe '"+ this.ecurie.getNom() + "'");
				lblTitre.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
				panelTitre.add(lblTitre);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Créer");
				okButton.setName("CreerEquipe");
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
	}

	public Ecurie getEcurie() {
		return ecurie;
	}

	public JTextField getTextFieldNomEquipe() {
		return textFieldNomEquipe;
	}

	public JComboBox getComboJeux() {
		return comboJeux;
	}
	
	public JLabel getLblnomEquipe() {
		return lblNomEquipe;
	}

	public JLabel getLblJoueur1() {
		return lblJoueur1;
	}

	public JLabel getLblJoueur2() {
		return lblJoueur2;
	}

	public JLabel getLblJoueur3() {
		return lblJoueur3;
	}

	public JLabel getLblJoueur4() {
		return lblJoueur4;
	}

	public JLabel getLblJoueurNonAjoutes() {
		return lblJoueurNonAjoutes;
	}	

}

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

import DBlink.Ecurie;
import DBlink.Jeu;

public class FormEnregistrerEquipe extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Ecurie ecurie;
	private JTextField textFieldNomEquipe;
	private JComboBox comboJeux;
	private JLabel lblNomEquipe;

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
		
		setTitle("Nouvelle equipe");
		setBounds(100, 100, 333, 289);
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
		}
		{
			JPanel panelTitre = new JPanel();
			contentPanel.add(panelTitre, BorderLayout.NORTH);
			{
				JLabel lblTitre = new JLabel("Nouvelle ??quipe '"+ this.ecurie.getNom() + "'");
				lblTitre.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
				panelTitre.add(lblTitre);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Cr??er");
				setName("CreerEquipe");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Annuler");
				setName("Annuler");
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

}

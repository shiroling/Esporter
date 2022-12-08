package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controleur.ConnexionUtilisateur;
import Controleur.ControleurAccueil;
import DBlink.BDSelect;
import base.ConnexionState;

public class Connexion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldID;
	private JPasswordField textFieldMDP;

	/**
	 * Create the dialog.
	 */
	public Connexion(ControleurAccueil controleur, ConnexionState connexionVisee) {
		setType(Type.POPUP);
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 264, 214);
		getContentPane().setLayout(new BorderLayout());
		FlowLayout fl_contentPanel = new FlowLayout();
		fl_contentPanel.setVgap(10);
		fl_contentPanel.setHgap(100000);
		contentPanel.setLayout(fl_contentPanel);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblID = new JLabel("Identifiant");
			contentPanel.add(lblID);
		}
		{
			textFieldID = new JTextField();
			textFieldID.setToolTipText("Identifiant");
			contentPanel.add(textFieldID);
			textFieldID.setColumns(10);
		}
		{
			JLabel lblMDP = new JLabel("Mot de passe");
			contentPanel.add(lblMDP);
		}
		{
			textFieldMDP = new JPasswordField();
			textFieldMDP.setToolTipText("Mot de passe");
			contentPanel.add(textFieldMDP);
			textFieldMDP.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						switch (connexionVisee) {
						case ARBITRE : 
							break;
						case GESTIONNAIRE :
							if(ConnexionUtilisateur.isGestionnaire(textFieldID.getText(), String.valueOf(textFieldMDP.getPassword()))) {
								controleur.setConnexionState(ConnexionState.GESTIONNAIRE);
								System.out.println(BDSelect.getIdGerantFromLogs(textFieldID.getText(), String.valueOf(textFieldMDP.getPassword())));
								controleur.setIdLog(BDSelect.getIdGerantFromLogs(textFieldID.getText(), String.valueOf(textFieldMDP.getPassword())));
							} else {
								System.out.println("Fils de pute de tes morts");
								controleur.setConnexionState(ConnexionState.NON_CONNECTE);
							}
							break;
						case MANAGER :
							break; 
						default :
							controleur.setConnexionState(ConnexionState.NON_CONNECTE);
						}
						Connexion.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controleur.setConnexionState(ConnexionState.NON_CONNECTE);
						Connexion.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setVisible(true);
		}
	}

}

package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controleur.FocusListenerTextField;

public class ConnexionV2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConnexionV2 dialog = new ConnexionV2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConnexionV2() {
		setBounds(100, 100, 325, 296);
		setTitle("Connexion");
		getContentPane().setLayout(new BorderLayout());
		FlowLayout fl_contentPanel = new FlowLayout();
		fl_contentPanel.setVgap(30);
		contentPanel.setLayout(fl_contentPanel);
		contentPanel.setBackground(new Color(170,170,170));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			PanelArrondi panelContenantTitreChampsBtn = new PanelArrondi(30,30,30,30);
			contentPanel.add(panelContenantTitreChampsBtn);
			panelContenantTitreChampsBtn.setLayout(new GridLayout(4, 1, 0, 0));
			{
				JPanel panelLblTitre = new JPanel();
				panelLblTitre.setOpaque(false);
				panelLblTitre.setBackground(new Color(0,0,0,0));
				panelContenantTitreChampsBtn.add(panelLblTitre);
				{
					JLabel lblTitreLogin = new JLabel("LOGIN");
					lblTitreLogin.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 23));
					panelLblTitre.add(lblTitreLogin);
				}
			}
			{
				JPanel panelTxtFeildUsername = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panelTxtFeildUsername.getLayout();
				flowLayout.setHgap(30);
				panelTxtFeildUsername.setOpaque(false);
				panelTxtFeildUsername.setBackground(new Color(0,0,0,0));
				flowLayout.setVgap(10);
				panelContenantTitreChampsBtn.add(panelTxtFeildUsername);
				{
					textFieldUsername = new JTextField();
					textFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
					textFieldUsername.setText("USERNAME");
					textFieldUsername.setForeground(Color.GRAY);
					FocusListenerTextField focusListenerUsername = new FocusListenerTextField(textFieldUsername, textFieldUsername.getText());
					textFieldUsername.addFocusListener(focusListenerUsername);
					panelTxtFeildUsername.add(textFieldUsername);
					textFieldUsername.setColumns(15);
				}
			}
			{
				JPanel panelTxtFeildPassword = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panelTxtFeildPassword.getLayout();
				panelTxtFeildPassword.setOpaque(false);
				panelTxtFeildPassword.setBackground(new Color(0,0,0,0));
				flowLayout.setVgap(10);
				panelContenantTitreChampsBtn.add(panelTxtFeildPassword);
				{
					textFieldPassword = new JTextField();
					textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
					textFieldPassword.setText("PASSWORD");
					textFieldPassword.setForeground(Color.GRAY);
					FocusListenerTextField focusListenerPassword = new FocusListenerTextField(textFieldPassword, textFieldPassword.getText());
					textFieldPassword.addFocusListener(focusListenerPassword);
					panelTxtFeildPassword.add(textFieldPassword);
					textFieldPassword.setColumns(15);
				}
			}
			{
				JPanel panelBtnConnexion = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panelBtnConnexion.getLayout();
				panelBtnConnexion.setOpaque(false);
				panelBtnConnexion.setBackground(new Color(0,0,0,0));
				flowLayout.setVgap(10);
				panelContenantTitreChampsBtn.add(panelBtnConnexion);
				{
					BtnStyleV2 btnSeConnecter = new BtnStyleV2(BtnStyleV2.COLOR_BASE_BLEU, BtnStyleV2.COLOR_OVER_BLEU, BtnStyleV2.COLOR_CLIC_BLEU, 30);
					btnSeConnecter.setText("Se connecter");
					btnSeConnecter.setForeground(Color.WHITE);
					btnSeConnecter.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
					btnSeConnecter.updateUI();
					panelBtnConnexion.add(btnSeConnecter);
				}
			}
		}
	}

}

package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class ConnexionV2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

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
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel panelContenantTitreChampsBtn = new JPanel();
			Border blueBorder = BorderFactory.createLineBorder(new Color(0, 153, 255), 3);
			panelContenantTitreChampsBtn.setBorder(blueBorder);
			panelContenantTitreChampsBtn.setBackground(Color.WHITE);
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
					textField = new JTextField();
					textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
					panelTxtFeildUsername.add(textField);
					textField.setColumns(15);
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
					textField_1 = new JTextField();
					textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
					panelTxtFeildPassword.add(textField_1);
					textField_1.setColumns(15);
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
					JButton btnNewButton = new JButton("New button");
					panelBtnConnexion.add(btnNewButton);
				}
			}
		}
	}

}

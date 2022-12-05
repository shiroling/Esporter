package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DBlink.Jeu;
import DBlink.Tournoi;

public class CreerTournoi {

	private static JDialog cTournois;
	private JTextField textNom;
	private JTextField textDateDebut;
	private JTextField textDateFin;
	private JTextField texDateFinIscription;
	private List<Integer> idJeux;
	private JPanel panel_8;
	private JComboBox comboJeu;
	public static void main(String[] args) {
		CreerTournoi c = new CreerTournoi();
	}

	/**
	 * Create the application.
	 */
	public CreerTournoi() {
		initialize();
		cTournois.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		cTournois = new JDialog();
		cTournois.setType(Type.POPUP);
		cTournois.setAlwaysOnTop(true);
		cTournois.setModal(true);
		cTournois.setBounds(100, 100, 350, 454);
		cTournois.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		cTournois.getContentPane().add(panel, BorderLayout.SOUTH);

		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fermer();
			}
		});
		panel.add(btnNewButton_1);

		JPanel panel_1 = new JPanel();
		cTournois.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(0);
		panel_1.add(panel_2);

		JLabel lblNewLabel_1 = new JLabel("Nom");
		panel_2.add(lblNewLabel_1);

		textNom = new JTextField();
		panel_2.add(textNom);
		textNom.setColumns(10);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setVgap(15);
		flowLayout_1.setHgap(0);
		panel_1.add(panel_3);

		JLabel labelPortee = new JLabel("Port\u00E9e");
		panel_3.add(labelPortee);

		JComboBox comboPortee = new JComboBox();
		comboPortee.setModel(new DefaultComboBoxModel(new String[] {"Local", "National", "International"}));
		panel_3.add(comboPortee);

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setVgap(15);
		flowLayout_2.setHgap(0);
		panel_1.add(panel_4);

		JLabel lblNewLabel_2 = new JLabel("Date debut tournoi");
		panel_4.add(lblNewLabel_2);

		textDateDebut = new JTextField();
		panel_4.add(textDateDebut);
		textDateDebut.setColumns(10);

		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_5.getLayout();
		flowLayout_3.setVgap(15);
		flowLayout_3.setHgap(0);
		panel_1.add(panel_5);

		JLabel lblNewLabel_3 = new JLabel("Date fin tournoi");
		panel_5.add(lblNewLabel_3);

		textDateFin = new JTextField();
		panel_5.add(textDateFin);
		textDateFin.setColumns(10);

		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_6.getLayout();
		flowLayout_4.setVgap(15);
		flowLayout_4.setHgap(0);
		panel_1.add(panel_6);

		JLabel lblNewLabel_4 = new JLabel("Date fin inscription");
		panel_6.add(lblNewLabel_4);

		texDateFinIscription = new JTextField();
		panel_6.add(texDateFinIscription);
		texDateFinIscription.setColumns(10);

		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_7.getLayout();
		flowLayout_5.setHgap(20);
		panel_1.add(panel_7);

		panel_8 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_8.getLayout();
		flowLayout_6.setHgap(20);
		panel_1.add(panel_8);

		comboJeu = new JComboBox();
		comboJeu.setModel(new DefaultComboBoxModel(Jeu.getStringJeux()));
		comboJeu.setToolTipText("Jeux");
		panel_7.add(comboJeu);
		idJeux = new ArrayList<>();
		JButton btnAjouterJeu = new JButton("Ajouter Jeu");
		btnAjouterJeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idJeux.add(Jeu.getIdJeu(comboJeu.getSelectedItem().toString()));
				addGameDuCombo(comboJeu, btnAjouterJeu);
			}
		});
		panel_7.add(btnAjouterJeu);

		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int id : idJeux) {
					Jeu j = new Jeu(id);
					if(idJeux.size() == 1) {
						Tournoi.insererTournoi(textNom.getText(), comboPortee.getSelectedItem().toString(), texDateFinIscription.getText(), textDateDebut.getText(), textDateFin.getText(), id);
					} else {
						Tournoi.insererTournoi(textNom.getText() + " - " + j.getNom(), comboPortee.getSelectedItem().toString(), texDateFinIscription.getText(), textDateDebut.getText(), textDateFin.getText(), id);
					}
				}
				CreerTournoi.fermer();
			}
		});
		panel.add(btnNewButton);

	}

	private void addGameDuCombo(JComboBox comboJeu, JButton btnAjouterJeu) {
		JLabel lblJeu = new JLabel(comboJeu.getSelectedItem().toString());
		lblJeu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboJeu.addItem(lblJeu.getText());
				CreerTournoi.this.idJeux.remove(Jeu.getId(lblJeu.getText()));
				CreerTournoi.this.panel_8.remove(lblJeu);
			}
		});
		CreerTournoi.this.panel_8.add(new JLabel(comboJeu.getSelectedItem().toString()));
		comboJeu.removeItem(comboJeu.getSelectedItem());
		if(comboJeu.getItemCount() == 0) {
			comboJeu.setVisible(false);
			btnAjouterJeu.setVisible(false);
		}
	}
	public static void fermer() {
		cTournois.dispose();
	}

}

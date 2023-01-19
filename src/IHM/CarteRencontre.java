package IHM;
import java.awt.Font;

import javax.swing.JLabel;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import DBlink.Rencontre;

import java.awt.Color;
import java.awt.FlowLayout;

public class CarteRencontre extends Carte {
	private Rencontre rencontre;
	/**
	 * Create the panel.
	 */
	public CarteRencontre(Rencontre rencontre) {
		super();
		this.rencontre = rencontre;
		setBackground(new Color(255,255,255));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelNomRencontre = new JPanel();
		panelNomRencontre.setBackground(new Color(0,0,0,0));
		FlowLayout flowLayout = (FlowLayout) panelNomRencontre.getLayout();
		flowLayout.setVgap(30);
		add(panelNomRencontre);
		
		JLabel lblNomEquipe1 = new JLabel(rencontre.getEquipes().get(0).toString());
		lblNomEquipe1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		panelNomRencontre.add(lblNomEquipe1);
		
		JLabel lblSeparationEquipe = new JLabel(" - ");
		lblSeparationEquipe.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		panelNomRencontre.add(lblSeparationEquipe);
		
		JLabel lblNomEquipe2 = new JLabel(rencontre.getEquipes().get(1).toString());
		lblNomEquipe2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		panelNomRencontre.add(lblNomEquipe2);
		
		JPanel panelDateRencontre = new JPanel();
		panelDateRencontre.setBackground(new Color(0,0,0,0));
		FlowLayout flowLayout_1 = (FlowLayout) panelDateRencontre.getLayout();
		flowLayout_1.setVgap(20);
		add(panelDateRencontre);
		
		JLabel lblDateRencontre = new JLabel(rencontre.getDate().toString());
		lblDateRencontre.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		panelDateRencontre.add(lblDateRencontre);
		
		if (rencontre.estResultatRenseigne()) {
			if(rencontre.getVainqueur().getId() == rencontre.getEquipes().get(0).getId()) {
				lblNomEquipe1.setForeground(new Color(0, 128, 0));
				lblNomEquipe2.setForeground(new Color(128, 0, 0));
			} else {
				lblNomEquipe2.setForeground(new Color(0, 128, 0));
				lblNomEquipe1.setForeground(new Color(128, 0, 0));
			}
		}
		
		List<JPanel> listPanelAHover = new ArrayList<>();
		listPanelAHover.add(panelNomRencontre);
		listPanelAHover.add(panelDateRencontre);
		
		JPanel panelNomTournoi = new JPanel();
		panelNomTournoi.setBackground(new Color(0, 0, 0, 0));
		add(panelNomTournoi);
		
		JLabel lblNomTournoi = new JLabel(rencontre.getTournoi().getNom());
		lblNomTournoi.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		panelNomTournoi.add(lblNomTournoi);
		super.addHoverPannels(listPanelAHover);

		this.setName("CarteRencontre");
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
	}
	public Rencontre getRencontre() {
		return rencontre;
	}



}

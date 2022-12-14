package IHM;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import DBlink.Tournoi;
import base.PreDate;

public class CarteTournois extends Carte {
	
	private Tournoi tournoi;
	private JPanel panelDate;
	private JPanel panelNom;
	
	public CarteTournois(Tournoi tournoi) {
		super();
		this.tournoi = tournoi;
		GridLayout gridLayout = (GridLayout) getLayout();
		gridLayout.setRows(2);
		
		panelNom = new JPanel();
		panelNom.setBackground(new Color(255,255,255));
		add(panelNom);
		panelNom.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
		
		JLabel lblNomTournoi = new JLabel(tournoi.getNom());
		lblNomTournoi.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		lblNomTournoi.setHorizontalAlignment(SwingConstants.CENTER);
		panelNom.add(lblNomTournoi);
		
		panelDate = new JPanel();
		panelDate.setBackground(new Color(255,255,255));
		add(panelDate);
		panelDate.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		
		JLabel lblDateDebutFinTournoi = new JLabel(PreDate.toStringDateFormatterEuropean(tournoi.getDateDebut()) + " -- " + PreDate.toStringDateFormatterEuropean(tournoi.getDateFin()));
		lblDateDebutFinTournoi.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		panelDate.add(lblDateDebutFinTournoi);
		
		List<JPanel> listPanelAHover = new ArrayList<>();
		listPanelAHover.add(panelDate);
		listPanelAHover.add(panelNom);
		super.addHoverPannels(listPanelAHover);
	}
	
	public Tournoi getTournoi() {
		return tournoi;
	}
	
	public JPanel getPanelNomTournoi() {
		return this.panelNom;
	}
	
	public JPanel getPanelDateTournoi() {
		return this.panelDate;
	}

	
}

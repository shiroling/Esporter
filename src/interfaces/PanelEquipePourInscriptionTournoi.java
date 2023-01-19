package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import contoleur_bd.Equipe;
import controleur_ihm.HoverPanelEquipePourInscription;

public class PanelEquipePourInscriptionTournoi extends JPanel {
	
private Equipe equipe;
	
	public PanelEquipePourInscriptionTournoi(Equipe equipe, PopupSelectionEquipePourInscription vue) {
		this.equipe=equipe;
		
		HoverPanelEquipePourInscription hover = new HoverPanelEquipePourInscription(this, vue);
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 8));
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(0,0,0,0));
		setPreferredSize(new Dimension(0, 40));
		addMouseListener(hover);
		
		JLabel lblNomEquipe = new JLabel(equipe.getNom());
		lblNomEquipe.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
		add(lblNomEquipe);
	}
	
	public Equipe getEquipe() {
		return equipe;
	}
	
	public void enleverContour() {
		setBorder(new EmptyBorder(0,0,0,0));
	}
	
	public void setBorderBleu() {
		setBorder(new LineBorder(Color.BLUE));
	}
}

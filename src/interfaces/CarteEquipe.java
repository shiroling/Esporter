package interfaces;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import contoleur_bd.BDSelect;
import contoleur_bd.Equipe;

import java.awt.GridLayout;

public class CarteEquipe extends Carte {
	
	private Equipe equipe;
	
	public CarteEquipe(Equipe equipe) {
		super();
		this.equipe=equipe;
		setBackground(new Color(255,255,255));
		setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panelNom = new JPanel();
		add(panelNom);
		JLabel lblNomEquipe = new JLabel(equipe.getNom());
		lblNomEquipe.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		panelNom.add(lblNomEquipe);
		
		List<JPanel> listPanelAHover = new ArrayList<>();
		listPanelAHover.add(this);
		super.addHoverPannels(listPanelAHover);

		this.setName("CarteJeu");
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		JPanel panelPoint = new JPanel();
		add(panelPoint);
		
		JLabel lblPoint = new JLabel("Nombre de points : "+BDSelect.getPointsEquipe(equipe.getId()));
		lblPoint.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
		panelPoint.add(lblPoint);
		panelPoint.setBackground(new Color(0,0,0,0));
		panelNom.setBackground(new Color(0,0,0,0));
	}
	
	public Equipe getEquipe() {
		return equipe;
	}
	
	

}

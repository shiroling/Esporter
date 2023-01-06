package IHM;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import DBlink.Equipe;

public class CarteEquipe extends Carte {
	
	private Equipe equipe;
	
	public CarteEquipe(Equipe equipe) {
		super();
		this.equipe=equipe;
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 55));
		setBackground(new Color(255,255,255));
		
		JLabel lblNomEquipe = new JLabel(equipe.getNom());
		lblNomEquipe.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		add(lblNomEquipe);
		
		List<JPanel> listPanelAHover = new ArrayList<>();
		listPanelAHover.add(this);
		super.addHoverPannels(listPanelAHover);
	}
	
	public Equipe getEquipe() {
		return equipe;
	}
	
	

}

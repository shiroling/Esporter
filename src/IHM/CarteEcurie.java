package IHM;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import DBlink.Ecurie;

import java.awt.Color;
import java.awt.FlowLayout;

public class CarteEcurie extends Carte {

	private Ecurie ecurie;
	
	public CarteEcurie(Ecurie ecurie) {
		super();
		this.ecurie=ecurie;
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 55));
		setBackground(new Color(255,255,255));
		
		JLabel lblNomEcurie = new JLabel(ecurie.getNom());
		lblNomEcurie.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		add(lblNomEcurie);
		
		List<JPanel> listPanelAHover = new ArrayList<>();
		listPanelAHover.add(this);
		super.addHoverPannels(listPanelAHover);
	}
	
	public Ecurie getEcurie() {
		return ecurie;
	}
}

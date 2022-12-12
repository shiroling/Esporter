package IHM;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import DBlink.Jeu;

public class CarteJeu extends Carte {
	private Jeu jeu;
	/**
	 * Create the panel.
	 */
	public CarteJeu(Jeu jeu) {
		super();
		this.jeu=jeu;
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 55));
		setBackground(new Color(255,255,255));
		
		JLabel lblNomJeu = new JLabel(jeu.getNom());
		lblNomJeu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		add(lblNomJeu);
		
		List<JPanel> listPanelAHover = new ArrayList<>();
		listPanelAHover.add(this);
		super.addHoverPannels(listPanelAHover);
	}

	public Jeu getJeu() {
		return jeu;
	}
}

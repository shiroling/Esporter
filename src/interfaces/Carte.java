package interfaces;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controleur_ihm.HoverCarte;

public class Carte extends JPanel {
	
	private List<JPanel> listPanelAHover;
	
	public Carte() {
		super();
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(0,0,0,0));
		setLayout(new GridLayout(0, 1, 0, 0));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 55));
		setBackground(new Color(255,255,255));
	}
	
	public void addHoverPannels(List<JPanel> listPanelAHover) {
		this.listPanelAHover = listPanelAHover;
		HoverCarte hoverCarte = new HoverCarte(this, listPanelAHover);
		addMouseListener(hoverCarte);
	}
	
}
package IHM;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Controleur.HoverCarte;

public class Carte extends JPanel {
	
	private List<JPanel> listPanelAHover;
	/**
	 * Create the panel.
	 */
	public Carte() {
		setLayout(new GridLayout(0, 1, 0, 0));
	}
	
	public void addHoverPannels(List<JPanel> listPanelAHover) {
		this.listPanelAHover = listPanelAHover;
		HoverCarte hoverCarte = new HoverCarte(this, listPanelAHover);
		addMouseListener(hoverCarte);
	}
}
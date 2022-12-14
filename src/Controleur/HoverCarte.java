package Controleur;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPanel;

import IHM.Carte;

public class HoverCarte implements MouseListener{
	
	private Carte vue;
	private List<JPanel> listPanel;
	
	public HoverCarte(Carte vue, List<JPanel> listPanel) {
		super();
		this.vue = vue;
		this.listPanel = listPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		for(int i = 0 ; i < listPanel.size() ; i++) {
			this.listPanel.get(i).setBackground(new Color(220,220,220));
		}		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		for(int i = 0 ; i < listPanel.size() ; i++) {
			this.listPanel.get(i).setBackground(new Color(255,255,255));
		}		
	}

}

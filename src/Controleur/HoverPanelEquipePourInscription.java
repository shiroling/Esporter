package Controleur;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import IHM.PanelEquipePourInscriptionTournoi;

public class HoverPanelEquipePourInscription implements MouseListener {
	
	private PanelEquipePourInscriptionTournoi vue;

	public HoverPanelEquipePourInscription(PanelEquipePourInscriptionTournoi vue) {
		super();
		this.vue = vue;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.vue.setBackground(new Color(220,220,220));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.vue.setBackground(Color.WHITE);
	}

}

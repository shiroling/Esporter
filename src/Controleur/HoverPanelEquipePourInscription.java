package Controleur;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import IHM.PanelEquipePourInscriptionTournoi;
import IHM.PopupSelectionEquipePourInscription;

public class HoverPanelEquipePourInscription implements MouseListener {
	
	private PanelEquipePourInscriptionTournoi vue;
	private PopupSelectionEquipePourInscription popupContenant;

	public HoverPanelEquipePourInscription(PanelEquipePourInscriptionTournoi vue, PopupSelectionEquipePourInscription popupContenant) {
		super();
		this.vue = vue;
		this.popupContenant = popupContenant;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		popupContenant.setEquipeSelectionee(this.vue.getEquipe());
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

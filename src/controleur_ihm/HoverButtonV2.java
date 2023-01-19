package controleur_ihm;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import interfaces.BtnStyleV2;


public class HoverButtonV2 implements MouseListener {
	
	private BtnStyleV2 btn; 

	public HoverButtonV2(BtnStyleV2 btnStyle) {
		super();
		this.btn = btnStyle;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.btn.setBackground(this.btn.getCouleurClick());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.btn.setBackground(this.btn.getCouleurOver());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.btn.setBackground(this.btn.getCouleurOver());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.btn.setBackground(this.btn.getCouleurDeBase());
	}

}

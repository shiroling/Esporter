package controleur_ihm;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import interfaces.BtnStyle;


public class HoverButton implements MouseListener {
	
	private BtnStyle btn; 

	public HoverButton(BtnStyle btnStyle) {
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

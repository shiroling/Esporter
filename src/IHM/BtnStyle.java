package IHM;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

import Controleur.HoverButton;

public class BtnStyle extends JButton {
	
	private Color couleurDeBase;
	private Color couleurOver;
	private Color couleurClick;
	private int radius;	
	

	public BtnStyle(Color couleurDeBase, Color couleurOver, Color couleurClick, int radius) {
		super();
		this.couleurDeBase = couleurDeBase;
		this.couleurOver = couleurOver;
		this.couleurClick = couleurClick;
		this.radius = radius;
		setContentAreaFilled(false);
		setBackground(couleurDeBase);
		setBorderPainted(false);
		setFocusable(false);
		HoverButton hover = new HoverButton(this);
		addMouseListener(hover);
	}

	public Color getCouleurDeBase() {
		return couleurDeBase;
	}

	public Color getCouleurOver() {
		return couleurOver;
	}

	public Color getCouleurClick() {
		return couleurClick;
	}

	public int getRadius() {
		return radius;
	}

	public void setCouleurDeBase(Color couleurDeBase) {
		this.couleurDeBase = couleurDeBase;
	}


	public void setCouleurOver(Color couleurOver) {
		this.couleurOver = couleurOver;
	}

	public void setCouleurClick(Color couleurClick) {
		this.couleurClick = couleurClick;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//Paint border
		g2.fillRoundRect(2, 2, getWidth(), getHeight(), radius, radius);
		g2.setColor(getBackground());
		//Border 2px
		g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
		super.paintComponent(g);
	}
	
	

}

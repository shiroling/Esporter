package IHM;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Paint;

import javax.swing.JPanel;

public class PanelDegrade extends JPanel {

	public PanelDegrade() {
		super();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

	    // Création d'un dégradé de couleur rouge à bleu
	    Paint paint = new LinearGradientPaint(0, 0, getWidth(), getHeight(),
	      new float[] {0, 1}, new Color[] {new Color(163, 218, 255), BtnStyleV2.COLOR_BASE_BLEU});

	    // Appliquer le dégradé en arrière-plan du JPanel
	    g2d.setPaint(paint);
	    g2d.fillRect(0, 0, getWidth(), getHeight());
	}
}

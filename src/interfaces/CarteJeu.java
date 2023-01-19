package interfaces;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import contoleur_bd.Jeu;

public class CarteJeu extends Carte {
	private Jeu jeu;
	/**
	 * Create the panel.
	 */
	public CarteJeu(Jeu jeu) {
		super();
		this.jeu=jeu;
		setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panelNomJeu = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelNomJeu.getLayout();
		panelNomJeu.setBackground(new Color(0,0,0,0));
		flowLayout.setVgap(30);
		add(panelNomJeu);
		
		JLabel lblNomJeu = new JLabel(jeu.getNom());
		lblNomJeu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		panelNomJeu.add(lblNomJeu);
		
		JPanel panelLogoJeu = new JPanel();
		panelLogoJeu.setBackground(new Color(0,0,0,0));
		add(panelLogoJeu);
		
		// Récupération de l'image à partir du classpath
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(jeu.getPathLogo());

		// Chargement de l'image en utilisant la classe ImageIO
		BufferedImage image = null;
		try {
			image = ImageIO.read(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Affichage de l'image dans un JLabel
		JLabel lblLogoJeu = new JLabel(new ImageIcon(image));
		panelLogoJeu.add(lblLogoJeu);		
		
		List<JPanel> listPanelAHover = new ArrayList<>();
		listPanelAHover.add(panelNomJeu);
		listPanelAHover.add(panelLogoJeu);

		this.setName("CarteJeu");
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
	}

	public Jeu getJeu() {
		return jeu;
	}
}

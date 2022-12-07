package IHM;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import DBlink.Equipe;

public class CarteEquipe extends Carte {
	private Equipe equipe;
	/**
	 * Create the panel.
	 */
	public CarteEquipe(Equipe eq) {
		super("Equipe ","nom : "+eq.getNom());
		equipe=eq;
		JLabel lblManager = new JLabel("Manager : "+eq.getEcurie().getNomManager());
		lblManager.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblManager);
		JLabel lblecurie = new JLabel("Ecurie : "+eq.getEcurie().getNom());
		lblecurie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblecurie);
		

	}
	public Equipe getEquipe() {
		return equipe;
	}
	
	

}

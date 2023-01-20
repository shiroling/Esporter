package controleur_ihm;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controleur_ihm.ControleurAccueil.Etat;
import interfaces.Accueil;
import interfaces.CarteEcurie;
import interfaces.CarteEquipe;
import interfaces.CarteJeu;
import interfaces.CarteRencontre;
import interfaces.CarteTournois;

public class mouthAdapteruAccueil extends MouseAdapter {

	private static Accueil vue;

	public mouthAdapteruAccueil(Accueil vue) {
		super();
		this.vue = vue;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ControleurAccueil controleur = vue.getControleur();
		Object obj = e.getSource();
			if (obj instanceof CarteEcurie) {
				CarteEcurie ce = (CarteEcurie) obj;
				vue.procedureCreePopupEcurie(ce.getEcurie());
			} else if (obj instanceof CarteTournois) {
				CarteTournois ct = (CarteTournois) obj;
				vue.procedureCreePopupTournoi(ct.getTournoi());
			} else if (obj instanceof CarteEquipe) {
				CarteEquipe ce = (CarteEquipe) obj;
				vue.procedureCreePopupEquipe(ce.getEquipe());
			} else if (obj instanceof CarteJeu) {
				CarteJeu ce = (CarteJeu) obj;
				vue.procedureCreePopupJeu(ce.getJeu());
			} else if (obj instanceof CarteRencontre) {
				CarteRencontre cr = (CarteRencontre) obj;
				vue.procedureCreePopupRencontre(cr.getRencontre());
			}
		

}};

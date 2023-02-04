package controleur_ihm;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import contoleur_bd.Ecurie;
import contoleur_bd.Equipe;
import contoleur_bd.Joueur;
import contoleur_bd.Tournoi;
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
		mouthAdapteruAccueil.vue = vue;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void mouseClicked(MouseEvent e) {
		ControleurAccueil controleur = Accueil.getControleur();
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
		} else if (obj instanceof JLabel) {
			JLabel jl = (JLabel) obj;
			switch (jl.getName()) {
			case "Joueur":
				Accueil.procedureCreerPopup(Joueur.getJoueurFromPseudo(jl.getText()), controleur);
				break;
			case "Equipe":
				Accueil.procedureCreerPopup(Equipe.getEquipeFromNom(jl.getText()), controleur);
				break;
			case "Ecurie":
				Accueil.procedureCreerPopup(Ecurie.getEcurieFromNom(jl.getText()), controleur);
				break;
			case "Tournoi":
				Accueil.procedureCreerPopup(Tournoi.getTournoiFromNom(jl.getText()), controleur);
				break;
			default:
				break;
			}
		}

	}
};

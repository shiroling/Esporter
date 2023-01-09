package Controleur;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import DBlink.BDSelect;
import DBlink.Filters;
import DBlink.Jeu;
import DBlink.Tournoi;
import base.Portee;

public class ItemListnerComboFiltre implements ItemListener {
	
	public enum Etat {
		TOURNOI, RENCONTRE, EQUIPE;
	}
	
	private ControleurAccueil controleurAccueil;
	private Etat state;

	public ItemListnerComboFiltre(ControleurAccueil controleurAccueil, Etat state) {
		super();
		this.controleurAccueil = controleurAccueil;
		this.state = state;
	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		switch (this.state) {
		case TOURNOI:
			List<Tournoi> tournois = BDSelect.getListeTournois();
			
			switch(controleurAccueil.getComboFiltreAvencementTournoi().getSelectedItem().toString()) {
			case "En Cours":
				tournois = Filters.filtrer(tournois, Filters.estTournoiEnCours);
				break;
			case "A Venir":
				tournois = Filters.filtrer(tournois, Filters.estTournoiAVenir);
				break;
			case "Finis" :
				tournois = Filters.filtrer(tournois, Filters.estTournoiFini);
				break;
			}
			
			switch(controleurAccueil.getComboFiltreInscriptionTournoi().getSelectedItem().toString()) {
			case "En Cours":
				tournois = Filters.filtrer(tournois, Filters.sontInscriptionsEnCours);
				break;
			case "Finis":
				tournois = Filters.filtrer(tournois, Filters.sontInscriptionsFinies);
				break;
			}
			
			switch(controleurAccueil.getComboFiltreMultiTournoi().getSelectedItem().toString()) {
			case "Multigaming" :
				tournois = Filters.filtrer(tournois, Filters.estTournoiMulti);
				break;
			case "Jeu unique":
				tournois = Filters.filtrer(tournois, Filters.estTournoiJeuUnique);
				break;
			}
			
			if(!(controleurAccueil.getComboFiltreJeuTournoi().getSelectedItem().toString().equals("Tous"))) {
				tournois = Filters.filtrer(tournois, Filters.estTournoiSurJeu, Jeu.getJeuFromName(controleurAccueil.getComboFiltreJeuTournoi().getSelectedItem().toString()).getId());
			}
			
			if(!(controleurAccueil.getComboFiltrePorteeTournoi().getSelectedItem().toString().equals("Tous"))) {
				tournois = Filters.filtrer(tournois, Filters.estTournoiDePortee, Portee.stringToPortee(controleurAccueil.getComboFiltrePorteeTournoi().getSelectedItem().toString()));
			}
			this.setCartesTournoiDansAccueil(tournois);
			break;
		case RENCONTRE:
			break;
		case EQUIPE:
			break;
		}
	}
	
	private void setCartesTournoiDansAccueil(List<Tournoi> tournois) {
		controleurAccueil.getVueAccueil().viderCartes();
		controleurAccueil.getVueAccueil().ajouterCartesTournois(tournois);
		controleurAccueil.getVueAccueil().getLblTitreCartes().setText("Tournois");
		controleurAccueil.getVueAccueil().ajusterGrille();
	}

}

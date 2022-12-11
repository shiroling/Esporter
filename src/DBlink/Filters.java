package DBlink;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import base.Portee;

public class Filters {
	// Tournoi
	Predicate<Integer> estTournoiEnCours = id -> BDPredicats.estTournoiEnCours(id);
	Predicate<Integer> estTournoiFini = id -> BDPredicats.estTournoiFini(id);
	Predicate<Integer> estTournoiAVenir = id -> BDPredicats.estTournoiAVenir(id);
	Predicate<Integer> sontInscriptionsFinies = id -> BDPredicats.sontInscriptionsFinies(id);
	Predicate<Integer> estTournoiMulti = id -> BDPredicats.estTournoiMulti(id);
	BiPredicate<Integer, Integer> estTournoiSurJeu = (idTournoi, idJeu)  -> BDPredicats.estTournoiSurJeu(idTournoi, idJeu);
	BiPredicate<Integer, Portee> estTournoiDePortee = (id, p) -> BDPredicats.estTournoiDePortee(id, p);
	
	// Rencontre
	Predicate<Integer> estRencontreFini = id -> BDPredicats.estTournoiFini(id);
	Predicate<Integer> estRencontreAVenir = estRencontreFini.negate();
	BiPredicate<Integer, Integer> estRencontreSurJeu = (idMatch, idJeu) -> BDPredicats.estMatchSurJeu(idMatch, idJeu);
	BiPredicate<Integer, Integer> estRencontreDansTournoi = (idMatch, idTournoi) -> BDPredicats.estMatchTournoi(idMatch, idTournoi);
	BiPredicate<Integer, Integer> estRencontreDansPoule = (idMatch, idPoule) -> BDPredicats.estMatchPoule(idMatch, idPoule);
	BiPredicate<Integer, Integer> estRencontreAvecEquipe = (idMatch, idEquipe)  -> BDPredicats.estMatchAvecEquipe(idMatch, idEquipe);
	
	// Equipe
	BiPredicate<Integer, Integer> estEquipeFromEcurie = (idEquipe, idEcurie) -> BDPredicats.estEquipeFromEcurie(idEquipe, idEcurie);
	BiPredicate<Integer, Integer> estEquipeSurJeu = (idEquipe, idJeu) -> BDPredicats.estEquipeSurJeu(idEquipe, idJeu);


	
	public static List<Tournoi> tournoi(List<Tournoi> lt, Predicate<Integer> p) {
		for(Tournoi t : lt) {
			if( !p.test(t.getId())) {
				lt.remove(t);
			};
		}
		return lt;
	}	
	public static <T> List<Tournoi> tournoi(List<Tournoi> lt, BiPredicate<Integer, T> p, T secondPart) {
		for(Tournoi t : lt) {
			if( !p.test(t.getId(), secondPart)) {
				lt.remove(t);
			};
		}
		return lt;
	}
	
	public static List<Rencontre> rencontres(List<Rencontre> lt, Predicate<Integer> p) {
		for(Rencontre r : lt) {
			if( !p.test(r.getId())) {
				lt.remove(r);
			};
		}
		return lt;
	}	
	public static <T> List<Rencontre> Rencontre(List<Rencontre> lt, BiPredicate<Integer, T> p, T secondPart) {
		for(Rencontre r : lt) {
			if( !p.test(r.getId(), secondPart)) {
				lt.remove(r);
			};
		}
		return lt;
	}

	
}

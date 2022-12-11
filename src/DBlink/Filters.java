package DBlink;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import base.Portee;

public class Filters {
	// Tournoi
	Predicate<Integer> esBDEntityournoiEnCours = id -> BDPredicats.estTournoiEnCours(id);
	Predicate<Integer> esBDEntityournoiFini = id -> BDPredicats.estTournoiFini(id);
	Predicate<Integer> esBDEntityournoiAVenir = id -> BDPredicats.estTournoiAVenir(id);
	Predicate<Integer> sontInscriptionsFinies = id -> BDPredicats.sontInscriptionsFinies(id);
	Predicate<Integer> esBDEntityournoiMulti = id -> BDPredicats.estTournoiMulti(id);
	BiPredicate<Integer, Integer> esBDEntityournoiSurJeu = (idTournoi, idJeu)  -> BDPredicats.estTournoiSurJeu(idTournoi, idJeu);
	BiPredicate<Integer, Portee> esBDEntityournoiDePortee = (id, p) -> BDPredicats.estTournoiDePortee(id, p);
	
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

	
	/// don't min me np
	
	
	public static List<BDEntity> tournois(List<BDEntity> lt, List<Predicate<Integer>> lp) {
		for(Predicate<Integer> p : lp) {
			 lt = Filters.tournois(lt, p);
		}
		return lt;
	}

	public static <T> List<BDEntity> tournois(List<BDEntity> lt, List<BiPredicate<Integer, T>> lp, T secondPart) {
		for(BiPredicate<Integer, T> p : lp) {
			 lt = Filters.tournois(lt, p, secondPart);
		}
		return lt;
	}
	
	
	public static List<BDEntity> tournois(List<BDEntity> lt, Predicate<Integer> p) {
		for(BDEntity t : lt) {
			if( !p.test(t.getId())) {
				lt.remove(t);
			};
		}
		return lt;
	}	
	
	public static <T> List<BDEntity> tournois(List<BDEntity> lt, BiPredicate<Integer, T> p, T secondPart) {
		for(BDEntity t : lt) {
			if( !p.test(t.getId(), secondPart)) {
				lt.remove(t);
			};
		}
		return lt;
	}
}

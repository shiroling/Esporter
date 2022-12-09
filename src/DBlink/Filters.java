package DBlink;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
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
	
	// Match
	Predicate<Integer> estMatchFini = id -> BDPredicats.estTournoiFini(id);
	Predicate<Integer> estMatchAVenir = estMatchFini.negate();
	BiPredicate<Integer, Integer> estMatchSurJeu = (idMatch, idJeu) -> BDPredicats.estMatchSurJeu(idMatch, idJeu);
	BiPredicate<Integer, Integer> estMatchDansTournoi = (idMatch, idTournoi) -> BDPredicats.estMatchTournoi(idMatch, idTournoi);
	BiPredicate<Integer, Integer> estMatchDansPoule = (idMatch, idPoule) -> BDPredicats.estMatchPoule(idMatch, idPoule);
	BiPredicate<Integer, Integer> estMatchAvecEquipe = (idMatch, idEquipe)  -> BDPredicats.estMatchAvecEquipe(idMatch, idEquipe);
	
	// Equipe
	BiPredicate<Integer, Integer> estEquipeFromEcurie = (idEquipe, idEcurie) -> BDPredicats.estEquipeFromEcurie(idEquipe, idEcurie);
	BiPredicate<Integer, Integer> estEquipeSurJeu = (idEquipe, idJeu) -> BDPredicats.estEquipeSurJeu(idEquipe, idJeu);

	public static List<Tournoi> tournoi(List<Tournoi> lt, List<FunctionalInterface> f) {
		for (Tournoi t : lt) {
			if(true) {
				
			}
			
		}
		
		
		
		return null;
		
	}
	
}

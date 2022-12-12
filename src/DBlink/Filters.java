package DBlink;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import base.Portee;

public class Filters {
	// Tournoi
	public static Predicate<Integer> estTournoiEnCours = id -> BDPredicats.estTournoiEnCours(id);
	public static Predicate<Integer> estTournoiFini = id -> BDPredicats.estTournoiFini(id);
	public static Predicate<Integer> estTournoiAVenir = id -> BDPredicats.estTournoiAVenir(id);
	public static Predicate<Integer> sontInscriptionsFinies = id -> BDPredicats.sontInscriptionsFinies(id);
	public static Predicate<Integer> estTournoiMulti = id -> BDPredicats.estTournoiMulti(id);
	public static BiPredicate<Integer, Integer> estTournoiSurJeu = (idTournoi, idJeu)  -> BDPredicats.estTournoiSurJeu(idTournoi, idJeu);
	public static BiPredicate<Integer, Portee> estTournoiDePortee = (id, p) -> BDPredicats.estTournoiDePortee(id, p);
	
	// Rencontre
	public static Predicate<Integer> estRencontreFini = id -> BDPredicats.estTournoiFini(id);
	public static Predicate<Integer> estRencontreAVenir = estRencontreFini.negate();
	public static BiPredicate<Integer, Integer> estRencontreSurJeu = (idMatch, idJeu) -> BDPredicats.estMatchSurJeu(idMatch, idJeu);
	public static BiPredicate<Integer, Integer> estRencontreDansTournoi = (idMatch, idTournoi) -> BDPredicats.estMatchTournoi(idMatch, idTournoi);
	public static BiPredicate<Integer, Integer> estRencontreDansPoule = (idMatch, idPoule) -> BDPredicats.estMatchPoule(idMatch, idPoule);
	public static BiPredicate<Integer, Integer> estRencontreAvecEquipe = (idMatch, idEquipe)  -> BDPredicats.estMatchAvecEquipe(idMatch, idEquipe);
	
	// Equipe
	public static BiPredicate<Integer, Integer> estEquipeFromEcurie = (idEquipe, idEcurie) -> BDPredicats.estEquipeFromEcurie(idEquipe, idEcurie);
	public static BiPredicate<Integer, Integer> estEquipeSurJeu = (idEquipe, idJeu) -> BDPredicats.estEquipeSurJeu(idEquipe, idJeu);

	
	/// don't min me np
	
	
	public static <T extends BDEntity> List<BDEntity> filter(List<BDEntity> lt, List<Predicate<Integer>> lp) {
		for(Predicate<Integer> p : lp) {
			 lt = Filters.filter(lt, p);
		}
		return lt;
	}

	public static <T extends BDEntity, TypeSecondPart> List<T> filter(List<T> lt, List<BiPredicate<Integer, TypeSecondPart>> lp, TypeSecondPart secondPart) {
		for(BiPredicate<Integer, TypeSecondPart> p : lp) {
			 lt = Filters.filter(lt, p, secondPart);
		}
		return lt;
	}
	
	
	public static <T extends BDEntity> List<T> filter(List<T> lt, Predicate<Integer> p) {
		
		List<T> includedList = new ArrayList<>();
		for(T t : lt) {
			if( p.test(t.getId())) {
				includedList.add(t);
			}
		}
		return includedList;
	}	
	
	public static <T extends BDEntity, TypeSecondPart> List<T> filter(List<T> lt, BiPredicate<Integer, TypeSecondPart> p, TypeSecondPart secondPart) {
		List<T> includedList = new ArrayList<>();

		for(T t : lt) {
			if( p.test(t.getId(), secondPart)) {
				includedList.add(t);
			}
		}
		return includedList;
	}
}

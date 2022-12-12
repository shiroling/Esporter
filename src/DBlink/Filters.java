package DBlink;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import base.Portee;

public class Filters {
	// Tournoi
	public static Predicate<Tournoi> estTournoiEnCours = t -> BDPredicats.estTournoiEnCours(t.getId());
	public static Predicate<Tournoi> estTournoiFini = t -> BDPredicats.estTournoiFini(t.getId());
	public static Predicate<Tournoi> estTournoiAVenir = t -> BDPredicats.estTournoiAVenir(t.getId());
	public static Predicate<Tournoi> sontInscriptionsFinies = t -> BDPredicats.sontInscriptionsFinies(t.getId());
	public static Predicate<Tournoi> estTournoiMulti = t -> BDPredicats.estTournoiMulti(t);
	public static BiPredicate<Tournoi, Integer> estTournoiSurJeu = (t, idJeu)  -> BDPredicats.estTournoiSurJeu(t.getId(), idJeu);
	public static BiPredicate<Tournoi, Portee> estTournoiDePortee = (t, p) -> BDPredicats.estTournoiDePortee(t.getId(), p);
	
	// Rencontre
	public static Predicate<Integer> estRencontreFini = id -> BDPredicats.estTournoiFini(id);
	public static Predicate<Integer> estRencontreAVenir = estRencontreFini.negate();
	public static BiPredicate<Integer, Integer> estRencontreSurJeu = (idMatch, idJeu) -> BDPredicats.estMatchSurJeu(idMatch, idJeu);
	public static BiPredicate<Integer, Integer> estRencontreDansTournoi = (idMatch, idTournoi) -> BDPredicats.estMatchTournoi(idMatch, idTournoi);
	public static BiPredicate<Integer, Integer> estRencontreDansPoule = (idMatch, idPoule) -> BDPredicats.estMatchPoule(idMatch, idPoule);
	public static BiPredicate<Integer, Integer> estRencontreAvecEquipe = (idMatch, idEquipe)  -> BDPredicats.estMatchAvecEquipe(idMatch, idEquipe);
	
	// Equipe
	public static BiPredicate<Equipe, Integer> estEquipeFromEcurie = (equipe, idEcurie) -> BDPredicats.estEquipeFromEcurie(equipe, idEcurie);
	public static BiPredicate<Equipe, Integer> estEquipeSurJeu = (equipe, idJeu) -> BDPredicats.estEquipeSurJeu(equipe, idJeu);

	
	/// don't min me np
	
	
	public static List<BDEntity> filtrer(List<BDEntity> lt, List<Predicate<BDEntity>> lp) {
		for(Predicate<BDEntity> p : lp) {
			 lt = Filters.filtrer(lt, p);
		}
		return lt;
	}
	

	public static <T extends BDEntity, TypeSecondPart> List<T> filtrer(List<T> lt, List<BiPredicate<T, TypeSecondPart>> lp, TypeSecondPart secondPart) {
		for(BiPredicate<T, TypeSecondPart> p : lp) {
			 lt = Filters.filtrer(lt, p, secondPart);
		}
		return lt;
	}
	
	
	public static <T extends BDEntity> List<T> filtrer(List<T> tl, Predicate<T> estTournoiAVenir2) {
		return tl.stream().filter(estTournoiAVenir2).collect(Collectors.toList());
	}
	
	
	public static <T extends BDEntity, TypeSecondPart> List<T> filtrer(List<T> lt, BiPredicate<T, TypeSecondPart> p, TypeSecondPart secondPart) {
		List<T> includedList = new ArrayList<>();
			 includedList = Filters.filtrer(lt, p, secondPart);
		return includedList;
	}
}

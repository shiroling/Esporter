package DBlink;

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
	public static Predicate<Rencontre> estRencontreFini = r -> BDPredicats.estRencontreFinie(r);
	public static Predicate<Rencontre> estRencontreAVenir = estRencontreFini.negate();
	public static BiPredicate<Rencontre, Integer> estRencontreSurJeu = (r, idJeu) -> BDPredicats.estMatchSurJeu(r, idJeu);
	public static BiPredicate<Rencontre, Integer> estRencontreDansTournoi = (r, idTournoi) -> BDPredicats.estMatchTournoi(r, idTournoi);
	public static BiPredicate<Rencontre, Integer> estRencontreDansPoule = (r, idPoule) -> BDPredicats.estMatchPoule(r, idPoule);
	public static BiPredicate<Rencontre, Integer> estRencontreAvecEquipe = (r, idEquipe)  -> BDPredicats.estMatchAvecEquipe(r, idEquipe);
	
	// Equipe
	public static BiPredicate<Equipe, Integer> estEquipeFromEcurie = (equipe, idEcurie) -> equipe.getIdEcurie() == idEcurie;
	public static BiPredicate<Equipe, Integer> estEquipeSurJeu = (equipe, idJeu) -> equipe.getIdJeu() == idJeu;

	
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
	
	public static <T extends BDEntity> List<T> filtrer(List<T> tl, Predicate<T> p) {
		return tl.stream().filter(p).collect(Collectors.toList());
	}
	
	
	public static <T extends BDEntity, TypeSecondPart> List<T> filtrer(List<T> lt, BiPredicate<T, TypeSecondPart> p, TypeSecondPart secondPart) {
		return lt.stream().filter(x -> p.test(x, secondPart)).collect(Collectors.toList());
	}
}

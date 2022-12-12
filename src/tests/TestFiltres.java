package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import DBlink.Filters;
import DBlink.Tournoi;

class TestFiltres {

	@Test
	void testTournoisFini() {
		List<Tournoi> tl = new ArrayList<>();
		tl.add(new Tournoi(2556501)); // tournoi TestPast
		tl.add(new Tournoi(2556502)); // tournoi TestFuture 
		tl.add(new Tournoi(2556503)); // Tournoi TestNow
			
		tl = Filters.filtrer(tl, Filters.estTournoiFini);

		assertTrue(tl.size() == 1 && tl.get(0).getId() == 2556501);
	}

	@Test
	void testTournoisAVenir() {
		List<Tournoi> tl = new ArrayList<>();
		tl.add(new Tournoi(2556501)); // tournoi TestPast
		tl.add(new Tournoi(2556502)); // tournoi TestFuture 
		tl.add(new Tournoi(2556503)); // Tournoi TestNow
		
		tl = Filters.filtrer(tl, Filters.estTournoiAVenir);
		
		assertTrue(tl.size() == 1 && tl.get(0).getId() == 2556502);
	}
	
	@Test
	void testTournoisEnCours() {
		List<Tournoi> tl = new ArrayList<>();
		tl.add(new Tournoi(2556501)); // tournoi TestPast
		tl.add(new Tournoi(2556502)); // tournoi TestFuture 
		tl.add(new Tournoi(2556503)); // Tournoi TestNow
		
		tl = Filters.filtrer(tl, Filters.estTournoiEnCours);
		
		assertTrue(tl.size() == 1 && tl.get(0).getId() == 2556503);
	}
	
	@Test
	void testInscriptionFinies() {
		List<Tournoi> tl = new ArrayList<>();
		tl.add(new Tournoi(2556504)); // tournoi TestPast
		tl.add(new Tournoi(2556505)); // tournoi TestFuture 
		
		tl = Filters.filtrer(tl, Filters.sontInscriptionsFinies);
		
		assertTrue(tl.size() == 1 && tl.get(0).getId() == 2556505);
	}
	
	@Test
	void testTournoiMulti() {
		List<Tournoi> tl = new ArrayList<>();
		tl.add(new Tournoi(97)); // tournoi multi 1
		tl.add(new Tournoi(98)); // tournoi multi 2
		tl.add(new Tournoi(2));  // tournoi non multi
		
		tl = Filters.filtrer(tl, Filters.estTournoiMulti);
		assertTrue(tl.size() == 2 && tl.get(0).getId() == 97 && tl.get(1).getId() == 98);
	}
	
	@Test
	void testEstTournoiSurJeu() {
		List<Tournoi> tl = new ArrayList<>();
		tl.add(new Tournoi(1)); // tournoi RL
		tl.add(new Tournoi(2)); // tournoi OW2
		
		tl = Filters.filtrer(tl, Filters.estTournoiSurJeu, 1);
		assertTrue(tl.size() == 1 && tl.get(0).getIdJeu() == 1);
	}
	
	
	/*
	// Tournoi
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
*/	
	

}

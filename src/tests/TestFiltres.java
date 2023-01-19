package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import commun.Portee;
import contoleur_bd.BDEntity;
import contoleur_bd.Equipe;
import contoleur_bd.Filters;
import contoleur_bd.Rencontre;
import contoleur_bd.Tournoi;

public class TestFiltres {

	@Test
	public void testTournoisFini() {
		List<Tournoi> tl = new ArrayList<>();
		tl.add(new Tournoi(2556501)); // tournoi TestPast
		tl.add(new Tournoi(2556502)); // tournoi TestFuture 
		tl.add(new Tournoi(2556503)); // Tournoi TestNow
			
		tl = Filters.filtrer(tl, Filters.estTournoiFini);

		assertTrue(tl.size() == 1 && tl.get(0).getId() == 2556501);
	}

	@org.junit.Test
	public void testTournoisAVenir() {
		List<Tournoi> tl = new ArrayList<>();
		tl.add(new Tournoi(2556501)); // tournoi TestPast
		tl.add(new Tournoi(2556502)); // tournoi TestFuture 
		tl.add(new Tournoi(2556503)); // Tournoi TestNow
		
		tl = Filters.filtrer(tl, Filters.estTournoiAVenir);
		
		assertTrue(tl.size() == 1 && tl.get(0).getId() == 2556502);
	}
	
	@Test
	public void testTournoisEnCours() {
		List<Tournoi> tl = new ArrayList<>();
		tl.add(new Tournoi(2556501)); // tournoi TestPast
		tl.add(new Tournoi(2556502)); // tournoi TestFuture 
		tl.add(new Tournoi(2556503)); // Tournoi TestNow
		
		tl = Filters.filtrer(tl, Filters.estTournoiEnCours);
		
		assertTrue(tl.size() == 1 && tl.get(0).getId() == 2556503);
	}
	
	@Test
	public void testTournoiInscriptionFinies() {
		List<Tournoi> tl = new ArrayList<>();
		tl.add(new Tournoi(2556504)); // tournoi TestPast
		tl.add(new Tournoi(2556505)); // tournoi TestFuture 
		
		tl = Filters.filtrer(tl, Filters.sontInscriptionsFinies);
		
		assertTrue(tl.size() == 1 && tl.get(0).getId() == 2556505);
	}
	
	@Test
	public void testTournoiMulti() {
		List<Tournoi> tl = new ArrayList<>();
		tl.add(new Tournoi(97)); // tournoi multi 1
		tl.add(new Tournoi(98)); // tournoi multi 2
		tl.add(new Tournoi(2));  // tournoi non multi
		
		tl = Filters.filtrer(tl, Filters.estTournoiMulti);
		assertTrue(tl.size() == 2 && tl.get(0).getId() == 97 && tl.get(1).getId() == 98);
	}
	
	@Test
	public void testTournoiSurJeu() {
		List<Tournoi> tl = new ArrayList<>();
		tl.add(new Tournoi(1)); // tournoi RL
		tl.add(new Tournoi(2)); // tournoi OW2
		
		tl = Filters.filtrer(tl, Filters.estTournoiSurJeu, 1);
		assertTrue(tl.size() == 1 && tl.get(0).getIdJeu() == 1);
	}
	
	@Test
	public void testTournoiDePortee() {
		List<Tournoi> tl = new ArrayList<>();
		tl.add(new Tournoi(3)); // tournoi international
		tl.add(new Tournoi(4)); // tournoi national
		
		tl = Filters.filtrer(tl, Filters.estTournoiDePortee, Portee.NATIONAL);
		assertTrue(tl.size() == 1 && tl.get(0).getIdJeu() == 4);
	}
	
	@Test
	public void testEstRencontreFini() {
		List<Rencontre> liste = new ArrayList<>();
		liste.add(new Rencontre(1)); // rencontre a venir
		liste.add(new Rencontre(4)); // rencontre finie
		
		liste = Filters.filtrer(liste, Filters.estRencontreFini);
		assertTrue(liste.size() == 1 && liste.get(0).getId() == 4);
	}
	
	@Test
	public void testEstRencontreAVenir() {
		List<Rencontre> liste = new ArrayList<>();
		liste.add(new Rencontre(1)); // rencontre a venir
		liste.add(new Rencontre(4)); // rencontre finie
		
		liste = Filters.filtrer(liste, Filters.estRencontreFini.negate());
		assertTrue(liste.size() == 1 && liste.get(0).getId() == 1);
	}
	
	@Test
	public void testEstRencontreSurJeu() {
		List<Rencontre> liste = new ArrayList<>();
		liste.add(new Rencontre(1)); // sur RL
		liste.add(new Rencontre(5)); // sur OW2
		
		liste = Filters.filtrer(liste, Filters.estRencontreSurJeu, 1);
		assertTrue(liste.size() == 1 && liste.get(0).getId() == 5);
	}
	
	@Test
	public void testEstRencontreDansTournoi() {
		List<Rencontre> liste = new ArrayList<>();
		liste.add(new Rencontre(1)); // sur tournoi 1
		liste.add(new Rencontre(5)); // sur tournoi 2
		
		liste = Filters.filtrer(liste, Filters.estRencontreDansTournoi, 1);
		assertTrue(liste.size() == 1 && liste.get(0).getId() == 1);
	}
	
	@Test
	public void testEstRencontreDansPoule() {
		List<Rencontre> liste = new ArrayList<>();
		liste.add(new Rencontre(1)); // poule 1
		liste.add(new Rencontre(5)); // poule 2
		
		liste = Filters.filtrer(liste, Filters.estRencontreDansPoule, 2);
		assertTrue(liste.size() == 1 && liste.get(0).getId() == 5);
	}
	
	@Test
	public void testEstRencontreAvecEquipe() {
		List<Rencontre> liste = new ArrayList<>();
		liste.add(new Rencontre(1)); // avec equipe 2
		liste.add(new Rencontre(3)); // sans equipe 2
		
		liste = Filters.filtrer(liste, Filters.estRencontreAvecEquipe, 2);
		assertTrue(liste.size() == 1 && liste.get(0).getId() == 1);
	}
	
	@Test
	public void testEquipeSurJeu() {
		List<Equipe> tl = new ArrayList<>();
		tl.add(new Equipe(1)); // pas sur lol (4)
		tl.add(new Equipe(4)); // sur lol (4)
		
		tl = Filters.filtrer(tl, Filters.estEquipeSurJeu, 4);
		assertTrue(tl.size() == 1 && tl.get(0).getId() == 4);
	}
	
	@Test
	public void testEquipefromEcurie() {
		List<Equipe> tl = new ArrayList<>();
		tl.add(new Equipe(1)); // pas chez mandatory (4)
		tl.add(new Equipe(2)); // chez mandatory (4)
		
		tl = Filters.filtrer(tl, Filters.estEquipeFromEcurie, 4);
		assertTrue(tl.size() == 1 && tl.get(0).getId() == 2);
	}

}

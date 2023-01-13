package tests;

import java.util.List;

import DBlink.BDInsert;
import DBlink.BDSelect;
import DBlink.Equipe;
import DBlink.Poule;
import DBlink.Rencontre;
import DBlink.Tournoi;

public class testGenerationTournoi {
	public static void main(String[] args) throws Exception {
		
		/*
		Poule p = new Poule(675);
		System.out.println(p.estFinie());
		
		List<Rencontre> lr = p.getRencontres();
		for (Rencontre r : lr) {
			r.designerVainceur(r.getEquipes().get(0).getId());
		}
		
		System.out.println(p.estFinie());
		
		*/
		Tournoi t = new Tournoi(260);
		List<Poule> lp = t.getListePoulesSimples();		
		for (Poule poule : lp) {
			System.out.println(poule.getPremier().getId());
			BDInsert.insererComposer(poule.getPremier().getId(), poule.getTournoi().getPouleFinale().getId());

		}

	}
}

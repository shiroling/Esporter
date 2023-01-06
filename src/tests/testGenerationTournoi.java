package tests;

import DBlink.BDSelect;
import DBlink.Tournoi;

public class testGenerationTournoi {
	public static void main(String[] args) throws Exception {
		Tournoi t = new Tournoi(178);
		
		System.out.println("nb inscrits : "+t.getNombreInscrits());
		System.out.println(BDSelect.getNombreInscritTournois(178));
		
		System.out.println(t.isTournoiPlein());
		t.genererPoules();
		
	}
}

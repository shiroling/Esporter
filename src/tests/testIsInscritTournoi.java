package tests;

import DBlink.Equipe;
import DBlink.Tournoi;

public class testIsInscritTournoi {
	public static void main(String[] args) {
		Tournoi t = new Tournoi(1);
		System.out.println(t.isInscrite(new Equipe(1)));
		
		
		t = new Tournoi(2);
		System.out.println(t.isInscrite(new Equipe(1)));
	}
}

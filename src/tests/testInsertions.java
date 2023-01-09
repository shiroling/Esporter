package tests;

import DBlink.Equipe;
import DBlink.Tournoi;

public class testInsertions {
	public static void main(String[] args) {
		Tournoi t = new Tournoi(177);
		t.inscrireEquipe(new Equipe(1));
	}
}

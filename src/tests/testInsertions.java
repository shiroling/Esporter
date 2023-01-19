package tests;

import contoleur_bd.Equipe;
import contoleur_bd.Tournoi;

public class testInsertions {
	public static void main(String[] args) {
		Tournoi t = new Tournoi(177);
		t.inscrireEquipe(new Equipe(1));
	}
}

package tests;

import contoleur_bd.BDPredicats;

public class testExistNomTournoi {
	public static void main(String[] args) {
		System.out.println(BDPredicats.existeNomTournoi("RLVL"));
		System.out.println(BDPredicats.existeNomTournoi("Shiro's multiFest"));
		System.out.println(BDPredicats.existeNomTournoi("foifnfqseon"));
	}
}

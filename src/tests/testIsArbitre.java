package tests;

import contoleur_bd.BDPredicats;

public class testIsArbitre {
public static void main(String[] args) {
	System.out.println(BDPredicats.isArbitre("Charles", "$iutinfo"));
	System.out.println(BDPredicats.isArbitre("Collina", "$iutinfo"));
	System.out.println(BDPredicats.isArbitre("Pierreluigi", "$iutinfo"));

	System.out.println(BDPredicats.isArbitre("bob", "$iutinfo"));
}
}

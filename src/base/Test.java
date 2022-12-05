package base;

public class Test {

	@SuppressWarnings({"unused" })
	public static void main(String[] args) {
		/*
		//List<Tournoi>  l = ControleurBD.getListeTournois();
		//List<Ecurie>  l = ControleurBD.getListeEcurie();
		//List<Equipe>  l = ControleurBD.getListeEquipes();
		//List<Jeu>  l = ControleurBD.getListeJeux();
		//List<Joueur>  l = ControleurBD.getListeJoueurs();
		//List<Poule>  l = ControleurBD.getListePoules();
		List<Rencontre>  l = ControleurBD.getListeRencontre();
		
		LocalDate d = LocalDate.of(1914, 6, 28);
		Date dfi = java.sql.Date.valueOf(LocalDate.of(1914, 6, 28));
		Date ddt = java.sql.Date.valueOf(LocalDate.of(1914, 7, 28));
		Date dft = java.sql.Date.valueOf(LocalDate.of(1918, 7, 28));
		int i[] = {(1), (2)};  
		Tournoi.insererTournoisMultigaming("bébouMulti", Portee.NATIONAL, dfi, ddt, dft, i, 3);
	*/
		for (String string : Portee.toString()) {
			System.out.println(string);
		}
	}

}

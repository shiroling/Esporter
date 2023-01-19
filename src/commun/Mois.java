package commun;

public enum Mois {
	JANVIER("Janvier", 0), FEVRIER("Février", 1), MARS("Mars", 2), AVRIL("Avril", 3), MAI("Mai", 4), JUIN("Juin", 5), JUILLET("Juillet", 6), AOUT("Août", 7), SEPTMBRE("Septembre", 8), OCTOBRE("Octobre", 9), NOVEMBRE("Novembre", 10), DECEMBRE("Décembre", 11);
	
	private String denomination;
	private int moisChiffre;

	private Mois(String denomination, int moisChiffre) {
		this.denomination = denomination;
		this.moisChiffre = moisChiffre;
	} 
	
	public int getMoisChiffre() {
		return this.moisChiffre;
	}
	
	public String getDenomination() {
		return this.denomination;
	}
	
	public static Mois stringToMois(String str) {
		switch(str) {
			case "Janvier":
				return Mois.JANVIER;
			case "Février":
				return Mois.FEVRIER;
			case "Mars" :
				return Mois.MARS;
			case "Avril":
				return Mois.AVRIL;
			case "Mai":
				return Mois.MAI;
			case "Juin":
				return Mois.JUIN;
			case "Juillet":
				return Mois.JUILLET;
			case "Août":
				return Mois.AOUT;
			case "Septembre":
				return Mois.SEPTMBRE;
			case "Octobre":
				return Mois.OCTOBRE;
			case "Novembre":
				return Mois.NOVEMBRE;
			case "Décembre":
				return Mois.DECEMBRE;
			default :
				return null;
		}
	}
	
	public static String[] toStrings() {
		String[] mois = new String[Mois.values().length];
		for (int i = 0; i < Mois.values().length ; i++) {
			mois[i] = Mois.values()[i].getDenomination();
		}
		return mois;
	}
}
package base;
import java.util.stream.Stream;

public enum Mois {
	JANVIER("Janvier"), FEVRIER("Février"), MARS("Mars"), AVRIL("Avril"), MAI("Mai"), JUIN("Juin"), JUILLET("Juillet"), AOUT("Août"), SEPTMBRE("Septembre"), OCTOBRE("Octobre"), NOVEMBRE("Novembre"), DECEMBRE("Décembre");
	
	private String denomination;

	private Mois(String denomination) {
		this.denomination = denomination;
	} 
	
	public String getDenomination() {
		return this.denomination;
	}
	
	public static String[] toStrings() {
		String[] mois = new String[Mois.values().length];
		for (int i = 0; i < Mois.values().length ; i++) {
			mois[i] = Mois.values()[i].getDenomination();
		}
		return mois;
	}
}
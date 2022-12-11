package DBlink;

import java.util.List;

public class Jeu extends BDEntity implements Comparable<Jeu> {
	private String nom;

	public Jeu(int id) {
		super(id);
	}
	
	public void init() {
		BDinit.init(this);
	}


	public int getId() {
		return super.getId();
	}

	public String getNom() {
		if (this.nom == null) {
			this.init();
		}
		return nom;
	}

	protected void setNom(String nom) {
		this.nom = nom;
	}


	public static String[] toStrings(List<Jeu> jeux) {
		String[] nomJeux = new String[jeux.size()];
		for(int i = 0; i < jeux.size() ; i++) {
			nomJeux[i] = jeux.get(i).toString();
		}
		return nomJeux;
	}
	
	public static String[] toStrings() {
		List<Jeu> jeux = BDSelect.getListeJeux();
		String[] nomJeux = new String[jeux.size()];
		for(int i = 0; i < jeux.size() ; i++) {
			nomJeux[i] = jeux.get(i).toString();
		}
		return nomJeux;
	}

	@Override
	public String toString() {
		return this.getNom();
	}
	
	public static Jeu getJeuFromName(String name) {
		return new Jeu(BDSelect.getIdJeu(name));
	}

	@Override
	public int compareTo(Jeu o) {
		if (this.getNom().compareTo("Valorant") == 0) {
			return 1;
		}
		return 0;
	}

}

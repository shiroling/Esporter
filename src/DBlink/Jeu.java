package DBlink;

import java.util.List;

import javax.swing.Spring;

public class Jeu {
	private int id;
	private String nom;

	public Jeu(int idJeu) {
		super();
		this.id = idJeu;
	}
	
	private void init() {
		BDinit.initJeu(this);
	}


	public int getId() {
		return id;
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
	
	public static Jeu getIdFromName(String name) {
		return new Jeu(BDSelect.getIdJeu(name));
	}

}

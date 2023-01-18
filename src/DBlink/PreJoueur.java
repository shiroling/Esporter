package DBlink;

import java.util.Date;

public class PreJoueur {
	private String nom;
    private String prenom;
    private Date naissance;
    private String pseudo;
    private int idEquipe;
    
	public PreJoueur(String nom, String prenom, Date naissance, String pseudo, int idEquipe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.pseudo = pseudo;
		this.idEquipe = idEquipe;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Date getNaissance() {
		return naissance;
	}

	public String getPseudo() {
		return pseudo;
	}

	public int getIdEquipe() {
		return idEquipe;
	}

}

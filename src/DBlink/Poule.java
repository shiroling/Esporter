package DBlink;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Poule extends BDEntity {
    private Boolean isFinale;
    private int idTournoi;

    

    public Poule(int id) {
		super(id);
		this.isFinale = null;
		this.idTournoi = -1;
	}
    
    public void init() {
		BDinit.init(this);
	}

    public int getId() {
		return super.getId();
	}
	
	public Boolean isFinale() {
		if(this.isFinale == null) {
			this.init();
		}
		return isFinale;
	}

	public int getIdTournoi() {
		if(idTournoi == -1) {
			this.init();
		}
		return idTournoi;
	}
	
	public Tournoi getTournoi() {
		return new Tournoi(this.idTournoi);
	}

	protected void setIsFinale(Boolean isFinale) {
		this.isFinale = isFinale;
	}

	protected void setIdTournoi(int idTournoi) {
		this.idTournoi = idTournoi;
	}
	
	public List<Equipe> getEquipes() {
		return BDSelect.getListeEquipesFromPoule(this.getId());
	}

	@Override
	public String toString() {
		// TODO non Auto-generated method stub
		return "le toString() n'est pas implémenté dans la class Poule je vous laisse le faire comme je ne sais pas comment vous voulez qu'il soit";
	}
	
	public static Date fixerDateRencontre(boolean isFinale, int idTournoi) {
		Tournoi t = new Tournoi(idTournoi);
		Date debut = t.getDateDebut();
		Date fin = t.getDateFin();
		
		int diff = (int) (debut.getTime() / 86400000 - fin.getTime() / 86400000);
		if(diff < 2) {
			return debut;
		}
		
		if(isFinale) {
			return fin;
		}
		return debut;
		}

	public void genererRencontres() {		
		BDInsert.genererRencontre(this.getId());
	}
	
	public List<Rencontre> getRencontres() {
		return BDSelect.getListeRencontreFromPoule(this.getId());
	}

	public Rencontre getRencontreVide() throws Exception {
		List<Rencontre> lr = this.getRencontres();
		for (Rencontre rencontre : lr) {
			if(!rencontre.isFull()) {
				return rencontre;
			}
		}
		throw new Exception("Impossible d'insérer le finaliste, il n'y a pas de rencontres libres");
	}

	public void setFinalist(int idEquipe) {
		// TODO faut utiliser la procedure PLSQL
		BDInsert.insererComposer(idEquipe, this.getId());
		
		// TODO vérifier si c'est le dernier matche joué de la poule
		// si c'est le cas, il faut inscrire le premier de la poule GET_PREMIER_POULE(idPoule)
		// et l'inscrire à la poule finale du tournoi p.getTournoi.getPouleFinale()
		// BREF
	}
}

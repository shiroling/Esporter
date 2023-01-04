package DBlink;

import java.sql.Date;
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
	
	private Date fixerDateRencontre(boolean isFinale) {
		Tournoi t = new Tournoi(this.getIdTournoi());
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

	@SuppressWarnings("null")
	public void genererRencontres() {		
		this.init(); //just in case it isn't ;)
		
		List<Equipe> l = this.getEquipes();
		List<Equipe> le = null;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 2; j++) {
				le.add(l.get(i*4+j));
			}
			
			BDInsert.insererRencontre(BDSelect.getRandomArbitre() , this.getId(), fixerDateRencontre(this.isFinale()), le);
			le.clear();
		}
		
		List<Poule> lp = BDSelect.getPoulesTournoi(this.getId());
		for (Poule poule : lp) {
			poule.genererRencontres();
		}
	}
}

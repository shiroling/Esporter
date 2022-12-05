package modeleBD;

public class Poule {
    private final int idPoule;
    private Boolean isFinale;
    private int idTournoi;

    

    public Poule(int idPoule) {
		super();
		this.idPoule = idPoule;
		this.isFinale = null;
		this.idTournoi = -1;
	}
    
    private void init() {
		ControleurBD.initPoule(this);
	}

    public int getId() {
		return idPoule;
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
}

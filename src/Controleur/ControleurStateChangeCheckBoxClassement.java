package Controleur;

import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import DBlink.BDSelect;
import DBlink.Equipe;
import IHM.Accueil;

public class ControleurStateChangeCheckBoxClassement implements ChangeListener{
	
	private Accueil vue;
	
	public ControleurStateChangeCheckBoxClassement(Accueil vue) {
		super();
		this.vue = vue;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JCheckBox check = (JCheckBox) e.getSource();
		
		if(check.isSelected()) {
			this.vue.viderCartes();
			
			List<Equipe> equipes = BDSelect.getClassementGeneral();
			this.vue.ajouterCartesEquipe(equipes);
		}
	}

}

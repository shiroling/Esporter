package Controleur;

import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import DBlink.BDSelect;
import DBlink.Equipe;
import IHM.AccueilV2;

public class ControleurStateChangeCheckBoxClassement implements ChangeListener{
	
	private AccueilV2 vue;
	
	public ControleurStateChangeCheckBoxClassement(AccueilV2 vue) {
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

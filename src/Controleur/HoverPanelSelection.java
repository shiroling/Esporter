package Controleur;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import DBlink.BDSelect;
import IHM.AccueilV2;
import IHM.PanelSelection;
import IHM.PanelSelection.Selection;

public class HoverPanelSelection implements MouseListener{
	
	private PanelSelection vue;
	private Selection select;
	private AccueilV2 vueAccueil;

	public HoverPanelSelection(PanelSelection vue, Selection select, AccueilV2 vueAccueil) {
		super();
		this.vue = vue;
		this.select = select;
		this.vueAccueil = vueAccueil;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch(this.select) {
		case TOURNOI:
			this.vueAccueil.getControleur().setPanelFiltresTournois();
			vueAccueil.viderCartes();
			vueAccueil.ajouterCartesTournois(BDSelect.getListeTournois());
			vueAccueil.getLblTitreCartes().setText("Tournois");
			vueAccueil.ajusterGrille();
			break;
		case RENCONTRE:
			this.vueAccueil.getControleur().setPanelFiltresRencontres();
			vueAccueil.viderCartes();
			vueAccueil.getLblTitreCartes().setText("Matchs");
			vueAccueil.ajouterCartesMatch(BDSelect.getListeRencontre());
			vueAccueil.ajusterGrille();
			break;
		case JEU:
			this.vueAccueil.getControleur().setPanelVide();
			vueAccueil.viderCartes();
			vueAccueil.ajouterCartesJeu(BDSelect.getListeJeux());
			vueAccueil.getLblTitreCartes().setText("Jeux");
			vueAccueil.ajusterGrille();
			break;
		case EQUIPE:
			this.vueAccueil.getControleur().setPanelFiltresEquipes();
			vueAccueil.viderCartes();
			vueAccueil.ajouterCartesEquipe(BDSelect.getListeEquipes());
			vueAccueil.getLblTitreCartes().setText("Equipes");
			vueAccueil.ajusterGrille();
			break;
		case ECURIE:
			this.vueAccueil.getControleur().setPanelVide();
			vueAccueil.viderCartes();
			vueAccueil.ajouterCartesEcurie(BDSelect.getListeEcurie());
			vueAccueil.getLblTitreCartes().setText("Ecuries");
			vueAccueil.ajusterGrille();
			break;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.vue.getPanelLigneHover().setPreferredSize(new Dimension(20, 0));
		this.vue.getPanelLigneHover().repaint();
		this.vue.revalidate();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.vue.getPanelLigneHover().setPreferredSize(new Dimension(10, 0));
		this.vue.getPanelLigneHover().repaint();
		this.vue.revalidate();
	}

}

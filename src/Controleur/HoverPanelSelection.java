package Controleur;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import DBlink.BDSelect;
import DBlink.Ecurie;
import DBlink.Equipe;
import DBlink.Jeu;
import DBlink.Rencontre;
import DBlink.Tournoi;
import IHM.Accueil;

import IHM.PanelSelection;
import IHM.PanelSelection.Selection;

public class HoverPanelSelection implements MouseListener{
	
	private PanelSelection vue;
	private Selection select;
	private Accueil vueAccueil;

	public HoverPanelSelection(PanelSelection vue, Selection select, Accueil vueAccueil) {
		super();
		this.vue = vue;
		this.select = select;
		this.vueAccueil = vueAccueil;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ControleurAccueil ctrlAcceuil = vueAccueil.getControleur();
		
		switch(this.select) {
		case TOURNOI:
			ctrlAcceuil.setPanelFiltresTournois();
			ctrlAcceuil.updateTournois();
			vueAccueil.viderCartes();
			vueAccueil.ajouterCartesTournois(ctrlAcceuil.getTournois());
			vueAccueil.getLblTitreCartes().setText("Tournois");
			vueAccueil.ajusterGrille();
			break;
		case RENCONTRE:
			this.vueAccueil.getControleur().setPanelFiltresRencontres();
			ctrlAcceuil.updateRencontres();
			vueAccueil.viderCartes();
			vueAccueil.getLblTitreCartes().setText("Matchs");
			vueAccueil.ajouterCartesMatch(ctrlAcceuil.getRencontres());
			vueAccueil.ajusterGrille();
			break;
		case JEU:
			this.vueAccueil.getControleur().setPanelVide();
			ctrlAcceuil.updateJeux();
			vueAccueil.viderCartes();
			vueAccueil.ajouterCartesJeu(ctrlAcceuil.getJeux());
			vueAccueil.getLblTitreCartes().setText("Jeux");
			vueAccueil.ajusterGrille();
			break;
		case EQUIPE:
			this.vueAccueil.getControleur().setPanelFiltresEquipes();
			ctrlAcceuil.updateEquipes();
			vueAccueil.viderCartes();
			vueAccueil.ajouterCartesEquipe(ctrlAcceuil.getEquipes());
			vueAccueil.getLblTitreCartes().setText("Equipes");
			vueAccueil.ajusterGrille();
			break;
		case ECURIE:
			this.vueAccueil.getControleur().setPanelVide();
			ctrlAcceuil.updateEcuries();
			vueAccueil.viderCartes();
			vueAccueil.ajouterCartesEcurie(ctrlAcceuil.getEcuries());
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

package IHM;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controleur.HoverPanelSelection;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class PanelSelection extends JPanel {
	
	private JPanel panelLigneHover;
	private HoverPanelSelection hover;
	
	public static enum Selection {
		TOURNOI("Tournois"), RENCONTRE("Matchs"), JEU("Jeux"), EQUIPE("Equipes"), ECURIE("Ecuries");
		
		private String label;
		
		private Selection(String lbl) {
			this.label = lbl;
		}
		
		public String getLabel() {
			return this.label;
		}
	}
	
	public PanelSelection(AccueilV2 vueAccueil, Selection selection) {		
		hover = new HoverPanelSelection(this, selection, vueAccueil);
		
		setLayout(new BorderLayout(0, 0));
		addMouseListener(hover);
		setPreferredSize(new Dimension(0, 50));
		setBackground(Color.WHITE);
		setBorder(new LineBorder(Color.GRAY));
		
		panelLigneHover = new JPanel();
		panelLigneHover.setBackground(new Color(0, 153, 255));
		panelLigneHover.setPreferredSize(new Dimension(10, 0));
		add(panelLigneHover, BorderLayout.EAST);
		
		JPanel panelLbl = new JPanel();
		panelLbl.setBackground(new Color(0,0,0,0));
		FlowLayout flowLayout = (FlowLayout) panelLbl.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setHgap(10);
		flowLayout.setVgap(getHeight()/2 + 15); 
		add(panelLbl, BorderLayout.CENTER);
		
		JLabel lblSelection = new JLabel(selection.getLabel());
		lblSelection.setHorizontalAlignment(SwingConstants.LEFT);
		panelLbl.add(lblSelection);
	}

	public JPanel getPanelLigneHover() {
		return this.panelLigneHover;
	}

	public HoverPanelSelection getHover() {
		return hover;
	}
	
	
}

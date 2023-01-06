package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import IHM.PopupTournoi;

public class ControlerPopupTournoi implements ActionListener {
	
	private PopupTournoi vue;
	
	public ControlerPopupTournoi(PopupTournoi vue) {
		super();
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		
		
	}

}

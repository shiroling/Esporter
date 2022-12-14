package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBlink.Rencontre;

public class PopupRencontre extends JDialog {

	private final JPanel contentPanel = new JPanel();



	/**
	 * Create the dialog.
	 */
	public PopupRencontre(Rencontre r) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelHead = new JPanel();
		contentPanel.add(panelHead, BorderLayout.NORTH);
		
		JPanel panelCorp = new JPanel();
		contentPanel.add(panelCorp, BorderLayout.CENTER);
		
		
	}

}

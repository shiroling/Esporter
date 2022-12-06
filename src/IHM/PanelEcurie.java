package IHM;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PanelEcurie extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelEcurie() {
		setLayout(new GridLayout(5, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		add(panel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton);

	}

}

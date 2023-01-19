package interfaces;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
/**
 * @author benoit leclerc
 *
 */
public abstract class MyLabel extends JLabel {
	

	public MyLabel() {
		super();
	}

	public MyLabel(String s) {
		super(s);
	}

	public abstract void popup();
	

}

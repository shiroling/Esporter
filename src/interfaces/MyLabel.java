package interfaces;

import javax.swing.JLabel;

public abstract class MyLabel extends JLabel {
	
	public MyLabel() {
		super();
	}

	public MyLabel(String s) {
		super(s);
	}

	public abstract void popup();
	

}

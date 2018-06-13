package Client;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class UI {
	public static void main(String[] args) {
	       JFrame atm = new JFrame("ATM");
	       atm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       atm.setResizable(false);
	       atm.setLayout(new BorderLayout());
	       atm.add(new ATM(), BorderLayout.CENTER);
	       atm.pack();
	       atm.setLocationRelativeTo(null);
	       atm.setVisible(true);
		}

}

package Client;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class UI {
	public static void main(String[] args) {
	 /* JFrame atm = new JFrame("ATM");
	    atm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    atm.setResizable(false);
	    atm.setLayout(new BorderLayout());
	    atm.add(new ATM(), BorderLayout.CENTER);
	    atm.pack();
	    atm.setLocationRelativeTo(null);
	    atm.setVisible(true);*/
		JFrame login = new JFrame("Login");
	    login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    login.setResizable(false);
	    login.setLayout(new BorderLayout());
	    login.add(new Login(), BorderLayout.CENTER);
	    login.pack();
	    login.setLocationRelativeTo(null);
	    login.setVisible(true);
		}

}

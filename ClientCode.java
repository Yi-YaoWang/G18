package Client;

import java.awt.BorderLayout;
import java.util.Scanner;

import javax.swing.JFrame;

public class ClientCode {
	public static void main(String[] argv) {
		String ip = " ";
		Scanner scan = new Scanner(System.in);
		JFrame atm = new JFrame("ATM");
		ATM atm2 = null;
		atm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		atm.setResizable(false);
		atm.setLayout(new BorderLayout());
		atm.add(new ATM(), BorderLayout.CENTER);
		atm.pack();
		atm.setLocationRelativeTo(null);
		atm.setVisible(true);
		// ip = scan.nextLine();
		//new ClientThreadCode(ip, 8000).start();// �إߪ���A�ǤJIP�MPort�ð��浥�ݱ����s�u���ʧ@
	}
}
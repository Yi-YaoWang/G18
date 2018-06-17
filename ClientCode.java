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
		//new ClientThreadCode(ip, 8000).start();// 建立物件，傳入IP和Port並執行等待接受連線的動作
	}
}
package Client;

import java.awt.BorderLayout;
import java.util.Scanner;

import javax.swing.JFrame;

public class ClientCode {
	public static void main(String[] argv) {
		String ip = " ";
		Scanner scan = new Scanner(System.in);
		// ip = scan.nextLine();
		JFrame login = new JFrame("ATM");
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setResizable(false);
		login.setLayout(new BorderLayout());
		login.add(new Login(), BorderLayout.CENTER);
		login.pack();
		login.setLocationRelativeTo(null);
		login.setVisible(true);
		// new ClientThreadCode(ip, 8000).start();//建立物件，傳入IP和Port並執行等待接受連線的動作
	}
}
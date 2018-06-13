package Client;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;

public class ClientThreadCode extends Thread
{
    private Socket m_socket;//�M���A���ݶi��s�u
    
    public ClientThreadCode(String ip, int port)
    {
        try
        {
            m_socket = new Socket(ip, port);//�إ߳s�u�C(ip�����A���ݪ�ip�Aport�����A���ݶ}�Ҫ�port)
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void run()
    {
        try
        {
            if (m_socket != null)//�s�u���\�~�~�򩹤U����
            {
            	System.out.println("�s�u���\");
            	JFrame atm = new JFrame("ATM");
            	atm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	       	atm.setResizable(false);
     	       	atm.setLayout(new BorderLayout());
     	       	atm.add(new ATM(), BorderLayout.CENTER);
     	       	atm.pack();
     	       	atm.setLocationRelativeTo(null);
     	       	atm.setVisible(true);
                
                PrintStream writer = new PrintStream(m_socket.getOutputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
            	
                Scanner scan = new Scanner(System.in);
                
                while(true) {
                	String str = scan.next();
                	writer.println(str);
                	//System.out.println("Server:" + reader.readLine());
                    writer.flush();
                }
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
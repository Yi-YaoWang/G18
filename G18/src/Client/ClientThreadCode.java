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
            	System.out.println("連線成功");
                /*PrintStream writer = new PrintStream(m_socket.getOutputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
            	
                Scanner scan = new Scanner(System.in);
                
                while(true) {
                	String str = scan.next();
                	writer.println(str);
                	//System.out.println("Server:" + reader.readLine());
                    writer.flush();
                }*/
            	PrintStream writer = new PrintStream(m_socket.getOutputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
            
                writer.println(ATM.num1);
                writer.flush();
                //System.out.println("Server:" + reader.readLine());
                System.out.println("金額: "+ATM.num1);
            
                m_socket.close();
            }
        }
        catch (IOException e)
        {
            System.out.println("A");
            System.out.println(e.getMessage());
        }
    }
}
package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientThreadCode extends Thread
{
    private Socket m_socket;//和伺服器端進行連線
    
    public ClientThreadCode(String ip, int port)
    {
        try
        {
            m_socket = new Socket(ip, port);//建立連線。(ip為伺服器端的ip，port為伺服器端開啟的port)
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void run()
    {
        try
        {
            if (m_socket != null)//連線成功才繼續往下執行
            {

                //由於Server端使用 PrintStream 和 BufferedReader 來接收和寄送訊息，所以Client端也要相同
                PrintStream writer = new PrintStream(m_socket.getOutputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
            
            
                Scanner sc=new Scanner(System.in);
                
                while(true) {
                	
                	String str=sc.next();
                	writer.println(str);
                	System.out.println("Server:" + reader.readLine());
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
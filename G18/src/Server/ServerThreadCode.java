package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ServerThreadCode extends Thread
{
    private ServerSocket m_serverSocket;//���A���ݪ�Socket�A����Client�ݪ��s�u
    private Socket m_socket;//Server�MClient�������s�u�q�D
    
    public ServerThreadCode(int port)
    {
        try
        {
            m_serverSocket = new ServerSocket(8000);//�إߦ��A���ݪ�Socket�A�åB�]�wPort
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());//�X�{�ҥ~�ɡA��������ܨҥ~�T��
        }
    }
    
    @Override
    public void run()//�мgThread����run()��k
    {
    	
        try
        {
            System.out.println("等待連線......");
            m_socket = m_serverSocket.accept();//���ݦ��A���ݪ��s�u�A�Y���s�u�h�{���@�����b�o��
            System.out.println("連線成功");
            
            m_serverSocket.close();//�@���s�u�إߦ��\�A�B���ݭn�A������L�s�u�A�h�i����ServerSocket
            
            //�e�X�ݪ��s�g�����M�����ݪ�����Class�ۦP
            //�ϥ�Socket��getInputStream()�MgetOutputStream()�i�汵���M�o�e���
            //�Q�n�g�J�r��i�H�� PrintStream�F�Q�n��U�ذ򥻸�ƫ��A�A�p int, double...���� "��" ��X�A�i�H�� DataOutputStream�F�Q�n���Ӫ��� Serialize�A�h�i�H�� ObjectOutputStream�C
            PrintStream writer;//�b���ڨϥ�PrintStream�N�r��i��s�g�M�e�X
            BufferedReader reader;//�b���ڨϥ�BufferedReader�N��ƶi�汵���MŪ��
            
            writer = new PrintStream(m_socket.getOutputStream());//�ѩ�O�N��ƽs�g�ðe�X�A�ҥH�OOutput

            //BufferedReader�b�غc�ɱ����@��Reader����A�bŪ���зǿ�J��y�ɡA�|�ϥ�InputStreamReader�A���~�ӤFReader���O
            reader = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));//�����Ƕi�Ӫ���ơA�ҥH�OInput
            
            
            Scanner sc=new Scanner(System.in);
           
            while(true) {
            	
            	String str=sc.next();
                writer.println(  str);//�N��ƽs�g�i��y��
                System.out.println(reader.readLine());
                writer.flush();//�M�Žw�İϨðe�X���
            
            
           
           
        	
        }
            
           // m_socket.close();//�����s�u
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());//�X�{�ҥ~�ɡA��������ܨҥ~�T��(�s�u���\���|�X�{�ҥ~)
        }
    }
}
package Client;

import java.util.Scanner;

public class ClientCode
{
    public static void main(String[] argv)
    {	
    	String ip = " ";
    	Scanner scan = new Scanner(System.in);
    	ip = scan.nextLine();
        new ClientThreadCode(ip, 8000).start();//�إߪ���A�ǤJIP�MPort�ð��浥�ݱ����s�u���ʧ@
    }
}
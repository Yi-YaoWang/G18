package Client;

import java.util.Scanner;

public class ClientCode
{
    public static void main(String[] argv)
    {	
    	String ip = " ";
    	Scanner scan = new Scanner(System.in);
    	ip = scan.nextLine();
        new ClientThreadCode(ip, 8000).start();//建立物件，傳入IP和Port並執行等待接受連線的動作
    }
}

package nätverksprogramering;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class DatagramSender {
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException, InterruptedException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    InetAddress toAdr = InetAddress.getByName("172.20.201.52");
    int toPort = 55555;
    DatagramSocket socket = new DatagramSocket();
    String message;
    System.out.println("?: ");
    
    ArrayList<String> citat = new ArrayList();
    citat.add("Ping");
    citat.add("pong");
    citat.add("dong");
    
    
    while(true){
        for (int i = 0 ;i < citat.size(); i++){
       // if (message.equals("byte"))  System.exit(0);
        message = citat.get(i); 
        byte[] data = message.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toPort);
        socket.send(packet);
        System.out.println(message);
        Thread.sleep(3000);
        }

    }
  } 
}

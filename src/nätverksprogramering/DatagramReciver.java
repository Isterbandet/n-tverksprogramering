
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

public class DatagramReciver {
public static void main(String[] args) throws UnknownHostException, SocketException, IOException{
 
    int minPort = 55555;
    DatagramSocket socket = new DatagramSocket(minPort);
    byte[] data = new byte[265];
    while(true){
        DatagramPacket packet = new DatagramPacket(data, data.length);
        socket.receive(packet);
        System.out.println("Medelande från" +packet.getAddress().getHostAddress());
        String message = new String(packet.getData(), 0, packet.getLength());
        System.out.println(message);
    }
  } 
}
package pkg11_socketudp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class JavaRecieveUDP {
    public static void main(String[] args) {
        try{
            DatagramSocket sock = new DatagramSocket(7777);
            byte[] buffer = new byte[65536];
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
            
            echo("Server socket created. Waiting for incoming data...");
            
            while(true){
                sock.receive(incoming);
                byte[] data = incoming.getData();
                String s = new String(data, 0, incoming.getLength());
                
                echo(incoming.getAddress().getHostAddress() + " : " + incoming.getPort() + " - " + s);
                
                s = "OK : " + s;
                DatagramPacket dp = new DatagramPacket(s.getBytes(), s.getBytes().length, incoming.getAddress(), incoming.getPort());
                sock.send(dp);
            }
        }catch(Exception e){
            
        }
    }

    private static void echo(String text) {
        System.out.println(text);
    }
}

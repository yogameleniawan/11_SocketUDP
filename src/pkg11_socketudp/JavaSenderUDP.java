package pkg11_socketudp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class JavaSenderUDP {

    public static void main(String[] args) throws Exception, SocketException {
            
            DatagramSocket sock = new DatagramSocket();
            InetAddress host = InetAddress.getByName("localhost");
            int port = 7777;
            BufferedReader cin= new BufferedReader ( new InputStreamReader
(System.in));
            while (true) {
                echo("Enter message to send : ");
                String s = (String) cin.readLine();
                byte[] b = s.getBytes();
                DatagramPacket dp = new DatagramPacket(b, b.length, host, port);
                sock.send(dp);
                byte[] buffer = new byte[65536];
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
                sock.receive(reply);
                byte[] data = reply.getData();
                s = new String(data, 0, reply.getLength());
                echo(reply.getAddress().getHostAddress() + " : " + reply.getPort() + " - " + s);
            }
        }

    private static void echo(String text) {
        System.out.println(text);
    }
    
}

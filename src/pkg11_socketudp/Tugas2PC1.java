package pkg11_socketudp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Tugas2PC1 {

    public static void main(String[] args) throws IOException {
        DatagramSocket dreceive = new DatagramSocket(10086);
        DatagramSocket dread = new DatagramSocket();
        byte buffer[] = new byte[1024];
        InetAddress address = InetAddress.getByName("192.168.233.135");
        int port = 10086;
        BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Command (chat/read): ");
            String str = dis.readLine();
            if ((str == null || str.equals("end"))) {
                break;
            } else if (str.equals("chat")) {
                System.out.print("Inputan Server: ");
                str = dis.readLine();
                buffer = str.getBytes();
                DatagramPacket dp = new DatagramPacket(buffer, str.length(), address, port);
                dread.send(dp);
            } else if (str.equals("read")) {
                DatagramPacket p = new DatagramPacket(buffer,
                        buffer.length);
                dreceive.receive(p);
                String ps = new String(p.getData(), 0, p.getLength());
                System.out.println("From Server: " + ps);
            }
        }

    }
}

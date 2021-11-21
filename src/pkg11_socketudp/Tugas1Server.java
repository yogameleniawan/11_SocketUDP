package pkg11_socketudp;

import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Tugas1Server {
    public static DatagramSocket ds;
    public static int clientport = 800, serverport = 900;

    public static void main(String args[]) throws Exception {
        byte b[] = new byte[1024];
        FileInputStream f = new FileInputStream("D:/input-udp.txt");
        DatagramSocket dsoc = new DatagramSocket(2000);
        int i = 0;
        while (f.available() != 0) {
            b[i] = (byte) f.read();
            i++;
        }
        f.close();
        dsoc.send(new DatagramPacket(b, i, InetAddress.getLocalHost(), 1000));
    }
}

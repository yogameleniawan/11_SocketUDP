package pkg11_socketudp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import static javax.swing.JOptionPane.showMessageDialog;

public class Tugas1Client {
    public static DatagramSocket d;
    public static byte buffer[] = new byte[1024];
    public static int clientport = 800, serverport = 900;

    public static void main(String args[]) throws IOException {
        byte b[] = new byte[3072];
        DatagramSocket dsoc = new DatagramSocket(1000);
        FileOutputStream f = new FileOutputStream("D:/output-udp.txt");
        while (true) {
            DatagramPacket dp = new DatagramPacket(b, b.length);
            dsoc.receive(dp);
            System.out.println(new String(dp.getData(), 0, dp.getLength()));
            f.write(dp.getData());
            showMessageDialog(null, "File berhasil ditulis");
        }
    }
}

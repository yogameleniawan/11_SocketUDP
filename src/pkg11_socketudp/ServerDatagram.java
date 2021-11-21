package pkg11_socketudp;

import java.net.*;
import java.io.*;

class ServerDatagram {

    public static DatagramSocket ds;
    public static int clientport = 800, serverport = 900;

    public static void main(String args[]) throws Exception {
        byte buffer[] = new byte[1024];
        ds = new DatagramSocket(serverport);
        BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Server menunggu input");
        InetAddress i = InetAddress.getByName("Localhost");
        while (true) {
            System.out.print("Inputan Server: ");
            String str = dis.readLine();
            if ((str == null || str.equals("end"))) {
                break;
            }
            buffer = str.getBytes();
            ds.send(new DatagramPacket(buffer, str.length(), i,
                    clientport));
        }
    }
}

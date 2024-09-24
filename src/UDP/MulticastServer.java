/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author DELL
 */
public class MulticastServer {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, InterruptedException{
        DatagramSocket server = new DatagramSocket();
        System.out.println("message server is running ...");
        
        int iFrame = 0;
        while(true){
            byte[] data = ("data frame" + iFrame).getBytes();
            DatagramPacket dpFrame = new DatagramPacket(
                                data, data.length, 
                                InetAddress.getByName("224.2.2.3"),1107);
            server.send(dpFrame);
            iFrame++;
            System.out.println("freme: " + iFrame);
            Thread.sleep(2000);
        }
    }
}

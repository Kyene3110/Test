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

/**
 *
 * @author DELL
 */
public class UDPClient {
    public static void main (String[] args) throws SocketException, IOException{
        DatagramSocket client = new DatagramSocket();
        
        String str = "hello from client!";
        byte[] data = str.getBytes();
        DatagramPacket dpReq = new DatagramPacket(
                                data, data.length, InetAddress.getByName("localhost"),1107);
        
        client.send(dpReq);
        System.out.println("Send request ");
        
        byte[] buf = new byte[1024];
        
        DatagramPacket dpRes = new DatagramPacket(buf, buf.length);
        client.receive(dpRes);
        System.out.println("reversed str: "+ new String(dpRes.getData()).trim());
    }
}

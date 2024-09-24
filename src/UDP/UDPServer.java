/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author DELL
 */
public class UDPServer {
    public static void main (String[] args) throws SocketException, IOException{
        DatagramSocket server = new DatagramSocket(1107);
        System.out.println("UDP string server is running ...");
        while(true){
            byte[] buf = new byte[1024];
            
            //receive request package
            DatagramPacket dpReq = new DatagramPacket(buf, buf.length);
            server.receive(dpReq);
            String strReq = new String(dpReq.getData()).trim();
            System.out.println("str req: " + strReq);
            
            // reverse string & send res package
            String strRes = new StringBuilder(strReq).reverse().toString();
            byte[] data = strRes.getBytes();
            DatagramPacket dqRes = new DatagramPacket(data, data.length,
                                    dpReq.getAddress(), dpReq.getPort());
            server.send(dqRes);
            System.out.println("reverse str: "+ strRes);
            
            
        }
    }
}

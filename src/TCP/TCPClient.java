/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

/**
 *
 * @author DELL
 */
public class TCPClient {
    public static void main(String[] args) throws IOException, ConnectException{
        Socket client = new Socket("10.21.72.74",8387);
        System.out.println(client);
        
        // 1. gui ma sv 
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("B21DCCN" + Math.round(Math.random()*1000));
        // 2. nhan ve hai so nguyen
        DataInputStream dis = new DataInputStream(client.getInputStream());
        int a = dis.readInt();
        int b = dis.readInt();
        System.out.format("a: %d, b: %d \n", a, b);
//        // 3. tinh tong va gui len
        dos.writeShort(a+b);
//        
//        //4
        dis.close();
        dos.close();
        client.close();
    }
}

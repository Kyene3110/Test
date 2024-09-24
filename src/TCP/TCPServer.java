/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author DELL
 */
public class TCPServer {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(1109);
        System.out.println("server in running ...");
        while(true){
            Socket conn = server.accept();
            System.out.println(conn);
            
            //1
            DataInputStream dis = new DataInputStream(conn.getInputStream());
            String sCode = dis.readUTF();
            System.out.println("request from: "+ sCode);
//            2
            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            dos.writeInt((int)Math.round(Math.random()*100));
            dos.writeInt((int)Math.round(Math.random()*100));
            //3
            int sum = dis.readShort();
            System.out.println("sum: "+ sum);
            //4
            dos.close();
            dis.close();
            conn.close();
        }
    }
}

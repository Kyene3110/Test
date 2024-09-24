/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author DELL
 */
public class HTTPServer {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Web Server is running ......");
        while (true){
            Socket req = server.accept();
            // receive request
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(req.getInputStream()));
            String line = br.readLine();
            while(line!=null && !line.isEmpty()){
                System.out.println(line);
                line = br.readLine();
            }
            
            
            //send response
            String strResHeader = "HTTP/1.1 200 OK \r\n"
                    + "\r\n";
            
            String strRes = "Server is busy. Try again later.";
            OutputStream os = req.getOutputStream();
            os.write((strResHeader+strRes).getBytes("UTF-8"));
            
            
           br.close();
           os.close();
           req.close();
        }
    }
}

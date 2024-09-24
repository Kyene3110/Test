/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HTTP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author DELL
 */
public class HTTPClient {
    public static void main (String[] args) throws IOException{
        Socket client = new Socket("www.google.com", 80);        
        System.out.println(client);
        
        //send http request
        String strReq = "GET / HTTP/1.1 \r\n"
                + "Host: www.google.com \r\n"
                + "User-Agent: HTTPTool 1.0 \r\n"
                + "Accept: text/* \r\n"
                + "\r\n";
        
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(client.getOutputStream()));
        
        bw.write(strReq);
        bw.flush();
        
        // receive http response
        InputStream input = client.getInputStream();
        byte[] data = new byte[1024];
        int NoOfByte = 0;
        while ((NoOfByte = input.read(data)) != -1){
            System.out.println(new String(data, 0, NoOfByte, "UTF-8"));
        }
        
        
//        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
//        
//        String line = br.readLine();
//        while(line != null && !line.isEmpty()){
//            System.out.println(line);
//            line = br.readLine();
//        }
        
        
        bw.close();
//        br.close();
        input.close();
        client.close();
    }
}

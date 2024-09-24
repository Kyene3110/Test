/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 *
 * @author DELL
 */
public class NIC {
    public static void main(String[] args) throws SocketException{
        Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();
        while(nifs.hasMoreElements()){
            NetworkInterface nif = nifs.nextElement();
            if (nif.isUp()){
                System.out.println(nif);
            }
            Enumeration<InetAddress> ias = nif.getInetAddresses();
            while(ias.hasMoreElements()){
                InetAddress ia = ias.nextElement();
            }
            
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jennyserver;

import Database.Database;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jenny
 */
public class JennyServer {

    /**
     * @param args the command line arguments
     */
    ServerSocket serverSocket = null;
    
     public static ArrayList<Integer> values = new ArrayList<>();
    int i=0;
     

    public JennyServer() {
        try {
            serverSocket = new ServerSocket(8000);
          //sock=new Socket("192.168.0.16",8000);
        } catch (IOException e) {
            System.err.println(e);
            System.exit(0);
        }

    }

    public void runServer() throws IOException {
      //  byte[] akiloByte = new byte[1024];
        
            while (true) {               
                System.out.println("connecting to client.......");
                Socket socket = serverSocket.accept();                
                String a=socket.getLocalAddress().getHostName();                
                System.out.println("Client connected from:" + a);             
                              
                
                //add to matlab-------------------------------------------------------
                //DataOutputStream output=new DataOutputStream(socket.getOutputStream());
                
                Mobil mobil=new Mobil(socket);
                new Thread(mobil).start();
                
              
                 if(a.equals("127.0.0.1")){
                
                  Matlab mat=new Matlab(socket);
                  new Thread(mat).start();
                    
                
            }
        }
    }
    

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        JennyServer jenny = new JennyServer();
        jenny.runServer();
    }
   

}

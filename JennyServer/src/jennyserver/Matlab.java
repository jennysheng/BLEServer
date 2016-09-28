/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jennyserver;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jenny
 */
public class Matlab implements Runnable{
    Socket sock;
    DataOutputStream output=null;
    
    public Matlab(Socket sock){
        this.sock=sock;
    }

    @Override
    public void run() {
        try {
            //add to matlab-------------------------------------------------------
           output=new DataOutputStream(sock.getOutputStream());
            while(true){
                for(int i=0; i<JennyServer.values.size();i++){
                output.writeInt(JennyServer.values.get(i));}
            }
        } catch (IOException ex) {
            Logger.getLogger(Matlab.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

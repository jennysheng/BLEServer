/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jennyserver;

import Database.Database;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jennyserver.JennyServer.values;

/**
 *
 * @author jenny
 */
public class Mobil implements Runnable{
    Socket socket;
    int value=0;
    DataInputStream input;
    public Mobil(Socket socket){
        this.socket=socket;        
    }

    @Override
    public void run() {
       
        try {
            input = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Mobil.class.getName()).log(Level.SEVERE, null, ex);
        }
          while (true) {
            try {
               
                
               // Database database=new Database("adc","root","3306");
                value=input.readInt();
                values.add(value);
                //database.addADCValueToDatabase(value);
                //database.checkValues();
                System.out.println(value);
            } catch (IOException ex) {
                Logger.getLogger(Mobil.class.getName()).log(Level.SEVERE, null, ex);
            }
                   
            }
        
    
    
    
    }
    
}

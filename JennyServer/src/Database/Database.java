/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jenny
 */
public class Database {
     private final String password;
    private final String userName;
    private final String databaseName;
    private final Statement stmt = null;
    private final ResultSet rs = null;
    private PreparedStatement pstmt = null;

    public Database(String databaseName, String userName, String password) {
        this.databaseName = databaseName;
        this.userName = userName;
        this.password = password;
    }
    
    
    public Connection setUpConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String URL = "jdbc:mysql://localhost:3306/" + databaseName + "?user=" + userName + "&password=" + password + "";
            Connection c = DriverManager.getConnection(URL);
            return c;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public void addADCValueToDatabase(int adc) {

        try {
            Connection c = setUpConnection();
            String query = "INSERT INTO adc(adc)" + "VALUES (?)";
            pstmt = c.prepareStatement(query);           
            pstmt.setInt(1, adc);          
            int affected=pstmt.executeUpdate();
            System.out.println(">> Affected rows: " + affected);
            
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Failed to execute INSERT. " + e.getMessage());
        } finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      
     public void checkValues() {
        try {
            Connection con = setUpConnection();
            try {

                PreparedStatement statement = con.prepareStatement("SELECT adc FROM adc");
                

                //Creating Variable to execute query
                ResultSet result = statement.executeQuery();
                

                while (result.next() ) {
                    System.out.println("---");
                    System.out.println("weight:    " + result.getString(1));// databasecolumn
                    
                   
                }

            } finally {
                con.close();
            }

        } catch (SQLException ex) {
            System.out.println("Failed to execute SELECT. " + ex.getMessage());
        }
     
    }
}

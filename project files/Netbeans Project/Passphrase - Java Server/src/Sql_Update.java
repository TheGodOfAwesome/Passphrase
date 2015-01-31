
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kuz
 */
public class Sql_Update {

   

    Sql_Update(String Passphrase) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
        try{
            Class.forName("com.mysql.jdbc.Driver");
             
             Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pass", "root", "");
         //   Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/travelshop","root","");
             System.out.println("Connected");
             Statement stmt = (Statement) con.createStatement();
             
        //     String Passphrase = "ftg5tg5tfvfd4d";
             String Pass_ID = "1010";
             String insert = "UPDATE passtb SET passphrase = '"+Passphrase+"' WHERE pass_id=1010;";
             

             stmt.executeUpdate(insert);
             
        }catch(SQLException e){
             System.out.println(e.getSQLState());
             e.getMessage();
             e.getErrorCode();
             e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sql_Update.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    // public Sql_Update(String Passphrase){
        
    
    // }
}

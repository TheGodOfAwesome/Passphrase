/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
/**
 * The class extends the Thread class so we can receive and send messages at the same time
 */
/**
 *
 * @author Kuz
 */
public class TCPServer extends Thread {
    public static final int SERVERPORT = 4444;
    public static String key = "1234567891234567";
    public static String Passphrase; 
    public static String Time_Left;
    public static int Time_left;

    private TCPServer() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public String EncryptString(String enc) {
    
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try {
                     String pass = MCrypt.bytesToHex( mcrypt.encrypt(enc) );
                 } catch (Exception ex) {
                     Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
               }
       return pass;
    }
    
    
    private boolean running = false;
    private PrintWriter mOut;
    private OnMessageReceived messageListener;
    private static int cnt;
    MCrypt mcrypt = new MCrypt();
    
    //getNext variables
    public static final int MIN_LENGTH=12;
    protected static java.util.Random r=new java.util.Random();
    protected static char[] goodChar={'a','b','c','d','e','f','g','h','j','k','m','n','p','q','r','s','t','q','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','M','N','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9','+','-','*','/','!','#','$','%','?','@'};
    //***********************************************************************//
    
    //passgen variables
    private static final String dCase = "abcdefghijklmnopqrstuvwxyz";
    private static final String uCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String sChar = "!@#$%&*-+=";
    private static final String intChar = "0123456789";
    private static Random ra = new Random();
    private static String pass = "";   
    //**********************************************************************//
    
    //generateRandomString variable
    private static Random random = new Random((new Date()).getTime());
    //**********************************************************************//
    
    //randomNumberGenerator variable
    private static final String ALPHA_NUMERIC_STRING = "123456";
    //**********************************************************************//
    
    public static void main(String[] args) {
 
        //opens the window where the messages will be received and sent
        ServerBoard frame = new ServerBoard();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
        ActionListener actListner = new ActionListener() {
	 
	@Override	 
        public void actionPerformed(ActionEvent event) {
	    
            String Text = "The Time Left To Next Passphrase is ";
            String EndText = " secs.";
            String choose = "1";
            int selectioncrit = 1;
               
	    cnt += 1;
	    Time_left = 60 - cnt;
            Time_Left = Text + Time_left + EndText;
	    System.out.println("Counter = "+cnt);
            if (cnt == 60){
             choose = randomNumberGenerator(selectioncrit);
             System.out.println(choose);
             if (choose.equals("1")){   
             System.out.println("One Minute");
             System.out.println("RSG 1");
             Passphrase = getNext();
             System.out.println("New Passphrase::"+Passphrase);
             
                
             
         try{
            Class.forName("com.mysql.jdbc.Driver");
             
             Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pass", "root", "");
             System.out.println("Connected");
             Statement stmt = (Statement) con.createStatement();
             
             System.out.println(TCPServer.encrypt(Passphrase, key));
             Passphrase = TCPServer.encrypt(Passphrase, key);
             String insert = "UPDATE passtb SET passphrase = '"+Passphrase+"' WHERE pass_id=1010;";
             

             stmt.executeUpdate(insert);
             
        }catch(SQLException e){
             System.out.println(e.getSQLState());
             e.getMessage();
             e.getErrorCode();
             e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sql_Update.class.getName()).log(Level.SEVERE, null, ex);
        }        catch (Exception ex) {
                     Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
                 }
             
             
             

             cnt = 0;
             }if (choose.equals("2")){
                 while (pass.length () != MIN_LENGTH){
                    int rPick = ra.nextInt(4);
                    if (rPick == 0){
                        int spot = ra.nextInt(25);
                        pass += dCase.charAt(spot);
                    }  else if (rPick == 1) {
                        int spot = ra.nextInt (25);
                        pass += uCase.charAt(spot);
                    }  else if (rPick == 2) {
                        int spot = ra.nextInt (7);
                        pass += sChar.charAt(spot);
                    }  else if (rPick == 3){
                        int spot = ra.nextInt (9);
                        pass += intChar.charAt (spot);
                    }
                 }
                 System.out.println("One Minute");
                 System.out.println("RSG 2");
                 Passphrase =  pass;
                 System.out.println("New Passphrase::"+Passphrase);
                 
                 
                 
         try{
            Class.forName("com.mysql.jdbc.Driver");
             
             Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pass", "root", "");
             System.out.println("Connected");
             Statement stmt = (Statement) con.createStatement();
             
             System.out.println(TCPServer.encrypt(Passphrase, key));
             Passphrase = TCPServer.encrypt(Passphrase, key);
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
                 
                 
                 
 
                 cnt = 0;
             }if (choose.equals("3")){
                 System.out.println("One Minute");
                 System.out.println("RSG 3");
                 Passphrase = generateSessionKey(MIN_LENGTH);
                 System.out.println("New Passphrase::"+Passphrase);
                 
                 
                 
        try{
            Class.forName("com.mysql.jdbc.Driver");
             
             Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pass", "root", "");
             System.out.println("Connected");
             Statement stmt = (Statement) con.createStatement();
             
             System.out.println(TCPServer.encrypt(Passphrase, key));
             Passphrase = TCPServer.encrypt(Passphrase, key);
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
                 
                 
                 
                 cnt = 0; 
             }if (choose.equals("4")){
                 System.out.println("One Minute");
                 System.out.println("RSG 4");
                 Passphrase = generateRandomString(MIN_LENGTH);
                 System.out.println("New Passphrase::"+Passphrase);
                 
                 
                 
         try{
            Class.forName("com.mysql.jdbc.Driver");
             
             Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pass", "root", "");
             System.out.println("Connected");
             Statement stmt = (Statement) con.createStatement();
             
             System.out.println(TCPServer.encrypt(Passphrase, key));
             Passphrase = TCPServer.encrypt(Passphrase, key);
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
                 
                 
                 
                 cnt = 0; 
             }if (choose.equals("5")){
                 System.out.println("One Minute");
                 System.out.println("RSG 5");
                 Passphrase = generateString(1,MIN_LENGTH);
                 System.out.println("New Passphrase::"+Passphrase);
                 
                 
                 
         try{
            Class.forName("com.mysql.jdbc.Driver");
             
             Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pass", "root", "");
             System.out.println("Connected");
             Statement stmt = (Statement) con.createStatement();
             
             System.out.println(TCPServer.encrypt(Passphrase, key));
             Passphrase = TCPServer.encrypt(Passphrase, key);
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
                 
                 
                 
                 cnt = 0; 
             }if (choose.equals("6")){
                 System.out.println("One Minute");
                 System.out.println("RSG 6");
                 Passphrase = RandomAlphaNumericString(MIN_LENGTH);
                 System.out.println("New Passphrase::"+Passphrase);
                 
                 
                 
         try{
            Class.forName("com.mysql.jdbc.Driver");
             
             Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pass", "root", "");
             System.out.println("Connected");
             Statement stmt = (Statement) con.createStatement();
             
             System.out.println(TCPServer.encrypt(Passphrase, key));
             Passphrase = TCPServer.encrypt(Passphrase, key);
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
                 
                 
                 
                 cnt = 0; 
             }
             }
	 
	}

           private String getNext() {
              StringBuffer sb=new StringBuffer();
           for(int i=0;i<MIN_LENGTH;i++){
               sb.append(goodChar[r.nextInt(goodChar.length)]);
           }
           return sb.toString();}
           
           public String generateSessionKey(int length){
           String alphabet = 
           new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&*-+="); //9
           int n = alphabet.length(); //10
           String result = new String(); 
           Random r = new Random(); //11
            for (int i=0; i<length; i++) //12
             result = result + alphabet.charAt(r.nextInt(n)); //13
            return result;
          }
    
          public String generateRandomString(int length) {
          char[] values = {'a','b','c','d','e','f','g','h','j','k','m','n','p','q','r','s','t','q','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','M','N','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9','+','-','*','/','!','#','$','%','?','@'};

          String out = "";

           for (int i=0;i<length;i++) {
                int idx=random.nextInt(values.length);
                out += values[idx];
           }
           return out;
          }
          
          public String generateString(int n,int length){
          String str1="\0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&*-+=";
          StringBuilder sb=new StringBuilder(length);
          Random r = new Random();

           for(int i=0;i<n;i++)
           {
               for(int j=0;j<length;j++)
               {
                sb.append(str1.charAt(r.nextInt(str1.length())));
               }
            
           }  
            return sb.toString();
          }
          
          public String RandomAlphaNumericString(int size){
          String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&*-+=";
          String ret = "";
          int length = chars.length();
           for (int i = 0; i < size; i ++){
            ret += chars.split("")[ (int) (Math.random() * (length - 1)) ];
           }
          return ret;
          }
          
          public String randomNumberGenerator(int count) {
          StringBuilder builder = new StringBuilder();
          while (count-- != 0) {
           int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
           builder.append(ALPHA_NUMERIC_STRING.charAt(character));
          }
          return builder.toString();
          }

          
           
    };
 
         javax.swing.Timer timer = new javax.swing.Timer(1000, actListner);
	 
	  timer.start();
        
    }
 
    /**
     * Constructor of the class
     * @param messageListener listens for the messages
     */
    public TCPServer(OnMessageReceived messageListener) {
        this.messageListener = messageListener;
    }
 
    /**
     * Method to send the messages from server to client
     * @param message the message sent by the server
     */
    public void sendMessage(String message){
        String encrypted = null;
        try{
        encrypted = MCrypt.bytesToHex( mcrypt.encrypt(message) );
        System.out.println("Normal Text ::" +message+ " \n Encrypted Value :: "+encrypted );
        }catch(Exception e){
	      System.out.println(e.toString());  
        }
        if (mOut != null && !mOut.checkError()) {
            mOut.println(encrypted);
            mOut.flush();
        }
    }
 
    @Override
    public void run() {
        super.run();
        String decrypted = null;
        running = true;
 
        try {
            System.out.println("S: Connecting...");
 
            //create a server socket. A server socket waits for requests to come in over the network.
            ServerSocket serverSocket = new ServerSocket(SERVERPORT);
 
            //create client socket... the method accept() listens for a connection to be made to this socket and accepts it.
            Socket client = serverSocket.accept();
            System.out.println("S: Receiving...");
 
            
            
            try {
 
                //sends the message to the client
                mOut = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
 
                //read the message received from client
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
 
                //in this while we wait to receive messages from client (it's an infinite loop)
                //this while it's like a listener for messages
                while (running) {
                    String message = in.readLine();
                try{
                    decrypted = new String( mcrypt.decrypt( message ) );
                    System.out.println("Encrypted Message  ::"+message +" \n Decrypted Value :: "+decrypted);
               }catch(Exception e){
	            System.out.println(e.toString());  
               }
      
                    if (message != null && messageListener != null) {
                        //call the method messageReceived from ServerBoard class
                        messageListener.messageReceived(decrypted);
                   //    String encrypted = null;
                   //    String Test = "Password";
                   // if (decrypted == "Requesting Passphrase. . .") {
                        //send the client the passphrase reply
                   //    System.out.println("Hello World");
                   //    encrypted = MCrypt.bytesToHex( mcrypt.encrypt(Test) );
                   //    System.out.println("Normal Text ::"+Test +" \n Encrypted Value :: "+encrypted );
                   //    if (mOut != null && !mOut.checkError()) {
                   //    mOut.println(encrypted);
                   //    mOut.flush();  
                   //    }else{
                   //     System.out.println("Goodbye World");    
                   //    }
                   //}
                    }
                }
 
            } catch (Exception e) {
                System.out.println("S: Error");
                e.printStackTrace();
            } finally {
                client.close();
                System.out.println("S: Done.");
            }
 
        } catch (Exception e) {
            System.out.println("S: Error");
            e.printStackTrace();
        }
 
    }
 
    
    public static String encrypt(String input, String key){
	  byte[] crypted = null;
	  try{
	    SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
	      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	      cipher.init(Cipher.ENCRYPT_MODE, skey);
	      crypted = cipher.doFinal(input.getBytes());
	    }catch(Exception e){
	    	System.out.println(e.toString());
	    }
	    return new String(Base64.encodeBase64(crypted));
	}

	public static String decrypt(String input, String key){
	    byte[] output = null;
	    try{
	      SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
	      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	      cipher.init(Cipher.DECRYPT_MODE, skey);
	      output = cipher.doFinal(Base64.decodeBase64(input));
	    }catch(Exception e){
	      System.out.println(e.toString());
	    }
	    return new String(output);
	}
    
    //Declare the interface. The method messageReceived(String message) must be implemented in the ServerBoard
    //class at on startServer button click
    public interface OnMessageReceived {
        public void messageReceived(String message);
    }
    
 
}

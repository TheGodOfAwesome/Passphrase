/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;
 
/**
 *
 * @author Kuz
 */
public class ServerBoard extends JFrame {
    private JTextArea messagesArea;
    private JButton sendButton;
    private JTextField message;
    private JButton startServer;
    private TCPServer mServer;
    private PrintWriter mOut;
    MCrypt mcrypt = new MCrypt();
    
    //private static int cnt; 
    //public static final int MIN_LENGTH=9;
    //protected static java.util.Random r=new java.util.Random();
    //protected static char[] goodChar={'a','b','c','d','e','f','g','h','j','k','m','n','p','q','r','s','t','q','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','M','N','P','Q','R','S','T','U','V','W','X','Y','Z','2','3','4','5','6','7','8','9','+','-','@'};

    //public static String getNext(){
    //       StringBuffer sb=new StringBuffer();
    //       for(int i=0;i<MIN_LENGTH;i++){
    //           sb.append(goodChar[r.nextInt(goodChar.length)]);
    //       }
    //       return sb.toString();
    //   }
    
   
    public ServerBoard() {
 
        super("ServerBoard");
 
        JPanel panelFields = new JPanel();
        panelFields.setLayout(new BoxLayout(panelFields,BoxLayout.X_AXIS));
 
        JPanel panelFields2 = new JPanel();
        panelFields2.setLayout(new BoxLayout(panelFields2,BoxLayout.X_AXIS));
 
        //here we will have the text messages screen
        messagesArea = new JTextArea();
        messagesArea.setColumns(30);
        messagesArea.setRows(10);
        messagesArea.setEditable(false);
 
        sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get the message from the text view
                String messageText = message.getText();
                // add message to the message area
                messagesArea.append("\n" + messageText);
                // send the message to the client
                mServer.sendMessage(messageText);
                // clear text
                message.setText("");
            }
        });
 
        startServer = new JButton("Start");
        startServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // disable the start button
                startServer.setEnabled(false);
 
                //creates the object OnMessageReceived asked by the TCPServer constructor
                mServer = new TCPServer(new TCPServer.OnMessageReceived() {
                    @Override
                    //this method declared in the interface from TCPServer class is implemented here
                    //this method is actually a callback method, because it will run every time when it will be called from
                    //TCPServer class (at while)
                    public void messageReceived(String message) {
                        //messagesArea.append("\n "+message);
                         //if (message == " Requesting Passphrase. . ." ){
                         //     String encrypted = null;
                          //    String Test = "Password";
                          //    System.out.println("Hello World");
                          //   try{
                          //        encrypted = MCrypt.bytesToHex( mcrypt.encrypt(Test) );
                          //        System.out.println("Normal Text ::"+Test +" \n Encrypted Value :: "+encrypted );
                          //       }catch(Exception e){
	                  //        System.out.println(e.toString());  
                          //       }
                         //if (mOut != null && !mOut.checkError()) {
                         //mOut.println(encrypted);
                         //mOut.flush();
                         //}
                       //}
                       messagesArea.append("\n "+message);
                       String Try = "Requesting Passphrase. . .";
                       
                       if ( message.equals(Try)){
                         // send the reply to the client
                         
                          mServer.sendMessage(TCPServer.Passphrase);
                          mServer.sendMessage(TCPServer.Time_Left);
                           System.out.println("Passphrase Sent!!!");
                           System.out.println("Verified User");
                        }else{
                         
                           System.out.println("Unverified User");
                       }
                       
                    
           
                    }
                });
                mServer.start();
 
            }
        });
 
        //the box where the user enters the text (EditText is called in Android)
        message = new JTextField();
        message.setSize(200, 20);
 
        //add the buttons and the text fields to the panel
        panelFields.add(messagesArea);
        panelFields.add(startServer);
 
        panelFields2.add(message);
        panelFields2.add(sendButton);
 
        getContentPane().add(panelFields);
        getContentPane().add(panelFields2);
 
        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
 
        setSize(300, 170);
        setVisible(true);
    }
    
    
            
  }
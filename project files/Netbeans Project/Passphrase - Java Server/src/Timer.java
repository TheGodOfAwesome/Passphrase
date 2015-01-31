/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author Kuz
 */
public class Timer extends TimerTask{
    
   private static int cnt; 
   public static final int MIN_LENGTH=9;
   protected static java.util.Random r=new java.util.Random();
   protected static char[] goodChar={'a','b','c','d','e','f','g','h','j','k','m','n','p','q','r','s','t','q','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','M','N','P','Q','R','S','T','U','V','W','X','Y','Z','2','3','4','5','6','7','8','9','+','-','@'};
   String Passphrase;

    public static String getNext(){
           StringBuffer sb=new StringBuffer();
           for(int i=0;i<MIN_LENGTH;i++){
               sb.append(goodChar[r.nextInt(goodChar.length)]);
           }
           return sb.toString();
       }

    Timer(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
public void run() {
System.out.println("Timer task executed.");
Passphrase = getNext();
}
}
class TTest {
public static void main(String args[]) {
//MyTimerTask myTask = new MyTimerTask();
Timer myTimer = new Timer( 50, 5000);;
/* Set an initial delay of 1 second,
then repeat every half second.
*/
//myTimer.schedule(myTask, 1000, 500);
try {
Thread.sleep(5000);
} catch (InterruptedException exc) {}
myTimer.cancel(); 
}     
}

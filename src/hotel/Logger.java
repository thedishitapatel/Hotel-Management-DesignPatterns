
package hotel;

/**
 *
 * @author John and Dishita
 */
public class Logger {

    //existing class for ADAPTER pattern
    
    public Logger() {
    }
    
    public void logMsg(String msg){
        System.out.println("----------------------------------------------------");
        System.out.println("NEW LOG ENTRY:");
        System.out.println(msg);
        System.out.println("----------------------------------------------------");
                
    }
}

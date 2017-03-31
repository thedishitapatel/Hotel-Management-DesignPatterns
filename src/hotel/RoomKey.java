
package hotel;

/**
 *
 * @author John and Dishita
 */
public class RoomKey {
    
    //Fields
    String fName;
    String lName;
    int roomNum;
    FlyweightIntr objFW;
    
    //Constructor
    public RoomKey(String fn, String ln, int t, FlyweightIntr fw) {
        fName = fn;
        lName = ln;
        roomNum = t;
        objFW = fw;
    }
    
    //Print RoomKey Data method
    public void print() {
        System.out.println("");
        System.out.println("");
        System.out.println("- - - - - - - - ROOM KEY - - - - - - -");
        System.out.println("Issued to:\t\t" + fName + " " + lName);
        System.out.println("Hotel ID# and Name:\t" + objFW.getHotelId() + " - " + objFW.getHotelName());
        System.out.println("Room Number:\t\t" + roomNum);
        System.out.println("Address:\t\t" + objFW.getAddress() + "-" + objFW.getCity() + "-" 
                + objFW.getState() + "-" +  objFW.getZip());
        System.out.println(" - - - - - - - - - - - - - - - - - - -");  
        System.out.println("");
        System.out.println("");
    }

    //Returns Guest's Full Name
    public String getName() {
        return fName + " " + lName;
    }

    //Getters
    public int roomNum() {
        return roomNum;
    }

    public FlyweightIntr getObjFW() {
        return objFW;
    }
    
    
    
}


package hotel;

import java.util.List;

/**
 *
 * @author John and Dishita
 */
public class Facade {
    
    //Fields
    FlyweightFactory ff;
    Hotel[] hotels;
    LogInterface log;

    //Constructor
    public Facade() {
        this.hotels = new Hotel[] { 
            new Hotel(1, "The Metro Hotel"),
            new Hotel(2, "Ocean View Inn"),
            new Hotel(3, "The Lone Star Motel")
        };
        
        ff = FlyweightFactory.getInstance();
        log = new LogAdapter();
    }
    
    //Service Methods
    //check in
    public RoomKey checkIn(Guest g){
        Hotel h = hotels[g.hotelId]; 
        int rNum = h.getFreeRoom();
        if(rNum == 0){
            return null;
        }
        Room r = h.getRoomByNum(rNum);
        
        FlyweightIntr fwi = ff.getFlyweight(h.getHotelId());
        RoomKey result = new RoomKey(g.fName, g.lName, rNum, fwi);
        r.setState(r.state.transitionState());
        
        String logMsg =  
                  "\t\tAction: Guest Check In\n"
                + "\t\tHotel: " + h.getHotelName() + " - " + h.getHotelId() + "\n"
                + "\t\tRoom #: " + rNum + "\n"
                + "\t\tGuest: " + g.fName + " " + g.lName + "\n"
                + "\t\tRoom Status: " + r.state.stateDesc() + "\n";
        log.printLog(logMsg);
        
        return result;
    }
    
    //check out
    public void checkOut(RoomKey key){
        Hotel h = hotels[key.objFW.getHotelId() - 1];
        Room r = h.getRoomByNum(key.roomNum);
        
        r.setState(r.state.transitionState());
        
        String logMsg =  
                  "\t\tAction: Guest Check Out\n"
                + "\t\tHotel: " + h.getHotelName() + " - " + h.getHotelId() + "\n"
                + "\t\tRoom #: " + key.roomNum + "\n"
                + "\t\tGuest: " + key.getName() + "\n"
                + "\t\tRoom Status: " + r.state.stateDesc() + "\n";
        log.printLog(logMsg);
        
    }
    
    //call maintanence
    public void callMaintanence(){
        String logMsg = "";
        
        for(Hotel h : hotels){
            List<Room> rms = h.getRoomsToClean();
            if(rms.size() > 0){
                logMsg +=  
                  "\t\tAction: Call Mainanence\n"
                + "\t\tHotel: " + h.getHotelName() + " - " + h.getHotelId() + "\n";
                for(Room r : rms){
                    r.setState(r.state.transitionState());
                    logMsg += "\t\tRoom #: " + r.roomNum + "\n"
                            + "\t\tRoom Status: " + r.state.stateDesc() + "\n";
                }
            }
        }
        
        if(logMsg.length() > 0){
            log.printLog(logMsg);
        }
    }
}

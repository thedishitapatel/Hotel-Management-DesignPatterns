
package hotel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author John and Dishita
 */
public class Hotel {
    
    //Fields
    private Room[] rooms;
    private int hotelId;
    private String hotelName;

    //Constructor
    public Hotel(int hotelId, String hotelName) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.rooms = new Room[5];
        
        for(int i = 1; i < 6; i++){
            Room r = new Room(100 + i, this.hotelId);
            this.rooms[i - 1] = r;
        }
    }
    
    //Service Methods
    //method to get the next unoccupied room
    public int getFreeRoom(){
        for(Room r : rooms){
            if(r.checkIn()){
                return r.getRoomNum();
            }
        }
        
        return 0;
    }
    
    //method to get array of rooms needing maintanence
    public List<Room> getRoomsToClean(){
        List<Room> rms = new ArrayList<>();
        for(Room r : rooms){
            if(r.callMainanence()){
                rms.add(r);
            }
        }
        
        return rms;
    }
    
    //method to get Room object by Room Num
    public Room getRoomByNum(int rn){
        for(Room r : rooms){
            if(r.getRoomNum() == rn){
                return r;
            }
        }
        return null;
    }

    //Getters and Setters
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    
    
}

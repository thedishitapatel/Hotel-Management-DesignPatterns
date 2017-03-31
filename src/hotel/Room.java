
package hotel;

/**
 *
 * @author John and Dishita
 */
public class Room {
    
    //Fields
    int roomNum;
    State state;
    int hotelId;

    //Constructor
    public Room(int roomNum, int h) {
        this.roomNum = roomNum;
        //this.state = state;
        this.hotelId = h;
        
        this.state = State.initialState(this);
    }

    //Getteers and Setters
    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    //Service Methods to check room's state
    public boolean checkIn(){
        return state.checkIn();
    }
    
    public boolean checkOut(){
        return state.checkOut();
    }
    
    public boolean callMainanence(){
        return state.callMaintanence();
    }
}

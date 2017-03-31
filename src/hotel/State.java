
package hotel;

/**
 *
 * @author John and Dishita
 */
public abstract class State  {

    //Abstract Class for STATE pattern
    
    Room context;

    public State(Room context) {
        this.context = context;
    }
    
    public Room getContext() {
        return context;
    }

    public void setContext(Room context) {
        this.context = context;
    }
    
    public abstract State transitionState();
    public abstract boolean checkOut();
    public abstract boolean checkIn();
    public abstract boolean callMaintanence();
    public abstract String stateDesc();
    
    
    public static State initialState(Room r){
        return new Empty(r);
    }
    
}

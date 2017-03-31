
package hotel;

/**
 *
 * @author John and Dishita
 */
public class Occupied extends State {

    //Child Class for STATE pattern
    
    public Occupied(Room context) {
        super(context);
    }

    @Override
    public State transitionState() {
        return new Maintenance(context);
    }

    @Override
    public boolean checkOut() {
        return true;
    }

    @Override
    public boolean checkIn() {
        return false;
    }

    @Override
    public boolean callMaintanence() {
        return false;
    }

    @Override
    public String stateDesc() {
        return "Room is occupied";
    }
    
}

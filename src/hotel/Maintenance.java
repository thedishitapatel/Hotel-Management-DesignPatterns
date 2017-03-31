
package hotel;

/**
 *
 * @author John and Dishita
 */
public class Maintenance extends State {

    //Child Class for STATE pattern
    
    public Maintenance(Room context) {
        super(context);
    }

    @Override
    public State transitionState() {
        return new Empty(context);
    }

    @Override
    public boolean checkOut() {
        return false;
    }

    @Override
    public boolean checkIn() {
        return false;
    }

    @Override
    public boolean callMaintanence() {
        return true;
    }

    @Override
    public String stateDesc() {
        return "Room requires mainanence";
    }
    
}

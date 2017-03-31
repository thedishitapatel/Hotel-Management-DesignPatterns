
package hotel;

/**
 *
 * @author John and Dishita
 */
public class Empty extends State {

    //Child Class for STATE pattern
    
    public Empty(Room context) {
        super(context);
    }

    @Override
    public State transitionState() {
        return new Occupied(context);
    }

    @Override
    public boolean checkOut() {
        return false;
    }

    @Override
    public boolean checkIn() {
        return true;
    }

    @Override
    public boolean callMaintanence() {
        return false;
    }

    @Override
    public String stateDesc() {
        return "Room is ready to use";
    }
    
}

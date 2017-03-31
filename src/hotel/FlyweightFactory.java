
package hotel;

import java.util.HashMap;

/**
 *
 * @author John and Dishita
 */
public class FlyweightFactory {
    
    private static FlyweightFactory factory;
    private HashMap lstFlyweight;

    //private constructor for SINGLETON
    private FlyweightFactory() {
        lstFlyweight = new HashMap();
    }
    
    //public getInstance for SINGLETON
    public static FlyweightFactory getInstance() {
        if(factory == null){
            factory = new FlyweightFactory();
        }
        return factory;
    }
    
    //synchronized method for factory-flyweight
    public synchronized FlyweightIntr getFlyweight(int hotelId){
        if(lstFlyweight.get(hotelId) == null){
            FlyweightIntr fwIntr = new Flyweight(hotelId);
            lstFlyweight.put(hotelId, fwIntr);
            return fwIntr;
        }
        else{
            return (FlyweightIntr) lstFlyweight.get(hotelId);
        }
    }
    
    //inner class for factory-flyweight
    private class Flyweight implements FlyweightIntr{

        private int hotelId;
        private String hotelName;
        private String address;
        private String city;
        private String state;
        private String zip;

        private Flyweight(int id) {
            if(id == 1){
                setFields("The Metro Hotel", "1 North St.", "Northtown", "Michigan", "11111");
            }
            if(id == 2){
                setFields("Ocean View Inn", "1 East Ave.", "Eastberg", "Florida", "22222");
            }
            if(id == 3){
                setFields("The Lone Star Motel", "1 South Rd.", "Southville", "Texas", "33333");
            }
            this.hotelId = id;
        }

        private void setFields(String hn, String a, String c, String s, String z){
            hotelName = hn;
            address = a;
            city = c;
            state = s;
            zip = z;
        }
        
        //Getters and Setters
        public String getHotelName() {
            return hotelName;
        }
        public String getAddress() {
            return address;
        }
        public String getCity() {
            return city;
        }
        public String getState() {
            return state;
        }
        public String getZip() {
            return zip;
        }
        public int getHotelId(){
            return hotelId;
        }
        
        
        
    }
}

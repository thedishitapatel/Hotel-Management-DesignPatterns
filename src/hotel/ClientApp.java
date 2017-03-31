
package hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author John and Dishita
 */
public class ClientApp {
    
    private static Scanner read = new Scanner(System.in);
        
    public static void main(String[] args) {
        
        //Fields
        List<RoomKey> issuedRoomKeys = new ArrayList<>();
        boolean running = true;
        Facade clientFacade = new Facade();
        
        //Opening Title
        System.out.println("Welcome To Hotel & Guest Manager");
        
        //Main Menu Switch
        while(running){
            System.out.println("\n");
            System.out.println("***********Main Menu*************");
            System.out.println("Please Choose An Option:");
            System.out.println("1\tGuest Check In");
            System.out.println("2\tGuest Check Out");
            System.out.println("3\tCall Maintanence");
            System.out.println("");
            System.out.println("4\tExit");
            System.out.println("*********************************");
            
            System.out.print("Enter a number: ");
            String in = read.next();
            int i;
            try{
                i = Integer.parseInt(in);
            }catch(Exception e){
                i = 0;
            }
            
            switch(i){
                case 1:
                    Guest g = checkInMenu();
                    RoomKey rk = clientFacade.checkIn(g);
                    if(rk == null){
                        System.out.println("Sorry, there are no rooms available at this location.");
                        break;
                    }
                    System.out.print("Press ENTER to view the Room Key issued:");
                    read.nextLine();
                    read.nextLine();
                    rk.print();
                    System.out.print("Press ENTER to return to Main Menu");
                    read.nextLine();
                    issuedRoomKeys.add(rk);
                    break;
                case 2:
                    RoomKey rkRet = checkOutMenu(issuedRoomKeys);
                    if(rkRet == null){
                        break;
                    }
                    clientFacade.checkOut(rkRet);
                    System.out.print("Press ENTER to return to Main Menu");
                    read.nextLine();
                    read.nextLine();
                    break;
                case 3:
                    maintanenceMenu();
                    clientFacade.callMaintanence();
                    System.out.print("Press ENTER to return to Main Menu");
                    read.nextLine();
                    read.nextLine();
                    break;
                case 4:
                    System.out.println("Thank You");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Selection. Please, try again.");
                    break;
            }
            
        }
        
    }
    
    //Check in menu method
    public static Guest checkInMenu(){
        int hotelID = 0;
        while(hotelID <= 0 || hotelID >= 4){
            System.out.println("Please Select A Hotel");
            System.out.println("\t1. The Metro Hotel");
            System.out.println("\t2. Ocean View Inn");
            System.out.println("\t3. The Lone Star Motel");

            System.out.print("Enter a number: ");
            String in = read.next();
            int i;
            try{
                i = Integer.parseInt(in);
            }catch(Exception e){
                i = 0;
            } 
            if(i <= 0 || i >= 4){
                System.out.println("Invalid Selection. Please, try again.");
            }
            hotelID = i;
        }
        
        System.out.println("\nEnter Guest's First Name:");
        String f = read.next();
        
        System.out.println("\nEnter Guest's Last Name:");
        String l = read.next();
        
        return new Guest(f, l, hotelID - 1);        
    }
    
    //Check Out Menu Method
    public static RoomKey checkOutMenu(List<RoomKey> rooms){
        if(rooms.size() <= 0){
            System.out.println("There are no guests to check out.");
            System.out.println("Press ENTER to return to Main Menu");
            read.nextLine();
            read.nextLine();
            return null;
        }
        
        String menuOptions = "";
        for(int i = 0; i < rooms.size(); i++){
            menuOptions += "\t" + (i+1) + ". " + rooms.get(i).getName() + "\n";
        }
        
        int keyIndex = -1;
        while(keyIndex < 0 || keyIndex >= rooms.size()){
            System.out.println("Please Select A Guest To Check Out");
            System.out.println(menuOptions);

            System.out.print("Enter a number: ");
            String in = read.next();
            int i;
            try{
                i = Integer.parseInt(in);
            }catch(Exception e){
                i = -1;
            } 
            if(i <= 0 || i > rooms.size()){
                System.out.println("Invalid Selection. Please, try again.");
            }
            keyIndex = i-1;
        }
        
        return rooms.remove(keyIndex);
    }
    
    //Mainanence Menu Method
    public static void maintanenceMenu(){
        System.out.println("Maintanence will be called to all recently checked out rooms");
    }
}

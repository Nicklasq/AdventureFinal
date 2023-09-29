import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);

    public String getUserInput() {
        return scanner.nextLine();
    }

    public void printCurrentRoom(Room room) {
        String line = "Room: " + room.getName() +
                "\nDescription: " + room.getDescription();
        System.out.println(line);
    }

    public void printRoomItems(Room room) {
        String line = "Items in the " + room.getName();

        System.out.println(line);
        for (Item item : room.getItems()) {
            System.out.println(item.getName() + item.getDescription());
        }
    }

    public void welcome() {
        System.out.println("Welcome To The Naughty Adventure Game" +
                "" +
                "\nObjective: Your goal is to explore the haunted house, find the key to unlock the entrance door, and escape the mansion while dealing with supernatural enemies.");
    }

                    public void helpMenu() {
                            System.out.println("""
                                    -------------------------------------------------|
                                        Movement Commands:                           |   
                                        Type "go north" to move north.               |      
                                        Type "go south" to move south.               |       
                                        Type "go east" to move east.                 |       
                                        Type "go west" to move west.                 | 
                                        Type "pick up (item) to pick up an item      |    
                                        Type "drop (item) to srop an item            |     
                                                                                     |           
                                        Interaction Commands:                        |  
                                        Type "look" or to examine your surroundings. |
                                        Type "Inventory" to look at your Inventory   |       
                                                                                     |            
                                        Menu and Help Commands:                      |        
                                        Type "help" to display this help menu.       |          
                                        Type "quit" to exit the game.                |        
                                    -------------------------------------------------|
                                        """);
                        }




}

//import java.util.Scanner;
import java.util.ArrayList;

public class Player {
    private Room current;

    //private ArrayList<Item>inventory;



    public void setInitialRoom(Room current){
        this.current = current;

    }

    public Room getCurrent() {
        return current;
    }

    public void setCurrent(Room current) {
        this.current = current;
    }

    public class Inventory {
        private ArrayList<Item> items = new ArrayList<Item>();

        public Inventory() {
            this.items.add(new Item("Knife"));
            this.items.add(new Item("Note"));
        }
    }

    public void move(String direction) {
        // Check if the direction is valid for the current room
        Room nextRoom = null;
        //String direction = scanner.nextLine().toLowerCase();

        switch (direction) {
            case "north", "go north", "n":
                nextRoom = current.getNorth();
                break;
            case "east":
                nextRoom = current.getEast();
                break;
            case "south":
                nextRoom = current.getSouth();
                break;
            case "west":
                nextRoom = current.getWest();
                break;
        }

        if (nextRoom != null) {
            current = nextRoom;
            System.out.println("You move to the " + current.getName() + ".");
        } else {
            System.out.println("You can't go that way.");
        }
    }

    public void helpMenu(){
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

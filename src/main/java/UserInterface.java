import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {



    public void printCurrentRoom(Room room){
        String line = "Room: " + room.getName() +
                "\nDescription: " + room.getDescription();
        System.out.println(line);

    }

    Scanner scanner = new Scanner(System.in);

    public String getUserInput(){
        return scanner.nextLine();
    }


    public void printRoomItems(Room room){
        System.out.println("Current room name: " + room.getName());
        String line = "You look around and see these items in the " + room.getName() + ": ";

        System.out.println(line);

        for (Item item: room.getItems()) {
            System.out.println(item.getName());
        }

        // Display food items
        for (Food food: room.getFoodItems()) {
            System.out.println(food.getName());
        }
    }

    public void welcome(){
        System.out.println("""
        --------------------------------------------------------|
        𝓦𝓮𝓵𝓬𝓸𝓶𝓮 𝓽𝓸 𝓽𝓱𝓮 𝓗𝓪𝓾𝓷𝓽𝓮𝓭 𝓗𝓸𝓾𝓼𝓮                         |
                                                                |
        You wake up in the entrance of an old and spooky house, |      
        a spine-tingling chill surrounds you.                   |     
        The entrance hall is dimly lit with cobwebs everywhere, |    
        creaky floors, and a lingering sense of fear.           |
        You try to open the exit door but its locked.           |
        Your adventure into darkness has begun.                 |
                                                                |
        Pick up items they may be useful later on. Sharp objects|
        can be used as weapons                                  |
                                                                |
        Find key to the entrance door to escape                 |                                                        
        (type 'help' to see what your options are)              |
        --------------------------------------------------------|
        """);
    }
    public void helpMenu(){
        System.out.println("""
                    -------------------------------------------------|
                        Movement Commands:                           |   
                        Type "go-north" to move north.               |      
                        Type "go-south" to move south.               |       
                        Type "go-east" to move east.                 |       
                        Type "go-west" to move west.                 | 
                        Type "back" to go back to your previous room |
                        Type "take (item)" to pick up an item        |    
                        Type "drop (item)" to drop an item           |     
                                                                     |           
                        Interaction Commands:                        |  
                        Type "look" or to examine your surroundings. |
                        Type "Inventory" to look at your Inventory   |
                        Type "health" to look at your current healt  |
                        type "read (notes name)" to read a note      |
                        type "search" to search a dead body          |       
                        type "attack" to attack with weapon equipped | 
                        type "eat" to eat food and gain health       | 
                        type "equip or "unequip" to equip and unequip| 
                         weapons                                     |
                        type "use key" to use key to escape          |         
                                                                     | 
                        Menu and Help Commands:                      |        
                        Type "help" to display this help menu.       |          
                        Type "quit" to exit the game.                |        
                    -------------------------------------------------|
                        """);
    }


}

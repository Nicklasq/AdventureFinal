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
        String line = "You look around and see these items in the " + room.getName();

        System.out.println(line);
        for (Item item: room.getItems()) {
            System.out.println(item.getName());
        }
    }

    public void printTakeItem(String itemName) {
        System.out.println("You took a " + itemName + ".");
    }

    public void printDropItem(String itemName) {
        System.out.println("You dropped the " + itemName + ".");
    }

    public void printNoItemInRoom(String itemName) {
        System.out.println("There is no " + itemName + " in this room.");
    }

    public void printNoItemInInventory(String itemName) {
        System.out.println("You do not have " + itemName + " in your inventory.");
    }

    public void welcome(){
        System.out.println("""
        --------------------------------------------------------|
        You wake up in the entrance of an old and spooky house, |      
        a spine-tingling chill surrounds you.                   |     
        The entrance hall is dimly lit with cobwebs everywhere, |    
        creaky floors, and a lingering sense of fear.           |
        You try to open the exit door but its locked.           |
        Your adventure into darkness has begun.                 |  
        (type 'help' to see what your options are)              |
        --------------------------------------------------------|
        """);
    }

}

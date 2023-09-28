import java.util.Scanner;
//sophus
public class UserInterface {

    Scanner scanner = new Scanner(System.in);

    public String getUserInput(){
        return scanner.nextLine();
    }

    public void printCurrentRoom(Room room){

        String line = "Room: " + room.getName() +
                      "\nDescriptiohn: " + room.getDescription();
        System.out.println(line);
    }

    public void printRoomItems(Room room){
        String line = "Items in the " + room.getName();

        System.out.println(line);
        for (Item item: room.getItems()) {
            System.out.println(item.getName());


        }
       
    }


    public void welcome(){
        System.out.println("Welcome To The Naughty Adventure Game");
    }
}

import java.util.Scanner;

public class UserInterface {
    private GameEngine gameEngine = new GameEngine();
    //sophus
    boolean isRunning = true;
    public void startProgram() {
        Scanner scanner = new Scanner(System.in);

        // Build the rooms
        gameEngine.buildRoom();

        do {
            // Print the current room's description
            Room current = gameEngine.getCurrent();
            System.out.println(current.getDescription());

            // Get player's input
            System.out.print("Enter a direction (North, East, South, West, or Look): ");
            String direction = scanner.nextLine().toLowerCase();

            // Handle player's actions
            switch (direction) {
                case "look":
                    // The player wants to look at the current room
                    //System.out.println(current.getDescription());
                    break;
                case "north":
                case "east":
                case "south":
                case "west":
                    gameEngine.move(direction);
                    break;
//                case "Exit":
//                //System.out.println("Thanks for playing");
//                    isRunning = false;
//                break;
                default:
                    System.out.println("Invalid command. Try again.");
            }
        } while(isRunning);
    }

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.startProgram();
    }
}
import java.util.Scanner;

public class Adventure {

    public void startAdventure(){

        boolean isRunning = true;

        UserInterface ui = new UserInterface();
        ui.welcome();
        Adventure game = new Adventure();
        Map map = new Map();
        map.createMap();
        Player player = new Player();
        player.setCurrent(map.getEntrance());

        while (isRunning) {
            String input = ui.getUserInput();
            switch (input.toLowerCase()) {
                case "north", "south", "east", "west":
                    player.move(input);
                    ui.printCurrentRoom(player.getCurrent());
                    break;
                case "exit", "quit":
                    System.exit(0);
                    break;
                case "help":
                    ui.helpMenu();
                    break;
                case "look":
                    ui.printRoomItems(player.getCurrent());
                    break;
                case "take":
                    System.out.print("Enter the item name to take: ");
                    String takeItemName = ui.getUserInput();
                    player.takeItem(takeItemName);
                    break;
                case "drop":
                    System.out.print("Enter the item name to drop: ");
                    String dropItemName = ui.getUserInput();
                    player.dropItem(dropItemName);
                    break;
                default:
                    System.out.println("Invalid command. Try again. (type 'help' for help menu)");
            }

        }

    }
}
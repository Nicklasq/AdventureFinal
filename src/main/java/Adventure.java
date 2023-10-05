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

        while (isRunning){
            String input = ui.getUserInput().toLowerCase();
            String[] inputParts = input.split(" ", 2);
            String command = inputParts[0];
            String itemName = (inputParts.length > 1) ? inputParts[1] : "";
            String foodName = (inputParts.length > 1) ? inputParts[1] : "";
            String weaponName = (inputParts.length > 1) ? inputParts[1] : "";



            //need to fix so you can type 'go south' or 's'
            switch (command) {
                case "north", "go-north", "n", "south", "go-south", "s", "east", "go-east", "e", "west", "go-west", "w":
                    player.move(command);
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
                    player.takeItem(itemName);
                    player.takeFood(foodName);
                    break;
                case "drop":
                    player.dropItem(itemName);
                    break;
                case "inventory":
                    player.showInventory();
                    break;
                case "eat":
                    player.eat(foodName);
                    String eatStatus = player.eat(foodName); //changed from itemName to foodName??
                    System.out.println(eatStatus);
                    break;
                case "health":
                    System.out.println("Your current health: " + player.getHealth());
                    break;
                case "equip":
                    player.equip(weaponName);
                    System.out.println("Your equipped weapon: " + player.getEquippedWeapon().getName());
                    break;
                case "unequip":
                    player.unequip();
                    break;
                case "read":
                    if (itemName.equals("note1")) {
                        player.readNote();
                    }
                    else if (itemName.equals("note2")) {
                        player.readNote2();
                    }
                    else if (itemName.equals("note3")) {
                        player.readNote3();
                    }
                    else {
                        System.out.println("You can't read that.");
                    }
                    break;
                default:
                    System.out.println("Invalid command. Try again. (type 'help' for help menu)");
            }
        }
    }
}
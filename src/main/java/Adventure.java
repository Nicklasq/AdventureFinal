import java.util.Scanner;

public class Adventure {

    public void startAdventure() {

        boolean isRunning = true;

        UserInterface ui = new UserInterface();
        ui.welcome();
        Adventure game = new Adventure();
        Map map = new Map();
        map.createMap();
        Player player = new Player();
        player.setCurrent(map.getEntrance());

        while (isRunning) {
            String input = ui.getUserInput().toLowerCase();
            String[] inputParts = input.split(" ", 2);
            String command = inputParts[0];
            String itemName = (inputParts.length > 1) ? inputParts[1] : "";
            String foodName = (inputParts.length > 1) ? inputParts[1] : "";
            String weaponName = (inputParts.length > 1) ? inputParts[1] : "";

            if (player.getCurrent().getEnemies().size() > 0) {
                // Handle enemy encounter
                Enemy enemy = player.getCurrent().getEnemies().get(0);
                System.out.println("You encountered " + enemy.getName() + "!");

                switch (command) {
                    case "attack":
                        player.attack(enemy);
                        //enemy attack
                        //int damageTaken = enemy.attack();
                        //player.setHealth(player.getHealth() - damageTaken);

                        if (!enemy.isAlive()) {
                            //System.out.println("You defeated " + enemy.getName() + ".");   we can delete this
                            player.getCurrent().removeEnemy(enemy);

                            //After defeating the enemy
                            if (player.getCurrent().getNorth() != null) {
                                //player.move("north");          we can delete this
                                //ui.printCurrentRoom(player.getCurrent());      we can delete this
                                //System.out.println("You have defeted " + enemy.getName());         we can delete this
                            } else {
                                System.out.println("There's no room to move forward.");
                            }
                        }
                        break;
                    case "health":
                        System.out.println("Your current health: " + player.getHealth());
                        break;
                    case "equip":
                        player.equip(itemName);
                        break;
                    case "back":
                        player.moveBack();
                        ui.printCurrentRoom(player.getCurrent());
                        break;
                    case "exit", "quit":
                        System.exit(0);
                        break;
                    case "help":
                        ui.helpMenu();
                        break;
                    default:
                        System.out.println("An enemy is blocking your path. You can only use 'attack', 'health', 'equip', or 'back'.");
                }

                // Check if the enemy is defeated
                if (!enemy.isAlive()) {
                    System.out.println("You defeated " + enemy.getName() + ".");
                    // You can add code here to handle looting the enemy, if needed
                    player.getCurrent().removeEnemy(enemy);
                } else if (player.getHealth() <= 0) {
                    System.out.println("You have been defeated. Game over!");
                    isRunning = false;
                }
            } else {


                switch (command) {
                    case "north", "go-north", "n", "south", "go-south", "s", "east", "go-east", "e", "west", "go-west", "w":
                        if (player.isEnemyBlocking()) {
                            System.out.println("An enemy is blocking your path.");
                        } else {
                            player.move(command);
                            ui.printCurrentRoom(player.getCurrent());
                        }
                        //if (player.isDoorLocked()){
                        //    System.out.println("Door is locked");
                        //}else {
                        //    player.move(command);
                        //    ui.printCurrentRoom(player.getCurrent());
                        //}
                        break;
                    case "back":
                        player.moveBack();
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
                        //player.takeItem(itemName, player.getCurrent());
                        player.takeFood(foodName);
                        player.takeItem(itemName, player.getCurrent());
                        break;
                    case "drop":
                        player.dropItem(itemName);
                        break;
                    case "inventory":
                        player.showInventory();
                        break;
                    case "eat":
                        String eatStatus = player.eat(foodName);
                        System.out.println(eatStatus);
                        break;
                    case "health":
                        System.out.println("Your current health: " + player.getHealth());
                        break;
                    case "equip":
                        player.equip(weaponName);
                        break;
                    case "attack":
                        player.attack();
                        break;
                    case "unequip":
                        player.unequip();
                        break;
                    case "read":
                        if (itemName.equals("note1")) {
                            player.readNote();
                        } else if (itemName.equals("note2")) {
                            player.readNote2();
                        } else {
                            System.out.println("You can't read that.");
                        }
                        break;
                    default:
                        System.out.println("Invalid command. Try again. (type 'help' for help menu)");
                }
            }
        }
    }
}
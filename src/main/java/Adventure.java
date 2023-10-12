import java.util.Scanner;

public class Adventure {

    public void startAdventure() {

        boolean isRunning = true;
        boolean won = false;

        UserInterface ui = new UserInterface();
        ui.welcome();
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
                        player.attack();

                        if (!enemy.isAlive()) {
                            player.getCurrent().removeEnemy(enemy);
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

                //check if the enemy is defeated
                if (!enemy.isAlive()) {
                    player.getCurrent().removeEnemy(enemy);
                } else if (player.getHealth() <= 0) {
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
                        if (itemName.equals("letter")) {
                            player.readNote();
                        } else if (itemName.equals("note")) {
                            player.readNote2();
                        } else {
                            System.out.println("You can't read that.");
                        }
                        break;
                    case "use":
                        if (player.use()){
                            isRunning = false;
                            won = true;
                        }
                        break;
                    default:
                        System.out.println("Invalid command. Try again. (type 'help' for help menu)");
                }
            }
        }
        if (won){
            System.out.println("ＹＯＵ ＥＳＣＡＰＥＤ ＡＮＤ ＷＯＮ ＴＨＥ ＧＡＭＥ, ＴＨＡＮＫＳ ＦＯＲ ＰＬＡＹＩＮＧ");
        }
        else{
            System.out.println("ＹＯＵ ＬＯＳＴ ＴＨＥ ＧＡＭＥ, ＴＲＹ ＡＧＡＩＮ.");
        }
    }
}
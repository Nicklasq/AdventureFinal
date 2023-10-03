//import java.util.Scanner;
import java.util.ArrayList;

public class Player {
    private Room current;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int health;

    //players health
    public Player() {
        this.health = 80; // Full health is at 100
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setInitialRoom(Room current) {
        this.current = current;

    }

    public Room getCurrent() {
        return current;
    }

    public void setCurrent(Room current) {
        this.current = current;
    }


//    public class Inventory {
//        private ArrayList<Item> items = new ArrayList<Item>();
//
//       public Inventory() {
//            this.items.add(new Item("Knife"));
//            this.items.add(new Item("Note"));
//        }
//    }

    public void move(String direction) {
        // Check if the direction is valid for the current room
        Room nextRoom = null;
        //String direction = scanner.nextLine().toLowerCase();

        switch (direction) {
            case "north", "go-north", "n":
                nextRoom = current.getNorth();
                break;
            case "east", "go-east", "e":
                nextRoom = current.getEast();
                break;
            case "south", "go-south", "s":
                nextRoom = current.getSouth();
                break;
            case "west", "go-west", "w":
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


    public boolean takeItem(String itemName) {
        Room currentRoom = getCurrent();
        ArrayList<Item> roomItems = currentRoom.getItems();

        for (Item item : roomItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                inventory.add(item);
                roomItems.remove(item);
                System.out.println("You took a " + itemName + ".");
                return true;
            }
        }
        System.out.println("There is no " + itemName + " in this room.");
        return false;
    }

    public boolean takeFood(String foodName) {
        Room currentRoom = getCurrent();
        ArrayList<Food> roomFood = currentRoom.getFoodItems();
        for (Food food : roomFood) {
            if (food.getName().equalsIgnoreCase(foodName)) {
                inventory.add(food);
                roomFood.remove(food);
                System.out.println("You took " + foodName + ".");
                return true;
            }
        }
        System.out.println("Theres is no " + foodName + " in this room.");
        return false;

    }


    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Items in your inventory:");
            for (Item item : inventory) {
                System.out.println(item.getName());
            }
        }
    }

    public boolean dropItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                current.getItems().add(item);
                inventory.remove(item);
                System.out.println("You dropped the " + itemName + ".");
                return true;
            }
        }
        System.out.println("You do not have " + itemName + " in your inventory.");
        return false;
    }



    public String eat(String foodName) {
        Room currentRoom = getCurrent();
        ArrayList<Food> roomFoodItems = currentRoom.getFoodItems();

        // Check if foodName is empty or null
        if (foodName == null   || foodName.isEmpty()) {
            return "Please specify the name of the food you want to eat.";
        }

        for (Food food : roomFoodItems) {
            // Check if the foodName matches, ignoring case
            if (food.getName().equalsIgnoreCase(foodName)) {
                int healthChange = food.getHealthPoints();
                currentRoom.getFoodItems().remove(food);

                if (healthChange > 0) {
                    // Positive health change
                    inventory.remove(food);
                    setHealth(getHealth() + healthChange); // Increase player's health
                    return "You ate the " + foodName + " and gained " + healthChange + " health points.";
                } else if (healthChange < 0) {
                    // Negative health change
                    inventory.remove(food);
                    setHealth(getHealth() - healthChange); // Decrease player's health
                    return "You ate the " + foodName + " and lost " + (-healthChange) + " health points.";
                }
            }
        }

        return "There is no " + foodName + " to eat.";
    }


    public boolean readNote() {
        Room currentRoom = getCurrent();
        ArrayList<Item> roomItems = currentRoom.getItems();

        for (Item item : roomItems) {
            if (item.getName().equalsIgnoreCase("note1")) {
                System.out.println("""
                        **********************************************************************|
                        SEND HELP!!!                                                          |
                                                                                              |
                        I'm writing in sheer desperation to warn you                          |
                        about the horrors that dwell within this wretched house.              |
                        Monstrous entities haunt these halls, relentlessly seeking the living.|
                        Beware the shifting shadows, chilling whispers,                       |
                        and grotesque apparitions that lurk here.                             |
                        They are real, and they hunger for you.                               |           
                        You need a key to unlock the entrance door to freedom,                |
                        not sure where it is I'm going to try to find it.                     |
                        But trust not your senses, this place distorts reality.               |                             
                        My life hangs by a thread, and I'm not sure if I'll survive.          |
                        **********************************************************************|
                        """);
                return true;
            }
        }
        System.out.println("There is no note in this room to read.");
        return false;
    }

    public boolean readNote2() {
        Room currentRoom = getCurrent();
        ArrayList<Item> roomItems = currentRoom.getItems();

        for (Item item : roomItems) {
            if (item.getName().equalsIgnoreCase("note2")) {
                System.out.println("""
                        TEST (write something about note2)
                        """);
                return true;
            }

        }
        System.out.println("There is no note in this room to read.");
        return false;
    }

    public boolean readNote3() {
        Room currentRoom = getCurrent();
        ArrayList<Item> roomItems = currentRoom.getItems();

        for (Item item : roomItems) {
            if (item.getName().equalsIgnoreCase("note3")) {
                System.out.println("""
                        TEST (write something about note3)
                        """);
                return true;
            }

        }
        System.out.println("There is no note in this room to read.");
        return false;
    }
}


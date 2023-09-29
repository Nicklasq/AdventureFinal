//import java.util.Scanner;

import java.util.ArrayList;

public class Player {
    private Room current;
    private ArrayList<Item> inventory = new ArrayList<>();


    public Room getCurrent() {
        return current;
    }

    public void setCurrent(Room current) {
        this.current = current;
    }


    public boolean move(String direction) {
        // Check if the direction is valid for the current room
        Room nextRoom = null;
        //String direction = scanner.nextLine().toLowerCase();

        switch (direction) {
            case "north", "go north", "n":
                nextRoom = current.getNorth();
                break;
            case "east", "go east", "e":
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
            return true;

        } return false;
    }

    public boolean takeItem(String itemName) {
        Room currentRoom = getCurrent();
        ArrayList<Item> roomItems = currentRoom.getItems();

        for (Item item : roomItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                inventory.add(item);
                roomItems.remove(item);
//                System.out.println("You have taken " + itemName + ".");
                return true;
            }
        }
        return false;

//        System.out.println("There is no " + itemName + " in this room.");
    }

    public boolean dropItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                current.getItems().add(item);
                inventory.remove(item);
//                System.out.println("You have dropped " + itemName + ".");
                return true;
            }
        }
        return false;

//        System.out.println("You do not have " + itemName + " in your inventory.");
    }
}
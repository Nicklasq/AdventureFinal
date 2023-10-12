//import java.util.Scanner;

import org.w3c.dom.ranges.Range;

import java.security.Key;
import java.util.ArrayList;

public class Player {
    private Room current;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int health;
    private Weapon equippedWeapon;
    private Room previousRoom;
    private boolean enemyBlocking;
    private boolean doorLocked;


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



    public boolean isEnemyBlocking() {
        return enemyBlocking;
    }

    public void setEnemyBlocking(boolean enemyBlocking) {
        this.enemyBlocking = enemyBlocking;
    }

    public boolean isDoorLocked() {
        return doorLocked;
    }

    public void move(String direction) {
        // Check if the direction is valid for the current room
        Room nextRoom = null;

        if (direction.equals("north") || direction.equals("go-north") || direction.equals("n")) {
            nextRoom = current.getNorth();
        } else if (direction.equals("east") || direction.equals("go-east") || direction.equals("e")) {
            nextRoom = current.getEast();
        } else if (direction.equals("south") || direction.equals("go-south") || direction.equals("s")) {
            nextRoom = current.getSouth();
        } else if (direction.equals("west") || direction.equals("go-west") || direction.equals("w")) {
            nextRoom = current.getWest();
        }

        if (nextRoom != null) {
            current = nextRoom;
            System.out.println("You move to the " + current.getName() + ".");
        } else {
            System.out.println("You can't go that way.");
        }

        if (nextRoom != null) {
            if (!isEnemyBlocking()) {
                // No enemy blocking the way, move to the next room
                previousRoom = current;
                current = nextRoom;
                System.out.println("You move to the " + current.getName() + ".");
            } else {
                // Enemy blocking the way, cannot move
                System.out.println("An enemy is blocking your path.");
            }
        } else {
            System.out.println("You can't go that way.");
        }
    }


    public void moveBack() {
        if (previousRoom != null) {
            // Swap current and previous rooms
            Room temp = current;
            current = previousRoom;
            previousRoom = temp;
            System.out.println("You move back to the " + current.getName() + ".");
        } else {
            System.out.println("You can't go back from here.");
        }
    }


    public boolean takeItem(String itemName, Room room) {
        ArrayList<Item> roomItems = room.getItems();

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

        for (Item item : inventory
        ) {

            System.out.println(item.getName());
        }
        Room currentRoom = getCurrent();

        // Check if foodName is empty or null
        if (foodName == null || foodName.isEmpty()) {
            return "Please specify the name of the food you want to eat.";
        }


        for (Item food : inventory) {


            if (food instanceof Food) {


                if (food.getName().equals(foodName)) {

                    Food f = (Food) food;
                    int healthChange = f.getHealthPoints();
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
            // Check if the foodName matches, ignoring case

        }

        return "There is no " + foodName + " to eat.";

    }

    public boolean readNote() {
        Room currentRoom = getCurrent();
        ArrayList<Item> roomItems = currentRoom.getItems();

        for (Item item : roomItems) {
            if (item.getName().equalsIgnoreCase("note1")) {
                System.out.println("""
                        *********************************************************************|
                        𝒮𝐸𝒩𝒟 𝐻𝐸𝐿𝒫!!!                                                        |                                                                                               
                                                                                             |                         
                        𝐼'𝓂 𝓌𝓇𝒾𝓉𝒾𝓃𝑔 𝒾𝓃 𝓈𝒽𝑒𝑒𝓇 𝒹𝑒𝓈𝓅𝑒𝓇𝒶𝓉𝒾𝑜𝓃 𝓉𝑜 𝓌𝒶𝓇𝓃 𝓎𝑜𝓊                         |                        
                        𝒶𝒷𝑜𝓊𝓉 𝓉𝒽𝑒 𝒽𝑜𝓇𝓇𝑜𝓇𝓈 𝓉𝒽𝒶𝓉 𝒹𝓌𝑒𝓁𝓁 𝓌𝒾𝓉𝒽𝒾𝓃 𝓉𝒽𝒾𝓈 𝓌𝓇𝑒𝓉𝒸𝒽𝑒𝒹 𝒽𝑜𝓊𝓈𝑒.              |                         
                        𝑀𝑜𝓃𝓈𝓉𝓇𝑜𝓊𝓈 𝑒𝓃𝓉𝒾𝓉𝒾𝑒𝓈 𝒽𝒶𝓊𝓃𝓉 𝓉𝒽𝑒𝓈𝑒 𝒽𝒶𝓁𝓁𝓈, 𝓇𝑒𝓁𝑒𝓃𝓉𝓁𝑒𝓈𝓈𝓁𝓎 𝓈𝑒𝑒𝓀𝒾𝓃𝑔 𝓉𝒽𝑒 𝓁𝒾𝓋𝒾𝓃𝑔.    |                         
                        𝐵𝑒𝓌𝒶𝓇𝑒 𝓉𝒽𝑒 𝓈𝒽𝒾𝒻𝓉𝒾𝓃𝑔 𝓈𝒽𝒶𝒹𝑜𝓌𝓈, 𝒸𝒽𝒾𝓁𝓁𝒾𝓃𝑔 𝓌𝒽𝒾𝓈𝓅𝑒𝓇𝓈,                       |                         
                        𝒶𝓃𝒹 𝑔𝓇𝑜𝓉𝑒𝓈𝓆𝓊𝑒 𝒶𝓅𝓅𝒶𝓇𝒾𝓉𝒾𝑜𝓃𝓈 𝓉𝒽𝒶𝓉 𝓁𝓊𝓇𝓀 𝒽𝑒𝓇𝑒.                             |                         
                        𝒯𝒽𝑒𝓎 𝒶𝓇𝑒 𝓇𝑒𝒶𝓁, 𝒶𝓃𝒹 𝓉𝒽𝑒𝓎 𝒽𝓊𝓃𝑔𝑒𝓇 𝒻𝑜𝓇 𝓎𝑜𝓊.                              |                                    
                        𝒴𝑜𝓊 𝓃𝑒𝑒𝒹 𝒶 𝓀𝑒𝓎 𝓉𝑜 𝓊𝓃𝓁𝑜𝒸𝓀 𝓉𝒽𝑒 𝑒𝓃𝓉𝓇𝒶𝓃𝒸𝑒 𝒹𝑜𝑜𝓇 𝓉𝑜 𝒻𝓇𝑒𝑒𝒹𝑜𝓂,                 |                         
                        𝓃𝑜𝓉 𝓈𝓊𝓇𝑒 𝓌𝒽𝑒𝓇𝑒 𝒾𝓉 𝒾𝓈 𝐼'𝓂 𝑔𝑜𝒾𝓃𝑔 𝓉𝑜 𝓉𝓇𝓎 𝓉𝑜 𝒻𝒾𝓃𝒹 𝒾𝓉.                      |                         
                        𝐵𝓊𝓉 𝓉𝓇𝓊𝓈𝓉 𝓃𝑜𝓉 𝓎𝑜𝓊𝓇 𝓈𝑒𝓃𝓈𝑒𝓈, 𝓉𝒽𝒾𝓈 𝓅𝓁𝒶𝒸𝑒 𝒹𝒾𝓈𝓉𝑜𝓇𝓉𝓈 𝓇𝑒𝒶𝓁𝒾𝓉𝓎.                 |                                                      
                        𝑀𝓎 𝓁𝒾𝒻𝑒 𝒽𝒶𝓃𝑔𝓈 𝒷𝓎 𝒶 𝓉𝒽𝓇𝑒𝒶𝒹, 𝒶𝓃𝒹 𝐼'𝓂 𝓃𝑜𝓉 𝓈𝓊𝓇𝑒 𝒾𝒻 𝐼'𝓁𝓁 𝓈𝓊𝓇𝓋𝒾𝓋𝑒.          |
                        *********************************************************************|
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
                       *****************************************************************************|
                       𝓣𝓗𝓔 𝓑𝓔𝓓𝓡𝓞𝓞𝓜!!                                                             |       
                                                                                                    |       
                       𝓑𝓮𝔀𝓪𝓻𝓮 𝓽𝓱𝓮 𝓼𝓱𝓪𝓭𝓸𝔀𝓼, 𝓼𝓽𝓻𝓪𝓷𝓰𝓮 𝓼𝓸𝓾𝓷𝓭𝓼, 𝓪𝓷𝓭 𝓼𝓬𝓪𝓻𝔂 𝓽𝓱𝓲𝓷𝓰𝓼 𝓱𝓮𝓻𝓮.               |      
                       𝓣𝓱𝓮𝔂'𝓻𝓮 𝓻𝓮𝓵𝓮𝓷𝓽𝓵𝓮𝓼𝓼 𝓪𝓷𝓭 𝔀𝓪𝓷𝓽 𝔂𝓸𝓾 𝓰𝓸𝓷𝓮.  𝓣𝓸 𝓮𝓼𝓬𝓪𝓹𝓮, 𝓯𝓲𝓷𝓭 𝓽𝓱𝓮 𝓫𝓮𝓭𝓻𝓸𝓸𝓶 𝓴𝓮𝔂. | 
                       𝓘𝓽 𝓾𝓷𝓵𝓸𝓬𝓴𝓼 𝓽𝓱𝓮 𝓮𝓷𝓽𝓻𝓪𝓷𝓬𝓮 𝓪𝓷𝓭 𝓼𝓮𝓽𝓼 𝔂𝓸𝓾 𝓯𝓻𝓮𝓮.                                  |
                       𝓣𝓱𝓲𝓼 𝓲𝓼𝓷'𝓽 𝓪 𝓳𝓸𝓴𝓮; 𝓲𝓽'𝓼 𝓵𝓲𝓯𝓮 𝓸𝓻 𝓭𝓮𝓪𝓽𝓱.                                       |        
                       𝓨𝓸𝓾 𝓶𝓾𝓼𝓽 𝓯𝓲𝓷𝓭 𝓽𝓱𝓪𝓽 𝓴𝓮𝔂 𝓲𝓷 𝓽𝓱𝓮 𝓫𝓮𝓭𝓻𝓸𝓸𝓶 𝓽𝓸 𝓮𝓼𝓬𝓪𝓹𝓮.                         |     
                       𝓓𝓸𝓷'𝓽 𝔀𝓪𝓲𝓽; 𝓽𝓲𝓶𝓮'𝓼 𝓻𝓾𝓷𝓷𝓲𝓷𝓰 𝓸𝓾𝓽. 𝓣𝓱𝓮 𝓫𝓮𝓭𝓻𝓸𝓸𝓶 𝓱𝓸𝓵𝓭𝓼 𝓽𝓱𝓮 𝓪𝓷𝓼𝔀𝓮𝓻.          |
                       *****************************************************************************|         
                        """);
                return true;
            }

        }
        System.out.println("There is no note in this room to read.");
        return false;
    }



    public void equip(String weaponName) {
        for (Item item : inventory) {
            if (item instanceof Weapon && item.getName().equalsIgnoreCase(weaponName)) {
                equippedWeapon = (Weapon) item;
                System.out.println("You equipped the " + weaponName + ".");
                inventory.remove(item);
                return;
            }
        }
        System.out.println("You do not have a " + weaponName + " in your inventory.");
    }

    public void unequip() {
        if (equippedWeapon != null) {
            inventory.add(equippedWeapon);
            System.out.println("You unequipped the " + equippedWeapon.getName() + ".");
            equippedWeapon = null;
        } else {
            System.out.println("You dont have any weapons equipped.");
        }
    }



    public void attack() {
        if (equippedWeapon != null) {
            int damageDealt = equippedWeapon.getDamage();
            // Perform the attack logic here
            System.out.println("You attacked and dealt " + damageDealt + " damage.");
        } else {
            System.out.println("You are not equipped with any weapon.");
        }
    }

    public void attack(Enemy enemy) {
        if (equippedWeapon != null) {
            int damageDealt = equippedWeapon.getDamage();
            enemy.takeDamage(damageDealt);

            if (enemy.isAlive()) {
                int damageTaken = enemy.attack(); // Enemy attacks back
                setHealth(getHealth() - damageTaken);
                System.out.println("You attacked " + enemy.getName() + " and dealt " + damageDealt + " damage.");
                System.out.println(enemy.getName() + " attacked you and dealt " + damageTaken + " damage.");
            } else {
                System.out.println("You defeated " + enemy.getName() + ".");
                // Drop enemy's weapon
                if (enemy.getWeapon() != null) {
                    current.takeItem(enemy.getWeapon().getName());
                    System.out.println(enemy.getName() + " dropped " + enemy.getWeapon().getName() + ".");
                }
                current.removeEnemy(enemy);
            }
        } else {
            System.out.println("You are not equipped with any weapon.");
        }
    }
}



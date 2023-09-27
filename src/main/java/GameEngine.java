public class GameEngine {
    private Room current;


    public void callBuildRoom(){
         Map map = new Map();
         map.buildRoom();
    }
//    public void buildRoom() {
//        // Define rooms and their descriptions
//        Room entrance = new Room("Entrance", "You are in the entrance, .");
//        Room kitchen = new Room("Kitchen", "You are in the kitchen.");
//        Room diningRoom = new Room("Dining Room", "You are in the dining room.");
//        Room garage = new Room("Garage", "You are in the garage.");
//        Room bedRoom = new Room("Bedroom", "You are in the bedroom.");
//        Room office = new Room("Office", "You are in the office.");
//        Room bathRoom = new Room("Bathroom", "Upon entering the bathroom, you're met by a horrid odor, from a gruesome scene lurking in the bathtub.");
//        Room hallWay = new Room("Hallway", "You are in the hallway.");
//        Room livingRoom = new Room("Living Room", "You are in the living room.");
//
//        // Connect rooms with directions
//        entrance.setEast(kitchen);
//        entrance.setSouth(garage);
//
//        kitchen.setWest(entrance);
//        kitchen.setEast(diningRoom);
//
//        diningRoom.setWest(kitchen);
//        diningRoom.setSouth(office);
//
//        garage.setNorth(entrance);
//        garage.setSouth(bathRoom);
//
//        bedRoom.setSouth(hallWay);
//
//        office.setNorth(diningRoom);
//        office.setSouth(livingRoom);
//
//        bathRoom.setNorth(garage);
//        bathRoom.setEast(hallWay);
//
//        hallWay.setNorth(bedRoom);
//        hallWay.setWest(bathRoom);
//        hallWay.setEast(livingRoom);
//
//        livingRoom.setNorth(office);
//        livingRoom.setWest(hallWay);
//
//        // Set the starting room
//        current = entrance;
//    }

    public void move(String direction) {
        // Check if the direction is valid for the current room
        Room nextRoom = null;

        switch (direction) {
            case "north":
                nextRoom = current.getNorth();
                break;
            case "east":
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
            System.out.println("You move to the " + current.getName() + ".");
        } else {
            System.out.println("You can't go that way.");
        }
    }
    public Room getCurrent() {
        return current;
    }


    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        gameEngine.callBuildRoom();
    }

}
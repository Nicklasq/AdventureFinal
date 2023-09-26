import java.util.Scanner;

public class GameEngine {

    private Room current;

    public void buildRoom() {
        Room room1 = new Room("Room 1 ", " sakdjba ");
        Room room2 = new Room("roo2", " rum2");
        Room room3 = new Room("room3", "sad");
        Room room4 = new Room("room4", " ");
        Room room5 = new Room("room5", " ");
        Room room6 = new Room("room6", " sd");
        Room room7 = new Room("room7", " ");
        Room room8 = new Room("room8", " ");
        Room room9 = new Room("room9", " s");

        //Room1 directions
        room1.setEast(room2);
        room1.setSouth(room4);
        room1.setNorth(null);
        room1.setWest(null);

        //Room2 directions
        room2.setEast(room3);
        room2.setSouth(room5);
        room2.setNorth(null);
        room2.setWest(room1);

        //Room3
        room3.setEast(null);
        room3.setSouth(room6);
        room3.setNorth(null);
        room3.setWest(room2);

        //Room4
        room4.setEast(room5);
        room4.setSouth(room7);
        room4.setNorth(room1);
        room4.setWest(null);

        //Room5
        room5.setEast(room6);
        room5.setSouth(room8);
        room5.setNorth(room2);
        room5.setWest(room4);

        //Room6
        room6.setEast(null);
        room6.setSouth(room9);
        room6.setNorth(room3);
        room6.setWest(room5);

        //Room7
        room7.setEast(room8);
        room7.setSouth(null);
        room7.setNorth(room4);
        room7.setWest(null);

        //Room8
        room8.setEast(room9);
        room8.setSouth(null);
        room8.setNorth(room5);
        room8.setWest(room7);

        //Room9
        room9.setEast(null);
        room9.setSouth(null);
        room9.setNorth(room6);
        room9.setWest(room8);

        // peg på starter room
        current = room1;


    }

    public void startProgram() {
        System.out.print("Enter a direction: ");
        Scanner scanner = new Scanner(System.in);
        String direction = scanner.nextLine().toLowerCase();


        while (true) {
            if (direction.equals("Look")) {

                System.out.println(current.getDescription());
            } else if (direction.equals("Go North")) {
                if (current.getNorth() != null) {
                    current = current.getNorth();
                    System.out.println("Gone North");
                } else {
                    System.out.println("Cant go that way");
                }


            } else if (direction.equals("Go East")) {
                if (current.getEast() != null) {
                    current = current.getEast();
                    System.out.println("Gone East");
                }


            } else if (direction.equals("Go south")) {
                if (current.getSouth() != null) {
                    current = current.getSouth();
                    System.out.println("Gone South");
                }


            } else if (direction.equals("Go West")) {
                if (current.getWest() != null) {
                    current = current.getWest();
                    System.out.println("Gone West");
                }
            }
        }
    }
}
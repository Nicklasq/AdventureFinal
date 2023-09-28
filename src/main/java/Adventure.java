public class Adventure {

    public static void main(String[] args) {

        boolean isRunning = true;

        UserInterface ui = new UserInterface();
        ui.welcome();
        Adventure game = new Adventure();
        Map map = new Map();
        map.createMap();

        Player player = new Player();
        player.setCurrent(map.getEntrance());

        while (isRunning){
            String input = ui.getUserInput();
            switch (input){
                case "north", "south", "east", "west":
                    player.move(input);
                    ui.printCurrentRoom(player.getCurrent());
                    break;
                case "exit", "quit":
                    System.exit(0);
                    break;
                case "help":
                    player.helpMenu();
                    break;
                case "Look", "look":
                    ui.printRoomItems(player.getCurrent());
            }

        }


    }
}

import java.util.Scanner;

public class UserInterface {


    public void startProgram() {
        boolean stillGoing = true;

        while (stillGoing) {
            System.out.print("Enter a direction: ");
            Scanner scanner = new Scanner(System.in);
            String direction = scanner.nextLine().toLowerCase();
            GameEngine gameEngine = new GameEngine();
        }

    }
}



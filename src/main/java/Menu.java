import java.util.Scanner;

public class Menu {
    char input;
    Game game = new Game();

    void mainMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Minesweeper!");
        System.out.println("Please enter an option:");
        System.out.println();
        System.out.println("Enter 'A' to start a new game");
        System.out.println("Enter 'B' to quit");
        System.out.println();

        input = scanner.next().charAt(0);
        input = Character.toLowerCase(input);
        while (input != 'a' && input != 'b') {
            System.out.println("Error, invalid choice.");
            System.out.println("Enter 'A' to start a new game");
            System.out.println("Enter 'B' to quit");
            input = scanner.next().charAt(0);
            input = Character.toLowerCase(input);
        }

        if (input == 'a') {
            game.playGame();
        } else if (input == 'b') {
            System.out.println("Thanks for playing. See you next time!");
        }
    }
}

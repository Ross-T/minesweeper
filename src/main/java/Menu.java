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
        System.out.println("Enter 'B' for instructions");
        System.out.println("Enter 'C' to quit");
        System.out.println();

        input = scanner.next().charAt(0);
        input = Character.toLowerCase(input);
        while (input != 'a' && input != 'b' && input != 'c') {
            System.out.println("Error, invalid choice.");
            System.out.println("Enter 'A' to start a new game");
            System.out.println("Enter 'B' for instructions");
            System.out.println("Enter 'C' to quit");
            input = scanner.next().charAt(0);
            input = Character.toLowerCase(input);
        }

        if (input == 'a') {
            game.playGame();
        } else if (input == 'b') {
            printInstructions();
            mainMenu();
        } else if (input == 'c') {
            System.out.println("Thanks for playing. See you next time!");
        }
    }

    void printInstructions() {
        System.out.println("Minesweeper is a game where mines are hidden behind a grid of cells. Your job is to reveal all of the hidden cells on the grid without revealing a mine!");
        System.out.println("Once revealed, cells which which are adjacent to a mine in any direction (including diagonally) will display a number indicating how many adjacent mines there are.");
        System.out.println("Once you think you know where a mine is, you can place a flag on that cell to indicate the presence of a mine and prevent this cell from being revealed accidentally.");
        System.out.println("Good luck!");
        System.out.println();
    }

}

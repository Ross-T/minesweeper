import java.util.Scanner;

// The Menu class handles user input and output
public class Menu {

    // A character to store the user's input
    char input;

    // An instance of the Game class
    Game game = new Game();

    // Method to display the main menu
    void mainMenu() {
        System.out.println("Welcome to Minesweeper!");
        System.out.println("Please enter an option:");
        System.out.println();
        System.out.println("Enter 'A' to start a new game");
        System.out.println("Enter 'B' for instructions");
        System.out.println("Enter 'C' to quit");
        System.out.println();

        input = getUserInput();

        if (input == 'a') {
            game.playGame();
        } else if (input == 'b') {
            printInstructions();
            mainMenu();
        } else if (input == 'c') {
            System.out.println("Thanks for playing. See you next time!");
        }
    }

    // Method to get the user's input and check its validity
    char getUserInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.length() == 1) {
                input = line.charAt(0);
                input = Character.toLowerCase(input);
                if (input == 'a' || input == 'b' || input == 'c') {
                    return input;
                }
            }
            System.out.println("Error, invalid choice.");
            System.out.println("Enter 'A' to start a new game");
            System.out.println("Enter 'B' for instructions");
            System.out.println("Enter 'C' to quit");
        }
    }

    // Method to print the game instructions
    void printInstructions() {
        System.out.println("Minesweeper is a game where 10 mines are hidden behind a grid of cells. Your job is to reveal all of the hidden cells on the grid without revealing any of the 10 mines!");
        System.out.println("Once revealed, cells which which are adjacent to a mine in any direction (including diagonally) will display a number indicating how many adjacent mines there are.");
        System.out.println("Once you think you know where a mine is, you can place a flag on that cell to indicate the presence of a mine and prevent this cell from being revealed accidentally.");
        System.out.println("Good luck!");
        System.out.println();
    }

}

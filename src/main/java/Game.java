import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Board board = new Board(this);
    Timer timer = new Timer();

    void playGame() {
        board.newGame();
        Scanner scanner = new Scanner(System.in);
        timer.start();
        while (!board.isGameOver()) {
            board.printBoard(board.getDisplayBoard());
            int x = -1;
            int y = -1;
            char action = ' ';

            System.out.println();
            System.out.println("Please enter the coordinates of the cell you wish to select, followed by an action.");
            System.out.println("'R' = Reveal cell");
            System.out.println("'F' = Flag/unflag a cell");
            System.out.println("Enter your move (format: x y action), where x and y are the coordinates, and action is either 'R' or 'F':");
            System.out.println();

            try {
                x = scanner.nextInt();
                y = scanner.nextInt();
                action = scanner.next().charAt(0);
            } catch (InputMismatchException e) {
                System.out.println("Error, invalid input. Please enter valid coordinates and a valid action.");
                scanner.nextLine();
                continue;
            }

            if ((x < 0 || x >= board.getSize()) || (y < 0 || y >= board.getSize()) || (action != 'r' && action != 'f')) {
                System.out.println("Invalid input. Please enter valid coordinates and a action.");
                continue;
            }

            board.makeMove(x, y, action);
            checkWin();
        }
    }

    void checkWin() {
        boolean completed = true;
        outerLoop:
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getDisplayBoard()[i][j] == board.getUnrevealed() && board.getBoard()[i][j] != board.getMine()) {
                    completed = false;
                    break outerLoop;
                }
            }
        }
        if (completed) {
            timer.stop();

            board.printBoard(board.getBoard());
            System.out.println();
            System.out.println("Congratulations! You win!");
            timer.displayTime();
            board.setGameOver(true);

            endGameMenu();
        }
    }

    void endGameMenu() {
        char input;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 'A' to return to the menu");
        System.out.println("Enter 'B' to quit");
        System.out.println();

        input = scanner.next().charAt(0);
        input = Character.toLowerCase(input);
        while (input != 'a' && input != 'b') {
            System.out.println("Error, invalid choice.");
            System.out.println("Enter 'A' to return to the menu");
            System.out.println("Enter 'B' to quit");
            input = scanner.next().charAt(0);
            input = Character.toLowerCase(input);
        }

        if (input == 'a') {
            returnToMenu();
        } else if (input == 'b') {
            System.out.println("Thanks for playing. See you next time!");
        }
    }

    void returnToMenu() {
        Menu menu = new Menu();
        menu.mainMenu();
    }
}
